/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchBuffer;
import com.google.android.gms.internal.fi;

public final class LoadMatchesResponse {
    private final InvitationBuffer sV;
    private final TurnBasedMatchBuffer sW;
    private final TurnBasedMatchBuffer sX;
    private final TurnBasedMatchBuffer sY;

    public LoadMatchesResponse(Bundle object) {
        DataHolder dataHolder = LoadMatchesResponse.a(object, 0);
        this.sV = dataHolder != null ? new InvitationBuffer(dataHolder) : null;
        dataHolder = LoadMatchesResponse.a(object, 1);
        this.sW = dataHolder != null ? new TurnBasedMatchBuffer(dataHolder) : null;
        dataHolder = LoadMatchesResponse.a(object, 2);
        this.sX = dataHolder != null ? new TurnBasedMatchBuffer(dataHolder) : null;
        if ((object = LoadMatchesResponse.a(object, 3)) != null) {
            this.sY = new TurnBasedMatchBuffer((DataHolder)object);
            return;
        }
        this.sY = null;
    }

    private static DataHolder a(Bundle bundle, int n2) {
        String string2 = fi.at(n2);
        if (bundle.containsKey(string2)) return (DataHolder)bundle.getParcelable(string2);
        return null;
    }

    public TurnBasedMatchBuffer getCompletedMatches() {
        return this.sY;
    }

    public InvitationBuffer getInvitations() {
        return this.sV;
    }

    public TurnBasedMatchBuffer getMyTurnMatches() {
        return this.sW;
    }

    public TurnBasedMatchBuffer getTheirTurnMatches() {
        return this.sX;
    }
}

