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
package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface dp
extends IInterface {
    public void b(int var1, IBinder var2, Bundle var3) throws RemoteException;

    public static abstract class com.google.android.gms.internal.dp$a
    extends Binder
    implements dp {
        public com.google.android.gms.internal.dp$a() {
            this.attachInterface(this, "com.google.android.gms.common.internal.IGmsCallbacks");
        }

        public static dp v(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsCallbacks");
            if (iInterface == null) return new a(iBinder);
            if (!(iInterface instanceof dp)) return new a(iBinder);
            return (dp)iInterface;
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
                    parcel.writeString("com.google.android.gms.common.internal.IGmsCallbacks");
                    return true;
                }
                case 1: 
            }
            object.enforceInterface("com.google.android.gms.common.internal.IGmsCallbacks");
            n2 = object.readInt();
            IBinder iBinder = object.readStrongBinder();
            object = object.readInt() != 0 ? (Bundle)Bundle.CREATOR.createFromParcel(object) : null;
            this.b(n2, iBinder, (Bundle)object);
            parcel.writeNoException();
            return true;
        }

        private static class a
        implements dp {
            private IBinder dU;

            a(IBinder iBinder) {
                this.dU = iBinder;
            }

            public IBinder asBinder() {
                return this.dU;
            }

            @Override
            public void b(int n2, IBinder iBinder, Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsCallbacks");
                    parcel.writeInt(n2);
                    parcel.writeStrongBinder(iBinder);
                    if (bundle != null) {
                        parcel.writeInt(1);
                        bundle.writeToParcel(parcel, 0);
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

