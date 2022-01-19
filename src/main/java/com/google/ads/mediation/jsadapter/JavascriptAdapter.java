/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 */
package com.google.ads.mediation.jsadapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.mediation.EmptyNetworkExtras;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.jsadapter.AdViewCheckTask;
import com.google.ads.mediation.jsadapter.BannerWebViewClient;
import com.google.ads.mediation.jsadapter.JavascriptServerParameters;
import com.google.android.gms.internal.cs;

public final class JavascriptAdapter
implements MediationBannerAdapter<EmptyNetworkExtras, JavascriptServerParameters> {
    private WebView C;
    private FrameLayout D;
    private boolean E;
    private MediationBannerListener k;
    private int v;
    private int w;

    @Override
    public void destroy() {
        this.E = true;
    }

    @Override
    public Class<EmptyNetworkExtras> getAdditionalParametersType() {
        return EmptyNetworkExtras.class;
    }

    @Override
    public View getBannerView() {
        return this.D;
    }

    @Override
    public Class<JavascriptServerParameters> getServerParametersType() {
        return JavascriptServerParameters.class;
    }

    public WebView getWebView() {
        return this.C;
    }

    public int getWebViewHeight() {
        return this.v;
    }

    public int getWebViewWidth() {
        return this.w;
    }

    public void passbackReceived() {
        cs.r("Passback received");
        this.sendAdNotReceivedUpdate();
    }

    @Override
    public void requestBannerAd(MediationBannerListener mediationBannerListener, Activity activity, JavascriptServerParameters javascriptServerParameters, AdSize adSize, MediationAdRequest mediationAdRequest, EmptyNetworkExtras emptyNetworkExtras) {
        this.k = mediationBannerListener;
        int n2 = javascriptServerParameters.height != null ? javascriptServerParameters.height.intValue() : adSize.getHeightInPixels((Context)activity);
        this.v = n2;
        n2 = javascriptServerParameters.width != null ? javascriptServerParameters.width.intValue() : adSize.getWidthInPixels((Context)activity);
        this.w = n2;
        this.E = false;
        this.C = new WebView((Context)activity);
        this.C.getSettings().setJavaScriptEnabled(true);
        this.C.setWebViewClient((WebViewClient)new BannerWebViewClient(this, javascriptServerParameters.passBackUrl));
        this.C.setBackgroundColor(0);
        this.D = new FrameLayout((Context)activity);
        mediationBannerListener = new FrameLayout.LayoutParams(this.w, this.v, 17);
        this.D.addView((View)this.C, (ViewGroup.LayoutParams)mediationBannerListener);
        this.C.loadDataWithBaseURL(null, javascriptServerParameters.htmlScript, "text/html", "utf-8", null);
    }

    public void sendAdNotReceivedUpdate() {
        if (this.E) return;
        this.E = true;
        this.k.onFailedToReceiveAd(this, AdRequest.ErrorCode.NO_FILL);
    }

    public void sendAdReceivedUpdate() {
        if (this.E) return;
        this.E = true;
        this.k.onReceivedAd(this);
    }

    public boolean shouldStopAdCheck() {
        return this.E;
    }

    public void startCheckingForAd() {
        new AdViewCheckTask(this, 200L, 100L).start();
    }
}

