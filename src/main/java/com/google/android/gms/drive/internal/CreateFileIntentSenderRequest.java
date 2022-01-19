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
import com.google.android.gms.drive.internal.d;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CreateFileIntentSenderRequest
implements SafeParcelable {
    public static final Parcelable.Creator<CreateFileIntentSenderRequest> CREATOR = new d();
    final int kZ;
    final int nT;
    final String oa;
    final DriveId ob;
    final MetadataBundle oo;

    CreateFileIntentSenderRequest(int n2, MetadataBundle metadataBundle, int n3, String string2, DriveId driveId) {
        this.kZ = n2;
        this.oo = metadataBundle;
        this.nT = n3;
        this.oa = string2;
        this.ob = driveId;
    }

    public CreateFileIntentSenderRequest(MetadataBundle metadataBundle, int n2, String string2, DriveId driveId) {
        this(1, metadataBundle, n2, string2, driveId);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        d.a(this, parcel, n2);
    }
}

