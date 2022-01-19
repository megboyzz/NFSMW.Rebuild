/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.bx;
import com.google.android.gms.internal.bz;
import com.google.android.gms.internal.cb;
import com.google.android.gms.internal.cl;
import com.google.android.gms.internal.cs;

public final class bw {
    public static cl a(Context context, bz bz2, a a2) {
        if (!bz2.ej.iI) return bw.c(context, bz2, a2);
        return bw.b(context, bz2, a2);
    }

    private static cl b(Context object, bz bz2, a a2) {
        cs.r("Fetching ad response from local ad request service.");
        object = new bx.a((Context)object, bz2, a2);
        ((cl)object).start();
        return object;
    }

    private static cl c(Context context, bz bz2, a a2) {
        cs.r("Fetching ad response from remote ad request service.");
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) == 0) return new bx.b(context, bz2, a2);
        cs.v("Failed to connect to remote ad request service.");
        return null;
    }

    public static interface a {
        public void a(cb var1);
    }
}

