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
import com.google.android.gms.internal.du;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class CameraUpdateFactory {
    private static ICameraUpdateFactoryDelegate xm;

    private CameraUpdateFactory() {
    }

    static void a(ICameraUpdateFactoryDelegate iCameraUpdateFactoryDelegate) {
        if (xm != null) {
            return;
        }
        xm = du.f(iCameraUpdateFactoryDelegate);
    }

    private static ICameraUpdateFactoryDelegate dQ() {
        return du.c(xm, "CameraUpdateFactory is not initialized");
    }

    public static CameraUpdate newCameraPosition(CameraPosition object) {
        try {
            return new CameraUpdate(CameraUpdateFactory.dQ().newCameraPosition((CameraPosition)object));
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public static CameraUpdate newLatLng(LatLng object) {
        try {
            return new CameraUpdate(CameraUpdateFactory.dQ().newLatLng((LatLng)object));
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds object, int n2) {
        try {
            return new CameraUpdate(CameraUpdateFactory.dQ().newLatLngBounds((LatLngBounds)object, n2));
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds object, int n2, int n3, int n4) {
        try {
            return new CameraUpdate(CameraUpdateFactory.dQ().newLatLngBoundsWithSize((LatLngBounds)object, n2, n3, n4));
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public static CameraUpdate newLatLngZoom(LatLng object, float f2) {
        try {
            return new CameraUpdate(CameraUpdateFactory.dQ().newLatLngZoom((LatLng)object, f2));
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public static CameraUpdate scrollBy(float f2, float f3) {
        try {
            return new CameraUpdate(CameraUpdateFactory.dQ().scrollBy(f2, f3));
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public static CameraUpdate zoomBy(float f2) {
        try {
            return new CameraUpdate(CameraUpdateFactory.dQ().zoomBy(f2));
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public static CameraUpdate zoomBy(float f2, Point object) {
        try {
            return new CameraUpdate(CameraUpdateFactory.dQ().zoomByWithFocus(f2, object.x, object.y));
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public static CameraUpdate zoomIn() {
        try {
            return new CameraUpdate(CameraUpdateFactory.dQ().zoomIn());
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public static CameraUpdate zoomOut() {
        try {
            return new CameraUpdate(CameraUpdateFactory.dQ().zoomOut());
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public static CameraUpdate zoomTo(float f2) {
        try {
            return new CameraUpdate(CameraUpdateFactory.dQ().zoomTo(f2));
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }
}

