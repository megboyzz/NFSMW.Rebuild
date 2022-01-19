/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.c;
import com.google.android.gms.games.leaderboard.e;

public final class LeaderboardScoreBuffer
extends DataBuffer<LeaderboardScore> {
    private final c rP;

    public LeaderboardScoreBuffer(DataHolder dataHolder) {
        super(dataHolder);
        this.rP = new c(dataHolder.getMetadata());
    }

    public c de() {
        return this.rP;
    }

    @Override
    public LeaderboardScore get(int n2) {
        return new e(this.lb, n2);
    }
}

