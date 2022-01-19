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
import com.google.android.gms.drive.internal.s;

public class OnDownloadProgressResponse
implements SafeParcelable {
    public static final Parcelable.Creator<OnDownloadProgressResponse> CREATOR = new s();
    final int kZ;
    final long oL;
    final long oM;

    OnDownloadProgressResponse(int n2, long l2, long l3) {
        this.kZ = n2;
        this.oL = l2;
        this.oM = l3;
    }

    public long cy() {
        return this.oL;
    }

    public long cz() {
        return this.oM;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        s.a(this, parcel, n2);
    }
}

