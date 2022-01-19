/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.RemoteException
 *  android.os.SystemClock
 */
package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.os.SystemClock;
import com.google.android.gms.dynamic.c;
import com.google.android.gms.internal.at;
import com.google.android.gms.internal.au;
import com.google.android.gms.internal.aw;
import com.google.android.gms.internal.ay;
import com.google.android.gms.internal.bb;
import com.google.android.gms.internal.bc;
import com.google.android.gms.internal.bd;
import com.google.android.gms.internal.cr;
import com.google.android.gms.internal.cs;
import com.google.android.gms.internal.v;
import com.google.android.gms.internal.x;

public final class ax
implements ay.a {
    private final bb ed;
    private final v eq;
    private final String fR;
    private final long fS;
    private final at fT;
    private final x fU;
    private bc fV;
    private int fW = -2;
    private final Object fx = new Object();
    private final Context mContext;

    public ax(Context context, String string2, bb bb2, au au2, at at2, v v2, x x2) {
        this.mContext = context;
        this.fR = string2;
        this.ed = bb2;
        long l2 = au2.fJ != -1L ? au2.fJ : 10000L;
        this.fS = l2;
        this.fT = at2;
        this.eq = v2;
        this.fU = x2;
    }

    private bc V() {
        cs.t("Instantiating mediation adapter: " + this.fR);
        try {
            return this.ed.l(this.fR);
        }
        catch (RemoteException remoteException) {
            cs.a("Could not instantiate mediation adapter: " + this.fR, remoteException);
            return null;
        }
    }

    static /* synthetic */ bc a(ax ax2, bc bc2) {
        ax2.fV = bc2;
        return bc2;
    }

    private void a(long l2, long l3, long l4, long l5) {
        while (this.fW == -2) {
            this.b(l2, l3, l4, l5);
        }
        return;
    }

    private void a(aw aw2) {
        try {
            if (this.fU.eG) {
                this.fV.a(c.h(this.mContext), this.eq, this.fT.fH, this.fT.adJson, (bd)aw2);
                return;
            }
            this.fV.a(c.h(this.mContext), this.fU, this.eq, this.fT.fH, this.fT.adJson, aw2);
            return;
        }
        catch (RemoteException remoteException) {
            cs.b("Could not request ad from mediation adapter.", remoteException);
            this.f(5);
            return;
        }
    }

    private void b(long l2, long l3, long l4, long l5) {
        long l6 = SystemClock.elapsedRealtime();
        l2 = l3 - (l6 - l2);
        l3 = l5 - (l6 - l4);
        if (l2 <= 0L || l3 <= 0L) {
            cs.t("Timed out waiting for adapter.");
            this.fW = 3;
            return;
        }
        try {
            this.fx.wait(Math.min(l2, l3));
            return;
        }
        catch (InterruptedException interruptedException) {
            this.fW = -1;
            return;
        }
    }

    public ay b(long l2, long l3) {
        Object object = this.fx;
        synchronized (object) {
            long l4 = SystemClock.elapsedRealtime();
            final aw aw2 = new aw();
            cr.iE.post(new Runnable(){

                /*
                 * Enabled unnecessary exception pruning
                 */
                @Override
                public void run() {
                    Object object = ax.this.fx;
                    synchronized (object) {
                        if (ax.this.fW != -2) {
                            return;
                        }
                        ax.a(ax.this, ax.this.V());
                        if (ax.this.fV == null) {
                            ax.this.f(4);
                            return;
                        }
                        aw2.a(ax.this);
                        ax.this.a(aw2);
                        return;
                    }
                }
            });
            this.a(l4, this.fS, l2, l3);
            return new ay(this.fT, this.fV, this.fR, aw2, this.fW);
        }
    }

    /*
     * Unable to fully structure code
     */
    public void cancel() {
        var1_1 = this.fx;
        synchronized (var1_1) {
            try {
                if (this.fV != null) {
                    this.fV.destroy();
                }
lbl7:
                // 4 sources

                while (true) {
                    this.fW = -1;
                    this.fx.notify();
                    break;
                }
            }
            catch (RemoteException var2_2) {
                cs.b("Could not destroy mediation adapter.", var2_2);
                ** continue;
            }
            return;
        }
    }

    @Override
    public void f(int n2) {
        Object object = this.fx;
        synchronized (object) {
            this.fW = n2;
            this.fx.notify();
            return;
        }
    }
}

