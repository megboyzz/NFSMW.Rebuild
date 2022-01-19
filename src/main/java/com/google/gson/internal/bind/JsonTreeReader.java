/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class JsonTreeReader
extends JsonReader {
    private static final Object SENTINEL_CLOSED;
    private static final Reader UNREADABLE_READER;
    private final List<Object> stack = new ArrayList<Object>();

    static {
        UNREADABLE_READER = new Reader(){

            @Override
            public void close() throws IOException {
                throw new AssertionError();
            }

            @Override
            public int read(char[] cArray, int n2, int n3) throws IOException {
                throw new AssertionError();
            }
        };
        SENTINEL_CLOSED = new Object();
    }

    public JsonTreeReader(JsonElement jsonElement) {
        super(UNREADABLE_READER);
        this.stack.add(jsonElement);
    }

    private void expect(JsonToken jsonToken) throws IOException {
        if (this.peek() == jsonToken) return;
        throw new IllegalStateException("Expected " + (Object)((Object)jsonToken) + " but was " + (Object)((Object)this.peek()));
    }

    private Object peekStack() {
        return this.stack.get(this.stack.size() - 1);
    }

    private Object popStack() {
        return this.stack.remove(this.stack.size() - 1);
    }

    @Override
    public void beginArray() throws IOException {
        this.expect(JsonToken.BEGIN_ARRAY);
        JsonArray jsonArray = (JsonArray)this.peekStack();
        this.stack.add(jsonArray.iterator());
    }

    @Override
    public void beginObject() throws IOException {
        this.expect(JsonToken.BEGIN_OBJECT);
        JsonObject jsonObject = (JsonObject)this.peekStack();
        this.stack.add(jsonObject.entrySet().iterator());
    }

    @Override
    public void close() throws IOException {
        this.stack.clear();
        this.stack.add(SENTINEL_CLOSED);
    }

    @Override
    public void endArray() throws IOException {
        this.expect(JsonToken.END_ARRAY);
        this.popStack();
        this.popStack();
    }

    @Override
    public void endObject() throws IOException {
        this.expect(JsonToken.END_OBJECT);
        this.popStack();
        this.popStack();
    }

    @Override
    public boolean hasNext() throws IOException {
        JsonToken jsonToken = this.peek();
        if (jsonToken == JsonToken.END_OBJECT) return false;
        if (jsonToken == JsonToken.END_ARRAY) return false;
        return true;
    }

    @Override
    public boolean nextBoolean() throws IOException {
        this.expect(JsonToken.BOOLEAN);
        return ((JsonPrimitive)this.popStack()).getAsBoolean();
    }

    @Override
    public double nextDouble() throws IOException {
        JsonToken jsonToken = this.peek();
        if (jsonToken != JsonToken.NUMBER && jsonToken != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + (Object)((Object)JsonToken.NUMBER) + " but was " + (Object)((Object)jsonToken));
        }
        double d2 = ((JsonPrimitive)this.peekStack()).getAsDouble();
        if (!this.isLenient()) {
            if (Double.isNaN(d2)) throw new NumberFormatException("JSON forbids NaN and infinities: " + d2);
            if (Double.isInfinite(d2)) {
                throw new NumberFormatException("JSON forbids NaN and infinities: " + d2);
            }
        }
        this.popStack();
        return d2;
    }

    @Override
    public int nextInt() throws IOException {
        JsonToken jsonToken = this.peek();
        if (jsonToken != JsonToken.NUMBER && jsonToken != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + (Object)((Object)JsonToken.NUMBER) + " but was " + (Object)((Object)jsonToken));
        }
        int n2 = ((JsonPrimitive)this.peekStack()).getAsInt();
        this.popStack();
        return n2;
    }

    @Override
    public long nextLong() throws IOException {
        JsonToken jsonToken = this.peek();
        if (jsonToken != JsonToken.NUMBER && jsonToken != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + (Object)((Object)JsonToken.NUMBER) + " but was " + (Object)((Object)jsonToken));
        }
        long l2 = ((JsonPrimitive)this.peekStack()).getAsLong();
        this.popStack();
        return l2;
    }

    @Override
    public String nextName() throws IOException {
        this.expect(JsonToken.NAME);
        Map.Entry entry = (Map.Entry)((Iterator)this.peekStack()).next();
        this.stack.add(entry.getValue());
        return (String)entry.getKey();
    }

    @Override
    public void nextNull() throws IOException {
        this.expect(JsonToken.NULL);
        this.popStack();
    }

    @Override
    public String nextString() throws IOException {
        JsonToken jsonToken = this.peek();
        if (jsonToken == JsonToken.STRING) return ((JsonPrimitive)this.popStack()).getAsString();
        if (jsonToken == JsonToken.NUMBER) return ((JsonPrimitive)this.popStack()).getAsString();
        throw new IllegalStateException("Expected " + (Object)((Object)JsonToken.STRING) + " but was " + (Object)((Object)jsonToken));
    }

    @Override
    public JsonToken peek() throws IOException {
        if (this.stack.isEmpty()) {
            return JsonToken.END_DOCUMENT;
        }
        Object object = this.peekStack();
        if (object instanceof Iterator) {
            boolean bl2 = this.stack.get(this.stack.size() - 2) instanceof JsonObject;
            if (!(object = (Iterator)object).hasNext()) {
                if (!bl2) return JsonToken.END_ARRAY;
                return JsonToken.END_OBJECT;
            }
            if (bl2) {
                return JsonToken.NAME;
            }
            this.stack.add(object.next());
            return this.peek();
        }
        if (object instanceof JsonObject) {
            return JsonToken.BEGIN_OBJECT;
        }
        if (object instanceof JsonArray) {
            return JsonToken.BEGIN_ARRAY;
        }
        if (object instanceof JsonPrimitive) {
            if (((JsonPrimitive)(object = (JsonPrimitive)object)).isString()) {
                return JsonToken.STRING;
            }
            if (((JsonPrimitive)object).isBoolean()) {
                return JsonToken.BOOLEAN;
            }
            if (!((JsonPrimitive)object).isNumber()) throw new AssertionError();
            return JsonToken.NUMBER;
        }
        if (object instanceof JsonNull) {
            return JsonToken.NULL;
        }
        if (object != SENTINEL_CLOSED) throw new AssertionError();
        throw new IllegalStateException("JsonReader is closed");
    }

    public void promoteNameToValue() throws IOException {
        this.expect(JsonToken.NAME);
        Map.Entry entry = (Map.Entry)((Iterator)this.peekStack()).next();
        this.stack.add(entry.getValue());
        this.stack.add(new JsonPrimitive((String)entry.getKey()));
    }

    @Override
    public void skipValue() throws IOException {
        if (this.peek() == JsonToken.NAME) {
            this.nextName();
            return;
        }
        this.popStack();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}

