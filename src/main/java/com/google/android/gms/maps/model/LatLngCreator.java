/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.model.LatLng;

public class LatLngCreator
implements Parcelable.Creator<LatLng> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void a(LatLng latLng, Parcel parcel, int n2) {
        n2 = b.l(parcel);
        b.c(parcel, 1, latLng.getVersionCode());
        b.a(parcel, 2, latLng.latitude);
        b.a(parcel, 3, latLng.longitude);
        b.D(parcel, n2);
    }

    public LatLng createFromParcel(Parcel parcel) {
        double d2 = 0.0;
        int n2 = a.k(parcel);
        int n3 = 0;
        double d3 = 0.0;
        block5: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new LatLng(n3, d3, d2);
                throw new a.a("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.j(parcel);
            switch (a.A(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block5;
                }
                case 1: {
                    n3 = a.g(parcel, n4);
                    continue block5;
                }
                case 2: {
                    d3 = a.k(parcel, n4);
                    continue block5;
                }
                case 3: 
            }
            d2 = a.k(parcel, n4);
        }
    }

    public LatLng[] newArray(int n2) {
        return new LatLng[n2];
    }
}

