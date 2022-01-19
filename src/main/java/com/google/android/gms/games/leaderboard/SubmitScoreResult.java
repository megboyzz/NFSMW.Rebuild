/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.ds;
import com.google.android.gms.internal.du;
import com.google.android.gms.internal.fh;
import java.util.HashMap;

public final class SubmitScoreResult {
    private static final String[] so = new String[]{"leaderboardId", "playerId", "timeSpan", "hasResult", "rawScore", "formattedScore", "newBest", "scoreTag"};
    private int ka;
    private String qK;
    private String rL;
    private HashMap<Integer, Result> sp;

    public SubmitScoreResult(int n2, String string2, String string3) {
        this(n2, string2, string3, new HashMap<Integer, Result>());
    }

    public SubmitScoreResult(int n2, String string2, String string3, HashMap<Integer, Result> hashMap) {
        this.ka = n2;
        this.rL = string2;
        this.qK = string3;
        this.sp = hashMap;
    }

    public SubmitScoreResult(DataHolder dataHolder) {
        this.ka = dataHolder.getStatusCode();
        this.sp = new HashMap();
        int n2 = dataHolder.getCount();
        boolean bl2 = n2 == 3;
        du.p(bl2);
        int n3 = 0;
        while (n3 < n2) {
            int n4 = dataHolder.t(n3);
            if (n3 == 0) {
                this.rL = dataHolder.getString("leaderboardId", n3, n4);
                this.qK = dataHolder.getString("playerId", n3, n4);
            }
            if (dataHolder.getBoolean("hasResult", n3, n4)) {
                this.a(new Result(dataHolder.getLong("rawScore", n3, n4), dataHolder.getString("formattedScore", n3, n4), dataHolder.getString("scoreTag", n3, n4), dataHolder.getBoolean("newBest", n3, n4)), dataHolder.getInteger("timeSpan", n3, n4));
            }
            ++n3;
        }
    }

    private void a(Result result, int n2) {
        this.sp.put(n2, result);
    }

    public String getLeaderboardId() {
        return this.rL;
    }

    public String getPlayerId() {
        return this.qK;
    }

    public Result getScoreResult(int n2) {
        return this.sp.get(n2);
    }

    public int getStatusCode() {
        return this.ka;
    }

    public String toString() {
        ds.a a2 = ds.e(this).a("PlayerId", this.qK).a("StatusCode", this.ka);
        int n2 = 0;
        while (n2 < 3) {
            Object object = this.sp.get(n2);
            a2.a("TimesSpan", fh.at(n2));
            object = object == null ? "null" : ((Result)object).toString();
            a2.a("Result", object);
            ++n2;
        }
        return a2.toString();
    }

    public static final class Result {
        public final String formattedScore;
        public final boolean newBest;
        public final long rawScore;
        public final String scoreTag;

        public Result(long l2, String string2, String string3, boolean bl2) {
            this.rawScore = l2;
            this.formattedScore = string2;
            this.scoreTag = string3;
            this.newBest = bl2;
        }

        public String toString() {
            return ds.e(this).a("RawScore", this.rawScore).a("FormattedScore", this.formattedScore).a("ScoreTag", this.scoreTag).a("NewBest", this.newBest).toString();
        }
    }
}

