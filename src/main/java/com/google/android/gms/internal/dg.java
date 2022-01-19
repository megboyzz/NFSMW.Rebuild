/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  android.util.Log
 */
package com.google.android.gms.internal;

import android.os.Looper;
import android.util.Log;

public final class dg {
    public static void B(String string2) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) return;
        Log.e((String)"Asserts", (String)("checkMainThread: current thread " + Thread.currentThread() + " IS NOT the main thread " + Looper.getMainLooper().getThread() + "!"));
        throw new IllegalStateException(string2);
    }

    public static void C(String string2) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) return;
        Log.e((String)"Asserts", (String)("checkNotMainThread: current thread " + Thread.currentThread() + " IS the main thread " + Looper.getMainLooper().getThread() + "!"));
        throw new IllegalStateException(string2);
    }

    public static void a(boolean bl2, Object object) {
        if (bl2) return;
        throw new IllegalStateException(String.valueOf(object));
    }

    public static void d(Object object) {
        if (object != null) return;
        throw new IllegalArgumentException("null reference");
    }

    public static void n(boolean bl2) {
        if (bl2) return;
        throw new IllegalStateException();
    }
}

