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
import com.google.android.gms.internal.eb;

public class ed
implements Parcelable.Creator<eb.a> {
    static void a(eb.a a2, Parcel parcel, int n2) {
        n2 = b.l(parcel);
        b.c(parcel, 1, a2.versionCode);
        b.a(parcel, 2, a2.nv, false);
        b.c(parcel, 3, a2.nw);
        b.D(parcel, n2);
    }

    public eb.a[] D(int n2) {
        return new eb.a[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.o(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.D(n2);
    }

    public eb.a o(Parcel parcel) {
        int n2 = 0;
        int n3 = a.k(parcel);
        String string2 = null;
        int n4 = 0;
        block5: while (true) {
            if (parcel.dataPosition() >= n3) {
                if (parcel.dataPosition() == n3) return new eb.a(n4, string2, n2);
                throw new a.a("Overread allowed size end=" + n3, parcel);
            }
            int n5 = a.j(parcel);
            switch (a.A(n5)) {
                default: {
                    a.b(parcel, n5);
                    continue block5;
                }
                case 1: {
                    n4 = a.g(parcel, n5);
                    continue block5;
                }
                case 2: {
                    string2 = a.m(parcel, n5);
                    continue block5;
                }
                case 3: 
            }
            n2 = a.g(parcel, n5);
        }
    }
}

