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
import com.google.android.gms.maps.model.internal.e;
import java.util.List;

public final class Polygon {
    private final e yQ;

    public Polygon(e e2) {
        this.yQ = du.f(e2);
    }

    public boolean equals(Object object) {
        if (!(object instanceof Polygon)) {
            return false;
        }
        try {
            return this.yQ.a(((Polygon)object).yQ);
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public int getFillColor() {
        try {
            return this.yQ.getFillColor();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public List<List<LatLng>> getHoles() {
        try {
            return this.yQ.getHoles();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public String getId() {
        try {
            return this.yQ.getId();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public List<LatLng> getPoints() {
        try {
            return this.yQ.getPoints();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public int getStrokeColor() {
        try {
            return this.yQ.getStrokeColor();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public float getStrokeWidth() {
        try {
            return this.yQ.getStrokeWidth();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public float getZIndex() {
        try {
            return this.yQ.getZIndex();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public int hashCode() {
        try {
            return this.yQ.hashCodeRemote();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public boolean isGeodesic() {
        try {
            return this.yQ.isGeodesic();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public boolean isVisible() {
        try {
            return this.yQ.isVisible();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public void remove() {
        try {
            this.yQ.remove();
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public void setFillColor(int n2) {
        try {
            this.yQ.setFillColor(n2);
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public void setGeodesic(boolean bl2) {
        try {
            this.yQ.setGeodesic(bl2);
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public void setHoles(List<? extends List<LatLng>> list) {
        try {
            this.yQ.setHoles(list);
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public void setPoints(List<LatLng> list) {
        try {
            this.yQ.setPoints(list);
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public void setStrokeColor(int n2) {
        try {
            this.yQ.setStrokeColor(n2);
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public void setStrokeWidth(float f2) {
        try {
            this.yQ.setStrokeWidth(f2);
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public void setVisible(boolean bl2) {
        try {
            this.yQ.setVisible(bl2);
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public void setZIndex(float f2) {
        try {
            this.yQ.setZIndex(f2);
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }
}

