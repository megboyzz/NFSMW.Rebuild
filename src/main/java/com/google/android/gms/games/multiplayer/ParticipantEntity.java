/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.CharArrayBuffer
 *  android.net.Uri
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.d;
import com.google.android.gms.internal.ds;
import com.google.android.gms.internal.eo;
import com.google.android.gms.internal.ey;

public final class ParticipantEntity
extends ey
implements Participant {
    public static final Parcelable.Creator<ParticipantEntity> CREATOR = new a();
    private final int kZ;
    private final String pW;
    private final Uri qb;
    private final Uri qc;
    private final String rm;
    private final boolean sA;
    private final PlayerEntity sB;
    private final int sC;
    private final ParticipantResult sD;
    private final int sy;
    private final String sz;

    ParticipantEntity(int n2, String string2, String string3, Uri uri, Uri uri2, int n3, String string4, boolean bl2, PlayerEntity playerEntity, int n4, ParticipantResult participantResult) {
        this.kZ = n2;
        this.rm = string2;
        this.pW = string3;
        this.qb = uri;
        this.qc = uri2;
        this.sy = n3;
        this.sz = string4;
        this.sA = bl2;
        this.sB = playerEntity;
        this.sC = n4;
        this.sD = participantResult;
    }

    public ParticipantEntity(Participant participant) {
        this.kZ = 2;
        this.rm = participant.getParticipantId();
        this.pW = participant.getDisplayName();
        this.qb = participant.getIconImageUri();
        this.qc = participant.getHiResImageUri();
        this.sy = participant.getStatus();
        this.sz = participant.dm();
        this.sA = participant.isConnectedToRoom();
        Player player = participant.getPlayer();
        player = player == null ? null : new PlayerEntity(player);
        this.sB = player;
        this.sC = participant.getCapabilities();
        this.sD = participant.getResult();
    }

    static int a(Participant participant) {
        return ds.hashCode(participant.getPlayer(), participant.getStatus(), participant.dm(), participant.isConnectedToRoom(), participant.getDisplayName(), participant.getIconImageUri(), participant.getHiResImageUri(), participant.getCapabilities(), participant.getResult());
    }

    static boolean a(Participant participant, Object object) {
        boolean bl2 = true;
        if (!(object instanceof Participant)) {
            return false;
        }
        boolean bl3 = bl2;
        if (participant == object) return bl3;
        if (!ds.equal((object = (Participant)object).getPlayer(), participant.getPlayer())) return false;
        if (!ds.equal(object.getStatus(), participant.getStatus())) return false;
        if (!ds.equal(object.dm(), participant.dm())) return false;
        if (!ds.equal(object.isConnectedToRoom(), participant.isConnectedToRoom())) return false;
        if (!ds.equal(object.getDisplayName(), participant.getDisplayName())) return false;
        if (!ds.equal(object.getIconImageUri(), participant.getIconImageUri())) return false;
        if (!ds.equal(object.getHiResImageUri(), participant.getHiResImageUri())) return false;
        if (!ds.equal(object.getCapabilities(), participant.getCapabilities())) return false;
        bl3 = bl2;
        if (ds.equal(object.getResult(), participant.getResult())) return bl3;
        return false;
    }

    static String b(Participant participant) {
        return ds.e(participant).a("Player", participant.getPlayer()).a("Status", participant.getStatus()).a("ClientAddress", participant.dm()).a("ConnectedToRoom", participant.isConnectedToRoom()).a("DisplayName", participant.getDisplayName()).a("IconImage", participant.getIconImageUri()).a("HiResImage", participant.getHiResImageUri()).a("Capabilities", participant.getCapabilities()).a("Result", participant.getResult()).toString();
    }

    public int describeContents() {
        return 0;
    }

    @Override
    public String dm() {
        return this.sz;
    }

    public boolean equals(Object object) {
        return ParticipantEntity.a(this, object);
    }

    @Override
    public Participant freeze() {
        return this;
    }

    @Override
    public int getCapabilities() {
        return this.sC;
    }

    @Override
    public String getDisplayName() {
        if (this.sB != null) return this.sB.getDisplayName();
        return this.pW;
    }

    @Override
    public void getDisplayName(CharArrayBuffer charArrayBuffer) {
        if (this.sB == null) {
            eo.b(this.pW, charArrayBuffer);
            return;
        }
        this.sB.getDisplayName(charArrayBuffer);
    }

    @Override
    public Uri getHiResImageUri() {
        if (this.sB != null) return this.sB.getHiResImageUri();
        return this.qc;
    }

    @Override
    public Uri getIconImageUri() {
        if (this.sB != null) return this.sB.getIconImageUri();
        return this.qb;
    }

    @Override
    public String getParticipantId() {
        return this.rm;
    }

    @Override
    public Player getPlayer() {
        return this.sB;
    }

    @Override
    public ParticipantResult getResult() {
        return this.sD;
    }

    @Override
    public int getStatus() {
        return this.sy;
    }

    public int getVersionCode() {
        return this.kZ;
    }

    public int hashCode() {
        return ParticipantEntity.a(this);
    }

    @Override
    public boolean isConnectedToRoom() {
        return this.sA;
    }

    @Override
    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return ParticipantEntity.b(this);
    }

    public void writeToParcel(Parcel parcel, int n2) {
        Object var6_3 = null;
        int n3 = 0;
        if (!this.bz()) {
            d.a(this, parcel, n2);
            return;
        }
        parcel.writeString(this.rm);
        parcel.writeString(this.pW);
        String string2 = this.qb == null ? null : this.qb.toString();
        parcel.writeString(string2);
        string2 = this.qc == null ? var6_3 : this.qc.toString();
        parcel.writeString(string2);
        parcel.writeInt(this.sy);
        parcel.writeString(this.sz);
        int n4 = this.sA ? 1 : 0;
        parcel.writeInt(n4);
        n4 = this.sB == null ? n3 : 1;
        parcel.writeInt(n4);
        if (this.sB == null) return;
        this.sB.writeToParcel(parcel, n2);
    }

    static final class a
    extends d {
        a() {
        }

        @Override
        public ParticipantEntity X(Parcel object) {
            boolean bl2 = true;
            if (ParticipantEntity.c(ParticipantEntity.by())) return super.X((Parcel)object);
            if (ParticipantEntity.D(ParticipantEntity.class.getCanonicalName())) {
                return super.X((Parcel)object);
            }
            String string2 = object.readString();
            String string3 = object.readString();
            String string4 = object.readString();
            string4 = string4 == null ? null : Uri.parse((String)string4);
            String string5 = object.readString();
            string5 = string5 == null ? null : Uri.parse((String)string5);
            int n2 = object.readInt();
            String string6 = object.readString();
            boolean bl3 = object.readInt() > 0;
            if (object.readInt() <= 0) {
                bl2 = false;
            }
            if (bl2) {
                object = (PlayerEntity)PlayerEntity.CREATOR.createFromParcel(object);
                return new ParticipantEntity(2, string2, string3, (Uri)string4, (Uri)string5, n2, string6, bl3, (PlayerEntity)object, 7, null);
            }
            object = null;
            return new ParticipantEntity(2, string2, string3, (Uri)string4, (Uri)string5, n2, string6, bl3, (PlayerEntity)object, 7, null);
        }

        @Override
        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return this.X(parcel);
        }
    }
}

