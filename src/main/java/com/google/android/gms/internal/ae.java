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

public interface ae
extends IInterface {
    public void onAppEvent(String var1, String var2) throws RemoteException;

    public static abstract class com.google.android.gms.internal.ae$a
    extends Binder
    implements ae {
        public com.google.android.gms.internal.ae$a() {
            this.attachInterface(this, "com.google.android.gms.ads.internal.client.IAppEventListener");
        }

        public static ae h(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
            if (iInterface == null) return new a(iBinder);
            if (!(iInterface instanceof ae)) return new a(iBinder);
            return (ae)iInterface;
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
                    parcel2.writeString("com.google.android.gms.ads.internal.client.IAppEventListener");
                    return true;
                }
                case 1: 
            }
            parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
            this.onAppEvent(parcel.readString(), parcel.readString());
            parcel2.writeNoException();
            return true;
        }

        private static class a
        implements ae {
            private IBinder dU;

            a(IBinder iBinder) {
                this.dU = iBinder;
            }

            public IBinder asBinder() {
                return this.dU;
            }

            @Override
            public void onAppEvent(String string2, String string3) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAppEventListener");
                    parcel.writeString(string2);
                    parcel.writeString(string3);
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

