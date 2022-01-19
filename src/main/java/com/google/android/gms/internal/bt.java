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

public interface bt
extends IInterface {
    public IBinder a(b var1) throws RemoteException;

    public static abstract class com.google.android.gms.internal.bt$a
    extends Binder
    implements bt {
        public static bt n(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
            if (iInterface == null) return new a(iBinder);
            if (!(iInterface instanceof bt)) return new a(iBinder);
            return (bt)iInterface;
        }

        public boolean onTransact(int n2, Parcel parcel, Parcel parcel2, int n3) throws RemoteException {
            switch (n2) {
                default: {
                    return super.onTransact(n2, parcel, parcel2, n3);
                }
                case 1598968902: {
                    parcel2.writeString("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
                    return true;
                }
                case 1: 
            }
            parcel.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
            parcel = this.a(b.a.C(parcel.readStrongBinder()));
            parcel2.writeNoException();
            parcel2.writeStrongBinder((IBinder)parcel);
            return true;
        }

        private static class a
        implements bt {
            private IBinder dU;

            a(IBinder iBinder) {
                this.dU = iBinder;
            }

            @Override
            public IBinder a(b b2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
                    b2 = b2 != null ? b2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)b2);
                    this.dU.transact(1, parcel, parcel2, 0);
                    parcel2.readException();
                    b2 = parcel2.readStrongBinder();
                    return b2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            public IBinder asBinder() {
                return this.dU;
            }
        }
    }
}

