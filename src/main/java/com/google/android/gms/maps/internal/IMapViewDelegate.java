/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Binder
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 */
package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;

public interface IMapViewDelegate
extends IInterface {
    public IGoogleMapDelegate getMap() throws RemoteException;

    public b getView() throws RemoteException;

    public void onCreate(Bundle var1) throws RemoteException;

    public void onDestroy() throws RemoteException;

    public void onLowMemory() throws RemoteException;

    public void onPause() throws RemoteException;

    public void onResume() throws RemoteException;

    public void onSaveInstanceState(Bundle var1) throws RemoteException;

    public static abstract class com.google.android.gms.maps.internal.IMapViewDelegate$a
    extends Binder
    implements IMapViewDelegate {
        public static IMapViewDelegate S(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
            if (iInterface == null) return new a(iBinder);
            if (!(iInterface instanceof IMapViewDelegate)) return new a(iBinder);
            return (IMapViewDelegate)iInterface;
        }

        public boolean onTransact(int n2, Parcel object, Parcel parcel, int n3) throws RemoteException {
            b b2 = null;
            b b3 = null;
            IGoogleMapDelegate iGoogleMapDelegate = null;
            b b4 = null;
            switch (n2) {
                default: {
                    return super.onTransact(n2, object, parcel, n3);
                }
                case 1598968902: {
                    parcel.writeString("com.google.android.gms.maps.internal.IMapViewDelegate");
                    return true;
                }
                case 1: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
                    iGoogleMapDelegate = this.getMap();
                    parcel.writeNoException();
                    object = b4;
                    if (iGoogleMapDelegate != null) {
                        object = iGoogleMapDelegate.asBinder();
                    }
                    parcel.writeStrongBinder((IBinder)object);
                    return true;
                }
                case 2: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
                    b4 = b2;
                    if (object.readInt() != 0) {
                        b4 = (Bundle)Bundle.CREATOR.createFromParcel(object);
                    }
                    this.onCreate((Bundle)b4);
                    parcel.writeNoException();
                    return true;
                }
                case 3: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
                    this.onResume();
                    parcel.writeNoException();
                    return true;
                }
                case 4: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
                    this.onPause();
                    parcel.writeNoException();
                    return true;
                }
                case 5: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
                    this.onDestroy();
                    parcel.writeNoException();
                    return true;
                }
                case 6: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
                    this.onLowMemory();
                    parcel.writeNoException();
                    return true;
                }
                case 7: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
                    b4 = b3;
                    if (object.readInt() != 0) {
                        b4 = (Bundle)Bundle.CREATOR.createFromParcel(object);
                    }
                    this.onSaveInstanceState((Bundle)b4);
                    parcel.writeNoException();
                    if (b4 != null) {
                        parcel.writeInt(1);
                        b4.writeToParcel(parcel, 1);
                        return true;
                    }
                    parcel.writeInt(0);
                    return true;
                }
                case 8: 
            }
            object.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
            b4 = this.getView();
            parcel.writeNoException();
            object = iGoogleMapDelegate;
            if (b4 != null) {
                object = b4.asBinder();
            }
            parcel.writeStrongBinder((IBinder)object);
            return true;
        }

        private static class a
        implements IMapViewDelegate {
            private IBinder dU;

            a(IBinder iBinder) {
                this.dU = iBinder;
            }

            public IBinder asBinder() {
                return this.dU;
            }

            @Override
            public IGoogleMapDelegate getMap() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
                    this.dU.transact(1, parcel, parcel2, 0);
                    parcel2.readException();
                    IGoogleMapDelegate iGoogleMapDelegate = IGoogleMapDelegate.a.O(parcel2.readStrongBinder());
                    return iGoogleMapDelegate;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public b getView() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
                    this.dU.transact(8, parcel, parcel2, 0);
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
            public void onCreate(Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
                    if (bundle != null) {
                        parcel.writeInt(1);
                        bundle.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(2, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void onDestroy() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
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
            public void onLowMemory() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
                    this.dU.transact(6, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void onPause() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
                    this.dU.transact(4, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void onResume() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
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
            public void onSaveInstanceState(Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
                    if (bundle != null) {
                        parcel.writeInt(1);
                        bundle.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(7, parcel, parcel2, 0);
                    parcel2.readException();
                    if (parcel2.readInt() == 0) return;
                    bundle.readFromParcel(parcel2);
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

