package com.ea.easp;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.ea.InAppWebBrowser.BrowserAndroid;
import com.ea.easp.Debug;
import com.ea.easp.facebook.FacebookAgentJNI;
import com.ea.easp.mtx.market.MarketJNI;

public class EASPHandler {
    private static final String kMODULE_TAG = "EASPHandler";
    public static Activity mActivity;
    public static ViewGroup mViewGroup;
    private MarketJNI mAndroidMarketJNI;
    private FacebookAgentJNI mFacebookAgent;
    private GLSurfaceView mGLSurfaceView;
    private Handler mHandler = new Handler();
    private PhysicalKeyboardAndroid mPhysicalKeyboard;
    private TaskLauncher mTaskLauncher = new TaskLauncher(this.mHandler, this.mGLSurfaceView);

    public EASPHandler(Activity activity, ViewGroup viewGroup, GLSurfaceView gLSurfaceView) {
        mActivity = activity;
        mViewGroup = viewGroup;
        this.mGLSurfaceView = gLSurfaceView;
    }

    public native void initJNI();

    public void onActivityResult(int i, int i2, Intent intent) {
        Debug.Log.i(kMODULE_TAG, "onActivityResult requestCode=" + i + ", resultCode=" + i2);
        this.mFacebookAgent.authorizeCallback(i, i2, intent);
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.mPhysicalKeyboard.onConfigurationChanged(configuration);
    }

    public void onCreate() {
        Debug.Log.d(kMODULE_TAG, "onCreate()...");
        initJNI();
        DeviceInfoUtil.init();
        PackageUtil.init();
        this.mFacebookAgent = new FacebookAgentJNI(mActivity, this.mTaskLauncher);
        this.mFacebookAgent.init();
        BrowserAndroid.Startup(mActivity, mViewGroup);
        this.mAndroidMarketJNI = new MarketJNI(mActivity, this.mTaskLauncher, MarketJNI.StoreType.UNKNOWN);
        this.mAndroidMarketJNI.init();
        this.mPhysicalKeyboard = new PhysicalKeyboardAndroid(this.mTaskLauncher);
        Debug.Log.d(kMODULE_TAG, "...onCreate()");
    }

    public void onDestroy() {
        Debug.Log.d(kMODULE_TAG, "onDestroy()...");
        this.mPhysicalKeyboard = null;
        this.mAndroidMarketJNI.shutdown();
        BrowserAndroid.Shutdown();
        this.mFacebookAgent.shutdown();
        PackageUtil.shutdown();
        DeviceInfoUtil.shutdown();
        shutdownJNI();
        mActivity = null;
        Debug.Log.d(kMODULE_TAG, "...onDestroy()");
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.mPhysicalKeyboard.OnKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return this.mPhysicalKeyboard.OnKeyUp(i, keyEvent);
    }

    public void setLogEnabled(boolean z) {
        Debug.LogEnabled = z;
    }

    public native void shutdownJNI();
}
