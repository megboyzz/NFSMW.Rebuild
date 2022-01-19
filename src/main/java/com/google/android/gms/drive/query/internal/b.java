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
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.internal.FieldOnlyFilter;

public class b
implements Parcelable.Creator<FieldOnlyFilter> {
    static void a(FieldOnlyFilter fieldOnlyFilter, Parcel parcel, int n2) {
        int n3 = com.google.android.gms.common.internal.safeparcel.b.l(parcel);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 1000, fieldOnlyFilter.kZ);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 1, fieldOnlyFilter.pg, n2, false);
        com.google.android.gms.common.internal.safeparcel.b.D(parcel, n3);
    }

    public FieldOnlyFilter O(Parcel parcel) {
        int n2 = a.k(parcel);
        int n3 = 0;
        MetadataBundle metadataBundle = null;
        block4: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new FieldOnlyFilter(n3, metadataBundle);
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

    public FieldOnlyFilter[] af(int n2) {
        return new FieldOnlyFilter[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.O(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.af(n2);
    }
}

