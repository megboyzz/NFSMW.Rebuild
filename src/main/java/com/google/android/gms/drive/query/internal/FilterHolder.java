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
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Filter;
import com.google.android.gms.drive.query.internal.ComparisonFilter;
import com.google.android.gms.drive.query.internal.FieldOnlyFilter;
import com.google.android.gms.drive.query.internal.InFilter;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.NotFilter;
import com.google.android.gms.drive.query.internal.c;

public class FilterHolder
implements SafeParcelable {
    public static final Parcelable.Creator<FilterHolder> CREATOR = new c();
    final int kZ;
    final ComparisonFilter<?> pi;
    final FieldOnlyFilter pj;
    final LogicalFilter pk;
    final NotFilter pl;
    final InFilter<?> pm;
    private final Filter pn;

    FilterHolder(int n2, ComparisonFilter<?> comparisonFilter, FieldOnlyFilter fieldOnlyFilter, LogicalFilter logicalFilter, NotFilter notFilter, InFilter<?> inFilter) {
        this.kZ = n2;
        this.pi = comparisonFilter;
        this.pj = fieldOnlyFilter;
        this.pk = logicalFilter;
        this.pl = notFilter;
        this.pm = inFilter;
        if (this.pi != null) {
            this.pn = this.pi;
            return;
        }
        if (this.pj != null) {
            this.pn = this.pj;
            return;
        }
        if (this.pk != null) {
            this.pn = this.pk;
            return;
        }
        if (this.pl != null) {
            this.pn = this.pl;
            return;
        }
        if (this.pm == null) throw new IllegalArgumentException("At least one filter must be set.");
        this.pn = this.pm;
    }

    public FilterHolder(Filter filter) {
        this.kZ = 1;
        SafeParcelable safeParcelable = filter instanceof ComparisonFilter ? (ComparisonFilter)filter : null;
        this.pi = safeParcelable;
        safeParcelable = filter instanceof FieldOnlyFilter ? (FieldOnlyFilter)filter : null;
        this.pj = safeParcelable;
        safeParcelable = filter instanceof LogicalFilter ? (LogicalFilter)filter : null;
        this.pk = safeParcelable;
        safeParcelable = filter instanceof NotFilter ? (NotFilter)filter : null;
        this.pl = safeParcelable;
        safeParcelable = filter instanceof InFilter ? (InFilter)filter : null;
        this.pm = safeParcelable;
        if (this.pi == null && this.pj == null && this.pk == null && this.pl == null && this.pm == null) {
            throw new IllegalArgumentException("Invalid filter type or null filter.");
        }
        this.pn = filter;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        c.a(this, parcel, n2);
    }
}

