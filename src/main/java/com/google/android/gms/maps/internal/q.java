/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.IBinder
 *  android.os.RemoteException
 *  android.util.Log
 */
package com.google.android.gms.maps.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.du;
import com.google.android.gms.maps.internal.c;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class q {
    private static Context ye;
    private static c yf;

    private static <T> T a(ClassLoader classLoader, String string2) {
        try {
            classLoader = q.c(du.f(classLoader).loadClass(string2));
            return (T)classLoader;
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new IllegalStateException("Unable to find dynamic class " + string2);
        }
    }

    private static <T> T c(Class<?> clazz) {
        try {
            Object obj = clazz.newInstance();
            return (T)obj;
        }
        catch (InstantiationException instantiationException) {
            throw new IllegalStateException("Unable to instantiate the dynamic class " + clazz.getName());
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new IllegalStateException("Unable to call the default constructor of " + clazz.getName());
        }
    }

    private static boolean ef() {
        if (q.eg() == null) return false;
        return true;
    }

    private static Class<?> eg() {
        try {
            return Class.forName("com.google.android.gms.maps.internal.CreatorImpl");
        }
        catch (ClassNotFoundException classNotFoundException) {
            return null;
        }
    }

    private static Context getRemoteContext(Context context) {
        if (ye != null) return ye;
        if (q.ef()) {
            ye = context;
            return ye;
        }
        ye = GooglePlayServicesUtil.getRemoteContext(context);
        return ye;
    }

    public static c u(Context context) throws GooglePlayServicesNotAvailableException {
        du.f(context);
        if (yf != null) {
            return yf;
        }
        q.v(context);
        yf = q.w(context);
        try {
            yf.a(com.google.android.gms.dynamic.c.h(q.getRemoteContext(context).getResources()), 4132500);
            return yf;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    private static void v(Context context) throws GooglePlayServicesNotAvailableException {
        int n2 = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        switch (n2) {
            default: {
                throw new GooglePlayServicesNotAvailableException(n2);
            }
            case 0: 
        }
    }

    private static c w(Context context) {
        if (!q.ef()) return c.a.N((IBinder)q.a(q.getRemoteContext(context).getClassLoader(), "com.google.android.gms.maps.internal.CreatorImpl"));
        Log.i((String)q.class.getSimpleName(), (String)"Making Creator statically");
        return (c)q.c(q.eg());
    }
}

