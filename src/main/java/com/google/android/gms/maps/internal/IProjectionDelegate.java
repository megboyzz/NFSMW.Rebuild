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
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.VisibleRegion;

public interface IProjectionDelegate
extends IInterface {
    public LatLng fromScreenLocation(b var1) throws RemoteException;

    public VisibleRegion getVisibleRegion() throws RemoteException;

    public b toScreenLocation(LatLng var1) throws RemoteException;

    public static abstract class com.google.android.gms.maps.internal.IProjectionDelegate$a
    extends Binder
    implements IProjectionDelegate {
        public static IProjectionDelegate ad(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
            if (iInterface == null) return new a(iBinder);
            if (!(iInterface instanceof IProjectionDelegate)) return new a(iBinder);
            return (IProjectionDelegate)iInterface;
        }

        public boolean onTransact(int n2, Parcel object, Parcel parcel, int n3) throws RemoteException {
            Object var5_5 = null;
            switch (n2) {
                default: {
                    return super.onTransact(n2, (Parcel)object, parcel, n3);
                }
                case 1598968902: {
                    parcel.writeString("com.google.android.gms.maps.internal.IProjectionDelegate");
                    return true;
                }
                case 1: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
                    object = this.fromScreenLocation(b.a.C(object.readStrongBinder()));
                    parcel.writeNoException();
                    if (object != null) {
                        parcel.writeInt(1);
                        ((LatLng)object).writeToParcel(parcel, 1);
                        return true;
                    }
                    parcel.writeInt(0);
                    return true;
                }
                case 2: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
                    object = object.readInt() != 0 ? LatLng.CREATOR.createFromParcel((Parcel)object) : null;
                    b b2 = this.toScreenLocation((LatLng)object);
                    parcel.writeNoException();
                    object = var5_5;
                    if (b2 != null) {
                        object = b2.asBinder();
                    }
                    parcel.writeStrongBinder((IBinder)object);
                    return true;
                }
                case 3: 
            }
            object.enforceInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
            object = this.getVisibleRegion();
            parcel.writeNoException();
            if (object != null) {
                parcel.writeInt(1);
                ((VisibleRegion)object).writeToParcel(parcel, 1);
                return true;
            }
            parcel.writeInt(0);
            return true;
        }

        private static class a
        implements IProjectionDelegate {
            private IBinder dU;

            a(IBinder iBinder) {
                this.dU = iBinder;
            }

            public IBinder asBinder() {
                return this.dU;
            }

            @Override
            public LatLng fromScreenLocation(b object) throws RemoteException {
                Object var2_3 = null;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IProjectionDelegate");
                    object = object != null ? object.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)object);
                    this.dU.transact(1, parcel, parcel2, 0);
                    parcel2.readException();
                    object = var2_3;
                    if (parcel2.readInt() == 0) return object;
                    object = LatLng.CREATOR.createFromParcel(parcel2);
                    return object;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public VisibleRegion getVisibleRegion() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IProjectionDelegate");
                    this.dU.transact(3, parcel, parcel2, 0);
                    parcel2.readException();
                    VisibleRegion visibleRegion = parcel2.readInt() != 0 ? VisibleRegion.CREATOR.createFromParcel(parcel2) : null;
                    return visibleRegion;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public b toScreenLocation(LatLng object) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IProjectionDelegate");
                    if (object != null) {
                        parcel.writeInt(1);
                        ((LatLng)object).writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(2, parcel, parcel2, 0);
                    parcel2.readException();
                    object = b.a.C(parcel2.readStrongBinder());
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

