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

public class hd
implements Parcelable.Creator<ha.b> {
    static void a(ha.b b2, Parcel parcel, int n2) {
        int n3 = b.l(parcel);
        Set<Integer> set = b2.eF();
        if (set.contains(1)) {
            b.c(parcel, 1, b2.getVersionCode());
        }
        if (set.contains(2)) {
            b.a(parcel, 2, b2.fj(), n2, true);
        }
        if (set.contains(3)) {
            b.a(parcel, 3, b2.fk(), n2, true);
        }
        if (set.contains(4)) {
            b.c(parcel, 4, b2.getLayout());
        }
        b.D(parcel, n3);
    }

    public ha.b[] aV(int n2) {
        return new ha.b[n2];
    }

    public ha.b an(Parcel parcel) {
        ha.b.b b2 = null;
        int n2 = 0;
        int n3 = a.k(parcel);
        HashSet<Integer> hashSet = new HashSet<Integer>();
        ha.b.a a2 = null;
        int n4 = 0;
        block6: while (true) {
            if (parcel.dataPosition() >= n3) {
                if (parcel.dataPosition() == n3) return new ha.b(hashSet, n4, a2, b2, n2);
                throw new a.a("Overread allowed size end=" + n3, parcel);
            }
            int n5 = a.j(parcel);
            switch (a.A(n5)) {
                default: {
                    a.b(parcel, n5);
                    continue block6;
                }
                case 1: {
                    n4 = a.g(parcel, n5);
                    hashSet.add(1);
                    continue block6;
                }
                case 2: {
                    a2 = a.a(parcel, n5, ha.b.a.CREATOR);
                    hashSet.add(2);
                    continue block6;
                }
                case 3: {
                    b2 = a.a(parcel, n5, ha.b.b.CREATOR);
                    hashSet.add(3);
                    continue block6;
                }
                case 4: 
            }
            n2 = a.g(parcel, n5);
            hashSet.add(4);
        }
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.an(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.aV(n2);
    }
}

