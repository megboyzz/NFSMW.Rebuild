/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.RemoteException
 *  org.json.JSONObject
 */
package com.google.android.gms.internal;

import android.app.Activity;
import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.ads.mediation.admob.AdMobServerParameters;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.c;
import com.google.android.gms.internal.bc;
import com.google.android.gms.internal.bd;
import com.google.android.gms.internal.bf;
import com.google.android.gms.internal.bg;
import com.google.android.gms.internal.cs;
import com.google.android.gms.internal.v;
import com.google.android.gms.internal.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class be<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters>
extends bc.a {
    private final MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> gf;
    private final NETWORK_EXTRAS gg;

    public be(MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter, NETWORK_EXTRAS NETWORK_EXTRAS) {
        this.gf = mediationAdapter;
        this.gg = NETWORK_EXTRAS;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    private SERVER_PARAMETERS a(String var1_1, int var2_3, String var3_4) throws RemoteException {
        if (var1_1 == null) ** GOTO lbl26
        try {
            var4_5 = new JSONObject((String)var1_1);
            var1_1 = new HashMap<String, String>(var4_5.length());
            var5_6 = var4_5.keys();
            while (var5_6.hasNext()) {
                var6_7 = (String)var5_6.next();
                var1_1.put(var6_7, var4_5.getString(var6_7));
            }
        }
        catch (Throwable var1_2) {
            cs.b("Could not get MediationServerParameters.", var1_2);
            throw new RemoteException();
        }
lbl-1000:
        // 2 sources

        {
            while (true) {
                var5_6 = this.gf.getServerParametersType();
                var4_5 = null;
                if (var5_6 != null) {
                    var4_5 = (MediationServerParameters)var5_6.newInstance();
                    var4_5.load((Map<String, String>)var1_1);
                }
                if (var4_5 instanceof AdMobServerParameters == false) return (SERVER_PARAMETERS)var4_5;
                var1_1 = (AdMobServerParameters)var4_5;
                var1_1.adJson = var3_4;
                var1_1.tagForChildDirectedTreatment = var2_3;
                return (SERVER_PARAMETERS)var4_5;
            }
lbl26:
            // 1 sources

            var1_1 = new HashMap<K, V>(0);
            ** continue;
        }
    }

    @Override
    public void a(b b2, v v2, String string2, bd bd2) throws RemoteException {
        this.a(b2, v2, string2, null, bd2);
    }

    @Override
    public void a(b b2, v v2, String string2, String string3, bd bd2) throws RemoteException {
        if (!(this.gf instanceof MediationInterstitialAdapter)) {
            cs.v("MediationAdapter is not a MediationInterstitialAdapter: " + this.gf.getClass().getCanonicalName());
            throw new RemoteException();
        }
        cs.r("Requesting interstitial ad from adapter.");
        try {
            ((MediationInterstitialAdapter)this.gf).requestInterstitialAd(new bf(bd2), (Activity)c.b(b2), this.a(string2, v2.tagForChildDirectedTreatment, string3), bg.e(v2), this.gg);
            return;
        }
        catch (Throwable throwable) {
            cs.b("Could not request interstitial ad from adapter.", throwable);
            throw new RemoteException();
        }
    }

    @Override
    public void a(b b2, x x2, v v2, String string2, bd bd2) throws RemoteException {
        this.a(b2, x2, v2, string2, null, bd2);
    }

    @Override
    public void a(b b2, x x2, v v2, String string2, String string3, bd bd2) throws RemoteException {
        if (!(this.gf instanceof MediationBannerAdapter)) {
            cs.v("MediationAdapter is not a MediationBannerAdapter: " + this.gf.getClass().getCanonicalName());
            throw new RemoteException();
        }
        cs.r("Requesting banner ad from adapter.");
        try {
            ((MediationBannerAdapter)this.gf).requestBannerAd(new bf(bd2), (Activity)c.b(b2), this.a(string2, v2.tagForChildDirectedTreatment, string3), bg.b(x2), bg.e(v2), this.gg);
            return;
        }
        catch (Throwable throwable) {
            cs.b("Could not request banner ad from adapter.", throwable);
            throw new RemoteException();
        }
    }

    @Override
    public void destroy() throws RemoteException {
        try {
            this.gf.destroy();
            return;
        }
        catch (Throwable throwable) {
            cs.b("Could not destroy adapter.", throwable);
            throw new RemoteException();
        }
    }

    @Override
    public b getView() throws RemoteException {
        if (!(this.gf instanceof MediationBannerAdapter)) {
            cs.v("MediationAdapter is not a MediationBannerAdapter: " + this.gf.getClass().getCanonicalName());
            throw new RemoteException();
        }
        try {
            return c.h(((MediationBannerAdapter)this.gf).getBannerView());
        }
        catch (Throwable throwable) {
            cs.b("Could not get banner view from adapter.", throwable);
            throw new RemoteException();
        }
    }

    @Override
    public void showInterstitial() throws RemoteException {
        if (!(this.gf instanceof MediationInterstitialAdapter)) {
            cs.v("MediationAdapter is not a MediationInterstitialAdapter: " + this.gf.getClass().getCanonicalName());
            throw new RemoteException();
        }
        cs.r("Showing interstitial from adapter.");
        try {
            ((MediationInterstitialAdapter)this.gf).showInterstitial();
            return;
        }
        catch (Throwable throwable) {
            cs.b("Could not show interstitial from adapter.", throwable);
            throw new RemoteException();
        }
    }
}

