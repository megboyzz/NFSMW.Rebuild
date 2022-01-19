/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Process
 */
package com.google.android.gms.internal;

import android.os.Process;
import com.google.android.gms.internal.cs;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class cm {
    private static final ThreadFactory iv = new ThreadFactory(){
        private final AtomicInteger iy = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "AdWorker #" + this.iy.getAndIncrement());
        }
    };
    private static final ThreadPoolExecutor iw = new ThreadPoolExecutor(0, 10, 65L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(true), iv);

    public static void execute(final Runnable runnable) {
        try {
            iw.execute(new Runnable(){

                @Override
                public void run() {
                    Process.setThreadPriority((int)10);
                    runnable.run();
                }
            });
            return;
        }
        catch (RejectedExecutionException rejectedExecutionException) {
            cs.b("Too many background threads already running. Aborting task.", rejectedExecutionException);
            return;
        }
    }
}

