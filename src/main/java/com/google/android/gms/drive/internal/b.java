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
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.internal.CloseContentsRequest;

public class b
implements Parcelable.Creator<CloseContentsRequest> {
    static void a(CloseContentsRequest closeContentsRequest, Parcel parcel, int n2) {
        int n3 = com.google.android.gms.common.internal.safeparcel.b.l(parcel);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 1, closeContentsRequest.kZ);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, closeContentsRequest.om, n2, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, closeContentsRequest.on, false);
        com.google.android.gms.common.internal.safeparcel.b.D(parcel, n3);
    }

    public CloseContentsRequest[] N(int n2) {
        return new CloseContentsRequest[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.w(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.N(n2);
    }

    public CloseContentsRequest w(Parcel parcel) {
        Boolean bl2 = null;
        int n2 = a.k(parcel);
        int n3 = 0;
        Contents contents = null;
        block5: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new CloseContentsRequest(n3, contents, bl2);
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
                    contents = a.a(parcel, n4, Contents.CREATOR);
                    continue block5;
                }
                case 3: 
            }
            bl2 = a.d(parcel, n4);
        }
    }
}

