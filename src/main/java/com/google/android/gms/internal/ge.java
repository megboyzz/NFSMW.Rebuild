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
import com.google.android.gms.internal.gd;
import java.util.ArrayList;

public class ge
implements Parcelable.Creator<gd> {
    static void a(gd gd2, Parcel parcel, int n2) {
        n2 = b.l(parcel);
        b.a(parcel, 1, gd2.name, false);
        b.c(parcel, 1000, gd2.versionCode);
        b.a(parcel, 2, gd2.xa, false);
        b.a(parcel, 3, gd2.xb, false);
        b.a(parcel, 4, gd2.xc, false);
        b.a(parcel, 5, gd2.xd, false);
        b.D(parcel, n2);
    }

    public gd[] aM(int n2) {
        return new gd[n2];
    }

    public gd ag(Parcel parcel) {
        ArrayList<String> arrayList = null;
        int n2 = a.k(parcel);
        int n3 = 0;
        String string2 = null;
        String string3 = null;
        String string4 = null;
        String string5 = null;
        block8: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new gd(n3, string5, string4, string3, string2, arrayList);
                throw new a.a("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.j(parcel);
            switch (a.A(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block8;
                }
                case 1: {
                    string5 = a.m(parcel, n4);
                    continue block8;
                }
                case 1000: {
                    n3 = a.g(parcel, n4);
                    continue block8;
                }
                case 2: {
                    string4 = a.m(parcel, n4);
                    continue block8;
                }
                case 3: {
                    string3 = a.m(parcel, n4);
                    continue block8;
                }
                case 4: {
                    string2 = a.m(parcel, n4);
                    continue block8;
                }
                case 5: 
            }
            arrayList = a.y(parcel, n4);
        }
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.ag(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.aM(n2);
    }
}

