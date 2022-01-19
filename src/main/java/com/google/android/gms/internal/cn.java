/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.content.pm.PackageManager
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.google.android.gms.internal.co;
import com.google.android.gms.internal.cp;
import com.google.android.gms.internal.cq;
import com.google.android.gms.internal.cr;
import com.google.android.gms.internal.cs;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class cn {
    private static final Object hA = new Object();
    private static String iA;
    private static boolean iB;
    private static boolean iz;

    static {
        iz = true;
        iB = false;
    }

    public static String a(Readable readable) throws IOException {
        int n2;
        StringBuilder stringBuilder = new StringBuilder();
        CharBuffer charBuffer = CharBuffer.allocate(2048);
        while ((n2 = readable.read(charBuffer)) != -1) {
            charBuffer.flip();
            stringBuilder.append(charBuffer, 0, n2);
        }
        return stringBuilder.toString();
    }

    private static JSONArray a(Collection<?> object) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        object = object.iterator();
        while (object.hasNext()) {
            cn.a(jSONArray, object.next());
        }
        return jSONArray;
    }

    private static JSONArray a(Object[] objectArray) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        int n2 = objectArray.length;
        int n3 = 0;
        while (n3 < n2) {
            cn.a(jSONArray, objectArray[n3]);
            ++n3;
        }
        return jSONArray;
    }

    private static JSONObject a(Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        Iterator iterator = bundle.keySet().iterator();
        while (iterator.hasNext()) {
            String string2 = (String)iterator.next();
            cn.a(jSONObject, string2, bundle.get(string2));
        }
        return jSONObject;
    }

    public static void a(Context context, String string2, WebSettings webSettings) {
        webSettings.setUserAgentString(cn.b(context, string2));
    }

    public static void a(Context context, String string2, List<String> object) {
        object = object.iterator();
        while (object.hasNext()) {
            new cq(context, string2, (String)object.next()).start();
        }
    }

    public static void a(Context context, String string2, boolean bl2, HttpURLConnection httpURLConnection) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(bl2);
        httpURLConnection.setReadTimeout(60000);
        httpURLConnection.setRequestProperty("User-Agent", cn.b(context, string2));
        httpURLConnection.setUseCaches(false);
    }

    public static void a(WebView webView) {
        if (Build.VERSION.SDK_INT < 11) return;
        co.a(webView);
    }

    private static void a(JSONArray jSONArray, Object object) throws JSONException {
        if (object instanceof Bundle) {
            jSONArray.put((Object)cn.a((Bundle)object));
            return;
        }
        if (object instanceof Map) {
            jSONArray.put((Object)cn.m((Map)object));
            return;
        }
        if (object instanceof Collection) {
            jSONArray.put((Object)cn.a((Collection)object));
            return;
        }
        if (object instanceof Object[]) {
            jSONArray.put((Object)cn.a((Object[])object));
            return;
        }
        jSONArray.put(object);
    }

    private static void a(JSONObject jSONObject, String string2, Object object) throws JSONException {
        if (object instanceof Bundle) {
            jSONObject.put(string2, (Object)cn.a((Bundle)object));
            return;
        }
        if (object instanceof Map) {
            jSONObject.put(string2, (Object)cn.m((Map)object));
            return;
        }
        if (object instanceof Collection) {
            if (string2 == null) {
                string2 = "null";
            }
            jSONObject.put(string2, (Object)cn.a((Collection)object));
            return;
        }
        if (object instanceof Object[]) {
            jSONObject.put(string2, (Object)cn.a(Arrays.asList((Object[])object)));
            return;
        }
        jSONObject.put(string2, object);
    }

    public static boolean a(PackageManager packageManager, String string2, String string3) {
        if (packageManager.checkPermission(string3, string2) != 0) return false;
        return true;
    }

    public static boolean as() {
        return iz;
    }

    public static int at() {
        if (Build.VERSION.SDK_INT < 9) return 0;
        return 6;
    }

    public static int au() {
        if (Build.VERSION.SDK_INT < 9) return 1;
        return 7;
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    private static String b(final Context var0, String var1_3) {
        var2_4 = cn.hA;
        synchronized (var2_4) {
            block10: {
                if (cn.iA != null) {
                    return cn.iA;
                }
                if (Build.VERSION.SDK_INT < 17) break block10;
                cn.iA = cp.getDefaultUserAgent(var0 /* !! */ );
                ** GOTO lbl14
            }
            if (!cr.ax()) {
                cr.iE.post(new Runnable(){

                    @Override
                    public void run() {
                        Object object = hA;
                        synchronized (object) {
                            cn.p(cn.j(var0));
                            hA.notifyAll();
                            return;
                        }
                    }
                });
            } else {
                cn.iA = cn.j(var0 /* !! */ );
lbl14:
                // 3 sources

                while (true) {
                    cn.iA = cn.iA + " (Mobile; " + var1_3 + ")";
                    return cn.iA;
                }
            }
            while (true) {
                if ((var0 /* !! */  = cn.iA) != null) ** continue;
                try {
                    cn.hA.wait();
                }
                catch (InterruptedException var0_1) {
                    return cn.iA;
                }
            }
        }
    }

    public static void b(WebView webView) {
        if (Build.VERSION.SDK_INT < 11) return;
        co.b(webView);
    }

    public static boolean h(Context context) {
        boolean bl2;
        Intent intent = new Intent();
        intent.setClassName(context, "com.google.android.gms.ads.AdActivity");
        context = context.getPackageManager().resolveActivity(intent, 65536);
        if (context == null || context.activityInfo == null) {
            cs.v("Could not find com.google.android.gms.ads.AdActivity, please make sure it is declared in AndroidManifest.xml.");
            return false;
        }
        if ((context.activityInfo.configChanges & 0x10) == 0) {
            cs.v(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "keyboard"));
            bl2 = false;
        } else {
            bl2 = true;
        }
        if ((context.activityInfo.configChanges & 0x20) == 0) {
            cs.v(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "keyboardHidden"));
            bl2 = false;
        }
        if ((context.activityInfo.configChanges & 0x80) == 0) {
            cs.v(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "orientation"));
            bl2 = false;
        }
        if ((context.activityInfo.configChanges & 0x100) == 0) {
            cs.v(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "screenLayout"));
            bl2 = false;
        }
        if ((context.activityInfo.configChanges & 0x200) == 0) {
            cs.v(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "uiMode"));
            bl2 = false;
        }
        if ((context.activityInfo.configChanges & 0x400) == 0) {
            cs.v(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "screenSize"));
            bl2 = false;
        }
        if ((context.activityInfo.configChanges & 0x800) != 0) return bl2;
        cs.v(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "smallestScreenSize"));
        return false;
    }

    public static void i(Context context) {
        if (iB) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        context.getApplicationContext().registerReceiver((BroadcastReceiver)new a(), intentFilter);
        iB = true;
    }

    private static String j(Context context) {
        return new WebView(context).getSettings().getUserAgentString();
    }

    static /* synthetic */ boolean k(boolean bl2) {
        iz = bl2;
        return bl2;
    }

    public static JSONObject m(Map<String, ?> map) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            Iterator<String> iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                String string2 = iterator.next();
                cn.a(jSONObject, string2, map.get(string2));
            }
            return jSONObject;
        }
        catch (ClassCastException classCastException) {
            throw new JSONException("Could not convert map to JSON: " + classCastException.getMessage());
        }
    }

    public static String o(String string2) {
        return Uri.parse((String)string2).buildUpon().query(null).build().toString();
    }

    static /* synthetic */ String p(String string2) {
        iA = string2;
        return string2;
    }

    private static final class a
    extends BroadcastReceiver {
        private a() {
        }

        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                cn.k(true);
                return;
            }
            if (!"android.intent.action.SCREEN_OFF".equals(intent.getAction())) return;
            cn.k(false);
        }
    }
}

