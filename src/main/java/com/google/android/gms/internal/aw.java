/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal;

import com.google.android.gms.internal.av;
import com.google.android.gms.internal.ay;
import com.google.android.gms.internal.bd;

public final class aw
extends bd.a {
    private ay.a fP;
    private av fQ;
    private final Object fx = new Object();

    public void a(av av2) {
        Object object = this.fx;
        synchronized (object) {
            this.fQ = av2;
            return;
        }
    }

    public void a(ay.a a2) {
        Object object = this.fx;
        synchronized (object) {
            this.fP = a2;
            return;
        }
    }

    @Override
    public void onAdClosed() {
        Object object = this.fx;
        synchronized (object) {
            if (this.fQ == null) return;
            this.fQ.D();
            return;
        }
    }

    @Override
    public void onAdFailedToLoad(int n2) {
        Object object = this.fx;
        synchronized (object) {
            if (this.fP == null) return;
            n2 = n2 == 3 ? 1 : 2;
            this.fP.f(n2);
            this.fP = null;
            return;
        }
    }

    @Override
    public void onAdLeftApplication() {
        Object object = this.fx;
        synchronized (object) {
            if (this.fQ == null) return;
            this.fQ.E();
            return;
        }
    }

    @Override
    public void onAdLoaded() {
        Object object = this.fx;
        synchronized (object) {
            if (this.fP != null) {
                this.fP.f(0);
                this.fP = null;
                return;
            }
            if (this.fQ == null) return;
            this.fQ.G();
            return;
        }
    }

    @Override
    public void onAdOpened() {
        Object object = this.fx;
        synchronized (object) {
            if (this.fQ == null) return;
            this.fQ.F();
            return;
        }
    }

    @Override
    public void w() {
        Object object = this.fx;
        synchronized (object) {
            if (this.fQ == null) return;
            this.fQ.C();
            return;
        }
    }
}

