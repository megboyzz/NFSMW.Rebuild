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
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.MaskedWallet;

public interface hn
extends IInterface {
    public void a(int var1, FullWallet var2, Bundle var3) throws RemoteException;

    public void a(int var1, MaskedWallet var2, Bundle var3) throws RemoteException;

    public void a(int var1, boolean var2, Bundle var3) throws RemoteException;

    public static abstract class com.google.android.gms.internal.hn$a
    extends Binder
    implements hn {
        public com.google.android.gms.internal.hn$a() {
            this.attachInterface(this, "com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
        }

        public static hn ax(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
            if (iInterface == null) return new a(iBinder);
            if (!(iInterface instanceof hn)) return new a(iBinder);
            return (hn)iInterface;
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
                    parcel.writeString("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
                    return true;
                }
                case 1: {
                    object.enforceInterface("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
                    n2 = object.readInt();
                    MaskedWallet maskedWallet = object.readInt() != 0 ? (MaskedWallet)MaskedWallet.CREATOR.createFromParcel(object) : null;
                    object = object.readInt() != 0 ? (Bundle)Bundle.CREATOR.createFromParcel(object) : null;
                    this.a(n2, maskedWallet, (Bundle)object);
                    parcel.writeNoException();
                    return true;
                }
                case 2: {
                    object.enforceInterface("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
                    n2 = object.readInt();
                    FullWallet fullWallet = object.readInt() != 0 ? (FullWallet)FullWallet.CREATOR.createFromParcel(object) : null;
                    object = object.readInt() != 0 ? (Bundle)Bundle.CREATOR.createFromParcel(object) : null;
                    this.a(n2, fullWallet, (Bundle)object);
                    parcel.writeNoException();
                    return true;
                }
                case 3: 
            }
            object.enforceInterface("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
            n2 = object.readInt();
            boolean bl2 = object.readInt() != 0;
            object = object.readInt() != 0 ? (Bundle)Bundle.CREATOR.createFromParcel(object) : null;
            this.a(n2, bl2, (Bundle)object);
            parcel.writeNoException();
            return true;
        }

        private static class a
        implements hn {
            private IBinder dU;

            a(IBinder iBinder) {
                this.dU = iBinder;
            }

            /*
             * Enabled unnecessary exception pruning
             */
            @Override
            public void a(int n2, FullWallet fullWallet, Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
                    parcel.writeInt(n2);
                    if (fullWallet != null) {
                        parcel.writeInt(1);
                        fullWallet.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    if (bundle != null) {
                        parcel.writeInt(1);
                        bundle.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(2, parcel, parcel2, 0);
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
            public void a(int n2, MaskedWallet maskedWallet, Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
                    parcel.writeInt(n2);
                    if (maskedWallet != null) {
                        parcel.writeInt(1);
                        maskedWallet.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
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

            /*
             * Enabled unnecessary exception pruning
             */
            @Override
            public void a(int n2, boolean bl2, Bundle bundle) throws RemoteException {
                int n3 = 1;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
                    parcel.writeInt(n2);
                    n2 = bl2 ? n3 : 0;
                    parcel.writeInt(n2);
                    if (bundle != null) {
                        parcel.writeInt(1);
                        bundle.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(3, parcel, parcel2, 0);
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
        }
    }
}

