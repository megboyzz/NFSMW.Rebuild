/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.internal.du;
import java.util.ArrayList;
import java.util.Arrays;

public final class RoomConfig {
    private final String rc;
    private final RoomUpdateListener sK;
    private final RoomStatusUpdateListener sL;
    private final RealTimeMessageReceivedListener sM;
    private final String[] sN;
    private final Bundle sO;
    private final boolean sP;
    private final int sv;

    private RoomConfig(Builder builder) {
        this.sK = builder.sK;
        this.sL = builder.sL;
        this.sM = builder.sM;
        this.rc = builder.sQ;
        this.sv = builder.sv;
        this.sO = builder.sO;
        this.sP = builder.sP;
        int n2 = builder.sR.size();
        this.sN = builder.sR.toArray(new String[n2]);
        if (this.sM != null) return;
        du.a(this.sP, "Must either enable sockets OR specify a message listener");
    }

    public static Builder builder(RoomUpdateListener roomUpdateListener) {
        return new Builder(roomUpdateListener);
    }

    public static Bundle createAutoMatchCriteria(int n2, int n3, long l2) {
        Bundle bundle = new Bundle();
        bundle.putInt("min_automatch_players", n2);
        bundle.putInt("max_automatch_players", n3);
        bundle.putLong("exclusive_bit_mask", l2);
        return bundle;
    }

    public Bundle getAutoMatchCriteria() {
        return this.sO;
    }

    public String getInvitationId() {
        return this.rc;
    }

    public String[] getInvitedPlayerIds() {
        return this.sN;
    }

    public RealTimeMessageReceivedListener getMessageReceivedListener() {
        return this.sM;
    }

    public RoomStatusUpdateListener getRoomStatusUpdateListener() {
        return this.sL;
    }

    public RoomUpdateListener getRoomUpdateListener() {
        return this.sK;
    }

    public int getVariant() {
        return this.sv;
    }

    public boolean isSocketEnabled() {
        return this.sP;
    }

    public static final class Builder {
        final RoomUpdateListener sK;
        RoomStatusUpdateListener sL;
        RealTimeMessageReceivedListener sM;
        Bundle sO;
        boolean sP = false;
        String sQ = null;
        ArrayList<String> sR = new ArrayList();
        int sv = -1;

        private Builder(RoomUpdateListener roomUpdateListener) {
            this.sK = du.c(roomUpdateListener, "Must provide a RoomUpdateListener");
        }

        public Builder addPlayersToInvite(ArrayList<String> arrayList) {
            du.f(arrayList);
            this.sR.addAll(arrayList);
            return this;
        }

        public Builder addPlayersToInvite(String ... stringArray) {
            du.f(stringArray);
            this.sR.addAll(Arrays.asList(stringArray));
            return this;
        }

        public RoomConfig build() {
            return new RoomConfig(this);
        }

        public Builder setAutoMatchCriteria(Bundle bundle) {
            this.sO = bundle;
            return this;
        }

        public Builder setInvitationIdToAccept(String string2) {
            du.f(string2);
            this.sQ = string2;
            return this;
        }

        public Builder setMessageReceivedListener(RealTimeMessageReceivedListener realTimeMessageReceivedListener) {
            this.sM = realTimeMessageReceivedListener;
            return this;
        }

        public Builder setRoomStatusUpdateListener(RoomStatusUpdateListener roomStatusUpdateListener) {
            this.sL = roomStatusUpdateListener;
            return this;
        }

        public Builder setSocketCommunicationEnabled(boolean bl2) {
            this.sP = bl2;
            return this;
        }

        public Builder setVariant(int n2) {
            boolean bl2 = n2 == -1 || n2 > 0;
            du.b(bl2, "Variant must be a positive integer or Room.ROOM_VARIANT_ANY");
            this.sv = n2;
            return this;
        }
    }
}

