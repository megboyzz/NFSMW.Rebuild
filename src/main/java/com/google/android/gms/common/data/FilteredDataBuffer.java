/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.google.android.gms.common.data;

import android.os.Bundle;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.internal.dg;

public abstract class FilteredDataBuffer<T>
extends DataBuffer<T> {
    protected final DataBuffer<T> mDataBuffer;

    public FilteredDataBuffer(DataBuffer<T> dataBuffer) {
        super(null);
        dg.d(dataBuffer);
        this.mDataBuffer = dataBuffer;
    }

    @Override
    public void close() {
        this.mDataBuffer.close();
    }

    protected abstract int computeRealPosition(int var1);

    @Override
    public T get(int n2) {
        return this.mDataBuffer.get(this.computeRealPosition(n2));
    }

    @Override
    public Bundle getMetadata() {
        return this.mDataBuffer.getMetadata();
    }

    @Override
    public boolean isClosed() {
        return this.mDataBuffer.isClosed();
    }
}

