/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 */
package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.CollectionMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.Filter;
import com.google.android.gms.drive.query.internal.d;
import com.google.android.gms.drive.query.internal.e;
import java.util.Collections;

public class InFilter<T>
implements SafeParcelable,
Filter {
    public static final e CREATOR = new e();
    final int kZ;
    final MetadataBundle pg;
    private final CollectionMetadataField<T> po;

    InFilter(int n2, MetadataBundle metadataBundle) {
        this.kZ = n2;
        this.pg = metadataBundle;
        this.po = (CollectionMetadataField)d.b(metadataBundle);
    }

    public InFilter(CollectionMetadataField<T> collectionMetadataField, T t2) {
        this(1, MetadataBundle.a(collectionMetadataField, Collections.singleton(t2)));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        e.a(this, parcel, n2);
    }
}

