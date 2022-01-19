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
import com.google.android.gms.maps.internal.g;

public interface ILocationSourceDelegate
extends IInterface {
    public void activate(g var1) throws RemoteException;

    public void deactivate() throws RemoteException;

    public static abstract class com.google.android.gms.maps.internal.ILocationSourceDelegate$a
    extends Binder
    implements ILocationSourceDelegate {
        public com.google.android.gms.maps.internal.ILocationSourceDelegate$a() {
            this.attachInterface(this, "com.google.android.gms.maps.internal.ILocationSourceDelegate");
        }

        public static ILocationSourceDelegate Q(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.ILocationSourceDelegate");
            if (iInterface == null) return new a(iBinder);
            if (!(iInterface instanceof ILocationSourceDelegate)) return new a(iBinder);
            return (ILocationSourceDelegate)iInterface;
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
                    parcel2.writeString("com.google.android.gms.maps.internal.ILocationSourceDelegate");
                    return true;
                }
                case 1: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.ILocationSourceDelegate");
                    this.activate(g.a.V(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
                case 2: 
            }
            parcel.enforceInterface("com.google.android.gms.maps.internal.ILocationSourceDelegate");
            this.deactivate();
            parcel2.writeNoException();
            return true;
        }

        private static class a
        implements ILocationSourceDelegate {
            private IBinder dU;

            a(IBinder iBinder) {
                this.dU = iBinder;
            }

            @Override
            public void activate(g g2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ILocationSourceDelegate");
                    g2 = g2 != null ? g2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)g2);
                    this.dU.transact(1, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            public IBinder asBinder() {
                return this.dU;
            }

            @Override
            public void deactivate() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ILocationSourceDelegate");
                    this.dU.transact(2, parcel, parcel2, 0);
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

