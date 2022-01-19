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
import com.google.android.gms.internal.ct;

public class cu
implements Parcelable.Creator<ct> {
    static void a(ct ct2, Parcel parcel, int n2) {
        n2 = b.l(parcel);
        b.c(parcel, 1, ct2.versionCode);
        b.a(parcel, 2, ct2.iF, false);
        b.c(parcel, 3, ct2.iG);
        b.c(parcel, 4, ct2.iH);
        b.a(parcel, 5, ct2.iI);
        b.D(parcel, n2);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.h(parcel);
    }

    public ct h(Parcel parcel) {
        boolean bl2 = false;
        int n2 = a.k(parcel);
        String string2 = null;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        block7: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new ct(n5, string2, n4, n3, bl2);
                throw new a.a("Overread allowed size end=" + n2, parcel);
            }
            int n6 = a.j(parcel);
            switch (a.A(n6)) {
                default: {
                    a.b(parcel, n6);
                    continue block7;
                }
                case 1: {
                    n5 = a.g(parcel, n6);
                    continue block7;
                }
                case 2: {
                    string2 = a.m(parcel, n6);
                    continue block7;
                }
                case 3: {
                    n4 = a.g(parcel, n6);
                    continue block7;
                }
                case 4: {
                    n3 = a.g(parcel, n6);
                    continue block7;
                }
                case 5: 
            }
            bl2 = a.c(parcel, n6);
        }
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.o(n2);
    }

    public ct[] o(int n2) {
        return new ct[n2];
    }
}

