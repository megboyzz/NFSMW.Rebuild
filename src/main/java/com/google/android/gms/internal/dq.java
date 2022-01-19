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
import com.google.android.gms.internal.dp;

public interface dq
extends IInterface {
    public void a(dp var1, int var2) throws RemoteException;

    public void a(dp var1, int var2, String var3) throws RemoteException;

    public void a(dp var1, int var2, String var3, Bundle var4) throws RemoteException;

    public void a(dp var1, int var2, String var3, IBinder var4, Bundle var5) throws RemoteException;

    public void a(dp var1, int var2, String var3, String var4, String[] var5) throws RemoteException;

    public void a(dp var1, int var2, String var3, String var4, String[] var5, String var6, Bundle var7) throws RemoteException;

    public void a(dp var1, int var2, String var3, String var4, String[] var5, String var6, IBinder var7, String var8, Bundle var9) throws RemoteException;

    public void a(dp var1, int var2, String var3, String[] var4, String var5, Bundle var6) throws RemoteException;

    public void b(dp var1, int var2, String var3, Bundle var4) throws RemoteException;

    public void c(dp var1, int var2, String var3, Bundle var4) throws RemoteException;

    public void d(dp var1, int var2, String var3, Bundle var4) throws RemoteException;

    public void e(dp var1, int var2, String var3, Bundle var4) throws RemoteException;

    public void f(dp var1, int var2, String var3, Bundle var4) throws RemoteException;

    public void g(dp var1, int var2, String var3, Bundle var4) throws RemoteException;

    public void h(dp var1, int var2, String var3, Bundle var4) throws RemoteException;

    public void i(dp var1, int var2, String var3, Bundle var4) throws RemoteException;

    public void j(dp var1, int var2, String var3, Bundle var4) throws RemoteException;

    public void k(dp var1, int var2, String var3, Bundle var4) throws RemoteException;

    public void l(dp var1, int var2, String var3, Bundle var4) throws RemoteException;

    public void m(dp var1, int var2, String var3, Bundle var4) throws RemoteException;

    public static abstract class com.google.android.gms.internal.dq$a
    extends Binder
    implements dq {
        public static dq w(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (iInterface == null) return new a(iBinder);
            if (!(iInterface instanceof dq)) return new a(iBinder);
            return (dq)iInterface;
        }

        public boolean onTransact(int n2, Parcel object, Parcel parcel, int n3) throws RemoteException {
            Object object2 = null;
            String[] stringArray = null;
            String[] stringArray2 = null;
            String string2 = null;
            IBinder iBinder = null;
            String string3 = null;
            Object var12_11 = null;
            Object var13_12 = null;
            Object var14_13 = null;
            Object var15_14 = null;
            Object var16_15 = null;
            Object var17_16 = null;
            Object object3 = null;
            switch (n2) {
                default: {
                    return super.onTransact(n2, object, parcel, n3);
                }
                case 1598968902: {
                    parcel.writeString("com.google.android.gms.common.internal.IGmsServiceBroker");
                    return true;
                }
                case 1: {
                    object.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    object3 = dp.a.v(object.readStrongBinder());
                    n2 = object.readInt();
                    object2 = object.readString();
                    stringArray = object.readString();
                    stringArray2 = object.createStringArray();
                    string2 = object.readString();
                    object = object.readInt() != 0 ? (Bundle)Bundle.CREATOR.createFromParcel(object) : null;
                    this.a((dp)object3, n2, (String)object2, (String)stringArray, stringArray2, string2, (Bundle)object);
                    parcel.writeNoException();
                    return true;
                }
                case 2: {
                    object.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    object2 = dp.a.v(object.readStrongBinder());
                    n2 = object.readInt();
                    stringArray = object.readString();
                    if (object.readInt() != 0) {
                        object3 = (Bundle)Bundle.CREATOR.createFromParcel(object);
                    }
                    this.a((dp)object2, n2, (String)stringArray, (Bundle)object3);
                    parcel.writeNoException();
                    return true;
                }
                case 3: {
                    object.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    this.a(dp.a.v(object.readStrongBinder()), object.readInt(), object.readString());
                    parcel.writeNoException();
                    return true;
                }
                case 4: {
                    object.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    this.a(dp.a.v(object.readStrongBinder()), object.readInt());
                    parcel.writeNoException();
                    return true;
                }
                case 5: {
                    object.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    stringArray = dp.a.v(object.readStrongBinder());
                    n2 = object.readInt();
                    stringArray2 = object.readString();
                    object3 = object2;
                    if (object.readInt() != 0) {
                        object3 = (Bundle)Bundle.CREATOR.createFromParcel(object);
                    }
                    this.b((dp)stringArray, n2, (String)stringArray2, (Bundle)object3);
                    parcel.writeNoException();
                    return true;
                }
                case 6: {
                    object.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    object2 = dp.a.v(object.readStrongBinder());
                    n2 = object.readInt();
                    stringArray2 = object.readString();
                    object3 = stringArray;
                    if (object.readInt() != 0) {
                        object3 = (Bundle)Bundle.CREATOR.createFromParcel(object);
                    }
                    this.c((dp)object2, n2, (String)stringArray2, (Bundle)object3);
                    parcel.writeNoException();
                    return true;
                }
                case 7: {
                    object.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    object2 = dp.a.v(object.readStrongBinder());
                    n2 = object.readInt();
                    stringArray = object.readString();
                    object3 = stringArray2;
                    if (object.readInt() != 0) {
                        object3 = (Bundle)Bundle.CREATOR.createFromParcel(object);
                    }
                    this.d((dp)object2, n2, (String)stringArray, (Bundle)object3);
                    parcel.writeNoException();
                    return true;
                }
                case 8: {
                    object.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    object2 = dp.a.v(object.readStrongBinder());
                    n2 = object.readInt();
                    stringArray = object.readString();
                    object3 = string2;
                    if (object.readInt() != 0) {
                        object3 = (Bundle)Bundle.CREATOR.createFromParcel(object);
                    }
                    this.e((dp)object2, n2, (String)stringArray, (Bundle)object3);
                    parcel.writeNoException();
                    return true;
                }
                case 9: {
                    object.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    object3 = dp.a.v(object.readStrongBinder());
                    n2 = object.readInt();
                    object2 = object.readString();
                    stringArray = object.readString();
                    stringArray2 = object.createStringArray();
                    string2 = object.readString();
                    iBinder = object.readStrongBinder();
                    string3 = object.readString();
                    object = object.readInt() != 0 ? (Bundle)Bundle.CREATOR.createFromParcel(object) : null;
                    this.a((dp)object3, n2, (String)object2, (String)stringArray, stringArray2, string2, iBinder, string3, (Bundle)object);
                    parcel.writeNoException();
                    return true;
                }
                case 10: {
                    object.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    this.a(dp.a.v(object.readStrongBinder()), object.readInt(), object.readString(), object.readString(), object.createStringArray());
                    parcel.writeNoException();
                    return true;
                }
                case 11: {
                    object.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    object2 = dp.a.v(object.readStrongBinder());
                    n2 = object.readInt();
                    stringArray = object.readString();
                    object3 = iBinder;
                    if (object.readInt() != 0) {
                        object3 = (Bundle)Bundle.CREATOR.createFromParcel(object);
                    }
                    this.f((dp)object2, n2, (String)stringArray, (Bundle)object3);
                    parcel.writeNoException();
                    return true;
                }
                case 12: {
                    object.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    object2 = dp.a.v(object.readStrongBinder());
                    n2 = object.readInt();
                    stringArray = object.readString();
                    object3 = string3;
                    if (object.readInt() != 0) {
                        object3 = (Bundle)Bundle.CREATOR.createFromParcel(object);
                    }
                    this.g((dp)object2, n2, (String)stringArray, (Bundle)object3);
                    parcel.writeNoException();
                    return true;
                }
                case 13: {
                    object.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    object2 = dp.a.v(object.readStrongBinder());
                    n2 = object.readInt();
                    stringArray = object.readString();
                    object3 = var12_11;
                    if (object.readInt() != 0) {
                        object3 = (Bundle)Bundle.CREATOR.createFromParcel(object);
                    }
                    this.h((dp)object2, n2, (String)stringArray, (Bundle)object3);
                    parcel.writeNoException();
                    return true;
                }
                case 14: {
                    object.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    object2 = dp.a.v(object.readStrongBinder());
                    n2 = object.readInt();
                    stringArray = object.readString();
                    object3 = var13_12;
                    if (object.readInt() != 0) {
                        object3 = (Bundle)Bundle.CREATOR.createFromParcel(object);
                    }
                    this.i((dp)object2, n2, (String)stringArray, (Bundle)object3);
                    parcel.writeNoException();
                    return true;
                }
                case 15: {
                    object.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    object2 = dp.a.v(object.readStrongBinder());
                    n2 = object.readInt();
                    stringArray = object.readString();
                    object3 = var14_13;
                    if (object.readInt() != 0) {
                        object3 = (Bundle)Bundle.CREATOR.createFromParcel(object);
                    }
                    this.j((dp)object2, n2, (String)stringArray, (Bundle)object3);
                    parcel.writeNoException();
                    return true;
                }
                case 16: {
                    object.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    object2 = dp.a.v(object.readStrongBinder());
                    n2 = object.readInt();
                    stringArray = object.readString();
                    object3 = var15_14;
                    if (object.readInt() != 0) {
                        object3 = (Bundle)Bundle.CREATOR.createFromParcel(object);
                    }
                    this.k((dp)object2, n2, (String)stringArray, (Bundle)object3);
                    parcel.writeNoException();
                    return true;
                }
                case 17: {
                    object.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    object2 = dp.a.v(object.readStrongBinder());
                    n2 = object.readInt();
                    stringArray = object.readString();
                    object3 = var16_15;
                    if (object.readInt() != 0) {
                        object3 = (Bundle)Bundle.CREATOR.createFromParcel(object);
                    }
                    this.l((dp)object2, n2, (String)stringArray, (Bundle)object3);
                    parcel.writeNoException();
                    return true;
                }
                case 18: {
                    object.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    object2 = dp.a.v(object.readStrongBinder());
                    n2 = object.readInt();
                    stringArray = object.readString();
                    object3 = var17_16;
                    if (object.readInt() != 0) {
                        object3 = (Bundle)Bundle.CREATOR.createFromParcel(object);
                    }
                    this.m((dp)object2, n2, (String)stringArray, (Bundle)object3);
                    parcel.writeNoException();
                    return true;
                }
                case 19: {
                    object.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    object3 = dp.a.v(object.readStrongBinder());
                    n2 = object.readInt();
                    object2 = object.readString();
                    stringArray = object.readStrongBinder();
                    object = object.readInt() != 0 ? (Bundle)Bundle.CREATOR.createFromParcel(object) : null;
                    this.a((dp)object3, n2, (String)object2, (IBinder)stringArray, (Bundle)object);
                    parcel.writeNoException();
                    return true;
                }
                case 20: 
            }
            object.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            object3 = dp.a.v(object.readStrongBinder());
            n2 = object.readInt();
            object2 = object.readString();
            stringArray = object.createStringArray();
            stringArray2 = object.readString();
            object = object.readInt() != 0 ? (Bundle)Bundle.CREATOR.createFromParcel(object) : null;
            this.a((dp)object3, n2, (String)object2, stringArray, (String)stringArray2, (Bundle)object);
            parcel.writeNoException();
            return true;
        }

        private static class a
        implements dq {
            private IBinder dU;

            a(IBinder iBinder) {
                this.dU = iBinder;
            }

            @Override
            public void a(dp dp2, int n2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    dp2 = dp2 != null ? dp2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)dp2);
                    parcel.writeInt(n2);
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
            public void a(dp dp2, int n2, String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    dp2 = dp2 != null ? dp2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)dp2);
                    parcel.writeInt(n2);
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

            /*
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public void a(dp dp2, int n2, String string2, Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    void var4_9;
                    void var3_8;
                    void var2_7;
                    void var1_3;
                    parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    if (dp2 != null) {
                        IBinder iBinder = dp2.asBinder();
                    } else {
                        Object var1_4 = null;
                    }
                    parcel.writeStrongBinder((IBinder)var1_3);
                    parcel.writeInt((int)var2_7);
                    parcel.writeString((String)var3_8);
                    if (var4_9 != null) {
                        parcel.writeInt(1);
                        var4_9.writeToParcel(parcel, 0);
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
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public void a(dp dp2, int n2, String string2, IBinder iBinder, Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    void var5_10;
                    void var4_9;
                    void var3_8;
                    void var2_7;
                    void var1_3;
                    parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    if (dp2 != null) {
                        IBinder iBinder2 = dp2.asBinder();
                    } else {
                        Object var1_4 = null;
                    }
                    parcel.writeStrongBinder((IBinder)var1_3);
                    parcel.writeInt((int)var2_7);
                    parcel.writeString((String)var3_8);
                    parcel.writeStrongBinder((IBinder)var4_9);
                    if (var5_10 != null) {
                        parcel.writeInt(1);
                        var5_10.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(19, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void a(dp dp2, int n2, String string2, String string3, String[] stringArray) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    dp2 = dp2 != null ? dp2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)dp2);
                    parcel.writeInt(n2);
                    parcel.writeString(string2);
                    parcel.writeString(string3);
                    parcel.writeStringArray(stringArray);
                    this.dU.transact(10, parcel, parcel2, 0);
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
            public void a(dp dp2, int n2, String string2, String string3, String[] stringArray, String string4, Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    void var7_12;
                    void var6_11;
                    void var5_10;
                    void var4_9;
                    void var3_8;
                    void var2_7;
                    void var1_3;
                    parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    if (dp2 != null) {
                        IBinder iBinder = dp2.asBinder();
                    } else {
                        Object var1_4 = null;
                    }
                    parcel.writeStrongBinder((IBinder)var1_3);
                    parcel.writeInt((int)var2_7);
                    parcel.writeString((String)var3_8);
                    parcel.writeString((String)var4_9);
                    parcel.writeStringArray((String[])var5_10);
                    parcel.writeString((String)var6_11);
                    if (var7_12 != null) {
                        parcel.writeInt(1);
                        var7_12.writeToParcel(parcel, 0);
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
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public void a(dp dp2, int n2, String string2, String string3, String[] stringArray, String string4, IBinder iBinder, String string5, Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    void var9_14;
                    void var8_13;
                    void var7_12;
                    void var6_11;
                    void var5_10;
                    void var4_9;
                    void var3_8;
                    void var2_7;
                    void var1_3;
                    parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    if (dp2 != null) {
                        IBinder iBinder2 = dp2.asBinder();
                    } else {
                        Object var1_4 = null;
                    }
                    parcel.writeStrongBinder((IBinder)var1_3);
                    parcel.writeInt((int)var2_7);
                    parcel.writeString((String)var3_8);
                    parcel.writeString((String)var4_9);
                    parcel.writeStringArray((String[])var5_10);
                    parcel.writeString((String)var6_11);
                    parcel.writeStrongBinder((IBinder)var7_12);
                    parcel.writeString((String)var8_13);
                    if (var9_14 != null) {
                        parcel.writeInt(1);
                        var9_14.writeToParcel(parcel, 0);
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

            /*
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public void a(dp dp2, int n2, String string2, String[] stringArray, String string3, Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    void var6_11;
                    void var5_10;
                    void var4_9;
                    void var3_8;
                    void var2_7;
                    void var1_3;
                    parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    if (dp2 != null) {
                        IBinder iBinder = dp2.asBinder();
                    } else {
                        Object var1_4 = null;
                    }
                    parcel.writeStrongBinder((IBinder)var1_3);
                    parcel.writeInt((int)var2_7);
                    parcel.writeString((String)var3_8);
                    parcel.writeStringArray((String[])var4_9);
                    parcel.writeString((String)var5_10);
                    if (var6_11 != null) {
                        parcel.writeInt(1);
                        var6_11.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(20, parcel, parcel2, 0);
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

            /*
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public void b(dp dp2, int n2, String string2, Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    void var4_9;
                    void var3_8;
                    void var2_7;
                    void var1_3;
                    parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    if (dp2 != null) {
                        IBinder iBinder = dp2.asBinder();
                    } else {
                        Object var1_4 = null;
                    }
                    parcel.writeStrongBinder((IBinder)var1_3);
                    parcel.writeInt((int)var2_7);
                    parcel.writeString((String)var3_8);
                    if (var4_9 != null) {
                        parcel.writeInt(1);
                        var4_9.writeToParcel(parcel, 0);
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

            /*
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public void c(dp dp2, int n2, String string2, Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    void var4_9;
                    void var3_8;
                    void var2_7;
                    void var1_3;
                    parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    if (dp2 != null) {
                        IBinder iBinder = dp2.asBinder();
                    } else {
                        Object var1_4 = null;
                    }
                    parcel.writeStrongBinder((IBinder)var1_3);
                    parcel.writeInt((int)var2_7);
                    parcel.writeString((String)var3_8);
                    if (var4_9 != null) {
                        parcel.writeInt(1);
                        var4_9.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(6, parcel, parcel2, 0);
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
            public void d(dp dp2, int n2, String string2, Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    void var4_9;
                    void var3_8;
                    void var2_7;
                    void var1_3;
                    parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    if (dp2 != null) {
                        IBinder iBinder = dp2.asBinder();
                    } else {
                        Object var1_4 = null;
                    }
                    parcel.writeStrongBinder((IBinder)var1_3);
                    parcel.writeInt((int)var2_7);
                    parcel.writeString((String)var3_8);
                    if (var4_9 != null) {
                        parcel.writeInt(1);
                        var4_9.writeToParcel(parcel, 0);
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

            /*
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public void e(dp dp2, int n2, String string2, Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    void var4_9;
                    void var3_8;
                    void var2_7;
                    void var1_3;
                    parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    if (dp2 != null) {
                        IBinder iBinder = dp2.asBinder();
                    } else {
                        Object var1_4 = null;
                    }
                    parcel.writeStrongBinder((IBinder)var1_3);
                    parcel.writeInt((int)var2_7);
                    parcel.writeString((String)var3_8);
                    if (var4_9 != null) {
                        parcel.writeInt(1);
                        var4_9.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(8, parcel, parcel2, 0);
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
            public void f(dp dp2, int n2, String string2, Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    void var4_9;
                    void var3_8;
                    void var2_7;
                    void var1_3;
                    parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    if (dp2 != null) {
                        IBinder iBinder = dp2.asBinder();
                    } else {
                        Object var1_4 = null;
                    }
                    parcel.writeStrongBinder((IBinder)var1_3);
                    parcel.writeInt((int)var2_7);
                    parcel.writeString((String)var3_8);
                    if (var4_9 != null) {
                        parcel.writeInt(1);
                        var4_9.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(11, parcel, parcel2, 0);
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
            public void g(dp dp2, int n2, String string2, Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    void var4_9;
                    void var3_8;
                    void var2_7;
                    void var1_3;
                    parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    if (dp2 != null) {
                        IBinder iBinder = dp2.asBinder();
                    } else {
                        Object var1_4 = null;
                    }
                    parcel.writeStrongBinder((IBinder)var1_3);
                    parcel.writeInt((int)var2_7);
                    parcel.writeString((String)var3_8);
                    if (var4_9 != null) {
                        parcel.writeInt(1);
                        var4_9.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(12, parcel, parcel2, 0);
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
            public void h(dp dp2, int n2, String string2, Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    void var4_9;
                    void var3_8;
                    void var2_7;
                    void var1_3;
                    parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    if (dp2 != null) {
                        IBinder iBinder = dp2.asBinder();
                    } else {
                        Object var1_4 = null;
                    }
                    parcel.writeStrongBinder((IBinder)var1_3);
                    parcel.writeInt((int)var2_7);
                    parcel.writeString((String)var3_8);
                    if (var4_9 != null) {
                        parcel.writeInt(1);
                        var4_9.writeToParcel(parcel, 0);
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
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public void i(dp dp2, int n2, String string2, Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    void var4_9;
                    void var3_8;
                    void var2_7;
                    void var1_3;
                    parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    if (dp2 != null) {
                        IBinder iBinder = dp2.asBinder();
                    } else {
                        Object var1_4 = null;
                    }
                    parcel.writeStrongBinder((IBinder)var1_3);
                    parcel.writeInt((int)var2_7);
                    parcel.writeString((String)var3_8);
                    if (var4_9 != null) {
                        parcel.writeInt(1);
                        var4_9.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(14, parcel, parcel2, 0);
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
            public void j(dp dp2, int n2, String string2, Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    void var4_9;
                    void var3_8;
                    void var2_7;
                    void var1_3;
                    parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    if (dp2 != null) {
                        IBinder iBinder = dp2.asBinder();
                    } else {
                        Object var1_4 = null;
                    }
                    parcel.writeStrongBinder((IBinder)var1_3);
                    parcel.writeInt((int)var2_7);
                    parcel.writeString((String)var3_8);
                    if (var4_9 != null) {
                        parcel.writeInt(1);
                        var4_9.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(15, parcel, parcel2, 0);
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
            public void k(dp dp2, int n2, String string2, Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    void var4_9;
                    void var3_8;
                    void var2_7;
                    void var1_3;
                    parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    if (dp2 != null) {
                        IBinder iBinder = dp2.asBinder();
                    } else {
                        Object var1_4 = null;
                    }
                    parcel.writeStrongBinder((IBinder)var1_3);
                    parcel.writeInt((int)var2_7);
                    parcel.writeString((String)var3_8);
                    if (var4_9 != null) {
                        parcel.writeInt(1);
                        var4_9.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(16, parcel, parcel2, 0);
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
            public void l(dp dp2, int n2, String string2, Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    void var4_9;
                    void var3_8;
                    void var2_7;
                    void var1_3;
                    parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    if (dp2 != null) {
                        IBinder iBinder = dp2.asBinder();
                    } else {
                        Object var1_4 = null;
                    }
                    parcel.writeStrongBinder((IBinder)var1_3);
                    parcel.writeInt((int)var2_7);
                    parcel.writeString((String)var3_8);
                    if (var4_9 != null) {
                        parcel.writeInt(1);
                        var4_9.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(17, parcel, parcel2, 0);
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
            public void m(dp dp2, int n2, String string2, Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    void var4_9;
                    void var3_8;
                    void var2_7;
                    void var1_3;
                    parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    if (dp2 != null) {
                        IBinder iBinder = dp2.asBinder();
                    } else {
                        Object var1_4 = null;
                    }
                    parcel.writeStrongBinder((IBinder)var1_3);
                    parcel.writeInt((int)var2_7);
                    parcel.writeString((String)var3_8);
                    if (var4_9 != null) {
                        parcel.writeInt(1);
                        var4_9.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(18, parcel, parcel2, 0);
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

