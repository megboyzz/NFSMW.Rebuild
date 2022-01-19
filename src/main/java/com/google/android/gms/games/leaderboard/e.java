/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.CharArrayBuffer
 *  android.net.Uri
 */
package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.b;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.d;

public final class e
extends b
implements LeaderboardScore {
    private final com.google.android.gms.games.e sb;

    e(DataHolder dataHolder, int n2) {
        super(dataHolder, n2);
        this.sb = new com.google.android.gms.games.e(dataHolder, n2);
    }

    public LeaderboardScore dg() {
        return new d(this);
    }

    @Override
    public boolean equals(Object object) {
        return d.a(this, object);
    }

    @Override
    public /* synthetic */ Object freeze() {
        return this.dg();
    }

    @Override
    public String getDisplayRank() {
        return this.getString("display_rank");
    }

    @Override
    public void getDisplayRank(CharArrayBuffer charArrayBuffer) {
        this.a("display_rank", charArrayBuffer);
    }

    @Override
    public String getDisplayScore() {
        return this.getString("display_score");
    }

    @Override
    public void getDisplayScore(CharArrayBuffer charArrayBuffer) {
        this.a("display_score", charArrayBuffer);
    }

    @Override
    public long getRank() {
        return this.getLong("rank");
    }

    @Override
    public long getRawScore() {
        return this.getLong("raw_score");
    }

    @Override
    public Player getScoreHolder() {
        if (!this.A("external_player_id")) return this.sb;
        return null;
    }

    @Override
    public String getScoreHolderDisplayName() {
        if (!this.A("external_player_id")) return this.sb.getDisplayName();
        return this.getString("default_display_name");
    }

    @Override
    public void getScoreHolderDisplayName(CharArrayBuffer charArrayBuffer) {
        if (this.A("external_player_id")) {
            this.a("default_display_name", charArrayBuffer);
            return;
        }
        this.sb.getDisplayName(charArrayBuffer);
    }

    @Override
    public Uri getScoreHolderHiResImageUri() {
        if (!this.A("external_player_id")) return this.sb.getHiResImageUri();
        return null;
    }

    @Override
    public Uri getScoreHolderIconImageUri() {
        if (!this.A("external_player_id")) return this.sb.getIconImageUri();
        return this.z("default_display_image_uri");
    }

    @Override
    public String getScoreTag() {
        return this.getString("score_tag");
    }

    @Override
    public long getTimestampMillis() {
        return this.getLong("achieved_timestamp");
    }

    @Override
    public int hashCode() {
        return d.a(this);
    }

    public String toString() {
        return d.b(this);
    }
}

