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
import com.google.android.gms.drive.internal.w;

public class OpenContentsRequest
implements SafeParcelable {
    public static final Parcelable.Creator<OpenContentsRequest> CREATOR = new w();
    final int kZ;
    final int nU;
    final DriveId oF;

    OpenContentsRequest(int n2, DriveId driveId, int n3) {
        this.kZ = n2;
        this.oF = driveId;
        this.nU = n3;
    }

    public OpenContentsRequest(DriveId driveId, int n2) {
        this(1, driveId, n2);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        w.a(this, parcel, n2);
    }
}

