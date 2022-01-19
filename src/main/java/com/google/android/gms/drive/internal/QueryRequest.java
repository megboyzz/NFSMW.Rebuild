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
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.y;
import com.google.android.gms.drive.query.Query;

public class QueryRequest
implements SafeParcelable {
    public static final Parcelable.Creator<QueryRequest> CREATOR = new y();
    final int kZ;
    final Query oO;

    QueryRequest(int n2, Query query) {
        this.kZ = n2;
        this.oO = query;
    }

    public QueryRequest(Query query) {
        this(1, query);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        y.a(this, parcel, n2);
    }
}

