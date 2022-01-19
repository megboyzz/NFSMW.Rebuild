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
import com.google.android.gms.drive.internal.CreateFolderRequest;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class f
implements Parcelable.Creator<CreateFolderRequest> {
    static void a(CreateFolderRequest createFolderRequest, Parcel parcel, int n2) {
        int n3 = b.l(parcel);
        b.c(parcel, 1, createFolderRequest.kZ);
        b.a(parcel, 2, createFolderRequest.op, n2, false);
        b.a(parcel, 3, createFolderRequest.oo, n2, false);
        b.D(parcel, n3);
    }

    public CreateFolderRequest A(Parcel parcel) {
        MetadataBundle metadataBundle = null;
        int n2 = a.k(parcel);
        int n3 = 0;
        DriveId driveId = null;
        block5: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new CreateFolderRequest(n3, driveId, metadataBundle);
                throw new a.a("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.j(parcel);
            switch (a.A(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block5;
                }
                case 1: {
                    n3 = a.g(parcel, n4);
                    continue block5;
                }
                case 2: {
                    driveId = a.a(parcel, n4, DriveId.CREATOR);
                    continue block5;
                }
                case 3: 
            }
            metadataBundle = a.a(parcel, n4, MetadataBundle.CREATOR);
        }
    }

    public CreateFolderRequest[] R(int n2) {
        return new CreateFolderRequest[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.A(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.R(n2);
    }
}

