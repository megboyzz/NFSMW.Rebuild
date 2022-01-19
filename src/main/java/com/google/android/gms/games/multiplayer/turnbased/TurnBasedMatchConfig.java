/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.internal.du;
import java.util.ArrayList;

public final class TurnBasedMatchConfig {
    private final String[] sN;
    private final Bundle sO;
    private final int sv;
    private final int ta;

    private TurnBasedMatchConfig(Builder builder) {
        this.sv = builder.sv;
        this.ta = builder.ta;
        this.sO = builder.sO;
        int n2 = builder.sR.size();
        this.sN = builder.sR.toArray(new String[n2]);
    }

    public static Builder builder() {
        return new Builder();
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

    public String[] getInvitedPlayerIds() {
        return this.sN;
    }

    public int getMinPlayers() {
        return this.ta;
    }

    public int getVariant() {
        return this.sv;
    }

    public static final class Builder {
        Bundle sO = null;
        ArrayList<String> sR = new ArrayList();
        int sv = -1;
        int ta = 2;

        private Builder() {
        }

        public Builder addInvitedPlayer(String string2) {
            du.f(string2);
            this.sR.add(string2);
            return this;
        }

        public Builder addInvitedPlayers(ArrayList<String> arrayList) {
            du.f(arrayList);
            this.sR.addAll(arrayList);
            return this;
        }

        public TurnBasedMatchConfig build() {
            return new TurnBasedMatchConfig(this);
        }

        public Builder setAutoMatchCriteria(Bundle bundle) {
            this.sO = bundle;
            return this;
        }

        public Builder setMinPlayers(int n2) {
            this.ta = n2;
            return this;
        }

        public Builder setVariant(int n2) {
            boolean bl2 = n2 == -1 || n2 > 0;
            du.b(bl2, "Variant must be a positive integer or TurnBasedMatch.MATCH_VARIANT_ANY");
            this.sv = n2;
            return this;
        }
    }
}

