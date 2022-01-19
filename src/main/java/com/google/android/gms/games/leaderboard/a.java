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
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardVariant;
import com.google.android.gms.games.leaderboard.f;
import com.google.android.gms.internal.ds;
import com.google.android.gms.internal.eo;
import java.util.ArrayList;

public final class a
implements Leaderboard {
    private final String pW;
    private final Uri qb;
    private final String rL;
    private final int rM;
    private final ArrayList<f> rN;

    public a(Leaderboard object) {
        this.rL = object.getLeaderboardId();
        this.pW = object.getDisplayName();
        this.qb = object.getIconImageUri();
        this.rM = object.getScoreOrder();
        object = object.getVariants();
        int n2 = ((ArrayList)object).size();
        this.rN = new ArrayList(n2);
        int n3 = 0;
        while (n3 < n2) {
            this.rN.add((f)((LeaderboardVariant)((ArrayList)object).get(n3)).freeze());
            ++n3;
        }
    }

    static int a(Leaderboard leaderboard) {
        return ds.hashCode(leaderboard.getLeaderboardId(), leaderboard.getDisplayName(), leaderboard.getIconImageUri(), leaderboard.getScoreOrder(), leaderboard.getVariants());
    }

    static boolean a(Leaderboard leaderboard, Object object) {
        boolean bl2 = true;
        if (!(object instanceof Leaderboard)) {
            return false;
        }
        boolean bl3 = bl2;
        if (leaderboard == object) return bl3;
        if (!ds.equal((object = (Leaderboard)object).getLeaderboardId(), leaderboard.getLeaderboardId())) return false;
        if (!ds.equal(object.getDisplayName(), leaderboard.getDisplayName())) return false;
        if (!ds.equal(object.getIconImageUri(), leaderboard.getIconImageUri())) return false;
        if (!ds.equal(object.getScoreOrder(), leaderboard.getScoreOrder())) return false;
        bl3 = bl2;
        if (ds.equal(object.getVariants(), leaderboard.getVariants())) return bl3;
        return false;
    }

    static String b(Leaderboard leaderboard) {
        return ds.e(leaderboard).a("LeaderboardId", leaderboard.getLeaderboardId()).a("DisplayName", leaderboard.getDisplayName()).a("IconImageUri", leaderboard.getIconImageUri()).a("ScoreOrder", leaderboard.getScoreOrder()).a("Variants", leaderboard.getVariants()).toString();
    }

    public Leaderboard dd() {
        return this;
    }

    public boolean equals(Object object) {
        return a.a(this, object);
    }

    @Override
    public /* synthetic */ Object freeze() {
        return this.dd();
    }

    @Override
    public String getDisplayName() {
        return this.pW;
    }

    @Override
    public void getDisplayName(CharArrayBuffer charArrayBuffer) {
        eo.b(this.pW, charArrayBuffer);
    }

    @Override
    public Uri getIconImageUri() {
        return this.qb;
    }

    @Override
    public String getLeaderboardId() {
        return this.rL;
    }

    @Override
    public int getScoreOrder() {
        return this.rM;
    }

    @Override
    public ArrayList<LeaderboardVariant> getVariants() {
        return new ArrayList<LeaderboardVariant>(this.rN);
    }

    public int hashCode() {
        return a.a(this);
    }

    @Override
    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return a.b(this);
    }
}

