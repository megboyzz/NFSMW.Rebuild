/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.v;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class OnMetadataResponse
implements SafeParcelable {
    public static final Parcelable.Creator<OnMetadataResponse> CREATOR = new v();
    final int kZ;
    final MetadataBundle oo;

    OnMetadataResponse(int n2, MetadataBundle metadataBundle) {
        this.kZ = n2;
        this.oo = metadataBundle;
    }

    public MetadataBundle cB() {
        return this.oo;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        v.a(this, parcel, n2);
    }
}

