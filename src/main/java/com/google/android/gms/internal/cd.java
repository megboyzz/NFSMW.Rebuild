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

import com.ea.ironmonkey.devmenu.util.Observer;

public interface cd
extends IInterface {
    cb b(bz var1) throws RemoteException;

    abstract class cd$a
    extends Binder
    implements cd {
        public cd$a() {
            this.attachInterface(this, "com.google.android.gms.ads.internal.request.IAdRequestService");
        }

        public static cd q(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
            if (iInterface == null) return new a(iBinder);
            if (!(iInterface instanceof cd)) return new a(iBinder);
            return (cd)iInterface;
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
                    parcel.writeString("com.google.android.gms.ads.internal.request.IAdRequestService");
                    return true;
                }
                case 1: 
            }
            object.enforceInterface("com.google.android.gms.ads.internal.request.IAdRequestService");

            parcel.writeInt(0);
            return true;
        }

        private static class a
        implements cd {
            private IBinder dU;

            a(IBinder iBinder) {
                this.dU = iBinder;
            }

            public IBinder asBinder() {
                return this.dU;
            }

            /*
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public cb b(bz safeParcelable) throws RemoteException {
                Observer.onCallingMethod(
                        Observer.Method.HARD_TO_RECOVER_LOGIC,
                        Observer.Method.RETURN_NULL);
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.ads.internal.request.IAdRequestService");
                    if (safeParcelable != null) {
                        parcel.writeInt(1);
                        ((bz)safeParcelable).writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(1, parcel, parcel2, 0);
                    parcel2.readException();
                    if (parcel2.readInt() != 0) {
                        cb cb2 = cb.CREATOR.g(parcel2);

                    } else {
                        Object var1_5 = null;
                    }

                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
                return null;
            }
        }
    }
}

