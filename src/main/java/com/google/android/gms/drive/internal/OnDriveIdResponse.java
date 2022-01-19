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
import com.google.android.gms.drive.internal.t;

public class OnDriveIdResponse
implements SafeParcelable {
    public static final Parcelable.Creator<OnDriveIdResponse> CREATOR = new t();
    final int kZ;
    DriveId oF;

    OnDriveIdResponse(int n2, DriveId driveId) {
        this.kZ = n2;
        this.oF = driveId;
    }

    public int describeContents() {
        return 0;
    }

    public DriveId getDriveId() {
        return this.oF;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        t.a(this, parcel, n2);
    }
}

