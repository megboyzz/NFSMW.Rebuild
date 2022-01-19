/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.IBinder
 *  android.view.View
 */
package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.c;
import com.google.android.gms.internal.du;
import com.google.android.gms.internal.gn;
import com.google.android.gms.plus.PlusOneDummyView;

public final class gr {
    private static Context ye;
    private static gn zF;

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled unnecessary exception pruning
     */
    public static View a(Context context, int n2, int n3, String string2, int n4) {
        if (string2 != null) return (View)c.b(gr.x(context).a(c.h(context), n2, n3, string2, n4));
        try {
            throw new NullPointerException();
        }
        catch (Exception exception) {
            return new PlusOneDummyView(context, n2);
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled unnecessary exception pruning
     */
    public static View a(Context context, int n2, int n3, String string2, String string3) {
        if (string2 != null) return (View)c.b(gr.x(context).a(c.h(context), n2, n3, string2, string3));
        try {
            throw new NullPointerException();
        }
        catch (Exception exception) {
            return new PlusOneDummyView(context, n2);
        }
    }

    private static gn x(Context object) throws a {
        du.f(object);
        if (zF != null) return zF;
        if (ye == null && (ye = GooglePlayServicesUtil.getRemoteContext((Context)object)) == null) {
            throw new a("Could not get remote context.");
        }
        object = ye.getClassLoader();
        try {
            zF = gn.a.as((IBinder)((ClassLoader)object).loadClass("com.google.android.gms.plus.plusone.PlusOneButtonCreatorImpl").newInstance());
            return zF;
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
    }
}

