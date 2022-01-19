/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson;

import com.google.gson.JsonArray;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class JsonElement {
    public BigDecimal getAsBigDecimal() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }

    public BigInteger getAsBigInteger() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }

    public boolean getAsBoolean() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }

    Boolean getAsBooleanWrapper() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }

    public byte getAsByte() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }

    public char getAsCharacter() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }

    public double getAsDouble() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }

    public float getAsFloat() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }

    public int getAsInt() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }

    public JsonArray getAsJsonArray() {
        if (!this.isJsonArray()) throw new IllegalStateException("This is not a JSON Array.");
        return (JsonArray)this;
    }

    public JsonNull getAsJsonNull() {
        if (!this.isJsonNull()) throw new IllegalStateException("This is not a JSON Null.");
        return (JsonNull)this;
    }

    public JsonObject getAsJsonObject() {
        if (!this.isJsonObject()) throw new IllegalStateException("Not a JSON Object: " + this);
        return (JsonObject)this;
    }

    public JsonPrimitive getAsJsonPrimitive() {
        if (!this.isJsonPrimitive()) throw new IllegalStateException("This is not a JSON Primitive.");
        return (JsonPrimitive)this;
    }

    public long getAsLong() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }

    public Number getAsNumber() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }

    public short getAsShort() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }

    public String getAsString() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }

    public boolean isJsonArray() {
        return this instanceof JsonArray;
    }

    public boolean isJsonNull() {
        return this instanceof JsonNull;
    }

    public boolean isJsonObject() {
        return this instanceof JsonObject;
    }

    public boolean isJsonPrimitive() {
        return this instanceof JsonPrimitive;
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            JsonWriter jsonWriter = new JsonWriter(stringWriter);
            jsonWriter.setLenient(true);
            Streams.write(this, jsonWriter);
            return stringWriter.toString();
        }
        catch (IOException iOException) {
            throw new AssertionError((Object)iOException);
        }
    }
}

