/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.appstate;

import com.google.android.gms.appstate.AppState;
import com.google.android.gms.appstate.a;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.b;

public final class c
extends b
implements AppState {
    c(DataHolder dataHolder, int n2) {
        super(dataHolder, n2);
    }

    public AppState aJ() {
        return new a(this);
    }

    @Override
    public boolean equals(Object object) {
        return a.a(this, object);
    }

    @Override
    public /* synthetic */ Object freeze() {
        return this.aJ();
    }

    @Override
    public byte[] getConflictData() {
        return this.getByteArray("conflict_data");
    }

    @Override
    public String getConflictVersion() {
        return this.getString("conflict_version");
    }

    @Override
    public int getKey() {
        return this.getInteger("key");
    }

    @Override
    public byte[] getLocalData() {
        return this.getByteArray("local_data");
    }

    @Override
    public String getLocalVersion() {
        return this.getString("local_version");
    }

    @Override
    public boolean hasConflict() {
        if (this.A("conflict_version")) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return a.a(this);
    }

    public String toString() {
        return a.b(this);
    }
}

