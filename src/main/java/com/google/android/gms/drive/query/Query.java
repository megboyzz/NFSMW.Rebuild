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
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Filter;
import com.google.android.gms.drive.query.a;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.Operator;
import java.util.ArrayList;
import java.util.List;

public class Query
implements SafeParcelable {
    public static final Parcelable.Creator<Query> CREATOR = new a();
    final int kZ;
    LogicalFilter pc;
    String pd;

    Query(int n2, LogicalFilter logicalFilter, String string2) {
        this.kZ = n2;
        this.pc = logicalFilter;
        this.pd = string2;
    }

    Query(LogicalFilter logicalFilter, String string2) {
        this(1, logicalFilter, string2);
    }

    public int describeContents() {
        return 0;
    }

    public Filter getFilter() {
        return this.pc;
    }

    public String getPageToken() {
        return this.pd;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        a.a(this, parcel, n2);
    }

    public static class Builder {
        private String pd;
        private final List<Filter> pe = new ArrayList<Filter>();

        public Builder addFilter(Filter filter) {
            this.pe.add(filter);
            return this;
        }

        public Query build() {
            return new Query(new LogicalFilter(Operator.pw, this.pe), this.pd);
        }

        public Builder setPageToken(String string2) {
            this.pd = string2;
            return this;
        }
    }
}

