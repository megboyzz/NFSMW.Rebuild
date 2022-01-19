/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 */
package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.fo;
import com.google.android.gms.location.Geofence;
import java.util.Locale;

public class fn
implements SafeParcelable,
Geofence {
    public static final fo CREATOR = new fo();
    private final int kZ;
    private final short tB;
    private final double tC;
    private final double tD;
    private final float tE;
    private final int tF;
    private final int tG;
    private final String ty;
    private final int tz;
    private final long ub;

    public fn(int n2, String string2, int n3, short s2, double d2, double d3, float f2, long l2, int n4, int n5) {
        fn.aa(string2);
        fn.b(f2);
        fn.a(d2, d3);
        n3 = fn.aE(n3);
        this.kZ = n2;
        this.tB = s2;
        this.ty = string2;
        this.tC = d2;
        this.tD = d3;
        this.tE = f2;
        this.ub = l2;
        this.tz = n3;
        this.tF = n4;
        this.tG = n5;
    }

    public fn(String string2, int n2, short s2, double d2, double d3, float f2, long l2, int n3, int n4) {
        this(1, string2, n2, s2, d2, d3, f2, l2, n3, n4);
    }

    private static void a(double d2, double d3) {
        if (d2 > 90.0) throw new IllegalArgumentException("invalid latitude: " + d2);
        if (d2 < -90.0) {
            throw new IllegalArgumentException("invalid latitude: " + d2);
        }
        if (d3 > 180.0) throw new IllegalArgumentException("invalid longitude: " + d3);
        if (!(d3 < -180.0)) return;
        throw new IllegalArgumentException("invalid longitude: " + d3);
    }

    private static int aE(int n2) {
        int n3 = n2 & 7;
        if (n3 != 0) return n3;
        throw new IllegalArgumentException("No supported transition specified: " + n2);
    }

    private static String aF(int n2) {
        switch (n2) {
            default: {
                return null;
            }
            case 1: 
        }
        return "CIRCLE";
    }

    private static void aa(String string2) {
        if (string2 == null) throw new IllegalArgumentException("requestId is null or too long: " + string2);
        if (string2.length() <= 100) return;
        throw new IllegalArgumentException("requestId is null or too long: " + string2);
    }

    private static void b(float f2) {
        if (!(f2 <= 0.0f)) return;
        throw new IllegalArgumentException("invalid radius: " + f2);
    }

    public static fn f(byte[] object) {
        Parcel parcel = Parcel.obtain();
        parcel.unmarshall(object, 0, ((byte[])object).length);
        parcel.setDataPosition(0);
        object = CREATOR.aa(parcel);
        parcel.recycle();
        return object;
    }

    public int describeContents() {
        fo fo2 = CREATOR;
        return 0;
    }

    public short ds() {
        return this.tB;
    }

    public float dt() {
        return this.tE;
    }

    public int du() {
        return this.tz;
    }

    public int dv() {
        return this.tG;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof fn)) {
            return false;
        }
        object = (fn)object;
        if (this.tE != ((fn)object).tE) {
            return false;
        }
        if (this.tC != ((fn)object).tC) {
            return false;
        }
        if (this.tD != ((fn)object).tD) {
            return false;
        }
        if (this.tB == ((fn)object).tB) return true;
        return false;
    }

    public long getExpirationTime() {
        return this.ub;
    }

    public double getLatitude() {
        return this.tC;
    }

    public double getLongitude() {
        return this.tD;
    }

    public int getNotificationResponsiveness() {
        return this.tF;
    }

    @Override
    public String getRequestId() {
        return this.ty;
    }

    public int getVersionCode() {
        return this.kZ;
    }

    public int hashCode() {
        long l2 = Double.doubleToLongBits(this.tC);
        int n2 = (int)(l2 ^ l2 >>> 32);
        l2 = Double.doubleToLongBits(this.tD);
        return ((((n2 + 31) * 31 + (int)(l2 ^ l2 >>> 32)) * 31 + Float.floatToIntBits(this.tE)) * 31 + this.tB) * 31 + this.tz;
    }

    public String toString() {
        return String.format(Locale.US, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", fn.aF(this.tB), this.ty, this.tz, this.tC, this.tD, Float.valueOf(this.tE), this.tF / 1000, this.tG, this.ub);
    }

    public void writeToParcel(Parcel parcel, int n2) {
        fo fo2 = CREATOR;
        fo.a(this, parcel, n2);
    }
}

