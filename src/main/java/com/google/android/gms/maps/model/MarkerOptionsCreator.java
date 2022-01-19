/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MarkerOptionsCreator
implements Parcelable.Creator<MarkerOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void a(MarkerOptions markerOptions, Parcel parcel, int n2) {
        int n3 = b.l(parcel);
        b.c(parcel, 1, markerOptions.getVersionCode());
        b.a(parcel, 2, markerOptions.getPosition(), n2, false);
        b.a(parcel, 3, markerOptions.getTitle(), false);
        b.a(parcel, 4, markerOptions.getSnippet(), false);
        b.a(parcel, 5, markerOptions.ek(), false);
        b.a(parcel, 6, markerOptions.getAnchorU());
        b.a(parcel, 7, markerOptions.getAnchorV());
        b.a(parcel, 8, markerOptions.isDraggable());
        b.a(parcel, 9, markerOptions.isVisible());
        b.a(parcel, 10, markerOptions.isFlat());
        b.a(parcel, 11, markerOptions.getRotation());
        b.a(parcel, 12, markerOptions.getInfoWindowAnchorU());
        b.a(parcel, 13, markerOptions.getInfoWindowAnchorV());
        b.a(parcel, 14, markerOptions.getAlpha());
        b.D(parcel, n3);
    }

    public MarkerOptions createFromParcel(Parcel parcel) {
        int n2 = a.k(parcel);
        int n3 = 0;
        LatLng latLng = null;
        String string2 = null;
        String string3 = null;
        IBinder iBinder = null;
        float f2 = 0.0f;
        float f3 = 0.0f;
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = false;
        float f4 = 0.0f;
        float f5 = 0.5f;
        float f6 = 0.0f;
        float f7 = 1.0f;
        block16: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new MarkerOptions(n3, latLng, string2, string3, iBinder, f2, f3, bl2, bl3, bl4, f4, f5, f6, f7);
                throw new a.a("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.j(parcel);
            switch (a.A(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block16;
                }
                case 1: {
                    n3 = a.g(parcel, n4);
                    continue block16;
                }
                case 2: {
                    latLng = a.a(parcel, n4, LatLng.CREATOR);
                    continue block16;
                }
                case 3: {
                    string2 = a.m(parcel, n4);
                    continue block16;
                }
                case 4: {
                    string3 = a.m(parcel, n4);
                    continue block16;
                }
                case 5: {
                    iBinder = a.n(parcel, n4);
                    continue block16;
                }
                case 6: {
                    f2 = a.j(parcel, n4);
                    continue block16;
                }
                case 7: {
                    f3 = a.j(parcel, n4);
                    continue block16;
                }
                case 8: {
                    bl2 = a.c(parcel, n4);
                    continue block16;
                }
                case 9: {
                    bl3 = a.c(parcel, n4);
                    continue block16;
                }
                case 10: {
                    bl4 = a.c(parcel, n4);
                    continue block16;
                }
                case 11: {
                    f4 = a.j(parcel, n4);
                    continue block16;
                }
                case 12: {
                    f5 = a.j(parcel, n4);
                    continue block16;
                }
                case 13: {
                    f6 = a.j(parcel, n4);
                    continue block16;
                }
                case 14: 
            }
            f7 = a.j(parcel, n4);
        }
    }

    public MarkerOptions[] newArray(int n2) {
        return new MarkerOptions[n2];
    }
}

