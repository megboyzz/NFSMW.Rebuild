/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Binder
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 */
package com.google.android.gms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.maps.model.LatLng;

public interface d
extends IInterface {
    public float getAlpha() throws RemoteException;

    public String getId() throws RemoteException;

    public LatLng getPosition() throws RemoteException;

    public float getRotation() throws RemoteException;

    public String getSnippet() throws RemoteException;

    public String getTitle() throws RemoteException;

    public boolean h(d var1) throws RemoteException;

    public int hashCodeRemote() throws RemoteException;

    public void hideInfoWindow() throws RemoteException;

    public void i(b var1) throws RemoteException;

    public boolean isDraggable() throws RemoteException;

    public boolean isFlat() throws RemoteException;

    public boolean isInfoWindowShown() throws RemoteException;

    public boolean isVisible() throws RemoteException;

    public void remove() throws RemoteException;

    public void setAlpha(float var1) throws RemoteException;

    public void setAnchor(float var1, float var2) throws RemoteException;

    public void setDraggable(boolean var1) throws RemoteException;

    public void setFlat(boolean var1) throws RemoteException;

    public void setInfoWindowAnchor(float var1, float var2) throws RemoteException;

    public void setPosition(LatLng var1) throws RemoteException;

    public void setRotation(float var1) throws RemoteException;

    public void setSnippet(String var1) throws RemoteException;

    public void setTitle(String var1) throws RemoteException;

    public void setVisible(boolean var1) throws RemoteException;

    public void showInfoWindow() throws RemoteException;

    public static abstract class com.google.android.gms.maps.model.internal.d$a
    extends Binder
    implements d {
        public static d aj(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            if (iInterface == null) return new a(iBinder);
            if (!(iInterface instanceof d)) return new a(iBinder);
            return (d)iInterface;
        }

        public boolean onTransact(int n2, Parcel object, Parcel parcel, int n3) throws RemoteException {
            int n4 = 0;
            int n5 = 0;
            boolean bl2 = false;
            int n6 = 0;
            int n7 = 0;
            boolean bl3 = false;
            int n8 = 0;
            boolean bl4 = false;
            switch (n2) {
                default: {
                    return super.onTransact(n2, (Parcel)object, parcel, n3);
                }
                case 1598968902: {
                    parcel.writeString("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    return true;
                }
                case 1: {
                    object.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.remove();
                    parcel.writeNoException();
                    return true;
                }
                case 2: {
                    object.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    object = this.getId();
                    parcel.writeNoException();
                    parcel.writeString((String)object);
                    return true;
                }
                case 3: {
                    object.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    object = object.readInt() != 0 ? LatLng.CREATOR.createFromParcel((Parcel)object) : null;
                    this.setPosition((LatLng)object);
                    parcel.writeNoException();
                    return true;
                }
                case 4: {
                    object.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    object = this.getPosition();
                    parcel.writeNoException();
                    if (object != null) {
                        parcel.writeInt(1);
                        ((LatLng)object).writeToParcel(parcel, 1);
                        return true;
                    }
                    parcel.writeInt(0);
                    return true;
                }
                case 5: {
                    object.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.setTitle(object.readString());
                    parcel.writeNoException();
                    return true;
                }
                case 6: {
                    object.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    object = this.getTitle();
                    parcel.writeNoException();
                    parcel.writeString((String)object);
                    return true;
                }
                case 7: {
                    object.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.setSnippet(object.readString());
                    parcel.writeNoException();
                    return true;
                }
                case 8: {
                    object.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    object = this.getSnippet();
                    parcel.writeNoException();
                    parcel.writeString((String)object);
                    return true;
                }
                case 9: {
                    object.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    if (object.readInt() != 0) {
                        bl4 = true;
                    }
                    this.setDraggable(bl4);
                    parcel.writeNoException();
                    return true;
                }
                case 10: {
                    object.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    bl4 = this.isDraggable();
                    parcel.writeNoException();
                    n2 = n4;
                    if (bl4) {
                        n2 = 1;
                    }
                    parcel.writeInt(n2);
                    return true;
                }
                case 11: {
                    object.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.showInfoWindow();
                    parcel.writeNoException();
                    return true;
                }
                case 12: {
                    object.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.hideInfoWindow();
                    parcel.writeNoException();
                    return true;
                }
                case 13: {
                    object.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    bl4 = this.isInfoWindowShown();
                    parcel.writeNoException();
                    n2 = n5;
                    if (bl4) {
                        n2 = 1;
                    }
                    parcel.writeInt(n2);
                    return true;
                }
                case 14: {
                    object.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    bl4 = bl2;
                    if (object.readInt() != 0) {
                        bl4 = true;
                    }
                    this.setVisible(bl4);
                    parcel.writeNoException();
                    return true;
                }
                case 15: {
                    object.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    bl4 = this.isVisible();
                    parcel.writeNoException();
                    n2 = n6;
                    if (bl4) {
                        n2 = 1;
                    }
                    parcel.writeInt(n2);
                    return true;
                }
                case 16: {
                    object.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    bl4 = this.h(com.google.android.gms.maps.model.internal.d$a.aj(object.readStrongBinder()));
                    parcel.writeNoException();
                    n2 = n7;
                    if (bl4) {
                        n2 = 1;
                    }
                    parcel.writeInt(n2);
                    return true;
                }
                case 17: {
                    object.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    n2 = this.hashCodeRemote();
                    parcel.writeNoException();
                    parcel.writeInt(n2);
                    return true;
                }
                case 18: {
                    object.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.i(b.a.C(object.readStrongBinder()));
                    parcel.writeNoException();
                    return true;
                }
                case 19: {
                    object.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.setAnchor(object.readFloat(), object.readFloat());
                    parcel.writeNoException();
                    return true;
                }
                case 20: {
                    object.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    bl4 = bl3;
                    if (object.readInt() != 0) {
                        bl4 = true;
                    }
                    this.setFlat(bl4);
                    parcel.writeNoException();
                    return true;
                }
                case 21: {
                    object.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    bl4 = this.isFlat();
                    parcel.writeNoException();
                    n2 = n8;
                    if (bl4) {
                        n2 = 1;
                    }
                    parcel.writeInt(n2);
                    return true;
                }
                case 22: {
                    object.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.setRotation(object.readFloat());
                    parcel.writeNoException();
                    return true;
                }
                case 23: {
                    object.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    float f2 = this.getRotation();
                    parcel.writeNoException();
                    parcel.writeFloat(f2);
                    return true;
                }
                case 24: {
                    object.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.setInfoWindowAnchor(object.readFloat(), object.readFloat());
                    parcel.writeNoException();
                    return true;
                }
                case 25: {
                    object.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.setAlpha(object.readFloat());
                    parcel.writeNoException();
                    return true;
                }
                case 26: 
            }
            object.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            float f3 = this.getAlpha();
            parcel.writeNoException();
            parcel.writeFloat(f3);
            return true;
        }

        private static class a
        implements d {
            private IBinder dU;

            a(IBinder iBinder) {
                this.dU = iBinder;
            }

            public IBinder asBinder() {
                return this.dU;
            }

            @Override
            public float getAlpha() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.dU.transact(26, parcel, parcel2, 0);
                    parcel2.readException();
                    float f2 = parcel2.readFloat();
                    return f2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public String getId() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.dU.transact(2, parcel, parcel2, 0);
                    parcel2.readException();
                    String string2 = parcel2.readString();
                    return string2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public LatLng getPosition() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.dU.transact(4, parcel, parcel2, 0);
                    parcel2.readException();
                    LatLng latLng = parcel2.readInt() != 0 ? LatLng.CREATOR.createFromParcel(parcel2) : null;
                    return latLng;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public float getRotation() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.dU.transact(23, parcel, parcel2, 0);
                    parcel2.readException();
                    float f2 = parcel2.readFloat();
                    return f2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public String getSnippet() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.dU.transact(8, parcel, parcel2, 0);
                    parcel2.readException();
                    String string2 = parcel2.readString();
                    return string2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public String getTitle() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.dU.transact(6, parcel, parcel2, 0);
                    parcel2.readException();
                    String string2 = parcel2.readString();
                    return string2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public boolean h(d d2) throws RemoteException {
                boolean bl2 = false;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    d2 = d2 != null ? d2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)d2);
                    this.dU.transact(16, parcel, parcel2, 0);
                    parcel2.readException();
                    int n2 = parcel2.readInt();
                    if (n2 == 0) return bl2;
                    bl2 = true;
                    return bl2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public int hashCodeRemote() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.dU.transact(17, parcel, parcel2, 0);
                    parcel2.readException();
                    int n2 = parcel2.readInt();
                    return n2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void hideInfoWindow() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.dU.transact(12, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void i(b b2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    b2 = b2 != null ? b2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)b2);
                    this.dU.transact(18, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public boolean isDraggable() throws RemoteException {
                boolean bl2 = false;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.dU.transact(10, parcel, parcel2, 0);
                    parcel2.readException();
                    int n2 = parcel2.readInt();
                    if (n2 == 0) return bl2;
                    bl2 = true;
                    return bl2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public boolean isFlat() throws RemoteException {
                boolean bl2 = false;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.dU.transact(21, parcel, parcel2, 0);
                    parcel2.readException();
                    int n2 = parcel2.readInt();
                    if (n2 == 0) return bl2;
                    bl2 = true;
                    return bl2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public boolean isInfoWindowShown() throws RemoteException {
                boolean bl2 = false;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.dU.transact(13, parcel, parcel2, 0);
                    parcel2.readException();
                    int n2 = parcel2.readInt();
                    if (n2 == 0) return bl2;
                    bl2 = true;
                    return bl2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public boolean isVisible() throws RemoteException {
                boolean bl2 = false;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.dU.transact(15, parcel, parcel2, 0);
                    parcel2.readException();
                    int n2 = parcel2.readInt();
                    if (n2 == 0) return bl2;
                    bl2 = true;
                    return bl2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void remove() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.dU.transact(1, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void setAlpha(float f2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    parcel.writeFloat(f2);
                    this.dU.transact(25, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void setAnchor(float f2, float f3) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    parcel.writeFloat(f2);
                    parcel.writeFloat(f3);
                    this.dU.transact(19, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void setDraggable(boolean bl2) throws RemoteException {
                int n2 = 0;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    if (bl2) {
                        n2 = 1;
                    }
                    parcel.writeInt(n2);
                    this.dU.transact(9, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void setFlat(boolean bl2) throws RemoteException {
                int n2 = 0;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    if (bl2) {
                        n2 = 1;
                    }
                    parcel.writeInt(n2);
                    this.dU.transact(20, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void setInfoWindowAnchor(float f2, float f3) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    parcel.writeFloat(f2);
                    parcel.writeFloat(f3);
                    this.dU.transact(24, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void setPosition(LatLng latLng) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    if (latLng != null) {
                        parcel.writeInt(1);
                        latLng.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(3, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void setRotation(float f2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    parcel.writeFloat(f2);
                    this.dU.transact(22, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void setSnippet(String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    parcel.writeString(string2);
                    this.dU.transact(7, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void setTitle(String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    parcel.writeString(string2);
                    this.dU.transact(5, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void setVisible(boolean bl2) throws RemoteException {
                int n2 = 0;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    if (bl2) {
                        n2 = 1;
                    }
                    parcel.writeInt(n2);
                    this.dU.transact(14, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void showInfoWindow() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.dU.transact(11, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }
        }
    }
}

