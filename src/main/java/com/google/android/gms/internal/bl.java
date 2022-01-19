/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.bj;
import com.google.android.gms.internal.bm;
import com.google.android.gms.internal.ct;

public class bl
implements Parcelable.Creator<bm> {
    static void a(bm bm2, Parcel parcel, int n2) {
        int n3 = b.l(parcel);
        b.c(parcel, 1, bm2.versionCode);
        b.a(parcel, 2, bm2.gF, n2, false);
        b.a(parcel, 3, bm2.aa(), false);
        b.a(parcel, 4, bm2.ab(), false);
        b.a(parcel, 5, bm2.ac(), false);
        b.a(parcel, 6, bm2.ad(), false);
        b.a(parcel, 7, bm2.gK, false);
        b.a(parcel, 8, bm2.gL);
        b.a(parcel, 9, bm2.gM, false);
        b.a(parcel, 10, bm2.ae(), false);
        b.c(parcel, 11, bm2.orientation);
        b.c(parcel, 12, bm2.gO);
        b.a(parcel, 13, bm2.gn, false);
        b.a(parcel, 14, bm2.ej, n2, false);
        b.D(parcel, n3);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.e(parcel);
    }

    public bm e(Parcel parcel) {
        int n2 = a.k(parcel);
        int n3 = 0;
        bj bj2 = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        String string2 = null;
        boolean bl2 = false;
        String string3 = null;
        IBinder iBinder5 = null;
        int n4 = 0;
        int n5 = 0;
        String string4 = null;
        ct ct2 = null;
        block16: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new bm(n3, bj2, iBinder, iBinder2, iBinder3, iBinder4, string2, bl2, string3, iBinder5, n4, n5, string4, ct2);
                throw new a.a("Overread allowed size end=" + n2, parcel);
            }
            int n6 = a.j(parcel);
            switch (a.A(n6)) {
                default: {
                    a.b(parcel, n6);
                    continue block16;
                }
                case 1: {
                    n3 = a.g(parcel, n6);
                    continue block16;
                }
                case 2: {
                    bj2 = a.a(parcel, n6, bj.CREATOR);
                    continue block16;
                }
                case 3: {
                    iBinder = a.n(parcel, n6);
                    continue block16;
                }
                case 4: {
                    iBinder2 = a.n(parcel, n6);
                    continue block16;
                }
                case 5: {
                    iBinder3 = a.n(parcel, n6);
                    continue block16;
                }
                case 6: {
                    iBinder4 = a.n(parcel, n6);
                    continue block16;
                }
                case 7: {
                    string2 = a.m(parcel, n6);
                    continue block16;
                }
                case 8: {
                    bl2 = a.c(parcel, n6);
                    continue block16;
                }
                case 9: {
                    string3 = a.m(parcel, n6);
                    continue block16;
                }
                case 10: {
                    iBinder5 = a.n(parcel, n6);
                    continue block16;
                }
                case 11: {
                    n4 = a.g(parcel, n6);
                    continue block16;
                }
                case 12: {
                    n5 = a.g(parcel, n6);
                    continue block16;
                }
                case 13: {
                    string4 = a.m(parcel, n6);
                    continue block16;
                }
                case 14: 
            }
            ct2 = a.a(parcel, n6, ct.CREATOR);
        }
    }

    public bm[] j(int n2) {
        return new bm[n2];
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.j(n2);
    }
}

