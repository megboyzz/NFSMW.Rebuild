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
import com.google.android.gms.drive.internal.OnMetadataResponse;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class v
implements Parcelable.Creator<OnMetadataResponse> {
    static void a(OnMetadataResponse onMetadataResponse, Parcel parcel, int n2) {
        int n3 = b.l(parcel);
        b.c(parcel, 1, onMetadataResponse.kZ);
        b.a(parcel, 2, onMetadataResponse.oo, n2, false);
        b.D(parcel, n3);
    }

    public OnMetadataResponse G(Parcel parcel) {
        int n2 = a.k(parcel);
        int n3 = 0;
        MetadataBundle metadataBundle = null;
        block4: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new OnMetadataResponse(n3, metadataBundle);
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
            metadataBundle = a.a(parcel, n4, MetadataBundle.CREATOR);
        }
    }

    public OnMetadataResponse[] X(int n2) {
        return new OnMetadataResponse[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.G(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.X(n2);
    }
}

