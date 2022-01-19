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
import com.google.android.gms.dynamic.b;
import com.google.android.gms.internal.ab;
import com.google.android.gms.internal.ae;
import com.google.android.gms.internal.v;
import com.google.android.gms.internal.x;

public interface ac
extends IInterface {
    public void H() throws RemoteException;

    public void a(ab var1) throws RemoteException;

    public void a(ae var1) throws RemoteException;

    public void a(x var1) throws RemoteException;

    public boolean a(v var1) throws RemoteException;

    public void destroy() throws RemoteException;

    public boolean isReady() throws RemoteException;

    public void pause() throws RemoteException;

    public void resume() throws RemoteException;

    public void showInterstitial() throws RemoteException;

    public void stopLoading() throws RemoteException;

    public b x() throws RemoteException;

    public x y() throws RemoteException;

    public static abstract class com.google.android.gms.internal.ac$a
    extends Binder
    implements ac {
        public com.google.android.gms.internal.ac$a() {
            this.attachInterface(this, "com.google.android.gms.ads.internal.client.IAdManager");
        }

        public static ac f(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (iInterface == null) return new a(iBinder);
            if (!(iInterface instanceof ac)) return new a(iBinder);
            return (ac)iInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int n2, Parcel object, Parcel parcel, int n3) throws RemoteException {
            b b2 = null;
            b b3 = null;
            Object object2 = null;
            int n4 = 0;
            switch (n2) {
                default: {
                    return super.onTransact(n2, (Parcel)object, parcel, n3);
                }
                case 1598968902: {
                    parcel.writeString("com.google.android.gms.ads.internal.client.IAdManager");
                    return true;
                }
                case 1: {
                    object.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    b2 = this.x();
                    parcel.writeNoException();
                    object = object2;
                    if (b2 != null) {
                        object = b2.asBinder();
                    }
                    parcel.writeStrongBinder((IBinder)object);
                    return true;
                }
                case 2: {
                    object.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    this.destroy();
                    parcel.writeNoException();
                    return true;
                }
                case 3: {
                    object.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    boolean bl2 = this.isReady();
                    parcel.writeNoException();
                    n2 = bl2 ? 1 : 0;
                    parcel.writeInt(n2);
                    return true;
                }
                case 4: {
                    object.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    object2 = b2;
                    if (object.readInt() != 0) {
                        object2 = v.CREATOR.a((Parcel)object);
                    }
                    boolean bl3 = this.a((v)object2);
                    parcel.writeNoException();
                    n2 = n4;
                    if (bl3) {
                        n2 = 1;
                    }
                    parcel.writeInt(n2);
                    return true;
                }
                case 5: {
                    object.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    this.pause();
                    parcel.writeNoException();
                    return true;
                }
                case 6: {
                    object.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    this.resume();
                    parcel.writeNoException();
                    return true;
                }
                case 7: {
                    object.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    this.a(ab.a.e(object.readStrongBinder()));
                    parcel.writeNoException();
                    return true;
                }
                case 8: {
                    object.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    this.a(ae.a.h(object.readStrongBinder()));
                    parcel.writeNoException();
                    return true;
                }
                case 9: {
                    object.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    this.showInterstitial();
                    parcel.writeNoException();
                    return true;
                }
                case 10: {
                    object.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    this.stopLoading();
                    parcel.writeNoException();
                    return true;
                }
                case 11: {
                    object.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    this.H();
                    parcel.writeNoException();
                    return true;
                }
                case 12: {
                    object.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    object = this.y();
                    parcel.writeNoException();
                    if (object != null) {
                        parcel.writeInt(1);
                        ((x)object).writeToParcel(parcel, 1);
                        return true;
                    }
                    parcel.writeInt(0);
                    return true;
                }
                case 13: 
            }
            object.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            object2 = b3;
            if (object.readInt() != 0) {
                object2 = x.CREATOR.b((Parcel)object);
            }
            this.a((x)object2);
            parcel.writeNoException();
            return true;
        }

        private static class a
        implements ac {
            private IBinder dU;

            a(IBinder iBinder) {
                this.dU = iBinder;
            }

            @Override
            public void H() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.dU.transact(11, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void a(ab ab2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    ab2 = ab2 != null ? ab2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)ab2);
                    this.dU.transact(7, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void a(ae ae2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    ae2 = ae2 != null ? ae2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)ae2);
                    this.dU.transact(8, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void a(x x2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    if (x2 != null) {
                        parcel.writeInt(1);
                        x2.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(13, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            /*
             * Enabled unnecessary exception pruning
             */
            @Override
            public boolean a(v v2) throws RemoteException {
                Parcel parcel;
                Parcel parcel2;
                boolean bl2;
                block6: {
                    block5: {
                        bl2 = true;
                        parcel2 = Parcel.obtain();
                        parcel = Parcel.obtain();
                        try {
                            parcel2.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                            if (v2 != null) {
                                parcel2.writeInt(1);
                                v2.writeToParcel(parcel2, 0);
                            } else {
                                parcel2.writeInt(0);
                            }
                            this.dU.transact(4, parcel2, parcel, 0);
                            parcel.readException();
                            int n2 = parcel.readInt();
                            if (n2 == 0) break block5;
                            break block6;
                        }
                        catch (Throwable throwable) {
                            parcel.recycle();
                            parcel2.recycle();
                            throw throwable;
                        }
                    }
                    bl2 = false;
                }
                parcel.recycle();
                parcel2.recycle();
                return bl2;
            }

            public IBinder asBinder() {
                return this.dU;
            }

            @Override
            public void destroy() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
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
            public boolean isReady() throws RemoteException {
                boolean bl2 = false;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.dU.transact(3, parcel, parcel2, 0);
                    parcel2.readException();
                    int n2 = parcel2.readInt();
                    if (n2 == 0) return bl2;
                    bl2 = true;
                    return bl2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void pause() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.dU.transact(5, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void resume() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.dU.transact(6, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void showInterstitial() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.dU.transact(9, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void stopLoading() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.dU.transact(10, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public b x() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.dU.transact(1, parcel, parcel2, 0);
                    parcel2.readException();
                    b b2 = b.a.C(parcel2.readStrongBinder());
                    return b2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public x y() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.dU.transact(12, parcel, parcel2, 0);
                    parcel2.readException();
                    x x2 = parcel2.readInt() != 0 ? x.CREATOR.b(parcel2) : null;
                    return x2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }
        }
    }
}

