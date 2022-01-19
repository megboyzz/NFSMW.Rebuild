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

public class hh
implements Parcelable.Creator<ha.d> {
    static void a(ha.d d2, Parcel parcel, int n2) {
        n2 = b.l(parcel);
        Set<Integer> set = d2.eF();
        if (set.contains(1)) {
            b.c(parcel, 1, d2.getVersionCode());
        }
        if (set.contains(2)) {
            b.a(parcel, 2, d2.getFamilyName(), true);
        }
        if (set.contains(3)) {
            b.a(parcel, 3, d2.getFormatted(), true);
        }
        if (set.contains(4)) {
            b.a(parcel, 4, d2.getGivenName(), true);
        }
        if (set.contains(5)) {
            b.a(parcel, 5, d2.getHonorificPrefix(), true);
        }
        if (set.contains(6)) {
            b.a(parcel, 6, d2.getHonorificSuffix(), true);
        }
        if (set.contains(7)) {
            b.a(parcel, 7, d2.getMiddleName(), true);
        }
        b.D(parcel, n2);
    }

    public ha.d[] aZ(int n2) {
        return new ha.d[n2];
    }

    public ha.d ar(Parcel parcel) {
        String string2 = null;
        int n2 = a.k(parcel);
        HashSet<Integer> hashSet = new HashSet<Integer>();
        int n3 = 0;
        String string3 = null;
        String string4 = null;
        String string5 = null;
        String string6 = null;
        String string7 = null;
        block9: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new ha.d(hashSet, n3, string7, string6, string5, string4, string3, string2);
                throw new a.a("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.j(parcel);
            switch (a.A(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block9;
                }
                case 1: {
                    n3 = a.g(parcel, n4);
                    hashSet.add(1);
                    continue block9;
                }
                case 2: {
                    string7 = a.m(parcel, n4);
                    hashSet.add(2);
                    continue block9;
                }
                case 3: {
                    string6 = a.m(parcel, n4);
                    hashSet.add(3);
                    continue block9;
                }
                case 4: {
                    string5 = a.m(parcel, n4);
                    hashSet.add(4);
                    continue block9;
                }
                case 5: {
                    string4 = a.m(parcel, n4);
                    hashSet.add(5);
                    continue block9;
                }
                case 6: {
                    string3 = a.m(parcel, n4);
                    hashSet.add(6);
                    continue block9;
                }
                case 7: 
            }
            string2 = a.m(parcel, n4);
            hashSet.add(7);
        }
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.ar(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.aZ(n2);
    }
}

