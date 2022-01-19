/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.common.data;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.internal.du;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class a<T>
implements Iterator<T> {
    private int lc;
    private final DataBuffer<T> mDataBuffer;

    public a(DataBuffer<T> dataBuffer) {
        this.mDataBuffer = du.f(dataBuffer);
        this.lc = -1;
    }

    @Override
    public boolean hasNext() {
        if (this.lc >= this.mDataBuffer.getCount() - 1) return false;
        return true;
    }

    @Override
    public T next() {
        int n2;
        if (!this.hasNext()) {
            throw new NoSuchElementException("Cannot advance the iterator beyond " + this.lc);
        }
        DataBuffer<T> dataBuffer = this.mDataBuffer;
        this.lc = n2 = this.lc + 1;
        return dataBuffer.get(n2);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}

