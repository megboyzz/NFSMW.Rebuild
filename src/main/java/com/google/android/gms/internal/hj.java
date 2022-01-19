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

public class hj
implements Parcelable.Creator<ha.g> {
    static void a(ha.g g2, Parcel parcel, int n2) {
        n2 = b.l(parcel);
        Set<Integer> set = g2.eF();
        if (set.contains(1)) {
            b.c(parcel, 1, g2.getVersionCode());
        }
        if (set.contains(2)) {
            b.a(parcel, 2, g2.isPrimary());
        }
        if (set.contains(3)) {
            b.a(parcel, 3, g2.getValue(), true);
        }
        b.D(parcel, n2);
    }

    public ha.g at(Parcel parcel) {
        boolean bl2 = false;
        int n2 = a.k(parcel);
        HashSet<Integer> hashSet = new HashSet<Integer>();
        String string2 = null;
        int n3 = 0;
        block5: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new ha.g(hashSet, n3, bl2, string2);
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
                    hashSet.add(1);
                    continue block5;
                }
                case 2: {
                    bl2 = a.c(parcel, n4);
                    hashSet.add(2);
                    continue block5;
                }
                case 3: 
            }
            string2 = a.m(parcel, n4);
            hashSet.add(3);
        }
    }

    public ha.g[] bb(int n2) {
        return new ha.g[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.at(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.bb(n2);
    }
}

