/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.drive.query.internal.LogicalFilter;

public class a
implements Parcelable.Creator<Query> {
    static void a(Query query, Parcel parcel, int n2) {
        int n3 = b.l(parcel);
        b.c(parcel, 1000, query.kZ);
        b.a(parcel, 1, query.pc, n2, false);
        b.a(parcel, 3, query.pd, false);
        b.D(parcel, n3);
    }

    public Query M(Parcel parcel) {
        String string2 = null;
        int n2 = com.google.android.gms.common.internal.safeparcel.a.k(parcel);
        int n3 = 0;
        LogicalFilter logicalFilter = null;
        block5: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new Query(n3, logicalFilter, string2);
                throw new a.a("Overread allowed size end=" + n2, parcel);
            }
            int n4 = com.google.android.gms.common.internal.safeparcel.a.j(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.A(n4)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, n4);
                    continue block5;
                }
                case 1000: {
                    n3 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, n4);
                    continue block5;
                }
                case 1: {
                    logicalFilter = com.google.android.gms.common.internal.safeparcel.a.a(parcel, n4, LogicalFilter.CREATOR);
                    continue block5;
                }
                case 3: 
            }
            string2 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, n4);
        }
    }

    public Query[] ad(int n2) {
        return new Query[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.M(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.ad(n2);
    }
}

