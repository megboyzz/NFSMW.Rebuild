/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.games.multiplayer;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.e;

public final class ParticipantBuffer
extends DataBuffer<Participant> {
    @Override
    public Participant get(int n2) {
        return new e(this.lb, n2);
    }
}

