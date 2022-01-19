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
import com.google.android.gms.drive.internal.CreateContentsRequest;

public class c
implements Parcelable.Creator<CreateContentsRequest> {
    static void a(CreateContentsRequest createContentsRequest, Parcel parcel, int n2) {
        n2 = b.l(parcel);
        b.c(parcel, 1, createContentsRequest.kZ);
        b.D(parcel, n2);
    }

    public CreateContentsRequest[] O(int n2) {
        return new CreateContentsRequest[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.x(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.O(n2);
    }

    public CreateContentsRequest x(Parcel parcel) {
        int n2 = a.k(parcel);
        int n3 = 0;
        block3: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new CreateContentsRequest(n3);
                throw new a.a("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.j(parcel);
            switch (a.A(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block3;
                }
                case 1: 
            }
            n3 = a.g(parcel, n4);
        }
    }
}

