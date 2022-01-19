/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal;

import com.google.android.gms.internal.fa;

public final class fi {
    public static String at(int n2) {
        switch (n2) {
            default: {
                fa.b("MatchTurnStatus", "Unknown match turn status: " + n2);
                return "TURN_STATUS_UNKNOWN";
            }
            case 0: {
                return "TURN_STATUS_INVITED";
            }
            case 1: {
                return "TURN_STATUS_MY_TURN";
            }
            case 2: {
                return "TURN_STATUS_THEIR_TURN";
            }
            case 3: 
        }
        return "TURN_STATUS_COMPLETE";
    }
}

