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
import com.google.android.gms.internal.ha;
import java.util.HashSet;
import java.util.Set;

public class hc
implements Parcelable.Creator<ha.a> {
    static void a(ha.a a2, Parcel parcel, int n2) {
        n2 = b.l(parcel);
        Set<Integer> set = a2.eF();
        if (set.contains(1)) {
            b.c(parcel, 1, a2.getVersionCode());
        }
        if (set.contains(2)) {
            b.c(parcel, 2, a2.getMax());
        }
        if (set.contains(3)) {
            b.c(parcel, 3, a2.getMin());
        }
        b.D(parcel, n2);
    }

    public ha.a[] aU(int n2) {
        return new ha.a[n2];
    }

    public ha.a am(Parcel parcel) {
        int n2 = 0;
        int n3 = a.k(parcel);
        HashSet<Integer> hashSet = new HashSet<Integer>();
        int n4 = 0;
        int n5 = 0;
        block5: while (true) {
            if (parcel.dataPosition() >= n3) {
                if (parcel.dataPosition() == n3) return new ha.a(hashSet, n5, n4, n2);
                throw new a.a("Overread allowed size end=" + n3, parcel);
            }
            int n6 = a.j(parcel);
            switch (a.A(n6)) {
                default: {
                    a.b(parcel, n6);
                    continue block5;
                }
                case 1: {
                    n5 = a.g(parcel, n6);
                    hashSet.add(1);
                    continue block5;
                }
                case 2: {
                    n4 = a.g(parcel, n6);
                    hashSet.add(2);
                    continue block5;
                }
                case 3: 
            }
            n2 = a.g(parcel, n6);
            hashSet.add(3);
        }
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.am(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.aU(n2);
    }
}

