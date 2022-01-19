/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 */
package com.google.android.gms.games.leaderboard;

import android.content.ContentValues;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.ds;
import com.google.android.gms.internal.du;
import com.google.android.gms.internal.fh;
import java.util.HashMap;

public final class i {
    private static final String[] so = new String[]{"leaderboardId", "playerId", "timeSpan", "hasResult", "rawScore", "formattedScore", "newBest", "scoreTag"};
    private int ka;
    private String qK;
    private String rL;
    private HashMap<Integer, a> sp;

    public i(DataHolder dataHolder) {
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
                this.a(new a(dataHolder.getLong("rawScore", n3, n4), dataHolder.getString("formattedScore", n3, n4), dataHolder.getString("scoreTag", n3, n4), dataHolder.getBoolean("newBest", n3, n4)), dataHolder.getInteger("timeSpan", n3, n4));
            }
            ++n3;
        }
    }

    private void a(a a2, int n2) {
        this.sp.put(n2, a2);
    }

    private ContentValues au(int n2) {
        a a2 = this.av(n2);
        ContentValues contentValues = new ContentValues();
        contentValues.put("leaderboardId", this.rL);
        contentValues.put("playerId", this.qK);
        contentValues.put("timeSpan", Integer.valueOf(n2));
        if (a2 != null) {
            contentValues.put("rawScore", Long.valueOf(a2.rawScore));
            contentValues.put("formattedScore", a2.formattedScore);
            contentValues.put("scoreTag", a2.scoreTag);
            contentValues.put("newBest", Boolean.valueOf(a2.newBest));
            contentValues.put("hasResult", Boolean.valueOf(true));
            return contentValues;
        }
        contentValues.put("hasResult", Boolean.valueOf(false));
        return contentValues;
    }

    public a av(int n2) {
        return this.sp.get(n2);
    }

    public DataHolder dl() {
        DataHolder.Builder builder = DataHolder.builder(so);
        int n2 = 0;
        while (n2 < 3) {
            builder.withRow(this.au(n2));
            ++n2;
        }
        return builder.build(this.ka);
    }

    public String toString() {
        ds.a a2 = ds.e(this).a("PlayerId", this.qK).a("StatusCode", this.ka);
        int n2 = 0;
        while (n2 < 3) {
            Object object = this.sp.get(n2);
            a2.a("TimesSpan", fh.at(n2));
            object = object == null ? "null" : ((a)object).toString();
            a2.a("Result", object);
            ++n2;
        }
        return a2.toString();
    }

    public static final class a {
        public final String formattedScore;
        public final boolean newBest;
        public final long rawScore;
        public final String scoreTag;

        public a(long l2, String string2, String string3, boolean bl2) {
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

