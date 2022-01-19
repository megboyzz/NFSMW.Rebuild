/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.x;

public class y
implements Parcelable.Creator<x> {
    static void a(x x2, Parcel parcel, int n2) {
        int n3 = b.l(parcel);
        b.c(parcel, 1, x2.versionCode);
        b.a(parcel, 2, x2.eF, false);
        b.c(parcel, 3, x2.height);
        b.c(parcel, 4, x2.heightPixels);
        b.a(parcel, 5, x2.eG);
        b.c(parcel, 6, x2.width);
        b.c(parcel, 7, x2.widthPixels);
        b.a((Parcel)parcel, (int)8, (Parcelable[])x2.eH, (int)n2, (boolean)false);
        b.D(parcel, n3);
    }

    public x b(Parcel parcel) {
        x[] xArray = null;
        int n2 = 0;
        int n3 = a.k(parcel);
        int n4 = 0;
        boolean bl2 = false;
        int n5 = 0;
        int n6 = 0;
        String string2 = null;
        int n7 = 0;
        block10: while (true) {
            if (parcel.dataPosition() >= n3) {
                if (parcel.dataPosition() == n3) return new x(n7, string2, n6, n5, bl2, n4, n2, xArray);
                throw new a.a("Overread allowed size end=" + n3, parcel);
            }
            int n8 = a.j(parcel);
            switch (a.A(n8)) {
                default: {
                    a.b(parcel, n8);
                    continue block10;
                }
                case 1: {
                    n7 = a.g(parcel, n8);
                    continue block10;
                }
                case 2: {
                    string2 = a.m(parcel, n8);
                    continue block10;
                }
                case 3: {
                    n6 = a.g(parcel, n8);
                    continue block10;
                }
                case 4: {
                    n5 = a.g(parcel, n8);
                    continue block10;
                }
                case 5: {
                    bl2 = a.c(parcel, n8);
                    continue block10;
                }
                case 6: {
                    n4 = a.g(parcel, n8);
                    continue block10;
                }
                case 7: {
                    n2 = a.g(parcel, n8);
                    continue block10;
                }
                case 8: 
            }
            xArray = a.b(parcel, n8, x.CREATOR);
        }
    }

    public x[] c(int n2) {
        return new x[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.b(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.c(n2);
    }
}

