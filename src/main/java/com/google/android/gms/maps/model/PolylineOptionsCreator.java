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
import com.google.android.gms.maps.model.PolylineOptions;
import java.util.ArrayList;

public class PolylineOptionsCreator
implements Parcelable.Creator<PolylineOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void a(PolylineOptions polylineOptions, Parcel parcel, int n2) {
        n2 = b.l(parcel);
        b.c(parcel, 1, polylineOptions.getVersionCode());
        b.b(parcel, 2, polylineOptions.getPoints(), false);
        b.a(parcel, 3, polylineOptions.getWidth());
        b.c(parcel, 4, polylineOptions.getColor());
        b.a(parcel, 5, polylineOptions.getZIndex());
        b.a(parcel, 6, polylineOptions.isVisible());
        b.a(parcel, 7, polylineOptions.isGeodesic());
        b.D(parcel, n2);
    }

    public PolylineOptions createFromParcel(Parcel parcel) {
        float f2 = 0.0f;
        boolean bl2 = false;
        int n2 = a.k(parcel);
        ArrayList<LatLng> arrayList = null;
        boolean bl3 = false;
        int n3 = 0;
        float f3 = 0.0f;
        int n4 = 0;
        block9: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new PolylineOptions(n4, arrayList, f3, n3, f2, bl3, bl2);
                throw new a.a("Overread allowed size end=" + n2, parcel);
            }
            int n5 = a.j(parcel);
            switch (a.A(n5)) {
                default: {
                    a.b(parcel, n5);
                    continue block9;
                }
                case 1: {
                    n4 = a.g(parcel, n5);
                    continue block9;
                }
                case 2: {
                    arrayList = a.c(parcel, n5, LatLng.CREATOR);
                    continue block9;
                }
                case 3: {
                    f3 = a.j(parcel, n5);
                    continue block9;
                }
                case 4: {
                    n3 = a.g(parcel, n5);
                    continue block9;
                }
                case 5: {
                    f2 = a.j(parcel, n5);
                    continue block9;
                }
                case 6: {
                    bl3 = a.c(parcel, n5);
                    continue block9;
                }
                case 7: 
            }
            bl2 = a.c(parcel, n5);
        }
    }

    public PolylineOptions[] newArray(int n2) {
        return new PolylineOptions[n2];
    }
}

