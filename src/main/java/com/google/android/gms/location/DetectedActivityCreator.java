/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.location.DetectedActivity;

public class DetectedActivityCreator
implements Parcelable.Creator<DetectedActivity> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void a(DetectedActivity detectedActivity, Parcel parcel, int n2) {
        n2 = b.l(parcel);
        b.c(parcel, 1, detectedActivity.tw);
        b.c(parcel, 1000, detectedActivity.getVersionCode());
        b.c(parcel, 2, detectedActivity.tx);
        b.D(parcel, n2);
    }

    public DetectedActivity createFromParcel(Parcel parcel) {
        int n2 = 0;
        int n3 = a.k(parcel);
        int n4 = 0;
        int n5 = 0;
        block5: while (true) {
            if (parcel.dataPosition() >= n3) {
                if (parcel.dataPosition() == n3) return new DetectedActivity(n5, n4, n2);
                throw new a.a("Overread allowed size end=" + n3, parcel);
            }
            int n6 = a.j(parcel);
            switch (a.A(n6)) {
                default: {
                    a.b(parcel, n6);
                    continue block5;
                }
                case 1: {
                    n4 = a.g(parcel, n6);
                    continue block5;
                }
                case 1000: {
                    n5 = a.g(parcel, n6);
                    continue block5;
                }
                case 2: 
            }
            n2 = a.g(parcel, n6);
        }
    }

    public DetectedActivity[] newArray(int n2) {
        return new DetectedActivity[n2];
    }
}

