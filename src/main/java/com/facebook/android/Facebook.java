/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ActivityNotFoundException
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.IBinder
 *  android.os.Message
 *  android.os.Messenger
 *  android.os.RemoteException
 *  android.text.TextUtils
 *  android.webkit.CookieSyncManager
 *  com.ea.easp.Debug$Log
 */
package com.facebook.android;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import com.ea.easp.Debug;
import com.facebook.android.DialogError;
import com.facebook.android.FacebookError;
import com.facebook.android.FbDialog;
import com.facebook.android.Util;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

public class Facebook {
    public static final String CANCEL_URI = "fbconnect://cancel";
    private static final int DEFAULT_AUTH_ACTIVITY_CODE = 32665;
    protected static String DIALOG_BASE_URL = "https://m.facebook.com/dialog/";
    public static final String EXPIRES = "expires_in";
    public static final String FB_APP_SIGNATURE = "30820268308201d102044a9c4610300d06092a864886f70d0101040500307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e3020170d3039303833313231353231365a180f32303530303932353231353231365a307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e30819f300d06092a864886f70d010101050003818d0030818902818100c207d51df8eb8c97d93ba0c8c1002c928fab00dc1b42fca5e66e99cc3023ed2d214d822bc59e8e35ddcf5f44c7ae8ade50d7e0c434f500e6c131f4a2834f987fc46406115de2018ebbb0d5a3c261bd97581ccfef76afc7135a6d59e8855ecd7eacc8f8737e794c60a761c536b72b11fac8e603f5da1a2d54aa103b8a13c0dbc10203010001300d06092a864886f70d0101040500038181005ee9be8bcbb250648d3b741290a82a1c9dc2e76a0af2f2228f1d9f9c4007529c446a70175c5a900d5141812866db46be6559e2141616483998211f4a673149fb2232a10d247663b26a9031e15f84bc1c74d141ff98a02d76f85b2c8ab2571b6469b232d8e768a7f7ca04f7abe4a775615916c07940656b58717457b42bd928a2";
    public static final int FORCE_DIALOG_AUTH = -1;
    protected static String GRAPH_BASE_URL = "https://graph.facebook.com/";
    private static final String LOGIN = "oauth";
    public static final String REDIRECT_URI = "fbconnect://success";
    protected static String RESTSERVER_URL = "https://api.facebook.com/restserver.php";
    public static final String SINGLE_SIGN_ON_DISABLED = "service_disabled";
    public static final String TOKEN = "access_token";
    private final long REFRESH_TOKEN_BARRIER;
    private long mAccessExpires = 0L;
    private String mAccessToken = null;
    private String mAppId;
    private Activity mAuthActivity;
    private int mAuthActivityCode;
    private DialogListener mAuthDialogListener;
    private String[] mAuthPermissions;
    private long mLastAccessUpdate = 0L;

    public Facebook(String string) {
        this.REFRESH_TOKEN_BARRIER = 86400000L;
        if (string == null) {
            throw new IllegalArgumentException("You must specify your application ID when instantiating a Facebook object. See README for details.");
        }
        this.mAppId = string;
    }

    private void startDialogAuth(Activity activity, String[] stringArray) {
        Bundle bundle = new Bundle();
        if (stringArray.length > 0) {
            bundle.putString("scope", TextUtils.join((CharSequence)",", (Object[])stringArray));
        }
        CookieSyncManager.createInstance((Context)activity);
        this.dialog((Context)activity, LOGIN, bundle, new DialogListener(){

            @Override
            public void onCancel() {
                Debug.Log.d((String)"Facebook-authorize", (String)"Login canceled");
                Facebook.this.mAuthDialogListener.onCancel();
            }

            @Override
            public void onComplete(Bundle bundle) {
                CookieSyncManager.getInstance().sync();
                Facebook.this.setAccessToken(bundle.getString(Facebook.TOKEN));
                Facebook.this.setAccessExpiresIn(bundle.getString(Facebook.EXPIRES));
                if (Facebook.this.isSessionValid()) {
                    Debug.Log.d((String)"Facebook-authorize", (String)("Login Success! access_token=" + Facebook.this.getAccessToken() + " expires=" + Facebook.this.getAccessExpires()));
                    Facebook.this.mAuthDialogListener.onComplete(bundle);
                    return;
                }
                Facebook.this.mAuthDialogListener.onFacebookError(new FacebookError("Failed to receive access token."));
            }

            @Override
            public void onError(DialogError dialogError) {
                Debug.Log.d((String)"Facebook-authorize", (String)("Login failed: " + dialogError));
                Facebook.this.mAuthDialogListener.onError(dialogError);
            }

            @Override
            public void onFacebookError(FacebookError facebookError) {
                Debug.Log.d((String)"Facebook-authorize", (String)("Login failed: " + facebookError));
                Facebook.this.mAuthDialogListener.onFacebookError(facebookError);
            }
        });
    }

    private boolean startSingleSignOn(Activity activity, String string, String[] stringArray, int n2) {
        boolean bl2 = true;
        Intent intent = new Intent();
        intent.setClassName("com.facebook.katana", "com.facebook.katana.ProxyAuth");
        intent.putExtra("client_id", string);
        if (stringArray.length > 0) {
            intent.putExtra("scope", TextUtils.join((CharSequence)",", (Object[])stringArray));
        }
        if (!this.validateActivityIntent((Context)activity, intent)) {
            return false;
        }
        this.mAuthActivity = activity;
        this.mAuthPermissions = stringArray;
        this.mAuthActivityCode = n2;
        try {
            activity.startActivityForResult(intent, n2);
            return bl2;
        }
        catch (ActivityNotFoundException activityNotFoundException) {
            return false;
        }
    }

    private boolean validateActivityIntent(Context context, Intent intent) {
        intent = context.getPackageManager().resolveActivity(intent, 0);
        if (intent != null) return this.validateAppSignatureForPackage(context, intent.activityInfo.packageName);
        return false;
    }

    private boolean validateAppSignatureForPackage(Context signatureArray, String string) {
        boolean bl2 = false;
        try {
            signatureArray = signatureArray.getPackageManager().getPackageInfo(string, 64);
            signatureArray = signatureArray.signatures;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            return false;
        }
        int n2 = signatureArray.length;
        int n3 = 0;
        while (true) {
            boolean bl3 = bl2;
            if (n3 >= n2) return bl3;
            if (signatureArray[n3].toCharsString().equals(FB_APP_SIGNATURE)) {
                return true;
            }
            ++n3;
        }
    }

    private boolean validateServiceIntent(Context context, Intent intent) {
        intent = context.getPackageManager().resolveService(intent, 0);
        if (intent != null) return this.validateAppSignatureForPackage(context, intent.serviceInfo.packageName);
        return false;
    }

    public void authorize(Activity activity, DialogListener dialogListener) {
        this.authorize(activity, new String[0], 32665, dialogListener);
    }

    public void authorize(Activity activity, String[] stringArray, int n2, DialogListener dialogListener) {
        boolean bl2 = false;
        this.mAuthDialogListener = dialogListener;
        if (n2 >= 0) {
            bl2 = this.startSingleSignOn(activity, this.mAppId, stringArray, n2);
        }
        if (bl2) return;
        this.startDialogAuth(activity, stringArray);
    }

    public void authorize(Activity activity, String[] stringArray, DialogListener dialogListener) {
        this.authorize(activity, stringArray, 32665, dialogListener);
    }

    public void authorizeCallback(int n2, int n3, Intent object) {
        if (n2 != this.mAuthActivityCode) return;
        if (n3 == -1) {
            String string;
            String string2 = string = object.getStringExtra("error");
            if (string == null) {
                string2 = object.getStringExtra("error_type");
            }
            if (string2 != null) {
                if (string2.equals(SINGLE_SIGN_ON_DISABLED) || string2.equals("AndroidAuthKillSwitchException")) {
                    Debug.Log.d((String)"Facebook-authorize", (String)"Hosted auth currently disabled. Retrying dialog auth...");
                    this.startDialogAuth(this.mAuthActivity, this.mAuthPermissions);
                    return;
                }
                if (string2.equals("access_denied") || string2.equals("OAuthAccessDeniedException")) {
                    Debug.Log.d((String)"Facebook-authorize", (String)"Login canceled by user.");
                    this.mAuthDialogListener.onCancel();
                    return;
                }
                string = object.getStringExtra("error_description");
                object = string2;
                if (string != null) {
                    object = string2 + ":" + string;
                }
                Debug.Log.d((String)"Facebook-authorize", (String)("Login failed: " + (String)object));
                this.mAuthDialogListener.onFacebookError(new FacebookError((String)object));
                return;
            }
            this.setAccessToken(object.getStringExtra(TOKEN));
            this.setAccessExpiresIn(object.getStringExtra(EXPIRES));
            if (this.isSessionValid()) {
                Debug.Log.d((String)"Facebook-authorize", (String)("Login Success! access_token=" + this.getAccessToken() + " expires=" + this.getAccessExpires()));
                this.mAuthDialogListener.onComplete(object.getExtras());
                return;
            }
            this.mAuthDialogListener.onFacebookError(new FacebookError("Failed to receive access token."));
            return;
        }
        if (n3 != 0) return;
        if (object != null) {
            Debug.Log.d((String)"Facebook-authorize", (String)("Login failed: " + object.getStringExtra("error")));
            this.mAuthDialogListener.onError(new DialogError(object.getStringExtra("error"), object.getIntExtra("error_code", -1), object.getStringExtra("failing_url")));
            return;
        }
        Debug.Log.d((String)"Facebook-authorize", (String)"Login canceled by user.");
        this.mAuthDialogListener.onCancel();
    }

    public void dialog(Context context, String string, Bundle bundle, DialogListener dialogListener) {
        String string2 = DIALOG_BASE_URL + string;
        bundle.putString("display", "touch");
        bundle.putString("redirect_uri", REDIRECT_URI);
        if (string.equals(LOGIN)) {
            bundle.putString("type", "user_agent");
            bundle.putString("client_id", this.mAppId);
        } else {
            bundle.putString("app_id", this.mAppId);
        }
        if (this.isSessionValid()) {
            bundle.putString(TOKEN, this.getAccessToken());
        }
        string = string2 + "?" + Util.encodeUrl(bundle);
        if (context.checkCallingOrSelfPermission("android.permission.INTERNET") != 0) {
            Util.showAlert(context, "Error", "Application requires permission to access the Internet");
            return;
        }
        new FbDialog(context, string, dialogListener).show();
    }

    public void dialog(Context context, String string, DialogListener dialogListener) {
        this.dialog(context, string, new Bundle(), dialogListener);
    }

    public boolean extendAccessToken(Context context, ServiceListener serviceListener) {
        Intent intent = new Intent();
        intent.setClassName("com.facebook.katana", "com.facebook.katana.platform.TokenRefreshService");
        if (this.validateServiceIntent(context, intent)) return context.bindService(intent, (ServiceConnection)new TokenRefreshServiceConnection(context, serviceListener), 1);
        return false;
    }

    public boolean extendAccessTokenIfNeeded(Context context, ServiceListener serviceListener) {
        if (!this.shouldExtendAccessToken()) return true;
        return this.extendAccessToken(context, serviceListener);
    }

    public long getAccessExpires() {
        return this.mAccessExpires;
    }

    public String getAccessToken() {
        return this.mAccessToken;
    }

    public String getAppId() {
        return this.mAppId;
    }

    public boolean isSessionValid() {
        if (this.getAccessToken() == null) return false;
        if (this.getAccessExpires() == 0L) return true;
        if (System.currentTimeMillis() >= this.getAccessExpires()) return false;
        return true;
    }

    public String logout(Context object) throws MalformedURLException, IOException {
        Util.clearCookies(object);
        object = new Bundle();
        object.putString("method", "auth.expireSession");
        object = this.request((Bundle)object);
        this.setAccessToken(null);
        this.setAccessExpires(0L);
        return object;
    }

    public String request(Bundle bundle) throws MalformedURLException, IOException {
        if (bundle.containsKey("method")) return this.request(null, bundle, "GET");
        throw new IllegalArgumentException("API method must be specified. (parameters must contain key \"method\" and value). See http://developers.facebook.com/docs/reference/rest/");
    }

    public String request(String string) throws MalformedURLException, IOException {
        return this.request(string, new Bundle(), "GET");
    }

    public String request(String string, Bundle bundle) throws MalformedURLException, IOException {
        return this.request(string, bundle, "GET");
    }

    public String request(String string, Bundle bundle, String string2) throws FileNotFoundException, MalformedURLException, IOException {
        bundle.putString("format", "json");
        if (this.isSessionValid()) {
            bundle.putString(TOKEN, this.getAccessToken());
        }
        if (string != null) {
            string = GRAPH_BASE_URL + string;
            return Util.openUrl(string, string2, bundle);
        }
        string = RESTSERVER_URL;
        return Util.openUrl(string, string2, bundle);
    }

    public void setAccessExpires(long l2) {
        this.mAccessExpires = l2;
    }

    public void setAccessExpiresIn(String string) {
        if (string == null) return;
        long l2 = string.equals("0") ? 0L : System.currentTimeMillis() + Long.parseLong(string) * 1000L;
        this.setAccessExpires(l2);
    }

    public void setAccessToken(String string) {
        this.mAccessToken = string;
        this.mLastAccessUpdate = System.currentTimeMillis();
    }

    public void setAppId(String string) {
        this.mAppId = string;
    }

    public boolean shouldExtendAccessToken() {
        if (!this.isSessionValid()) return false;
        if (System.currentTimeMillis() - this.mLastAccessUpdate < 86400000L) return false;
        return true;
    }

    public static interface DialogListener {
        public void onCancel();

        public void onComplete(Bundle var1);

        public void onError(DialogError var1);

        public void onFacebookError(FacebookError var1);
    }

    public static interface ServiceListener {
        public void onComplete(Bundle var1);

        public void onError(Error var1);

        public void onFacebookError(FacebookError var1);
    }

    private class TokenRefreshServiceConnection
    implements ServiceConnection {
        final Context applicationsContext;
        final Messenger messageReceiver = new Messenger(new Handler(){

            public void handleMessage(Message object) {
                String string = object.getData().getString(Facebook.TOKEN);
                long l2 = object.getData().getLong(Facebook.EXPIRES) * 1000L;
                Object object2 = (Bundle)object.getData().clone();
                object2.putLong(Facebook.EXPIRES, l2);
                if (string != null) {
                    Facebook.this.setAccessToken(string);
                    Facebook.this.setAccessExpires(l2);
                    if (TokenRefreshServiceConnection.this.serviceListener != null) {
                        TokenRefreshServiceConnection.this.serviceListener.onComplete((Bundle)object2);
                    }
                } else if (TokenRefreshServiceConnection.this.serviceListener != null) {
                    string = object.getData().getString("error");
                    if (object.getData().containsKey("error_code")) {
                        int n2 = object.getData().getInt("error_code");
                        TokenRefreshServiceConnection.this.serviceListener.onFacebookError(new FacebookError(string, null, n2));
                    } else {
                        object2 = TokenRefreshServiceConnection.this.serviceListener;
                        object = string != null ? string : "Unknown service error";
                        object2.onError(new Error((String)object));
                    }
                }
                TokenRefreshServiceConnection.this.applicationsContext.unbindService((ServiceConnection)TokenRefreshServiceConnection.this);
            }
        });
        Messenger messageSender = null;
        final ServiceListener serviceListener;

        public TokenRefreshServiceConnection(Context context, ServiceListener serviceListener) {
            this.applicationsContext = context;
            this.serviceListener = serviceListener;
        }

        private void refreshToken() {
            Bundle bundle = new Bundle();
            bundle.putString(Facebook.TOKEN, Facebook.this.mAccessToken);
            Message message = Message.obtain();
            message.setData(bundle);
            message.replyTo = this.messageReceiver;
            try {
                this.messageSender.send(message);
                return;
            }
            catch (RemoteException remoteException) {
                this.serviceListener.onError(new Error("Service connection error"));
                return;
            }
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            this.messageSender = new Messenger(iBinder);
            this.refreshToken();
        }

        public void onServiceDisconnected(ComponentName componentName) {
            this.serviceListener.onError(new Error("Service disconnected"));
            this.applicationsContext.unbindService((ServiceConnection)this);
        }
    }
}

