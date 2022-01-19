/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.appstate;

public interface OnStateLoadedListener {
    public void onStateConflict(int var1, String var2, byte[] var3, byte[] var4);

    public void onStateLoaded(int var1, int var2, byte[] var3);
}

