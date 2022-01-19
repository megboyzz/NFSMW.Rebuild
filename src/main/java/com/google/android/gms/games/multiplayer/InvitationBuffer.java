/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.games.multiplayer;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.b;

public final class InvitationBuffer
extends d<Invitation> {
    public InvitationBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    @Override
    protected /* synthetic */ Object a(int n2, int n3) {
        return this.getEntry(n2, n3);
    }

    protected Invitation getEntry(int n2, int n3) {
        return new b(this.lb, n2, n3);
    }

    @Override
    protected String getPrimaryDataMarkerColumn() {
        return "external_invitation_id";
    }
}

