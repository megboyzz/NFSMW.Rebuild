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
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;

public interface IMapFragmentDelegate
extends IInterface {
    public IGoogleMapDelegate getMap() throws RemoteException;

    public boolean isReady() throws RemoteException;

    public void onCreate(Bundle var1) throws RemoteException;

    public b onCreateView(b var1, b var2, Bundle var3) throws RemoteException;

    public void onDestroy() throws RemoteException;

    public void onDestroyView() throws RemoteException;

    public void onInflate(b var1, GoogleMapOptions var2, Bundle var3) throws RemoteException;

    public void onLowMemory() throws RemoteException;

    public void onPause() throws RemoteException;

    public void onResume() throws RemoteException;

    public void onSaveInstanceState(Bundle var1) throws RemoteException;

    public static abstract class com.google.android.gms.maps.internal.IMapFragmentDelegate$a
    extends Binder
    implements IMapFragmentDelegate {
        public static IMapFragmentDelegate R(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            if (iInterface == null) return new a(iBinder);
            if (!(iInterface instanceof IMapFragmentDelegate)) return new a(iBinder);
            return (IMapFragmentDelegate)iInterface;
        }

        public boolean onTransact(int n2, Parcel object, Parcel parcel, int n3) throws RemoteException {
            GoogleMapOptions googleMapOptions = null;
            switch (n2) {
                default: {
                    return super.onTransact(n2, object, parcel, n3);
                }
                case 1598968902: {
                    parcel.writeString("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    return true;
                }
                case 1: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    object = this.getMap();
                    parcel.writeNoException();
                    object = object != null ? object.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)object);
                    return true;
                }
                case 2: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    b b2 = b.a.C(object.readStrongBinder());
                    googleMapOptions = object.readInt() != 0 ? GoogleMapOptions.CREATOR.createFromParcel((Parcel)object) : null;
                    object = object.readInt() != 0 ? (Bundle)Bundle.CREATOR.createFromParcel(object) : null;
                    this.onInflate(b2, googleMapOptions, (Bundle)object);
                    parcel.writeNoException();
                    return true;
                }
                case 3: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    object = object.readInt() != 0 ? (Bundle)Bundle.CREATOR.createFromParcel(object) : null;
                    this.onCreate((Bundle)object);
                    parcel.writeNoException();
                    return true;
                }
                case 4: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    b b3 = b.a.C(object.readStrongBinder());
                    b b4 = b.a.C(object.readStrongBinder());
                    object = object.readInt() != 0 ? (Bundle)Bundle.CREATOR.createFromParcel(object) : null;
                    b3 = this.onCreateView(b3, b4, (Bundle)object);
                    parcel.writeNoException();
                    object = googleMapOptions;
                    if (b3 != null) {
                        object = b3.asBinder();
                    }
                    parcel.writeStrongBinder((IBinder)object);
                    return true;
                }
                case 5: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    this.onResume();
                    parcel.writeNoException();
                    return true;
                }
                case 6: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    this.onPause();
                    parcel.writeNoException();
                    return true;
                }
                case 7: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    this.onDestroyView();
                    parcel.writeNoException();
                    return true;
                }
                case 8: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    this.onDestroy();
                    parcel.writeNoException();
                    return true;
                }
                case 9: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    this.onLowMemory();
                    parcel.writeNoException();
                    return true;
                }
                case 10: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    object = object.readInt() != 0 ? (Bundle)Bundle.CREATOR.createFromParcel(object) : null;
                    this.onSaveInstanceState((Bundle)object);
                    parcel.writeNoException();
                    if (object != null) {
                        parcel.writeInt(1);
                        object.writeToParcel(parcel, 1);
                        return true;
                    }
                    parcel.writeInt(0);
                    return true;
                }
                case 11: 
            }
            object.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            boolean bl2 = this.isReady();
            parcel.writeNoException();
            n2 = bl2 ? 1 : 0;
            parcel.writeInt(n2);
            return true;
        }

        private static class a
        implements IMapFragmentDelegate {
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
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
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
            public boolean isReady() throws RemoteException {
                boolean bl2 = false;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    this.dU.transact(11, parcel, parcel2, 0);
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
            public void onCreate(Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    if (bundle != null) {
                        parcel.writeInt(1);
                        bundle.writeToParcel(parcel, 0);
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

            /*
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public b onCreateView(b b2, b b3, Bundle bundle) throws RemoteException {
                Object var4_13 = null;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    void var3_12;
                    void var1_6;
                    void var2_11;
                    void var1_3;
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    if (b2 != null) {
                        IBinder iBinder = b2.asBinder();
                    } else {
                        Object var1_8 = null;
                    }
                    parcel.writeStrongBinder((IBinder)var1_3);
                    Object var1_4 = var4_13;
                    if (var2_11 != null) {
                        IBinder iBinder = var2_11.asBinder();
                    }
                    parcel.writeStrongBinder((IBinder)var1_6);
                    if (var3_12 != null) {
                        parcel.writeInt(1);
                        var3_12.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(4, parcel, parcel2, 0);
                    parcel2.readException();
                    b b4 = b.a.C(parcel2.readStrongBinder());
                    return b4;
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
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    this.dU.transact(8, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void onDestroyView() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    this.dU.transact(7, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            /*
             * Enabled unnecessary exception pruning
             */
            @Override
            public void onInflate(b b2, GoogleMapOptions googleMapOptions, Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    b2 = b2 != null ? b2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)b2);
                    if (googleMapOptions != null) {
                        parcel.writeInt(1);
                        googleMapOptions.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
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
            public void onLowMemory() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
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
            public void onPause() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
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
            public void onResume() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
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
            public void onSaveInstanceState(Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    if (bundle != null) {
                        parcel.writeInt(1);
                        bundle.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(10, parcel, parcel2, 0);
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

