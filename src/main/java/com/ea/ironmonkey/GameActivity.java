package com.ea.ironmonkey;

import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.net.Uri;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.PowerManager;
import android.os.Process;
import android.support.v4.view.MotionEventCompat;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;

import com.ea.EAIO.EAIO;
import com.ea.EAMIO.StorageDirectory;
import com.ea.easp.EASPHandler;
import com.ea.games.nfs13_na.BuildConfig;
import com.ea.games.nfs13_na.R;
import com.ea.nimble.ApplicationLifecycle;
import com.eamobile.DownloadActivity;
import com.eamobile.IDeviceData;
import com.eamobile.IDownloadActivity;
import com.eamobile.Language;
import com.eamobile.download.DeviceData;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import me.michael.application.ServerKt;

//TODO А тут тоже может происходить много чего интересного
//TODO убить гугл дрм
public class GameActivity extends Activity implements DrawFrameListener, IDeviceData, IDownloadActivity {

    private final String TAG = "GameActivity";
    private static final String DOWNLOAD_PROPERTIES = "downloadcontent/config.properties";

    public static final int LIFECYCLE_NONE = 0;
    public static final int LIFECYCLE_CREATED = 1;
    public static final int LIFECYCLE_STARTED = 2;
    public static final int LIFECYCLE_RUNNING = 3;
    public static final int LIFECYCLE_STOPPED = 4;
    public static final int LIFECYCLE_DESTROYED = 5;

    private final String[] lifecycleNames = {
            "LIFECYCLE_NONE",
            "LIFECYCLE_CREATED",
            "LIFECYCLE_STARTED",
            "LIFECYCLE_RUNNING",
            "LIFECYCLE_STOPPED",
            "LIFECYCLE_DESTROYED"
    };

    private static String SDCARD_DATA_FOLDER = "";

    public static final int STATE_SPLASH = 0;
    public static final int STATE_SPLASH_PROCESS = 1;
    public static final int STATE_GOOGLE_DRM = 2;
    public static final int STATE_ADC_START = 3;
    public static final int STATE_ADC_PROCESS = 4;
    public static final int STATE_FULL_START = 5;
    public static final int STATE_FULL_PROCESS = 6;
    public static final int STATE_RESTORE_CONTEXT = 7;
    public static final int STATE_GAME_START = 8;

    private int laststate;
    private int lifecycle;
    private static int oldState;
    public static int state = 0;

    public static GameActivity instance;
    private static AudioManager mAudioManager;
    private Accelerometer accelerometer;
    private DownloadActivity downloadActivity = null;
    private EASPHandler easpHandler;
    private GameGLSurfaceView gameGLSurfaceView;
    private SplashScreen splash;
    private GameRenderer gameRenderer;
    private GoogleDrm googleDrm;
    private RunLoop runLoop;
    private Handler handler;

    private static boolean assetsReady = false;
    private static boolean isAmazonDev = false;
    private boolean isXperiaPlay = false;

    private AlertDialog.Builder mAd;
    private FrameLayout mFrameLayout;
    private PowerManager.WakeLock mWakeLock;
    public int naturalOrientation;
    private int splashCounter;
    private long splashDelay;
    private long splashTimer;

    private void ForceHideVirtualKeyboard() {
        View currentFocus = getCurrentFocus();
        if (currentFocus != null) {
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
        getWindow().setSoftInputMode(3);
    }

    public static String GetApplicationVersion() {
       return BuildConfig.VERSION_NAME;
    }

    public static String GetDefaultLanguage() {
        return Locale.getDefault().toString().substring(0, 2);
    }

    public static String GetDeviceName() {
        return Build.MODEL;
    }

    private void getC2DMRegistrationId() {
        Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
        intent.putExtra("app", PendingIntent.getBroadcast(this, 0, new Intent(), 0));
        intent.putExtra("sender", C2DMConstants.SENDER_EMAIL);
        startService(intent);
    }

    public static String getOsVersion() {
        return Build.VERSION.RELEASE;
    }

    private void setLifecycle(int i) {
        if (i != this.lifecycle) {
            Log.i(TAG, this.lifecycleNames[this.lifecycle] + " -> " + this.lifecycleNames[i]);
            this.lifecycle = i;
        }
    }

    @SuppressLint("InvalidWakeLockTag")
    private void wakeLockAcquire() {
        if (this.mWakeLock == null) {
            this.mWakeLock = ((PowerManager) getSystemService(Context.POWER_SERVICE)).newWakeLock(10, TAG);
        }
        if (!this.mWakeLock.isHeld()) {
            try {
                this.mWakeLock.acquire();
            } catch (SecurityException e) {
                Log.w(TAG, "Missing WAKE_LOCK permission.");
            }
        }
    }

    private void wakeLockRelease() {
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (SecurityException e) {
            Log.w(TAG, "Missing WAKE_LOCK permission.");
        }
    }

    public void CallGC() {
        Log.d(TAG, "Call garbage collector");
        System.gc();
    }

    public int GetNaturalOrientation() {
        Display defaultDisplay = getWindow().getWindowManager().getDefaultDisplay();
        int i = 0;
        int i2 = 0;
        switch (defaultDisplay.getRotation()) {
            case 0:
            case 2:
                i = defaultDisplay.getWidth();
                i2 = defaultDisplay.getHeight();
                break;
            case 1:
            case 3:
                i = defaultDisplay.getHeight();
                i2 = defaultDisplay.getWidth();
                break;
        }
        if (i > i2) {
            Log.d(TAG, "NaturalOrientation = LANDSCAPE");
            return 0;
        }
        Log.d(TAG, "NaturalOrientation = PORTRAIT");
        return 1;
    }

    public ViewParent GetViewRoot() {
        return getWindow().getDecorView().getRootView().getParent();
    }

    public boolean IsSystemKey(int i) {

        switch (i) {
            case Language.SPACE_UNAVAIL_TITLE:
            case Language.BTN_DOWNLOAD:
            case Language.BTN_EXIT:
            case Language.NETWORK_WARNING_TXT:
            case Language.UPDATES_FOUND_TITLE:
            case Language.UPDATES_FOUND_TXT:
            case Language.UNSUPPORTED_DEVICE_TITLE:
            case 91:
                return false;
            default:
                return true;
        }
    }

    public void ShowMessage(String message, String[] strArr, final boolean finish) {

        Log.d(TAG, "ShowMessage msg = " + message + " finish = " + finish);

        this.mAd = new AlertDialog.Builder(this);
        this.mAd.setMessage(message);
        this.mAd.setCancelable(false);
        this.mAd.setPositiveButton(strArr[0], new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (finish) {
                    GameActivity.this.finish();
                }
            }
        });
        this.handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                GameActivity.this.mAd.show();
            }
        }, 20);
    }

    public float calcPerformanceScore(float f, int i, int i2, int i3) {
        Log.i(TAG, "calcPerformanceScore(" + f + ", " + i + ", " + i2 + ", " + i3 + ")");
        float f2 = BitmapDescriptorFactory.HUE_RED + (0.001f * f * 3.0f);
        if (i > 1) {
            f2 += 0.001f * f * ((float) (Math.min(i, 4) - 1)) * 0.5f;
        }
        float sqrt = (float) (((double) BitmapDescriptorFactory.HUE_RED) + (Math.sqrt((double) (i2 * i3)) * 0.0010000000474974513d * 0.5d));
        try {
            Log.i(TAG, new BufferedReader(new FileReader(new File("/proc/cpuinfo"))).readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.i(TAG, Build.MODEL);
        return ((1.0f + f2) / (1.0f + sqrt)) * 0.33333334f;
    }

    public Accelerometer getAccelerometer() {
        return this.accelerometer;
    }

    public DisplayMetrics getDisplayMetrics() {
        return getResources().getDisplayMetrics();
    }

    public GameGLSurfaceView getGameGLSurfaceView() {
        return this.gameGLSurfaceView;
    }

    public float getPerformanceScore() {
        float f = BitmapDescriptorFactory.HUE_RED;
        int i = 0;
        String readCpuFile = readCpuFile("present");
        if (readCpuFile.length() > 0) {
            List<Integer> parseCpuList = parseCpuList(readCpuFile);
            Iterator<Integer> it = parseCpuList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String readCpuFile2 = readCpuFile(String.format("cpu%d/cpufreq/cpuinfo_max_freq", Integer.valueOf(it.next().intValue())));
                if (readCpuFile2.length() > 0) {
                    try {
                        f = ((float) Integer.parseInt(readCpuFile2)) * 0.001f;
                        break;
                    } catch (NumberFormatException e) {
                    }
                }
            }
            i = parseCpuList.size();
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return calcPerformanceScore(f, i, displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    public RunLoop getRunLoop() {
        return this.runLoop;
    }

    public int getTotalMemory() {
        int i = 0;
        File file = new File("/proc/meminfo");
        if (file.exists()) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    Log.d("mem", readLine);
                    String[] split = readLine.split(":");
                    Log.d("mem", split[0]);
                    Log.d("mem", split[1]);
                    if (split[0].trim().toLowerCase().equals("memtotal")) {
                        String[] split2 = split[1].trim().split(" ");
                        Log.d("mem", split2[0]);
                        try {
                            i = Integer.parseInt(split2[0].trim()) / 1024;
                            break;
                        } catch (NumberFormatException e) {
                            Log.d("mem", e.toString());
                        }
                    }
                }
                bufferedReader.close();
            } catch (Exception e2) {
                Log.e(TAG, String.format("Error reading system file: %s (%s)", file.getAbsolutePath(), e2.getMessage()));
            }
        }
        Log.d("mem", "totalmemory=" + i);
        return i;
    }

    public void installWallpaper() {
        Intent intent = new Intent("android.intent.action.VIEW");
        AssetFileDescriptor assetFileDescriptor = null;
        FileChannel fileChannel = null;
        FileChannel fileChannel2 = null;
        String str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/published/wallpaper/";
        try {
            new File(str).mkdirs();
            assetFileDescriptor = getResources().openRawResourceFd(R.raw.wallpaper);
            File file = new File(str, "wallpaper.apk");
            file.createNewFile();
            fileChannel = assetFileDescriptor.createInputStream().getChannel();
            fileChannel2 = new FileOutputStream(file).getChannel();
            fileChannel2.transferFrom(fileChannel, 0, assetFileDescriptor.getLength());
            try {
                fileChannel.close();
                fileChannel2.close();
            } catch (Exception e) {
                Log.e(TAG, e.toString());
            }
            assetFileDescriptor.close();

        } catch (IOException e2) {
            if (fileChannel2 != null) {
                try {
                    fileChannel2.close();
                    fileChannel.close();
                    assetFileDescriptor.close();
                } catch (IOException e3) {
                    intent.setDataAndType(Uri.fromFile(new File(str + "wallpaper.apk")), "application/vnd.android.package-archive");
                    startActivity(intent);
                }
            }
        }
        intent.setDataAndType(Uri.fromFile(new File(str + "wallpaper.apk")), "application/vnd.android.package-archive");
        startActivity(intent);
    }

    public boolean isAssetsReady() {
        return assetsReady;
    }

    public native void nativeOnCreate();

    public native void nativeOnDestroy();

    public native void nativeOnPause();

    public native void nativeOnPhysicalKeyDown(int i, int i2);

    public native void nativeOnPhysicalKeyUp(int i, int i2);

    public native void nativeOnPhysicalKeyboardVisibilityChanged(boolean z);

    public native void nativeOnPhysicalNavigationVisibilityChanged(boolean z);

    public native void nativeOnRestart();

    public native void nativeOnResume();

    public native void nativeOnStart();

    public native void nativeOnStop();

    public native boolean nativeRestoreContext();

    public native void nativeSurfaceChanged(GL10 gl10, int i, int i2);

    public native void nativeSurfaceCreated(GL10 gl10, EGLConfig eGLConfig);

    public boolean needInstallWallpaper() {
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.easpHandler.onActivityResult(i, i2, intent);
        ApplicationLifecycle.onActivityResult(i, i2, intent, this);
    }

    public void onBackPressed() {
        if (state == 1 || state == 0 || state == 7) {
            finish();
        }
        ApplicationLifecycle.onBackPressed();
    }

    public void onConfigurationChanged(Configuration configuration) {
        Log.d(TAG, "onConfigurationChanged(" + configuration.toString() + ")");
        super.onConfigurationChanged(configuration);
        if (this.isXperiaPlay) {
            switch (configuration.navigationHidden) {
                case 1:
                    nativeOnPhysicalNavigationVisibilityChanged(true);
                    return;
                case 2:
                    nativeOnPhysicalNavigationVisibilityChanged(false);
                    return;
                default:
            }
        }
    }

    @Override
    public void onCreate(Bundle bundle) {
        Log.setEnable(true);
        Log.i(TAG, "onCreate");
        Log.i(TAG, "GameActivity.state = " + state);
        super.onCreate(bundle);
        instance = this;
        if (this.lifecycle == LIFECYCLE_DESTROYED) {
            Log.w(TAG, "onCreate called on destroyed app, finishing");
            finish();
        } else if (this.lifecycle >= LIFECYCLE_CREATED) {
            Log.w(TAG, "onCreate ignored, lifecycle is already " + this.lifecycleNames[this.lifecycle]);
        } else {
            this.handler = new Handler();
            setLifecycle(1);
            getWindow().setFlags(1024, 1024);
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            requestWindowFeature(1);
            Log.d("Model", Build.MODEL);
            mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
            SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
            Sensor defaultSensor = sensorManager.getDefaultSensor(1);

            int rotation = getWindow().getWindowManager().getDefaultDisplay().getRotation();
            switch (rotation) {
                case 0:
                    Log.d(TAG, "Orientation: ROTATION_0");
                    break;
                case 1:
                    Log.d(TAG, "Orientation: ROTATION_90");
                    break;
                case 2:
                    Log.d(TAG, "Orientation: ROTATION_180");
                    break;
                case 3:
                    Log.d(TAG, "Orientation: ROTATION_270");
                    break;
            }
            if (defaultSensor != null) {
                this.accelerometer = new Accelerometer(sensorManager, defaultSensor, rotation);
            }
            this.gameGLSurfaceView = new GameGLSurfaceView(this);
            this.gameRenderer = new GameRenderer(this);
            this.gameRenderer.setDrawFrameListener(this);
            this.gameGLSurfaceView.setRenderer(this.gameRenderer);
            this.runLoop = new RunLoop(this.gameGLSurfaceView);
            this.mFrameLayout = new FrameLayout(this);
            this.mFrameLayout.addView(this.gameGLSurfaceView);
            setContentView(this.mFrameLayout);
            //this.googleDrm = new GoogleDrm(this);
            System.loadLibrary("nimble");
            System.loadLibrary("app");
            Log.d(TAG, "Init EAIO/EAMIO");
            EAIO.Startup(this);
            StorageDirectory.Startup(this);
            if (this.easpHandler == null) {
                Log.d(TAG, "Init EASPHandler");
                this.easpHandler = new EASPHandler(this, this.mFrameLayout, this.gameGLSurfaceView);
                this.easpHandler.onCreate();
            }
            ApplicationLifecycle.onActivityCreate(bundle, this);
            Log.d(TAG, "nativeOnCreate");
            nativeOnCreate();
        }
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy");
        super.onDestroy();
        if (this.lifecycle >= 5) {
            Log.w(TAG, "onDestroy ignored, lifecycle is already " + this.lifecycleNames[this.lifecycle]);
            return;
        }
        setLifecycle(5);
        if (this.googleDrm.isEnable()) {
            this.googleDrm.destroy();
        }
        this.easpHandler.onDestroy();
        if (state == 8) {
            ApplicationLifecycle.onActivityDestroy(this);
            nativeOnDestroy();
        }
        StorageDirectory.Shutdown();
        EAIO.Shutdown();
        System.exit(0);
    }

    @Override // com.eamobile.IDownloadActivity
    public void onDownloadEvent(int i) {
        String str = getApplicationInfo().dataDir + "/files/var1/adcEvents";
        long currentTimeMillis = System.currentTimeMillis();
        Log.i(TAG, "GetADCTelemetry: eventId= " + i + " eventTime=" + currentTimeMillis + " fileName=" + str);
        byte[] bArr = {(byte) ((i >> 24) & MotionEventCompat.ACTION_MASK), (byte) ((i >> 16) & MotionEventCompat.ACTION_MASK), (byte) ((i >> 8) & MotionEventCompat.ACTION_MASK), (byte) (i & MotionEventCompat.ACTION_MASK), (byte) ((int) ((currentTimeMillis >> 56) & 255)), (byte) ((int) ((currentTimeMillis >> 48) & 255)), (byte) ((int) ((currentTimeMillis >> 40) & 255)), (byte) ((int) ((currentTimeMillis >> 32) & 255)), (byte) ((int) ((currentTimeMillis >> 24) & 255)), (byte) ((int) ((currentTimeMillis >> 16) & 255)), (byte) ((int) ((currentTimeMillis >> 8) & 255)), (byte) ((int) (255 & currentTimeMillis))};
        Log.i(TAG, "Write adcEvents file");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(str), true);
            fileOutputStream.write(bArr, 0, 12);
            fileOutputStream.close();
        } catch (Exception e) {
            Log.i(TAG, "Can't save adcEvents file");
        }
    }


    @Override // com.ea.ironmonkey.DrawFrameListener
    public void onDrawFrame(GL10 gl10) {
        Log.i("state", "state = " + state);
        if (state != this.laststate) {
            Log.d(TAG, "onDrawFrame state=" + state);
            this.laststate = state;
        }
        boolean z = false;
        switch (state) {
            case STATE_SPLASH: {
                this.splash = new SplashScreen(this);
                this.splash.init(gl10, this.gameRenderer.getWidth(), this.gameRenderer.getHeight());
                if (this.googleDrm.isEnable()) {
                    if (AccountManager.get(this).getAccountsByType(GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE).length > 0) {
                        this.handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                GameActivity.this.googleDrm.start();
                            }
                        }, 20);
                    } else {
                        Log.e(TAG, "No Google account!!!!");
                        this.handler.post(new Runnable() {
                            /* class com.ea.ironmonkey.GameActivity.AnonymousClass6 */

                            public void run() {
                                new AlertDialog.Builder(GameActivity.instance)
                                        .setTitle("NFS MW")
                                        .setMessage("This application is not authorized for use on your Android device.")
                                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {


                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                GameActivity.this.finish();
                                                Process.killProcess(Process.myPid());
                                            }
                                        }).setIcon(R.drawable.icon).show();
                            }
                        });
                    }
                    state = 2;
                } else {
                    state = 1;
                }
                this.splashCounter = 3;
            }break;
            case STATE_SPLASH_PROCESS: {
                if (this.splashCounter <= 0) {
                    this.splashTimer = System.currentTimeMillis() + 2500;
                    if (assetsReady) {
                        Log.i(TAG, "STATE_GAME_START 2");
                        state = 8;
                    } else {
                        InputStream inputStream = null;
                        try {
                            inputStream = getAssets().open(DOWNLOAD_PROPERTIES);
                            inputStream.close();
                        } catch (Exception e) {
                        }
                        if (inputStream == null) {
                            Log.i(TAG, "STATE_GAME_START 1");
                            state = 8;
                        } else {
                            this.handler.postDelayed(new Runnable() {
                                /* class com.ea.ironmonkey.GameActivity.AnonymousClass7 */

                                public void run() {
                                    GameActivity.this.downloadActivity = new DownloadActivity(GameActivity.instance);
                                }
                            }, 20);
                            Log.i(TAG, "state ADC start");
                            state = 3;
                        }
                    }
                } else {
                    this.splashCounter--;
                }
            } break;
            case STATE_ADC_START: {
                Log.i(TAG, "ADC start");
                if (this.downloadActivity != null) {
                    Log.i(TAG, "ADC init");
                    this.downloadActivity.init(this, this, this, gl10);
                    state = 4;
                    break;
                }
            }break;
            case STATE_RESTORE_CONTEXT: {
                if (this.splash == null) {
                    this.splash = new SplashScreen(this);
                    this.splash.init(gl10, this.gameRenderer.getWidth(), this.gameRenderer.getHeight());
                    this.splashDelay = System.currentTimeMillis() + 2000;
                }
                if (this.splashDelay < System.currentTimeMillis() && hasWindowFocus()) {
                    if (oldState != 8) {
                        state = oldState;
                    } else {
                        this.splashTimer = System.currentTimeMillis() + 300;
                        state = 8;
                    }
                    break;
                }
            }
            case STATE_GAME_START: {
                if (this.splashTimer < System.currentTimeMillis() && nativeRestoreContext()) {
                    assetsReady = true;
                    nativeOnStart();
                    nativeOnResume();
                    //drawRectangle(gl10, 0, 0, 100, 100, 100, 100, 4, 100);
                    this.gameRenderer.setDrawFrameListener(null);
                    z = true;
                    break;
                }
            }
        }
        GLES20.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        GLES20.glClear(16640);
        if (this.splash != null) {
            this.splash.draw(gl10, this.gameRenderer.getWidth(), this.gameRenderer.getHeight());
        }
        if (z && this.splash != null) {
            this.splash.destroy(gl10);
            this.splash = null;
        }
    }

    public boolean onKeyDown(final int i, KeyEvent keyEvent) {
        super.onKeyDown(i, keyEvent);
        if (state != 8) {
            return true;
        }
        if ((i == 4 || i == 108) && keyEvent.getRepeatCount() > 0) {
            return true;
        }
        final int scanCode = keyEvent.getScanCode();
        this.gameGLSurfaceView.queueEvent(new Runnable() {
            /* class com.ea.ironmonkey.GameActivity.AnonymousClass1 */

            public void run() {
                GameActivity.this.nativeOnPhysicalKeyDown(i, scanCode);
            }
        });
        return IsSystemKey(i);
    }

    public boolean onKeyUp(final int i, KeyEvent keyEvent) {
        super.onKeyUp(i, keyEvent);
        if (state != 8) {
            return true;
        }
        final int scanCode = keyEvent.getScanCode();
        this.gameGLSurfaceView.queueEvent(new Runnable() {
            /* class com.ea.ironmonkey.GameActivity.AnonymousClass2 */

            public void run() {
                GameActivity.this.nativeOnPhysicalKeyUp(i, scanCode);
            }
        });
        return IsSystemKey(i);
    }

    public void onLowMemory() {
        ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        Log.i(TAG, "Available memory: " + ((memoryInfo.availMem / 1024) / 1024) + "MB\n");
        Log.i(TAG, "Threshold: " + ((memoryInfo.threshold / 1024) / 1024) + "MB\n");
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.processName.contains("nfs13")) {
                Log.i(TAG, "Total memory: " + (activityManager.getProcessMemoryInfo(new int[]{runningAppProcessInfo.pid})[0].getTotalPss() / 1024) + "MB\n");
            }
        }
        super.onLowMemory();
    }

    public void onPause() {
        Log.i(TAG, "onPause state=" + state);
        super.onPause();
        if (!isAmazonDev) {
            mAudioManager.setStreamMute(3, true);
        }
        if (this.lifecycle != 3) {
            Log.w(TAG, "onPause ignored, lifecycle is currently " + this.lifecycleNames[this.lifecycle]);
            return;
        }
        setLifecycle(2);
        this.gameGLSurfaceView.onPause();
        if (this.downloadActivity != null) {
            this.downloadActivity.onPause();
        }
        ApplicationLifecycle.onActivityPause(this);
        nativeOnPause();
        this.splash = null;
    }

    public void onRestart() {
        Log.i(TAG, "onRestart");
        Log.i(TAG, "TouchEvent, GameActivity.state = " + state);
        super.onRestart();
        ApplicationLifecycle.onActivityRestart(this);
        nativeOnRestart();
    }

    @Override // com.eamobile.IDownloadActivity
    public void onResult(String str, int i) {
        Log.w(TAG, "onResult(" + str + "," + i + ")");
        if (i != -1) {
            finish();
            Process.killProcess(Process.myPid());
        } else if (str.equals("GOOGL_DRM")) {
            state = 1;
        } else {
            File file = new File(new File(str).getParent() + "/.nomedia");
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (Exception e) {
                }
            }
            if (this.downloadActivity != null) {
                this.downloadActivity.destroyDownloadActvity();
                this.downloadActivity = null;
            }
            this.handler.postDelayed(new Runnable() {
                /* class com.ea.ironmonkey.GameActivity.AnonymousClass8 */

                public void run() {
                    GameActivity.this.setContentView(GameActivity.this.gameGLSurfaceView);
                }
            }, 20);
            if (hasWindowFocus()) {
                state = 8;
                return;
            }
            oldState = 8;
            state = 8;
        }
    }

    public void onResume() {
        Log.i(TAG, "onResume");
        Log.i("check", "GameActivity.state = " + state);
        super.onResume();
        if (state != 7) {
            oldState = state;
            state = 8;
            this.gameRenderer.setDrawFrameListener(this);
        }
        if (!isAmazonDev) {
            if (mAudioManager.requestAudioFocus(null, 3, 1) == 0) {
                Log.e(TAG, "requestAudioFocus failed");
            }
            mAudioManager.setStreamSolo(3, true);
            mAudioManager.setStreamMute(3, false);
        }
        if (this.lifecycle == 3) {
            Log.w(TAG, "onResume ignored, lifecycle is currently " + this.lifecycleNames[this.lifecycle]);
            return;
        }
        setLifecycle(3);
        this.gameGLSurfaceView.onResume();
        ApplicationLifecycle.onActivityResume(this);
        nativeOnResume();
        if (this.downloadActivity != null) {
            this.downloadActivity.onResume();
        }
    }

    @Override // com.eamobile.IDeviceData
    public void onRetrievedDeviceData(DeviceData deviceData) {
        deviceData.setResolution(480, 800);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        ApplicationLifecycle.onActivitySaveInstanceState(bundle, this);
    }

    public void onStart() {
        System.gc();
        Log.i(TAG, "onStart");
        super.onStart();
        Log.i(TAG, "onStart 1");
        wakeLockAcquire();
        Log.i(TAG, "onStart 2");
        if (this.lifecycle < 2 || this.lifecycle >= 4) {
            Log.i(TAG, "onStart 3");
            setLifecycle(2);
            Log.i(TAG, "nativeOnStart");
            nativeOnStart();
            Log.i(TAG, "nativeOnStart - end");
            if (this.isXperiaPlay) {
                switch (getResources().getConfiguration().navigationHidden) {
                    case 1:
                        nativeOnPhysicalNavigationVisibilityChanged(true);
                        break;
                    case 2:
                        nativeOnPhysicalNavigationVisibilityChanged(false);
                        break;
                }
            }
            Log.i(TAG, "ApplicationLifecycle");
            ApplicationLifecycle.onActivityStart(this);
            return;
        }
        Log.w(TAG, "onStart ignored, lifecycle is already " + this.lifecycleNames[this.lifecycle]);
    }

    public void onStop() {
        Log.i(TAG, "onStop");
        super.onStop();
        if (this.lifecycle >= 4) {
            Log.w(TAG, "onStop ignored, lifecycle is already " + this.lifecycleNames[this.lifecycle]);
            return;
        }
        setLifecycle(4);
        wakeLockRelease();
        nativeOnStop();
        if (!isAmazonDev) {
            mAudioManager.setStreamMute(3, false);
            mAudioManager.setStreamMute(3, false);
            mAudioManager.setStreamSolo(3, false);
            if (mAudioManager.abandonAudioFocus(null) == 0) {
                Log.e(TAG, "abandonAudioFocus failed");
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        Log.i(TAG, "onWindowsFocusChanged(" + z + ") state=" + state);
        if (this.downloadActivity != null) {
            this.downloadActivity.onWindowFocusChanged(z);
        }
        if (!z) {
            ForceHideVirtualKeyboard();
            nativeOnPhysicalKeyDown(131, 0);
            nativeOnPhysicalKeyUp(131, 0);
            if (state == 8 && !isAmazonDev) {
                mAudioManager.setStreamMute(3, true);
                oldState = state;
                state = 7;
                this.gameRenderer.setDrawFrameListener(this);
            }
        }
        if (z && !isAmazonDev) {
            mAudioManager.setStreamMute(3, false);
        }
        ApplicationLifecycle.onActivityWindowFocusChanged(z, this);
    }

    public void openURL(String str) {
        Log.d("OpenURL", str);
        try {
            Bundle bundle = new Bundle();
            bundle.putString("URL", str);
            Intent intent = new Intent(this, WebActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void openURLinBrowser(String str) {
        Log.d("OpenURLinBrowser", str);
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Integer> parseCpuList(String str) {
        ArrayList arrayList = new ArrayList();
        String[] split = str.split(",");
        for (String str2 : split) {
            if (str2.contains("-")) {
                String[] split2 = str2.split("-");
                if (split2.length >= 2) {
                    try {
                        int parseInt = Integer.parseInt(split2[0]);
                        int parseInt2 = Integer.parseInt(split2[1]);
                        for (int i = parseInt; i <= parseInt2; i++) {
                            arrayList.add(i);
                        }
                    } catch (NumberFormatException e) {
                    }
                }
            } else {
                try {
                    arrayList.add(Integer.parseInt(str2));
                } catch (NumberFormatException e2) {
                }
            }
        }
        return arrayList;
    }

    public String readCpuFile(String str) {
        File file = new File("/sys/devices/system/cpu", str);
        if (file.exists()) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                return readLine;
            } catch (Exception e) {
                Log.e(TAG, String.format("Error reading system file: %s (%s)", file.getAbsolutePath(), e.getMessage()));
            }
        }
        return "";
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        Log.d(TAG, "setContentView(" + view + ")");
        if (view == null) {
            return;
        }
        if (view == this.mFrameLayout) {
            super.setContentView(view);
            return;
        }
        int childCount = this.mFrameLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mFrameLayout.getChildAt(i);
            if (childAt != this.gameGLSurfaceView) {
                this.mFrameLayout.removeView(childAt);
            }
        }
        if (view != this.gameGLSurfaceView) {
            this.mFrameLayout.addView(view);
        }
        this.mFrameLayout.bringChildToFront(view);
    }
}
