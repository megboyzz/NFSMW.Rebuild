/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 */
package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.r;
import com.google.android.gms.maps.model.TileCreator;
import com.google.android.gms.maps.model.i;

public final class Tile
implements SafeParcelable {
    public static final TileCreator CREATOR = new TileCreator();
    public final byte[] data;
    public final int height;
    private final int kZ;
    public final int width;

    Tile(int n2, int n3, int n4, byte[] byArray) {
        this.kZ = n2;
        this.width = n3;
        this.height = n4;
        this.data = byArray;
    }

    public Tile(int n2, int n3, byte[] byArray) {
        this(1, n2, n3, byArray);
    }

    public int describeContents() {
        return 0;
    }

    int getVersionCode() {
        return this.kZ;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        if (r.eh()) {
            i.a(this, parcel, n2);
            return;
        }
        TileCreator.a(this, parcel, n2);
    }
}

