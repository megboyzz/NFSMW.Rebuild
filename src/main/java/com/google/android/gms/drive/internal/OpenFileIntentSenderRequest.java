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
import com.google.android.gms.drive.internal.x;

public class OpenFileIntentSenderRequest
implements SafeParcelable {
    public static final Parcelable.Creator<OpenFileIntentSenderRequest> CREATOR = new x();
    final int kZ;
    final String oa;
    final DriveId ob;
    final String[] ol;

    OpenFileIntentSenderRequest(int n2, String string2, String[] stringArray, DriveId driveId) {
        this.kZ = n2;
        this.oa = string2;
        this.ol = stringArray;
        this.ob = driveId;
    }

    public OpenFileIntentSenderRequest(String string2, String[] stringArray, DriveId driveId) {
        this(1, string2, stringArray, driveId);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        x.a(this, parcel, n2);
    }
}

