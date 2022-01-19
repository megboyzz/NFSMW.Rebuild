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
package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public interface ICameraUpdateFactoryDelegate
extends IInterface {
    public b newCameraPosition(CameraPosition var1) throws RemoteException;

    public b newLatLng(LatLng var1) throws RemoteException;

    public b newLatLngBounds(LatLngBounds var1, int var2) throws RemoteException;

    public b newLatLngBoundsWithSize(LatLngBounds var1, int var2, int var3, int var4) throws RemoteException;

    public b newLatLngZoom(LatLng var1, float var2) throws RemoteException;

    public b scrollBy(float var1, float var2) throws RemoteException;

    public b zoomBy(float var1) throws RemoteException;

    public b zoomByWithFocus(float var1, int var2, int var3) throws RemoteException;

    public b zoomIn() throws RemoteException;

    public b zoomOut() throws RemoteException;

    public b zoomTo(float var1) throws RemoteException;

    public static abstract class com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate$a
    extends Binder
    implements ICameraUpdateFactoryDelegate {
        public static ICameraUpdateFactoryDelegate L(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            if (iInterface == null) return new a(iBinder);
            if (!(iInterface instanceof ICameraUpdateFactoryDelegate)) return new a(iBinder);
            return (ICameraUpdateFactoryDelegate)iInterface;
        }

        public boolean onTransact(int n2, Parcel object, Parcel parcel, int n3) throws RemoteException {
            Object var11_5 = null;
            Object var12_6 = null;
            Object var13_7 = null;
            Object var14_8 = null;
            Object var15_9 = null;
            Object object2 = null;
            b b2 = null;
            Object var7_12 = null;
            Object var8_13 = null;
            Object var9_14 = null;
            Object var10_15 = null;
            switch (n2) {
                default: {
                    return super.onTransact(n2, object, parcel, n3);
                }
                case 1598968902: {
                    parcel.writeString("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    return true;
                }
                case 1: {
                    object.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    object2 = this.zoomIn();
                    parcel.writeNoException();
                    object = var10_15;
                    if (object2 != null) {
                        object = object2.asBinder();
                    }
                    parcel.writeStrongBinder((IBinder)object);
                    return true;
                }
                case 2: {
                    object.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    object2 = this.zoomOut();
                    parcel.writeNoException();
                    object = var11_5;
                    if (object2 != null) {
                        object = object2.asBinder();
                    }
                    parcel.writeStrongBinder((IBinder)object);
                    return true;
                }
                case 3: {
                    object.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    object2 = this.scrollBy(object.readFloat(), object.readFloat());
                    parcel.writeNoException();
                    object = var12_6;
                    if (object2 != null) {
                        object = object2.asBinder();
                    }
                    parcel.writeStrongBinder((IBinder)object);
                    return true;
                }
                case 4: {
                    object.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    object2 = this.zoomTo(object.readFloat());
                    parcel.writeNoException();
                    object = var13_7;
                    if (object2 != null) {
                        object = object2.asBinder();
                    }
                    parcel.writeStrongBinder((IBinder)object);
                    return true;
                }
                case 5: {
                    object.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    object2 = this.zoomBy(object.readFloat());
                    parcel.writeNoException();
                    object = var14_8;
                    if (object2 != null) {
                        object = object2.asBinder();
                    }
                    parcel.writeStrongBinder((IBinder)object);
                    return true;
                }
                case 6: {
                    object.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    object2 = this.zoomByWithFocus(object.readFloat(), object.readInt(), object.readInt());
                    parcel.writeNoException();
                    object = var15_9;
                    if (object2 != null) {
                        object = object2.asBinder();
                    }
                    parcel.writeStrongBinder((IBinder)object);
                    return true;
                }
                case 7: {
                    object.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    object = object.readInt() != 0 ? CameraPosition.CREATOR.createFromParcel((Parcel)object) : null;
                    b2 = this.newCameraPosition((CameraPosition)object);
                    parcel.writeNoException();
                    object = object2;
                    if (b2 != null) {
                        object = b2.asBinder();
                    }
                    parcel.writeStrongBinder((IBinder)object);
                    return true;
                }
                case 8: {
                    object.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    object = object.readInt() != 0 ? LatLng.CREATOR.createFromParcel((Parcel)object) : null;
                    object2 = this.newLatLng((LatLng)object);
                    parcel.writeNoException();
                    object = b2;
                    if (object2 != null) {
                        object = object2.asBinder();
                    }
                    parcel.writeStrongBinder((IBinder)object);
                    return true;
                }
                case 9: {
                    object.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    object2 = object.readInt() != 0 ? LatLng.CREATOR.createFromParcel((Parcel)object) : null;
                    object2 = this.newLatLngZoom((LatLng)object2, object.readFloat());
                    parcel.writeNoException();
                    object = var7_12;
                    if (object2 != null) {
                        object = object2.asBinder();
                    }
                    parcel.writeStrongBinder((IBinder)object);
                    return true;
                }
                case 10: {
                    object.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    object2 = object.readInt() != 0 ? LatLngBounds.CREATOR.createFromParcel((Parcel)object) : null;
                    object2 = this.newLatLngBounds((LatLngBounds)object2, object.readInt());
                    parcel.writeNoException();
                    object = var8_13;
                    if (object2 != null) {
                        object = object2.asBinder();
                    }
                    parcel.writeStrongBinder((IBinder)object);
                    return true;
                }
                case 11: 
            }
            object.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            object2 = object.readInt() != 0 ? LatLngBounds.CREATOR.createFromParcel((Parcel)object) : null;
            object2 = this.newLatLngBoundsWithSize((LatLngBounds)object2, object.readInt(), object.readInt(), object.readInt());
            parcel.writeNoException();
            object = var9_14;
            if (object2 != null) {
                object = object2.asBinder();
            }
            parcel.writeStrongBinder((IBinder)object);
            return true;
        }

        private static class a
        implements ICameraUpdateFactoryDelegate {
            private IBinder dU;

            a(IBinder iBinder) {
                this.dU = iBinder;
            }

            public IBinder asBinder() {
                return this.dU;
            }

            @Override
            public b newCameraPosition(CameraPosition object) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    if (object != null) {
                        parcel.writeInt(1);
                        ((CameraPosition)object).writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(7, parcel, parcel2, 0);
                    parcel2.readException();
                    object = b.a.C(parcel2.readStrongBinder());
                    return object;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public b newLatLng(LatLng object) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    if (object != null) {
                        parcel.writeInt(1);
                        ((LatLng)object).writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(8, parcel, parcel2, 0);
                    parcel2.readException();
                    object = b.a.C(parcel2.readStrongBinder());
                    return object;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public b newLatLngBounds(LatLngBounds object, int n2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    if (object != null) {
                        parcel.writeInt(1);
                        ((LatLngBounds)object).writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    parcel.writeInt(n2);
                    this.dU.transact(10, parcel, parcel2, 0);
                    parcel2.readException();
                    object = b.a.C(parcel2.readStrongBinder());
                    return object;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public b newLatLngBoundsWithSize(LatLngBounds object, int n2, int n3, int n4) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    if (object != null) {
                        parcel.writeInt(1);
                        ((LatLngBounds)object).writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    parcel.writeInt(n2);
                    parcel.writeInt(n3);
                    parcel.writeInt(n4);
                    this.dU.transact(11, parcel, parcel2, 0);
                    parcel2.readException();
                    object = b.a.C(parcel2.readStrongBinder());
                    return object;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public b newLatLngZoom(LatLng object, float f2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    if (object != null) {
                        parcel.writeInt(1);
                        ((LatLng)object).writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    parcel.writeFloat(f2);
                    this.dU.transact(9, parcel, parcel2, 0);
                    parcel2.readException();
                    object = b.a.C(parcel2.readStrongBinder());
                    return object;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public b scrollBy(float f2, float f3) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    parcel.writeFloat(f2);
                    parcel.writeFloat(f3);
                    this.dU.transact(3, parcel, parcel2, 0);
                    parcel2.readException();
                    b b2 = b.a.C(parcel2.readStrongBinder());
                    return b2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public b zoomBy(float f2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    parcel.writeFloat(f2);
                    this.dU.transact(5, parcel, parcel2, 0);
                    parcel2.readException();
                    b b2 = b.a.C(parcel2.readStrongBinder());
                    return b2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public b zoomByWithFocus(float f2, int n2, int n3) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    parcel.writeFloat(f2);
                    parcel.writeInt(n2);
                    parcel.writeInt(n3);
                    this.dU.transact(6, parcel, parcel2, 0);
                    parcel2.readException();
                    b b2 = b.a.C(parcel2.readStrongBinder());
                    return b2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public b zoomIn() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    this.dU.transact(1, parcel, parcel2, 0);
                    parcel2.readException();
                    b b2 = b.a.C(parcel2.readStrongBinder());
                    return b2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public b zoomOut() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    this.dU.transact(2, parcel, parcel2, 0);
                    parcel2.readException();
                    b b2 = b.a.C(parcel2.readStrongBinder());
                    return b2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public b zoomTo(float f2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    parcel.writeFloat(f2);
                    this.dU.transact(4, parcel, parcel2, 0);
                    parcel2.readException();
                    b b2 = b.a.C(parcel2.readStrongBinder());
                    return b2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }
        }
    }
}

