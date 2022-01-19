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
import com.google.android.gms.maps.model.CameraPosition;

public interface e
extends IInterface {
    public void onCameraChange(CameraPosition var1) throws RemoteException;

    public static abstract class com.google.android.gms.maps.internal.e$a
    extends Binder
    implements e {
        public com.google.android.gms.maps.internal.e$a() {
            this.attachInterface(this, "com.google.android.gms.maps.internal.IOnCameraChangeListener");
        }

        public static e T(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnCameraChangeListener");
            if (iInterface == null) return new a(iBinder);
            if (!(iInterface instanceof e)) return new a(iBinder);
            return (e)iInterface;
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
                    parcel.writeString("com.google.android.gms.maps.internal.IOnCameraChangeListener");
                    return true;
                }
                case 1: 
            }
            object.enforceInterface("com.google.android.gms.maps.internal.IOnCameraChangeListener");
            object = object.readInt() != 0 ? CameraPosition.CREATOR.createFromParcel((Parcel)object) : null;
            this.onCameraChange((CameraPosition)object);
            parcel.writeNoException();
            return true;
        }

        private static class a
        implements e {
            private IBinder dU;

            a(IBinder iBinder) {
                this.dU = iBinder;
            }

            public IBinder asBinder() {
                return this.dU;
            }

            @Override
            public void onCameraChange(CameraPosition cameraPosition) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IOnCameraChangeListener");
                    if (cameraPosition != null) {
                        parcel.writeInt(1);
                        cameraPosition.writeToParcel(parcel, 0);
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

