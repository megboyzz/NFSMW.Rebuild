/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.location;

public final class LocationStatusCodes {
    public static final int ERROR = 1;
    public static final int GEOFENCE_NOT_AVAILABLE = 1000;
    public static final int GEOFENCE_TOO_MANY_GEOFENCES = 1001;
    public static final int GEOFENCE_TOO_MANY_PENDING_INTENTS = 1002;
    public static final int SUCCESS = 0;

    private LocationStatusCodes() {
    }

    public static int aD(int n2) {
        if (n2 >= 0) {
            if (n2 <= 1) return n2;
        }
        if (1000 > n2) return 1;
        if (n2 > 1002) return 1;
        return n2;
    }
}

