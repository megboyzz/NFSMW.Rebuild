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
import com.google.android.gms.location.LocationRequest;

public class LocationRequestCreator
implements Parcelable.Creator<LocationRequest> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void a(LocationRequest locationRequest, Parcel parcel, int n2) {
        n2 = b.l(parcel);
        b.c(parcel, 1, locationRequest.mPriority);
        b.c(parcel, 1000, locationRequest.getVersionCode());
        b.a(parcel, 2, locationRequest.tH);
        b.a(parcel, 3, locationRequest.tI);
        b.a(parcel, 4, locationRequest.tJ);
        b.a(parcel, 5, locationRequest.tA);
        b.c(parcel, 6, locationRequest.tK);
        b.a(parcel, 7, locationRequest.tL);
        b.D(parcel, n2);
    }

    public LocationRequest createFromParcel(Parcel parcel) {
        boolean bl2 = false;
        int n2 = a.k(parcel);
        int n3 = 102;
        long l2 = 3600000L;
        long l3 = 600000L;
        long l4 = Long.MAX_VALUE;
        int n4 = Integer.MAX_VALUE;
        float f2 = 0.0f;
        int n5 = 0;
        block10: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new LocationRequest(n5, n3, l2, l3, bl2, l4, n4, f2);
                throw new a.a("Overread allowed size end=" + n2, parcel);
            }
            int n6 = a.j(parcel);
            switch (a.A(n6)) {
                default: {
                    a.b(parcel, n6);
                    continue block10;
                }
                case 1: {
                    n3 = a.g(parcel, n6);
                    continue block10;
                }
                case 1000: {
                    n5 = a.g(parcel, n6);
                    continue block10;
                }
                case 2: {
                    l2 = a.h(parcel, n6);
                    continue block10;
                }
                case 3: {
                    l3 = a.h(parcel, n6);
                    continue block10;
                }
                case 4: {
                    bl2 = a.c(parcel, n6);
                    continue block10;
                }
                case 5: {
                    l4 = a.h(parcel, n6);
                    continue block10;
                }
                case 6: {
                    n4 = a.g(parcel, n6);
                    continue block10;
                }
                case 7: 
            }
            f2 = a.j(parcel, n6);
        }
    }

    public LocationRequest[] newArray(int n2) {
        return new LocationRequest[n2];
    }
}

