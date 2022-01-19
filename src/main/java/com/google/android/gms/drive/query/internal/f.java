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
import com.google.android.gms.drive.query.internal.FilterHolder;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.Operator;
import java.util.ArrayList;

public class f
implements Parcelable.Creator<LogicalFilter> {
    static void a(LogicalFilter logicalFilter, Parcel parcel, int n2) {
        int n3 = b.l(parcel);
        b.c(parcel, 1000, logicalFilter.kZ);
        b.a(parcel, 1, logicalFilter.pf, n2, false);
        b.b(parcel, 2, logicalFilter.pp, false);
        b.D(parcel, n3);
    }

    public LogicalFilter R(Parcel parcel) {
        ArrayList<FilterHolder> arrayList = null;
        int n2 = a.k(parcel);
        int n3 = 0;
        Operator operator = null;
        block5: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new LogicalFilter(n3, operator, arrayList);
                throw new a.a("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.j(parcel);
            switch (a.A(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block5;
                }
                case 1000: {
                    n3 = a.g(parcel, n4);
                    continue block5;
                }
                case 1: {
                    operator = a.a(parcel, n4, Operator.CREATOR);
                    continue block5;
                }
                case 2: 
            }
            arrayList = a.c(parcel, n4, FilterHolder.CREATOR);
        }
    }

    public LogicalFilter[] ai(int n2) {
        return new LogicalFilter[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.R(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.ai(n2);
    }
}

