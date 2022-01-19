/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;

public class j
implements Parcelable.Creator<NotifyTransactionStatusRequest> {
    static void a(NotifyTransactionStatusRequest notifyTransactionStatusRequest, Parcel parcel, int n2) {
        n2 = b.l(parcel);
        b.c(parcel, 1, notifyTransactionStatusRequest.kZ);
        b.a(parcel, 2, notifyTransactionStatusRequest.BN, false);
        b.c(parcel, 3, notifyTransactionStatusRequest.status);
        b.a(parcel, 4, notifyTransactionStatusRequest.Cv, false);
        b.D(parcel, n2);
    }

    public NotifyTransactionStatusRequest aE(Parcel parcel) {
        String string2 = null;
        int n2 = 0;
        int n3 = a.k(parcel);
        String string3 = null;
        int n4 = 0;
        block6: while (true) {
            if (parcel.dataPosition() >= n3) {
                if (parcel.dataPosition() == n3) return new NotifyTransactionStatusRequest(n4, string3, n2, string2);
                throw new a.a("Overread allowed size end=" + n3, parcel);
            }
            int n5 = a.j(parcel);
            switch (a.A(n5)) {
                default: {
                    a.b(parcel, n5);
                    continue block6;
                }
                case 1: {
                    n4 = a.g(parcel, n5);
                    continue block6;
                }
                case 2: {
                    string3 = a.m(parcel, n5);
                    continue block6;
                }
                case 3: {
                    n2 = a.g(parcel, n5);
                    continue block6;
                }
                case 4: 
            }
            string2 = a.m(parcel, n5);
        }
    }

    public NotifyTransactionStatusRequest[] bm(int n2) {
        return new NotifyTransactionStatusRequest[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.aE(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.bm(n2);
    }
}

