/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 */
package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.internal.du;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.internal.b;

public final class Circle {
    private final b ym;

    public Circle(b b2) {
        this.ym = du.f(b2);
    }

    public boolean equals(Object object) {
        if (!(object instanceof Circle)) {
            return false;
        }
        try {
            return this.ym.a(((Circle)object).ym);
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public LatLng getCenter() {
        try {
            return this.ym.getCenter();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public int getFillColor() {
        try {
            return this.ym.getFillColor();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public String getId() {
        try {
            return this.ym.getId();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public double getRadius() {
        try {
            return this.ym.getRadius();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public int getStrokeColor() {
        try {
            return this.ym.getStrokeColor();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public float getStrokeWidth() {
        try {
            return this.ym.getStrokeWidth();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public float getZIndex() {
        try {
            return this.ym.getZIndex();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public int hashCode() {
        try {
            return this.ym.hashCodeRemote();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public boolean isVisible() {
        try {
            return this.ym.isVisible();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public void remove() {
        try {
            this.ym.remove();
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public void setCenter(LatLng latLng) {
        try {
            this.ym.setCenter(latLng);
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public void setFillColor(int n2) {
        try {
            this.ym.setFillColor(n2);
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public void setRadius(double d2) {
        try {
            this.ym.setRadius(d2);
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public void setStrokeColor(int n2) {
        try {
            this.ym.setStrokeColor(n2);
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public void setStrokeWidth(float f2) {
        try {
            this.ym.setStrokeWidth(f2);
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public void setVisible(boolean bl2) {
        try {
            this.ym.setVisible(bl2);
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public void setZIndex(float f2) {
        try {
            this.ym.setZIndex(f2);
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }
}

