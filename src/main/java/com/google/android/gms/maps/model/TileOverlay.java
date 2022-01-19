/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 */
package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.internal.du;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.internal.f;

public final class TileOverlay {
    private final f yV;

    public TileOverlay(f f2) {
        this.yV = du.f(f2);
    }

    public void clearTileCache() {
        try {
            this.yV.clearTileCache();
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public boolean equals(Object object) {
        if (!(object instanceof TileOverlay)) {
            return false;
        }
        try {
            return this.yV.a(((TileOverlay)object).yV);
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public boolean getFadeIn() {
        try {
            return this.yV.getFadeIn();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public String getId() {
        try {
            return this.yV.getId();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public float getZIndex() {
        try {
            return this.yV.getZIndex();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public int hashCode() {
        try {
            return this.yV.hashCodeRemote();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public boolean isVisible() {
        try {
            return this.yV.isVisible();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public void remove() {
        try {
            this.yV.remove();
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public void setFadeIn(boolean bl2) {
        try {
            this.yV.setFadeIn(bl2);
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public void setVisible(boolean bl2) {
        try {
            this.yV.setVisible(bl2);
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public void setZIndex(float f2) {
        try {
            this.yV.setZIndex(f2);
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }
}

