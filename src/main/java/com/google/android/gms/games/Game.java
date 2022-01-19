/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.CharArrayBuffer
 *  android.net.Uri
 *  android.os.Parcelable
 */
package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

public interface Game
extends Parcelable,
Freezable<Game> {
    public int getAchievementTotalCount();

    public String getApplicationId();

    public String getDescription();

    public void getDescription(CharArrayBuffer var1);

    public String getDeveloperName();

    public void getDeveloperName(CharArrayBuffer var1);

    public String getDisplayName();

    public void getDisplayName(CharArrayBuffer var1);

    public Uri getFeaturedImageUri();

    public int getGameplayAclStatus();

    public Uri getHiResImageUri();

    public Uri getIconImageUri();

    public String getInstancePackageName();

    public int getLeaderboardCount();

    public String getPrimaryCategory();

    public String getSecondaryCategory();

    public boolean isInstanceInstalled();

    public boolean isPlayEnabledGame();

    public boolean isRealTimeMultiplayerEnabled();

    public boolean isTurnBasedMultiplayerEnabled();
}

