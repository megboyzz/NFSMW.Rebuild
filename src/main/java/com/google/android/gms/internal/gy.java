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
import com.google.android.gms.internal.gv;
import com.google.android.gms.internal.gx;
import java.util.HashSet;
import java.util.Set;

public class gy
implements Parcelable.Creator<gx> {
    static void a(gx gx2, Parcel parcel, int n2) {
        int n3 = b.l(parcel);
        Set<Integer> set = gx2.eF();
        if (set.contains(1)) {
            b.c(parcel, 1, gx2.getVersionCode());
        }
        if (set.contains(2)) {
            b.a(parcel, 2, gx2.getId(), true);
        }
        if (set.contains(4)) {
            b.a(parcel, 4, gx2.eW(), n2, true);
        }
        if (set.contains(5)) {
            b.a(parcel, 5, gx2.getStartDate(), true);
        }
        if (set.contains(6)) {
            b.a(parcel, 6, gx2.eX(), n2, true);
        }
        if (set.contains(7)) {
            b.a(parcel, 7, gx2.getType(), true);
        }
        b.D(parcel, n3);
    }

    public gx[] aS(int n2) {
        return new gx[n2];
    }

    public gx ak(Parcel parcel) {
        String string2 = null;
        int n2 = a.k(parcel);
        HashSet<Integer> hashSet = new HashSet<Integer>();
        int n3 = 0;
        gv gv2 = null;
        String string3 = null;
        gv gv3 = null;
        String string4 = null;
        block8: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new gx(hashSet, n3, string4, gv3, string3, gv2, string2);
                throw new a.a("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.j(parcel);
            switch (a.A(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block8;
                }
                case 1: {
                    n3 = a.g(parcel, n4);
                    hashSet.add(1);
                    continue block8;
                }
                case 2: {
                    string4 = a.m(parcel, n4);
                    hashSet.add(2);
                    continue block8;
                }
                case 4: {
                    gv3 = a.a(parcel, n4, gv.CREATOR);
                    hashSet.add(4);
                    continue block8;
                }
                case 5: {
                    string3 = a.m(parcel, n4);
                    hashSet.add(5);
                    continue block8;
                }
                case 6: {
                    gv2 = a.a(parcel, n4, gv.CREATOR);
                    hashSet.add(6);
                    continue block8;
                }
                case 7: 
            }
            string2 = a.m(parcel, n4);
            hashSet.add(7);
        }
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.ak(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.aS(n2);
    }
}

