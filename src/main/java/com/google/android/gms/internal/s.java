/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal;

import com.google.android.gms.internal.cr;
import com.google.android.gms.internal.cs;
import com.google.android.gms.internal.r;
import com.google.android.gms.internal.v;
import java.lang.ref.WeakReference;

public final class s {
    private final Runnable ep;
    private v eq;
    private boolean er = false;

    public s(final r r2) {
        this.ep = new Runnable(){
            private final WeakReference<r> es;
            {
                this.es = new WeakReference<r>(r2);
            }

            @Override
            public void run() {
                s.a(s.this, false);
                r r22 = (r)this.es.get();
                if (r22 == null) return;
                r22.b(s.this.eq);
            }
        };
    }

    static /* synthetic */ boolean a(s s2, boolean bl2) {
        s2.er = bl2;
        return bl2;
    }

    public void a(v v2, long l2) {
        if (this.er) {
            cs.v("An ad refresh is already scheduled.");
            return;
        }
        cs.t("Scheduling ad refresh " + l2 + " milliseconds from now.");
        this.eq = v2;
        this.er = true;
        cr.iE.postDelayed(this.ep, l2);
    }

    public void cancel() {
        cr.iE.removeCallbacks(this.ep);
    }

    public void d(v v2) {
        this.a(v2, 60000L);
    }
}

