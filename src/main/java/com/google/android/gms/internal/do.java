/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.internal.du;

public final class do {
    private final String ng;

    public do(String string2) {
        this.ng = du.f(string2);
    }

    public void a(String string2, String string3) {
        if (!this.y(5)) return;
        Log.w((String)string2, (String)string3);
    }

    public void a(String string2, String string3, Throwable throwable) {
        if (!this.y(6)) return;
        Log.e((String)string2, (String)string3, (Throwable)throwable);
    }

    public void b(String string2, String string3) {
        if (!this.y(6)) return;
        Log.e((String)string2, (String)string3);
    }

    public boolean y(int n2) {
        return Log.isLoggable((String)this.ng, (int)n2);
    }
}

