/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.RemoteException
 */
package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.internal.at;
import com.google.android.gms.internal.au;
import com.google.android.gms.internal.ax;
import com.google.android.gms.internal.ay;
import com.google.android.gms.internal.bb;
import com.google.android.gms.internal.bz;
import com.google.android.gms.internal.cr;
import com.google.android.gms.internal.cs;
import java.util.Iterator;

public final class as {
    private final bb ed;
    private ax fA;
    private final bz fw;
    private final Object fx = new Object();
    private final au fy;
    private boolean fz = false;
    private final Context mContext;

    public as(Context context, bz bz2, bb bb2, au au2) {
        this.mContext = context;
        this.fw = bz2;
        this.ed = bb2;
        this.fy = au2;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public ay a(long l2, long l3) {
        cs.r("Starting mediation.");
        Iterator<at> iterator = this.fy.fI.iterator();
        block3: while (iterator.hasNext()) {
            at at2 = iterator.next();
            cs.t("Trying mediation network: " + at2.fD);
            Iterator<String> iterator2 = at2.fE.iterator();
            while (true) {
                if (!iterator2.hasNext()) continue block3;
                String string2 = iterator2.next();
                Object object = this.fx;
                synchronized (object) {
                    if (this.fz) {
                        return new ay(-1);
                    }
                    this.fA = new ax(this.mContext, string2, this.ed, this.fy, at2, this.fw.hp, this.fw.em);
                }
                object = this.fA.b(l2, l3);
                if (((ay)object).fZ == 0) {
                    cs.r("Adapter succeeded.");
                    return object;
                }
                if (((ay)object).gb == null) continue;
                cr.iE.post(new Runnable((ay)object){
                    final /* synthetic */ ay fB;
                    {
                        this.fB = ay2;
                    }

                    @Override
                    public void run() {
                        try {
                            this.fB.gb.destroy();
                            return;
                        }
                        catch (RemoteException remoteException) {
                            cs.b("Could not destroy mediation adapter.", remoteException);
                            return;
                        }
                    }
                });
            }
            break;
        }
        return new ay(1);
    }

    public void cancel() {
        Object object = this.fx;
        synchronized (object) {
            this.fz = true;
            if (this.fA == null) return;
            this.fA.cancel();
            return;
        }
    }
}

