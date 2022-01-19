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
import com.google.android.gms.drive.internal.n;

public class GetMetadataRequest
implements SafeParcelable {
    public static final Parcelable.Creator<GetMetadataRequest> CREATOR = new n();
    final int kZ;
    final DriveId oF;

    GetMetadataRequest(int n2, DriveId driveId) {
        this.kZ = n2;
        this.oF = driveId;
    }

    public GetMetadataRequest(DriveId driveId) {
        this(1, driveId);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        n.a(this, parcel, n2);
    }
}

