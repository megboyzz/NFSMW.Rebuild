/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class StatusCreator
implements Parcelable.Creator<Status> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void a(Status status, Parcel parcel, int n2) {
        int n3 = b.l(parcel);
        b.c(parcel, 1, status.getStatusCode());
        b.c(parcel, 1000, status.getVersionCode());
        b.a(parcel, 2, status.bg(), false);
        b.a(parcel, 3, (Parcelable)status.bf(), n2, false);
        b.D(parcel, n3);
    }

    public Status createFromParcel(Parcel parcel) {
        PendingIntent pendingIntent = null;
        int n2 = 0;
        int n3 = a.k(parcel);
        String string2 = null;
        int n4 = 0;
        block6: while (true) {
            if (parcel.dataPosition() >= n3) {
                if (parcel.dataPosition() == n3) return new Status(n4, n2, string2, pendingIntent);
                throw new a.a("Overread allowed size end=" + n3, parcel);
            }
            int n5 = a.j(parcel);
            switch (a.A(n5)) {
                default: {
                    a.b(parcel, n5);
                    continue block6;
                }
                case 1: {
                    n2 = a.g(parcel, n5);
                    continue block6;
                }
                case 1000: {
                    n4 = a.g(parcel, n5);
                    continue block6;
                }
                case 2: {
                    string2 = a.m(parcel, n5);
                    continue block6;
                }
                case 3: 
            }
            pendingIntent = (PendingIntent)a.a(parcel, n5, PendingIntent.CREATOR);
        }
    }

    public Status[] newArray(int n2) {
        return new Status[n2];
    }
}

