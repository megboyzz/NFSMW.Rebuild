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
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.e;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.du;

public class CreateFileRequest
implements SafeParcelable {
    public static final Parcelable.Creator<CreateFileRequest> CREATOR = new e();
    final int kZ;
    final Contents om;
    final MetadataBundle oo;
    final DriveId op;

    CreateFileRequest(int n2, DriveId driveId, MetadataBundle metadataBundle, Contents contents) {
        this.kZ = n2;
        this.op = du.f(driveId);
        this.oo = du.f(metadataBundle);
        this.om = du.f(contents);
    }

    public CreateFileRequest(DriveId driveId, MetadataBundle metadataBundle, Contents contents) {
        this(1, driveId, metadataBundle, contents);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        e.a(this, parcel, n2);
    }
}

