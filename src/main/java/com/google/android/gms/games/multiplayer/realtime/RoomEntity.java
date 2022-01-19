/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.CharArrayBuffer
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.games.multiplayer.realtime;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.c;
import com.google.android.gms.internal.ds;
import com.google.android.gms.internal.eo;
import com.google.android.gms.internal.ey;
import java.util.ArrayList;

public final class RoomEntity
extends ey
implements Room {
    public static final Parcelable.Creator<RoomEntity> CREATOR = new a();
    private final int kZ;
    private final String pZ;
    private final String rh;
    private final Bundle sO;
    private final String sS;
    private final int sT;
    private final int sU;
    private final long sr;
    private final ArrayList<ParticipantEntity> su;
    private final int sv;

    RoomEntity(int n2, String string2, String string3, long l2, int n3, String string4, int n4, Bundle bundle, ArrayList<ParticipantEntity> arrayList, int n5) {
        this.kZ = n2;
        this.rh = string2;
        this.sS = string3;
        this.sr = l2;
        this.sT = n3;
        this.pZ = string4;
        this.sv = n4;
        this.sO = bundle;
        this.su = arrayList;
        this.sU = n5;
    }

    public RoomEntity(Room room) {
        this.kZ = 2;
        this.rh = room.getRoomId();
        this.sS = room.getCreatorId();
        this.sr = room.getCreationTimestamp();
        this.sT = room.getStatus();
        this.pZ = room.getDescription();
        this.sv = room.getVariant();
        this.sO = room.getAutoMatchCriteria();
        ArrayList arrayList = room.getParticipants();
        int n2 = arrayList.size();
        this.su = new ArrayList(n2);
        int n3 = 0;
        while (true) {
            if (n3 >= n2) {
                this.sU = room.getAutoMatchWaitEstimateSeconds();
                return;
            }
            this.su.add((ParticipantEntity)((Participant)arrayList.get(n3)).freeze());
            ++n3;
        }
    }

    static int a(Room room) {
        return ds.hashCode(room.getRoomId(), room.getCreatorId(), room.getCreationTimestamp(), room.getStatus(), room.getDescription(), room.getVariant(), room.getAutoMatchCriteria(), room.getParticipants(), room.getAutoMatchWaitEstimateSeconds());
    }

    static int a(Room room, String string2) {
        ArrayList arrayList = room.getParticipants();
        int n2 = arrayList.size();
        int n3 = 0;
        while (n3 < n2) {
            Participant participant = (Participant)arrayList.get(n3);
            if (participant.getParticipantId().equals(string2)) {
                return participant.getStatus();
            }
            ++n3;
        }
        throw new IllegalStateException("Participant " + string2 + " is not in room " + room.getRoomId());
    }

    static boolean a(Room room, Object object) {
        boolean bl2 = true;
        if (!(object instanceof Room)) {
            return false;
        }
        boolean bl3 = bl2;
        if (room == object) return bl3;
        if (!ds.equal((object = (Room)object).getRoomId(), room.getRoomId())) return false;
        if (!ds.equal(object.getCreatorId(), room.getCreatorId())) return false;
        if (!ds.equal(object.getCreationTimestamp(), room.getCreationTimestamp())) return false;
        if (!ds.equal(object.getStatus(), room.getStatus())) return false;
        if (!ds.equal(object.getDescription(), room.getDescription())) return false;
        if (!ds.equal(object.getVariant(), room.getVariant())) return false;
        if (!ds.equal(object.getAutoMatchCriteria(), room.getAutoMatchCriteria())) return false;
        if (!ds.equal(object.getParticipants(), room.getParticipants())) return false;
        bl3 = bl2;
        if (ds.equal(object.getAutoMatchWaitEstimateSeconds(), room.getAutoMatchWaitEstimateSeconds())) return bl3;
        return false;
    }

    static String b(Room room) {
        return ds.e(room).a("RoomId", room.getRoomId()).a("CreatorId", room.getCreatorId()).a("CreationTimestamp", room.getCreationTimestamp()).a("RoomStatus", room.getStatus()).a("Description", room.getDescription()).a("Variant", room.getVariant()).a("AutoMatchCriteria", room.getAutoMatchCriteria()).a("Participants", room.getParticipants()).a("AutoMatchWaitEstimateSeconds", room.getAutoMatchWaitEstimateSeconds()).toString();
    }

    static String b(Room object, String string2) {
        object = object.getParticipants();
        int n2 = ((ArrayList)object).size();
        int n3 = 0;
        while (n3 < n2) {
            Participant participant = (Participant)((ArrayList)object).get(n3);
            Player player = participant.getPlayer();
            if (player != null && player.getPlayerId().equals(string2)) {
                return participant.getParticipantId();
            }
            ++n3;
        }
        return null;
    }

    static Participant c(Room room, String string2) {
        ArrayList arrayList = room.getParticipants();
        int n2 = arrayList.size();
        int n3 = 0;
        while (n3 < n2) {
            Participant participant = (Participant)arrayList.get(n3);
            if (participant.getParticipantId().equals(string2)) {
                return participant;
            }
            ++n3;
        }
        throw new IllegalStateException("Participant " + string2 + " is not in match " + room.getRoomId());
    }

    static ArrayList<String> c(Room object) {
        object = object.getParticipants();
        int n2 = ((ArrayList)object).size();
        ArrayList<String> arrayList = new ArrayList<String>(n2);
        int n3 = 0;
        while (n3 < n2) {
            arrayList.add(((Participant)((ArrayList)object).get(n3)).getParticipantId());
            ++n3;
        }
        return arrayList;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        return RoomEntity.a((Room)this, object);
    }

    @Override
    public Room freeze() {
        return this;
    }

    @Override
    public Bundle getAutoMatchCriteria() {
        return this.sO;
    }

    @Override
    public int getAutoMatchWaitEstimateSeconds() {
        return this.sU;
    }

    @Override
    public long getCreationTimestamp() {
        return this.sr;
    }

    @Override
    public String getCreatorId() {
        return this.sS;
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
    public Participant getParticipant(String string2) {
        return RoomEntity.c(this, string2);
    }

    @Override
    public String getParticipantId(String string2) {
        return RoomEntity.b(this, string2);
    }

    @Override
    public ArrayList<String> getParticipantIds() {
        return RoomEntity.c(this);
    }

    @Override
    public int getParticipantStatus(String string2) {
        return RoomEntity.a((Room)this, string2);
    }

    @Override
    public ArrayList<Participant> getParticipants() {
        return new ArrayList<Participant>(this.su);
    }

    @Override
    public String getRoomId() {
        return this.rh;
    }

    @Override
    public int getStatus() {
        return this.sT;
    }

    @Override
    public int getVariant() {
        return this.sv;
    }

    public int getVersionCode() {
        return this.kZ;
    }

    public int hashCode() {
        return RoomEntity.a(this);
    }

    @Override
    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return RoomEntity.b(this);
    }

    public void writeToParcel(Parcel parcel, int n2) {
        if (!this.bz()) {
            c.a(this, parcel, n2);
            return;
        }
        parcel.writeString(this.rh);
        parcel.writeString(this.sS);
        parcel.writeLong(this.sr);
        parcel.writeInt(this.sT);
        parcel.writeString(this.pZ);
        parcel.writeInt(this.sv);
        parcel.writeBundle(this.sO);
        int n3 = this.su.size();
        parcel.writeInt(n3);
        int n4 = 0;
        while (n4 < n3) {
            this.su.get(n4).writeToParcel(parcel, n2);
            ++n4;
        }
    }

    static final class a
    extends c {
        a() {
        }

        @Override
        public RoomEntity Z(Parcel parcel) {
            if (RoomEntity.c(RoomEntity.by())) return super.Z(parcel);
            if (RoomEntity.D(RoomEntity.class.getCanonicalName())) {
                return super.Z(parcel);
            }
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            long l2 = parcel.readLong();
            int n2 = parcel.readInt();
            String string4 = parcel.readString();
            int n3 = parcel.readInt();
            Bundle bundle = parcel.readBundle();
            int n4 = parcel.readInt();
            ArrayList<ParticipantEntity> arrayList = new ArrayList<ParticipantEntity>(n4);
            int n5 = 0;
            while (n5 < n4) {
                arrayList.add((ParticipantEntity)ParticipantEntity.CREATOR.createFromParcel(parcel));
                ++n5;
            }
            return new RoomEntity(2, string2, string3, l2, n2, string4, n3, bundle, arrayList, -1);
        }

        @Override
        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return this.Z(parcel);
        }
    }
}

