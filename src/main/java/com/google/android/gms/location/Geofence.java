/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 */
package com.google.android.gms.location;

import android.os.SystemClock;
import com.google.android.gms.internal.fn;

public interface Geofence {
    public static final int GEOFENCE_TRANSITION_DWELL = 4;
    public static final int GEOFENCE_TRANSITION_ENTER = 1;
    public static final int GEOFENCE_TRANSITION_EXIT = 2;
    public static final long NEVER_EXPIRE = -1L;

    public String getRequestId();

    public static final class Builder {
        private long tA = Long.MIN_VALUE;
        private short tB = (short)-1;
        private double tC;
        private double tD;
        private float tE;
        private int tF = 0;
        private int tG = -1;
        private String ty = null;
        private int tz = 0;

        public Geofence build() {
            if (this.ty == null) {
                throw new IllegalArgumentException("Request ID not set.");
            }
            if (this.tz == 0) {
                throw new IllegalArgumentException("Transitions types not set.");
            }
            if ((this.tz & 4) != 0 && this.tG < 0) {
                throw new IllegalArgumentException("Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELLING.");
            }
            if (this.tA == Long.MIN_VALUE) {
                throw new IllegalArgumentException("Expiration not set.");
            }
            if (this.tB == -1) {
                throw new IllegalArgumentException("Geofence region not set.");
            }
            if (this.tF >= 0) return new fn(this.ty, this.tz, 1, this.tC, this.tD, this.tE, this.tA, this.tF, this.tG);
            throw new IllegalArgumentException("Notification responsiveness should be nonnegative.");
        }

        public Builder setCircularRegion(double d2, double d3, float f2) {
            this.tB = 1;
            this.tC = d2;
            this.tD = d3;
            this.tE = f2;
            return this;
        }

        public Builder setExpirationDuration(long l2) {
            if (l2 < 0L) {
                this.tA = -1L;
                return this;
            }
            this.tA = SystemClock.elapsedRealtime() + l2;
            return this;
        }

        public Builder setLoiteringDelay(int n2) {
            this.tG = n2;
            return this;
        }

        public Builder setNotificationResponsiveness(int n2) {
            this.tF = n2;
            return this;
        }

        public Builder setRequestId(String string2) {
            this.ty = string2;
            return this;
        }

        public Builder setTransitionTypes(int n2) {
            this.tz = n2;
            return this;
        }
    }
}

