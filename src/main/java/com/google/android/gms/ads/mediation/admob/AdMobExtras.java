/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.google.android.gms.ads.mediation.admob;

import android.os.Bundle;
import com.google.ads.mediation.NetworkExtras;

public final class AdMobExtras
implements NetworkExtras {
    private final Bundle je;

    public AdMobExtras(Bundle object) {
        object = object != null ? new Bundle(object) : null;
        this.je = object;
    }

    public Bundle getExtras() {
        return this.je;
    }
}

