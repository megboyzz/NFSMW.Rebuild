/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.RemoteException
 */
package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.r;
import com.google.android.gms.maps.model.Tile;
import com.google.android.gms.maps.model.TileOverlayOptionsCreator;
import com.google.android.gms.maps.model.TileProvider;
import com.google.android.gms.maps.model.internal.g;
import com.google.android.gms.maps.model.j;

public final class TileOverlayOptions
implements SafeParcelable {
    public static final TileOverlayOptionsCreator CREATOR = new TileOverlayOptionsCreator();
    private final int kZ;
    private g yW;
    private TileProvider yX;
    private boolean yY = true;
    private float ys;
    private boolean yt = true;

    public TileOverlayOptions() {
        this.kZ = 1;
    }

    TileOverlayOptions(int n2, IBinder object, boolean bl2, float f2, boolean bl3) {
        this.kZ = n2;
        this.yW = g.a.an(object);
        object = this.yW == null ? null : new TileProvider(){
            private final g yZ;
            {
                this.yZ = TileOverlayOptions.this.yW;
            }

            @Override
            public Tile getTile(int n2, int n3, int n4) {
                try {
                    return this.yZ.getTile(n2, n3, n4);
                }
                catch (RemoteException remoteException) {
                    return null;
                }
            }
        };
        this.yX = object;
        this.yt = bl2;
        this.ys = f2;
        this.yY = bl3;
    }

    public int describeContents() {
        return 0;
    }

    IBinder em() {
        return this.yW.asBinder();
    }

    public TileOverlayOptions fadeIn(boolean bl2) {
        this.yY = bl2;
        return this;
    }

    public boolean getFadeIn() {
        return this.yY;
    }

    public TileProvider getTileProvider() {
        return this.yX;
    }

    int getVersionCode() {
        return this.kZ;
    }

    public float getZIndex() {
        return this.ys;
    }

    public boolean isVisible() {
        return this.yt;
    }

    public TileOverlayOptions tileProvider(TileProvider object) {
        this.yX = object;
        object = this.yX == null ? null : new g.a((TileProvider)object){
            final /* synthetic */ TileProvider zb;
            {
                this.zb = tileProvider;
            }

            @Override
            public Tile getTile(int n2, int n3, int n4) {
                return this.zb.getTile(n2, n3, n4);
            }
        };
        this.yW = object;
        return this;
    }

    public TileOverlayOptions visible(boolean bl2) {
        this.yt = bl2;
        return this;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        if (r.eh()) {
            j.a(this, parcel, n2);
            return;
        }
        TileOverlayOptionsCreator.a(this, parcel, n2);
    }

    public TileOverlayOptions zIndex(float f2) {
        this.ys = f2;
        return this;
    }
}

