/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  android.util.Log
 *  android.util.Pair
 */
package com.google.android.gms.common.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.du;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class a {

    public static abstract class a<R extends Result, C, A extends Api.a>
    implements GoogleApiClient.a<A>,
    PendingResult<R, C>,
    c<R> {
        private final Api.b<A> ks;
        private final Object kt = new Object();
        private final b<R, C> ku;
        private final CountDownLatch kv = new CountDownLatch(1);
        private final ArrayList<PendingResult.a> kw = new ArrayList();
        private final ArrayList<C> kx = new ArrayList();
        private R ky;
        private boolean kz;

        public a(Api.b<A> b2) {
            this.ks = b2;
            this.ku = new b<R, C>(){

                @Override
                protected void a(C c2, R r2) {
                    a.this.a(c2, r2);
                }
            };
        }

        private void aX() {
            if (this.ky == null) return;
            if (!(this.ky instanceof Releasable)) return;
            ((Releasable)this.ky).release();
        }

        @Override
        public final void a(A a2) {
            this.b(a2);
        }

        /*
         * Enabled unnecessary exception pruning
         */
        @Override
        public final void a(R object) {
            boolean bl2 = !this.isReady();
            du.a(bl2, "Results have already been reported.");
            Object object2 = this.kt;
            synchronized (object2) {
                this.ky = object;
                this.kv.countDown();
                if (!this.kz) {
                    for (Object e2 : this.kx) {
                        this.ku.b(e2, this.ky);
                    }
                }
                object = this.kw.iterator();
                while (true) {
                    if (!object.hasNext()) {
                        this.kx.clear();
                        this.kw.clear();
                        if (!this.kz) return;
                        this.aX();
                        return;
                    }
                    ((PendingResult.a)object.next()).c(this.ky.getStatus());
                }
            }
        }

        protected abstract void a(C var1, R var2);

        @Override
        public final Api.b<A> aV() {
            return this.ks;
        }

        @Override
        public final void addResultCallback(C c2) {
            Object object = this.kt;
            synchronized (object) {
                if (this.isReady()) {
                    if (this.kz) return;
                    this.ku.b(c2, this.ky);
                } else {
                    this.kx.add(c2);
                }
                return;
            }
        }

        @Override
        public final R await() {
            boolean bl2 = !this.kz;
            du.a(bl2, "Results have already been released.");
            try {
                this.kv.await();
            }
            catch (InterruptedException interruptedException) {
                this.a((R)this.b(Status.kX));
            }
            du.a(this.isReady(), "Result is not ready.");
            return this.ky;
        }

        @Override
        public final R await(long l2, TimeUnit timeUnit) {
            boolean bl2 = !this.kz;
            du.a(bl2, "Results have already been released.");
            try {
                if (!this.kv.await(l2, timeUnit)) {
                    this.a((R)this.b(Status.kY));
                }
            }
            catch (InterruptedException interruptedException) {
                this.a((R)this.b(Status.kX));
            }
            du.a(this.isReady(), "Result is not ready.");
            return this.ky;
        }

        protected abstract void b(A var1);

        public final boolean isReady() {
            if (this.kv.getCount() != 0L) return false;
            return true;
        }

        @Override
        public final void release() {
            Object object = this.kt;
            synchronized (object) {
                this.kz = true;
                this.aX();
                return;
            }
        }
    }

    static abstract class b<R, C>
    extends Handler {
        public b() {
            this(Looper.getMainLooper());
        }

        public b(Looper looper) {
            super(looper);
        }

        protected abstract void a(C var1, R var2);

        public void b(C c2, R r2) {
            this.sendMessage(this.obtainMessage(1, new Pair(c2, r2)));
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                default: {
                    Log.wtf((String)"GoogleApi", (String)"Don't know how to handle this message.");
                    return;
                }
                case 1: 
            }
            message = (Pair)message.obj;
            this.a(message.first, message.second);
        }
    }

    public static interface c<R> {
        public void a(R var1);
    }
}

