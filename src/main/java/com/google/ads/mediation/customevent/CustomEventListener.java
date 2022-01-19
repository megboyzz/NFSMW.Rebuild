/*
 * Decompiled with CFR 0.152.
 */
package com.google.ads.mediation.customevent;

@Deprecated
public interface CustomEventListener {
    public void onDismissScreen();

    public void onFailedToReceiveAd();

    public void onLeaveApplication();

    public void onPresentScreen();
}

