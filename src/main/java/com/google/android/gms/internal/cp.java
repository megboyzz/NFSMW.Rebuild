/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.webkit.WebSettings
 */
package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebSettings;
import com.google.android.gms.internal.co;

public final class cp {
    public static void a(Context context, WebSettings webSettings) {
        co.a(context, webSettings);
        webSettings.setMediaPlaybackRequiresUserGesture(false);
    }

    public static String getDefaultUserAgent(Context context) {
        return WebSettings.getDefaultUserAgent((Context)context);
    }
}

