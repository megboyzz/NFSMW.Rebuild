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
import com.google.android.gms.maps.model.internal.d;

public interface f
extends IInterface {
    public void e(d var1) throws RemoteException;

    public static abstract class com.google.android.gms.maps.internal.f$a
    extends Binder
    implements f {
        public com.google.android.gms.maps.internal.f$a() {
            this.attachInterface(this, "com.google.android.gms.maps.internal.IOnInfoWindowClickListener");
        }

        public static f U(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnInfoWindowClickListener");
            if (iInterface == null) return new a(iBinder);
            if (!(iInterface instanceof f)) return new a(iBinder);
            return (f)iInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int n2, Parcel parcel, Parcel parcel2, int n3) throws RemoteException {
            switch (n2) {
                default: {
                    return super.onTransact(n2, parcel, parcel2, n3);
                }
                case 1598968902: {
                    parcel2.writeString("com.google.android.gms.maps.internal.IOnInfoWindowClickListener");
                    return true;
                }
                case 1: 
            }
            parcel.enforceInterface("com.google.android.gms.maps.internal.IOnInfoWindowClickListener");
            this.e(d.a.aj(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }

        private static class a
        implements f {
            private IBinder dU;

            a(IBinder iBinder) {
                this.dU = iBinder;
            }

            public IBinder asBinder() {
                return this.dU;
            }

            @Override
            public void e(d d2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IOnInfoWindowClickListener");
                    d2 = d2 != null ? d2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)d2);
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

