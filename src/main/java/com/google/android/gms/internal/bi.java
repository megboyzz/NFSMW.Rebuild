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
import com.google.android.gms.internal.bj;

public class bi
implements Parcelable.Creator<bj> {
    static void a(bj bj2, Parcel parcel, int n2) {
        n2 = b.l(parcel);
        b.c(parcel, 1, bj2.versionCode);
        b.a(parcel, 2, bj2.gm, false);
        b.a(parcel, 3, bj2.gn, false);
        b.a(parcel, 4, bj2.mimeType, false);
        b.a(parcel, 5, bj2.packageName, false);
        b.a(parcel, 6, bj2.go, false);
        b.a(parcel, 7, bj2.gp, false);
        b.a(parcel, 8, bj2.gq, false);
        b.D(parcel, n2);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.d(parcel);
    }

    public bj d(Parcel parcel) {
        String string2 = null;
        int n2 = a.k(parcel);
        int n3 = 0;
        String string3 = null;
        String string4 = null;
        String string5 = null;
        String string6 = null;
        String string7 = null;
        String string8 = null;
        block10: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new bj(n3, string8, string7, string6, string5, string4, string3, string2);
                throw new a.a("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.j(parcel);
            switch (a.A(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block10;
                }
                case 1: {
                    n3 = a.g(parcel, n4);
                    continue block10;
                }
                case 2: {
                    string8 = a.m(parcel, n4);
                    continue block10;
                }
                case 3: {
                    string7 = a.m(parcel, n4);
                    continue block10;
                }
                case 4: {
                    string6 = a.m(parcel, n4);
                    continue block10;
                }
                case 5: {
                    string5 = a.m(parcel, n4);
                    continue block10;
                }
                case 6: {
                    string4 = a.m(parcel, n4);
                    continue block10;
                }
                case 7: {
                    string3 = a.m(parcel, n4);
                    continue block10;
                }
                case 8: 
            }
            string2 = a.m(parcel, n4);
        }
    }

    public bj[] i(int n2) {
        return new bj[n2];
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.i(n2);
    }
}

