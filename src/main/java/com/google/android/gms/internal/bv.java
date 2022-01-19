/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.SystemClock
 *  android.text.TextUtils
 *  org.json.JSONException
 */
package com.google.android.gms.internal;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.internal.as;
import com.google.android.gms.internal.at;
import com.google.android.gms.internal.au;
import com.google.android.gms.internal.aw;
import com.google.android.gms.internal.ay;
import com.google.android.gms.internal.bb;
import com.google.android.gms.internal.bc;
import com.google.android.gms.internal.bu;
import com.google.android.gms.internal.bw;
import com.google.android.gms.internal.bz;
import com.google.android.gms.internal.cb;
import com.google.android.gms.internal.cj;
import com.google.android.gms.internal.cl;
import com.google.android.gms.internal.cn;
import com.google.android.gms.internal.cr;
import com.google.android.gms.internal.cs;
import com.google.android.gms.internal.cv;
import com.google.android.gms.internal.cw;
import com.google.android.gms.internal.h;
import com.google.android.gms.internal.v;
import com.google.android.gms.internal.x;
import java.util.List;
import org.json.JSONException;

public final class bv
extends cl
implements bw.a,
cw.a {
    private final bb ed;
    private final Object fx = new Object();
    private au fy;
    private final cv gu;
    private final bu.a ha;
    private final bz.a hb;
    private final h hc;
    private cl hd;
    private cb he;
    private boolean hf = false;
    private as hg;
    private ay hh;
    private final Context mContext;

    public bv(Context context, bz.a a2, h h2, cv cv2, bb bb2, bu.a a3) {
        this.ed = bb2;
        this.ha = a3;
        this.gu = cv2;
        this.mContext = context;
        this.hb = a2;
        this.hc = h2;
    }

    private x a(bz bz2) throws a {
        int n2;
        int n3;
        if (this.he.hz == null) {
            throw new a("The ad response must specify one of the supported ad sizes.", 0);
        }
        Object[] objectArray = this.he.hz.split("x");
        if (objectArray.length != 2) {
            throw new a("Could not parse the ad size from the ad response: " + this.he.hz, 0);
        }
        try {
            n3 = Integer.parseInt(objectArray[0]);
            n2 = Integer.parseInt(objectArray[1]);
        }
        catch (NumberFormatException numberFormatException) {
            throw new a("Could not parse the ad size from the ad response: " + this.he.hz, 0);
        }
        objectArray = bz2.em.eH;
        int n4 = objectArray.length;
        int n5 = 0;
        while (n5 < n4) {
            Object object = objectArray[n5];
            float f2 = this.mContext.getResources().getDisplayMetrics().density;
            int n6 = ((x)object).width == -1 ? (int)((float)((x)object).widthPixels / f2) : ((x)object).width;
            int n7 = ((x)object).height == -2 ? (int)((float)((x)object).heightPixels / f2) : ((x)object).height;
            if (n3 == n6 && n2 == n7) {
                return new x((x)object, bz2.em.eH);
            }
            ++n5;
        }
        throw new a("The ad size from the ad response was not one of the requested sizes: " + this.he.hz, 0);
    }

    private void a(bz bz2, long l2) throws a {
        this.hg = new as(this.mContext, bz2, this.ed, this.fy);
        this.hh = this.hg.a(l2, 60000L);
        switch (this.hh.fZ) {
            default: {
                throw new a("Unexpected mediation result: " + this.hh.fZ, 0);
            }
            case 1: {
                throw new a("No fill from any mediation ad networks.", 3);
            }
            case 0: 
        }
    }

    private void aj() throws a {
        if (this.he.errorCode == -3) {
            return;
        }
        if (TextUtils.isEmpty((CharSequence)this.he.hu)) {
            throw new a("No fill from ad server.", 3);
        }
        if (!this.he.hw) return;
        try {
            this.fy = new au(this.he.hu);
            return;
        }
        catch (JSONException jSONException) {
            throw new a("Could not parse mediation config: " + this.he.hu, 0);
        }
    }

    private void b(long l2) throws a {
        cr.iE.post(new Runnable(){

            /*
             * Enabled unnecessary exception pruning
             */
            @Override
            public void run() {
                Object object = bv.this.fx;
                synchronized (object) {
                    if (((bv)bv.this).he.errorCode != -2) {
                        return;
                    }
                    bv.this.gu.aB().a(bv.this);
                    if (((bv)bv.this).he.errorCode == -3) {
                        cs.u("Loading URL in WebView: " + ((bv)bv.this).he.gK);
                        bv.this.gu.loadUrl(((bv)bv.this).he.gK);
                    } else {
                        cs.u("Loading HTML in WebView.");
                        bv.this.gu.loadDataWithBaseURL(cn.o(((bv)bv.this).he.gK), ((bv)bv.this).he.hu, "text/html", "UTF-8", null);
                    }
                    return;
                }
            }
        });
        this.d(l2);
    }

    private void c(long l2) throws a {
        do {
            if (this.e(l2)) continue;
            throw new a("Timed out waiting for ad response.", 2);
        } while (this.he == null);
        this.hd = null;
        if (this.he.errorCode == -2) return;
        if (this.he.errorCode == -3) return;
        throw new a("There was a problem getting an ad response. ErrorCode: " + this.he.errorCode, this.he.errorCode);
    }

    private void d(long l2) throws a {
        do {
            if (this.e(l2)) continue;
            throw new a("Timed out waiting for WebView to finish loading.", 2);
        } while (!this.hf);
    }

    private boolean e(long l2) throws a {
        l2 = 60000L - (SystemClock.elapsedRealtime() - l2);
        if (l2 <= 0L) {
            return false;
        }
        try {
            this.fx.wait(l2);
            return true;
        }
        catch (InterruptedException interruptedException) {
            throw new a("Ad request cancelled.", -1);
        }
    }

    @Override
    public void a(cb cb2) {
        Object object = this.fx;
        synchronized (object) {
            cs.r("Received ad response.");
            this.he = cb2;
            this.fx.notify();
            return;
        }
    }

    @Override
    public void a(cv object) {
        object = this.fx;
        synchronized (object) {
            cs.r("WebView finished loading.");
            this.hf = true;
            this.fx.notify();
            return;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    @Override
    public void ai() {
        Object object = this.fx;
        synchronized (object) {
            long l2;
            cs.r("AdLoaderBackgroundTask started.");
            Object object2 = this.hc.g().a(this.mContext);
            Object object3 = new bz(this.hb, (String)object2);
            object2 = null;
            Object object4 = null;
            int n2 = -2;
            Object object5 = object4;
            try {
                l2 = SystemClock.elapsedRealtime();
                object5 = object4;
                this.hd = bw.a(this.mContext, (bz)object3, this);
                object5 = object4;
                if (this.hd == null) {
                    object5 = object4;
                    throw new a("Could not start the ad request service.", 0);
                }
                object5 = object4;
                this.c(l2);
                object5 = object4;
                this.aj();
                object5 = object4;
                if (((bz)object3).em.eH != null) {
                    object5 = object4;
                    object2 = this.a((bz)object3);
                }
                object5 = object2;
                if (this.he.hw) {
                    object5 = object2;
                    this.a((bz)object3, l2);
                } else {
                    object5 = object2;
                    this.b(l2);
                }
            }
            catch (a a2) {
                n2 = a2.getErrorCode();
                if (n2 == 3 || n2 == -1) {
                    cs.t(a2.getMessage());
                } else {
                    cs.v(a2.getMessage());
                }
                this.he = new cb(n2);
                cr.iE.post(new Runnable(){

                    @Override
                    public void run() {
                        bv.this.onStop();
                    }
                });
                object2 = object5;
            }
            v v2 = ((bz)object3).hp;
            cv cv2 = this.gu;
            List<String> list = this.he.fK;
            List<String> list2 = this.he.fL;
            List<String> list3 = this.he.hy;
            int n3 = this.he.orientation;
            l2 = this.he.fO;
            String string2 = ((bz)object3).hs;
            boolean bl2 = this.he.hw;
            object5 = this.hh != null ? this.hh.ga : null;
            object4 = this.hh != null ? this.hh.gb : null;
            object3 = this.hh != null ? this.hh.gc : null;
            au au2 = this.fy;
            aw aw2 = this.hh != null ? this.hh.gd : null;
            object2 = new cj(v2, cv2, list, n2, list2, list3, n3, l2, string2, bl2, (at)object5, (bc)object4, (String)object3, au2, aw2, this.he.hx, (x)object2, this.he.hv);
            cr.iE.post(new Runnable((cj)object2){
                final /* synthetic */ cj hj;
                {
                    this.hj = cj2;
                }

                @Override
                public void run() {
                    Object object = bv.this.fx;
                    synchronized (object) {
                        bv.this.ha.a(this.hj);
                        return;
                    }
                }
            });
            return;
        }
    }

    @Override
    public void onStop() {
        Object object = this.fx;
        synchronized (object) {
            if (this.hd != null) {
                this.hd.cancel();
            }
            this.gu.stopLoading();
            cn.a(this.gu);
            if (this.hg == null) return;
            this.hg.cancel();
            return;
        }
    }

    private static final class a
    extends Exception {
        private final int hk;

        public a(String string2, int n2) {
            super(string2);
            this.hk = n2;
        }

        public int getErrorCode() {
            return this.hk;
        }
    }
}

