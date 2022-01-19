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
import com.google.android.gms.internal.bd;
import com.google.android.gms.internal.v;
import com.google.android.gms.internal.x;

public interface bc
extends IInterface {
    public void a(b var1, v var2, String var3, bd var4) throws RemoteException;

    public void a(b var1, v var2, String var3, String var4, bd var5) throws RemoteException;

    public void a(b var1, x var2, v var3, String var4, bd var5) throws RemoteException;

    public void a(b var1, x var2, v var3, String var4, String var5, bd var6) throws RemoteException;

    public void destroy() throws RemoteException;

    public b getView() throws RemoteException;

    public void showInterstitial() throws RemoteException;

    public static abstract class com.google.android.gms.internal.bc$a
    extends Binder
    implements bc {
        public com.google.android.gms.internal.bc$a() {
            this.attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        }

        public static bc j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            if (iInterface == null) return new a(iBinder);
            if (!(iInterface instanceof bc)) return new a(iBinder);
            return (bc)iInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int n2, Parcel object, Parcel parcel, int n3) throws RemoteException {
            Object object2 = null;
            Object object3 = null;
            switch (n2) {
                default: {
                    return super.onTransact(n2, object, parcel, n3);
                }
                case 1598968902: {
                    parcel.writeString("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    return true;
                }
                case 1: {
                    object.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    b b2 = b.a.C(object.readStrongBinder());
                    object3 = object.readInt() != 0 ? x.CREATOR.b((Parcel)object) : null;
                    object2 = object.readInt() != 0 ? v.CREATOR.a((Parcel)object) : null;
                    this.a(b2, (x)object3, (v)object2, object.readString(), bd.a.k(object.readStrongBinder()));
                    parcel.writeNoException();
                    return true;
                }
                case 2: {
                    object.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    object2 = this.getView();
                    parcel.writeNoException();
                    object = object3;
                    if (object2 != null) {
                        object = object2.asBinder();
                    }
                    parcel.writeStrongBinder((IBinder)object);
                    return true;
                }
                case 3: {
                    object.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    b b3 = b.a.C(object.readStrongBinder());
                    object3 = object2;
                    if (object.readInt() != 0) {
                        object3 = v.CREATOR.a((Parcel)object);
                    }
                    this.a(b3, (v)object3, object.readString(), bd.a.k(object.readStrongBinder()));
                    parcel.writeNoException();
                    return true;
                }
                case 4: {
                    object.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.showInterstitial();
                    parcel.writeNoException();
                    return true;
                }
                case 5: {
                    object.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.destroy();
                    parcel.writeNoException();
                    return true;
                }
                case 6: {
                    object.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    b b4 = b.a.C(object.readStrongBinder());
                    object3 = object.readInt() != 0 ? x.CREATOR.b((Parcel)object) : null;
                    object2 = object.readInt() != 0 ? v.CREATOR.a((Parcel)object) : null;
                    this.a(b4, (x)object3, (v)object2, object.readString(), object.readString(), bd.a.k(object.readStrongBinder()));
                    parcel.writeNoException();
                    return true;
                }
                case 7: 
            }
            object.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            object2 = b.a.C(object.readStrongBinder());
            object3 = object.readInt() != 0 ? v.CREATOR.a((Parcel)object) : null;
            this.a((b)object2, (v)object3, object.readString(), object.readString(), bd.a.k(object.readStrongBinder()));
            parcel.writeNoException();
            return true;
        }

        private static class a
        implements bc {
            private IBinder dU;

            a(IBinder iBinder) {
                this.dU = iBinder;
            }

            /*
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public void a(b b2, v v2, String string2, bd bd2) throws RemoteException {
                Object var5_13 = null;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    void var1_6;
                    void var4_12;
                    void var3_11;
                    void var2_10;
                    void var1_3;
                    parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    if (b2 != null) {
                        IBinder iBinder = b2.asBinder();
                    } else {
                        Object var1_7 = null;
                    }
                    parcel.writeStrongBinder((IBinder)var1_3);
                    if (var2_10 != null) {
                        parcel.writeInt(1);
                        var2_10.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    parcel.writeString((String)var3_11);
                    Object var1_4 = var5_13;
                    if (var4_12 != null) {
                        IBinder iBinder = var4_12.asBinder();
                    }
                    parcel.writeStrongBinder((IBinder)var1_6);
                    this.dU.transact(3, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            /*
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public void a(b b2, v v2, String string2, String string3, bd bd2) throws RemoteException {
                Object var6_14 = null;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    void var1_6;
                    void var5_13;
                    void var4_12;
                    void var3_11;
                    void var2_10;
                    void var1_3;
                    parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    if (b2 != null) {
                        IBinder iBinder = b2.asBinder();
                    } else {
                        Object var1_7 = null;
                    }
                    parcel.writeStrongBinder((IBinder)var1_3);
                    if (var2_10 != null) {
                        parcel.writeInt(1);
                        var2_10.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    parcel.writeString((String)var3_11);
                    parcel.writeString((String)var4_12);
                    Object var1_4 = var6_14;
                    if (var5_13 != null) {
                        IBinder iBinder = var5_13.asBinder();
                    }
                    parcel.writeStrongBinder((IBinder)var1_6);
                    this.dU.transact(7, parcel, parcel2, 0);
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
            public void a(b b2, x x2, v v2, String string2, bd bd2) throws RemoteException {
                Object var6_7 = null;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    b2 = b2 != null ? b2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)b2);
                    if (x2 != null) {
                        parcel.writeInt(1);
                        x2.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    if (v2 != null) {
                        parcel.writeInt(1);
                        v2.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    parcel.writeString(string2);
                    b2 = var6_7;
                    if (bd2 != null) {
                        b2 = bd2.asBinder();
                    }
                    parcel.writeStrongBinder((IBinder)b2);
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
            public void a(b b2, x x2, v v2, String string2, String string3, bd bd2) throws RemoteException {
                Object var7_8 = null;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    b2 = b2 != null ? b2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)b2);
                    if (x2 != null) {
                        parcel.writeInt(1);
                        x2.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    if (v2 != null) {
                        parcel.writeInt(1);
                        v2.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    parcel.writeString(string2);
                    parcel.writeString(string3);
                    b2 = var7_8;
                    if (bd2 != null) {
                        b2 = bd2.asBinder();
                    }
                    parcel.writeStrongBinder((IBinder)b2);
                    this.dU.transact(6, parcel, parcel2, 0);
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
            public void destroy() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
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
            public b getView() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.dU.transact(2, parcel, parcel2, 0);
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
            public void showInterstitial() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.dU.transact(4, parcel, parcel2, 0);
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

