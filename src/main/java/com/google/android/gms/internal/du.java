/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  android.text.TextUtils
 */
package com.google.android.gms.internal;

import android.os.Looper;
import android.text.TextUtils;

public final class du {
    public static void B(String string2) {
        if (Looper.myLooper() == Looper.getMainLooper()) return;
        throw new IllegalStateException(string2);
    }

    public static void C(String string2) {
        if (Looper.myLooper() != Looper.getMainLooper()) return;
        throw new IllegalStateException(string2);
    }

    public static String I(String string2) {
        if (!TextUtils.isEmpty((CharSequence)string2)) return string2;
        throw new IllegalArgumentException("Given String is empty or null");
    }

    public static void a(boolean bl2, Object object) {
        if (bl2) return;
        throw new IllegalStateException(String.valueOf(object));
    }

    public static void a(boolean bl2, String string2, Object ... objectArray) {
        if (bl2) return;
        throw new IllegalArgumentException(String.format(string2, objectArray));
    }

    public static void b(boolean bl2, Object object) {
        if (bl2) return;
        throw new IllegalArgumentException(String.valueOf(object));
    }

    public static <T> T c(T t2, Object object) {
        if (t2 != null) return t2;
        throw new NullPointerException(String.valueOf(object));
    }

    public static <T> T f(T t2) {
        if (t2 != null) return t2;
        throw new NullPointerException("null reference");
    }

    public static void n(boolean bl2) {
        if (bl2) return;
        throw new IllegalStateException();
    }

    public static void p(boolean bl2) {
        if (bl2) return;
        throw new IllegalArgumentException();
    }
}

