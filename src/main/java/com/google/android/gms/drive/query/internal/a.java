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
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.internal.ComparisonFilter;
import com.google.android.gms.drive.query.internal.Operator;

public class a
implements Parcelable.Creator<ComparisonFilter> {
    static void a(ComparisonFilter comparisonFilter, Parcel parcel, int n2) {
        int n3 = b.l(parcel);
        b.c(parcel, 1000, comparisonFilter.kZ);
        b.a(parcel, 1, comparisonFilter.pf, n2, false);
        b.a(parcel, 2, comparisonFilter.pg, n2, false);
        b.D(parcel, n3);
    }

    public ComparisonFilter N(Parcel parcel) {
        MetadataBundle metadataBundle = null;
        int n2 = com.google.android.gms.common.internal.safeparcel.a.k(parcel);
        int n3 = 0;
        Operator operator = null;
        block5: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new ComparisonFilter(n3, operator, metadataBundle);
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
                    operator = com.google.android.gms.common.internal.safeparcel.a.a(parcel, n4, Operator.CREATOR);
                    continue block5;
                }
                case 2: 
            }
            metadataBundle = com.google.android.gms.common.internal.safeparcel.a.a(parcel, n4, MetadataBundle.CREATOR);
        }
    }

    public ComparisonFilter[] ae(int n2) {
        return new ComparisonFilter[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.N(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.ae(n2);
    }
}

