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

public class hk
implements Parcelable.Creator<ha.h> {
    static void a(ha.h h2, Parcel parcel, int n2) {
        n2 = b.l(parcel);
        Set<Integer> set = h2.eF();
        if (set.contains(1)) {
            b.c(parcel, 1, h2.getVersionCode());
        }
        if (set.contains(3)) {
            b.c(parcel, 3, h2.fs());
        }
        if (set.contains(4)) {
            b.a(parcel, 4, h2.getValue(), true);
        }
        if (set.contains(5)) {
            b.a(parcel, 5, h2.getLabel(), true);
        }
        if (set.contains(6)) {
            b.c(parcel, 6, h2.getType());
        }
        b.D(parcel, n2);
    }

    public ha.h au(Parcel parcel) {
        String string2 = null;
        int n2 = 0;
        int n3 = a.k(parcel);
        HashSet<Integer> hashSet = new HashSet<Integer>();
        int n4 = 0;
        String string3 = null;
        int n5 = 0;
        block7: while (true) {
            if (parcel.dataPosition() >= n3) {
                if (parcel.dataPosition() == n3) return new ha.h(hashSet, n5, string3, n4, string2, n2);
                throw new a.a("Overread allowed size end=" + n3, parcel);
            }
            int n6 = a.j(parcel);
            switch (a.A(n6)) {
                default: {
                    a.b(parcel, n6);
                    continue block7;
                }
                case 1: {
                    n5 = a.g(parcel, n6);
                    hashSet.add(1);
                    continue block7;
                }
                case 3: {
                    n2 = a.g(parcel, n6);
                    hashSet.add(3);
                    continue block7;
                }
                case 4: {
                    string2 = a.m(parcel, n6);
                    hashSet.add(4);
                    continue block7;
                }
                case 5: {
                    string3 = a.m(parcel, n6);
                    hashSet.add(5);
                    continue block7;
                }
                case 6: 
            }
            n4 = a.g(parcel, n6);
            hashSet.add(6);
        }
    }

    public ha.h[] bc(int n2) {
        return new ha.h[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.au(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.bc(n2);
    }
}

