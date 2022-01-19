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
import com.google.android.gms.drive.query.internal.ComparisonFilter;
import com.google.android.gms.drive.query.internal.FieldOnlyFilter;
import com.google.android.gms.drive.query.internal.FilterHolder;
import com.google.android.gms.drive.query.internal.InFilter;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.NotFilter;

public class c
implements Parcelable.Creator<FilterHolder> {
    static void a(FilterHolder filterHolder, Parcel parcel, int n2) {
        int n3 = b.l(parcel);
        b.a(parcel, 1, filterHolder.pi, n2, false);
        b.c(parcel, 1000, filterHolder.kZ);
        b.a(parcel, 2, filterHolder.pj, n2, false);
        b.a(parcel, 3, filterHolder.pk, n2, false);
        b.a(parcel, 4, filterHolder.pl, n2, false);
        b.a(parcel, 5, filterHolder.pm, n2, false);
        b.D(parcel, n3);
    }

    public FilterHolder P(Parcel parcel) {
        InFilter inFilter = null;
        int n2 = a.k(parcel);
        int n3 = 0;
        NotFilter notFilter = null;
        LogicalFilter logicalFilter = null;
        FieldOnlyFilter fieldOnlyFilter = null;
        ComparisonFilter comparisonFilter = null;
        block8: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new FilterHolder(n3, comparisonFilter, fieldOnlyFilter, logicalFilter, notFilter, inFilter);
                throw new a.a("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.j(parcel);
            switch (a.A(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block8;
                }
                case 1: {
                    comparisonFilter = a.a(parcel, n4, ComparisonFilter.CREATOR);
                    continue block8;
                }
                case 1000: {
                    n3 = a.g(parcel, n4);
                    continue block8;
                }
                case 2: {
                    fieldOnlyFilter = a.a(parcel, n4, FieldOnlyFilter.CREATOR);
                    continue block8;
                }
                case 3: {
                    logicalFilter = a.a(parcel, n4, LogicalFilter.CREATOR);
                    continue block8;
                }
                case 4: {
                    notFilter = a.a(parcel, n4, NotFilter.CREATOR);
                    continue block8;
                }
                case 5: 
            }
            inFilter = a.a(parcel, n4, InFilter.CREATOR);
        }
    }

    public FilterHolder[] ag(int n2) {
        return new FilterHolder[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.P(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.ag(n2);
    }
}

