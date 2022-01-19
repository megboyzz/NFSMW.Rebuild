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
import com.google.android.gms.drive.internal.OpenFileIntentSenderRequest;

public class x
implements Parcelable.Creator<OpenFileIntentSenderRequest> {
    static void a(OpenFileIntentSenderRequest openFileIntentSenderRequest, Parcel parcel, int n2) {
        int n3 = b.l(parcel);
        b.c(parcel, 1, openFileIntentSenderRequest.kZ);
        b.a(parcel, 2, openFileIntentSenderRequest.oa, false);
        b.a(parcel, 3, openFileIntentSenderRequest.ol, false);
        b.a(parcel, 4, openFileIntentSenderRequest.ob, n2, false);
        b.D(parcel, n3);
    }

    public OpenFileIntentSenderRequest I(Parcel parcel) {
        DriveId driveId = null;
        int n2 = a.k(parcel);
        int n3 = 0;
        String[] stringArray = null;
        String string2 = null;
        block6: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new OpenFileIntentSenderRequest(n3, string2, stringArray, driveId);
                throw new a.a("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.j(parcel);
            switch (a.A(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block6;
                }
                case 1: {
                    n3 = a.g(parcel, n4);
                    continue block6;
                }
                case 2: {
                    string2 = a.m(parcel, n4);
                    continue block6;
                }
                case 3: {
                    stringArray = a.x(parcel, n4);
                    continue block6;
                }
                case 4: 
            }
            driveId = a.a(parcel, n4, DriveId.CREATOR);
        }
    }

    public OpenFileIntentSenderRequest[] Z(int n2) {
        return new OpenFileIntentSenderRequest[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.I(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.Z(n2);
    }
}

