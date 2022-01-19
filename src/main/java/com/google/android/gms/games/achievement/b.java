/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.games.achievement;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.games.achievement.AchievementBuffer;

public interface b {

    public static interface a
    extends Releasable,
    Result {
        public AchievementBuffer cK();
    }

    public static interface b
    extends Result {
        public String getAchievementId();
    }
}

