/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Binder
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.ParcelFileDescriptor
 *  android.os.RemoteException
 */
package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ek;
import com.google.android.gms.internal.ha;

public interface gm
extends IInterface {
    public void a(int var1, Bundle var2, Bundle var3) throws RemoteException;

    public void a(int var1, Bundle var2, ParcelFileDescriptor var3) throws RemoteException;

    public void a(int var1, Bundle var2, ek var3) throws RemoteException;

    public void a(int var1, ha var2) throws RemoteException;

    public void a(DataHolder var1, String var2) throws RemoteException;

    public void a(DataHolder var1, String var2, String var3) throws RemoteException;

    public void ah(String var1) throws RemoteException;

    public void ai(String var1) throws RemoteException;

    public void b(int var1, Bundle var2) throws RemoteException;

    public static abstract class com.google.android.gms.internal.gm$a
    extends Binder
    implements gm {
        public com.google.android.gms.internal.gm$a() {
            this.attachInterface(this, "com.google.android.gms.plus.internal.IPlusCallbacks");
        }

        public static gm ar(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
            if (iInterface == null) return new a(iBinder);
            if (!(iInterface instanceof gm)) return new a(iBinder);
            return (gm)iInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int n2, Parcel object, Parcel parcel, int n3) throws RemoteException {
            ek ek2 = null;
            DataHolder dataHolder = null;
            DataHolder dataHolder2 = null;
            SafeParcelable safeParcelable = null;
            switch (n2) {
                default: {
                    return super.onTransact(n2, object, parcel, n3);
                }
                case 1598968902: {
                    parcel.writeString("com.google.android.gms.plus.internal.IPlusCallbacks");
                    return true;
                }
                case 1: {
                    object.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
                    n2 = object.readInt();
                    safeParcelable = object.readInt() != 0 ? (Bundle)Bundle.CREATOR.createFromParcel(object) : null;
                    object = object.readInt() != 0 ? (Bundle)Bundle.CREATOR.createFromParcel(object) : null;
                    this.a(n2, (Bundle)safeParcelable, (Bundle)object);
                    parcel.writeNoException();
                    return true;
                }
                case 2: {
                    object.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
                    n2 = object.readInt();
                    safeParcelable = object.readInt() != 0 ? (Bundle)Bundle.CREATOR.createFromParcel(object) : null;
                    object = object.readInt() != 0 ? (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(object) : null;
                    this.a(n2, (Bundle)safeParcelable, (ParcelFileDescriptor)object);
                    parcel.writeNoException();
                    return true;
                }
                case 3: {
                    object.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
                    this.ah(object.readString());
                    parcel.writeNoException();
                    return true;
                }
                case 4: {
                    object.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
                    if (object.readInt() != 0) {
                        safeParcelable = DataHolder.CREATOR.createFromParcel((Parcel)object);
                    }
                    this.a((DataHolder)safeParcelable, object.readString());
                    parcel.writeNoException();
                    return true;
                }
                case 5: {
                    object.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
                    n2 = object.readInt();
                    safeParcelable = object.readInt() != 0 ? (Bundle)Bundle.CREATOR.createFromParcel(object) : null;
                    if (object.readInt() != 0) {
                        ek2 = ek.CREATOR.t((Parcel)object);
                    }
                    this.a(n2, (Bundle)safeParcelable, ek2);
                    parcel.writeNoException();
                    return true;
                }
                case 6: {
                    object.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
                    safeParcelable = dataHolder;
                    if (object.readInt() != 0) {
                        safeParcelable = DataHolder.CREATOR.createFromParcel((Parcel)object);
                    }
                    this.a((DataHolder)safeParcelable, object.readString(), object.readString());
                    parcel.writeNoException();
                    return true;
                }
                case 7: {
                    object.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
                    n2 = object.readInt();
                    object = object.readInt() != 0 ? (Bundle)Bundle.CREATOR.createFromParcel(object) : null;
                    this.b(n2, (Bundle)object);
                    parcel.writeNoException();
                    return true;
                }
                case 8: {
                    object.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
                    this.ai(object.readString());
                    parcel.writeNoException();
                    return true;
                }
                case 9: 
            }
            object.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
            n2 = object.readInt();
            safeParcelable = dataHolder2;
            if (object.readInt() != 0) {
                safeParcelable = ha.CREATOR.al((Parcel)object);
            }
            this.a(n2, (ha)safeParcelable);
            parcel.writeNoException();
            return true;
        }

        private static class a
        implements gm {
            private IBinder dU;

            a(IBinder iBinder) {
                this.dU = iBinder;
            }

            /*
             * Enabled unnecessary exception pruning
             */
            @Override
            public void a(int n2, Bundle bundle, Bundle bundle2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusCallbacks");
                    parcel.writeInt(n2);
                    if (bundle != null) {
                        parcel.writeInt(1);
                        bundle.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    if (bundle2 != null) {
                        parcel.writeInt(1);
                        bundle2.writeToParcel(parcel, 0);
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
            public void a(int n2, Bundle bundle, ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusCallbacks");
                    parcel.writeInt(n2);
                    if (bundle != null) {
                        parcel.writeInt(1);
                        bundle.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    if (parcelFileDescriptor != null) {
                        parcel.writeInt(1);
                        parcelFileDescriptor.writeToParcel(parcel, 0);
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
            public void a(int n2, Bundle bundle, ek ek2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusCallbacks");
                    parcel.writeInt(n2);
                    if (bundle != null) {
                        parcel.writeInt(1);
                        bundle.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    if (ek2 != null) {
                        parcel.writeInt(1);
                        ek2.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
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
            public void a(int n2, ha ha2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusCallbacks");
                    parcel.writeInt(n2);
                    if (ha2 != null) {
                        parcel.writeInt(1);
                        ha2.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
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
            public void a(DataHolder dataHolder, String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusCallbacks");
                    if (dataHolder != null) {
                        parcel.writeInt(1);
                        dataHolder.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    parcel.writeString(string2);
                    this.dU.transact(4, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void a(DataHolder dataHolder, String string2, String string3) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusCallbacks");
                    if (dataHolder != null) {
                        parcel.writeInt(1);
                        dataHolder.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    parcel.writeString(string2);
                    parcel.writeString(string3);
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
            public void ah(String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusCallbacks");
                    parcel.writeString(string2);
                    this.dU.transact(3, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void ai(String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusCallbacks");
                    parcel.writeString(string2);
                    this.dU.transact(8, parcel, parcel2, 0);
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
            public void b(int n2, Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusCallbacks");
                    parcel.writeInt(n2);
                    if (bundle != null) {
                        parcel.writeInt(1);
                        bundle.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(7, parcel, parcel2, 0);
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

