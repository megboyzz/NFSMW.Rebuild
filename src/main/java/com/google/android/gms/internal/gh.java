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
import com.google.android.gms.internal.gg;

public class gh
implements Parcelable.Creator<gg> {
    static void a(gg gg2, Parcel parcel, int n2) {
        n2 = b.l(parcel);
        b.a(parcel, 1, gg2.xj, false);
        b.c(parcel, 1000, gg2.versionCode);
        b.a(parcel, 2, gg2.xk, false);
        b.D(parcel, n2);
    }

    public gg[] aN(int n2) {
        return new gg[n2];
    }

    public gg ah(Parcel parcel) {
        String string2 = null;
        int n2 = a.k(parcel);
        int n3 = 0;
        String string3 = null;
        block5: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new gg(n3, string3, string2);
                throw new a.a("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.j(parcel);
            switch (a.A(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block5;
                }
                case 1: {
                    string3 = a.m(parcel, n4);
                    continue block5;
                }
                case 1000: {
                    n3 = a.g(parcel, n4);
                    continue block5;
                }
                case 2: 
            }
            string2 = a.m(parcel, n4);
        }
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.ah(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.aN(n2);
    }
}

