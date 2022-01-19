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
import com.google.android.gms.internal.ai;

public class aj
implements Parcelable.Creator<ai> {
    static void a(ai ai2, Parcel parcel, int n2) {
        n2 = b.l(parcel);
        b.c(parcel, 1, ai2.versionCode);
        b.c(parcel, 2, ai2.eZ);
        b.c(parcel, 3, ai2.backgroundColor);
        b.c(parcel, 4, ai2.fa);
        b.c(parcel, 5, ai2.fb);
        b.c(parcel, 6, ai2.fc);
        b.c(parcel, 7, ai2.fd);
        b.c(parcel, 8, ai2.fe);
        b.c(parcel, 9, ai2.ff);
        b.a(parcel, 10, ai2.fg, false);
        b.c(parcel, 11, ai2.fh);
        b.a(parcel, 12, ai2.fi, false);
        b.c(parcel, 13, ai2.fj);
        b.c(parcel, 14, ai2.fk);
        b.a(parcel, 15, ai2.fl, false);
        b.D(parcel, n2);
    }

    public ai c(Parcel parcel) {
        int n2 = a.k(parcel);
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        int n9 = 0;
        int n10 = 0;
        int n11 = 0;
        String string2 = null;
        int n12 = 0;
        String string3 = null;
        int n13 = 0;
        int n14 = 0;
        String string4 = null;
        block17: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new ai(n3, n4, n5, n6, n7, n8, n9, n10, n11, string2, n12, string3, n13, n14, string4);
                throw new a.a("Overread allowed size end=" + n2, parcel);
            }
            int n15 = a.j(parcel);
            switch (a.A(n15)) {
                default: {
                    a.b(parcel, n15);
                    continue block17;
                }
                case 1: {
                    n3 = a.g(parcel, n15);
                    continue block17;
                }
                case 2: {
                    n4 = a.g(parcel, n15);
                    continue block17;
                }
                case 3: {
                    n5 = a.g(parcel, n15);
                    continue block17;
                }
                case 4: {
                    n6 = a.g(parcel, n15);
                    continue block17;
                }
                case 5: {
                    n7 = a.g(parcel, n15);
                    continue block17;
                }
                case 6: {
                    n8 = a.g(parcel, n15);
                    continue block17;
                }
                case 7: {
                    n9 = a.g(parcel, n15);
                    continue block17;
                }
                case 8: {
                    n10 = a.g(parcel, n15);
                    continue block17;
                }
                case 9: {
                    n11 = a.g(parcel, n15);
                    continue block17;
                }
                case 10: {
                    string2 = a.m(parcel, n15);
                    continue block17;
                }
                case 11: {
                    n12 = a.g(parcel, n15);
                    continue block17;
                }
                case 12: {
                    string3 = a.m(parcel, n15);
                    continue block17;
                }
                case 13: {
                    n13 = a.g(parcel, n15);
                    continue block17;
                }
                case 14: {
                    n14 = a.g(parcel, n15);
                    continue block17;
                }
                case 15: 
            }
            string4 = a.m(parcel, n15);
        }
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.c(parcel);
    }

    public ai[] e(int n2) {
        return new ai[n2];
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.e(n2);
    }
}

