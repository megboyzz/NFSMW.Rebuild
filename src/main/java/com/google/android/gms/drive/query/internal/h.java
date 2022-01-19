/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.query.internal.Operator;

public class h
implements Parcelable.Creator<Operator> {
    static void a(Operator operator, Parcel parcel, int n2) {
        n2 = b.l(parcel);
        b.c(parcel, 1000, operator.kZ);
        b.a(parcel, 1, operator.mTag, false);
        b.D(parcel, n2);
    }

    public Operator T(Parcel parcel) {
        int n2 = a.k(parcel);
        int n3 = 0;
        String string2 = null;
        block4: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new Operator(n3, string2);
                throw new a.a("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.j(parcel);
            switch (a.A(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block4;
                }
                case 1000: {
                    n3 = a.g(parcel, n4);
                    continue block4;
                }
                case 1: 
            }
            string2 = a.m(parcel, n4);
        }
    }

    public Operator[] ak(int n2) {
        return new Operator[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.T(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.ak(n2);
    }
}

