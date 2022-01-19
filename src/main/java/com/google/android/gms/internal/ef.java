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
import com.google.android.gms.internal.ee;

public class ef
implements Parcelable.Creator<ee.a> {
    static void a(ee.a a2, Parcel parcel, int n2) {
        int n3 = b.l(parcel);
        b.c(parcel, 1, a2.getVersionCode());
        b.c(parcel, 2, a2.bO());
        b.a(parcel, 3, a2.bU());
        b.c(parcel, 4, a2.bP());
        b.a(parcel, 5, a2.bV());
        b.a(parcel, 6, a2.bW(), false);
        b.c(parcel, 7, a2.bX());
        b.a(parcel, 8, a2.bZ(), false);
        b.a(parcel, 9, a2.cb(), n2, false);
        b.D(parcel, n3);
    }

    public ee.a[] E(int n2) {
        return new ee.a[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.p(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.E(n2);
    }

    public ee.a p(Parcel parcel) {
        dz dz2 = null;
        int n2 = 0;
        int n3 = a.k(parcel);
        String string2 = null;
        String string3 = null;
        boolean bl2 = false;
        int n4 = 0;
        boolean bl3 = false;
        int n5 = 0;
        int n6 = 0;
        block11: while (true) {
            if (parcel.dataPosition() >= n3) {
                if (parcel.dataPosition() == n3) return new ee.a(n6, n5, bl3, n4, bl2, string3, n2, string2, dz2);
                throw new a.a("Overread allowed size end=" + n3, parcel);
            }
            int n7 = a.j(parcel);
            switch (a.A(n7)) {
                default: {
                    a.b(parcel, n7);
                    continue block11;
                }
                case 1: {
                    n6 = a.g(parcel, n7);
                    continue block11;
                }
                case 2: {
                    n5 = a.g(parcel, n7);
                    continue block11;
                }
                case 3: {
                    bl3 = a.c(parcel, n7);
                    continue block11;
                }
                case 4: {
                    n4 = a.g(parcel, n7);
                    continue block11;
                }
                case 5: {
                    bl2 = a.c(parcel, n7);
                    continue block11;
                }
                case 6: {
                    string3 = a.m(parcel, n7);
                    continue block11;
                }
                case 7: {
                    n2 = a.g(parcel, n7);
                    continue block11;
                }
                case 8: {
                    string2 = a.m(parcel, n7);
                    continue block11;
                }
                case 9: 
            }
            dz2 = a.a(parcel, n7, dz.CREATOR);
        }
    }
}

