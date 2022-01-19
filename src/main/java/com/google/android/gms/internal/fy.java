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
package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.fz;

public interface fy
extends IInterface {
    public void a(int var1, fz var2) throws RemoteException;

    public static abstract class com.google.android.gms.internal.fy$a
    extends Binder
    implements fy {
        public static fy K(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
            if (iInterface == null) return new a(iBinder);
            if (!(iInterface instanceof fy)) return new a(iBinder);
            return (fy)iInterface;
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
                    parcel.writeString("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                    return true;
                }
                case 1: 
            }
            object.enforceInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
            n2 = object.readInt();
            object = object.readInt() != 0 ? fz.CREATOR.ae((Parcel)object) : null;
            this.a(n2, (fz)object);
            return true;
        }

        private static class a
        implements fy {
            private IBinder dU;

            a(IBinder iBinder) {
                this.dU = iBinder;
            }

            @Override
            public void a(int n2, fz fz2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                    parcel.writeInt(n2);
                    if (fz2 != null) {
                        parcel.writeInt(1);
                        fz2.writeToParcel(parcel, 0);
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

            public IBinder asBinder() {
                return this.dU;
            }
        }
    }
}

