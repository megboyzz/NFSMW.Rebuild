/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class d
implements Parcelable.Creator<MetadataBundle> {
    static void a(MetadataBundle metadataBundle, Parcel parcel, int n2) {
        n2 = b.l(parcel);
        b.c(parcel, 1, metadataBundle.kZ);
        b.a(parcel, 2, metadataBundle.oT, false);
        b.D(parcel, n2);
    }

    public MetadataBundle L(Parcel parcel) {
        int n2 = a.k(parcel);
        int n3 = 0;
        Bundle bundle = null;
        block4: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new MetadataBundle(n3, bundle);
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
            bundle = a.o(parcel, n4);
        }
    }

    public MetadataBundle[] ac(int n2) {
        return new MetadataBundle[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.L(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.ac(n2);
    }
}

