/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.ads.mediation.customevent;

import com.google.ads.mediation.NetworkExtras;
import java.util.HashMap;

public final class CustomEventExtras
implements NetworkExtras {
    private final HashMap<String, Object> jf = new HashMap();

    public Object getExtra(String string) {
        return this.jf.get(string);
    }

    public void setExtra(String string, Object object) {
        this.jf.put(string, object);
    }
}

