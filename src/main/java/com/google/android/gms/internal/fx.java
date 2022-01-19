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
import com.google.android.gms.internal.fw;

public class fx
implements Parcelable.Creator<fw> {
    static void a(fw fw2, Parcel parcel, int n2) {
        n2 = b.l(parcel);
        b.a(parcel, 1, fw2.wF, false);
        b.c(parcel, 1000, fw2.kZ);
        b.D(parcel, n2);
    }

    public fw[] aJ(int n2) {
        return new fw[n2];
    }

    public fw ad(Parcel parcel) {
        int n2 = a.k(parcel);
        int n3 = 0;
        String string2 = null;
        block4: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new fw(n3, string2);
                throw new a.a("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.j(parcel);
            switch (a.A(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block4;
                }
                case 1: {
                    string2 = a.m(parcel, n4);
                    continue block4;
                }
                case 1000: 
            }
            n3 = a.g(parcel, n4);
        }
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.ad(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.aJ(n2);
    }
}

