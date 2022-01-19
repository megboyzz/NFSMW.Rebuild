/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.os.RemoteException
 */
package com.google.android.gms.maps.model;

import android.graphics.Bitmap;
import android.os.RemoteException;
import com.google.android.gms.internal.du;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.internal.a;

public final class BitmapDescriptorFactory {
    public static final float HUE_AZURE = 210.0f;
    public static final float HUE_BLUE = 240.0f;
    public static final float HUE_CYAN = 180.0f;
    public static final float HUE_GREEN = 120.0f;
    public static final float HUE_MAGENTA = 300.0f;
    public static final float HUE_ORANGE = 30.0f;
    public static final float HUE_RED = 0.0f;
    public static final float HUE_ROSE = 330.0f;
    public static final float HUE_VIOLET = 270.0f;
    public static final float HUE_YELLOW = 60.0f;
    private static a yh;

    private BitmapDescriptorFactory() {
    }

    public static void a(a a2) {
        if (yh != null) {
            return;
        }
        yh = du.f(a2);
    }

    public static BitmapDescriptor defaultMarker() {
        try {
            return new BitmapDescriptor(BitmapDescriptorFactory.ei().en());
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public static BitmapDescriptor defaultMarker(float f2) {
        try {
            return new BitmapDescriptor(BitmapDescriptorFactory.ei().c(f2));
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    private static a ei() {
        return du.c(yh, "IBitmapDescriptorFactory is not initialized");
    }

    public static BitmapDescriptor fromAsset(String object) {
        try {
            return new BitmapDescriptor(BitmapDescriptorFactory.ei().ad((String)object));
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public static BitmapDescriptor fromBitmap(Bitmap object) {
        try {
            return new BitmapDescriptor(BitmapDescriptorFactory.ei().a((Bitmap)object));
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public static BitmapDescriptor fromFile(String object) {
        try {
            return new BitmapDescriptor(BitmapDescriptorFactory.ei().ae((String)object));
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public static BitmapDescriptor fromPath(String object) {
        try {
            return new BitmapDescriptor(BitmapDescriptorFactory.ei().af((String)object));
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public static BitmapDescriptor fromResource(int n2) {
        try {
            return new BitmapDescriptor(BitmapDescriptorFactory.ei().aO(n2));
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }
}

