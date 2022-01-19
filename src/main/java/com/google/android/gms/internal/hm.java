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
import com.google.android.gms.internal.hn;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;

public interface hm
extends IInterface {
    public void a(Bundle var1, hn var2) throws RemoteException;

    public void a(FullWalletRequest var1, Bundle var2, hn var3) throws RemoteException;

    public void a(MaskedWalletRequest var1, Bundle var2, hn var3) throws RemoteException;

    public void a(NotifyTransactionStatusRequest var1, Bundle var2) throws RemoteException;

    public void a(String var1, String var2, Bundle var3, hn var4) throws RemoteException;

    public static abstract class com.google.android.gms.internal.hm$a
    extends Binder
    implements hm {
        public static hm aw(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.wallet.internal.IOwService");
            if (iInterface == null) return new a(iBinder);
            if (!(iInterface instanceof hm)) return new a(iBinder);
            return (hm)iInterface;
        }

        public boolean onTransact(int n2, Parcel object, Parcel object2, int n3) throws RemoteException {
            switch (n2) {
                default: {
                    return super.onTransact(n2, object, object2, n3);
                }
                case 1598968902: {
                    object2.writeString("com.google.android.gms.wallet.internal.IOwService");
                    return true;
                }
                case 1: {
                    object.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    object2 = object.readInt() != 0 ? (MaskedWalletRequest)MaskedWalletRequest.CREATOR.createFromParcel(object) : null;
                    Bundle bundle = object.readInt() != 0 ? (Bundle)Bundle.CREATOR.createFromParcel(object) : null;
                    this.a((MaskedWalletRequest)object2, bundle, hn.a.ax(object.readStrongBinder()));
                    return true;
                }
                case 2: {
                    object.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    object2 = object.readInt() != 0 ? (FullWalletRequest)FullWalletRequest.CREATOR.createFromParcel(object) : null;
                    Bundle bundle = object.readInt() != 0 ? (Bundle)Bundle.CREATOR.createFromParcel(object) : null;
                    this.a((FullWalletRequest)object2, bundle, hn.a.ax(object.readStrongBinder()));
                    return true;
                }
                case 3: {
                    object.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    String string2 = object.readString();
                    String string3 = object.readString();
                    object2 = object.readInt() != 0 ? (Bundle)Bundle.CREATOR.createFromParcel(object) : null;
                    this.a(string2, string3, (Bundle)object2, hn.a.ax(object.readStrongBinder()));
                    return true;
                }
                case 4: {
                    object.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    object2 = object.readInt() != 0 ? (NotifyTransactionStatusRequest)NotifyTransactionStatusRequest.CREATOR.createFromParcel(object) : null;
                    object = object.readInt() != 0 ? (Bundle)Bundle.CREATOR.createFromParcel(object) : null;
                    this.a((NotifyTransactionStatusRequest)object2, (Bundle)object);
                    return true;
                }
                case 5: 
            }
            object.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
            object2 = object.readInt() != 0 ? (Bundle)Bundle.CREATOR.createFromParcel(object) : null;
            this.a((Bundle)object2, hn.a.ax(object.readStrongBinder()));
            return true;
        }

        private static class a
        implements hm {
            private IBinder dU;

            a(IBinder iBinder) {
                this.dU = iBinder;
            }

            @Override
            public void a(Bundle bundle, hn hn2) throws RemoteException {
                Object var3_4 = null;
                Parcel parcel = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (bundle != null) {
                        parcel.writeInt(1);
                        bundle.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    bundle = var3_4;
                    if (hn2 != null) {
                        bundle = hn2.asBinder();
                    }
                    parcel.writeStrongBinder((IBinder)bundle);
                    this.dU.transact(5, parcel, null, 1);
                    return;
                }
                finally {
                    parcel.recycle();
                }
            }

            /*
             * Enabled unnecessary exception pruning
             */
            @Override
            public void a(FullWalletRequest fullWalletRequest, Bundle bundle, hn hn2) throws RemoteException {
                Object var4_5 = null;
                Parcel parcel = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (fullWalletRequest != null) {
                        parcel.writeInt(1);
                        fullWalletRequest.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    if (bundle != null) {
                        parcel.writeInt(1);
                        bundle.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    fullWalletRequest = var4_5;
                    if (hn2 != null) {
                        fullWalletRequest = hn2.asBinder();
                    }
                    parcel.writeStrongBinder((IBinder)fullWalletRequest);
                    this.dU.transact(2, parcel, null, 1);
                    return;
                }
                finally {
                    parcel.recycle();
                }
            }

            /*
             * Enabled unnecessary exception pruning
             */
            @Override
            public void a(MaskedWalletRequest maskedWalletRequest, Bundle bundle, hn hn2) throws RemoteException {
                Object var4_5 = null;
                Parcel parcel = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (maskedWalletRequest != null) {
                        parcel.writeInt(1);
                        maskedWalletRequest.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    if (bundle != null) {
                        parcel.writeInt(1);
                        bundle.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    maskedWalletRequest = var4_5;
                    if (hn2 != null) {
                        maskedWalletRequest = hn2.asBinder();
                    }
                    parcel.writeStrongBinder((IBinder)maskedWalletRequest);
                    this.dU.transact(1, parcel, null, 1);
                    return;
                }
                finally {
                    parcel.recycle();
                }
            }

            /*
             * Enabled unnecessary exception pruning
             */
            @Override
            public void a(NotifyTransactionStatusRequest notifyTransactionStatusRequest, Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (notifyTransactionStatusRequest != null) {
                        parcel.writeInt(1);
                        notifyTransactionStatusRequest.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    if (bundle != null) {
                        parcel.writeInt(1);
                        bundle.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(4, parcel, null, 1);
                    return;
                }
                finally {
                    parcel.recycle();
                }
            }

            @Override
            public void a(String string2, String string3, Bundle bundle, hn hn2) throws RemoteException {
                Object var5_6 = null;
                Parcel parcel = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    parcel.writeString(string2);
                    parcel.writeString(string3);
                    if (bundle != null) {
                        parcel.writeInt(1);
                        bundle.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    string2 = var5_6;
                    if (hn2 != null) {
                        string2 = hn2.asBinder();
                    }
                    parcel.writeStrongBinder((IBinder)string2);
                    this.dU.transact(3, parcel, null, 1);
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

