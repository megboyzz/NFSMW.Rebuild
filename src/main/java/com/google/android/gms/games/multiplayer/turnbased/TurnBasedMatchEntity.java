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
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchEntityCreator;
import com.google.android.gms.internal.ds;
import java.util.ArrayList;

public final class TurnBasedMatchEntity
implements SafeParcelable,
TurnBasedMatch {
    public static final TurnBasedMatchEntityCreator CREATOR = new TurnBasedMatchEntityCreator();
    private final int kZ;
    private final String ri;
    private final Bundle sO;
    private final String sS;
    private final GameEntity sq;
    private final long sr;
    private final ArrayList<ParticipantEntity> su;
    private final int sv;
    private final String tb;
    private final long tc;
    private final String td;
    private final int te;
    private final int tf;
    private final byte[] tg;
    private final String th;
    private final byte[] ti;
    private final int tj;
    private final int tk;
    private final boolean tl;

    TurnBasedMatchEntity(int n2, GameEntity gameEntity, String string2, String string3, long l2, String string4, long l3, String string5, int n3, int n4, int n5, byte[] byArray, ArrayList<ParticipantEntity> arrayList, String string6, byte[] byArray2, int n6, Bundle bundle, int n7, boolean bl2) {
        this.kZ = n2;
        this.sq = gameEntity;
        this.ri = string2;
        this.sS = string3;
        this.sr = l2;
        this.tb = string4;
        this.tc = l3;
        this.td = string5;
        this.te = n3;
        this.tk = n7;
        this.sv = n4;
        this.tf = n5;
        this.tg = byArray;
        this.su = arrayList;
        this.th = string6;
        this.ti = byArray2;
        this.tj = n6;
        this.sO = bundle;
        this.tl = bl2;
    }

    public TurnBasedMatchEntity(TurnBasedMatch object) {
        this.kZ = 2;
        this.sq = new GameEntity(object.getGame());
        this.ri = object.getMatchId();
        this.sS = object.getCreatorId();
        this.sr = object.getCreationTimestamp();
        this.tb = object.getLastUpdaterId();
        this.tc = object.getLastUpdatedTimestamp();
        this.td = object.getPendingParticipantId();
        this.te = object.getStatus();
        this.tk = object.getTurnStatus();
        this.sv = object.getVariant();
        this.tf = object.getVersion();
        this.th = object.getRematchId();
        this.tj = object.getMatchNumber();
        this.sO = object.getAutoMatchCriteria();
        this.tl = object.isLocallyModified();
        byte[] byArray = object.getData();
        if (byArray == null) {
            this.tg = null;
        } else {
            this.tg = new byte[byArray.length];
            System.arraycopy(byArray, 0, this.tg, 0, byArray.length);
        }
        if ((byArray = object.getPreviousMatchData()) == null) {
            this.ti = null;
        } else {
            this.ti = new byte[byArray.length];
            System.arraycopy(byArray, 0, this.ti, 0, byArray.length);
        }
        object = object.getParticipants();
        int n2 = ((ArrayList)object).size();
        this.su = new ArrayList(n2);
        int n3 = 0;
        while (n3 < n2) {
            this.su.add((ParticipantEntity)((Participant)((ArrayList)object).get(n3)).freeze());
            ++n3;
        }
    }

    static int a(TurnBasedMatch turnBasedMatch) {
        return ds.hashCode(turnBasedMatch.getGame(), turnBasedMatch.getMatchId(), turnBasedMatch.getCreatorId(), turnBasedMatch.getCreationTimestamp(), turnBasedMatch.getLastUpdaterId(), turnBasedMatch.getLastUpdatedTimestamp(), turnBasedMatch.getPendingParticipantId(), turnBasedMatch.getStatus(), turnBasedMatch.getTurnStatus(), turnBasedMatch.getVariant(), turnBasedMatch.getVersion(), turnBasedMatch.getParticipants(), turnBasedMatch.getRematchId(), turnBasedMatch.getMatchNumber(), turnBasedMatch.getAutoMatchCriteria(), turnBasedMatch.getAvailableAutoMatchSlots(), turnBasedMatch.isLocallyModified());
    }

    static int a(TurnBasedMatch turnBasedMatch, String string2) {
        ArrayList arrayList = turnBasedMatch.getParticipants();
        int n2 = arrayList.size();
        int n3 = 0;
        while (n3 < n2) {
            Participant participant = (Participant)arrayList.get(n3);
            if (participant.getParticipantId().equals(string2)) {
                return participant.getStatus();
            }
            ++n3;
        }
        throw new IllegalStateException("Participant " + string2 + " is not in match " + turnBasedMatch.getMatchId());
    }

    static boolean a(TurnBasedMatch turnBasedMatch, Object object) {
        boolean bl2 = true;
        if (!(object instanceof TurnBasedMatch)) {
            return false;
        }
        boolean bl3 = bl2;
        if (turnBasedMatch == object) return bl3;
        if (!ds.equal((object = (TurnBasedMatch)object).getGame(), turnBasedMatch.getGame())) return false;
        if (!ds.equal(object.getMatchId(), turnBasedMatch.getMatchId())) return false;
        if (!ds.equal(object.getCreatorId(), turnBasedMatch.getCreatorId())) return false;
        if (!ds.equal(object.getCreationTimestamp(), turnBasedMatch.getCreationTimestamp())) return false;
        if (!ds.equal(object.getLastUpdaterId(), turnBasedMatch.getLastUpdaterId())) return false;
        if (!ds.equal(object.getLastUpdatedTimestamp(), turnBasedMatch.getLastUpdatedTimestamp())) return false;
        if (!ds.equal(object.getPendingParticipantId(), turnBasedMatch.getPendingParticipantId())) return false;
        if (!ds.equal(object.getStatus(), turnBasedMatch.getStatus())) return false;
        if (!ds.equal(object.getTurnStatus(), turnBasedMatch.getTurnStatus())) return false;
        if (!ds.equal(object.getVariant(), turnBasedMatch.getVariant())) return false;
        if (!ds.equal(object.getVersion(), turnBasedMatch.getVersion())) return false;
        if (!ds.equal(object.getParticipants(), turnBasedMatch.getParticipants())) return false;
        if (!ds.equal(object.getRematchId(), turnBasedMatch.getRematchId())) return false;
        if (!ds.equal(object.getMatchNumber(), turnBasedMatch.getMatchNumber())) return false;
        if (!ds.equal(object.getAutoMatchCriteria(), turnBasedMatch.getAutoMatchCriteria())) return false;
        if (!ds.equal(object.getAvailableAutoMatchSlots(), turnBasedMatch.getAvailableAutoMatchSlots())) return false;
        bl3 = bl2;
        if (ds.equal(object.isLocallyModified(), turnBasedMatch.isLocallyModified())) return bl3;
        return false;
    }

    static String b(TurnBasedMatch turnBasedMatch) {
        return ds.e(turnBasedMatch).a("Game", turnBasedMatch.getGame()).a("MatchId", turnBasedMatch.getMatchId()).a("CreatorId", turnBasedMatch.getCreatorId()).a("CreationTimestamp", turnBasedMatch.getCreationTimestamp()).a("LastUpdaterId", turnBasedMatch.getLastUpdaterId()).a("LastUpdatedTimestamp", turnBasedMatch.getLastUpdatedTimestamp()).a("PendingParticipantId", turnBasedMatch.getPendingParticipantId()).a("MatchStatus", turnBasedMatch.getStatus()).a("TurnStatus", turnBasedMatch.getTurnStatus()).a("Variant", turnBasedMatch.getVariant()).a("Data", turnBasedMatch.getData()).a("Version", turnBasedMatch.getVersion()).a("Participants", turnBasedMatch.getParticipants()).a("RematchId", turnBasedMatch.getRematchId()).a("PreviousData", turnBasedMatch.getPreviousMatchData()).a("MatchNumber", turnBasedMatch.getMatchNumber()).a("AutoMatchCriteria", turnBasedMatch.getAutoMatchCriteria()).a("AvailableAutoMatchSlots", turnBasedMatch.getAvailableAutoMatchSlots()).a("LocallyModified", turnBasedMatch.isLocallyModified()).toString();
    }

    static String b(TurnBasedMatch object, String string2) {
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

    static Participant c(TurnBasedMatch turnBasedMatch, String string2) {
        ArrayList arrayList = turnBasedMatch.getParticipants();
        int n2 = arrayList.size();
        int n3 = 0;
        while (n3 < n2) {
            Participant participant = (Participant)arrayList.get(n3);
            if (participant.getParticipantId().equals(string2)) {
                return participant;
            }
            ++n3;
        }
        throw new IllegalStateException("Participant " + string2 + " is not in match " + turnBasedMatch.getMatchId());
    }

    static ArrayList<String> c(TurnBasedMatch object) {
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

    @Override
    public boolean canRematch() {
        if (this.te != 2) return false;
        if (this.th != null) return false;
        return true;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        return TurnBasedMatchEntity.a((TurnBasedMatch)this, object);
    }

    @Override
    public TurnBasedMatch freeze() {
        return this;
    }

    @Override
    public Bundle getAutoMatchCriteria() {
        return this.sO;
    }

    @Override
    public int getAvailableAutoMatchSlots() {
        if (this.sO != null) return this.sO.getInt("max_automatch_players");
        return 0;
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
    public byte[] getData() {
        return this.tg;
    }

    @Override
    public Game getGame() {
        return this.sq;
    }

    @Override
    public long getLastUpdatedTimestamp() {
        return this.tc;
    }

    @Override
    public String getLastUpdaterId() {
        return this.tb;
    }

    @Override
    public String getMatchId() {
        return this.ri;
    }

    @Override
    public int getMatchNumber() {
        return this.tj;
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
        return new ArrayList<Participant>(this.su);
    }

    @Override
    public String getPendingParticipantId() {
        return this.td;
    }

    @Override
    public byte[] getPreviousMatchData() {
        return this.ti;
    }

    @Override
    public String getRematchId() {
        return this.th;
    }

    @Override
    public int getStatus() {
        return this.te;
    }

    @Override
    public int getTurnStatus() {
        return this.tk;
    }

    @Override
    public int getVariant() {
        return this.sv;
    }

    @Override
    public int getVersion() {
        return this.tf;
    }

    public int getVersionCode() {
        return this.kZ;
    }

    public int hashCode() {
        return TurnBasedMatchEntity.a(this);
    }

    @Override
    public boolean isDataValid() {
        return true;
    }

    @Override
    public boolean isLocallyModified() {
        return this.tl;
    }

    public String toString() {
        return TurnBasedMatchEntity.b(this);
    }

    public void writeToParcel(Parcel parcel, int n2) {
        TurnBasedMatchEntityCreator.a(this, parcel, n2);
    }
}

