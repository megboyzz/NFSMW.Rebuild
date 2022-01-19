/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.google.android.gms.internal;

import android.util.Log;

public final class cs {
    public static void a(String string2, Throwable throwable) {
        if (!cs.n(3)) return;
        Log.d((String)"Ads", (String)string2, (Throwable)throwable);
    }

    public static void b(String string2, Throwable throwable) {
        if (!cs.n(5)) return;
        Log.w((String)"Ads", (String)string2, (Throwable)throwable);
    }

    public static boolean n(int n2) {
        if (n2 < 5) {
            if (!Log.isLoggable((String)"Ads", (int)n2)) return false;
        }
        if (n2 != 2) return true;
        return false;
    }

    public static void r(String string2) {
        if (!cs.n(3)) return;
        Log.d((String)"Ads", (String)string2);
    }

    public static void s(String string2) {
        if (!cs.n(6)) return;
        Log.e((String)"Ads", (String)string2);
    }

    public static void t(String string2) {
        if (!cs.n(4)) return;
        Log.i((String)"Ads", (String)string2);
    }

    public static void u(String string2) {
        if (!cs.n(2)) return;
        Log.v((String)"Ads", (String)string2);
    }

    public static void v(String string2) {
        if (!cs.n(5)) return;
        Log.w((String)"Ads", (String)string2);
    }
}

