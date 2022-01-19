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
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardVariant;
import com.google.android.gms.games.leaderboard.a;
import com.google.android.gms.games.leaderboard.g;
import java.util.ArrayList;

public final class b
extends com.google.android.gms.common.data.b
implements Leaderboard {
    private final int rO;

    b(DataHolder dataHolder, int n2, int n3) {
        super(dataHolder, n2);
        this.rO = n3;
    }

    public Leaderboard dd() {
        return new a(this);
    }

    @Override
    public boolean equals(Object object) {
        return a.a(this, object);
    }

    @Override
    public /* synthetic */ Object freeze() {
        return this.dd();
    }

    @Override
    public String getDisplayName() {
        return this.getString("name");
    }

    @Override
    public void getDisplayName(CharArrayBuffer charArrayBuffer) {
        this.a("name", charArrayBuffer);
    }

    @Override
    public Uri getIconImageUri() {
        return this.z("board_icon_image_uri");
    }

    @Override
    public String getLeaderboardId() {
        return this.getString("external_leaderboard_id");
    }

    @Override
    public int getScoreOrder() {
        return this.getInteger("score_order");
    }

    @Override
    public ArrayList<LeaderboardVariant> getVariants() {
        ArrayList<LeaderboardVariant> arrayList = new ArrayList<LeaderboardVariant>(this.rO);
        int n2 = 0;
        while (n2 < this.rO) {
            arrayList.add(new g(this.lb, this.ld + n2));
            ++n2;
        }
        return arrayList;
    }

    @Override
    public int hashCode() {
        return a.a(this);
    }

    public String toString() {
        return a.b(this);
    }
}

