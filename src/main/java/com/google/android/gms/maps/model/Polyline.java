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
import com.google.android.gms.maps.model.internal.IPolylineDelegate;
import java.util.List;

public final class Polyline {
    private final IPolylineDelegate yU;

    public Polyline(IPolylineDelegate iPolylineDelegate) {
        this.yU = du.f(iPolylineDelegate);
    }

    public boolean equals(Object object) {
        if (!(object instanceof Polyline)) {
            return false;
        }
        try {
            return this.yU.equalsRemote(((Polyline)object).yU);
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public int getColor() {
        try {
            return this.yU.getColor();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public String getId() {
        try {
            return this.yU.getId();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public List<LatLng> getPoints() {
        try {
            return this.yU.getPoints();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public float getWidth() {
        try {
            return this.yU.getWidth();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public float getZIndex() {
        try {
            return this.yU.getZIndex();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public int hashCode() {
        try {
            return this.yU.hashCodeRemote();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public boolean isGeodesic() {
        try {
            return this.yU.isGeodesic();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public boolean isVisible() {
        try {
            return this.yU.isVisible();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public void remove() {
        try {
            this.yU.remove();
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public void setColor(int n2) {
        try {
            this.yU.setColor(n2);
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public void setGeodesic(boolean bl2) {
        try {
            this.yU.setGeodesic(bl2);
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public void setPoints(List<LatLng> list) {
        try {
            this.yU.setPoints(list);
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public void setVisible(boolean bl2) {
        try {
            this.yU.setVisible(bl2);
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public void setWidth(float f2) {
        try {
            this.yU.setWidth(f2);
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public void setZIndex(float f2) {
        try {
            this.yU.setZIndex(f2);
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }
}

