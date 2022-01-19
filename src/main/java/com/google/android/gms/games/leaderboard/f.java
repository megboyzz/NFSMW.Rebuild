/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.games.leaderboard;

import com.google.android.gms.games.leaderboard.LeaderboardVariant;
import com.google.android.gms.internal.ds;
import com.google.android.gms.internal.ff;
import com.google.android.gms.internal.fh;

public final class f
implements LeaderboardVariant {
    private final int sc;
    private final int sd;
    private final boolean se;
    private final long sf;
    private final String sg;
    private final long sh;
    private final String si;
    private final String sj;
    private final long sk;
    private final String sl;
    private final String sm;
    private final String sn;

    public f(LeaderboardVariant leaderboardVariant) {
        this.sc = leaderboardVariant.getTimeSpan();
        this.sd = leaderboardVariant.getCollection();
        this.se = leaderboardVariant.hasPlayerInfo();
        this.sf = leaderboardVariant.getRawPlayerScore();
        this.sg = leaderboardVariant.getDisplayPlayerScore();
        this.sh = leaderboardVariant.getPlayerRank();
        this.si = leaderboardVariant.getDisplayPlayerRank();
        this.sj = leaderboardVariant.getPlayerScoreTag();
        this.sk = leaderboardVariant.getNumScores();
        this.sl = leaderboardVariant.dh();
        this.sm = leaderboardVariant.di();
        this.sn = leaderboardVariant.dj();
    }

    static int a(LeaderboardVariant leaderboardVariant) {
        return ds.hashCode(leaderboardVariant.getTimeSpan(), leaderboardVariant.getCollection(), leaderboardVariant.hasPlayerInfo(), leaderboardVariant.getRawPlayerScore(), leaderboardVariant.getDisplayPlayerScore(), leaderboardVariant.getPlayerRank(), leaderboardVariant.getDisplayPlayerRank(), leaderboardVariant.getNumScores(), leaderboardVariant.dh(), leaderboardVariant.dj(), leaderboardVariant.di());
    }

    static boolean a(LeaderboardVariant leaderboardVariant, Object object) {
        boolean bl2 = true;
        if (!(object instanceof LeaderboardVariant)) {
            return false;
        }
        boolean bl3 = bl2;
        if (leaderboardVariant == object) return bl3;
        if (!ds.equal((object = (LeaderboardVariant)object).getTimeSpan(), leaderboardVariant.getTimeSpan())) return false;
        if (!ds.equal(object.getCollection(), leaderboardVariant.getCollection())) return false;
        if (!ds.equal(object.hasPlayerInfo(), leaderboardVariant.hasPlayerInfo())) return false;
        if (!ds.equal(object.getRawPlayerScore(), leaderboardVariant.getRawPlayerScore())) return false;
        if (!ds.equal(object.getDisplayPlayerScore(), leaderboardVariant.getDisplayPlayerScore())) return false;
        if (!ds.equal(object.getPlayerRank(), leaderboardVariant.getPlayerRank())) return false;
        if (!ds.equal(object.getDisplayPlayerRank(), leaderboardVariant.getDisplayPlayerRank())) return false;
        if (!ds.equal(object.getNumScores(), leaderboardVariant.getNumScores())) return false;
        if (!ds.equal(object.dh(), leaderboardVariant.dh())) return false;
        if (!ds.equal(object.dj(), leaderboardVariant.dj())) return false;
        bl3 = bl2;
        if (ds.equal(object.di(), leaderboardVariant.di())) return bl3;
        return false;
    }

    static String b(LeaderboardVariant leaderboardVariant) {
        ds.a a2 = ds.e(leaderboardVariant).a("TimeSpan", fh.at(leaderboardVariant.getTimeSpan())).a("Collection", ff.at(leaderboardVariant.getCollection()));
        Object object = leaderboardVariant.hasPlayerInfo() ? Long.valueOf(leaderboardVariant.getRawPlayerScore()) : "none";
        a2 = a2.a("RawPlayerScore", object);
        object = leaderboardVariant.hasPlayerInfo() ? leaderboardVariant.getDisplayPlayerScore() : "none";
        a2 = a2.a("DisplayPlayerScore", object);
        object = leaderboardVariant.hasPlayerInfo() ? Long.valueOf(leaderboardVariant.getPlayerRank()) : "none";
        a2 = a2.a("PlayerRank", object);
        if (leaderboardVariant.hasPlayerInfo()) {
            object = leaderboardVariant.getDisplayPlayerRank();
            return a2.a("DisplayPlayerRank", object).a("NumScores", leaderboardVariant.getNumScores()).a("TopPageNextToken", leaderboardVariant.dh()).a("WindowPageNextToken", leaderboardVariant.dj()).a("WindowPagePrevToken", leaderboardVariant.di()).toString();
        }
        object = "none";
        return a2.a("DisplayPlayerRank", object).a("NumScores", leaderboardVariant.getNumScores()).a("TopPageNextToken", leaderboardVariant.dh()).a("WindowPageNextToken", leaderboardVariant.dj()).a("WindowPagePrevToken", leaderboardVariant.di()).toString();
    }

    @Override
    public String dh() {
        return this.sl;
    }

    @Override
    public String di() {
        return this.sm;
    }

    @Override
    public String dj() {
        return this.sn;
    }

    public LeaderboardVariant dk() {
        return this;
    }

    public boolean equals(Object object) {
        return f.a(this, object);
    }

    @Override
    public /* synthetic */ Object freeze() {
        return this.dk();
    }

    @Override
    public int getCollection() {
        return this.sd;
    }

    @Override
    public String getDisplayPlayerRank() {
        return this.si;
    }

    @Override
    public String getDisplayPlayerScore() {
        return this.sg;
    }

    @Override
    public long getNumScores() {
        return this.sk;
    }

    @Override
    public long getPlayerRank() {
        return this.sh;
    }

    @Override
    public String getPlayerScoreTag() {
        return this.sj;
    }

    @Override
    public long getRawPlayerScore() {
        return this.sf;
    }

    @Override
    public int getTimeSpan() {
        return this.sc;
    }

    @Override
    public boolean hasPlayerInfo() {
        return this.se;
    }

    public int hashCode() {
        return f.a(this);
    }

    @Override
    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return f.b(this);
    }
}

