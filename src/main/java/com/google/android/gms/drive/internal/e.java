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
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.CreateFileRequest;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class e
implements Parcelable.Creator<CreateFileRequest> {
    static void a(CreateFileRequest createFileRequest, Parcel parcel, int n2) {
        int n3 = b.l(parcel);
        b.c(parcel, 1, createFileRequest.kZ);
        b.a(parcel, 2, createFileRequest.op, n2, false);
        b.a(parcel, 3, createFileRequest.oo, n2, false);
        b.a(parcel, 4, createFileRequest.om, n2, false);
        b.D(parcel, n3);
    }

    public CreateFileRequest[] Q(int n2) {
        return new CreateFileRequest[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.z(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.Q(n2);
    }

    public CreateFileRequest z(Parcel parcel) {
        Contents contents = null;
        int n2 = a.k(parcel);
        int n3 = 0;
        DriveId driveId = null;
        DriveId driveId2 = null;
        while (true) {
            SafeParcelable safeParcelable;
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new CreateFileRequest(n3, driveId2, (MetadataBundle)((Object)driveId), contents);
                throw new a.a("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.j(parcel);
            switch (a.A(n4)) {
                default: {
                    a.b(parcel, n4);
                    safeParcelable = driveId;
                    driveId = driveId2;
                    driveId2 = safeParcelable;
                    break;
                }
                case 1: {
                    n3 = a.g(parcel, n4);
                    safeParcelable = driveId2;
                    driveId2 = driveId;
                    driveId = safeParcelable;
                    break;
                }
                case 2: {
                    safeParcelable = a.a(parcel, n4, DriveId.CREATOR);
                    driveId2 = driveId;
                    driveId = safeParcelable;
                    break;
                }
                case 3: {
                    safeParcelable = a.a(parcel, n4, MetadataBundle.CREATOR);
                    driveId = driveId2;
                    driveId2 = safeParcelable;
                    break;
                }
                case 4: {
                    contents = a.a(parcel, n4, Contents.CREATOR);
                    safeParcelable = driveId2;
                    driveId2 = driveId;
                    driveId = safeParcelable;
                }
            }
            safeParcelable = driveId;
            driveId = driveId2;
            driveId2 = safeParcelable;
        }
    }
}

