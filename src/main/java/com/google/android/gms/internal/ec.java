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
import com.google.android.gms.internal.eb;
import java.util.ArrayList;

public class ec
implements Parcelable.Creator<eb> {
    static void a(eb eb2, Parcel parcel, int n2) {
        n2 = b.l(parcel);
        b.c(parcel, 1, eb2.getVersionCode());
        b.b(parcel, 2, eb2.bN(), false);
        b.D(parcel, n2);
    }

    public eb[] C(int n2) {
        return new eb[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.n(parcel);
    }

    public eb n(Parcel parcel) {
        int n2 = a.k(parcel);
        int n3 = 0;
        ArrayList<eb.a> arrayList = null;
        block4: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new eb(n3, arrayList);
                throw new a.a("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.j(parcel);
            switch (a.A(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block4;
                }
                case 1: {
                    n3 = a.g(parcel, n4);
                    continue block4;
                }
                case 2: 
            }
            arrayList = a.c(parcel, n4, eb.a.CREATOR);
        }
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.C(n2);
    }
}

