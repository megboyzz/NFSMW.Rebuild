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
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Filter;
import com.google.android.gms.drive.query.internal.FilterHolder;
import com.google.android.gms.drive.query.internal.g;

public class NotFilter
implements SafeParcelable,
Filter {
    public static final Parcelable.Creator<NotFilter> CREATOR = new g();
    final int kZ;
    final FilterHolder pq;

    NotFilter(int n2, FilterHolder filterHolder) {
        this.kZ = n2;
        this.pq = filterHolder;
    }

    public NotFilter(Filter filter) {
        this(1, new FilterHolder(filter));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        g.a(this, parcel, n2);
    }
}

