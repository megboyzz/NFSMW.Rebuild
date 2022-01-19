/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 */
package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationEntity;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.e;
import com.google.android.gms.internal.du;
import java.util.ArrayList;

public final class b
extends com.google.android.gms.common.data.b
implements Invitation {
    private final ArrayList<Participant> su;
    private final Game sw;
    private final e sx;

    b(DataHolder parcelable, int n2, int n3) {
        super((DataHolder)parcelable, n2);
        this.sw = new com.google.android.gms.games.b((DataHolder)parcelable, n2);
        this.su = new ArrayList(n3);
        String string2 = this.getString("external_inviter_id");
        n2 = 0;
        parcelable = null;
        while (true) {
            if (n2 >= n3) {
                this.sx = (e)((Object)du.c(parcelable, "Must have a valid inviter!"));
                return;
            }
            e e2 = new e(this.lb, this.ld + n2);
            if (e2.getParticipantId().equals(string2)) {
                parcelable = e2;
            }
            this.su.add(e2);
            ++n2;
        }
    }

    public int describeContents() {
        return 0;
    }

    @Override
    public boolean equals(Object object) {
        return InvitationEntity.a(this, object);
    }

    @Override
    public Invitation freeze() {
        return new InvitationEntity(this);
    }

    @Override
    public long getCreationTimestamp() {
        return Math.max(this.getLong("creation_timestamp"), this.getLong("last_modified_timestamp"));
    }

    @Override
    public Game getGame() {
        return this.sw;
    }

    @Override
    public String getInvitationId() {
        return this.getString("external_invitation_id");
    }

    @Override
    public int getInvitationType() {
        return this.getInteger("type");
    }

    @Override
    public Participant getInviter() {
        return this.sx;
    }

    @Override
    public ArrayList<Participant> getParticipants() {
        return this.su;
    }

    @Override
    public int getVariant() {
        return this.getInteger("variant");
    }

    @Override
    public int hashCode() {
        return InvitationEntity.a(this);
    }

    public String toString() {
        return InvitationEntity.b(this);
    }

    public void writeToParcel(Parcel parcel, int n2) {
        ((InvitationEntity)this.freeze()).writeToParcel(parcel, n2);
    }
}

