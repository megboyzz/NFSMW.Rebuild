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
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.u;

public class OnListEntriesResponse
implements SafeParcelable {
    public static final Parcelable.Creator<OnListEntriesResponse> CREATOR = new u();
    final int kZ;
    final DataHolder oN;

    OnListEntriesResponse(int n2, DataHolder dataHolder) {
        this.kZ = n2;
        this.oN = dataHolder;
    }

    public DataHolder cA() {
        return this.oN;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        u.a(this, parcel, n2);
    }
}

