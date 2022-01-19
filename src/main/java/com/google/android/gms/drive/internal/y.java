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
import com.google.android.gms.drive.internal.QueryRequest;
import com.google.android.gms.drive.query.Query;

public class y
implements Parcelable.Creator<QueryRequest> {
    static void a(QueryRequest queryRequest, Parcel parcel, int n2) {
        int n3 = b.l(parcel);
        b.c(parcel, 1, queryRequest.kZ);
        b.a(parcel, 2, queryRequest.oO, n2, false);
        b.D(parcel, n3);
    }

    public QueryRequest J(Parcel parcel) {
        int n2 = a.k(parcel);
        int n3 = 0;
        Query query = null;
        block4: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new QueryRequest(n3, query);
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
            query = a.a(parcel, n4, Query.CREATOR);
        }
    }

    public QueryRequest[] aa(int n2) {
        return new QueryRequest[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.J(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.aa(n2);
    }
}

