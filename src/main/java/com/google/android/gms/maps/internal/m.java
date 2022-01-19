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
package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface m
extends IInterface {
    public boolean onMyLocationButtonClick() throws RemoteException;

    public static abstract class com.google.android.gms.maps.internal.m$a
    extends Binder
    implements m {
        public com.google.android.gms.maps.internal.m$a() {
            this.attachInterface(this, "com.google.android.gms.maps.internal.IOnMyLocationButtonClickListener");
        }

        public static m ab(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnMyLocationButtonClickListener");
            if (iInterface == null) return new a(iBinder);
            if (!(iInterface instanceof m)) return new a(iBinder);
            return (m)iInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int n2, Parcel parcel, Parcel parcel2, int n3) throws RemoteException {
            switch (n2) {
                default: {
                    return super.onTransact(n2, parcel, parcel2, n3);
                }
                case 1598968902: {
                    parcel2.writeString("com.google.android.gms.maps.internal.IOnMyLocationButtonClickListener");
                    return true;
                }
                case 1: 
            }
            parcel.enforceInterface("com.google.android.gms.maps.internal.IOnMyLocationButtonClickListener");
            boolean bl2 = this.onMyLocationButtonClick();
            parcel2.writeNoException();
            n2 = bl2 ? 1 : 0;
            parcel2.writeInt(n2);
            return true;
        }

        private static class a
        implements m {
            private IBinder dU;

            a(IBinder iBinder) {
                this.dU = iBinder;
            }

            public IBinder asBinder() {
                return this.dU;
            }

            @Override
            public boolean onMyLocationButtonClick() throws RemoteException {
                Parcel parcel;
                Parcel parcel2;
                boolean bl2;
                block3: {
                    block2: {
                        bl2 = true;
                        parcel2 = Parcel.obtain();
                        parcel = Parcel.obtain();
                        try {
                            parcel2.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMyLocationButtonClickListener");
                            this.dU.transact(1, parcel2, parcel, 0);
                            parcel.readException();
                            int n2 = parcel.readInt();
                            if (n2 == 0) break block2;
                            break block3;
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
        }
    }
}

