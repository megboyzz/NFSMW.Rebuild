/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.b;

public final class LeaderboardBuffer
extends d<Leaderboard> {
    public LeaderboardBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    @Override
    protected /* synthetic */ Object a(int n2, int n3) {
        return this.getEntry(n2, n3);
    }

    protected Leaderboard getEntry(int n2, int n3) {
        return new b(this.lb, n2, n3);
    }

    @Override
    protected String getPrimaryDataMarkerColumn() {
        return "external_leaderboard_id";
    }
}

