/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.view.View
 */
package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.customevent.CustomEventBanner;
import com.google.ads.mediation.customevent.CustomEventBannerListener;
import com.google.ads.mediation.customevent.CustomEventInterstitial;
import com.google.ads.mediation.customevent.CustomEventInterstitialListener;
import com.google.ads.mediation.customevent.CustomEventServerParameters;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import com.google.android.gms.internal.cs;

public final class CustomEventAdapter
implements MediationBannerAdapter<CustomEventExtras, CustomEventServerParameters>,
MediationInterstitialAdapter<CustomEventExtras, CustomEventServerParameters> {
    private View m;
    private CustomEventBanner n;
    private CustomEventInterstitial o;

    private static <T> T a(String string) {
        try {
            Object obj = Class.forName(string).newInstance();
            return (T)obj;
        }
        catch (Throwable throwable) {
            cs.v("Could not instantiate custom event adapter: " + string + ". " + throwable.getMessage());
            return null;
        }
    }

    private void a(View view) {
        this.m = view;
    }

    @Override
    public void destroy() {
        if (this.n != null) {
            this.n.destroy();
        }
        if (this.o == null) return;
        this.o.destroy();
    }

    @Override
    public Class<CustomEventExtras> getAdditionalParametersType() {
        return CustomEventExtras.class;
    }

    @Override
    public View getBannerView() {
        return this.m;
    }

    @Override
    public Class<CustomEventServerParameters> getServerParametersType() {
        return CustomEventServerParameters.class;
    }

    @Override
    public void requestBannerAd(MediationBannerListener mediationBannerListener, Activity activity, CustomEventServerParameters customEventServerParameters, AdSize adSize, MediationAdRequest mediationAdRequest, CustomEventExtras object) {
        this.n = (CustomEventBanner)CustomEventAdapter.a(customEventServerParameters.className);
        if (this.n == null) {
            mediationBannerListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
            return;
        }
        object = object == null ? null : ((CustomEventExtras)object).getExtra(customEventServerParameters.label);
        this.n.requestBannerAd(new a(this, mediationBannerListener), activity, customEventServerParameters.label, customEventServerParameters.parameter, adSize, mediationAdRequest, object);
    }

    @Override
    public void requestInterstitialAd(MediationInterstitialListener mediationInterstitialListener, Activity activity, CustomEventServerParameters customEventServerParameters, MediationAdRequest mediationAdRequest, CustomEventExtras object) {
        this.o = (CustomEventInterstitial)CustomEventAdapter.a(customEventServerParameters.className);
        if (this.o == null) {
            mediationInterstitialListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
            return;
        }
        object = object == null ? null : ((CustomEventExtras)object).getExtra(customEventServerParameters.label);
        this.o.requestInterstitialAd(new b(this, mediationInterstitialListener), activity, customEventServerParameters.label, customEventServerParameters.parameter, mediationAdRequest, object);
    }

    @Override
    public void showInterstitial() {
        this.o.showInterstitial();
    }

    private static final class a
    implements CustomEventBannerListener {
        private final MediationBannerListener k;
        private final CustomEventAdapter p;

        public a(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.p = customEventAdapter;
            this.k = mediationBannerListener;
        }

        @Override
        public void onClick() {
            cs.r("Custom event adapter called onFailedToReceiveAd.");
            this.k.onClick(this.p);
        }

        @Override
        public void onDismissScreen() {
            cs.r("Custom event adapter called onFailedToReceiveAd.");
            this.k.onDismissScreen(this.p);
        }

        @Override
        public void onFailedToReceiveAd() {
            cs.r("Custom event adapter called onFailedToReceiveAd.");
            this.k.onFailedToReceiveAd(this.p, AdRequest.ErrorCode.NO_FILL);
        }

        @Override
        public void onLeaveApplication() {
            cs.r("Custom event adapter called onFailedToReceiveAd.");
            this.k.onLeaveApplication(this.p);
        }

        @Override
        public void onPresentScreen() {
            cs.r("Custom event adapter called onFailedToReceiveAd.");
            this.k.onPresentScreen(this.p);
        }

        @Override
        public void onReceivedAd(View view) {
            cs.r("Custom event adapter called onReceivedAd.");
            this.p.a(view);
            this.k.onReceivedAd(this.p);
        }
    }

    private class b
    implements CustomEventInterstitialListener {
        private final MediationInterstitialListener l;
        private final CustomEventAdapter p;

        public b(CustomEventAdapter customEventAdapter2, MediationInterstitialListener mediationInterstitialListener) {
            this.p = customEventAdapter2;
            this.l = mediationInterstitialListener;
        }

        @Override
        public void onDismissScreen() {
            cs.r("Custom event adapter called onDismissScreen.");
            this.l.onDismissScreen(this.p);
        }

        @Override
        public void onFailedToReceiveAd() {
            cs.r("Custom event adapter called onFailedToReceiveAd.");
            this.l.onFailedToReceiveAd(this.p, AdRequest.ErrorCode.NO_FILL);
        }

        @Override
        public void onLeaveApplication() {
            cs.r("Custom event adapter called onLeaveApplication.");
            this.l.onLeaveApplication(this.p);
        }

        @Override
        public void onPresentScreen() {
            cs.r("Custom event adapter called onPresentScreen.");
            this.l.onPresentScreen(this.p);
        }

        @Override
        public void onReceivedAd() {
            cs.r("Custom event adapter called onReceivedAd.");
            this.l.onReceivedAd(CustomEventAdapter.this);
        }
    }
}

