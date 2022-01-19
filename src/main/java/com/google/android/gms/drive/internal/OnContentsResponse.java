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
import com.google.android.gms.drive.internal.r;

public class OnContentsResponse
implements SafeParcelable {
    public static final Parcelable.Creator<OnContentsResponse> CREATOR = new r();
    final int kZ;
    final Contents nZ;

    OnContentsResponse(int n2, Contents contents) {
        this.kZ = n2;
        this.nZ = contents;
    }

    public Contents cx() {
        return this.nZ;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        r.a(this, parcel, n2);
    }
}

