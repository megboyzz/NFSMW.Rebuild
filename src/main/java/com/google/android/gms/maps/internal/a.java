/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.maps.internal;

public final class a {
    public static Boolean a(byte by2) {
        switch (by2) {
            default: {
                return null;
            }
            case 1: {
                return Boolean.TRUE;
            }
            case 0: 
        }
        return Boolean.FALSE;
    }

    public static byte c(Boolean bl2) {
        if (bl2 == null) return -1;
        if (bl2 == false) return 0;
        return 1;
    }
}

