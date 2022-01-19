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
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class CameraPositionCreator
implements Parcelable.Creator<CameraPosition> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void a(CameraPosition cameraPosition, Parcel parcel, int n2) {
        int n3 = b.l(parcel);
        b.c(parcel, 1, cameraPosition.getVersionCode());
        b.a(parcel, 2, cameraPosition.target, n2, false);
        b.a(parcel, 3, cameraPosition.zoom);
        b.a(parcel, 4, cameraPosition.tilt);
        b.a(parcel, 5, cameraPosition.bearing);
        b.D(parcel, n3);
    }

    public CameraPosition createFromParcel(Parcel parcel) {
        float f2 = 0.0f;
        int n2 = a.k(parcel);
        int n3 = 0;
        LatLng latLng = null;
        float f3 = 0.0f;
        float f4 = 0.0f;
        block7: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new CameraPosition(n3, latLng, f4, f3, f2);
                throw new a.a("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.j(parcel);
            switch (a.A(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block7;
                }
                case 1: {
                    n3 = a.g(parcel, n4);
                    continue block7;
                }
                case 2: {
                    latLng = a.a(parcel, n4, LatLng.CREATOR);
                    continue block7;
                }
                case 3: {
                    f4 = a.j(parcel, n4);
                    continue block7;
                }
                case 4: {
                    f3 = a.j(parcel, n4);
                    continue block7;
                }
                case 5: 
            }
            f2 = a.j(parcel, n4);
        }
    }

    public CameraPosition[] newArray(int n2) {
        return new CameraPosition[n2];
    }
}

