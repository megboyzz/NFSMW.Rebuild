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
import com.google.android.gms.internal.bc;

public interface bb
extends IInterface {
    public bc l(String var1) throws RemoteException;

    public static abstract class com.google.android.gms.internal.bb$a
    extends Binder
    implements bb {
        public com.google.android.gms.internal.bb$a() {
            this.attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        }

        public static bb i(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
            if (iInterface == null) return new a(iBinder);
            if (!(iInterface instanceof bb)) return new a(iBinder);
            return (bb)iInterface;
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
                    parcel.writeString("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
                    return true;
                }
                case 1: 
            }
            object.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
            object = this.l(object.readString());
            parcel.writeNoException();
            object = object != null ? object.asBinder() : null;
            parcel.writeStrongBinder((IBinder)object);
            return true;
        }

        private static class a
        implements bb {
            private IBinder dU;

            a(IBinder iBinder) {
                this.dU = iBinder;
            }

            public IBinder asBinder() {
                return this.dU;
            }

            @Override
            public bc l(String object) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
                    parcel.writeString((String)object);
                    this.dU.transact(1, parcel, parcel2, 0);
                    parcel2.readException();
                    object = bc.a.j(parcel2.readStrongBinder());
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

