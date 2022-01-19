/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.google.android.gms.common.data;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.a;
import java.util.Iterator;

public abstract class DataBuffer<T>
implements Iterable<T> {
    protected final DataHolder lb;

    protected DataBuffer(DataHolder dataHolder) {
        this.lb = dataHolder;
        if (this.lb == null) return;
        this.lb.c(this);
    }

    public void close() {
        if (this.lb == null) return;
        this.lb.close();
    }

    public int describeContents() {
        return 0;
    }

    public abstract T get(int var1);

    public int getCount() {
        if (this.lb != null) return this.lb.getCount();
        return 0;
    }

    public Bundle getMetadata() {
        return this.lb.getMetadata();
    }

    public boolean isClosed() {
        if (this.lb != null) return this.lb.isClosed();
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return new a(this);
    }
}

