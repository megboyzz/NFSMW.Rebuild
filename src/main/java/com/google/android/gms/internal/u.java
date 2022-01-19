/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.IBinder
 *  android.os.RemoteException
 */
package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.c;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.internal.ac;
import com.google.android.gms.internal.ad;
import com.google.android.gms.internal.ba;
import com.google.android.gms.internal.cs;
import com.google.android.gms.internal.ct;
import com.google.android.gms.internal.r;
import com.google.android.gms.internal.x;

public final class u
extends e<ad> {
    private static final u ew = new u();

    private u() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    public static ac a(Context context, x x2, String string2, ba ba2) {
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) == 0) {
            ac ac2;
            ac ac3 = ac2 = ew.b(context, x2, string2, ba2);
            if (ac2 != null) return ac3;
        }
        cs.r("Using AdManager from the client jar.");
        return new r(context, x2, string2, ba2, new ct(4132500, 4132500, true));
    }

    private ac b(Context object, x x2, String string2, ba ba2) {
        try {
            b b2 = c.h(object);
            return ac.a.f(((ad)this.t((Context)object)).a(b2, x2, string2, ba2, 4132500));
        }
        catch (RemoteException remoteException) {
            cs.b("Could not create remote AdManager.", remoteException);
            return null;
        }
        catch (e.a a2) {
            cs.b("Could not create remote AdManager.", a2);
            return null;
        }
    }

    protected ad c(IBinder iBinder) {
        return ad.a.g(iBinder);
    }

    @Override
    protected /* synthetic */ Object d(IBinder iBinder) {
        return this.c(iBinder);
    }
}

