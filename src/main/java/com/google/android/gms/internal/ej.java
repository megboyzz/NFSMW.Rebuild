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
import com.google.android.gms.internal.eh;
import java.util.ArrayList;

public class ej
implements Parcelable.Creator<eh.a> {
    static void a(eh.a a2, Parcel parcel, int n2) {
        n2 = b.l(parcel);
        b.c(parcel, 1, a2.versionCode);
        b.a(parcel, 2, a2.className, false);
        b.b(parcel, 3, a2.nK, false);
        b.D(parcel, n2);
    }

    public eh.a[] H(int n2) {
        return new eh.a[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.s(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.H(n2);
    }

    public eh.a s(Parcel parcel) {
        ArrayList<eh.b> arrayList = null;
        int n2 = a.k(parcel);
        int n3 = 0;
        String string2 = null;
        block5: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new eh.a(n3, string2, arrayList);
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
            arrayList = a.c(parcel, n4, eh.b.CREATOR);
        }
    }
}

