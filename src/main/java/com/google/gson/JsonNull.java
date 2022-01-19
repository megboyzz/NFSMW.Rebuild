/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson;

import com.google.gson.JsonElement;

public final class JsonNull
extends JsonElement {
    public static final JsonNull INSTANCE = new JsonNull();

    @Deprecated
    public JsonNull() {
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof JsonNull)) return false;
        return true;
    }

    public int hashCode() {
        return JsonNull.class.hashCode();
    }
}

