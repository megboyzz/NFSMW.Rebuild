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
import com.google.android.gms.internal.dc;

public interface dd
extends IInterface {
    public void a(dc var1) throws RemoteException;

    public void a(dc var1, int var2) throws RemoteException;

    public void a(dc var1, int var2, String var3, byte[] var4) throws RemoteException;

    public void a(dc var1, int var2, byte[] var3) throws RemoteException;

    public void b(dc var1) throws RemoteException;

    public void b(dc var1, int var2) throws RemoteException;

    public void c(dc var1) throws RemoteException;

    public int getMaxNumKeys() throws RemoteException;

    public int getMaxStateSize() throws RemoteException;

    public static abstract class com.google.android.gms.internal.dd$a
    extends Binder
    implements dd {
        public static dd t(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.appstate.internal.IAppStateService");
            if (iInterface == null) return new a(iBinder);
            if (!(iInterface instanceof dd)) return new a(iBinder);
            return (dd)iInterface;
        }

        public boolean onTransact(int n2, Parcel parcel, Parcel parcel2, int n3) throws RemoteException {
            switch (n2) {
                default: {
                    return super.onTransact(n2, parcel, parcel2, n3);
                }
                case 1598968902: {
                    parcel2.writeString("com.google.android.gms.appstate.internal.IAppStateService");
                    return true;
                }
                case 5001: {
                    parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    n2 = this.getMaxStateSize();
                    parcel2.writeNoException();
                    parcel2.writeInt(n2);
                    return true;
                }
                case 5002: {
                    parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    n2 = this.getMaxNumKeys();
                    parcel2.writeNoException();
                    parcel2.writeInt(n2);
                    return true;
                }
                case 5003: {
                    parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    this.a(dc.a.s(parcel.readStrongBinder()), parcel.readInt(), parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                }
                case 5004: {
                    parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    this.a(dc.a.s(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                }
                case 5005: {
                    parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    this.a(dc.a.s(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
                case 5006: {
                    parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    this.a(dc.a.s(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                }
                case 5007: {
                    parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    this.b(dc.a.s(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                }
                case 5008: {
                    parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    this.b(dc.a.s(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
                case 5009: 
            }
            parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
            this.c(dc.a.s(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }

        private static class a
        implements dd {
            private IBinder dU;

            a(IBinder iBinder) {
                this.dU = iBinder;
            }

            @Override
            public void a(dc dc2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    dc2 = dc2 != null ? dc2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)dc2);
                    this.dU.transact(5005, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void a(dc dc2, int n2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    dc2 = dc2 != null ? dc2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)dc2);
                    parcel.writeInt(n2);
                    this.dU.transact(5004, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void a(dc dc2, int n2, String string2, byte[] byArray) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    dc2 = dc2 != null ? dc2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)dc2);
                    parcel.writeInt(n2);
                    parcel.writeString(string2);
                    parcel.writeByteArray(byArray);
                    this.dU.transact(5006, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void a(dc dc2, int n2, byte[] byArray) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    dc2 = dc2 != null ? dc2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)dc2);
                    parcel.writeInt(n2);
                    parcel.writeByteArray(byArray);
                    this.dU.transact(5003, parcel, parcel2, 0);
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
            public void b(dc dc2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    dc2 = dc2 != null ? dc2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)dc2);
                    this.dU.transact(5008, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void b(dc dc2, int n2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    dc2 = dc2 != null ? dc2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)dc2);
                    parcel.writeInt(n2);
                    this.dU.transact(5007, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void c(dc dc2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    dc2 = dc2 != null ? dc2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)dc2);
                    this.dU.transact(5009, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public int getMaxNumKeys() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    this.dU.transact(5002, parcel, parcel2, 0);
                    parcel2.readException();
                    int n2 = parcel2.readInt();
                    return n2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public int getMaxStateSize() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    this.dU.transact(5001, parcel, parcel2, 0);
                    parcel2.readException();
                    int n2 = parcel2.readInt();
                    return n2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }
        }
    }
}

