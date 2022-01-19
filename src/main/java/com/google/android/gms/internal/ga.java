/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.fz;
import com.google.android.gms.internal.gb;

public class ga
implements Parcelable.Creator<fz> {
    static void a(fz fz2, Parcel parcel, int n2) {
        int n3 = b.l(parcel);
        b.a((Parcel)parcel, (int)1, (Parcelable[])fz2.dC(), (int)n2, (boolean)false);
        b.c(parcel, 1000, fz2.kZ);
        b.a(parcel, 2, fz2.dD(), false);
        b.D(parcel, n3);
    }

    public fz[] aK(int n2) {
        return new fz[n2];
    }

    public fz ae(Parcel parcel) {
        float[] fArray = null;
        int n2 = a.k(parcel);
        int n3 = 0;
        gb[] gbArray = null;
        block5: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new fz(n3, gbArray, fArray);
                throw new a.a("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.j(parcel);
            switch (a.A(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block5;
                }
                case 1: {
                    gbArray = a.b(parcel, n4, gb.CREATOR);
                    continue block5;
                }
                case 1000: {
                    n3 = a.g(parcel, n4);
                    continue block5;
                }
                case 2: 
            }
            fArray = a.u(parcel, n4);
        }
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.ae(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.aK(n2);
    }
}

