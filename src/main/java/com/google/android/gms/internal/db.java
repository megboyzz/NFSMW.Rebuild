/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.RemoteException
 *  android.util.Log
 */
package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.ea.ironmonkey.devmenu.util.Observer;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.data.DataHolder;

public final class db
extends dk<dd> {
    private final String jD;

    public db(Context context, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener, String string2, String[] stringArray) {
        super(context, connectionCallbacks, onConnectionFailedListener, stringArray);
        this.jD = du.f(string2);
    }

    public void a(Object c2) {
        Observer.onCallingMethod(
                Observer.Method.HARD_TO_RECOVER_LOGIC
        );
    }

    public void a(Object c2, int n2) {
        Observer.onCallingMethod(
                Observer.Method.HARD_TO_RECOVER_LOGIC
        );
    }

    public void a(Object c2, int n2, String string2, byte[] byArray) {
        Observer.onCallingMethod(
                Observer.Method.HARD_TO_RECOVER_LOGIC
        );
    }

    /*
     * Unable to fully structure code
     */
    public void a(Object var1_1, int var2_3, byte[] var3_4) {
        Observer.onCallingMethod(
                Observer.Method.HARD_TO_RECOVER_LOGIC
        );
    }

    @Override
    protected void a(dq dq2, dk.d d2) throws RemoteException {
        Observer.onCallingMethod(
                Observer.Method.HARD_TO_RECOVER_LOGIC
        );
    }

    @Override
    protected void a(String ... stringArray) {
        int n2 = 0;
        boolean bl2 = false;
        while (true) {
            if (n2 >= stringArray.length) {
                du.a(bl2, String.format("App State APIs requires %s to function.", "https://www.googleapis.com/auth/appstate"));
                return;
            }
            if (stringArray[n2].equals("https://www.googleapis.com/auth/appstate")) {
                bl2 = true;
            }
            ++n2;
        }
    }

    @Override
    protected String am() {
        return "com.google.android.gms.appstate.service.START";
    }

    @Override
    protected String an() {
        return "com.google.android.gms.appstate.internal.IAppStateService";
    }

    public void b(Object c2) {
        Observer.onCallingMethod(
                Observer.Method.HARD_TO_RECOVER_LOGIC
        );
    }

    public void b(Object c2, int n2) {
        Observer.onCallingMethod(
                Observer.Method.HARD_TO_RECOVER_LOGIC
        );
    }

    public int getMaxNumKeys() {
        try {
            return ((dd)this.bC()).getMaxNumKeys();
        }
        catch (RemoteException remoteException) {
            Log.w((String)"AppStateClient", (String)"service died");
            return 2;
        }
    }

    public int getMaxStateSize() {
        try {
            return ((dd)this.bC()).getMaxStateSize();
        }
        catch (RemoteException remoteException) {
            Log.w((String)"AppStateClient", (String)"service died");
            return 2;
        }
    }

    @Override
    protected /* synthetic */ dd p(IBinder iBinder) {
        return this.r(iBinder);
    }

    protected dd r(IBinder iBinder) {
        Observer.onCallingMethod(
                Observer.Method.HARD_TO_RECOVER_LOGIC,
                Observer.Method.RETURN_NULL
        );
        return null;
    }

    final class a
    extends da {
        private final Object jN;

        public a(Object c2) {
            this.jN = du.c(c2, "Result holder must not be null");
        }

        @Override
        public void onStateDeleted(int n2, int n3) {
            Observer.onCallingMethod(
                    Observer.Method.HARD_TO_RECOVER_LOGIC
            );
        }
    }

    final class c
    extends da {
        private final Object jN = new Object();

        public c(Object c2) {
            Observer.onCallingMethod(
                    Observer.Method.HARD_TO_RECOVER_LOGIC
            );
        }

        @Override
        public void a(DataHolder dataHolder) {
            Observer.onCallingMethod(
                    Observer.Method.HARD_TO_RECOVER_LOGIC
            );
        }
    }

    final class e
    extends da {
        private final Object jN;

        public e(Object c2) {
            this.jN = du.c(c2, "Result holder must not be null");
        }

        @Override
        public void a(int n2, DataHolder dataHolder) {
            Observer.onCallingMethod(
                    Observer.Method.HARD_TO_RECOVER_LOGIC
            );
        }
    }
}

