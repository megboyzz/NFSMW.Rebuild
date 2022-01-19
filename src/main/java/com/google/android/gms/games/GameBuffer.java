/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.games;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.b;

public final class GameBuffer
extends DataBuffer<Game> {
    public GameBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    @Override
    public Game get(int n2) {
        return new b(this.lb, n2);
    }
}

