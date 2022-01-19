/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.games;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.e;

public final class PlayerBuffer
extends DataBuffer<Player> {
    public PlayerBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    @Override
    public Player get(int n2) {
        return new e(this.lb, n2);
    }
}

