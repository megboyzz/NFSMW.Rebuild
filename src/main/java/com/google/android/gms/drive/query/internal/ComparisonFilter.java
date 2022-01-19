/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 */
package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.Filter;
import com.google.android.gms.drive.query.internal.Operator;
import com.google.android.gms.drive.query.internal.a;
import com.google.android.gms.drive.query.internal.d;

public class ComparisonFilter<T>
implements SafeParcelable,
Filter {
    public static final a CREATOR = new a();
    final int kZ;
    final Operator pf;
    final MetadataBundle pg;
    final MetadataField<T> ph;

    ComparisonFilter(int n2, Operator operator, MetadataBundle metadataBundle) {
        this.kZ = n2;
        this.pf = operator;
        this.pg = metadataBundle;
        this.ph = d.b(metadataBundle);
    }

    public ComparisonFilter(Operator operator, MetadataField<T> metadataField, T t2) {
        this(1, operator, MetadataBundle.a(metadataField, t2));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        a.a(this, parcel, n2);
    }
}

