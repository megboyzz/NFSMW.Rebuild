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
import com.google.android.gms.drive.internal.CreateFileIntentSenderRequest;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class d
implements Parcelable.Creator<CreateFileIntentSenderRequest> {
    static void a(CreateFileIntentSenderRequest createFileIntentSenderRequest, Parcel parcel, int n2) {
        int n3 = b.l(parcel);
        b.c(parcel, 1, createFileIntentSenderRequest.kZ);
        b.a(parcel, 2, createFileIntentSenderRequest.oo, n2, false);
        b.c(parcel, 3, createFileIntentSenderRequest.nT);
        b.a(parcel, 4, createFileIntentSenderRequest.oa, false);
        b.a(parcel, 5, createFileIntentSenderRequest.ob, n2, false);
        b.D(parcel, n3);
    }

    public CreateFileIntentSenderRequest[] P(int n2) {
        return new CreateFileIntentSenderRequest[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.y(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.P(n2);
    }

    public CreateFileIntentSenderRequest y(Parcel parcel) {
        int n2 = 0;
        DriveId driveId = null;
        int n3 = a.k(parcel);
        String string2 = null;
        MetadataBundle metadataBundle = null;
        int n4 = 0;
        block7: while (true) {
            if (parcel.dataPosition() >= n3) {
                if (parcel.dataPosition() == n3) return new CreateFileIntentSenderRequest(n4, metadataBundle, n2, string2, driveId);
                throw new a.a("Overread allowed size end=" + n3, parcel);
            }
            int n5 = a.j(parcel);
            switch (a.A(n5)) {
                default: {
                    a.b(parcel, n5);
                    continue block7;
                }
                case 1: {
                    n4 = a.g(parcel, n5);
                    continue block7;
                }
                case 2: {
                    metadataBundle = a.a(parcel, n5, MetadataBundle.CREATOR);
                    continue block7;
                }
                case 3: {
                    n2 = a.g(parcel, n5);
                    continue block7;
                }
                case 4: {
                    string2 = a.m(parcel, n5);
                    continue block7;
                }
                case 5: 
            }
            driveId = a.a(parcel, n5, DriveId.CREATOR);
        }
    }
}

