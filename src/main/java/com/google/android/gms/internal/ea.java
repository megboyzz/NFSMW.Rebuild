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
import com.google.android.gms.internal.dz;
import com.google.android.gms.internal.eb;

public class ea
implements Parcelable.Creator<dz> {
    static void a(dz dz2, Parcel parcel, int n2) {
        int n3 = b.l(parcel);
        b.c(parcel, 1, dz2.getVersionCode());
        b.a(parcel, 2, dz2.bL(), n2, false);
        b.D(parcel, n3);
    }

    public dz[] B(int n2) {
        return new dz[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.m(parcel);
    }

    public dz m(Parcel parcel) {
        int n2 = a.k(parcel);
        int n3 = 0;
        eb eb2 = null;
        block4: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new dz(n3, eb2);
                throw new a.a("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.j(parcel);
            switch (a.A(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block4;
                }
                case 1: {
                    n3 = a.g(parcel, n4);
                    continue block4;
                }
                case 2: 
            }
            eb2 = a.a(parcel, n4, eb.CREATOR);
        }
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.B(n2);
    }
}

