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
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.aa;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class UpdateMetadataRequest
implements SafeParcelable {
    public static final Parcelable.Creator<UpdateMetadataRequest> CREATOR = new aa();
    final int kZ;
    final DriveId oF;
    final MetadataBundle oP;

    UpdateMetadataRequest(int n2, DriveId driveId, MetadataBundle metadataBundle) {
        this.kZ = n2;
        this.oF = driveId;
        this.oP = metadataBundle;
    }

    public UpdateMetadataRequest(DriveId driveId, MetadataBundle metadataBundle) {
        this(1, driveId, metadataBundle);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        aa.a(this, parcel, n2);
    }
}

