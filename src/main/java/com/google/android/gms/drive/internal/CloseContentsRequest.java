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
import com.google.android.gms.drive.internal.b;

public class CloseContentsRequest
implements SafeParcelable {
    public static final Parcelable.Creator<CloseContentsRequest> CREATOR = new b();
    final int kZ;
    final Contents om;
    final Boolean on;

    CloseContentsRequest(int n2, Contents contents, Boolean bl2) {
        this.kZ = n2;
        this.om = contents;
        this.on = bl2;
    }

    public CloseContentsRequest(Contents contents, boolean bl2) {
        this(1, contents, bl2);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        b.a(this, parcel, n2);
    }
}

