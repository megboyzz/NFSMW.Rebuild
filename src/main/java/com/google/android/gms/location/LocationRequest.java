/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.SystemClock
 */
package com.google.android.gms.location;

import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ds;
import com.google.android.gms.location.LocationRequestCreator;

public final class LocationRequest
implements SafeParcelable {
    public static final LocationRequestCreator CREATOR = new LocationRequestCreator();
    public static final int PRIORITY_BALANCED_POWER_ACCURACY = 102;
    public static final int PRIORITY_HIGH_ACCURACY = 100;
    public static final int PRIORITY_LOW_POWER = 104;
    public static final int PRIORITY_NO_POWER = 105;
    private final int kZ;
    int mPriority;
    long tA;
    long tH;
    long tI;
    boolean tJ;
    int tK;
    float tL;

    public LocationRequest() {
        this.kZ = 1;
        this.mPriority = 102;
        this.tH = 3600000L;
        this.tI = 600000L;
        this.tJ = false;
        this.tA = Long.MAX_VALUE;
        this.tK = Integer.MAX_VALUE;
        this.tL = 0.0f;
    }

    LocationRequest(int n2, int n3, long l2, long l3, boolean bl2, long l4, int n4, float f2) {
        this.kZ = n2;
        this.mPriority = n3;
        this.tH = l2;
        this.tI = l3;
        this.tJ = bl2;
        this.tA = l4;
        this.tK = n4;
        this.tL = f2;
    }

    private static void a(float f2) {
        if (!(f2 < 0.0f)) return;
        throw new IllegalArgumentException("invalid displacement: " + f2);
    }

    private static void aB(int n2) {
        switch (n2) {
            default: {
                throw new IllegalArgumentException("invalid quality: " + n2);
            }
            case 100: 
            case 102: 
            case 104: 
            case 105: 
        }
    }

    public static String aC(int n2) {
        switch (n2) {
            default: {
                return "???";
            }
            case 100: {
                return "PRIORITY_HIGH_ACCURACY";
            }
            case 102: {
                return "PRIORITY_BALANCED_POWER_ACCURACY";
            }
            case 104: {
                return "PRIORITY_LOW_POWER";
            }
            case 105: 
        }
        return "PRIORITY_NO_POWER";
    }

    public static LocationRequest create() {
        return new LocationRequest();
    }

    private static void i(long l2) {
        if (l2 >= 0L) return;
        throw new IllegalArgumentException("invalid interval: " + l2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof LocationRequest)) {
            return false;
        }
        object = (LocationRequest)object;
        if (this.mPriority != ((LocationRequest)object).mPriority) return false;
        if (this.tH != ((LocationRequest)object).tH) return false;
        if (this.tI != ((LocationRequest)object).tI) return false;
        if (this.tJ != ((LocationRequest)object).tJ) return false;
        if (this.tA != ((LocationRequest)object).tA) return false;
        if (this.tK != ((LocationRequest)object).tK) return false;
        if (this.tL == ((LocationRequest)object).tL) return true;
        return false;
    }

    public long getExpirationTime() {
        return this.tA;
    }

    public long getFastestInterval() {
        return this.tI;
    }

    public long getInterval() {
        return this.tH;
    }

    public int getNumUpdates() {
        return this.tK;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public float getSmallestDisplacement() {
        return this.tL;
    }

    int getVersionCode() {
        return this.kZ;
    }

    public int hashCode() {
        return ds.hashCode(this.mPriority, this.tH, this.tI, this.tJ, this.tA, this.tK, Float.valueOf(this.tL));
    }

    public LocationRequest setExpirationDuration(long l2) {
        long l3 = SystemClock.elapsedRealtime();
        this.tA = l2 > Long.MAX_VALUE - l3 ? Long.MAX_VALUE : l3 + l2;
        if (this.tA >= 0L) return this;
        this.tA = 0L;
        return this;
    }

    public LocationRequest setExpirationTime(long l2) {
        this.tA = l2;
        if (this.tA >= 0L) return this;
        this.tA = 0L;
        return this;
    }

    public LocationRequest setFastestInterval(long l2) {
        LocationRequest.i(l2);
        this.tJ = true;
        this.tI = l2;
        return this;
    }

    public LocationRequest setInterval(long l2) {
        LocationRequest.i(l2);
        this.tH = l2;
        if (this.tJ) return this;
        this.tI = (long)((double)this.tH / 6.0);
        return this;
    }

    public LocationRequest setNumUpdates(int n2) {
        if (n2 <= 0) {
            throw new IllegalArgumentException("invalid numUpdates: " + n2);
        }
        this.tK = n2;
        return this;
    }

    public LocationRequest setPriority(int n2) {
        LocationRequest.aB(n2);
        this.mPriority = n2;
        return this;
    }

    public LocationRequest setSmallestDisplacement(float f2) {
        LocationRequest.a(f2);
        this.tL = f2;
        return this;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Request[").append(LocationRequest.aC(this.mPriority));
        if (this.mPriority != 105) {
            stringBuilder.append(" requested=");
            stringBuilder.append(this.tH + "ms");
        }
        stringBuilder.append(" fastest=");
        stringBuilder.append(this.tI + "ms");
        if (this.tA != Long.MAX_VALUE) {
            long l2 = this.tA;
            long l3 = SystemClock.elapsedRealtime();
            stringBuilder.append(" expireIn=");
            stringBuilder.append(l2 - l3 + "ms");
        }
        if (this.tK != Integer.MAX_VALUE) {
            stringBuilder.append(" num=").append(this.tK);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n2) {
        LocationRequestCreator.a(this, parcel, n2);
    }
}

