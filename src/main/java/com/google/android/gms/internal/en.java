/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 */
package com.google.android.gms.internal;

import android.util.Base64;

public final class en {
    public static String b(byte[] byArray) {
        if (byArray != null) return Base64.encodeToString((byte[])byArray, (int)0);
        return null;
    }

    public static String c(byte[] byArray) {
        if (byArray != null) return Base64.encodeToString((byte[])byArray, (int)10);
        return null;
    }
}

