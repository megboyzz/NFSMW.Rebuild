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
import com.google.android.gms.maps.model.PolygonOptions;
import java.util.ArrayList;

public class PolygonOptionsCreator
implements Parcelable.Creator<PolygonOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void a(PolygonOptions polygonOptions, Parcel parcel, int n2) {
        n2 = b.l(parcel);
        b.c(parcel, 1, polygonOptions.getVersionCode());
        b.b(parcel, 2, polygonOptions.getPoints(), false);
        b.c(parcel, 3, polygonOptions.el(), false);
        b.a(parcel, 4, polygonOptions.getStrokeWidth());
        b.c(parcel, 5, polygonOptions.getStrokeColor());
        b.c(parcel, 6, polygonOptions.getFillColor());
        b.a(parcel, 7, polygonOptions.getZIndex());
        b.a(parcel, 8, polygonOptions.isVisible());
        b.a(parcel, 9, polygonOptions.isGeodesic());
        b.D(parcel, n2);
    }

    public PolygonOptions createFromParcel(Parcel parcel) {
        float f2 = 0.0f;
        boolean bl2 = false;
        int n2 = a.k(parcel);
        ArrayList<LatLng> arrayList = null;
        ArrayList arrayList2 = new ArrayList();
        boolean bl3 = false;
        int n3 = 0;
        int n4 = 0;
        float f3 = 0.0f;
        int n5 = 0;
        block11: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new PolygonOptions(n5, arrayList, arrayList2, f3, n4, n3, f2, bl3, bl2);
                throw new a.a("Overread allowed size end=" + n2, parcel);
            }
            int n6 = a.j(parcel);
            switch (a.A(n6)) {
                default: {
                    a.b(parcel, n6);
                    continue block11;
                }
                case 1: {
                    n5 = a.g(parcel, n6);
                    continue block11;
                }
                case 2: {
                    arrayList = a.c(parcel, n6, LatLng.CREATOR);
                    continue block11;
                }
                case 3: {
                    a.a(parcel, n6, arrayList2, this.getClass().getClassLoader());
                    continue block11;
                }
                case 4: {
                    f3 = a.j(parcel, n6);
                    continue block11;
                }
                case 5: {
                    n4 = a.g(parcel, n6);
                    continue block11;
                }
                case 6: {
                    n3 = a.g(parcel, n6);
                    continue block11;
                }
                case 7: {
                    f2 = a.j(parcel, n6);
                    continue block11;
                }
                case 8: {
                    bl3 = a.c(parcel, n6);
                    continue block11;
                }
                case 9: 
            }
            bl2 = a.c(parcel, n6);
        }
    }

    public PolygonOptions[] newArray(int n2) {
        return new PolygonOptions[n2];
    }
}

