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
import com.google.android.gms.dynamic.b;

public interface ad
extends IInterface {
    IBinder a(b var1, x var2, String var3, bb var4, int var5) throws RemoteException;

    abstract class ad$a
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
            Observer.onCallingMethod(Observer.Method.HARD_TO_RECOVER_LOGIC);
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
                Observer.onCallingMethod(
                        Observer.Method.HARD_TO_RECOVER_LOGIC,
                        Observer.Method.RETURN_NULL
                        );
                return null;
            }

            public IBinder asBinder() {
                return this.dU;
            }
        }
    }
}

