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

public interface bc
extends IInterface {
    void a(b var1, v var2, String var3, bd var4) throws RemoteException;

    void a(b var1, v var2, String var3, String var4, bd var5) throws RemoteException;

    void a(b var1, x var2, v var3, String var4, bd var5) throws RemoteException;

    void a(b var1, x var2, v var3, String var4, String var5, bd var6) throws RemoteException;

    void destroy() throws RemoteException;

    b getView() throws RemoteException;

    void showInterstitial() throws RemoteException;

    static abstract class bc$a
    extends Binder
    implements bc {
        public bc$a() {
            this.attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        }

        public static bc j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            if (iInterface == null) return new a(iBinder);
            if (!(iInterface instanceof bc)) return new a(iBinder);
            return (bc)iInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int n2, Parcel object, Parcel parcel, int n3) throws RemoteException {
            Observer.onCallingMethod(
                    Observer.Method.HARD_TO_RECOVER_LOGIC
            );
            return true;
        }

        private static class a
        implements bc {
            private IBinder dU;

            a(IBinder iBinder) {
                this.dU = iBinder;
            }

            /*
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public void a(b b2, v v2, String string2, bd bd2) throws RemoteException {
                Observer.onCallingMethod(
                        Observer.Method.HARD_TO_RECOVER_LOGIC
                );
            }

            /*
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public void a(b b2, v v2, String string2, String string3, bd bd2) throws RemoteException {
                Observer.onCallingMethod(
                        Observer.Method.HARD_TO_RECOVER_LOGIC
                );
            }

            /*
             * Enabled unnecessary exception pruning
             */
            @Override
            public void a(b b2, x x2, v v2, String string2, bd bd2) throws RemoteException {
                Observer.onCallingMethod(
                        Observer.Method.HARD_TO_RECOVER_LOGIC
                );
            }

            /*
             * Enabled unnecessary exception pruning
             */
            @Override
            public void a(b b2, x x2, v v2, String string2, String string3, bd bd2) throws RemoteException {
                Observer.onCallingMethod(
                        Observer.Method.HARD_TO_RECOVER_LOGIC
                );
            }

            public IBinder asBinder() {
                return this.dU;
            }

            @Override
            public void destroy() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.dU.transact(5, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public b getView() throws RemoteException {
                Observer.onCallingMethod(
                        Observer.Method.HARD_TO_RECOVER_LOGIC,
                        Observer.Method.RETURN_NULL
                );
                return null;
            }

            @Override
            public void showInterstitial() throws RemoteException {
                Observer.onCallingMethod(
                        Observer.Method.HARD_TO_RECOVER_LOGIC
                );
            }
        }
    }
}

