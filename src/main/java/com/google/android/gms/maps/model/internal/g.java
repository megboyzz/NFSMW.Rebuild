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
package com.google.android.gms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.Tile;

public interface g
extends IInterface {
    public Tile getTile(int var1, int var2, int var3) throws RemoteException;

    public static abstract class com.google.android.gms.maps.model.internal.g$a
    extends Binder
    implements g {
        public com.google.android.gms.maps.model.internal.g$a() {
            this.attachInterface(this, "com.google.android.gms.maps.model.internal.ITileProviderDelegate");
        }

        public static g an(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
            if (iInterface == null) return new a(iBinder);
            if (!(iInterface instanceof g)) return new a(iBinder);
            return (g)iInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int n2, Parcel object, Parcel parcel, int n3) throws RemoteException {
            switch (n2) {
                default: {
                    return super.onTransact(n2, (Parcel)object, parcel, n3);
                }
                case 1598968902: {
                    parcel.writeString("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
                    return true;
                }
                case 1: 
            }
            object.enforceInterface("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
            object = this.getTile(object.readInt(), object.readInt(), object.readInt());
            parcel.writeNoException();
            if (object != null) {
                parcel.writeInt(1);
                ((Tile)object).writeToParcel(parcel, 1);
                return true;
            }
            parcel.writeInt(0);
            return true;
        }

        private static class a
        implements g {
            private IBinder dU;

            a(IBinder iBinder) {
                this.dU = iBinder;
            }

            public IBinder asBinder() {
                return this.dU;
            }

            @Override
            public Tile getTile(int n2, int n3, int n4) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
                    parcel.writeInt(n2);
                    parcel.writeInt(n3);
                    parcel.writeInt(n4);
                    this.dU.transact(1, parcel, parcel2, 0);
                    parcel2.readException();
                    Tile tile = parcel2.readInt() != 0 ? Tile.CREATOR.createFromParcel(parcel2) : null;
                    return tile;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }
        }
    }
}

