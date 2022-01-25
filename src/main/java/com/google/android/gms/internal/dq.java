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
import com.ea.ironmonkey.devmenu.util.Observer;

public interface dq
extends IInterface {
    void a(dp var1, int var2) throws RemoteException;

    void a(dp var1, int var2, String var3) throws RemoteException;

    void a(dp var1, int var2, String var3, Bundle var4) throws RemoteException;

    void a(dp var1, int var2, String var3, IBinder var4, Bundle var5) throws RemoteException;

    void a(dp var1, int var2, String var3, String var4, String[] var5) throws RemoteException;

    void a(dp var1, int var2, String var3, String var4, String[] var5, String var6, Bundle var7) throws RemoteException;

    void a(dp var1, int var2, String var3, String var4, String[] var5, String var6, IBinder var7, String var8, Bundle var9) throws RemoteException;

    void a(dp var1, int var2, String var3, String[] var4, String var5, Bundle var6) throws RemoteException;

    void b(dp var1, int var2, String var3, Bundle var4) throws RemoteException;

    void c(dp var1, int var2, String var3, Bundle var4) throws RemoteException;

    void d(dp var1, int var2, String var3, Bundle var4) throws RemoteException;

    void e(dp var1, int var2, String var3, Bundle var4) throws RemoteException;

    void f(dp var1, int var2, String var3, Bundle var4) throws RemoteException;

    void g(dp var1, int var2, String var3, Bundle var4) throws RemoteException;

    void h(dp var1, int var2, String var3, Bundle var4) throws RemoteException;

    void i(dp var1, int var2, String var3, Bundle var4) throws RemoteException;

    void j(dp var1, int var2, String var3, Bundle var4) throws RemoteException;

    void k(dp var1, int var2, String var3, Bundle var4) throws RemoteException;

    void l(dp var1, int var2, String var3, Bundle var4) throws RemoteException;

    void m(dp var1, int var2, String var3, Bundle var4) throws RemoteException;

    abstract class dq$a
    extends Binder
    implements dq {
        public static dq w(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (iInterface == null) return new a(iBinder);
            if (!(iInterface instanceof dq)) return new a(iBinder);
            return (dq)iInterface;
        }

        public boolean onTransact(int n2, Parcel object, Parcel parcel, int n3) throws RemoteException {
            Observer.onCallingMethod(Observer.Method.HARD_TO_RECOVER_LOGIC);
            return true;
        }

        private static class a
        implements dq {
            private IBinder dU;

            a(IBinder iBinder) {
                this.dU = iBinder;
            }

            @Override
            public void a(dp dp2, int n2) throws RemoteException {
                Observer.onCallingMethod(Observer.Method.HARD_TO_RECOVER_LOGIC);
            }

            @Override
            public void a(dp dp2, int n2, String string2) throws RemoteException {
                Observer.onCallingMethod(Observer.Method.HARD_TO_RECOVER_LOGIC);
            }

            /*
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public void a(dp dp2, int n2, String string2, Bundle bundle) throws RemoteException {
                Observer.onCallingMethod(Observer.Method.HARD_TO_RECOVER_LOGIC);
            }

            /*
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public void a(dp dp2, int n2, String string2, IBinder iBinder, Bundle bundle) throws RemoteException {
                Observer.onCallingMethod(Observer.Method.HARD_TO_RECOVER_LOGIC);
            }

            @Override
            public void a(dp dp2, int n2, String string2, String string3, String[] stringArray) throws RemoteException {
                Observer.onCallingMethod(Observer.Method.HARD_TO_RECOVER_LOGIC);
            }

            /*
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public void a(dp dp2, int n2, String string2, String string3, String[] stringArray, String string4, Bundle bundle) throws RemoteException {
                Observer.onCallingMethod(Observer.Method.HARD_TO_RECOVER_LOGIC);
            }

            /*
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public void a(dp dp2, int n2, String string2, String string3, String[] stringArray, String string4, IBinder iBinder, String string5, Bundle bundle) throws RemoteException {
                Observer.onCallingMethod(Observer.Method.HARD_TO_RECOVER_LOGIC);
            }

            /*
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public void a(dp dp2, int n2, String string2, String[] stringArray, String string3, Bundle bundle) throws RemoteException {
                Observer.onCallingMethod(Observer.Method.HARD_TO_RECOVER_LOGIC);
            }

            public IBinder asBinder() {
                return this.dU;
            }

            /*
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public void b(dp dp2, int n2, String string2, Bundle bundle) throws RemoteException {
                Observer.onCallingMethod(Observer.Method.HARD_TO_RECOVER_LOGIC);
            }

            /*
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public void c(dp dp2, int n2, String string2, Bundle bundle) throws RemoteException {
                Observer.onCallingMethod(Observer.Method.HARD_TO_RECOVER_LOGIC);
            }

            /*
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public void d(dp dp2, int n2, String string2, Bundle bundle) throws RemoteException {
                Observer.onCallingMethod(Observer.Method.HARD_TO_RECOVER_LOGIC);
            }

            /*
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public void e(dp dp2, int n2, String string2, Bundle bundle) throws RemoteException {
                Observer.onCallingMethod(Observer.Method.HARD_TO_RECOVER_LOGIC);
            }

            /*
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public void f(dp dp2, int n2, String string2, Bundle bundle) throws RemoteException {
                Observer.onCallingMethod(Observer.Method.HARD_TO_RECOVER_LOGIC);
            }

            /*
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public void g(dp dp2, int n2, String string2, Bundle bundle) throws RemoteException {
                Observer.onCallingMethod(Observer.Method.HARD_TO_RECOVER_LOGIC);
            }

            /*
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public void h(dp dp2, int n2, String string2, Bundle bundle) throws RemoteException {
                Observer.onCallingMethod(Observer.Method.HARD_TO_RECOVER_LOGIC);
            }

            /*
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public void i(dp dp2, int n2, String string2, Bundle bundle) throws RemoteException {
                Observer.onCallingMethod(Observer.Method.HARD_TO_RECOVER_LOGIC);
            }

            /*
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public void j(dp dp2, int n2, String string2, Bundle bundle) throws RemoteException {
                Observer.onCallingMethod(Observer.Method.HARD_TO_RECOVER_LOGIC);
            }

            /*
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public void k(dp dp2, int n2, String string2, Bundle bundle) throws RemoteException {
                Observer.onCallingMethod(Observer.Method.HARD_TO_RECOVER_LOGIC);
            }

            /*
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public void l(dp dp2, int n2, String string2, Bundle bundle) throws RemoteException {
                Observer.onCallingMethod(Observer.Method.HARD_TO_RECOVER_LOGIC);
            }

            /*
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public void m(dp dp2, int n2, String string2, Bundle bundle) throws RemoteException {
                Observer.onCallingMethod(Observer.Method.HARD_TO_RECOVER_LOGIC);
            }
        }
    }
}

