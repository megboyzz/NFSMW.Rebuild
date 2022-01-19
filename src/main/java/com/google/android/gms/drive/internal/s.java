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
import com.google.android.gms.drive.internal.OnDownloadProgressResponse;

public class s
implements Parcelable.Creator<OnDownloadProgressResponse> {
    static void a(OnDownloadProgressResponse onDownloadProgressResponse, Parcel parcel, int n2) {
        n2 = b.l(parcel);
        b.c(parcel, 1, onDownloadProgressResponse.kZ);
        b.a(parcel, 2, onDownloadProgressResponse.oL);
        b.a(parcel, 3, onDownloadProgressResponse.oM);
        b.D(parcel, n2);
    }

    public OnDownloadProgressResponse D(Parcel parcel) {
        long l2 = 0L;
        int n2 = a.k(parcel);
        int n3 = 0;
        long l3 = 0L;
        block5: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new OnDownloadProgressResponse(n3, l3, l2);
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
                    l3 = a.h(parcel, n4);
                    continue block5;
                }
                case 3: 
            }
            l2 = a.h(parcel, n4);
        }
    }

    public OnDownloadProgressResponse[] U(int n2) {
        return new OnDownloadProgressResponse[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.D(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.U(n2);
    }
}

