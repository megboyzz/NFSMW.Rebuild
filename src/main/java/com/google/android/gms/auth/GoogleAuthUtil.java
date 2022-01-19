/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.accounts.AccountManager
 *  android.app.Notification
 *  android.app.NotificationManager
 *  android.app.PendingIntent
 *  android.content.ComponentName
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.os.RemoteException
 *  android.text.TextUtils
 *  android.util.Log
 *  com.google.android.gms.R$string
 */
package com.google.android.gms.auth;

import android.accounts.AccountManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.R;
import com.google.android.gms.auth.GoogleAuthException;
import com.google.android.gms.auth.GooglePlayServicesAvailabilityException;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.google.android.gms.auth.UserRecoverableNotifiedException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.a;
import com.google.android.gms.internal.du;
import com.google.android.gms.internal.o;
import java.io.IOException;
import java.net.URISyntaxException;

public final class GoogleAuthUtil {
    public static final String GOOGLE_ACCOUNT_TYPE = "com.google";
    public static final String KEY_ANDROID_PACKAGE_NAME;
    public static final String KEY_CALLER_UID;
    public static final String KEY_CLIENT_PACKAGE_NAME = "clientPackageName";
    public static final String KEY_REQUEST_ACTIONS = "request_visible_actions";
    @Deprecated
    public static final String KEY_REQUEST_VISIBLE_ACTIVITIES = "request_visible_actions";
    public static final String KEY_SUPPRESS_PROGRESS_SCREEN = "suppressProgressScreen";
    private static final ComponentName jS;
    private static final ComponentName jT;
    private static final Intent jU;
    private static final Intent jV;

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            // empty if block
        }
        KEY_CALLER_UID = "callerUid";
        if (Build.VERSION.SDK_INT >= 14) {
            // empty if block
        }
        KEY_ANDROID_PACKAGE_NAME = "androidPackageName";
        jS = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");
        jT = new ComponentName("com.google.android.gms", "com.google.android.gms.recovery.RecoveryService");
        jU = new Intent().setPackage("com.google.android.gms").setComponent(jS);
        jV = new Intent().setPackage("com.google.android.gms").setComponent(jT);
    }

    private GoogleAuthUtil() {
    }

    /*
     * Unable to fully structure code
     */
    private static String a(Context var0, String var1_2, String var2_3, Bundle var3_5) throws IOException, UserRecoverableNotifiedException, GoogleAuthException {
        var5_7 = var3_5;
        if (var3_5 == null) {
            var5_7 = new Bundle();
        }
        try {
            return GoogleAuthUtil.getToken(var0, var1_2, var2_3, var5_7);
        }
        catch (GooglePlayServicesAvailabilityException var3_6) {
            block13: {
                var5_7 = GooglePlayServicesUtil.getErrorPendingIntent(var3_6.getConnectionStatusCode(), var0, 0);
                var6_8 = var0.getResources();
                var7_9 = new Notification(17301642, (CharSequence)var6_8.getString(R.string.auth_client_play_services_err_notification_msg), System.currentTimeMillis());
                var7_9.flags |= 16;
                var1_2 = var2_3 = var0.getApplicationInfo().name;
                if (!TextUtils.isEmpty((CharSequence)var2_3)) break block13;
                var1_2 = var0.getPackageName();
                var8_10 = var0.getApplicationContext().getPackageManager();
                try {
                    var2_3 = var8_10.getApplicationInfo(var0.getPackageName(), 0);
lbl17:
                    // 2 sources

                    while (var2_3 != null) {
                        var1_2 = var8_10.getApplicationLabel((ApplicationInfo)var2_3).toString();
                        break;
                    }
                }
                catch (PackageManager.NameNotFoundException var2_4) {
                    var2_3 = null;
                    ** GOTO lbl17
                }
            }
            var1_2 = var6_8.getString(R.string.auth_client_requested_by_msg, new Object[]{var1_2});
            switch (var3_6.getConnectionStatusCode()) {
                default: {
                    var4_11 = R.string.auth_client_using_bad_version_title;
lbl29:
                    // 4 sources

                    while (true) {
                        var7_9.setLatestEventInfo(var0, (CharSequence)var6_8.getString(var4_11), (CharSequence)var1_2, (PendingIntent)var5_7);
                        ((NotificationManager)var0.getSystemService("notification")).notify(39789, var7_9);
                        throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
                    }
                }
                case 1: {
                    var4_11 = R.string.auth_client_needs_installation_title;
                    ** GOTO lbl29
                }
                case 2: {
                    var4_11 = R.string.auth_client_needs_update_title;
                    ** GOTO lbl29
                }
                case 3: 
            }
            var4_11 = R.string.auth_client_needs_enabling_title;
            ** continue;
        }
        catch (UserRecoverableAuthException var0_1) {
            throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
        }
    }

    private static void b(Intent object) {
        if (object == null) {
            throw new IllegalArgumentException("Callack cannot be null.");
        }
        object = object.toUri(1);
        try {
            Intent.parseUri((String)object, (int)1);
            return;
        }
        catch (URISyntaxException uRISyntaxException) {
            throw new IllegalArgumentException("Parameter callback contains invalid data. It must be serializable using toUri() and parseUri().");
        }
    }

    public static String getToken(Context context, String string2, String string3) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return GoogleAuthUtil.getToken(context, string2, string3, new Bundle());
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    public static String getToken(Context var0, String var1_1, String var2_5, Bundle var3_6) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        var5_7 = var0.getApplicationContext();
        du.C("Calling this from your main thread can lead to deadlock");
        GoogleAuthUtil.m(var5_7);
        var3_6 = var3_6 == null ? new Bundle() : new Bundle(var3_6);
        var0 = var0.getApplicationInfo().packageName;
        var3_6.putString("clientPackageName", (String)var0);
        if (!var3_6.containsKey(GoogleAuthUtil.KEY_ANDROID_PACKAGE_NAME)) {
            var3_6.putString(GoogleAuthUtil.KEY_ANDROID_PACKAGE_NAME, (String)var0);
        }
        if (var5_7.bindService(GoogleAuthUtil.jU, (ServiceConnection)(var0 = new a()), 1) == false) throw new IOException("Could not bind to service with the given context.");
        try {
            var1_1 = o.a.a(var0.aS()).a(var1_1, var2_5, var3_6);
            var2_5 = var1_1.getString("authtoken");
            var4_8 = TextUtils.isEmpty((CharSequence)var2_5);
            if (var4_8) ** GOTO lbl-1000
            ** GOTO lbl22
        }
        catch (RemoteException var1_2) {
            Log.i((String)"GoogleAuthUtil", (String)"GMS remote exception ", (Throwable)var1_2);
            throw new IOException("remote exception");
            catch (InterruptedException var1_4) {
                throw new GoogleAuthException("Interrupted");
            }
lbl22:
            // 1 sources

            var5_7.unbindService((ServiceConnection)var0);
            return var2_5;
lbl-1000:
            // 1 sources

            {
                var2_5 = var1_1.getString("Error");
                var1_1 = (Intent)var1_1.getParcelable("userRecoveryIntent");
                if (GoogleAuthUtil.x(var2_5)) {
                    throw new UserRecoverableAuthException(var2_5, (Intent)var1_1);
                }
            }
        }
        catch (Throwable var1_3) {
            var5_7.unbindService((ServiceConnection)var0);
            throw var1_3;
        }
        {
            if (GoogleAuthUtil.w(var2_5) == false) throw new GoogleAuthException(var2_5);
            throw new IOException(var2_5);
        }
    }

    public static String getTokenWithNotification(Context context, String string2, String string3, Bundle bundle) throws IOException, UserRecoverableNotifiedException, GoogleAuthException {
        Bundle bundle2 = bundle;
        if (bundle == null) {
            bundle2 = new Bundle();
        }
        bundle2.putBoolean("handle_notification", true);
        return GoogleAuthUtil.a(context, string2, string3, bundle2);
    }

    public static String getTokenWithNotification(Context context, String string2, String string3, Bundle bundle, Intent intent) throws IOException, UserRecoverableNotifiedException, GoogleAuthException {
        GoogleAuthUtil.b(intent);
        Bundle bundle2 = bundle;
        if (bundle == null) {
            bundle2 = new Bundle();
        }
        bundle2.putParcelable("callback_intent", (Parcelable)intent);
        bundle2.putBoolean("handle_notification", true);
        return GoogleAuthUtil.a(context, string2, string3, bundle2);
    }

    public static String getTokenWithNotification(Context context, String string2, String string3, Bundle bundle, String string4, Bundle bundle2) throws IOException, UserRecoverableNotifiedException, GoogleAuthException {
        if (TextUtils.isEmpty((CharSequence)string4)) {
            throw new IllegalArgumentException("Authority cannot be empty or null.");
        }
        Bundle bundle3 = bundle;
        if (bundle == null) {
            bundle3 = new Bundle();
        }
        bundle = bundle2;
        if (bundle2 == null) {
            bundle = new Bundle();
        }
        ContentResolver.validateSyncExtrasBundle((Bundle)bundle);
        bundle3.putString("authority", string4);
        bundle3.putBundle("sync_extras", bundle);
        bundle3.putBoolean("handle_notification", true);
        return GoogleAuthUtil.a(context, string2, string3, bundle3);
    }

    public static void invalidateToken(Context context, String string2) {
        AccountManager.get((Context)context).invalidateAuthToken(GOOGLE_ACCOUNT_TYPE, string2);
    }

    private static void m(Context context) throws GooglePlayServicesAvailabilityException, GoogleAuthException {
        try {
            GooglePlayServicesUtil.m(context);
            return;
        }
        catch (GooglePlayServicesRepairableException googlePlayServicesRepairableException) {
            throw new GooglePlayServicesAvailabilityException(googlePlayServicesRepairableException.getConnectionStatusCode(), googlePlayServicesRepairableException.getMessage(), googlePlayServicesRepairableException.getIntent());
        }
        catch (GooglePlayServicesNotAvailableException googlePlayServicesNotAvailableException) {
            throw new GoogleAuthException(googlePlayServicesNotAvailableException.getMessage());
        }
    }

    private static boolean w(String string2) {
        if ("NetworkError".equals(string2)) return true;
        if ("ServiceUnavailable".equals(string2)) return true;
        if (!"Timeout".equals(string2)) return false;
        return true;
    }

    private static boolean x(String string2) {
        if ("BadAuthentication".equals(string2)) return true;
        if ("CaptchaRequired".equals(string2)) return true;
        if ("DeviceManagementRequiredOrSyncDisabled".equals(string2)) return true;
        if ("NeedPermission".equals(string2)) return true;
        if ("NeedsBrowser".equals(string2)) return true;
        if ("UserCancel".equals(string2)) return true;
        if (!"AppDownloadRequired".equals(string2)) return false;
        return true;
    }
}

