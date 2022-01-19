/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonPrimitive;
import com.google.gson.internal.$Gson$Preconditions;
import com.google.gson.internal.StringMap;
import java.util.Map;
import java.util.Set;

public final class JsonObject
extends JsonElement {
    private final StringMap<JsonElement> members = new StringMap();

    private JsonElement createJsonElement(Object object) {
        if (object != null) return new JsonPrimitive(object);
        return JsonNull.INSTANCE;
    }

    public void add(String string2, JsonElement jsonElement) {
        JsonElement jsonElement2 = jsonElement;
        if (jsonElement == null) {
            jsonElement2 = JsonNull.INSTANCE;
        }
        this.members.put($Gson$Preconditions.checkNotNull(string2), jsonElement2);
    }

    public void addProperty(String string2, Boolean bl2) {
        this.add(string2, this.createJsonElement(bl2));
    }

    public void addProperty(String string2, Character c2) {
        this.add(string2, this.createJsonElement(c2));
    }

    public void addProperty(String string2, Number number) {
        this.add(string2, this.createJsonElement(number));
    }

    public void addProperty(String string2, String string3) {
        this.add(string2, this.createJsonElement(string3));
    }

    public Set<Map.Entry<String, JsonElement>> entrySet() {
        return this.members.entrySet();
    }

    public boolean equals(Object object) {
        if (object == this) return true;
        if (!(object instanceof JsonObject)) return false;
        if (!((JsonObject)object).members.equals(this.members)) return false;
        return true;
    }

    public JsonElement get(String object) {
        if (!this.members.containsKey(object)) return null;
        JsonElement jsonElement = this.members.get(object);
        object = jsonElement;
        if (jsonElement != null) return object;
        return JsonNull.INSTANCE;
    }

    public JsonArray getAsJsonArray(String string2) {
        return (JsonArray)this.members.get(string2);
    }

    public JsonObject getAsJsonObject(String string2) {
        return (JsonObject)this.members.get(string2);
    }

    public JsonPrimitive getAsJsonPrimitive(String string2) {
        return (JsonPrimitive)this.members.get(string2);
    }

    public boolean has(String string2) {
        return this.members.containsKey(string2);
    }

    public int hashCode() {
        return this.members.hashCode();
    }

    public JsonElement remove(String string2) {
        return this.members.remove(string2);
    }
}

