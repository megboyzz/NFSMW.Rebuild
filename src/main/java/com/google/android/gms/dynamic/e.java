/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.IBinder
 */
package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.du;

public abstract class e<T> {
    private final String pT;
    private T pU;

    protected e(String string2) {
        this.pT = string2;
    }

    protected abstract T d(IBinder var1);

    protected final T t(Context object) throws a {
        if (this.pU != null) return this.pU;
        du.f(object);
        object = GooglePlayServicesUtil.getRemoteContext((Context)object);
        if (object == null) {
            throw new a("Could not get remote context.");
        }
        object = object.getClassLoader();
        try {
            this.pU = this.d((IBinder)((ClassLoader)object).loadClass(this.pT).newInstance());
            return this.pU;
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new a("Could not load creator class.");
        }
        catch (InstantiationException instantiationException) {
            throw new a("Could not instantiate creator.");
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new a("Could not access creator.");
        }
    }

    public static class a
    extends Exception {
        public a(String string2) {
            super(string2);
        }

        public a(String string2, Throwable throwable) {
            super(string2, throwable);
        }
    }
}

