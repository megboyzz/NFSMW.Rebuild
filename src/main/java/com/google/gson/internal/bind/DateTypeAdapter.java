/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class DateTypeAdapter
extends TypeAdapter<Date> {
    public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory(){

        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() != Date.class) return null;
            return new DateTypeAdapter();
        }
    };
    private final DateFormat enUsFormat = DateFormat.getDateTimeInstance(2, 2, Locale.US);
    private final DateFormat iso8601Format;
    private final DateFormat localFormat = DateFormat.getDateTimeInstance(2, 2);

    public DateTypeAdapter() {
        this.iso8601Format = DateTypeAdapter.buildIso8601Format();
    }

    private static DateFormat buildIso8601Format() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat;
    }

    private Date deserializeToDate(String object) {
        synchronized (this) {
            try {
                Date date = this.localFormat.parse((String)object);
                object = date;
                return object;
            }
            catch (ParseException parseException) {
                try {
                    Date date = this.enUsFormat.parse((String)object);
                    object = date;
                    return object;
                }
                catch (ParseException parseException2) {
                    try {
                        Date date = this.iso8601Format.parse((String)object);
                        object = date;
                        return object;
                    }
                    catch (ParseException parseException3) {
                        throw new JsonSyntaxException((String)object, parseException3);
                    }
                }
            }
            finally {
            }
        }
    }

    @Override
    public Date read(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() != JsonToken.NULL) return this.deserializeToDate(jsonReader.nextString());
        jsonReader.nextNull();
        return null;
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    @Override
    public void write(JsonWriter jsonWriter, Date date) throws IOException {
        synchronized (this) {
            void var2_2;
            if (var2_2 == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value(this.enUsFormat.format((Date)var2_2));
            }
            return;
        }
    }
}

