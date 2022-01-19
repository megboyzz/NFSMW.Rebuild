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
import com.google.android.gms.maps.model.internal.d;

public interface d
extends IInterface {
    public b f(com.google.android.gms.maps.model.internal.d var1) throws RemoteException;

    public b g(com.google.android.gms.maps.model.internal.d var1) throws RemoteException;

    public static abstract class com.google.android.gms.maps.internal.d$a
    extends Binder
    implements d {
        public com.google.android.gms.maps.internal.d$a() {
            this.attachInterface(this, "com.google.android.gms.maps.internal.IInfoWindowAdapter");
        }

        public static d P(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
            if (iInterface == null) return new a(iBinder);
            if (!(iInterface instanceof d)) return new a(iBinder);
            return (d)iInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int n2, Parcel object, Parcel parcel, int n3) throws RemoteException {
            b b2 = null;
            b b3 = null;
            switch (n2) {
                default: {
                    return super.onTransact(n2, object, parcel, n3);
                }
                case 1598968902: {
                    parcel.writeString("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    return true;
                }
                case 1: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    b2 = this.f(d.a.aj(object.readStrongBinder()));
                    parcel.writeNoException();
                    object = b3;
                    if (b2 != null) {
                        object = b2.asBinder();
                    }
                    parcel.writeStrongBinder((IBinder)object);
                    return true;
                }
                case 2: 
            }
            object.enforceInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
            b3 = this.g(d.a.aj(object.readStrongBinder()));
            parcel.writeNoException();
            object = b2;
            if (b3 != null) {
                object = b3.asBinder();
            }
            parcel.writeStrongBinder((IBinder)object);
            return true;
        }

        private static class a
        implements d {
            private IBinder dU;

            a(IBinder iBinder) {
                this.dU = iBinder;
            }

            public IBinder asBinder() {
                return this.dU;
            }

            @Override
            public b f(com.google.android.gms.maps.model.internal.d object) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    object = object != null ? object.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)object);
                    this.dU.transact(1, parcel, parcel2, 0);
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
            public b g(com.google.android.gms.maps.model.internal.d object) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    object = object != null ? object.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)object);
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

