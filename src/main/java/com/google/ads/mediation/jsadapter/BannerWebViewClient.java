/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 */
package com.google.ads.mediation.jsadapter;

import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.ads.mediation.jsadapter.JavascriptAdapter;
import com.google.android.gms.internal.cs;
import java.net.URI;
import java.net.URISyntaxException;

public final class BannerWebViewClient
extends WebViewClient {
    private final String A;
    private boolean B;
    private final JavascriptAdapter r;

    public BannerWebViewClient(JavascriptAdapter javascriptAdapter, String string) {
        this.A = this.c(string);
        this.r = javascriptAdapter;
        this.B = false;
    }

    private boolean b(String string) {
        if (TextUtils.isEmpty((CharSequence)(string = this.c(string)))) {
            return false;
        }
        try {
            Object object = new URI(string);
            if ("passback".equals(((URI)object).getScheme())) {
                cs.r("Passback received");
                this.r.sendAdNotReceivedUpdate();
                return true;
            }
            if (TextUtils.isEmpty((CharSequence)this.A)) return false;
            Object object2 = new URI(this.A);
            string = ((URI)object2).getHost();
            String string2 = ((URI)object).getHost();
            object2 = ((URI)object2).getPath();
            object = ((URI)object).getPath();
            if (!BannerWebViewClient.equals(string, string2)) return false;
            if (!BannerWebViewClient.equals(object2, object)) return false;
            cs.r("Passback received");
            this.r.sendAdNotReceivedUpdate();
            return true;
        }
        catch (URISyntaxException uRISyntaxException) {
            cs.s(uRISyntaxException.getMessage());
            return false;
        }
    }

    private String c(String string) {
        if (TextUtils.isEmpty((CharSequence)string)) {
            return string;
        }
        try {
            if (!string.endsWith("/")) return string;
            return string.substring(0, string.length() - 1);
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            cs.s(indexOutOfBoundsException.getMessage());
            return string;
        }
    }

    private static boolean equals(Object object, Object object2) {
        if (object == object2) return true;
        if (object == null) return false;
        if (!object.equals(object2)) return false;
        return true;
    }

    public void onLoadResource(WebView webView, String string) {
        cs.u("onLoadResource: " + string);
        if (this.b(string)) return;
        super.onLoadResource(webView, string);
    }

    public void onPageFinished(WebView webView, String string) {
        cs.u("onPageFinished: " + string);
        super.onPageFinished(webView, string);
        if (this.B) return;
        this.r.startCheckingForAd();
        this.B = true;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String string) {
        cs.u("shouldOverrideUrlLoading: " + string);
        if (!this.b(string)) return false;
        cs.r("shouldOverrideUrlLoading: received passback url");
        return true;
    }
}

