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
import com.google.android.gms.internal.bb;
import com.google.android.gms.internal.x;

public interface ad
extends IInterface {
    public IBinder a(b var1, x var2, String var3, bb var4, int var5) throws RemoteException;

    public static abstract class com.google.android.gms.internal.ad$a
    extends Binder
    implements ad {
        public static ad g(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
            if (iInterface == null) return new a(iBinder);
            if (!(iInterface instanceof ad)) return new a(iBinder);
            return (ad)iInterface;
        }

        public boolean onTransact(int n2, Parcel parcel, Parcel parcel2, int n3) throws RemoteException {
            switch (n2) {
                default: {
                    return super.onTransact(n2, parcel, parcel2, n3);
                }
                case 1598968902: {
                    parcel2.writeString("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    return true;
                }
                case 1: 
            }
            parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
            b b2 = b.a.C(parcel.readStrongBinder());
            x x2 = parcel.readInt() != 0 ? x.CREATOR.b(parcel) : null;
            parcel = this.a(b2, x2, parcel.readString(), bb.a.i(parcel.readStrongBinder()), parcel.readInt());
            parcel2.writeNoException();
            parcel2.writeStrongBinder((IBinder)parcel);
            return true;
        }

        private static class a
        implements ad {
            private IBinder dU;

            a(IBinder iBinder) {
                this.dU = iBinder;
            }

            /*
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public IBinder a(b b2, x x2, String string2, bb bb2, int n2) throws RemoteException {
                Object var6_15 = null;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    void var5_14;
                    void var1_6;
                    void var4_13;
                    void var3_12;
                    void var2_11;
                    void var1_3;
                    parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    if (b2 != null) {
                        IBinder iBinder = b2.asBinder();
                    } else {
                        Object var1_8 = null;
                    }
                    parcel.writeStrongBinder((IBinder)var1_3);
                    if (var2_11 != null) {
                        parcel.writeInt(1);
                        var2_11.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    parcel.writeString((String)var3_12);
                    Object var1_4 = var6_15;
                    if (var4_13 != null) {
                        IBinder iBinder = var4_13.asBinder();
                    }
                    parcel.writeStrongBinder((IBinder)var1_6);
                    parcel.writeInt((int)var5_14);
                    this.dU.transact(1, parcel, parcel2, 0);
                    parcel2.readException();
                    IBinder iBinder = parcel2.readStrongBinder();
                    return iBinder;
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

