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
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.c;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.internal.dr;

public final class dv
extends e<dr> {
    private static final dv nj = new dv();

    private dv() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    public static View d(Context context, int n2, int n3) throws e.a {
        return nj.e(context, n2, n3);
    }

    private View e(Context context, int n2, int n3) throws e.a {
        try {
            b b2 = c.h(context);
            return (View)c.b(((dr)this.t(context)).a(b2, n2, n3));
        }
        catch (Exception exception) {
            throw new e.a("Could not get button with size " + n2 + " and color " + n3, exception);
        }
    }

    @Override
    public /* synthetic */ Object d(IBinder iBinder) {
        return this.y(iBinder);
    }

    public dr y(IBinder iBinder) {
        return dr.a.x(iBinder);
    }
}

