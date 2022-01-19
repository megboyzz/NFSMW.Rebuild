/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class c<T extends SafeParcelable>
extends DataBuffer<T> {
    private static final String[] lf = new String[]{"data"};
    private final Parcelable.Creator<T> lg;

    public c(DataHolder dataHolder, Parcelable.Creator<T> creator) {
        super(dataHolder);
        this.lg = creator;
    }

    @Override
    public /* synthetic */ Object get(int n2) {
        return this.s(n2);
    }

    public T s(int n2) {
        Object object = this.lb.getByteArray("data", n2, 0);
        Parcel parcel = Parcel.obtain();
        parcel.unmarshall(object, 0, ((byte[])object).length);
        parcel.setDataPosition(0);
        object = (SafeParcelable)this.lg.createFromParcel(parcel);
        parcel.recycle();
        return (T)object;
    }
}

