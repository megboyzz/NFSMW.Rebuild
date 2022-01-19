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
import com.google.android.gms.internal.eh;
import java.util.ArrayList;

public class ei
implements Parcelable.Creator<eh> {
    static void a(eh eh2, Parcel parcel, int n2) {
        n2 = b.l(parcel);
        b.c(parcel, 1, eh2.getVersionCode());
        b.b(parcel, 2, eh2.cf(), false);
        b.a(parcel, 3, eh2.cg(), false);
        b.D(parcel, n2);
    }

    public eh[] G(int n2) {
        return new eh[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.r(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.G(n2);
    }

    public eh r(Parcel parcel) {
        String string2 = null;
        int n2 = a.k(parcel);
        int n3 = 0;
        ArrayList<eh.a> arrayList = null;
        block5: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new eh(n3, arrayList, string2);
                throw new a.a("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.j(parcel);
            switch (a.A(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block5;
                }
                case 1: {
                    n3 = a.g(parcel, n4);
                    continue block5;
                }
                case 2: {
                    arrayList = a.c(parcel, n4, eh.a.CREATOR);
                    continue block5;
                }
                case 3: 
            }
            string2 = a.m(parcel, n4);
        }
    }
}

