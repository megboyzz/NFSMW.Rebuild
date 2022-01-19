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
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.eh;

public class eg
implements Parcelable.Creator<eh.b> {
    static void a(eh.b b2, Parcel parcel, int n2) {
        int n3 = b.l(parcel);
        b.c(parcel, 1, b2.versionCode);
        b.a(parcel, 2, b2.nL, false);
        b.a(parcel, 3, b2.nM, n2, false);
        b.D(parcel, n3);
    }

    public eh.b[] F(int n2) {
        return new eh.b[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.q(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.F(n2);
    }

    public eh.b q(Parcel parcel) {
        ee.a a2 = null;
        int n2 = a.k(parcel);
        int n3 = 0;
        String string2 = null;
        block5: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new eh.b(n3, string2, a2);
                throw new a.a("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.j(parcel);
            switch (a.A(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block5;
                }
                case 1: {
                    n3 = a.g(parcel, n4);
                    continue block5;
                }
                case 2: {
                    string2 = a.m(parcel, n4);
                    continue block5;
                }
                case 3: 
            }
            a2 = a.a(parcel, n4, ee.a.CREATOR);
        }
    }
}

