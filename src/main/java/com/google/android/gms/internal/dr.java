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

public interface dr
extends IInterface {
    public b a(b var1, int var2, int var3) throws RemoteException;

    public static abstract class com.google.android.gms.internal.dr$a
    extends Binder
    implements dr {
        public static dr x(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
            if (iInterface == null) return new a(iBinder);
            if (!(iInterface instanceof dr)) return new a(iBinder);
            return (dr)iInterface;
        }

        public boolean onTransact(int n2, Parcel object, Parcel parcel, int n3) throws RemoteException {
            switch (n2) {
                default: {
                    return super.onTransact(n2, object, parcel, n3);
                }
                case 1598968902: {
                    parcel.writeString("com.google.android.gms.common.internal.ISignInButtonCreator");
                    return true;
                }
                case 1: 
            }
            object.enforceInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
            object = this.a(b.a.C(object.readStrongBinder()), object.readInt(), object.readInt());
            parcel.writeNoException();
            object = object != null ? object.asBinder() : null;
            parcel.writeStrongBinder((IBinder)object);
            return true;
        }

        private static class a
        implements dr {
            private IBinder dU;

            a(IBinder iBinder) {
                this.dU = iBinder;
            }

            @Override
            public b a(b b2, int n2, int n3) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.common.internal.ISignInButtonCreator");
                    b2 = b2 != null ? b2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)b2);
                    parcel.writeInt(n2);
                    parcel.writeInt(n3);
                    this.dU.transact(1, parcel, parcel2, 0);
                    parcel2.readException();
                    b2 = b.a.C(parcel2.readStrongBinder());
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

