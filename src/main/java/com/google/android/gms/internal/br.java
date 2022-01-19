/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.IBinder
 *  android.os.RemoteException
 */
package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.c;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.internal.bk;
import com.google.android.gms.internal.bs;
import com.google.android.gms.internal.bt;
import com.google.android.gms.internal.cs;

public final class br
extends e<bt> {
    private static final br gZ = new br();

    private br() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    public static bs a(Activity object) {
        try {
            if (!br.b(object)) return gZ.c((Activity)object);
            cs.r("Using AdOverlay from the client jar.");
            return new bk((Activity)object);
        }
        catch (a a2) {
            cs.v(a2.getMessage());
            return null;
        }
    }

    private static boolean b(Activity activity) throws a {
        if ((activity = activity.getIntent()).hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) return activity.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        throw new a("Ad overlay requires the useClientJar flag in intent extras.");
    }

    private bs c(Activity object) {
        try {
            b b2 = c.h(object);
            return bs.a.m(((bt)this.t((Context)object)).a(b2));
        }
        catch (RemoteException remoteException) {
            cs.b("Could not create remote AdOverlay.", remoteException);
            return null;
        }
        catch (e.a a2) {
            cs.b("Could not create remote AdOverlay.", a2);
            return null;
        }
    }

    @Override
    protected /* synthetic */ Object d(IBinder iBinder) {
        return this.l(iBinder);
    }

    protected bt l(IBinder iBinder) {
        return bt.a.n(iBinder);
    }

    private static final class a
    extends Exception {
        public a(String string2) {
            super(string2);
        }
    }
}

