/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.games.achievement;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.achievement.Achievement;
import com.google.android.gms.games.achievement.a;

public final class AchievementBuffer
extends DataBuffer<Achievement> {
    public AchievementBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    @Override
    public Achievement get(int n2) {
        return new a(this.lb, n2);
    }
}

