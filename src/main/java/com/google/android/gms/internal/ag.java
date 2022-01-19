/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.RemoteException
 *  android.view.View
 *  android.view.ViewGroup
 */
package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.c;
import com.google.android.gms.internal.aa;
import com.google.android.gms.internal.ab;
import com.google.android.gms.internal.ac;
import com.google.android.gms.internal.ae;
import com.google.android.gms.internal.af;
import com.google.android.gms.internal.ba;
import com.google.android.gms.internal.cr;
import com.google.android.gms.internal.cs;
import com.google.android.gms.internal.t;
import com.google.android.gms.internal.u;
import com.google.android.gms.internal.v;
import com.google.android.gms.internal.x;
import com.google.android.gms.internal.z;

public final class ag {
    private AppEventListener eI;
    private AdSize[] eJ;
    private String eK;
    private final ba eW = new ba();
    private ac eX;
    private ViewGroup eY;
    private AdListener ev;

    public ag(ViewGroup viewGroup) {
        this.eY = viewGroup;
    }

    public ag(ViewGroup viewGroup, AttributeSet object, boolean bl2) {
        this.eY = viewGroup;
        Context context = viewGroup.getContext();
        try {
            object = new aa(context, (AttributeSet)object);
            this.eJ = ((aa)object).c(bl2);
            this.eK = ((aa)object).getAdUnitId();
        }
        catch (IllegalArgumentException illegalArgumentException) {
            cr.a(viewGroup, new x(context, AdSize.BANNER), illegalArgumentException.getMessage(), illegalArgumentException.getMessage());
            return;
        }
        if (!viewGroup.isInEditMode()) return;
        cr.a(viewGroup, new x(context, this.eJ[0]), "Ads by Google");
    }

    private void T() {
        try {
            b b2 = this.eX.x();
            if (b2 == null) {
                return;
            }
            this.eY.addView((View)c.b(b2));
            return;
        }
        catch (RemoteException remoteException) {
            cs.b("Failed to get an ad frame.", remoteException);
            return;
        }
    }

    private void U() throws RemoteException {
        if ((this.eJ == null || this.eK == null) && this.eX == null) {
            throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
        }
        Context context = this.eY.getContext();
        this.eX = u.a(context, new x(context, this.eJ), this.eK, this.eW);
        if (this.ev != null) {
            this.eX.a(new t(this.ev));
        }
        if (this.eI != null) {
            this.eX.a(new z(this.eI));
        }
        this.T();
    }

    public void a(af af2) {
        try {
            if (this.eX == null) {
                this.U();
            }
            if (!this.eX.a(new v(this.eY.getContext(), af2))) return;
            this.eW.c(af2.R());
            return;
        }
        catch (RemoteException remoteException) {
            cs.b("Failed to load ad.", remoteException);
            return;
        }
    }

    public void a(AdSize ... adSizeArray) {
        this.eJ = adSizeArray;
        try {
            if (this.eX != null) {
                this.eX.a(new x(this.eY.getContext(), this.eJ));
            }
        }
        catch (RemoteException remoteException) {
            cs.b("Failed to set the ad size.", remoteException);
        }
        this.eY.requestLayout();
    }

    public void destroy() {
        try {
            if (this.eX == null) return;
            this.eX.destroy();
            return;
        }
        catch (RemoteException remoteException) {
            cs.b("Failed to destroy AdView.", remoteException);
            return;
        }
    }

    public AdListener getAdListener() {
        return this.ev;
    }

    public AdSize getAdSize() {
        try {
            if (this.eX != null) {
                return this.eX.y().P();
            }
        }
        catch (RemoteException remoteException) {
            cs.b("Failed to get the current AdSize.", remoteException);
        }
        if (this.eJ == null) return null;
        return this.eJ[0];
    }

    public AdSize[] getAdSizes() {
        return this.eJ;
    }

    public String getAdUnitId() {
        return this.eK;
    }

    public AppEventListener getAppEventListener() {
        return this.eI;
    }

    public void pause() {
        try {
            if (this.eX == null) return;
            this.eX.pause();
            return;
        }
        catch (RemoteException remoteException) {
            cs.b("Failed to call pause.", remoteException);
            return;
        }
    }

    public void recordManualImpression() {
        try {
            this.eX.H();
            return;
        }
        catch (RemoteException remoteException) {
            cs.b("Failed to record impression.", remoteException);
            return;
        }
    }

    public void resume() {
        try {
            if (this.eX == null) return;
            this.eX.resume();
            return;
        }
        catch (RemoteException remoteException) {
            cs.b("Failed to call resume.", remoteException);
            return;
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

    public void setAdSizes(AdSize ... adSizeArray) {
        if (this.eJ != null) {
            throw new IllegalStateException("The ad size can only be set once on AdView.");
        }
        this.a(adSizeArray);
    }

    public void setAdUnitId(String string2) {
        if (this.eK != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
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
}

