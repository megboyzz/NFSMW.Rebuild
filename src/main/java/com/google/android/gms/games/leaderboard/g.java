/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.b;
import com.google.android.gms.games.leaderboard.LeaderboardVariant;
import com.google.android.gms.games.leaderboard.f;

public final class g
extends b
implements LeaderboardVariant {
    g(DataHolder dataHolder, int n2) {
        super(dataHolder, n2);
    }

    @Override
    public String dh() {
        return this.getString("top_page_token_next");
    }

    @Override
    public String di() {
        return this.getString("window_page_token_prev");
    }

    @Override
    public String dj() {
        return this.getString("window_page_token_next");
    }

    public LeaderboardVariant dk() {
        return new f(this);
    }

    @Override
    public boolean equals(Object object) {
        return f.a(this, object);
    }

    @Override
    public /* synthetic */ Object freeze() {
        return this.dk();
    }

    @Override
    public int getCollection() {
        return this.getInteger("collection");
    }

    @Override
    public String getDisplayPlayerRank() {
        return this.getString("player_display_rank");
    }

    @Override
    public String getDisplayPlayerScore() {
        return this.getString("player_display_score");
    }

    @Override
    public long getNumScores() {
        if (!this.A("total_scores")) return this.getLong("total_scores");
        return -1L;
    }

    @Override
    public long getPlayerRank() {
        if (!this.A("player_rank")) return this.getLong("player_rank");
        return -1L;
    }

    @Override
    public String getPlayerScoreTag() {
        return this.getString("player_score_tag");
    }

    @Override
    public long getRawPlayerScore() {
        if (!this.A("player_raw_score")) return this.getLong("player_raw_score");
        return -1L;
    }

    @Override
    public int getTimeSpan() {
        return this.getInteger("timespan");
    }

    @Override
    public boolean hasPlayerInfo() {
        if (this.A("player_raw_score")) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return f.a(this);
    }

    public String toString() {
        return f.b(this);
    }
}

