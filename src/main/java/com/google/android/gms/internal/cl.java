/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal;

import com.google.android.gms.internal.cm;

public abstract class cl {
    private final Runnable ep = new Runnable(){

        @Override
        public final void run() {
            cl.a(cl.this, Thread.currentThread());
            cl.this.ai();
        }
    };
    private volatile Thread it;

    static /* synthetic */ Thread a(cl cl2, Thread thread) {
        cl2.it = thread;
        return thread;
    }

    public abstract void ai();

    public final void cancel() {
        this.onStop();
        if (this.it == null) return;
        this.it.interrupt();
    }

    public abstract void onStop();

    public final void start() {
        cm.execute(this.ep);
    }
}

