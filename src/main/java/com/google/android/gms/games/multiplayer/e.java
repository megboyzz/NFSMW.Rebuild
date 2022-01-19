/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.CharArrayBuffer
 *  android.net.Uri
 *  android.os.Parcel
 */
package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.b;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.games.multiplayer.ParticipantResult;

public final class e
extends b
implements Participant {
    private final com.google.android.gms.games.e sE;

    public e(DataHolder dataHolder, int n2) {
        super(dataHolder, n2);
        this.sE = new com.google.android.gms.games.e(dataHolder, n2);
    }

    public int describeContents() {
        return 0;
    }

    @Override
    public String dm() {
        return this.getString("client_address");
    }

    @Override
    public boolean equals(Object object) {
        return ParticipantEntity.a(this, object);
    }

    @Override
    public Participant freeze() {
        return new ParticipantEntity(this);
    }

    @Override
    public int getCapabilities() {
        return this.getInteger("capabilities");
    }

    @Override
    public String getDisplayName() {
        if (!this.A("external_player_id")) return this.sE.getDisplayName();
        return this.getString("default_display_name");
    }

    @Override
    public void getDisplayName(CharArrayBuffer charArrayBuffer) {
        if (this.A("external_player_id")) {
            this.a("default_display_name", charArrayBuffer);
            return;
        }
        this.sE.getDisplayName(charArrayBuffer);
    }

    @Override
    public Uri getHiResImageUri() {
        if (!this.A("external_player_id")) return this.sE.getHiResImageUri();
        return null;
    }

    @Override
    public Uri getIconImageUri() {
        if (!this.A("external_player_id")) return this.sE.getIconImageUri();
        return this.z("default_display_image_uri");
    }

    @Override
    public String getParticipantId() {
        return this.getString("external_participant_id");
    }

    @Override
    public Player getPlayer() {
        if (!this.A("external_player_id")) return this.sE;
        return null;
    }

    @Override
    public ParticipantResult getResult() {
        if (this.A("result_type")) {
            return null;
        }
        int n2 = this.getInteger("result_type");
        int n3 = this.getInteger("placing");
        return new ParticipantResult(this.getParticipantId(), n2, n3);
    }

    @Override
    public int getStatus() {
        return this.getInteger("player_status");
    }

    @Override
    public int hashCode() {
        return ParticipantEntity.a(this);
    }

    @Override
    public boolean isConnectedToRoom() {
        if (this.getInteger("connected") <= 0) return false;
        return true;
    }

    public String toString() {
        return ParticipantEntity.b(this);
    }

    public void writeToParcel(Parcel parcel, int n2) {
        ((ParticipantEntity)this.freeze()).writeToParcel(parcel, n2);
    }
}

