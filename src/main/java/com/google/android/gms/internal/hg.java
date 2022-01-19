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

public class hg
implements Parcelable.Creator<ha.c> {
    static void a(ha.c c2, Parcel parcel, int n2) {
        n2 = b.l(parcel);
        Set<Integer> set = c2.eF();
        if (set.contains(1)) {
            b.c(parcel, 1, c2.getVersionCode());
        }
        if (set.contains(2)) {
            b.a(parcel, 2, c2.getUrl(), true);
        }
        b.D(parcel, n2);
    }

    public ha.c[] aY(int n2) {
        return new ha.c[n2];
    }

    public ha.c aq(Parcel parcel) {
        int n2 = a.k(parcel);
        HashSet<Integer> hashSet = new HashSet<Integer>();
        int n3 = 0;
        String string2 = null;
        block4: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new ha.c(hashSet, n3, string2);
                throw new a.a("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.j(parcel);
            switch (a.A(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block4;
                }
                case 1: {
                    n3 = a.g(parcel, n4);
                    hashSet.add(1);
                    continue block4;
                }
                case 2: 
            }
            string2 = a.m(parcel, n4);
            hashSet.add(2);
        }
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.aq(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.aY(n2);
    }
}

