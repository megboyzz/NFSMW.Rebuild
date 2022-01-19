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

public class hi
implements Parcelable.Creator<ha.f> {
    static void a(ha.f f2, Parcel parcel, int n2) {
        n2 = b.l(parcel);
        Set<Integer> set = f2.eF();
        if (set.contains(1)) {
            b.c(parcel, 1, f2.getVersionCode());
        }
        if (set.contains(2)) {
            b.a(parcel, 2, f2.getDepartment(), true);
        }
        if (set.contains(3)) {
            b.a(parcel, 3, f2.getDescription(), true);
        }
        if (set.contains(4)) {
            b.a(parcel, 4, f2.getEndDate(), true);
        }
        if (set.contains(5)) {
            b.a(parcel, 5, f2.getLocation(), true);
        }
        if (set.contains(6)) {
            b.a(parcel, 6, f2.getName(), true);
        }
        if (set.contains(7)) {
            b.a(parcel, 7, f2.isPrimary());
        }
        if (set.contains(8)) {
            b.a(parcel, 8, f2.getStartDate(), true);
        }
        if (set.contains(9)) {
            b.a(parcel, 9, f2.getTitle(), true);
        }
        if (set.contains(10)) {
            b.c(parcel, 10, f2.getType());
        }
        b.D(parcel, n2);
    }

    public ha.f as(Parcel parcel) {
        int n2 = 0;
        String string2 = null;
        int n3 = a.k(parcel);
        HashSet<Integer> hashSet = new HashSet<Integer>();
        String string3 = null;
        boolean bl2 = false;
        String string4 = null;
        String string5 = null;
        String string6 = null;
        String string7 = null;
        String string8 = null;
        int n4 = 0;
        block12: while (true) {
            if (parcel.dataPosition() >= n3) {
                if (parcel.dataPosition() == n3) return new ha.f(hashSet, n4, string8, string7, string6, string5, string4, bl2, string3, string2, n2);
                throw new a.a("Overread allowed size end=" + n3, parcel);
            }
            int n5 = a.j(parcel);
            switch (a.A(n5)) {
                default: {
                    a.b(parcel, n5);
                    continue block12;
                }
                case 1: {
                    n4 = a.g(parcel, n5);
                    hashSet.add(1);
                    continue block12;
                }
                case 2: {
                    string8 = a.m(parcel, n5);
                    hashSet.add(2);
                    continue block12;
                }
                case 3: {
                    string7 = a.m(parcel, n5);
                    hashSet.add(3);
                    continue block12;
                }
                case 4: {
                    string6 = a.m(parcel, n5);
                    hashSet.add(4);
                    continue block12;
                }
                case 5: {
                    string5 = a.m(parcel, n5);
                    hashSet.add(5);
                    continue block12;
                }
                case 6: {
                    string4 = a.m(parcel, n5);
                    hashSet.add(6);
                    continue block12;
                }
                case 7: {
                    bl2 = a.c(parcel, n5);
                    hashSet.add(7);
                    continue block12;
                }
                case 8: {
                    string3 = a.m(parcel, n5);
                    hashSet.add(8);
                    continue block12;
                }
                case 9: {
                    string2 = a.m(parcel, n5);
                    hashSet.add(9);
                    continue block12;
                }
                case 10: 
            }
            n2 = a.g(parcel, n5);
            hashSet.add(10);
        }
    }

    public ha.f[] ba(int n2) {
        return new ha.f[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.as(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.ba(n2);
    }
}

