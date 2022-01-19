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
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.GetMetadataRequest;

public class n
implements Parcelable.Creator<GetMetadataRequest> {
    static void a(GetMetadataRequest getMetadataRequest, Parcel parcel, int n2) {
        int n3 = b.l(parcel);
        b.c(parcel, 1, getMetadataRequest.kZ);
        b.a(parcel, 2, getMetadataRequest.oF, n2, false);
        b.D(parcel, n3);
    }

    public GetMetadataRequest B(Parcel parcel) {
        int n2 = a.k(parcel);
        int n3 = 0;
        DriveId driveId = null;
        block4: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new GetMetadataRequest(n3, driveId);
                throw new a.a("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.j(parcel);
            switch (a.A(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block4;
                }
                case 1: {
                    n3 = a.g(parcel, n4);
                    continue block4;
                }
                case 2: 
            }
            driveId = a.a(parcel, n4, DriveId.CREATOR);
        }
    }

    public GetMetadataRequest[] S(int n2) {
        return new GetMetadataRequest[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.B(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.S(n2);
    }
}

