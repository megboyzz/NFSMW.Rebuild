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
import com.google.android.gms.internal.fs;
import com.google.android.gms.internal.fw;
import java.util.ArrayList;

public class ft
implements Parcelable.Creator<fs> {
    static void a(fs fs2, Parcel parcel, int n2) {
        n2 = b.l(parcel);
        b.c(parcel, 1, fs2.dw());
        b.c(parcel, 1000, fs2.kZ);
        b.b(parcel, 2, fs2.ud, false);
        b.a(parcel, 3, fs2.dx(), false);
        b.a(parcel, 4, fs2.dy(), false);
        b.a(parcel, 5, fs2.dz());
        b.D(parcel, n2);
    }

    public fs[] aH(int n2) {
        return new fs[n2];
    }

    public fs ab(Parcel parcel) {
        String string2 = null;
        boolean bl2 = false;
        int n2 = a.k(parcel);
        String string3 = null;
        ArrayList<fw> arrayList = null;
        int n3 = 0;
        int n4 = 0;
        block8: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new fs(n4, n3, arrayList, string3, string2, bl2);
                throw new a.a("Overread allowed size end=" + n2, parcel);
            }
            int n5 = a.j(parcel);
            switch (a.A(n5)) {
                default: {
                    a.b(parcel, n5);
                    continue block8;
                }
                case 1: {
                    n3 = a.g(parcel, n5);
                    continue block8;
                }
                case 1000: {
                    n4 = a.g(parcel, n5);
                    continue block8;
                }
                case 2: {
                    arrayList = a.c(parcel, n5, fw.CREATOR);
                    continue block8;
                }
                case 3: {
                    string3 = a.m(parcel, n5);
                    continue block8;
                }
                case 4: {
                    string2 = a.m(parcel, n5);
                    continue block8;
                }
                case 5: 
            }
            bl2 = a.c(parcel, n5);
        }
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.ab(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.aH(n2);
    }
}

