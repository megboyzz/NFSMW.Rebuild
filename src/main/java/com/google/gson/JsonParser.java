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
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public final class JsonParser {
    /*
     * Enabled unnecessary exception pruning
     */
    public JsonElement parse(JsonReader jsonReader) throws JsonIOException, JsonSyntaxException {
        boolean bl2 = jsonReader.isLenient();
        jsonReader.setLenient(true);
        try {
            JsonElement jsonElement = Streams.parse(jsonReader);
            return jsonElement;
        }
        catch (StackOverflowError stackOverflowError) {
            throw new JsonParseException("Failed parsing JSON source: " + jsonReader + " to Json", stackOverflowError);
        }
        catch (OutOfMemoryError outOfMemoryError) {
            throw new JsonParseException("Failed parsing JSON source: " + jsonReader + " to Json", outOfMemoryError);
        }
        finally {
            jsonReader.setLenient(bl2);
        }
    }

    public JsonElement parse(Reader closeable) throws JsonIOException, JsonSyntaxException {
        try {
            closeable = new JsonReader((Reader)closeable);
            JsonElement jsonElement = this.parse((JsonReader)closeable);
            if (jsonElement.isJsonNull()) return jsonElement;
            if (((JsonReader)closeable).peek() == JsonToken.END_DOCUMENT) return jsonElement;
            throw new JsonSyntaxException("Did not consume the entire document.");
        }
        catch (MalformedJsonException malformedJsonException) {
            throw new JsonSyntaxException(malformedJsonException);
        }
        catch (IOException iOException) {
            throw new JsonIOException(iOException);
        }
        catch (NumberFormatException numberFormatException) {
            throw new JsonSyntaxException(numberFormatException);
        }
    }

    public JsonElement parse(String string2) throws JsonSyntaxException {
        return this.parse(new StringReader(string2));
    }
}

