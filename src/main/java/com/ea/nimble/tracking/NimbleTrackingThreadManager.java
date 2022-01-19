/*
 * Decompiled with CFR 0.152.
 */
package com.ea.nimble.tracking;

import com.ea.nimble.Log;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class NimbleTrackingThreadManager {
    private static NimbleTrackingThreadManager s_instance;
    private static int s_instanceRefs;
    private ScheduledExecutorService m_executor = new ScheduledThreadPoolExecutor(1){

        @Override
        protected void afterExecute(Runnable object, Throwable throwable) {
            super.afterExecute((Runnable)object, throwable);
            Throwable throwable2 = throwable;
            if (throwable == null) {
                throwable2 = throwable;
                if (object instanceof Future) {
                    object = (Future)object;
                    throwable2 = throwable;
                    if (!object.isCancelled()) {
                        try {
                            object.get();
                            throwable2 = throwable;
                        }
                        catch (ExecutionException executionException) {
                            throwable2 = executionException.getCause();
                        }
                        catch (InterruptedException interruptedException) {
                            Thread.currentThread().interrupt();
                            throwable2 = throwable;
                        }
                    }
                }
            }
            if (throwable2 == null) return;
            if (throwable2 instanceof Error) {
                throw (Error)throwable2;
            }
            if (throwable2 instanceof RuntimeException) {
                throw (RuntimeException)throwable2;
            }
            Log.Helper.LOGES("TrackingThreadManager", "Checked exception thrown from Tracking thread:", new Object[0]);
            throwable2.printStackTrace();
        }
    };

    NimbleTrackingThreadManager() {
    }

    static NimbleTrackingThreadManager acquireInstance() {
        if (s_instance == null) {
            s_instance = new NimbleTrackingThreadManager();
        }
        ++s_instanceRefs;
        return s_instance;
    }

    static void releaseInstance() {
        if (--s_instanceRefs != 0) return;
        s_instance.shutdown();
        s_instance = null;
    }

    private void shutdown() {
        this.m_executor.shutdown();
    }

    ScheduledFuture<?> createTimer(double d2, Runnable runnable) {
        return this.m_executor.schedule(runnable, (long)(1000.0 * d2), TimeUnit.MILLISECONDS);
    }

    void runInWorkerThread(Runnable runnable) {
        this.runInWorkerThread(false, runnable);
    }

    void runInWorkerThread(boolean bl2, Runnable object) {
        if (!bl2) {
            this.m_executor.execute((Runnable)object);
            return;
        }
        object = this.m_executor.submit((Runnable)object);
        try {
            object.get();
            return;
        }
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
            return;
        }
        catch (ExecutionException executionException) {
            return;
        }
    }
}

