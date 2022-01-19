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
import com.google.android.gms.internal.cb;
import java.util.ArrayList;

public class cc
implements Parcelable.Creator<cb> {
    static void a(cb cb2, Parcel parcel, int n2) {
        n2 = b.l(parcel);
        b.c(parcel, 1, cb2.versionCode);
        b.a(parcel, 2, cb2.gK, false);
        b.a(parcel, 3, cb2.hu, false);
        b.a(parcel, 4, cb2.fK, false);
        b.c(parcel, 5, cb2.errorCode);
        b.a(parcel, 6, cb2.fL, false);
        b.a(parcel, 7, cb2.hv);
        b.a(parcel, 8, cb2.hw);
        b.a(parcel, 9, cb2.hx);
        b.a(parcel, 10, cb2.hy, false);
        b.a(parcel, 11, cb2.fO);
        b.c(parcel, 12, cb2.orientation);
        b.a(parcel, 13, cb2.hz, false);
        b.D(parcel, n2);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.g(parcel);
    }

    public cb g(Parcel parcel) {
        int n2 = a.k(parcel);
        int n3 = 0;
        String string2 = null;
        String string3 = null;
        ArrayList<String> arrayList = null;
        int n4 = 0;
        ArrayList<String> arrayList2 = null;
        long l2 = 0L;
        boolean bl2 = false;
        long l3 = 0L;
        ArrayList<String> arrayList3 = null;
        long l4 = 0L;
        int n5 = 0;
        String string4 = null;
        block15: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new cb(n3, string2, string3, arrayList, n4, arrayList2, l2, bl2, l3, arrayList3, l4, n5, string4);
                throw new a.a("Overread allowed size end=" + n2, parcel);
            }
            int n6 = a.j(parcel);
            switch (a.A(n6)) {
                default: {
                    a.b(parcel, n6);
                    continue block15;
                }
                case 1: {
                    n3 = a.g(parcel, n6);
                    continue block15;
                }
                case 2: {
                    string2 = a.m(parcel, n6);
                    continue block15;
                }
                case 3: {
                    string3 = a.m(parcel, n6);
                    continue block15;
                }
                case 4: {
                    arrayList = a.y(parcel, n6);
                    continue block15;
                }
                case 5: {
                    n4 = a.g(parcel, n6);
                    continue block15;
                }
                case 6: {
                    arrayList2 = a.y(parcel, n6);
                    continue block15;
                }
                case 7: {
                    l2 = a.h(parcel, n6);
                    continue block15;
                }
                case 8: {
                    bl2 = a.c(parcel, n6);
                    continue block15;
                }
                case 9: {
                    l3 = a.h(parcel, n6);
                    continue block15;
                }
                case 10: {
                    arrayList3 = a.y(parcel, n6);
                    continue block15;
                }
                case 11: {
                    l4 = a.h(parcel, n6);
                    continue block15;
                }
                case 12: {
                    n5 = a.g(parcel, n6);
                    continue block15;
                }
                case 13: 
            }
            string4 = a.m(parcel, n6);
        }
    }

    public cb[] l(int n2) {
        return new cb[n2];
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.l(n2);
    }
}

