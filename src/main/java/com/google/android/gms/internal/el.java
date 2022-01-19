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
import com.google.android.gms.internal.ek;

public class el
implements Parcelable.Creator<ek> {
    static void a(ek ek2, Parcel parcel, int n2) {
        int n3 = b.l(parcel);
        b.c(parcel, 1, ek2.getVersionCode());
        b.a(parcel, 2, ek2.ci(), false);
        b.a(parcel, 3, ek2.cj(), n2, false);
        b.D(parcel, n3);
    }

    public ek[] I(int n2) {
        return new ek[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.t(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.I(n2);
    }

    public ek t(Parcel parcel) {
        eh eh2 = null;
        int n2 = a.k(parcel);
        int n3 = 0;
        Parcel parcel2 = null;
        block5: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new ek(n3, parcel2, eh2);
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
                    parcel2 = a.z(parcel, n4);
                    continue block5;
                }
                case 3: 
            }
            eh2 = a.a(parcel, n4, eh.CREATOR);
        }
    }
}

