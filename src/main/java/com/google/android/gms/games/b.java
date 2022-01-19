/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.CharArrayBuffer
 *  android.net.Uri
 *  android.os.Parcel
 */
package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;

public final class b
extends com.google.android.gms.common.data.b
implements Game {
    public b(DataHolder dataHolder, int n2) {
        super(dataHolder, n2);
    }

    public int describeContents() {
        return 0;
    }

    @Override
    public boolean equals(Object object) {
        return GameEntity.a(this, object);
    }

    @Override
    public Game freeze() {
        return new GameEntity(this);
    }

    @Override
    public int getAchievementTotalCount() {
        return this.getInteger("achievement_total_count");
    }

    @Override
    public String getApplicationId() {
        return this.getString("external_game_id");
    }

    @Override
    public String getDescription() {
        return this.getString("game_description");
    }

    @Override
    public void getDescription(CharArrayBuffer charArrayBuffer) {
        this.a("game_description", charArrayBuffer);
    }

    @Override
    public String getDeveloperName() {
        return this.getString("developer_name");
    }

    @Override
    public void getDeveloperName(CharArrayBuffer charArrayBuffer) {
        this.a("developer_name", charArrayBuffer);
    }

    @Override
    public String getDisplayName() {
        return this.getString("display_name");
    }

    @Override
    public void getDisplayName(CharArrayBuffer charArrayBuffer) {
        this.a("display_name", charArrayBuffer);
    }

    @Override
    public Uri getFeaturedImageUri() {
        return this.z("featured_image_uri");
    }

    @Override
    public int getGameplayAclStatus() {
        return this.getInteger("gameplay_acl_status");
    }

    @Override
    public Uri getHiResImageUri() {
        return this.z("game_hi_res_image_uri");
    }

    @Override
    public Uri getIconImageUri() {
        return this.z("game_icon_image_uri");
    }

    @Override
    public String getInstancePackageName() {
        return this.getString("package_name");
    }

    @Override
    public int getLeaderboardCount() {
        return this.getInteger("leaderboard_count");
    }

    @Override
    public String getPrimaryCategory() {
        return this.getString("primary_category");
    }

    @Override
    public String getSecondaryCategory() {
        return this.getString("secondary_category");
    }

    @Override
    public int hashCode() {
        return GameEntity.a(this);
    }

    @Override
    public boolean isInstanceInstalled() {
        if (this.getInteger("installed") <= 0) return false;
        return true;
    }

    @Override
    public boolean isPlayEnabledGame() {
        return this.getBoolean("play_enabled_game");
    }

    @Override
    public boolean isRealTimeMultiplayerEnabled() {
        if (this.getInteger("real_time_support") <= 0) return false;
        return true;
    }

    @Override
    public boolean isTurnBasedMultiplayerEnabled() {
        if (this.getInteger("turn_based_support") <= 0) return false;
        return true;
    }

    public String toString() {
        return GameEntity.b(this);
    }

    public void writeToParcel(Parcel parcel, int n2) {
        ((GameEntity)this.freeze()).writeToParcel(parcel, n2);
    }
}

