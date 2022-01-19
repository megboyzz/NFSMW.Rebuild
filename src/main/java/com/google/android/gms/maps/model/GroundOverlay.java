/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 */
package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.internal.du;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.internal.c;

public final class GroundOverlay {
    private final c yu;

    public GroundOverlay(c c2) {
        this.yu = du.f(c2);
    }

    public boolean equals(Object object) {
        if (!(object instanceof GroundOverlay)) {
            return false;
        }
        try {
            return this.yu.a(((GroundOverlay)object).yu);
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public float getBearing() {
        try {
            return this.yu.getBearing();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public LatLngBounds getBounds() {
        try {
            return this.yu.getBounds();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public float getHeight() {
        try {
            return this.yu.getHeight();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public String getId() {
        try {
            return this.yu.getId();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public LatLng getPosition() {
        try {
            return this.yu.getPosition();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public float getTransparency() {
        try {
            return this.yu.getTransparency();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public float getWidth() {
        try {
            return this.yu.getWidth();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public float getZIndex() {
        try {
            return this.yu.getZIndex();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public int hashCode() {
        try {
            return this.yu.hashCodeRemote();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public boolean isVisible() {
        try {
            return this.yu.isVisible();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public void remove() {
        try {
            this.yu.remove();
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public void setBearing(float f2) {
        try {
            this.yu.setBearing(f2);
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public void setDimensions(float f2) {
        try {
            this.yu.setDimensions(f2);
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public void setDimensions(float f2, float f3) {
        try {
            this.yu.a(f2, f3);
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public void setImage(BitmapDescriptor bitmapDescriptor) {
        try {
            this.yu.h(bitmapDescriptor.dP());
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public void setPosition(LatLng latLng) {
        try {
            this.yu.setPosition(latLng);
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public void setPositionFromBounds(LatLngBounds latLngBounds) {
        try {
            this.yu.setPositionFromBounds(latLngBounds);
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public void setTransparency(float f2) {
        try {
            this.yu.setTransparency(f2);
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public void setVisible(boolean bl2) {
        try {
            this.yu.setVisible(bl2);
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public void setZIndex(float f2) {
        try {
            this.yu.setZIndex(f2);
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }
}

