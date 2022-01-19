/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.webkit.WebResourceResponse
 *  android.webkit.WebView
 */
package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.internal.cn;
import com.google.android.gms.internal.cs;
import com.google.android.gms.internal.cv;
import com.google.android.gms.internal.cw;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public final class cy
extends cw {
    public cy(cv cv2, boolean bl2) {
        super(cv2, bl2);
    }

    private static WebResourceResponse b(Context context, String string2, String object) throws IOException {
        object = (HttpURLConnection)new URL((String)object).openConnection();
        try {
            cn.a(context, string2, true, (HttpURLConnection)object);
            ((URLConnection)object).connect();
            context = new WebResourceResponse("application/javascript", "UTF-8", (InputStream)new ByteArrayInputStream(cn.a(new InputStreamReader(((URLConnection)object).getInputStream())).getBytes("UTF-8")));
            return context;
        }
        finally {
            ((HttpURLConnection)object).disconnect();
        }
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String string2) {
        try {
            if (!"mraid.js".equalsIgnoreCase(new File(string2).getName())) {
                return super.shouldInterceptRequest(webView, string2);
            }
            if (!(webView instanceof cv)) {
                cs.v("Tried to intercept request from a WebView that wasn't an AdWebView.");
                return super.shouldInterceptRequest(webView, string2);
            }
            cv cv2 = (cv)webView;
            cv2.aB().Y();
            if (cv2.y().eG) {
                cs.u("shouldInterceptRequest(http://media.admob.com/mraid/v1/mraid_app_interstitial.js)");
                return cy.b(cv2.getContext(), this.gu.aD().iF, "http://media.admob.com/mraid/v1/mraid_app_interstitial.js");
            }
            if (cv2.aE()) {
                cs.u("shouldInterceptRequest(http://media.admob.com/mraid/v1/mraid_app_expanded_banner.js)");
                return cy.b(cv2.getContext(), this.gu.aD().iF, "http://media.admob.com/mraid/v1/mraid_app_expanded_banner.js");
            }
            cs.u("shouldInterceptRequest(http://media.admob.com/mraid/v1/mraid_app_banner.js)");
            return cy.b(cv2.getContext(), this.gu.aD().iF, "http://media.admob.com/mraid/v1/mraid_app_banner.js");
        }
        catch (IOException iOException) {
            cs.v("Could not fetching MRAID JS. " + iOException.getMessage());
            return super.shouldInterceptRequest(webView, string2);
        }
    }
}

