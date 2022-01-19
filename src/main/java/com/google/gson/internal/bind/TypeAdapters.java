/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;

public final class TypeAdapters {
    public static final TypeAdapter<BigDecimal> BIG_DECIMAL;
    public static final TypeAdapter<BigInteger> BIG_INTEGER;
    public static final TypeAdapter<BitSet> BIT_SET;
    public static final TypeAdapterFactory BIT_SET_FACTORY;
    public static final TypeAdapter<Boolean> BOOLEAN;
    public static final TypeAdapter<Boolean> BOOLEAN_AS_STRING;
    public static final TypeAdapterFactory BOOLEAN_FACTORY;
    public static final TypeAdapter<Number> BYTE;
    public static final TypeAdapterFactory BYTE_FACTORY;
    public static final TypeAdapter<Calendar> CALENDAR;
    public static final TypeAdapterFactory CALENDAR_FACTORY;
    public static final TypeAdapter<Character> CHARACTER;
    public static final TypeAdapterFactory CHARACTER_FACTORY;
    public static final TypeAdapter<Class> CLASS;
    public static final TypeAdapterFactory CLASS_FACTORY;
    public static final TypeAdapter<Number> DOUBLE;
    public static final TypeAdapterFactory ENUM_FACTORY;
    public static final TypeAdapter<Number> FLOAT;
    public static final TypeAdapter<InetAddress> INET_ADDRESS;
    public static final TypeAdapterFactory INET_ADDRESS_FACTORY;
    public static final TypeAdapter<Number> INTEGER;
    public static final TypeAdapterFactory INTEGER_FACTORY;
    public static final TypeAdapter<JsonElement> JSON_ELEMENT;
    public static final TypeAdapterFactory JSON_ELEMENT_FACTORY;
    public static final TypeAdapter<Locale> LOCALE;
    public static final TypeAdapterFactory LOCALE_FACTORY;
    public static final TypeAdapter<Number> LONG;
    public static final TypeAdapter<Number> NUMBER;
    public static final TypeAdapterFactory NUMBER_FACTORY;
    public static final TypeAdapter<Number> SHORT;
    public static final TypeAdapterFactory SHORT_FACTORY;
    public static final TypeAdapter<String> STRING;
    public static final TypeAdapter<StringBuffer> STRING_BUFFER;
    public static final TypeAdapterFactory STRING_BUFFER_FACTORY;
    public static final TypeAdapter<StringBuilder> STRING_BUILDER;
    public static final TypeAdapterFactory STRING_BUILDER_FACTORY;
    public static final TypeAdapterFactory STRING_FACTORY;
    public static final TypeAdapterFactory TIMESTAMP_FACTORY;
    public static final TypeAdapter<URI> URI;
    public static final TypeAdapterFactory URI_FACTORY;
    public static final TypeAdapter<URL> URL;
    public static final TypeAdapterFactory URL_FACTORY;
    public static final TypeAdapter<UUID> UUID;
    public static final TypeAdapterFactory UUID_FACTORY;

    static {
        CLASS = new TypeAdapter<Class>(){

            @Override
            public Class read(JsonReader jsonReader) throws IOException {
                throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
            }

            @Override
            public void write(JsonWriter jsonWriter, Class clazz) throws IOException {
                throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + clazz.getName() + ". Forgot to register a type adapter?");
            }
        };
        CLASS_FACTORY = TypeAdapters.newFactory(Class.class, CLASS);
        BIT_SET = new TypeAdapter<BitSet>(){

            /*
             * Unable to fully structure code
             * Could not resolve type clashes
             */
            @Override
            public BitSet read(JsonReader var1_1) throws IOException {
                if (var1_1.peek() == JsonToken.NULL) {
                    var1_1.nextNull();
                    return null;
                }
                var6_3 = new BitSet();
                var1_1.beginArray();
                var2_4 = 0;
                var5_5 /* !! */  = var1_1.peek();
                block7: while (true) {
                    if (var5_5 /* !! */  == JsonToken.END_ARRAY) {
                        var1_1.endArray();
                        return var6_3;
                    }
                    switch (32.$SwitchMap$com$google$gson$stream$JsonToken[var5_5 /* !! */ .ordinal()]) {
                        case 1: {
                            var4_7 = var1_1.nextInt() != 0;
                            ** GOTO lbl27
                        }
                        case 2: {
                            var4_7 = var1_1.nextBoolean();
                            ** GOTO lbl27
                        }
                        case 3: {
                            var5_5 /* !! */  = var1_1.nextString();
                            try {
                                var3_6 = Integer.parseInt((String)var5_5 /* !! */ );
                                var4_7 = var3_6 != 0;
                            }
                            catch (NumberFormatException var1_2) {
                                throw new JsonSyntaxException("Error: Expecting: bitset number value (1, 0), Found: " + (String)var5_5 /* !! */ );
                            }
lbl27:
                            // 3 sources

                            if (var4_7) {
                                var6_3.set(var2_4);
                            }
                            ++var2_4;
                            var5_5 /* !! */  = var1_1.peek();
                            continue block7;
                        }
                    }
                    break;
                }
                throw new JsonSyntaxException("Invalid bitset value type: " + (Object)var5_5 /* !! */ );
            }

            @Override
            public void write(JsonWriter jsonWriter, BitSet bitSet) throws IOException {
                if (bitSet == null) {
                    jsonWriter.nullValue();
                    return;
                }
                jsonWriter.beginArray();
                int n2 = 0;
                while (true) {
                    if (n2 >= bitSet.length()) {
                        jsonWriter.endArray();
                        return;
                    }
                    int n3 = bitSet.get(n2) ? 1 : 0;
                    jsonWriter.value(n3);
                    ++n2;
                }
            }
        };
        BIT_SET_FACTORY = TypeAdapters.newFactory(BitSet.class, BIT_SET);
        BOOLEAN = new TypeAdapter<Boolean>(){

            @Override
            public Boolean read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                if (jsonReader.peek() != JsonToken.STRING) return jsonReader.nextBoolean();
                return Boolean.parseBoolean(jsonReader.nextString());
            }

            @Override
            public void write(JsonWriter jsonWriter, Boolean bl2) throws IOException {
                if (bl2 == null) {
                    jsonWriter.nullValue();
                    return;
                }
                jsonWriter.value(bl2);
            }
        };
        BOOLEAN_AS_STRING = new TypeAdapter<Boolean>(){

            @Override
            public Boolean read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() != JsonToken.NULL) return Boolean.valueOf(jsonReader.nextString());
                jsonReader.nextNull();
                return null;
            }

            @Override
            public void write(JsonWriter jsonWriter, Boolean object) throws IOException {
                object = object == null ? "null" : ((Boolean)object).toString();
                jsonWriter.value((String)object);
            }
        };
        BOOLEAN_FACTORY = TypeAdapters.newFactory(Boolean.TYPE, Boolean.class, BOOLEAN);
        BYTE = new TypeAdapter<Number>(){

            @Override
            public Number read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                try {
                    byte by2 = (byte)jsonReader.nextInt();
                    return by2;
                }
                catch (NumberFormatException numberFormatException) {
                    throw new JsonSyntaxException(numberFormatException);
                }
            }

            @Override
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                jsonWriter.value(number);
            }
        };
        BYTE_FACTORY = TypeAdapters.newFactory(Byte.TYPE, Byte.class, BYTE);
        SHORT = new TypeAdapter<Number>(){

            @Override
            public Number read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                try {
                    short s2 = (short)jsonReader.nextInt();
                    return s2;
                }
                catch (NumberFormatException numberFormatException) {
                    throw new JsonSyntaxException(numberFormatException);
                }
            }

            @Override
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                jsonWriter.value(number);
            }
        };
        SHORT_FACTORY = TypeAdapters.newFactory(Short.TYPE, Short.class, SHORT);
        INTEGER = new TypeAdapter<Number>(){

            @Override
            public Number read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                try {
                    int n2 = jsonReader.nextInt();
                    return n2;
                }
                catch (NumberFormatException numberFormatException) {
                    throw new JsonSyntaxException(numberFormatException);
                }
            }

            @Override
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                jsonWriter.value(number);
            }
        };
        INTEGER_FACTORY = TypeAdapters.newFactory(Integer.TYPE, Integer.class, INTEGER);
        LONG = new TypeAdapter<Number>(){

            @Override
            public Number read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                try {
                    long l2 = jsonReader.nextLong();
                    return l2;
                }
                catch (NumberFormatException numberFormatException) {
                    throw new JsonSyntaxException(numberFormatException);
                }
            }

            @Override
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                jsonWriter.value(number);
            }
        };
        FLOAT = new TypeAdapter<Number>(){

            @Override
            public Number read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() != JsonToken.NULL) return Float.valueOf((float)jsonReader.nextDouble());
                jsonReader.nextNull();
                return null;
            }

            @Override
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                jsonWriter.value(number);
            }
        };
        DOUBLE = new TypeAdapter<Number>(){

            @Override
            public Number read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() != JsonToken.NULL) return jsonReader.nextDouble();
                jsonReader.nextNull();
                return null;
            }

            @Override
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                jsonWriter.value(number);
            }
        };
        NUMBER = new TypeAdapter<Number>(){

            @Override
            public Number read(JsonReader jsonReader) throws IOException {
                JsonToken jsonToken = jsonReader.peek();
                switch (jsonToken) {
                    default: {
                        throw new JsonSyntaxException("Expecting number, got: " + (Object)((Object)jsonToken));
                    }
                    case NULL: {
                        jsonReader.nextNull();
                        return null;
                    }
                    case NUMBER: 
                }
                return new LazilyParsedNumber(jsonReader.nextString());
            }

            @Override
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                jsonWriter.value(number);
            }
        };
        NUMBER_FACTORY = TypeAdapters.newFactory(Number.class, NUMBER);
        CHARACTER = new TypeAdapter<Character>(){

            @Override
            public Character read(JsonReader object) throws IOException {
                if (((JsonReader)object).peek() == JsonToken.NULL) {
                    ((JsonReader)object).nextNull();
                    return null;
                }
                if (((String)(object = ((JsonReader)object).nextString())).length() == 1) return Character.valueOf(((String)object).charAt(0));
                throw new JsonSyntaxException("Expecting character, got: " + (String)object);
            }

            @Override
            public void write(JsonWriter jsonWriter, Character object) throws IOException {
                object = object == null ? null : String.valueOf(object);
                jsonWriter.value((String)object);
            }
        };
        CHARACTER_FACTORY = TypeAdapters.newFactory(Character.TYPE, Character.class, CHARACTER);
        STRING = new TypeAdapter<String>(){

            @Override
            public String read(JsonReader jsonReader) throws IOException {
                JsonToken jsonToken = jsonReader.peek();
                if (jsonToken == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                if (jsonToken != JsonToken.BOOLEAN) return jsonReader.nextString();
                return Boolean.toString(jsonReader.nextBoolean());
            }

            @Override
            public void write(JsonWriter jsonWriter, String string2) throws IOException {
                jsonWriter.value(string2);
            }
        };
        BIG_DECIMAL = new TypeAdapter<BigDecimal>(){

            @Override
            public BigDecimal read(JsonReader object) throws IOException {
                if (((JsonReader)object).peek() == JsonToken.NULL) {
                    ((JsonReader)object).nextNull();
                    return null;
                }
                try {
                    return new BigDecimal(((JsonReader)object).nextString());
                }
                catch (NumberFormatException numberFormatException) {
                    throw new JsonSyntaxException(numberFormatException);
                }
            }

            @Override
            public void write(JsonWriter jsonWriter, BigDecimal bigDecimal) throws IOException {
                jsonWriter.value(bigDecimal);
            }
        };
        BIG_INTEGER = new TypeAdapter<BigInteger>(){

            @Override
            public BigInteger read(JsonReader object) throws IOException {
                if (((JsonReader)object).peek() == JsonToken.NULL) {
                    ((JsonReader)object).nextNull();
                    return null;
                }
                try {
                    return new BigInteger(((JsonReader)object).nextString());
                }
                catch (NumberFormatException numberFormatException) {
                    throw new JsonSyntaxException(numberFormatException);
                }
            }

            @Override
            public void write(JsonWriter jsonWriter, BigInteger bigInteger) throws IOException {
                jsonWriter.value(bigInteger);
            }
        };
        STRING_FACTORY = TypeAdapters.newFactory(String.class, STRING);
        STRING_BUILDER = new TypeAdapter<StringBuilder>(){

            @Override
            public StringBuilder read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() != JsonToken.NULL) return new StringBuilder(jsonReader.nextString());
                jsonReader.nextNull();
                return null;
            }

            @Override
            public void write(JsonWriter jsonWriter, StringBuilder charSequence) throws IOException {
                charSequence = charSequence == null ? null : charSequence.toString();
                jsonWriter.value((String)charSequence);
            }
        };
        STRING_BUILDER_FACTORY = TypeAdapters.newFactory(StringBuilder.class, STRING_BUILDER);
        STRING_BUFFER = new TypeAdapter<StringBuffer>(){

            @Override
            public StringBuffer read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() != JsonToken.NULL) return new StringBuffer(jsonReader.nextString());
                jsonReader.nextNull();
                return null;
            }

            @Override
            public void write(JsonWriter jsonWriter, StringBuffer charSequence) throws IOException {
                charSequence = charSequence == null ? null : charSequence.toString();
                jsonWriter.value((String)charSequence);
            }
        };
        STRING_BUFFER_FACTORY = TypeAdapters.newFactory(StringBuffer.class, STRING_BUFFER);
        URL = new TypeAdapter<URL>(){

            @Override
            public URL read(JsonReader object) throws IOException {
                if (((JsonReader)object).peek() == JsonToken.NULL) {
                    ((JsonReader)object).nextNull();
                    return null;
                }
                if ("null".equals(object = ((JsonReader)object).nextString())) return null;
                return new URL((String)object);
            }

            @Override
            public void write(JsonWriter jsonWriter, URL object) throws IOException {
                object = object == null ? null : ((URL)object).toExternalForm();
                jsonWriter.value((String)object);
            }
        };
        URL_FACTORY = TypeAdapters.newFactory(URL.class, URL);
        URI = new TypeAdapter<URI>(){

            @Override
            public URI read(JsonReader object) throws IOException {
                if (((JsonReader)object).peek() == JsonToken.NULL) {
                    ((JsonReader)object).nextNull();
                    return null;
                }
                try {
                    if ("null".equals(object = ((JsonReader)object).nextString())) return null;
                    return new URI((String)object);
                }
                catch (URISyntaxException uRISyntaxException) {
                    throw new JsonIOException(uRISyntaxException);
                }
            }

            @Override
            public void write(JsonWriter jsonWriter, URI object) throws IOException {
                object = object == null ? null : ((URI)object).toASCIIString();
                jsonWriter.value((String)object);
            }
        };
        URI_FACTORY = TypeAdapters.newFactory(URI.class, URI);
        INET_ADDRESS = new TypeAdapter<InetAddress>(){

            @Override
            public InetAddress read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() != JsonToken.NULL) return InetAddress.getByName(jsonReader.nextString());
                jsonReader.nextNull();
                return null;
            }

            @Override
            public void write(JsonWriter jsonWriter, InetAddress object) throws IOException {
                object = object == null ? null : ((InetAddress)object).getHostAddress();
                jsonWriter.value((String)object);
            }
        };
        INET_ADDRESS_FACTORY = TypeAdapters.newTypeHierarchyFactory(InetAddress.class, INET_ADDRESS);
        UUID = new TypeAdapter<UUID>(){

            @Override
            public UUID read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() != JsonToken.NULL) return java.util.UUID.fromString(jsonReader.nextString());
                jsonReader.nextNull();
                return null;
            }

            @Override
            public void write(JsonWriter jsonWriter, UUID object) throws IOException {
                object = object == null ? null : ((UUID)object).toString();
                jsonWriter.value((String)object);
            }
        };
        UUID_FACTORY = TypeAdapters.newFactory(UUID.class, UUID);
        TIMESTAMP_FACTORY = new TypeAdapterFactory(){

            @Override
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                if (typeToken.getRawType() == Timestamp.class) return new TypeAdapter<Timestamp>(gson.getAdapter(Date.class)){
                    final /* synthetic */ TypeAdapter val$dateTypeAdapter;
                    {
                        this.val$dateTypeAdapter = typeAdapter;
                    }

                    @Override
                    public Timestamp read(JsonReader object) throws IOException {
                        if ((object = (Date)this.val$dateTypeAdapter.read((JsonReader)object)) == null) return null;
                        return new Timestamp(((Date)object).getTime());
                    }

                    @Override
                    public void write(JsonWriter jsonWriter, Timestamp timestamp) throws IOException {
                        this.val$dateTypeAdapter.write(jsonWriter, timestamp);
                    }
                };
                return null;
            }
        };
        CALENDAR = new TypeAdapter<Calendar>(){
            private static final String DAY_OF_MONTH = "dayOfMonth";
            private static final String HOUR_OF_DAY = "hourOfDay";
            private static final String MINUTE = "minute";
            private static final String MONTH = "month";
            private static final String SECOND = "second";
            private static final String YEAR = "year";

            @Override
            public Calendar read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                jsonReader.beginObject();
                int n2 = 0;
                int n3 = 0;
                int n4 = 0;
                int n5 = 0;
                int n6 = 0;
                int n7 = 0;
                while (true) {
                    if (jsonReader.peek() == JsonToken.END_OBJECT) {
                        jsonReader.endObject();
                        return new GregorianCalendar(n2, n3, n4, n5, n6, n7);
                    }
                    String string2 = jsonReader.nextName();
                    int n8 = jsonReader.nextInt();
                    if (YEAR.equals(string2)) {
                        n2 = n8;
                        continue;
                    }
                    if (MONTH.equals(string2)) {
                        n3 = n8;
                        continue;
                    }
                    if (DAY_OF_MONTH.equals(string2)) {
                        n4 = n8;
                        continue;
                    }
                    if (HOUR_OF_DAY.equals(string2)) {
                        n5 = n8;
                        continue;
                    }
                    if (MINUTE.equals(string2)) {
                        n6 = n8;
                        continue;
                    }
                    if (!SECOND.equals(string2)) continue;
                    n7 = n8;
                }
            }

            @Override
            public void write(JsonWriter jsonWriter, Calendar calendar) throws IOException {
                if (calendar == null) {
                    jsonWriter.nullValue();
                    return;
                }
                jsonWriter.beginObject();
                jsonWriter.name(YEAR);
                jsonWriter.value(calendar.get(1));
                jsonWriter.name(MONTH);
                jsonWriter.value(calendar.get(2));
                jsonWriter.name(DAY_OF_MONTH);
                jsonWriter.value(calendar.get(5));
                jsonWriter.name(HOUR_OF_DAY);
                jsonWriter.value(calendar.get(11));
                jsonWriter.name(MINUTE);
                jsonWriter.value(calendar.get(12));
                jsonWriter.name(SECOND);
                jsonWriter.value(calendar.get(13));
                jsonWriter.endObject();
            }
        };
        CALENDAR_FACTORY = TypeAdapters.newFactoryForMultipleTypes(Calendar.class, GregorianCalendar.class, CALENDAR);
        LOCALE = new TypeAdapter<Locale>(){

            @Override
            public Locale read(JsonReader object) throws IOException {
                if (((JsonReader)object).peek() == JsonToken.NULL) {
                    ((JsonReader)object).nextNull();
                    return null;
                }
                StringTokenizer stringTokenizer = new StringTokenizer(((JsonReader)object).nextString(), "_");
                object = null;
                String string2 = null;
                String string3 = null;
                if (stringTokenizer.hasMoreElements()) {
                    object = stringTokenizer.nextToken();
                }
                if (stringTokenizer.hasMoreElements()) {
                    string2 = stringTokenizer.nextToken();
                }
                if (stringTokenizer.hasMoreElements()) {
                    string3 = stringTokenizer.nextToken();
                }
                if (string2 == null && string3 == null) {
                    return new Locale((String)object);
                }
                if (string3 != null) return new Locale((String)object, string2, string3);
                return new Locale((String)object, string2);
            }

            @Override
            public void write(JsonWriter jsonWriter, Locale object) throws IOException {
                object = object == null ? null : ((Locale)object).toString();
                jsonWriter.value((String)object);
            }
        };
        LOCALE_FACTORY = TypeAdapters.newFactory(Locale.class, LOCALE);
        JSON_ELEMENT = new TypeAdapter<JsonElement>(){

            @Override
            public JsonElement read(JsonReader jsonReader) throws IOException {
                switch (jsonReader.peek()) {
                    default: {
                        throw new IllegalArgumentException();
                    }
                    case STRING: {
                        return new JsonPrimitive(jsonReader.nextString());
                    }
                    case NUMBER: {
                        return new JsonPrimitive(new LazilyParsedNumber(jsonReader.nextString()));
                    }
                    case BOOLEAN: {
                        return new JsonPrimitive(jsonReader.nextBoolean());
                    }
                    case NULL: {
                        jsonReader.nextNull();
                        return JsonNull.INSTANCE;
                    }
                    case BEGIN_ARRAY: {
                        JsonArray jsonArray = new JsonArray();
                        jsonReader.beginArray();
                        while (true) {
                            if (!jsonReader.hasNext()) {
                                jsonReader.endArray();
                                return jsonArray;
                            }
                            jsonArray.add(this.read(jsonReader));
                        }
                    }
                    case BEGIN_OBJECT: 
                }
                JsonObject jsonObject = new JsonObject();
                jsonReader.beginObject();
                while (true) {
                    if (!jsonReader.hasNext()) {
                        jsonReader.endObject();
                        return jsonObject;
                    }
                    jsonObject.add(jsonReader.nextName(), this.read(jsonReader));
                }
            }

            @Override
            public void write(JsonWriter jsonWriter, JsonElement iterator) throws IOException {
                if (iterator == null || ((JsonElement)((Object)iterator)).isJsonNull()) {
                    jsonWriter.nullValue();
                    return;
                }
                if (((JsonElement)((Object)iterator)).isJsonPrimitive()) {
                    if (((JsonPrimitive)((Object)(iterator = ((JsonElement)((Object)iterator)).getAsJsonPrimitive()))).isNumber()) {
                        jsonWriter.value(((JsonPrimitive)((Object)iterator)).getAsNumber());
                        return;
                    }
                    if (((JsonPrimitive)((Object)iterator)).isBoolean()) {
                        jsonWriter.value(((JsonPrimitive)((Object)iterator)).getAsBoolean());
                        return;
                    }
                    jsonWriter.value(((JsonPrimitive)((Object)iterator)).getAsString());
                    return;
                }
                if (((JsonElement)((Object)iterator)).isJsonArray()) {
                    jsonWriter.beginArray();
                    iterator = ((JsonElement)((Object)iterator)).getAsJsonArray().iterator();
                    while (true) {
                        if (!iterator.hasNext()) {
                            jsonWriter.endArray();
                            return;
                        }
                        this.write(jsonWriter, (JsonElement)((Object)iterator.next()));
                    }
                }
                if (!((JsonElement)((Object)iterator)).isJsonObject()) throw new IllegalArgumentException("Couldn't write " + iterator.getClass());
                jsonWriter.beginObject();
                iterator = ((JsonElement)((Object)iterator)).getAsJsonObject().entrySet().iterator();
                while (true) {
                    if (!iterator.hasNext()) {
                        jsonWriter.endObject();
                        return;
                    }
                    Map.Entry<String, JsonElement> entry = iterator.next();
                    jsonWriter.name(entry.getKey());
                    this.write(jsonWriter, entry.getValue());
                }
            }
        };
        JSON_ELEMENT_FACTORY = TypeAdapters.newFactory(JsonElement.class, JSON_ELEMENT);
        ENUM_FACTORY = TypeAdapters.newEnumTypeHierarchyFactory();
    }

    private TypeAdapters() {
    }

    public static TypeAdapterFactory newEnumTypeHierarchyFactory() {
        return new TypeAdapterFactory(){

            @Override
            public <T> TypeAdapter<T> create(Gson clazz, TypeToken<T> object) {
                if (!Enum.class.isAssignableFrom((Class<?>)(object = ((TypeToken)object).getRawType()))) return null;
                if (object == Enum.class) {
                    return null;
                }
                clazz = object;
                if (((Class)object).isEnum()) return new EnumTypeAdapter(clazz);
                clazz = ((Class)object).getSuperclass();
                return new EnumTypeAdapter(clazz);
            }
        };
    }

    public static <TT> TypeAdapterFactory newFactory(final TypeToken<TT> typeToken, final TypeAdapter<TT> typeAdapter) {
        return new TypeAdapterFactory(){

            @Override
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken2) {
                if (!typeToken2.equals(typeToken)) return null;
                return typeAdapter;
            }
        };
    }

    public static <TT> TypeAdapterFactory newFactory(final Class<TT> clazz, final TypeAdapter<TT> typeAdapter) {
        return new TypeAdapterFactory(){

            @Override
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                if (typeToken.getRawType() != clazz) return null;
                return typeAdapter;
            }

            public String toString() {
                return "Factory[type=" + clazz.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    public static <TT> TypeAdapterFactory newFactory(final Class<TT> clazz, final Class<TT> clazz2, final TypeAdapter<? super TT> typeAdapter) {
        return new TypeAdapterFactory(){

            @Override
            public <T> TypeAdapter<T> create(Gson clazz3, TypeToken<T> typeToken) {
                clazz3 = typeToken.getRawType();
                if (clazz3 == clazz) return typeAdapter;
                if (clazz3 != clazz2) return null;
                return typeAdapter;
            }

            public String toString() {
                return "Factory[type=" + clazz2.getName() + "+" + clazz.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    public static <TT> TypeAdapterFactory newFactoryForMultipleTypes(final Class<TT> clazz, final Class<? extends TT> clazz2, final TypeAdapter<? super TT> typeAdapter) {
        return new TypeAdapterFactory(){

            @Override
            public <T> TypeAdapter<T> create(Gson clazz3, TypeToken<T> typeToken) {
                clazz3 = typeToken.getRawType();
                if (clazz3 == clazz) return typeAdapter;
                if (clazz3 != clazz2) return null;
                return typeAdapter;
            }

            public String toString() {
                return "Factory[type=" + clazz.getName() + "+" + clazz2.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    public static <TT> TypeAdapterFactory newTypeHierarchyFactory(final Class<TT> clazz, final TypeAdapter<TT> typeAdapter) {
        return new TypeAdapterFactory(){

            @Override
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                if (!clazz.isAssignableFrom(typeToken.getRawType())) return null;
                return typeAdapter;
            }

            public String toString() {
                return "Factory[typeHierarchy=" + clazz.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    private static final class EnumTypeAdapter<T extends Enum<T>>
    extends TypeAdapter<T> {
        private final Map<T, String> constantToName;
        private final Map<String, T> nameToConstant = new HashMap<String, T>();

        /*
         * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
         */
        public EnumTypeAdapter(Class<T> clazz) {
            int n2;
            int n3;
            Enum[] enumArray;
            this.constantToName = new HashMap<T, String>();
            try {
                enumArray = (Enum[])clazz.getEnumConstants();
                n3 = enumArray.length;
                n2 = 0;
            }
            catch (NoSuchFieldException noSuchFieldException) {
                throw new AssertionError();
            }
            while (n2 < n3) {
                Enum enum_ = enumArray[n2];
                {
                    String string2 = enum_.name();
                    SerializedName serializedName = clazz.getField(string2).getAnnotation(SerializedName.class);
                    if (serializedName != null) {
                        string2 = serializedName.value();
                    }
                    this.nameToConstant.put(string2, enum_);
                    this.constantToName.put(enum_, string2);
                    ++n2;
                }
            }
        }

        @Override
        public T read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) return (T)((Enum)this.nameToConstant.get(jsonReader.nextString()));
            jsonReader.nextNull();
            return null;
        }

        @Override
        public void write(JsonWriter jsonWriter, T object) throws IOException {
            object = object == null ? null : this.constantToName.get(object);
            jsonWriter.value((String)object);
        }
    }
}

