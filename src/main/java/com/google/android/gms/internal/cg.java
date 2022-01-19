/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal;

import com.google.android.gms.internal.an;
import com.google.android.gms.internal.cs;
import com.google.android.gms.internal.cv;
import java.util.Map;

public final class cg {
    private final Object fx = new Object();
    private cv gu;
    private String hI;
    public final an hJ = new an(){

        @Override
        public void a(cv object, Map<String, String> object2) {
            object = cg.this.fx;
            synchronized (object) {
                String string2 = object2.get("type");
                object2 = object2.get("errors");
                cs.v("Invalid " + string2 + " request error: " + (String)object2);
                cg.a(cg.this, 1);
                cg.this.fx.notify();
                return;
            }
        }
    };
    public final an hK = new an(){

        @Override
        public void a(cv object, Map<String, String> object2) {
            object = cg.this.fx;
            synchronized (object) {
                object2 = object2.get("url");
                if (object2 == null) {
                    cs.v("URL missing in loadAdUrl GMSG.");
                    return;
                }
                cg.a(cg.this, (String)object2);
                cg.this.fx.notify();
                return;
            }
        }
    };
    private int hk = -2;

    static /* synthetic */ int a(cg cg2, int n2) {
        cg2.hk = n2;
        return n2;
    }

    static /* synthetic */ String a(cg cg2, String string2) {
        cg2.hI = string2;
        return string2;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public String ap() {
        Object object = this.fx;
        synchronized (object) {
            while (this.hI == null) {
                int n2 = this.hk;
                if (n2 != -2) return this.hI;
                try {
                    this.fx.wait();
                }
                catch (InterruptedException interruptedException) {
                    cs.v("Ad request service was interrupted.");
                    return null;
                }
            }
            return this.hI;
        }
    }

    public void b(cv cv2) {
        Object object = this.fx;
        synchronized (object) {
            this.gu = cv2;
            return;
        }
    }

    public int getErrorCode() {
        Object object = this.fx;
        synchronized (object) {
            return this.hk;
        }
    }
}

