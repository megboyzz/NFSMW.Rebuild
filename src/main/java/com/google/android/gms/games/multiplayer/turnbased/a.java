/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcel
 */
package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.b;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.e;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchEntity;
import java.util.ArrayList;

public final class a
extends com.google.android.gms.common.data.b
implements TurnBasedMatch {
    private final int rO;
    private final Game sw;

    a(DataHolder dataHolder, int n2, int n3) {
        super(dataHolder, n2);
        this.sw = new b(dataHolder, n2);
        this.rO = n3;
    }

    @Override
    public boolean canRematch() {
        if (this.getTurnStatus() != 3) return false;
        if (this.getRematchId() != null) return false;
        if (this.getParticipants().size() <= 1) return false;
        return true;
    }

    public int describeContents() {
        return 0;
    }

    @Override
    public boolean equals(Object object) {
        return TurnBasedMatchEntity.a((TurnBasedMatch)this, object);
    }

    @Override
    public TurnBasedMatch freeze() {
        return new TurnBasedMatchEntity(this);
    }

    @Override
    public Bundle getAutoMatchCriteria() {
        if (this.getBoolean("has_automatch_criteria")) return TurnBasedMatchConfig.createAutoMatchCriteria(this.getInteger("automatch_min_players"), this.getInteger("automatch_max_players"), this.getLong("automatch_bit_mask"));
        return null;
    }

    @Override
    public int getAvailableAutoMatchSlots() {
        if (this.getBoolean("has_automatch_criteria")) return this.getInteger("automatch_max_players");
        return 0;
    }

    @Override
    public long getCreationTimestamp() {
        return this.getLong("creation_timestamp");
    }

    @Override
    public String getCreatorId() {
        return this.getString("creator_external");
    }

    @Override
    public byte[] getData() {
        return this.getByteArray("data");
    }

    @Override
    public Game getGame() {
        return this.sw;
    }

    @Override
    public long getLastUpdatedTimestamp() {
        return this.getLong("last_updated_timestamp");
    }

    @Override
    public String getLastUpdaterId() {
        return this.getString("last_updater_external");
    }

    @Override
    public String getMatchId() {
        return this.getString("external_match_id");
    }

    @Override
    public int getMatchNumber() {
        return this.getInteger("match_number");
    }

    @Override
    public Participant getParticipant(String string2) {
        return TurnBasedMatchEntity.c(this, string2);
    }

    @Override
    public String getParticipantId(String string2) {
        return TurnBasedMatchEntity.b(this, string2);
    }

    @Override
    public ArrayList<String> getParticipantIds() {
        return TurnBasedMatchEntity.c(this);
    }

    @Override
    public int getParticipantStatus(String string2) {
        return TurnBasedMatchEntity.a((TurnBasedMatch)this, string2);
    }

    @Override
    public ArrayList<Participant> getParticipants() {
        ArrayList<Participant> arrayList = new ArrayList<Participant>(this.rO);
        int n2 = 0;
        while (n2 < this.rO) {
            arrayList.add(new e(this.lb, this.ld + n2));
            ++n2;
        }
        return arrayList;
    }

    @Override
    public String getPendingParticipantId() {
        return this.getString("pending_participant_external");
    }

    @Override
    public byte[] getPreviousMatchData() {
        return this.getByteArray("previous_match_data");
    }

    @Override
    public String getRematchId() {
        return this.getString("rematch_id");
    }

    @Override
    public int getStatus() {
        return this.getInteger("status");
    }

    @Override
    public int getTurnStatus() {
        return this.getInteger("user_match_status");
    }

    @Override
    public int getVariant() {
        return this.getInteger("variant");
    }

    @Override
    public int getVersion() {
        return this.getInteger("version");
    }

    @Override
    public int hashCode() {
        return TurnBasedMatchEntity.a(this);
    }

    @Override
    public boolean isLocallyModified() {
        return this.getBoolean("upsync_required");
    }

    public String toString() {
        return TurnBasedMatchEntity.b(this);
    }

    public void writeToParcel(Parcel parcel, int n2) {
        ((TurnBasedMatchEntity)this.freeze()).writeToParcel(parcel, n2);
    }
}

