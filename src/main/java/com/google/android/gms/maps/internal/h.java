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
import com.google.android.gms.maps.model.LatLng;

public interface h
extends IInterface {
    public void onMapClick(LatLng var1) throws RemoteException;

    public static abstract class com.google.android.gms.maps.internal.h$a
    extends Binder
    implements h {
        public com.google.android.gms.maps.internal.h$a() {
            this.attachInterface(this, "com.google.android.gms.maps.internal.IOnMapClickListener");
        }

        public static h W(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnMapClickListener");
            if (iInterface == null) return new a(iBinder);
            if (!(iInterface instanceof h)) return new a(iBinder);
            return (h)iInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int n2, Parcel object, Parcel parcel, int n3) throws RemoteException {
            switch (n2) {
                default: {
                    return super.onTransact(n2, object, parcel, n3);
                }
                case 1598968902: {
                    parcel.writeString("com.google.android.gms.maps.internal.IOnMapClickListener");
                    return true;
                }
                case 1: 
            }
            object.enforceInterface("com.google.android.gms.maps.internal.IOnMapClickListener");
            object = object.readInt() != 0 ? LatLng.CREATOR.createFromParcel((Parcel)object) : null;
            this.onMapClick((LatLng)object);
            parcel.writeNoException();
            return true;
        }

        private static class a
        implements h {
            private IBinder dU;

            a(IBinder iBinder) {
                this.dU = iBinder;
            }

            public IBinder asBinder() {
                return this.dU;
            }

            @Override
            public void onMapClick(LatLng latLng) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMapClickListener");
                    if (latLng != null) {
                        parcel.writeInt(1);
                        latLng.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(1, parcel, parcel2, 0);
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

