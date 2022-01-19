/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.RemoteException
 */
package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.internal.ab;
import com.google.android.gms.internal.ac;
import com.google.android.gms.internal.ae;
import com.google.android.gms.internal.af;
import com.google.android.gms.internal.ba;
import com.google.android.gms.internal.cs;
import com.google.android.gms.internal.t;
import com.google.android.gms.internal.u;
import com.google.android.gms.internal.v;
import com.google.android.gms.internal.x;
import com.google.android.gms.internal.z;

public final class ah {
    private AppEventListener eI;
    private String eK;
    private final ba eW = new ba();
    private ac eX;
    private AdListener ev;
    private final Context mContext;

    public ah(Context context) {
        this.mContext = context;
    }

    private void j(String string2) throws RemoteException {
        if (this.eK == null) {
            this.k(string2);
        }
        this.eX = u.a(this.mContext, new x(), this.eK, this.eW);
        if (this.ev != null) {
            this.eX.a(new t(this.ev));
        }
        if (this.eI == null) return;
        this.eX.a(new z(this.eI));
    }

    private void k(String string2) {
        if (this.eX != null) return;
        throw new IllegalStateException("The ad unit ID must be set on InterstitialAd before " + string2 + " is called.");
    }

    public void a(af af2) {
        try {
            if (this.eX == null) {
                this.j("loadAd");
            }
            if (!this.eX.a(new v(this.mContext, af2))) return;
            this.eW.c(af2.R());
            return;
        }
        catch (RemoteException remoteException) {
            cs.b("Failed to load ad.", remoteException);
            return;
        }
    }

    public AdListener getAdListener() {
        return this.ev;
    }

    public String getAdUnitId() {
        return this.eK;
    }

    public AppEventListener getAppEventListener() {
        return this.eI;
    }

    public boolean isLoaded() {
        try {
            if (this.eX != null) return this.eX.isReady();
            return false;
        }
        catch (RemoteException remoteException) {
            cs.b("Failed to check if ad is ready.", remoteException);
            return false;
        }
    }

    public void setAdListener(AdListener object) {
        try {
            this.ev = object;
            if (this.eX == null) return;
            ac ac2 = this.eX;
            object = object != null ? new t((AdListener)object) : null;
            ac2.a((ab)object);
            return;
        }
        catch (RemoteException remoteException) {
            cs.b("Failed to set the AdListener.", remoteException);
            return;
        }
    }

    public void setAdUnitId(String string2) {
        if (this.eK != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
        }
        this.eK = string2;
    }

    public void setAppEventListener(AppEventListener object) {
        try {
            this.eI = object;
            if (this.eX == null) return;
            ac ac2 = this.eX;
            object = object != null ? new z((AppEventListener)object) : null;
            ac2.a((ae)object);
            return;
        }
        catch (RemoteException remoteException) {
            cs.b("Failed to set the AppEventListener.", remoteException);
            return;
        }
    }

    public void show() {
        try {
            this.k("show");
            this.eX.showInterstitial();
            return;
        }
        catch (RemoteException remoteException) {
            cs.b("Failed to show interstitial.", remoteException);
            return;
        }
    }
}

