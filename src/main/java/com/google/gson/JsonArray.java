/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class JsonArray
extends JsonElement
implements Iterable<JsonElement> {
    private final List<JsonElement> elements = new ArrayList<JsonElement>();

    public void add(JsonElement jsonElement) {
        JsonElement jsonElement2 = jsonElement;
        if (jsonElement == null) {
            jsonElement2 = JsonNull.INSTANCE;
        }
        this.elements.add(jsonElement2);
    }

    public void addAll(JsonArray jsonArray) {
        this.elements.addAll(jsonArray.elements);
    }

    public boolean equals(Object object) {
        if (object == this) return true;
        if (!(object instanceof JsonArray)) return false;
        if (!((Object)((JsonArray)object).elements).equals(this.elements)) return false;
        return true;
    }

    public JsonElement get(int n2) {
        return this.elements.get(n2);
    }

    @Override
    public BigDecimal getAsBigDecimal() {
        if (this.elements.size() != 1) throw new IllegalStateException();
        return this.elements.get(0).getAsBigDecimal();
    }

    @Override
    public BigInteger getAsBigInteger() {
        if (this.elements.size() != 1) throw new IllegalStateException();
        return this.elements.get(0).getAsBigInteger();
    }

    @Override
    public boolean getAsBoolean() {
        if (this.elements.size() != 1) throw new IllegalStateException();
        return this.elements.get(0).getAsBoolean();
    }

    @Override
    public byte getAsByte() {
        if (this.elements.size() != 1) throw new IllegalStateException();
        return this.elements.get(0).getAsByte();
    }

    @Override
    public char getAsCharacter() {
        if (this.elements.size() != 1) throw new IllegalStateException();
        return this.elements.get(0).getAsCharacter();
    }

    @Override
    public double getAsDouble() {
        if (this.elements.size() != 1) throw new IllegalStateException();
        return this.elements.get(0).getAsDouble();
    }

    @Override
    public float getAsFloat() {
        if (this.elements.size() != 1) throw new IllegalStateException();
        return this.elements.get(0).getAsFloat();
    }

    @Override
    public int getAsInt() {
        if (this.elements.size() != 1) throw new IllegalStateException();
        return this.elements.get(0).getAsInt();
    }

    @Override
    public long getAsLong() {
        if (this.elements.size() != 1) throw new IllegalStateException();
        return this.elements.get(0).getAsLong();
    }

    @Override
    public Number getAsNumber() {
        if (this.elements.size() != 1) throw new IllegalStateException();
        return this.elements.get(0).getAsNumber();
    }

    @Override
    public short getAsShort() {
        if (this.elements.size() != 1) throw new IllegalStateException();
        return this.elements.get(0).getAsShort();
    }

    @Override
    public String getAsString() {
        if (this.elements.size() != 1) throw new IllegalStateException();
        return this.elements.get(0).getAsString();
    }

    public int hashCode() {
        return ((Object)this.elements).hashCode();
    }

    @Override
    public Iterator<JsonElement> iterator() {
        return this.elements.iterator();
    }

    public int size() {
        return this.elements.size();
    }
}

