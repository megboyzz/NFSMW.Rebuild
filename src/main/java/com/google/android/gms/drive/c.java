/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;

public class c
implements Parcelable.Creator<DriveId> {
    static void a(DriveId driveId, Parcel parcel, int n2) {
        n2 = b.l(parcel);
        b.c(parcel, 1, driveId.kZ);
        b.a(parcel, 2, driveId.od, false);
        b.a(parcel, 3, driveId.oe);
        b.a(parcel, 4, driveId.of);
        b.D(parcel, n2);
    }

    public DriveId[] M(int n2) {
        return new DriveId[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.v(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.M(n2);
    }

    public DriveId v(Parcel parcel) {
        long l2 = 0L;
        int n2 = a.k(parcel);
        int n3 = 0;
        String string2 = null;
        long l3 = 0L;
        block6: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new DriveId(n3, string2, l3, l2);
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
                    l3 = a.h(parcel, n4);
                    continue block6;
                }
                case 4: 
            }
            l2 = a.h(parcel, n4);
        }
    }
}

