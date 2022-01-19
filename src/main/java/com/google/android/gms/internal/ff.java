/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal;

public final class ff {
    public static String at(int n2) {
        switch (n2) {
            default: {
                throw new IllegalArgumentException("Unknown leaderboard collection: " + n2);
            }
            case 0: {
                return "PUBLIC";
            }
            case 1: 
        }
        return "SOCIAL";
    }
}

