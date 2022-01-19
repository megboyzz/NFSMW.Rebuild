/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 */
package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.AdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.internal.bd;
import com.google.android.gms.internal.bg;
import com.google.android.gms.internal.cr;
import com.google.android.gms.internal.cs;

public final class bf<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters>
implements MediationBannerListener,
MediationInterstitialListener {
    private final bd gh;

    public bf(bd bd2) {
        this.gh = bd2;
    }

    @Override
    public void onClick(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        cs.r("Adapter called onClick.");
        if (!cr.ax()) {
            cs.v("onClick must be called on the main UI thread.");
            cr.iE.post(new Runnable(){

                @Override
                public void run() {
                    try {
                        bf.this.gh.w();
                        return;
                    }
                    catch (RemoteException remoteException) {
                        cs.b("Could not call onAdClicked.", remoteException);
                        return;
                    }
                }
            });
            return;
        }
        try {
            this.gh.w();
            return;
        }
        catch (RemoteException remoteException) {
            cs.b("Could not call onAdClicked.", remoteException);
            return;
        }
    }

    @Override
    public void onDismissScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        cs.r("Adapter called onDismissScreen.");
        if (!cr.ax()) {
            cs.v("onDismissScreen must be called on the main UI thread.");
            cr.iE.post(new Runnable(){

                @Override
                public void run() {
                    try {
                        bf.this.gh.onAdClosed();
                        return;
                    }
                    catch (RemoteException remoteException) {
                        cs.b("Could not call onAdClosed.", remoteException);
                        return;
                    }
                }
            });
            return;
        }
        try {
            this.gh.onAdClosed();
            return;
        }
        catch (RemoteException remoteException) {
            cs.b("Could not call onAdClosed.", remoteException);
            return;
        }
    }

    @Override
    public void onDismissScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        cs.r("Adapter called onDismissScreen.");
        if (!cr.ax()) {
            cs.v("onDismissScreen must be called on the main UI thread.");
            cr.iE.post(new Runnable(){

                @Override
                public void run() {
                    try {
                        bf.this.gh.onAdClosed();
                        return;
                    }
                    catch (RemoteException remoteException) {
                        cs.b("Could not call onAdClosed.", remoteException);
                        return;
                    }
                }
            });
            return;
        }
        try {
            this.gh.onAdClosed();
            return;
        }
        catch (RemoteException remoteException) {
            cs.b("Could not call onAdClosed.", remoteException);
            return;
        }
    }

    @Override
    public void onFailedToReceiveAd(MediationBannerAdapter<?, ?> mediationBannerAdapter, final AdRequest.ErrorCode errorCode) {
        cs.r("Adapter called onFailedToReceiveAd with error. " + (Object)((Object)errorCode));
        if (!cr.ax()) {
            cs.v("onFailedToReceiveAd must be called on the main UI thread.");
            cr.iE.post(new Runnable(){

                @Override
                public void run() {
                    try {
                        bf.this.gh.onAdFailedToLoad(bg.a(errorCode));
                        return;
                    }
                    catch (RemoteException remoteException) {
                        cs.b("Could not call onAdFailedToLoad.", remoteException);
                        return;
                    }
                }
            });
            return;
        }
        try {
            this.gh.onAdFailedToLoad(bg.a(errorCode));
            return;
        }
        catch (RemoteException remoteException) {
            cs.b("Could not call onAdFailedToLoad.", remoteException);
            return;
        }
    }

    @Override
    public void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, final AdRequest.ErrorCode errorCode) {
        cs.r("Adapter called onFailedToReceiveAd with error " + (Object)((Object)errorCode) + ".");
        if (!cr.ax()) {
            cs.v("onFailedToReceiveAd must be called on the main UI thread.");
            cr.iE.post(new Runnable(){

                @Override
                public void run() {
                    try {
                        bf.this.gh.onAdFailedToLoad(bg.a(errorCode));
                        return;
                    }
                    catch (RemoteException remoteException) {
                        cs.b("Could not call onAdFailedToLoad.", remoteException);
                        return;
                    }
                }
            });
            return;
        }
        try {
            this.gh.onAdFailedToLoad(bg.a(errorCode));
            return;
        }
        catch (RemoteException remoteException) {
            cs.b("Could not call onAdFailedToLoad.", remoteException);
            return;
        }
    }

    @Override
    public void onLeaveApplication(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        cs.r("Adapter called onLeaveApplication.");
        if (!cr.ax()) {
            cs.v("onLeaveApplication must be called on the main UI thread.");
            cr.iE.post(new Runnable(){

                @Override
                public void run() {
                    try {
                        bf.this.gh.onAdLeftApplication();
                        return;
                    }
                    catch (RemoteException remoteException) {
                        cs.b("Could not call onAdLeftApplication.", remoteException);
                        return;
                    }
                }
            });
            return;
        }
        try {
            this.gh.onAdLeftApplication();
            return;
        }
        catch (RemoteException remoteException) {
            cs.b("Could not call onAdLeftApplication.", remoteException);
            return;
        }
    }

    @Override
    public void onLeaveApplication(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        cs.r("Adapter called onLeaveApplication.");
        if (!cr.ax()) {
            cs.v("onLeaveApplication must be called on the main UI thread.");
            cr.iE.post(new Runnable(){

                @Override
                public void run() {
                    try {
                        bf.this.gh.onAdLeftApplication();
                        return;
                    }
                    catch (RemoteException remoteException) {
                        cs.b("Could not call onAdLeftApplication.", remoteException);
                        return;
                    }
                }
            });
            return;
        }
        try {
            this.gh.onAdLeftApplication();
            return;
        }
        catch (RemoteException remoteException) {
            cs.b("Could not call onAdLeftApplication.", remoteException);
            return;
        }
    }

    @Override
    public void onPresentScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        cs.r("Adapter called onPresentScreen.");
        if (!cr.ax()) {
            cs.v("onPresentScreen must be called on the main UI thread.");
            cr.iE.post(new Runnable(){

                @Override
                public void run() {
                    try {
                        bf.this.gh.onAdOpened();
                        return;
                    }
                    catch (RemoteException remoteException) {
                        cs.b("Could not call onAdOpened.", remoteException);
                        return;
                    }
                }
            });
            return;
        }
        try {
            this.gh.onAdOpened();
            return;
        }
        catch (RemoteException remoteException) {
            cs.b("Could not call onAdOpened.", remoteException);
            return;
        }
    }

    @Override
    public void onPresentScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        cs.r("Adapter called onPresentScreen.");
        if (!cr.ax()) {
            cs.v("onPresentScreen must be called on the main UI thread.");
            cr.iE.post(new Runnable(){

                @Override
                public void run() {
                    try {
                        bf.this.gh.onAdOpened();
                        return;
                    }
                    catch (RemoteException remoteException) {
                        cs.b("Could not call onAdOpened.", remoteException);
                        return;
                    }
                }
            });
            return;
        }
        try {
            this.gh.onAdOpened();
            return;
        }
        catch (RemoteException remoteException) {
            cs.b("Could not call onAdOpened.", remoteException);
            return;
        }
    }

    @Override
    public void onReceivedAd(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        cs.r("Adapter called onReceivedAd.");
        if (!cr.ax()) {
            cs.v("onReceivedAd must be called on the main UI thread.");
            cr.iE.post(new Runnable(){

                @Override
                public void run() {
                    try {
                        bf.this.gh.onAdLoaded();
                        return;
                    }
                    catch (RemoteException remoteException) {
                        cs.b("Could not call onAdLoaded.", remoteException);
                        return;
                    }
                }
            });
            return;
        }
        try {
            this.gh.onAdLoaded();
            return;
        }
        catch (RemoteException remoteException) {
            cs.b("Could not call onAdLoaded.", remoteException);
            return;
        }
    }

    @Override
    public void onReceivedAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        cs.r("Adapter called onReceivedAd.");
        if (!cr.ax()) {
            cs.v("onReceivedAd must be called on the main UI thread.");
            cr.iE.post(new Runnable(){

                @Override
                public void run() {
                    try {
                        bf.this.gh.onAdLoaded();
                        return;
                    }
                    catch (RemoteException remoteException) {
                        cs.b("Could not call onAdLoaded.", remoteException);
                        return;
                    }
                }
            });
            return;
        }
        try {
            this.gh.onAdLoaded();
            return;
        }
        catch (RemoteException remoteException) {
            cs.b("Could not call onAdLoaded.", remoteException);
            return;
        }
    }
}

