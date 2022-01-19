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
import com.google.android.gms.internal.dh;
import java.util.ArrayList;

public class dt
implements Parcelable.Creator<dh.a> {
    static void a(dh.a a2, Parcel parcel, int n2) {
        n2 = b.l(parcel);
        b.a(parcel, 1, a2.getAccountName(), false);
        b.c(parcel, 1000, a2.getVersionCode());
        b.a(parcel, 2, a2.bu(), false);
        b.c(parcel, 3, a2.bv());
        b.a(parcel, 4, a2.bw(), false);
        b.D(parcel, n2);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.i(parcel);
    }

    public dh.a i(Parcel parcel) {
        int n2 = 0;
        String string2 = null;
        int n3 = a.k(parcel);
        ArrayList<String> arrayList = null;
        String string3 = null;
        int n4 = 0;
        block7: while (true) {
            if (parcel.dataPosition() >= n3) {
                if (parcel.dataPosition() == n3) return new dh.a(n4, string3, arrayList, n2, string2);
                throw new a.a("Overread allowed size end=" + n3, parcel);
            }
            int n5 = a.j(parcel);
            switch (a.A(n5)) {
                default: {
                    a.b(parcel, n5);
                    continue block7;
                }
                case 1: {
                    string3 = a.m(parcel, n5);
                    continue block7;
                }
                case 1000: {
                    n4 = a.g(parcel, n5);
                    continue block7;
                }
                case 2: {
                    arrayList = a.y(parcel, n5);
                    continue block7;
                }
                case 3: {
                    n2 = a.g(parcel, n5);
                    continue block7;
                }
                case 4: 
            }
            string2 = a.m(parcel, n5);
        }
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.z(n2);
    }

    public dh.a[] z(int n2) {
        return new dh.a[n2];
    }
}

