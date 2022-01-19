/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 */
package com.google.android.gms.internal;

import android.os.Build;

public final class es {
    private static boolean K(int n2) {
        if (Build.VERSION.SDK_INT < n2) return false;
        return true;
    }

    public static boolean ck() {
        return es.K(11);
    }

    public static boolean cl() {
        return es.K(12);
    }

    public static boolean cm() {
        return es.K(13);
    }

    public static boolean cn() {
        return es.K(14);
    }

    public static boolean co() {
        return es.K(16);
    }

    public static boolean cp() {
        return es.K(17);
    }
}

