/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.internal.ds;
import com.google.android.gms.internal.du;
import com.google.android.gms.internal.ey;
import java.util.ArrayList;

public final class InvitationEntity
extends ey
implements Invitation {
    public static final Parcelable.Creator<InvitationEntity> CREATOR = new a();
    private final int kZ;
    private final String rc;
    private final GameEntity sq;
    private final long sr;
    private final int ss;
    private final ParticipantEntity st;
    private final ArrayList<ParticipantEntity> su;
    private final int sv;

    InvitationEntity(int n2, GameEntity gameEntity, String string2, long l2, int n3, ParticipantEntity participantEntity, ArrayList<ParticipantEntity> arrayList, int n4) {
        this.kZ = n2;
        this.sq = gameEntity;
        this.rc = string2;
        this.sr = l2;
        this.ss = n3;
        this.st = participantEntity;
        this.su = arrayList;
        this.sv = n4;
    }

    InvitationEntity(Invitation parcelable) {
        this.kZ = 1;
        this.sq = new GameEntity(parcelable.getGame());
        this.rc = parcelable.getInvitationId();
        this.sr = parcelable.getCreationTimestamp();
        this.ss = parcelable.getInvitationType();
        this.sv = parcelable.getVariant();
        String string2 = parcelable.getInviter().getParticipantId();
        Participant participant = null;
        ArrayList arrayList = parcelable.getParticipants();
        int n2 = arrayList.size();
        this.su = new ArrayList(n2);
        int n3 = 0;
        parcelable = participant;
        while (true) {
            if (n3 >= n2) {
                du.c(parcelable, "Must have a valid inviter!");
                this.st = (ParticipantEntity)parcelable.freeze();
                return;
            }
            participant = (Participant)arrayList.get(n3);
            if (participant.getParticipantId().equals(string2)) {
                parcelable = participant;
            }
            this.su.add((ParticipantEntity)participant.freeze());
            ++n3;
        }
    }

    static int a(Invitation invitation) {
        return ds.hashCode(invitation.getGame(), invitation.getInvitationId(), invitation.getCreationTimestamp(), invitation.getInvitationType(), invitation.getInviter(), invitation.getParticipants(), invitation.getVariant());
    }

    static boolean a(Invitation invitation, Object object) {
        boolean bl2 = true;
        if (!(object instanceof Invitation)) {
            return false;
        }
        boolean bl3 = bl2;
        if (invitation == object) return bl3;
        if (!ds.equal((object = (Invitation)object).getGame(), invitation.getGame())) return false;
        if (!ds.equal(object.getInvitationId(), invitation.getInvitationId())) return false;
        if (!ds.equal(object.getCreationTimestamp(), invitation.getCreationTimestamp())) return false;
        if (!ds.equal(object.getInvitationType(), invitation.getInvitationType())) return false;
        if (!ds.equal(object.getInviter(), invitation.getInviter())) return false;
        if (!ds.equal(object.getParticipants(), invitation.getParticipants())) return false;
        bl3 = bl2;
        if (ds.equal(object.getVariant(), invitation.getVariant())) return bl3;
        return false;
    }

    static String b(Invitation invitation) {
        return ds.e(invitation).a("Game", invitation.getGame()).a("InvitationId", invitation.getInvitationId()).a("CreationTimestamp", invitation.getCreationTimestamp()).a("InvitationType", invitation.getInvitationType()).a("Inviter", invitation.getInviter()).a("Participants", invitation.getParticipants()).a("Variant", invitation.getVariant()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        return InvitationEntity.a(this, object);
    }

    @Override
    public Invitation freeze() {
        return this;
    }

    @Override
    public long getCreationTimestamp() {
        return this.sr;
    }

    @Override
    public Game getGame() {
        return this.sq;
    }

    @Override
    public String getInvitationId() {
        return this.rc;
    }

    @Override
    public int getInvitationType() {
        return this.ss;
    }

    @Override
    public Participant getInviter() {
        return this.st;
    }

    @Override
    public ArrayList<Participant> getParticipants() {
        return new ArrayList<Participant>(this.su);
    }

    @Override
    public int getVariant() {
        return this.sv;
    }

    public int getVersionCode() {
        return this.kZ;
    }

    public int hashCode() {
        return InvitationEntity.a(this);
    }

    @Override
    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return InvitationEntity.b(this);
    }

    public void writeToParcel(Parcel parcel, int n2) {
        if (!this.bz()) {
            com.google.android.gms.games.multiplayer.a.a(this, parcel, n2);
            return;
        }
        this.sq.writeToParcel(parcel, n2);
        parcel.writeString(this.rc);
        parcel.writeLong(this.sr);
        parcel.writeInt(this.ss);
        this.st.writeToParcel(parcel, n2);
        int n3 = this.su.size();
        parcel.writeInt(n3);
        int n4 = 0;
        while (n4 < n3) {
            this.su.get(n4).writeToParcel(parcel, n2);
            ++n4;
        }
    }

    static final class a
    extends com.google.android.gms.games.multiplayer.a {
        a() {
        }

        @Override
        public InvitationEntity W(Parcel parcel) {
            if (InvitationEntity.c(InvitationEntity.by())) return super.W(parcel);
            if (InvitationEntity.D(InvitationEntity.class.getCanonicalName())) {
                return super.W(parcel);
            }
            GameEntity gameEntity = (GameEntity)GameEntity.CREATOR.createFromParcel(parcel);
            String string2 = parcel.readString();
            long l2 = parcel.readLong();
            int n2 = parcel.readInt();
            ParticipantEntity participantEntity = (ParticipantEntity)ParticipantEntity.CREATOR.createFromParcel(parcel);
            int n3 = parcel.readInt();
            ArrayList<ParticipantEntity> arrayList = new ArrayList<ParticipantEntity>(n3);
            int n4 = 0;
            while (n4 < n3) {
                arrayList.add((ParticipantEntity)ParticipantEntity.CREATOR.createFromParcel(parcel));
                ++n4;
            }
            return new InvitationEntity(1, gameEntity, string2, l2, n2, participantEntity, arrayList, -1);
        }

        @Override
        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return this.W(parcel);
        }
    }
}

