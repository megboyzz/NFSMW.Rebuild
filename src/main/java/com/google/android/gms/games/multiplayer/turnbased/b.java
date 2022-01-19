/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.games.multiplayer.turnbased;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;

public interface b {

    public static interface a
    extends Result {
        public String getMatchId();
    }

    public static interface b
    extends Result {
        public TurnBasedMatch cT();
    }

    public static interface c
    extends Result {
        public TurnBasedMatch cT();
    }

    public static interface d
    extends Result {
        public TurnBasedMatch cT();
    }

    public static interface e
    extends Releasable,
    Result {
        public LoadMatchesResponse cU();
    }

    public static interface f
    extends Result {
        public TurnBasedMatch cT();
    }
}

