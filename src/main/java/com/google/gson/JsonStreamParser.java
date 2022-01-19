/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class JsonStreamParser
implements Iterator<JsonElement> {
    private final Object lock;
    private final JsonReader parser;

    public JsonStreamParser(Reader reader) {
        this.parser = new JsonReader(reader);
        this.parser.setLenient(true);
        this.lock = new Object();
    }

    public JsonStreamParser(String string2) {
        this(new StringReader(string2));
    }

    /*
     * Enabled unnecessary exception pruning
     */
    @Override
    public boolean hasNext() {
        Object object = this.lock;
        synchronized (object) {
            try {
                JsonToken jsonToken = this.parser.peek();
                JsonToken jsonToken2 = JsonToken.END_DOCUMENT;
                if (jsonToken == jsonToken2) return false;
                return true;
            }
            catch (MalformedJsonException malformedJsonException) {
                throw new JsonSyntaxException(malformedJsonException);
            }
            catch (IOException iOException) {
                throw new JsonIOException(iOException);
            }
        }
    }

    @Override
    public JsonElement next() throws JsonParseException {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        try {
            return Streams.parse(this.parser);
        }
        catch (StackOverflowError stackOverflowError) {
            throw new JsonParseException("Failed parsing JSON source to Json", stackOverflowError);
        }
        catch (OutOfMemoryError outOfMemoryError) {
            throw new JsonParseException("Failed parsing JSON source to Json", outOfMemoryError);
        }
        catch (JsonParseException jsonParseException) {
            RuntimeException runtimeException = jsonParseException;
            if (!(jsonParseException.getCause() instanceof EOFException)) throw runtimeException;
            runtimeException = new NoSuchElementException();
            throw runtimeException;
        }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}

