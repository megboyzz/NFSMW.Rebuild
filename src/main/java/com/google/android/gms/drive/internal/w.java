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
import com.google.android.gms.drive.internal.OpenContentsRequest;

public class w
implements Parcelable.Creator<OpenContentsRequest> {
    static void a(OpenContentsRequest openContentsRequest, Parcel parcel, int n2) {
        int n3 = b.l(parcel);
        b.c(parcel, 1, openContentsRequest.kZ);
        b.a(parcel, 2, openContentsRequest.oF, n2, false);
        b.c(parcel, 3, openContentsRequest.nU);
        b.D(parcel, n3);
    }

    public OpenContentsRequest H(Parcel parcel) {
        int n2 = 0;
        int n3 = a.k(parcel);
        DriveId driveId = null;
        int n4 = 0;
        block5: while (true) {
            if (parcel.dataPosition() >= n3) {
                if (parcel.dataPosition() == n3) return new OpenContentsRequest(n4, driveId, n2);
                throw new a.a("Overread allowed size end=" + n3, parcel);
            }
            int n5 = a.j(parcel);
            switch (a.A(n5)) {
                default: {
                    a.b(parcel, n5);
                    continue block5;
                }
                case 1: {
                    n4 = a.g(parcel, n5);
                    continue block5;
                }
                case 2: {
                    driveId = a.a(parcel, n5, DriveId.CREATOR);
                    continue block5;
                }
                case 3: 
            }
            n2 = a.g(parcel, n5);
        }
    }

    public OpenContentsRequest[] Y(int n2) {
        return new OpenContentsRequest[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.H(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.Y(n2);
    }
}

