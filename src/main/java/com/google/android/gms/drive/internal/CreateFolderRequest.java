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
import com.google.android.gms.drive.internal.f;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.du;

public class CreateFolderRequest
implements SafeParcelable {
    public static final Parcelable.Creator<CreateFolderRequest> CREATOR = new f();
    final int kZ;
    final MetadataBundle oo;
    final DriveId op;

    CreateFolderRequest(int n2, DriveId driveId, MetadataBundle metadataBundle) {
        this.kZ = n2;
        this.op = du.f(driveId);
        this.oo = du.f(metadataBundle);
    }

    public CreateFolderRequest(DriveId driveId, MetadataBundle metadataBundle) {
        this(1, driveId, metadataBundle);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        f.a(this, parcel, n2);
    }
}

