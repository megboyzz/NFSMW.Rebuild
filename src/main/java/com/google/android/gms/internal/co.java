/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.Window
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 */
package com.google.android.gms.internal;

import android.content.Context;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.io.File;

public final class co {
    public static void a(Context context, WebSettings webSettings) {
        webSettings.setAppCachePath(new File(context.getCacheDir(), "com.google.android.gms.ads.appcache").getAbsolutePath());
        webSettings.setAppCacheMaxSize(0L);
        webSettings.setAppCacheEnabled(true);
        webSettings.setDatabasePath(context.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
        webSettings.setDatabaseEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
    }

    public static void a(Window window) {
        window.setFlags(0x1000000, 0x1000000);
    }

    public static void a(WebView webView) {
        webView.onPause();
    }

    public static void b(WebView webView) {
        webView.onResume();
    }

    public static void c(View view) {
        view.setLayerType(1, null);
    }

    public static void d(View view) {
        view.setLayerType(0, null);
    }
}

