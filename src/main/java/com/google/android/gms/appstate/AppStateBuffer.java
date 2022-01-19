/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.appstate;

import com.google.android.gms.appstate.AppState;
import com.google.android.gms.appstate.c;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class AppStateBuffer
extends DataBuffer<AppState> {
    public AppStateBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    @Override
    public AppState get(int n2) {
        return new c(this.lb, n2);
    }
}

