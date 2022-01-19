/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Point
 *  android.os.RemoteException
 */
package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.gms.dynamic.c;
import com.google.android.gms.maps.internal.IProjectionDelegate;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.VisibleRegion;

public final class Projection {
    private final IProjectionDelegate ya;

    Projection(IProjectionDelegate iProjectionDelegate) {
        this.ya = iProjectionDelegate;
    }

    public LatLng fromScreenLocation(Point object) {
        try {
            return this.ya.fromScreenLocation(c.h(object));
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public VisibleRegion getVisibleRegion() {
        try {
            return this.ya.getVisibleRegion();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public Point toScreenLocation(LatLng latLng) {
        try {
            return (Point)c.b(this.ya.toScreenLocation(latLng));
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }
}

