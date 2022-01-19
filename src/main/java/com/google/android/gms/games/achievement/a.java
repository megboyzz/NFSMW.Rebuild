/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.CharArrayBuffer
 *  android.net.Uri
 */
package com.google.android.gms.games.achievement;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.b;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.achievement.Achievement;
import com.google.android.gms.games.e;
import com.google.android.gms.internal.dg;
import com.google.android.gms.internal.ds;

public final class a
extends b
implements Achievement {
    a(DataHolder dataHolder, int n2) {
        super(dataHolder, n2);
    }

    @Override
    public String getAchievementId() {
        return this.getString("external_achievement_id");
    }

    @Override
    public int getCurrentSteps() {
        boolean bl2 = true;
        if (this.getType() != 1) {
            bl2 = false;
        }
        dg.n(bl2);
        return this.getInteger("current_steps");
    }

    @Override
    public String getDescription() {
        return this.getString("description");
    }

    @Override
    public void getDescription(CharArrayBuffer charArrayBuffer) {
        this.a("description", charArrayBuffer);
    }

    @Override
    public String getFormattedCurrentSteps() {
        boolean bl2 = true;
        if (this.getType() != 1) {
            bl2 = false;
        }
        dg.n(bl2);
        return this.getString("formatted_current_steps");
    }

    @Override
    public void getFormattedCurrentSteps(CharArrayBuffer charArrayBuffer) {
        boolean bl2 = true;
        if (this.getType() != 1) {
            bl2 = false;
        }
        dg.n(bl2);
        this.a("formatted_current_steps", charArrayBuffer);
    }

    @Override
    public String getFormattedTotalSteps() {
        boolean bl2 = true;
        if (this.getType() != 1) {
            bl2 = false;
        }
        dg.n(bl2);
        return this.getString("formatted_total_steps");
    }

    @Override
    public void getFormattedTotalSteps(CharArrayBuffer charArrayBuffer) {
        boolean bl2 = true;
        if (this.getType() != 1) {
            bl2 = false;
        }
        dg.n(bl2);
        this.a("formatted_total_steps", charArrayBuffer);
    }

    @Override
    public long getLastUpdatedTimestamp() {
        return this.getLong("last_updated_timestamp");
    }

    @Override
    public String getName() {
        return this.getString("name");
    }

    @Override
    public void getName(CharArrayBuffer charArrayBuffer) {
        this.a("name", charArrayBuffer);
    }

    @Override
    public Player getPlayer() {
        return new e(this.lb, this.ld);
    }

    @Override
    public Uri getRevealedImageUri() {
        return this.z("revealed_icon_image_uri");
    }

    @Override
    public int getState() {
        return this.getInteger("state");
    }

    @Override
    public int getTotalSteps() {
        boolean bl2 = true;
        if (this.getType() != 1) {
            bl2 = false;
        }
        dg.n(bl2);
        return this.getInteger("total_steps");
    }

    @Override
    public int getType() {
        return this.getInteger("type");
    }

    @Override
    public Uri getUnlockedImageUri() {
        return this.z("unlocked_icon_image_uri");
    }

    public String toString() {
        ds.a a2 = ds.e(this).a("id", this.getAchievementId()).a("name", this.getName()).a("state", this.getState()).a("type", this.getType());
        if (this.getType() != 1) return a2.toString();
        a2.a("steps", this.getCurrentSteps() + "/" + this.getTotalSteps());
        return a2.toString();
    }
}

