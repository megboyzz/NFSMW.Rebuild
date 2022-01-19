/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal;

public final class fh {
    public static String at(int n2) {
        switch (n2) {
            default: {
                throw new IllegalArgumentException("Unknown time span " + n2);
            }
            case 0: {
                return "DAILY";
            }
            case 1: {
                return "WEEKLY";
            }
            case 2: 
        }
        return "ALL_TIME";
    }
}

