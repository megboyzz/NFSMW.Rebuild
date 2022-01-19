/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.internal.ab;

public final class t
extends ab.a {
    private final AdListener ev;

    public t(AdListener adListener) {
        this.ev = adListener;
    }

    @Override
    public void onAdClosed() {
        this.ev.onAdClosed();
    }

    @Override
    public void onAdFailedToLoad(int n2) {
        this.ev.onAdFailedToLoad(n2);
    }

    @Override
    public void onAdLeftApplication() {
        this.ev.onAdLeftApplication();
    }

    @Override
    public void onAdLoaded() {
        this.ev.onAdLoaded();
    }

    @Override
    public void onAdOpened() {
        this.ev.onAdOpened();
    }
}

