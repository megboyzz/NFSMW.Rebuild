/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.util.concurrent.TimeUnit;

public interface PendingResult<R extends Result, C>
extends Releasable {
    public void addResultCallback(C var1);

    public R await();

    public R await(long var1, TimeUnit var3);

    public R b(Status var1);

    @Override
    public void release();

    public static interface a {
        public void c(Status var1);
    }
}

