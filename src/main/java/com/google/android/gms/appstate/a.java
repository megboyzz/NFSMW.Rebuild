/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.appstate;

import com.google.android.gms.appstate.AppState;
import com.google.android.gms.internal.ds;

public final class a
implements AppState {
    private final int jF;
    private final String jG;
    private final byte[] jH;
    private final boolean jI;
    private final String jJ;
    private final byte[] jK;

    public a(AppState appState) {
        this.jF = appState.getKey();
        this.jG = appState.getLocalVersion();
        this.jH = appState.getLocalData();
        this.jI = appState.hasConflict();
        this.jJ = appState.getConflictVersion();
        this.jK = appState.getConflictData();
    }

    static int a(AppState appState) {
        return ds.hashCode(appState.getKey(), appState.getLocalVersion(), appState.getLocalData(), appState.hasConflict(), appState.getConflictVersion(), appState.getConflictData());
    }

    static boolean a(AppState appState, Object object) {
        boolean bl2 = true;
        if (!(object instanceof AppState)) {
            return false;
        }
        boolean bl3 = bl2;
        if (appState == object) return bl3;
        if (!ds.equal((object = (AppState)object).getKey(), appState.getKey())) return false;
        if (!ds.equal(object.getLocalVersion(), appState.getLocalVersion())) return false;
        if (!ds.equal(object.getLocalData(), appState.getLocalData())) return false;
        if (!ds.equal(object.hasConflict(), appState.hasConflict())) return false;
        if (!ds.equal(object.getConflictVersion(), appState.getConflictVersion())) return false;
        bl3 = bl2;
        if (ds.equal(object.getConflictData(), appState.getConflictData())) return bl3;
        return false;
    }

    static String b(AppState appState) {
        return ds.e(appState).a("Key", appState.getKey()).a("LocalVersion", appState.getLocalVersion()).a("LocalData", appState.getLocalData()).a("HasConflict", appState.hasConflict()).a("ConflictVersion", appState.getConflictVersion()).a("ConflictData", appState.getConflictData()).toString();
    }

    public AppState aJ() {
        return this;
    }

    public boolean equals(Object object) {
        return a.a(this, object);
    }

    @Override
    public /* synthetic */ Object freeze() {
        return this.aJ();
    }

    @Override
    public byte[] getConflictData() {
        return this.jK;
    }

    @Override
    public String getConflictVersion() {
        return this.jJ;
    }

    @Override
    public int getKey() {
        return this.jF;
    }

    @Override
    public byte[] getLocalData() {
        return this.jH;
    }

    @Override
    public String getLocalVersion() {
        return this.jG;
    }

    @Override
    public boolean hasConflict() {
        return this.jI;
    }

    public int hashCode() {
        return a.a(this);
    }

    @Override
    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return a.b(this);
    }
}

