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
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.Filter;
import com.google.android.gms.drive.query.internal.b;
import com.google.android.gms.drive.query.internal.d;

public class FieldOnlyFilter
implements SafeParcelable,
Filter {
    public static final Parcelable.Creator<FieldOnlyFilter> CREATOR = new b();
    final int kZ;
    final MetadataBundle pg;
    private final MetadataField<?> ph;

    FieldOnlyFilter(int n2, MetadataBundle metadataBundle) {
        this.kZ = n2;
        this.pg = metadataBundle;
        this.ph = d.b(metadataBundle);
    }

    public FieldOnlyFilter(MetadataField<?> metadataField) {
        this(1, MetadataBundle.a(metadataField, null));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        b.a(this, parcel, n2);
    }
}

