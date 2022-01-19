/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.games.multiplayer.realtime;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.d;

public final class b
extends com.google.android.gms.common.data.d<Room> {
    public b(DataHolder dataHolder) {
        super(dataHolder);
    }

    @Override
    protected /* synthetic */ Object a(int n2, int n3) {
        return this.b(n2, n3);
    }

    protected Room b(int n2, int n3) {
        return new d(this.lb, n2, n3);
    }

    @Override
    protected String getPrimaryDataMarkerColumn() {
        return "external_match_id";
    }
}

