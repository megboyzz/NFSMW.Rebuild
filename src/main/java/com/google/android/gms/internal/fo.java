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
import com.google.android.gms.internal.fn;

public class fo
implements Parcelable.Creator<fn> {
    static void a(fn fn2, Parcel parcel, int n2) {
        n2 = b.l(parcel);
        b.a(parcel, 1, fn2.getRequestId(), false);
        b.c(parcel, 1000, fn2.getVersionCode());
        b.a(parcel, 2, fn2.getExpirationTime());
        b.a(parcel, 3, fn2.ds());
        b.a(parcel, 4, fn2.getLatitude());
        b.a(parcel, 5, fn2.getLongitude());
        b.a(parcel, 6, fn2.dt());
        b.c(parcel, 7, fn2.du());
        b.c(parcel, 8, fn2.getNotificationResponsiveness());
        b.c(parcel, 9, fn2.dv());
        b.D(parcel, n2);
    }

    public fn[] aG(int n2) {
        return new fn[n2];
    }

    public fn aa(Parcel parcel) {
        int n2 = a.k(parcel);
        int n3 = 0;
        String string2 = null;
        int n4 = 0;
        short s2 = 0;
        double d2 = 0.0;
        double d3 = 0.0;
        float f2 = 0.0f;
        long l2 = 0L;
        int n5 = 0;
        int n6 = -1;
        block12: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new fn(n3, string2, n4, s2, d2, d3, f2, l2, n5, n6);
                throw new a.a("Overread allowed size end=" + n2, parcel);
            }
            int n7 = a.j(parcel);
            switch (a.A(n7)) {
                default: {
                    a.b(parcel, n7);
                    continue block12;
                }
                case 1: {
                    string2 = a.m(parcel, n7);
                    continue block12;
                }
                case 1000: {
                    n3 = a.g(parcel, n7);
                    continue block12;
                }
                case 2: {
                    l2 = a.h(parcel, n7);
                    continue block12;
                }
                case 3: {
                    s2 = a.f(parcel, n7);
                    continue block12;
                }
                case 4: {
                    d2 = a.k(parcel, n7);
                    continue block12;
                }
                case 5: {
                    d3 = a.k(parcel, n7);
                    continue block12;
                }
                case 6: {
                    f2 = a.j(parcel, n7);
                    continue block12;
                }
                case 7: {
                    n4 = a.g(parcel, n7);
                    continue block12;
                }
                case 8: {
                    n5 = a.g(parcel, n7);
                    continue block12;
                }
                case 9: 
            }
            n6 = a.g(parcel, n7);
        }
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.aa(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.aG(n2);
    }
}

