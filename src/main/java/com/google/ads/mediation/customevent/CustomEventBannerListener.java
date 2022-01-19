/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package com.google.ads.mediation.customevent;

import android.view.View;
import com.google.ads.mediation.customevent.CustomEventListener;

@Deprecated
public interface CustomEventBannerListener
extends CustomEventListener {
    public void onClick();

    public void onReceivedAd(View var1);
}

