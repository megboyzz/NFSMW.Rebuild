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
import com.google.android.gms.games.Player;
import com.google.android.gms.games.d;
import com.google.android.gms.internal.dg;
import com.google.android.gms.internal.ds;
import com.google.android.gms.internal.eo;
import com.google.android.gms.internal.ey;

public final class PlayerEntity
extends ey
implements Player {
    public static final Parcelable.Creator<PlayerEntity> CREATOR = new a();
    private final int kZ;
    private final String pW;
    private final String qK;
    private final long qL;
    private final Uri qb;
    private final Uri qc;

    PlayerEntity(int n2, String string2, String string3, Uri uri, Uri uri2, long l2) {
        this.kZ = n2;
        this.qK = string2;
        this.pW = string3;
        this.qb = uri;
        this.qc = uri2;
        this.qL = l2;
    }

    public PlayerEntity(Player player) {
        boolean bl2 = true;
        this.kZ = 1;
        this.qK = player.getPlayerId();
        this.pW = player.getDisplayName();
        this.qb = player.getIconImageUri();
        this.qc = player.getHiResImageUri();
        this.qL = player.getRetrievedTimestamp();
        dg.d(this.qK);
        dg.d(this.pW);
        if (this.qL <= 0L) {
            bl2 = false;
        }
        dg.n(bl2);
    }

    static int a(Player player) {
        return ds.hashCode(player.getPlayerId(), player.getDisplayName(), player.getIconImageUri(), player.getHiResImageUri(), player.getRetrievedTimestamp());
    }

    static boolean a(Player player, Object object) {
        boolean bl2 = true;
        if (!(object instanceof Player)) {
            return false;
        }
        boolean bl3 = bl2;
        if (player == object) return bl3;
        if (!ds.equal((object = (Player)object).getPlayerId(), player.getPlayerId())) return false;
        if (!ds.equal(object.getDisplayName(), player.getDisplayName())) return false;
        if (!ds.equal(object.getIconImageUri(), player.getIconImageUri())) return false;
        if (!ds.equal(object.getHiResImageUri(), player.getHiResImageUri())) return false;
        bl3 = bl2;
        if (ds.equal(object.getRetrievedTimestamp(), player.getRetrievedTimestamp())) return bl3;
        return false;
    }

    static String b(Player player) {
        return ds.e(player).a("PlayerId", player.getPlayerId()).a("DisplayName", player.getDisplayName()).a("IconImageUri", player.getIconImageUri()).a("HiResImageUri", player.getHiResImageUri()).a("RetrievedTimestamp", player.getRetrievedTimestamp()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        return PlayerEntity.a(this, object);
    }

    @Override
    public Player freeze() {
        return this;
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
    public Uri getHiResImageUri() {
        return this.qc;
    }

    @Override
    public Uri getIconImageUri() {
        return this.qb;
    }

    @Override
    public String getPlayerId() {
        return this.qK;
    }

    @Override
    public long getRetrievedTimestamp() {
        return this.qL;
    }

    public int getVersionCode() {
        return this.kZ;
    }

    @Override
    public boolean hasHiResImage() {
        if (this.getHiResImageUri() == null) return false;
        return true;
    }

    @Override
    public boolean hasIconImage() {
        if (this.getIconImageUri() == null) return false;
        return true;
    }

    public int hashCode() {
        return PlayerEntity.a(this);
    }

    @Override
    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return PlayerEntity.b(this);
    }

    public void writeToParcel(Parcel parcel, int n2) {
        Object var4_3 = null;
        if (!this.bz()) {
            d.a(this, parcel, n2);
            return;
        }
        parcel.writeString(this.qK);
        parcel.writeString(this.pW);
        String string2 = this.qb == null ? null : this.qb.toString();
        parcel.writeString(string2);
        string2 = this.qc == null ? var4_3 : this.qc.toString();
        parcel.writeString(string2);
        parcel.writeLong(this.qL);
    }

    static final class a
    extends d {
        a() {
        }

        @Override
        public PlayerEntity V(Parcel parcel) {
            Uri uri = null;
            if (PlayerEntity.c(PlayerEntity.by())) return super.V(parcel);
            if (PlayerEntity.D(PlayerEntity.class.getCanonicalName())) {
                return super.V(parcel);
            }
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            String string5 = parcel.readString();
            string4 = string4 == null ? null : Uri.parse((String)string4);
            if (string5 == null) {
                return new PlayerEntity(1, string2, string3, (Uri)string4, uri, parcel.readLong());
            }
            uri = Uri.parse((String)string5);
            return new PlayerEntity(1, string2, string3, (Uri)string4, uri, parcel.readLong());
        }

        @Override
        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return this.V(parcel);
        }
    }
}

