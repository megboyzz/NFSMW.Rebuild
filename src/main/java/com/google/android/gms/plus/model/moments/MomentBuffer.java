/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.gz;
import com.google.android.gms.plus.model.moments.Moment;

public final class MomentBuffer
extends DataBuffer<Moment> {
    public MomentBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    @Override
    public Moment get(int n2) {
        return new gz(this.lb, n2);
    }
}

