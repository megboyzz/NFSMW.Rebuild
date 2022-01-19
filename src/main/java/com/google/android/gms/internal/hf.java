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

public class hf
implements Parcelable.Creator<ha.b.b> {
    static void a(ha.b.b b2, Parcel parcel, int n2) {
        n2 = b.l(parcel);
        Set<Integer> set = b2.eF();
        if (set.contains(1)) {
            b.c(parcel, 1, b2.getVersionCode());
        }
        if (set.contains(2)) {
            b.c(parcel, 2, b2.getHeight());
        }
        if (set.contains(3)) {
            b.a(parcel, 3, b2.getUrl(), true);
        }
        if (set.contains(4)) {
            b.c(parcel, 4, b2.getWidth());
        }
        b.D(parcel, n2);
    }

    public ha.b.b[] aX(int n2) {
        return new ha.b.b[n2];
    }

    public ha.b.b ap(Parcel parcel) {
        int n2 = 0;
        int n3 = a.k(parcel);
        HashSet<Integer> hashSet = new HashSet<Integer>();
        String string2 = null;
        int n4 = 0;
        int n5 = 0;
        block6: while (true) {
            if (parcel.dataPosition() >= n3) {
                if (parcel.dataPosition() == n3) return new ha.b.b(hashSet, n5, n4, string2, n2);
                throw new a.a("Overread allowed size end=" + n3, parcel);
            }
            int n6 = a.j(parcel);
            switch (a.A(n6)) {
                default: {
                    a.b(parcel, n6);
                    continue block6;
                }
                case 1: {
                    n5 = a.g(parcel, n6);
                    hashSet.add(1);
                    continue block6;
                }
                case 2: {
                    n4 = a.g(parcel, n6);
                    hashSet.add(2);
                    continue block6;
                }
                case 3: {
                    string2 = a.m(parcel, n6);
                    hashSet.add(3);
                    continue block6;
                }
                case 4: 
            }
            n2 = a.g(parcel, n6);
            hashSet.add(4);
        }
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.ap(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.aX(n2);
    }
}

