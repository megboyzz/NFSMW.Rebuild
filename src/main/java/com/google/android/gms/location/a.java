/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.location.Location
 *  android.os.Binder
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 */
package com.google.android.gms.location;

import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface a
extends IInterface {
    public void onLocationChanged(Location var1) throws RemoteException;

    public static abstract class com.google.android.gms.location.a$a
    extends Binder
    implements com.google.android.gms.location.a {
        public com.google.android.gms.location.a$a() {
            this.attachInterface(this, "com.google.android.gms.location.ILocationListener");
        }

        public static com.google.android.gms.location.a G(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationListener");
            if (iInterface == null) return new a(iBinder);
            if (!(iInterface instanceof com.google.android.gms.location.a)) return new a(iBinder);
            return (com.google.android.gms.location.a)iInterface;
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
                    parcel.writeString("com.google.android.gms.location.ILocationListener");
                    return true;
                }
                case 1: 
            }
            object.enforceInterface("com.google.android.gms.location.ILocationListener");
            object = object.readInt() != 0 ? (Location)Location.CREATOR.createFromParcel(object) : null;
            this.onLocationChanged((Location)object);
            return true;
        }

        private static class a
        implements com.google.android.gms.location.a {
            private IBinder dU;

            a(IBinder iBinder) {
                this.dU = iBinder;
            }

            public IBinder asBinder() {
                return this.dU;
            }

            @Override
            public void onLocationChanged(Location location) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.location.ILocationListener");
                    if (location != null) {
                        parcel.writeInt(1);
                        location.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(1, parcel, null, 1);
                    return;
                }
                finally {
                    parcel.recycle();
                }
            }
        }
    }
}

