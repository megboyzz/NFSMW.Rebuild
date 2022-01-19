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
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.internal.ds;
import com.google.android.gms.internal.du;
import com.google.android.gms.internal.eo;

public final class d
implements LeaderboardScore {
    private final long rR;
    private final String rS;
    private final String rT;
    private final long rU;
    private final long rV;
    private final String rW;
    private final Uri rX;
    private final Uri rY;
    private final PlayerEntity rZ;
    private final String sa;

    public d(LeaderboardScore leaderboardScore) {
        this.rR = leaderboardScore.getRank();
        this.rS = du.f(leaderboardScore.getDisplayRank());
        this.rT = du.f(leaderboardScore.getDisplayScore());
        this.rU = leaderboardScore.getRawScore();
        this.rV = leaderboardScore.getTimestampMillis();
        this.rW = leaderboardScore.getScoreHolderDisplayName();
        this.rX = leaderboardScore.getScoreHolderIconImageUri();
        this.rY = leaderboardScore.getScoreHolderHiResImageUri();
        Player player = leaderboardScore.getScoreHolder();
        player = player == null ? null : (PlayerEntity)player.freeze();
        this.rZ = player;
        this.sa = leaderboardScore.getScoreTag();
    }

    static int a(LeaderboardScore leaderboardScore) {
        return ds.hashCode(leaderboardScore.getRank(), leaderboardScore.getDisplayRank(), leaderboardScore.getRawScore(), leaderboardScore.getDisplayScore(), leaderboardScore.getTimestampMillis(), leaderboardScore.getScoreHolderDisplayName(), leaderboardScore.getScoreHolderIconImageUri(), leaderboardScore.getScoreHolderHiResImageUri(), leaderboardScore.getScoreHolder());
    }

    static boolean a(LeaderboardScore leaderboardScore, Object object) {
        boolean bl2 = true;
        if (!(object instanceof LeaderboardScore)) {
            return false;
        }
        boolean bl3 = bl2;
        if (leaderboardScore == object) return bl3;
        if (!ds.equal((object = (LeaderboardScore)object).getRank(), leaderboardScore.getRank())) return false;
        if (!ds.equal(object.getDisplayRank(), leaderboardScore.getDisplayRank())) return false;
        if (!ds.equal(object.getRawScore(), leaderboardScore.getRawScore())) return false;
        if (!ds.equal(object.getDisplayScore(), leaderboardScore.getDisplayScore())) return false;
        if (!ds.equal(object.getTimestampMillis(), leaderboardScore.getTimestampMillis())) return false;
        if (!ds.equal(object.getScoreHolderDisplayName(), leaderboardScore.getScoreHolderDisplayName())) return false;
        if (!ds.equal(object.getScoreHolderIconImageUri(), leaderboardScore.getScoreHolderIconImageUri())) return false;
        if (!ds.equal(object.getScoreHolderHiResImageUri(), leaderboardScore.getScoreHolderHiResImageUri())) return false;
        if (!ds.equal(object.getScoreHolder(), leaderboardScore.getScoreHolder())) return false;
        bl3 = bl2;
        if (ds.equal(object.getScoreTag(), leaderboardScore.getScoreTag())) return bl3;
        return false;
    }

    static String b(LeaderboardScore leaderboardScore) {
        Player player;
        ds.a a2 = ds.e(leaderboardScore).a("Rank", leaderboardScore.getRank()).a("DisplayRank", leaderboardScore.getDisplayRank()).a("Score", leaderboardScore.getRawScore()).a("DisplayScore", leaderboardScore.getDisplayScore()).a("Timestamp", leaderboardScore.getTimestampMillis()).a("DisplayName", leaderboardScore.getScoreHolderDisplayName()).a("IconImageUri", leaderboardScore.getScoreHolderIconImageUri()).a("HiResImageUri", leaderboardScore.getScoreHolderHiResImageUri());
        if (leaderboardScore.getScoreHolder() == null) {
            player = null;
            return a2.a("Player", player).a("ScoreTag", leaderboardScore.getScoreTag()).toString();
        }
        player = leaderboardScore.getScoreHolder();
        return a2.a("Player", player).a("ScoreTag", leaderboardScore.getScoreTag()).toString();
    }

    public LeaderboardScore dg() {
        return this;
    }

    public boolean equals(Object object) {
        return d.a(this, object);
    }

    @Override
    public /* synthetic */ Object freeze() {
        return this.dg();
    }

    @Override
    public String getDisplayRank() {
        return this.rS;
    }

    @Override
    public void getDisplayRank(CharArrayBuffer charArrayBuffer) {
        eo.b(this.rS, charArrayBuffer);
    }

    @Override
    public String getDisplayScore() {
        return this.rT;
    }

    @Override
    public void getDisplayScore(CharArrayBuffer charArrayBuffer) {
        eo.b(this.rT, charArrayBuffer);
    }

    @Override
    public long getRank() {
        return this.rR;
    }

    @Override
    public long getRawScore() {
        return this.rU;
    }

    @Override
    public Player getScoreHolder() {
        return this.rZ;
    }

    @Override
    public String getScoreHolderDisplayName() {
        if (this.rZ != null) return this.rZ.getDisplayName();
        return this.rW;
    }

    @Override
    public void getScoreHolderDisplayName(CharArrayBuffer charArrayBuffer) {
        if (this.rZ == null) {
            eo.b(this.rW, charArrayBuffer);
            return;
        }
        this.rZ.getDisplayName(charArrayBuffer);
    }

    @Override
    public Uri getScoreHolderHiResImageUri() {
        if (this.rZ != null) return this.rZ.getHiResImageUri();
        return this.rY;
    }

    @Override
    public Uri getScoreHolderIconImageUri() {
        if (this.rZ != null) return this.rZ.getIconImageUri();
        return this.rX;
    }

    @Override
    public String getScoreTag() {
        return this.sa;
    }

    @Override
    public long getTimestampMillis() {
        return this.rV;
    }

    public int hashCode() {
        return d.a(this);
    }

    @Override
    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return d.b(this);
    }
}

