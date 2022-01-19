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
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.model.internal.a;

public interface c
extends IInterface {
    public IMapViewDelegate a(b var1, GoogleMapOptions var2) throws RemoteException;

    public void a(b var1, int var2) throws RemoteException;

    public void e(b var1) throws RemoteException;

    public ICameraUpdateFactoryDelegate ed() throws RemoteException;

    public com.google.android.gms.maps.model.internal.a ee() throws RemoteException;

    public IMapFragmentDelegate f(b var1) throws RemoteException;

    public static abstract class com.google.android.gms.maps.internal.c$a
    extends Binder
    implements c {
        public static c N(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICreator");
            if (iInterface == null) return new a(iBinder);
            if (!(iInterface instanceof c)) return new a(iBinder);
            return (c)iInterface;
        }

        public boolean onTransact(int n2, Parcel object, Parcel parcel, int n3) throws RemoteException {
            Object object2 = null;
            Object var7_6 = null;
            Object var8_7 = null;
            Object object3 = null;
            switch (n2) {
                default: {
                    return super.onTransact(n2, object, parcel, n3);
                }
                case 1598968902: {
                    parcel.writeString("com.google.android.gms.maps.internal.ICreator");
                    return true;
                }
                case 1: {
                    object.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    this.e(b.a.C(object.readStrongBinder()));
                    parcel.writeNoException();
                    return true;
                }
                case 2: {
                    object.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    object2 = this.f(b.a.C(object.readStrongBinder()));
                    parcel.writeNoException();
                    object = object3;
                    if (object2 != null) {
                        object = object2.asBinder();
                    }
                    parcel.writeStrongBinder((IBinder)object);
                    return true;
                }
                case 3: {
                    object.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    object3 = b.a.C(object.readStrongBinder());
                    object = object.readInt() != 0 ? GoogleMapOptions.CREATOR.createFromParcel((Parcel)object) : null;
                    object3 = this.a((b)object3, (GoogleMapOptions)object);
                    parcel.writeNoException();
                    object = object2;
                    if (object3 != null) {
                        object = object3.asBinder();
                    }
                    parcel.writeStrongBinder((IBinder)object);
                    return true;
                }
                case 4: {
                    object.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    object2 = this.ed();
                    parcel.writeNoException();
                    object = var7_6;
                    if (object2 != null) {
                        object = object2.asBinder();
                    }
                    parcel.writeStrongBinder((IBinder)object);
                    return true;
                }
                case 5: {
                    object.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    object2 = this.ee();
                    parcel.writeNoException();
                    object = var8_7;
                    if (object2 != null) {
                        object = object2.asBinder();
                    }
                    parcel.writeStrongBinder((IBinder)object);
                    return true;
                }
                case 6: 
            }
            object.enforceInterface("com.google.android.gms.maps.internal.ICreator");
            this.a(b.a.C(object.readStrongBinder()), object.readInt());
            parcel.writeNoException();
            return true;
        }

        private static class a
        implements c {
            private IBinder dU;

            a(IBinder iBinder) {
                this.dU = iBinder;
            }

            /*
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public IMapViewDelegate a(b object, GoogleMapOptions googleMapOptions) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    void var2_8;
                    void var1_3;
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    if (object != null) {
                        IBinder iBinder = object.asBinder();
                    } else {
                        Object var1_5 = null;
                    }
                    parcel.writeStrongBinder((IBinder)var1_3);
                    if (var2_8 != null) {
                        parcel.writeInt(1);
                        var2_8.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(3, parcel, parcel2, 0);
                    parcel2.readException();
                    IMapViewDelegate iMapViewDelegate = IMapViewDelegate.a.S(parcel2.readStrongBinder());
                    return iMapViewDelegate;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void a(b b2, int n2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    b2 = b2 != null ? b2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)b2);
                    parcel.writeInt(n2);
                    this.dU.transact(6, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            public IBinder asBinder() {
                return this.dU;
            }

            @Override
            public void e(b b2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    b2 = b2 != null ? b2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)b2);
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
            public ICameraUpdateFactoryDelegate ed() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    this.dU.transact(4, parcel, parcel2, 0);
                    parcel2.readException();
                    ICameraUpdateFactoryDelegate iCameraUpdateFactoryDelegate = ICameraUpdateFactoryDelegate.a.L(parcel2.readStrongBinder());
                    return iCameraUpdateFactoryDelegate;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public com.google.android.gms.maps.model.internal.a ee() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    this.dU.transact(5, parcel, parcel2, 0);
                    parcel2.readException();
                    com.google.android.gms.maps.model.internal.a a2 = a.a.ag(parcel2.readStrongBinder());
                    return a2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public IMapFragmentDelegate f(b object) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    object = object != null ? object.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)object);
                    this.dU.transact(2, parcel, parcel2, 0);
                    parcel2.readException();
                    object = IMapFragmentDelegate.a.R(parcel2.readStrongBinder());
                    return object;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }
        }
    }
}

