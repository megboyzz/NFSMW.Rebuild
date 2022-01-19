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
import com.google.android.gms.common.data.b;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;

public final class e
extends b
implements Player {
    public e(DataHolder dataHolder, int n2) {
        super(dataHolder, n2);
    }

    public int describeContents() {
        return 0;
    }

    @Override
    public boolean equals(Object object) {
        return PlayerEntity.a(this, object);
    }

    @Override
    public Player freeze() {
        return new PlayerEntity(this);
    }

    @Override
    public String getDisplayName() {
        return this.getString("profile_name");
    }

    @Override
    public void getDisplayName(CharArrayBuffer charArrayBuffer) {
        this.a("profile_name", charArrayBuffer);
    }

    @Override
    public Uri getHiResImageUri() {
        return this.z("profile_hi_res_image_uri");
    }

    @Override
    public Uri getIconImageUri() {
        return this.z("profile_icon_image_uri");
    }

    @Override
    public String getPlayerId() {
        return this.getString("external_player_id");
    }

    @Override
    public long getRetrievedTimestamp() {
        return this.getLong("last_updated");
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

    @Override
    public int hashCode() {
        return PlayerEntity.a(this);
    }

    public String toString() {
        return PlayerEntity.b(this);
    }

    public void writeToParcel(Parcel parcel, int n2) {
        ((PlayerEntity)this.freeze()).writeToParcel(parcel, n2);
    }
}

