/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.games.multiplayer;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.games.multiplayer.InvitationBuffer;

public interface c {

    public static interface a
    extends Releasable,
    Result {
        public InvitationBuffer getInvitations();
    }
}

