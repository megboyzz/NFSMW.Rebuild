/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal;

public final class $Gson$Preconditions {
    public static void checkArgument(boolean bl2) {
        if (bl2) return;
        throw new IllegalArgumentException();
    }

    public static <T> T checkNotNull(T t2) {
        if (t2 != null) return t2;
        throw new NullPointerException();
    }
}

