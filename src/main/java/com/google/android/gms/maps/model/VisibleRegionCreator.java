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
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.VisibleRegion;

public class VisibleRegionCreator
implements Parcelable.Creator<VisibleRegion> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void a(VisibleRegion visibleRegion, Parcel parcel, int n2) {
        int n3 = b.l(parcel);
        b.c(parcel, 1, visibleRegion.getVersionCode());
        b.a(parcel, 2, visibleRegion.nearLeft, n2, false);
        b.a(parcel, 3, visibleRegion.nearRight, n2, false);
        b.a(parcel, 4, visibleRegion.farLeft, n2, false);
        b.a(parcel, 5, visibleRegion.farRight, n2, false);
        b.a(parcel, 6, visibleRegion.latLngBounds, n2, false);
        b.D(parcel, n3);
    }

    public VisibleRegion createFromParcel(Parcel parcel) {
        LatLngBounds latLngBounds = null;
        int n2 = a.k(parcel);
        int n3 = 0;
        LatLng latLng = null;
        LatLng latLng2 = null;
        LatLng latLng3 = null;
        LatLng latLng4 = null;
        block8: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new VisibleRegion(n3, latLng4, latLng3, latLng2, latLng, latLngBounds);
                throw new a.a("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.j(parcel);
            switch (a.A(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block8;
                }
                case 1: {
                    n3 = a.g(parcel, n4);
                    continue block8;
                }
                case 2: {
                    latLng4 = a.a(parcel, n4, LatLng.CREATOR);
                    continue block8;
                }
                case 3: {
                    latLng3 = a.a(parcel, n4, LatLng.CREATOR);
                    continue block8;
                }
                case 4: {
                    latLng2 = a.a(parcel, n4, LatLng.CREATOR);
                    continue block8;
                }
                case 5: {
                    latLng = a.a(parcel, n4, LatLng.CREATOR);
                    continue block8;
                }
                case 6: 
            }
            latLngBounds = a.a(parcel, n4, LatLngBounds.CREATOR);
        }
    }

    public VisibleRegion[] newArray(int n2) {
        return new VisibleRegion[n2];
    }
}

