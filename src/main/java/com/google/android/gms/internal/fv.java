/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.fs;
import com.google.android.gms.internal.fu;
import com.google.android.gms.location.LocationRequest;

public class fv
implements Parcelable.Creator<fu> {
    static void a(fu fu2, Parcel parcel, int n2) {
        int n3 = b.l(parcel);
        b.a(parcel, 1, fu2.dA(), n2, false);
        b.c(parcel, 1000, fu2.kZ);
        b.a(parcel, 2, fu2.dB(), n2, false);
        b.D(parcel, n3);
    }

    public fu[] aI(int n2) {
        return new fu[n2];
    }

    public fu ac(Parcel parcel) {
        fs fs2 = null;
        int n2 = a.k(parcel);
        int n3 = 0;
        LocationRequest locationRequest = null;
        block5: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new fu(n3, locationRequest, fs2);
                throw new a.a("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.j(parcel);
            switch (a.A(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block5;
                }
                case 1: {
                    locationRequest = a.a(parcel, n4, LocationRequest.CREATOR);
                    continue block5;
                }
                case 1000: {
                    n3 = a.g(parcel, n4);
                    continue block5;
                }
                case 2: 
            }
            fs2 = a.a(parcel, n4, fs.CREATOR);
        }
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.ac(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.aI(n2);
    }
}

