/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.os.Binder
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 */
package com.google.android.gms.maps.model.internal;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;

public interface a
extends IInterface {
    public b a(Bitmap var1) throws RemoteException;

    public b aO(int var1) throws RemoteException;

    public b ad(String var1) throws RemoteException;

    public b ae(String var1) throws RemoteException;

    public b af(String var1) throws RemoteException;

    public b c(float var1) throws RemoteException;

    public b en() throws RemoteException;

    public static abstract class com.google.android.gms.maps.model.internal.a$a
    extends Binder
    implements com.google.android.gms.maps.model.internal.a {
        public static com.google.android.gms.maps.model.internal.a ag(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            if (iInterface == null) return new a(iBinder);
            if (!(iInterface instanceof com.google.android.gms.maps.model.internal.a)) return new a(iBinder);
            return (com.google.android.gms.maps.model.internal.a)iInterface;
        }

        public boolean onTransact(int n2, Parcel object, Parcel parcel, int n3) throws RemoteException {
            Object var7_5 = null;
            Object var8_6 = null;
            Object var9_7 = null;
            b b2 = null;
            Object var10_9 = null;
            b b3 = null;
            switch (n2) {
                default: {
                    return super.onTransact(n2, object, parcel, n3);
                }
                case 1598968902: {
                    parcel.writeString("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    return true;
                }
                case 1: {
                    object.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    object = this.aO(object.readInt());
                    parcel.writeNoException();
                    object = object != null ? object.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)object);
                    return true;
                }
                case 2: {
                    object.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    b2 = this.ad(object.readString());
                    parcel.writeNoException();
                    object = b3;
                    if (b2 != null) {
                        object = b2.asBinder();
                    }
                    parcel.writeStrongBinder((IBinder)object);
                    return true;
                }
                case 3: {
                    object.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    b2 = this.ae(object.readString());
                    parcel.writeNoException();
                    object = var7_5;
                    if (b2 != null) {
                        object = b2.asBinder();
                    }
                    parcel.writeStrongBinder((IBinder)object);
                    return true;
                }
                case 4: {
                    object.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    b2 = this.en();
                    parcel.writeNoException();
                    object = var8_6;
                    if (b2 != null) {
                        object = b2.asBinder();
                    }
                    parcel.writeStrongBinder((IBinder)object);
                    return true;
                }
                case 5: {
                    object.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    b2 = this.c(object.readFloat());
                    parcel.writeNoException();
                    object = var9_7;
                    if (b2 != null) {
                        object = b2.asBinder();
                    }
                    parcel.writeStrongBinder((IBinder)object);
                    return true;
                }
                case 6: {
                    object.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    object = object.readInt() != 0 ? (Bitmap)Bitmap.CREATOR.createFromParcel(object) : null;
                    b3 = this.a((Bitmap)object);
                    parcel.writeNoException();
                    object = b2;
                    if (b3 != null) {
                        object = b3.asBinder();
                    }
                    parcel.writeStrongBinder((IBinder)object);
                    return true;
                }
                case 7: 
            }
            object.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            b2 = this.af(object.readString());
            parcel.writeNoException();
            object = var10_9;
            if (b2 != null) {
                object = b2.asBinder();
            }
            parcel.writeStrongBinder((IBinder)object);
            return true;
        }

        private static class a
        implements com.google.android.gms.maps.model.internal.a {
            private IBinder dU;

            a(IBinder iBinder) {
                this.dU = iBinder;
            }

            @Override
            public b a(Bitmap object) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    if (object != null) {
                        parcel.writeInt(1);
                        object.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(6, parcel, parcel2, 0);
                    parcel2.readException();
                    object = b.a.C(parcel2.readStrongBinder());
                    return object;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public b aO(int n2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    parcel.writeInt(n2);
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
            public b ad(String object) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    parcel.writeString((String)object);
                    this.dU.transact(2, parcel, parcel2, 0);
                    parcel2.readException();
                    object = b.a.C(parcel2.readStrongBinder());
                    return object;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public b ae(String object) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    parcel.writeString((String)object);
                    this.dU.transact(3, parcel, parcel2, 0);
                    parcel2.readException();
                    object = b.a.C(parcel2.readStrongBinder());
                    return object;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public b af(String object) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    parcel.writeString((String)object);
                    this.dU.transact(7, parcel, parcel2, 0);
                    parcel2.readException();
                    object = b.a.C(parcel2.readStrongBinder());
                    return object;
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
            public b c(float f2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    parcel.writeFloat(f2);
                    this.dU.transact(5, parcel, parcel2, 0);
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
            public b en() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    this.dU.transact(4, parcel, parcel2, 0);
                    parcel2.readException();
                    b b2 = b.a.C(parcel2.readStrongBinder());
                    return b2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }
        }
    }
}

