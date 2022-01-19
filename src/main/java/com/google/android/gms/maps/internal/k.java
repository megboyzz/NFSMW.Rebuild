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
import com.google.android.gms.maps.model.internal.d;

public interface k
extends IInterface {
    public boolean a(d var1) throws RemoteException;

    public static abstract class com.google.android.gms.maps.internal.k$a
    extends Binder
    implements k {
        public com.google.android.gms.maps.internal.k$a() {
            this.attachInterface(this, "com.google.android.gms.maps.internal.IOnMarkerClickListener");
        }

        public static k Z(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnMarkerClickListener");
            if (iInterface == null) return new a(iBinder);
            if (!(iInterface instanceof k)) return new a(iBinder);
            return (k)iInterface;
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
                    parcel2.writeString("com.google.android.gms.maps.internal.IOnMarkerClickListener");
                    return true;
                }
                case 1: 
            }
            parcel.enforceInterface("com.google.android.gms.maps.internal.IOnMarkerClickListener");
            boolean bl2 = this.a(d.a.aj(parcel.readStrongBinder()));
            parcel2.writeNoException();
            n2 = bl2 ? 1 : 0;
            parcel2.writeInt(n2);
            return true;
        }

        private static class a
        implements k {
            private IBinder dU;

            a(IBinder iBinder) {
                this.dU = iBinder;
            }

            @Override
            public boolean a(d d2) throws RemoteException {
                Parcel parcel;
                Parcel parcel2;
                boolean bl2;
                block3: {
                    block2: {
                        bl2 = true;
                        parcel2 = Parcel.obtain();
                        parcel = Parcel.obtain();
                        try {
                            parcel2.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMarkerClickListener");
                            d2 = d2 != null ? d2.asBinder() : null;
                            parcel2.writeStrongBinder((IBinder)d2);
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

            public IBinder asBinder() {
                return this.dU;
            }
        }
    }
}

