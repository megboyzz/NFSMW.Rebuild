/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.RemoteException
 */
package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.internal.du;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.internal.q;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class MapsInitializer {
    private MapsInitializer() {
    }

    public static void initialize(Context object) throws GooglePlayServicesNotAvailableException {
        du.f(object);
        object = q.u((Context)object);
        try {
            CameraUpdateFactory.a(object.ed());
            BitmapDescriptorFactory.a(object.ee());
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }
}

