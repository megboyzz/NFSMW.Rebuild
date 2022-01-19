/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.i;

public interface h {

    public static interface a
    extends Releasable,
    Result {
        public LeaderboardBuffer cQ();
    }

    public static interface b
    extends Result {
        public LeaderboardScore cR();
    }

    public static interface c
    extends Releasable,
    Result {
        public Leaderboard cO();

        public LeaderboardScoreBuffer cP();
    }

    public static interface d
    extends Releasable,
    Result {
        public i cS();
    }
}

