/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 */
package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.internal.IUiSettingsDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class UiSettings {
    private final IUiSettingsDelegate yd;

    UiSettings(IUiSettingsDelegate iUiSettingsDelegate) {
        this.yd = iUiSettingsDelegate;
    }

    public boolean isCompassEnabled() {
        try {
            return this.yd.isCompassEnabled();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public boolean isMyLocationButtonEnabled() {
        try {
            return this.yd.isMyLocationButtonEnabled();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public boolean isRotateGesturesEnabled() {
        try {
            return this.yd.isRotateGesturesEnabled();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public boolean isScrollGesturesEnabled() {
        try {
            return this.yd.isScrollGesturesEnabled();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public boolean isTiltGesturesEnabled() {
        try {
            return this.yd.isTiltGesturesEnabled();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public boolean isZoomControlsEnabled() {
        try {
            return this.yd.isZoomControlsEnabled();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public boolean isZoomGesturesEnabled() {
        try {
            return this.yd.isZoomGesturesEnabled();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public void setAllGesturesEnabled(boolean bl2) {
        try {
            this.yd.setAllGesturesEnabled(bl2);
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public void setCompassEnabled(boolean bl2) {
        try {
            this.yd.setCompassEnabled(bl2);
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public void setMyLocationButtonEnabled(boolean bl2) {
        try {
            this.yd.setMyLocationButtonEnabled(bl2);
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public void setRotateGesturesEnabled(boolean bl2) {
        try {
            this.yd.setRotateGesturesEnabled(bl2);
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public void setScrollGesturesEnabled(boolean bl2) {
        try {
            this.yd.setScrollGesturesEnabled(bl2);
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public void setTiltGesturesEnabled(boolean bl2) {
        try {
            this.yd.setTiltGesturesEnabled(bl2);
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public void setZoomControlsEnabled(boolean bl2) {
        try {
            this.yd.setZoomControlsEnabled(bl2);
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public void setZoomGesturesEnabled(boolean bl2) {
        try {
            this.yd.setZoomGesturesEnabled(bl2);
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }
}

