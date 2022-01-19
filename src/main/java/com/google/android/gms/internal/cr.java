/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.os.Build
 *  android.os.Handler
 *  android.os.Looper
 *  android.provider.Settings$Secure
 *  android.util.DisplayMetrics
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.TextView
 */
package com.google.android.gms.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.gms.internal.cs;
import com.google.android.gms.internal.x;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

public final class cr {
    public static final Handler iE = new Handler(Looper.getMainLooper());

    public static int a(Context context, int n2) {
        return cr.a(context.getResources().getDisplayMetrics(), n2);
    }

    public static int a(DisplayMetrics displayMetrics, int n2) {
        return (int)TypedValue.applyDimension((int)1, (float)n2, (DisplayMetrics)displayMetrics);
    }

    public static void a(ViewGroup viewGroup, x x2, String string2) {
        cr.a(viewGroup, x2, string2, -16777216, -1);
    }

    private static void a(ViewGroup viewGroup, x x2, String string2, int n2, int n3) {
        if (viewGroup.getChildCount() != 0) {
            return;
        }
        Context context = viewGroup.getContext();
        TextView textView = new TextView(context);
        textView.setGravity(17);
        textView.setText((CharSequence)string2);
        textView.setTextColor(n2);
        textView.setBackgroundColor(n3);
        string2 = new FrameLayout(context);
        string2.setBackgroundColor(n2);
        n2 = cr.a(context, 3);
        string2.addView((View)textView, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(x2.widthPixels - n2, x2.heightPixels - n2, 17));
        viewGroup.addView((View)string2, x2.widthPixels, x2.heightPixels);
    }

    public static void a(ViewGroup viewGroup, x x2, String string2, String string3) {
        cs.v(string3);
        cr.a(viewGroup, x2, string2, -65536, -16777216);
    }

    public static boolean aw() {
        return Build.DEVICE.startsWith("generic");
    }

    public static boolean ax() {
        if (Looper.myLooper() != Looper.getMainLooper()) return false;
        return true;
    }

    public static String l(Context object) {
        if ((object = Settings.Secure.getString((ContentResolver)object.getContentResolver(), (String)"android_id")) != null) {
            if (!cr.aw()) return cr.q((String)object);
        }
        object = "emulator";
        return cr.q((String)object);
    }

    public static String q(String string2) {
        int n2 = 0;
        while (n2 < 2) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(string2.getBytes());
                return String.format(Locale.US, "%032X", new BigInteger(1, messageDigest.digest()));
            }
            catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                ++n2;
            }
        }
        return null;
    }
}

