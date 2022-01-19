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

public interface o
extends IInterface {
    public Bundle a(String var1, String var2, Bundle var3) throws RemoteException;

    public static abstract class com.google.android.gms.internal.o$a
    extends Binder
    implements o {
        public static o a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.auth.IAuthManagerService");
            if (iInterface == null) return new a(iBinder);
            if (!(iInterface instanceof o)) return new a(iBinder);
            return (o)iInterface;
        }

        public boolean onTransact(int n2, Parcel object, Parcel parcel, int n3) throws RemoteException {
            switch (n2) {
                default: {
                    return super.onTransact(n2, object, parcel, n3);
                }
                case 1598968902: {
                    parcel.writeString("com.google.android.auth.IAuthManagerService");
                    return true;
                }
                case 1: 
            }
            object.enforceInterface("com.google.android.auth.IAuthManagerService");
            String string2 = object.readString();
            String string3 = object.readString();
            object = object.readInt() != 0 ? (Bundle)Bundle.CREATOR.createFromParcel(object) : null;
            object = this.a(string2, string3, (Bundle)object);
            parcel.writeNoException();
            if (object != null) {
                parcel.writeInt(1);
                object.writeToParcel(parcel, 1);
                return true;
            }
            parcel.writeInt(0);
            return true;
        }

        private static class a
        implements o {
            private IBinder dU;

            a(IBinder iBinder) {
                this.dU = iBinder;
            }

            /*
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public Bundle a(String string2, String string3, Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    void var1_3;
                    void var3_7;
                    void var2_6;
                    parcel.writeInterfaceToken("com.google.android.auth.IAuthManagerService");
                    parcel.writeString(string2);
                    parcel.writeString((String)var2_6);
                    if (var3_7 != null) {
                        parcel.writeInt(1);
                        var3_7.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(1, parcel, parcel2, 0);
                    parcel2.readException();
                    if (parcel2.readInt() != 0) {
                        Bundle bundle2 = (Bundle)Bundle.CREATOR.createFromParcel(parcel2);
                        return var1_3;
                    } else {
                        Object var1_5 = null;
                    }
                    return var1_3;
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

