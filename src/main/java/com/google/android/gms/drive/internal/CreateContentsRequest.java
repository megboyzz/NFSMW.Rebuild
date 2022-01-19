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
import com.google.android.gms.drive.internal.c;

public class CreateContentsRequest
implements SafeParcelable {
    public static final Parcelable.Creator<CreateContentsRequest> CREATOR = new c();
    final int kZ;

    public CreateContentsRequest() {
        this(1);
    }

    CreateContentsRequest(int n2) {
        this.kZ = n2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        c.a(this, parcel, n2);
    }
}

