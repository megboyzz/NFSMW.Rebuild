/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Binder
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 */
package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ek;
import com.google.android.gms.internal.gm;
import java.util.List;

public interface gp
extends IInterface {
    public void a(ek var1) throws RemoteException;

    public void a(gm var1) throws RemoteException;

    public void a(gm var1, int var2, int var3, int var4, String var5) throws RemoteException;

    public void a(gm var1, int var2, String var3, Uri var4, String var5, String var6) throws RemoteException;

    public void a(gm var1, Uri var2, Bundle var3) throws RemoteException;

    public void a(gm var1, String var2) throws RemoteException;

    public void a(gm var1, String var2, String var3) throws RemoteException;

    public void a(gm var1, List<String> var2) throws RemoteException;

    public void b(gm var1) throws RemoteException;

    public void b(gm var1, String var2) throws RemoteException;

    public void c(gm var1, String var2) throws RemoteException;

    public void clearDefaultAccount() throws RemoteException;

    public void d(gm var1, String var2) throws RemoteException;

    public void e(gm var1, String var2) throws RemoteException;

    public String et() throws RemoteException;

    public boolean eu() throws RemoteException;

    public String ev() throws RemoteException;

    public String getAccountName() throws RemoteException;

    public void removeMoment(String var1) throws RemoteException;

    public static abstract class com.google.android.gms.internal.gp$a
    extends Binder
    implements gp {
        public static gp au(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.plus.internal.IPlusService");
            if (iInterface == null) return new a(iBinder);
            if (!(iInterface instanceof gp)) return new a(iBinder);
            return (gp)iInterface;
        }

        public boolean onTransact(int n2, Parcel object, Parcel parcel, int n3) throws RemoteException {
            Uri uri = null;
            switch (n2) {
                default: {
                    return super.onTransact(n2, object, parcel, n3);
                }
                case 1598968902: {
                    parcel.writeString("com.google.android.gms.plus.internal.IPlusService");
                    return true;
                }
                case 1: {
                    object.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    this.a(gm.a.ar(object.readStrongBinder()), object.readString());
                    parcel.writeNoException();
                    return true;
                }
                case 2: {
                    object.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    this.a(gm.a.ar(object.readStrongBinder()), object.readString(), object.readString());
                    parcel.writeNoException();
                    return true;
                }
                case 3: {
                    object.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    this.b(gm.a.ar(object.readStrongBinder()), object.readString());
                    parcel.writeNoException();
                    return true;
                }
                case 4: {
                    object.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    object = object.readInt() != 0 ? ek.CREATOR.t((Parcel)object) : null;
                    this.a((ek)object);
                    parcel.writeNoException();
                    return true;
                }
                case 5: {
                    object.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    object = this.getAccountName();
                    parcel.writeNoException();
                    parcel.writeString((String)object);
                    return true;
                }
                case 6: {
                    object.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    this.clearDefaultAccount();
                    parcel.writeNoException();
                    return true;
                }
                case 8: {
                    object.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    this.a(gm.a.ar(object.readStrongBinder()));
                    parcel.writeNoException();
                    return true;
                }
                case 9: {
                    object.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    gm gm2 = gm.a.ar(object.readStrongBinder());
                    uri = object.readInt() != 0 ? (Uri)Uri.CREATOR.createFromParcel(object) : null;
                    object = object.readInt() != 0 ? (Bundle)Bundle.CREATOR.createFromParcel(object) : null;
                    this.a(gm2, uri, (Bundle)object);
                    parcel.writeNoException();
                    return true;
                }
                case 14: {
                    object.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    gm gm3 = gm.a.ar(object.readStrongBinder());
                    n2 = object.readInt();
                    String string2 = object.readString();
                    if (object.readInt() != 0) {
                        uri = (Uri)Uri.CREATOR.createFromParcel(object);
                    }
                    this.a(gm3, n2, string2, uri, object.readString(), object.readString());
                    parcel.writeNoException();
                    return true;
                }
                case 16: {
                    object.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    this.a(gm.a.ar(object.readStrongBinder()), object.readInt(), object.readInt(), object.readInt(), object.readString());
                    parcel.writeNoException();
                    return true;
                }
                case 17: {
                    object.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    this.removeMoment(object.readString());
                    parcel.writeNoException();
                    return true;
                }
                case 18: {
                    object.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    this.c(gm.a.ar(object.readStrongBinder()), object.readString());
                    parcel.writeNoException();
                    return true;
                }
                case 19: {
                    object.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    this.b(gm.a.ar(object.readStrongBinder()));
                    parcel.writeNoException();
                    return true;
                }
                case 34: {
                    object.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    this.a(gm.a.ar(object.readStrongBinder()), object.createStringArrayList());
                    parcel.writeNoException();
                    return true;
                }
                case 40: {
                    object.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    this.d(gm.a.ar(object.readStrongBinder()), object.readString());
                    parcel.writeNoException();
                    return true;
                }
                case 41: {
                    object.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    object = this.et();
                    parcel.writeNoException();
                    parcel.writeString((String)object);
                    return true;
                }
                case 42: {
                    object.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    boolean bl2 = this.eu();
                    parcel.writeNoException();
                    n2 = bl2 ? 1 : 0;
                    parcel.writeInt(n2);
                    return true;
                }
                case 43: {
                    object.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    object = this.ev();
                    parcel.writeNoException();
                    parcel.writeString((String)object);
                    return true;
                }
                case 44: 
            }
            object.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
            this.e(gm.a.ar(object.readStrongBinder()), object.readString());
            parcel.writeNoException();
            return true;
        }

        private static class a
        implements gp {
            private IBinder dU;

            a(IBinder iBinder) {
                this.dU = iBinder;
            }

            @Override
            public void a(ek ek2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    if (ek2 != null) {
                        parcel.writeInt(1);
                        ek2.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
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
            public void a(gm gm2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    gm2 = gm2 != null ? gm2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)gm2);
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
            public void a(gm gm2, int n2, int n3, int n4, String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    gm2 = gm2 != null ? gm2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)gm2);
                    parcel.writeInt(n2);
                    parcel.writeInt(n3);
                    parcel.writeInt(n4);
                    parcel.writeString(string2);
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
            public void a(gm gm2, int n2, String string2, Uri uri, String string3, String string4) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    void var6_11;
                    void var5_10;
                    void var4_9;
                    void var3_8;
                    void var2_7;
                    void var1_3;
                    parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    if (gm2 != null) {
                        IBinder iBinder = gm2.asBinder();
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
                    parcel.writeString((String)var5_10);
                    parcel.writeString((String)var6_11);
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
             * Enabled unnecessary exception pruning
             */
            @Override
            public void a(gm gm2, Uri uri, Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    gm2 = gm2 != null ? gm2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)gm2);
                    if (uri != null) {
                        parcel.writeInt(1);
                        uri.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    if (bundle != null) {
                        parcel.writeInt(1);
                        bundle.writeToParcel(parcel, 0);
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
            public void a(gm gm2, String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    gm2 = gm2 != null ? gm2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)gm2);
                    parcel.writeString(string2);
                    this.dU.transact(1, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void a(gm gm2, String string2, String string3) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    gm2 = gm2 != null ? gm2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)gm2);
                    parcel.writeString(string2);
                    parcel.writeString(string3);
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
            public void a(gm gm2, List<String> list) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    gm2 = gm2 != null ? gm2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)gm2);
                    parcel.writeStringList(list);
                    this.dU.transact(34, parcel, parcel2, 0);
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
            public void b(gm gm2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    gm2 = gm2 != null ? gm2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)gm2);
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
            public void b(gm gm2, String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    gm2 = gm2 != null ? gm2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)gm2);
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
            public void c(gm gm2, String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    gm2 = gm2 != null ? gm2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)gm2);
                    parcel.writeString(string2);
                    this.dU.transact(18, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void clearDefaultAccount() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
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
            public void d(gm gm2, String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    gm2 = gm2 != null ? gm2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)gm2);
                    parcel.writeString(string2);
                    this.dU.transact(40, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void e(gm gm2, String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    gm2 = gm2 != null ? gm2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)gm2);
                    parcel.writeString(string2);
                    this.dU.transact(44, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public String et() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.dU.transact(41, parcel, parcel2, 0);
                    parcel2.readException();
                    String string2 = parcel2.readString();
                    return string2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public boolean eu() throws RemoteException {
                boolean bl2 = false;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.dU.transact(42, parcel, parcel2, 0);
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
            public String ev() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.dU.transact(43, parcel, parcel2, 0);
                    parcel2.readException();
                    String string2 = parcel2.readString();
                    return string2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public String getAccountName() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.dU.transact(5, parcel, parcel2, 0);
                    parcel2.readException();
                    String string2 = parcel2.readString();
                    return string2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void removeMoment(String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    parcel.writeString(string2);
                    this.dU.transact(17, parcel, parcel2, 0);
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

