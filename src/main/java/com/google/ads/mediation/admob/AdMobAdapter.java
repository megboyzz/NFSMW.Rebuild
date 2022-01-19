/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.view.View
 */
package com.google.ads.mediation.admob;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.admob.AdMobServerParameters;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.internal.bg;
import com.google.android.gms.internal.cr;
import java.util.Date;

public final class AdMobAdapter
implements MediationBannerAdapter<AdMobExtras, AdMobServerParameters>,
MediationInterstitialAdapter<AdMobExtras, AdMobServerParameters> {
    private AdView h;
    private InterstitialAd i;

    private static AdRequest a(Context context, MediationAdRequest mediationAdRequest, AdMobExtras adMobExtras, AdMobServerParameters adMobServerParameters) {
        AdRequest.Builder builder = new AdRequest.Builder();
        Object object = mediationAdRequest.getBirthday();
        if (object != null) {
            builder.setBirthday((Date)object);
        }
        if ((object = mediationAdRequest.getGender()) != null) {
            builder.setGender(bg.a((AdRequest.Gender)((Object)object)));
        }
        if ((object = mediationAdRequest.getKeywords()) != null) {
            object = object.iterator();
            while (object.hasNext()) {
                builder.addKeyword((String)object.next());
            }
        }
        if (mediationAdRequest.isTesting()) {
            builder.addTestDevice(cr.l(context));
        }
        if (adMobServerParameters.tagForChildDirectedTreatment != -1) {
            boolean bl2 = adMobServerParameters.tagForChildDirectedTreatment == 1;
            builder.tagForChildDirectedTreatment(bl2);
        }
        if (adMobExtras == null) {
            adMobExtras = new AdMobExtras(new Bundle());
        }
        context = adMobExtras.getExtras();
        context.putInt("gw", 1);
        context.putString("mad_hac", adMobServerParameters.allowHouseAds);
        if (!TextUtils.isEmpty((CharSequence)adMobServerParameters.adJson)) {
            context.putString("_ad", adMobServerParameters.adJson);
        }
        context.putBoolean("_noRefresh", true);
        builder.addNetworkExtras(adMobExtras);
        return builder.build();
    }

    @Override
    public void destroy() {
        if (this.h != null) {
            this.h.destroy();
            this.h = null;
        }
        if (this.i == null) return;
        this.i = null;
    }

    @Override
    public Class<AdMobExtras> getAdditionalParametersType() {
        return AdMobExtras.class;
    }

    @Override
    public View getBannerView() {
        return this.h;
    }

    @Override
    public Class<AdMobServerParameters> getServerParametersType() {
        return AdMobServerParameters.class;
    }

    @Override
    public void requestBannerAd(MediationBannerListener mediationBannerListener, Activity activity, AdMobServerParameters adMobServerParameters, AdSize adSize, MediationAdRequest mediationAdRequest, AdMobExtras adMobExtras) {
        this.h = new AdView((Context)activity);
        this.h.setAdSize(new com.google.android.gms.ads.AdSize(adSize.getWidth(), adSize.getHeight()));
        this.h.setAdUnitId(adMobServerParameters.adUnitId);
        this.h.setAdListener(new a(this, mediationBannerListener));
        this.h.loadAd(AdMobAdapter.a((Context)activity, mediationAdRequest, adMobExtras, adMobServerParameters));
    }

    @Override
    public void requestInterstitialAd(MediationInterstitialListener mediationInterstitialListener, Activity activity, AdMobServerParameters adMobServerParameters, MediationAdRequest mediationAdRequest, AdMobExtras adMobExtras) {
        this.i = new InterstitialAd((Context)activity);
        this.i.setAdUnitId(adMobServerParameters.adUnitId);
        this.i.setAdListener(new b(this, mediationInterstitialListener));
        this.i.loadAd(AdMobAdapter.a((Context)activity, mediationAdRequest, adMobExtras, adMobServerParameters));
    }

    @Override
    public void showInterstitial() {
        this.i.show();
    }

    private static final class a
    extends AdListener {
        private final AdMobAdapter j;
        private final MediationBannerListener k;

        public a(AdMobAdapter adMobAdapter, MediationBannerListener mediationBannerListener) {
            this.j = adMobAdapter;
            this.k = mediationBannerListener;
        }

        @Override
        public void onAdClosed() {
            this.k.onDismissScreen(this.j);
        }

        @Override
        public void onAdFailedToLoad(int n2) {
            this.k.onFailedToReceiveAd(this.j, bg.h(n2));
        }

        @Override
        public void onAdLeftApplication() {
            this.k.onLeaveApplication(this.j);
        }

        @Override
        public void onAdLoaded() {
            this.k.onReceivedAd(this.j);
        }

        @Override
        public void onAdOpened() {
            this.k.onClick(this.j);
            this.k.onPresentScreen(this.j);
        }
    }

    private static final class b
    extends AdListener {
        private final AdMobAdapter j;
        private final MediationInterstitialListener l;

        public b(AdMobAdapter adMobAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.j = adMobAdapter;
            this.l = mediationInterstitialListener;
        }

        @Override
        public void onAdClosed() {
            this.l.onDismissScreen(this.j);
        }

        @Override
        public void onAdFailedToLoad(int n2) {
            this.l.onFailedToReceiveAd(this.j, bg.h(n2));
        }

        @Override
        public void onAdLeftApplication() {
            this.l.onLeaveApplication(this.j);
        }

        @Override
        public void onAdLoaded() {
            this.l.onReceivedAd(this.j);
        }

        @Override
        public void onAdOpened() {
            this.l.onPresentScreen(this.j);
        }
    }
}

