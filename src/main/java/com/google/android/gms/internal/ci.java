/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.ResolveInfo
 *  android.media.AudioManager
 *  android.net.ConnectivityManager
 *  android.net.Uri
 *  android.telephony.TelephonyManager
 *  android.util.DisplayMetrics
 */
package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.google.android.gms.internal.cn;
import com.google.android.gms.internal.cr;
import java.util.Locale;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public final class ci {
    public final int hW;
    public final boolean hX;
    public final boolean hY;
    public final String hZ;
    public final String ia;
    public final boolean ib;
    public final boolean ic;
    public final boolean id;
    public final String ie;
    public final String if;
    public final int ig;
    public final int ih;
    public final int ii;
    public final int ij;
    public final int ik;
    public final int il;
    public final float im;
    public final int in;
    public final int io;

    public ci(Context context) {
        boolean bl2 = true;
        AudioManager audioManager = (AudioManager)context.getSystemService("audio");
        ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService("connectivity");
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        Locale locale = Locale.getDefault();
        PackageManager packageManager = context.getPackageManager();
        TelephonyManager telephonyManager = (TelephonyManager)context.getSystemService("phone");
        this.hW = audioManager.getMode();
        boolean bl3 = ci.a(packageManager, "geo:0,0?q=donuts") != null;
        this.hX = bl3;
        bl3 = ci.a(packageManager, "http://www.google.com") != null ? bl2 : false;
        this.hY = bl3;
        this.hZ = telephonyManager.getNetworkOperator();
        this.ia = locale.getCountry();
        this.ib = cr.aw();
        this.ic = audioManager.isMusicActive();
        this.id = audioManager.isSpeakerphoneOn();
        this.ie = locale.getLanguage();
        this.if = ci.a(packageManager);
        this.ig = audioManager.getStreamVolume(3);
        this.ih = ci.a(context, connectivityManager, packageManager);
        this.ii = telephonyManager.getNetworkType();
        this.ij = telephonyManager.getPhoneType();
        this.ik = audioManager.getRingerMode();
        this.il = audioManager.getStreamVolume(2);
        this.im = displayMetrics.density;
        this.in = displayMetrics.widthPixels;
        this.io = displayMetrics.heightPixels;
    }

    private static int a(Context context, ConnectivityManager connectivityManager, PackageManager packageManager) {
        int n2 = -2;
        if (!cn.a(packageManager, context.getPackageName(), "android.permission.ACCESS_NETWORK_STATE")) return n2;
        context = connectivityManager.getActiveNetworkInfo();
        if (context == null) return -1;
        return context.getType();
    }

    private static ResolveInfo a(PackageManager packageManager, String string2) {
        return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse((String)string2)), 65536);
    }

    private static String a(PackageManager object) {
        ResolveInfo resolveInfo = ci.a(object, "market://details?id=com.google.android.gms.ads");
        if (resolveInfo == null) {
            return null;
        }
        resolveInfo = resolveInfo.activityInfo;
        if (resolveInfo == null) return null;
        try {
            if ((object = object.getPackageInfo(resolveInfo.packageName, 0)) == null) return null;
            return object.versionCode + "." + resolveInfo.packageName;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            return null;
        }
    }
}

