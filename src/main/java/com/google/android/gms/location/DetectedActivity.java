/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 */
package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.DetectedActivityCreator;

public class DetectedActivity
implements SafeParcelable {
    public static final DetectedActivityCreator CREATOR = new DetectedActivityCreator();
    public static final int IN_VEHICLE = 0;
    public static final int ON_BICYCLE = 1;
    public static final int ON_FOOT = 2;
    public static final int STILL = 3;
    public static final int TILTING = 5;
    public static final int UNKNOWN = 4;
    private final int kZ;
    int tw;
    int tx;

    public DetectedActivity(int n2, int n3) {
        this.kZ = 1;
        this.tw = n2;
        this.tx = n3;
    }

    public DetectedActivity(int n2, int n3, int n4) {
        this.kZ = n2;
        this.tw = n3;
        this.tx = n4;
    }

    private int aA(int n2) {
        int n3 = n2;
        if (n2 <= 6) return n3;
        return 4;
    }

    public int describeContents() {
        return 0;
    }

    public int getConfidence() {
        return this.tx;
    }

    public int getType() {
        return this.aA(this.tw);
    }

    public int getVersionCode() {
        return this.kZ;
    }

    public String toString() {
        return "DetectedActivity [type=" + this.getType() + ", confidence=" + this.tx + "]";
    }

    public void writeToParcel(Parcel parcel, int n2) {
        DetectedActivityCreator.a(this, parcel, n2);
    }
}

