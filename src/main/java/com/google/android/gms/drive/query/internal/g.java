/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.query.internal.FilterHolder;
import com.google.android.gms.drive.query.internal.NotFilter;

public class g
implements Parcelable.Creator<NotFilter> {
    static void a(NotFilter notFilter, Parcel parcel, int n2) {
        int n3 = b.l(parcel);
        b.c(parcel, 1000, notFilter.kZ);
        b.a(parcel, 1, notFilter.pq, n2, false);
        b.D(parcel, n3);
    }

    public NotFilter S(Parcel parcel) {
        int n2 = a.k(parcel);
        int n3 = 0;
        FilterHolder filterHolder = null;
        block4: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new NotFilter(n3, filterHolder);
                throw new a.a("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.j(parcel);
            switch (a.A(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block4;
                }
                case 1000: {
                    n3 = a.g(parcel, n4);
                    continue block4;
                }
                case 1: 
            }
            filterHolder = a.a(parcel, n4, FilterHolder.CREATOR);
        }
    }

    public NotFilter[] aj(int n2) {
        return new NotFilter[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.S(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.aj(n2);
    }
}

