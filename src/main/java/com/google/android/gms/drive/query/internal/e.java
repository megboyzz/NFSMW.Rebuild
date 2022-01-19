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
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.internal.InFilter;

public class e
implements Parcelable.Creator<InFilter> {
    static void a(InFilter inFilter, Parcel parcel, int n2) {
        int n3 = b.l(parcel);
        b.c(parcel, 1000, inFilter.kZ);
        b.a(parcel, 1, inFilter.pg, n2, false);
        b.D(parcel, n3);
    }

    public InFilter Q(Parcel parcel) {
        int n2 = a.k(parcel);
        int n3 = 0;
        MetadataBundle metadataBundle = null;
        block4: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new InFilter(n3, metadataBundle);
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
            metadataBundle = a.a(parcel, n4, MetadataBundle.CREATOR);
        }
    }

    public InFilter[] ah(int n2) {
        return new InFilter[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.Q(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.ah(n2);
    }
}

