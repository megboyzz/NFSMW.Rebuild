/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.CharArrayBuffer
 *  android.net.Uri
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.internal.ds;
import com.google.android.gms.internal.eo;
import com.google.android.gms.internal.ey;

public final class GameEntity
extends ey
implements Game {
    public static final Parcelable.Creator<GameEntity> CREATOR = new a();
    private final int kZ;
    private final String pV;
    private final String pW;
    private final String pX;
    private final String pY;
    private final String pZ;
    private final String qa;
    private final Uri qb;
    private final Uri qc;
    private final Uri qd;
    private final boolean qe;
    private final boolean qf;
    private final String qg;
    private final int qh;
    private final int qi;
    private final int qj;
    private final boolean qk;
    private final boolean ql;

    GameEntity(int n2, String string2, String string3, String string4, String string5, String string6, String string7, Uri uri, Uri uri2, Uri uri3, boolean bl2, boolean bl3, String string8, int n3, int n4, int n5, boolean bl4, boolean bl5) {
        this.kZ = n2;
        this.pV = string2;
        this.pW = string3;
        this.pX = string4;
        this.pY = string5;
        this.pZ = string6;
        this.qa = string7;
        this.qb = uri;
        this.qc = uri2;
        this.qd = uri3;
        this.qe = bl2;
        this.qf = bl3;
        this.qg = string8;
        this.qh = n3;
        this.qi = n4;
        this.qj = n5;
        this.qk = bl4;
        this.ql = bl5;
    }

    public GameEntity(Game game) {
        this.kZ = 2;
        this.pV = game.getApplicationId();
        this.pX = game.getPrimaryCategory();
        this.pY = game.getSecondaryCategory();
        this.pZ = game.getDescription();
        this.qa = game.getDeveloperName();
        this.pW = game.getDisplayName();
        this.qb = game.getIconImageUri();
        this.qc = game.getHiResImageUri();
        this.qd = game.getFeaturedImageUri();
        this.qe = game.isPlayEnabledGame();
        this.qf = game.isInstanceInstalled();
        this.qg = game.getInstancePackageName();
        this.qh = game.getGameplayAclStatus();
        this.qi = game.getAchievementTotalCount();
        this.qj = game.getLeaderboardCount();
        this.qk = game.isRealTimeMultiplayerEnabled();
        this.ql = game.isTurnBasedMultiplayerEnabled();
    }

    static int a(Game game) {
        return ds.hashCode(game.getApplicationId(), game.getDisplayName(), game.getPrimaryCategory(), game.getSecondaryCategory(), game.getDescription(), game.getDeveloperName(), game.getIconImageUri(), game.getHiResImageUri(), game.getFeaturedImageUri(), game.isPlayEnabledGame(), game.isInstanceInstalled(), game.getInstancePackageName(), game.getGameplayAclStatus(), game.getAchievementTotalCount(), game.getLeaderboardCount(), game.isRealTimeMultiplayerEnabled(), game.isTurnBasedMultiplayerEnabled());
    }

    static boolean a(Game game, Object object) {
        boolean bl2 = true;
        if (!(object instanceof Game)) {
            return false;
        }
        boolean bl3 = bl2;
        if (game == object) return bl3;
        if (!ds.equal((object = (Game)object).getApplicationId(), game.getApplicationId())) return false;
        if (!ds.equal(object.getDisplayName(), game.getDisplayName())) return false;
        if (!ds.equal(object.getPrimaryCategory(), game.getPrimaryCategory())) return false;
        if (!ds.equal(object.getSecondaryCategory(), game.getSecondaryCategory())) return false;
        if (!ds.equal(object.getDescription(), game.getDescription())) return false;
        if (!ds.equal(object.getDeveloperName(), game.getDeveloperName())) return false;
        if (!ds.equal(object.getIconImageUri(), game.getIconImageUri())) return false;
        if (!ds.equal(object.getHiResImageUri(), game.getHiResImageUri())) return false;
        if (!ds.equal(object.getFeaturedImageUri(), game.getFeaturedImageUri())) return false;
        if (!ds.equal(object.isPlayEnabledGame(), game.isPlayEnabledGame())) return false;
        if (!ds.equal(object.isInstanceInstalled(), game.isInstanceInstalled())) return false;
        if (!ds.equal(object.getInstancePackageName(), game.getInstancePackageName())) return false;
        if (!ds.equal(object.getGameplayAclStatus(), game.getGameplayAclStatus())) return false;
        if (!ds.equal(object.getAchievementTotalCount(), game.getAchievementTotalCount())) return false;
        if (!ds.equal(object.getLeaderboardCount(), game.getLeaderboardCount())) return false;
        if (!ds.equal(object.isRealTimeMultiplayerEnabled(), game.isRealTimeMultiplayerEnabled())) return false;
        bl3 = bl2;
        if (ds.equal(object.isTurnBasedMultiplayerEnabled(), game.isTurnBasedMultiplayerEnabled())) return bl3;
        return false;
    }

    static String b(Game game) {
        return ds.e(game).a("ApplicationId", game.getApplicationId()).a("DisplayName", game.getDisplayName()).a("PrimaryCategory", game.getPrimaryCategory()).a("SecondaryCategory", game.getSecondaryCategory()).a("Description", game.getDescription()).a("DeveloperName", game.getDeveloperName()).a("IconImageUri", game.getIconImageUri()).a("HiResImageUri", game.getHiResImageUri()).a("FeaturedImageUri", game.getFeaturedImageUri()).a("PlayEnabledGame", game.isPlayEnabledGame()).a("InstanceInstalled", game.isInstanceInstalled()).a("InstancePackageName", game.getInstancePackageName()).a("GameplayAclStatus", game.getGameplayAclStatus()).a("AchievementTotalCount", game.getAchievementTotalCount()).a("LeaderboardCount", game.getLeaderboardCount()).a("RealTimeMultiplayerEnabled", game.isRealTimeMultiplayerEnabled()).a("TurnBasedMultiplayerEnabled", game.isTurnBasedMultiplayerEnabled()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        return GameEntity.a(this, object);
    }

    @Override
    public Game freeze() {
        return this;
    }

    @Override
    public int getAchievementTotalCount() {
        return this.qi;
    }

    @Override
    public String getApplicationId() {
        return this.pV;
    }

    @Override
    public String getDescription() {
        return this.pZ;
    }

    @Override
    public void getDescription(CharArrayBuffer charArrayBuffer) {
        eo.b(this.pZ, charArrayBuffer);
    }

    @Override
    public String getDeveloperName() {
        return this.qa;
    }

    @Override
    public void getDeveloperName(CharArrayBuffer charArrayBuffer) {
        eo.b(this.qa, charArrayBuffer);
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
    public Uri getFeaturedImageUri() {
        return this.qd;
    }

    @Override
    public int getGameplayAclStatus() {
        return this.qh;
    }

    @Override
    public Uri getHiResImageUri() {
        return this.qc;
    }

    @Override
    public Uri getIconImageUri() {
        return this.qb;
    }

    @Override
    public String getInstancePackageName() {
        return this.qg;
    }

    @Override
    public int getLeaderboardCount() {
        return this.qj;
    }

    @Override
    public String getPrimaryCategory() {
        return this.pX;
    }

    @Override
    public String getSecondaryCategory() {
        return this.pY;
    }

    public int getVersionCode() {
        return this.kZ;
    }

    public int hashCode() {
        return GameEntity.a(this);
    }

    @Override
    public boolean isDataValid() {
        return true;
    }

    @Override
    public boolean isInstanceInstalled() {
        return this.qf;
    }

    @Override
    public boolean isPlayEnabledGame() {
        return this.qe;
    }

    @Override
    public boolean isRealTimeMultiplayerEnabled() {
        return this.qk;
    }

    @Override
    public boolean isTurnBasedMultiplayerEnabled() {
        return this.ql;
    }

    public String toString() {
        return GameEntity.b(this);
    }

    public void writeToParcel(Parcel parcel, int n2) {
        int n3 = 1;
        Object var5_4 = null;
        if (!this.bz()) {
            com.google.android.gms.games.a.a(this, parcel, n2);
            return;
        }
        parcel.writeString(this.pV);
        parcel.writeString(this.pW);
        parcel.writeString(this.pX);
        parcel.writeString(this.pY);
        parcel.writeString(this.pZ);
        parcel.writeString(this.qa);
        String string2 = this.qb == null ? null : this.qb.toString();
        parcel.writeString(string2);
        string2 = this.qc == null ? null : this.qc.toString();
        parcel.writeString(string2);
        string2 = this.qd == null ? var5_4 : this.qd.toString();
        parcel.writeString(string2);
        n2 = this.qe ? 1 : 0;
        parcel.writeInt(n2);
        n2 = this.qf ? n3 : 0;
        parcel.writeInt(n2);
        parcel.writeString(this.qg);
        parcel.writeInt(this.qh);
        parcel.writeInt(this.qi);
        parcel.writeInt(this.qj);
    }

    static final class a
    extends com.google.android.gms.games.a {
        a() {
        }

        @Override
        public GameEntity U(Parcel parcel) {
            boolean bl2;
            if (GameEntity.c(GameEntity.by())) return super.U(parcel);
            if (GameEntity.D(GameEntity.class.getCanonicalName())) {
                return super.U(parcel);
            }
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            String string5 = parcel.readString();
            String string6 = parcel.readString();
            String string7 = parcel.readString();
            String string8 = parcel.readString();
            string8 = string8 == null ? null : Uri.parse((String)string8);
            String string9 = parcel.readString();
            string9 = string9 == null ? null : Uri.parse((String)string9);
            String string10 = parcel.readString();
            string10 = string10 == null ? null : Uri.parse((String)string10);
            boolean bl3 = parcel.readInt() > 0;
            if (parcel.readInt() > 0) {
                bl2 = true;
                return new GameEntity(2, string2, string3, string4, string5, string6, string7, (Uri)string8, (Uri)string9, (Uri)string10, bl3, bl2, parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), false, false);
            }
            bl2 = false;
            return new GameEntity(2, string2, string3, string4, string5, string6, string7, (Uri)string8, (Uri)string9, (Uri)string10, bl3, bl2, parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), false, false);
        }

        @Override
        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return this.U(parcel);
        }
    }
}

