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
package com.google.android.gms.maps.internal;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;

public interface o
extends IInterface {
    public void c(b var1) throws RemoteException;

    public void onSnapshotReady(Bitmap var1) throws RemoteException;

    public static abstract class com.google.android.gms.maps.internal.o$a
    extends Binder
    implements o {
        public com.google.android.gms.maps.internal.o$a() {
            this.attachInterface(this, "com.google.android.gms.maps.internal.ISnapshotReadyCallback");
        }

        public static o ae(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
            if (iInterface == null) return new a(iBinder);
            if (!(iInterface instanceof o)) return new a(iBinder);
            return (o)iInterface;
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
                    parcel.writeString("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
                    return true;
                }
                case 1: {
                    object.enforceInterface("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
                    object = object.readInt() != 0 ? (Bitmap)Bitmap.CREATOR.createFromParcel(object) : null;
                    this.onSnapshotReady((Bitmap)object);
                    parcel.writeNoException();
                    return true;
                }
                case 2: 
            }
            object.enforceInterface("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
            this.c(b.a.C(object.readStrongBinder()));
            parcel.writeNoException();
            return true;
        }

        private static class a
        implements o {
            private IBinder dU;

            a(IBinder iBinder) {
                this.dU = iBinder;
            }

            public IBinder asBinder() {
                return this.dU;
            }

            @Override
            public void c(b b2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
                    b2 = b2 != null ? b2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)b2);
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
            public void onSnapshotReady(Bitmap bitmap) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
                    if (bitmap != null) {
                        parcel.writeInt(1);
                        bitmap.writeToParcel(parcel, 0);
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
        }
    }
}

