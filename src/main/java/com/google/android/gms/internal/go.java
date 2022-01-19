/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.os.Binder
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 */
package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface go
extends IInterface {
    public void cancelClick() throws RemoteException;

    public PendingIntent getResolution() throws RemoteException;

    public void reinitialize() throws RemoteException;

    public static abstract class com.google.android.gms.internal.go$a
    extends Binder
    implements go {
        public static go at(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.plus.internal.IPlusOneDelegate");
            if (iInterface == null) return new a(iBinder);
            if (!(iInterface instanceof go)) return new a(iBinder);
            return (go)iInterface;
        }

        public boolean onTransact(int n2, Parcel parcel, Parcel parcel2, int n3) throws RemoteException {
            switch (n2) {
                default: {
                    return super.onTransact(n2, parcel, parcel2, n3);
                }
                case 1598968902: {
                    parcel2.writeString("com.google.android.gms.plus.internal.IPlusOneDelegate");
                    return true;
                }
                case 1: {
                    parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusOneDelegate");
                    parcel = this.getResolution();
                    parcel2.writeNoException();
                    if (parcel != null) {
                        parcel2.writeInt(1);
                        parcel.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                }
                case 2: {
                    parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusOneDelegate");
                    this.cancelClick();
                    parcel2.writeNoException();
                    return true;
                }
                case 3: 
            }
            parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusOneDelegate");
            this.reinitialize();
            parcel2.writeNoException();
            return true;
        }

        private static class a
        implements go {
            private IBinder dU;

            a(IBinder iBinder) {
                this.dU = iBinder;
            }

            public IBinder asBinder() {
                return this.dU;
            }

            @Override
            public void cancelClick() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusOneDelegate");
                    this.dU.transact(2, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public PendingIntent getResolution() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusOneDelegate");
                    this.dU.transact(1, parcel, parcel2, 0);
                    parcel2.readException();
                    PendingIntent pendingIntent = parcel2.readInt() != 0 ? (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel2) : null;
                    return pendingIntent;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void reinitialize() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusOneDelegate");
                    this.dU.transact(3, parcel, parcel2, 0);
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

