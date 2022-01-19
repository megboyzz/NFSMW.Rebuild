/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.internal.ae;

public final class z
extends ae.a {
    private final AppEventListener eI;

    public z(AppEventListener appEventListener) {
        this.eI = appEventListener;
    }

    @Override
    public void onAppEvent(String string2, String string3) {
        this.eI.onAppEvent(string2, string3);
    }
}

