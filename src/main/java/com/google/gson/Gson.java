/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.InstanceCreator;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSyntaxException;
import com.google.gson.LongSerializationPolicy;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.Streams;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.internal.bind.JsonTreeWriter;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.SqlDateTypeAdapter;
import com.google.gson.internal.bind.TimeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class Gson {
    static final boolean DEFAULT_JSON_NON_EXECUTABLE = false;
    private static final String JSON_NON_EXECUTABLE_PREFIX = ")]}'\n";
    private final ThreadLocal<Map<TypeToken<?>, FutureTypeAdapter<?>>> calls = new ThreadLocal<Map<TypeToken<?>, FutureTypeAdapter<?>>>(){

        @Override
        protected Map<TypeToken<?>, FutureTypeAdapter<?>> initialValue() {
            return new HashMap();
        }
    };
    private final ConstructorConstructor constructorConstructor;
    final JsonDeserializationContext deserializationContext;
    private final List<TypeAdapterFactory> factories;
    private final boolean generateNonExecutableJson;
    private final boolean htmlSafe;
    private final boolean prettyPrinting;
    final JsonSerializationContext serializationContext;
    private final boolean serializeNulls;
    private final Map<TypeToken<?>, TypeAdapter<?>> typeTokenCache = Collections.synchronizedMap(new HashMap());

    public Gson() {
        this(Excluder.DEFAULT, FieldNamingPolicy.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, LongSerializationPolicy.DEFAULT, Collections.emptyList());
    }

    Gson(Excluder excluder, FieldNamingStrategy fieldNamingStrategy, Map<Type, InstanceCreator<?>> object, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, LongSerializationPolicy longSerializationPolicy, List<TypeAdapterFactory> list) {
        this.deserializationContext = new JsonDeserializationContext(){

            @Override
            public <T> T deserialize(JsonElement jsonElement, Type type) throws JsonParseException {
                return Gson.this.fromJson(jsonElement, type);
            }
        };
        this.serializationContext = new JsonSerializationContext(){

            @Override
            public JsonElement serialize(Object object) {
                return Gson.this.toJsonTree(object);
            }

            @Override
            public JsonElement serialize(Object object, Type type) {
                return Gson.this.toJsonTree(object, type);
            }
        };
        this.constructorConstructor = new ConstructorConstructor((Map<Type, InstanceCreator<?>>)object);
        this.serializeNulls = bl2;
        this.generateNonExecutableJson = bl4;
        this.htmlSafe = bl5;
        this.prettyPrinting = bl6;
        object = new ArrayList();
        object.add(TypeAdapters.JSON_ELEMENT_FACTORY);
        object.add(ObjectTypeAdapter.FACTORY);
        object.addAll(list);
        object.add(TypeAdapters.STRING_FACTORY);
        object.add(TypeAdapters.INTEGER_FACTORY);
        object.add(TypeAdapters.BOOLEAN_FACTORY);
        object.add(TypeAdapters.BYTE_FACTORY);
        object.add(TypeAdapters.SHORT_FACTORY);
        object.add(TypeAdapters.newFactory(Long.TYPE, Long.class, this.longAdapter(longSerializationPolicy)));
        object.add(TypeAdapters.newFactory(Double.TYPE, Double.class, this.doubleAdapter(bl7)));
        object.add(TypeAdapters.newFactory(Float.TYPE, Float.class, this.floatAdapter(bl7)));
        object.add(TypeAdapters.NUMBER_FACTORY);
        object.add(TypeAdapters.CHARACTER_FACTORY);
        object.add(TypeAdapters.STRING_BUILDER_FACTORY);
        object.add(TypeAdapters.STRING_BUFFER_FACTORY);
        object.add(TypeAdapters.newFactory(BigDecimal.class, TypeAdapters.BIG_DECIMAL));
        object.add(TypeAdapters.newFactory(BigInteger.class, TypeAdapters.BIG_INTEGER));
        object.add(TypeAdapters.URL_FACTORY);
        object.add(TypeAdapters.URI_FACTORY);
        object.add(TypeAdapters.UUID_FACTORY);
        object.add(TypeAdapters.LOCALE_FACTORY);
        object.add(TypeAdapters.INET_ADDRESS_FACTORY);
        object.add(TypeAdapters.BIT_SET_FACTORY);
        object.add(DateTypeAdapter.FACTORY);
        object.add(TypeAdapters.CALENDAR_FACTORY);
        object.add(TimeTypeAdapter.FACTORY);
        object.add(SqlDateTypeAdapter.FACTORY);
        object.add(TypeAdapters.TIMESTAMP_FACTORY);
        object.add(ArrayTypeAdapter.FACTORY);
        object.add(TypeAdapters.ENUM_FACTORY);
        object.add(TypeAdapters.CLASS_FACTORY);
        object.add(excluder);
        object.add(new CollectionTypeAdapterFactory(this.constructorConstructor));
        object.add(new MapTypeAdapterFactory(this.constructorConstructor, bl3));
        object.add(new ReflectiveTypeAdapterFactory(this.constructorConstructor, fieldNamingStrategy, excluder));
        this.factories = Collections.unmodifiableList(object);
    }

    private static void assertFullConsumption(Object object, JsonReader jsonReader) {
        if (object == null) return;
        try {
            if (jsonReader.peek() == JsonToken.END_DOCUMENT) return;
            throw new JsonIOException("JSON document was not fully consumed.");
        }
        catch (MalformedJsonException malformedJsonException) {
            throw new JsonSyntaxException(malformedJsonException);
        }
        catch (IOException iOException) {
            throw new JsonIOException(iOException);
        }
    }

    private void checkValidFloatingPoint(double d2) {
        if (Double.isNaN(d2)) throw new IllegalArgumentException(d2 + " is not a valid double value as per JSON specification. To override this" + " behavior, use GsonBuilder.serializeSpecialDoubleValues() method.");
        if (!Double.isInfinite(d2)) return;
        throw new IllegalArgumentException(d2 + " is not a valid double value as per JSON specification. To override this" + " behavior, use GsonBuilder.serializeSpecialDoubleValues() method.");
    }

    private TypeAdapter<Number> doubleAdapter(boolean bl2) {
        if (!bl2) return new TypeAdapter<Number>(){

            @Override
            public Double read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() != JsonToken.NULL) return jsonReader.nextDouble();
                jsonReader.nextNull();
                return null;
            }

            @Override
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                if (number == null) {
                    jsonWriter.nullValue();
                    return;
                }
                double d2 = number.doubleValue();
                Gson.this.checkValidFloatingPoint(d2);
                jsonWriter.value(number);
            }
        };
        return TypeAdapters.DOUBLE;
    }

    private TypeAdapter<Number> floatAdapter(boolean bl2) {
        if (!bl2) return new TypeAdapter<Number>(){

            @Override
            public Float read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() != JsonToken.NULL) return Float.valueOf((float)jsonReader.nextDouble());
                jsonReader.nextNull();
                return null;
            }

            @Override
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                if (number == null) {
                    jsonWriter.nullValue();
                    return;
                }
                float f2 = number.floatValue();
                Gson.this.checkValidFloatingPoint(f2);
                jsonWriter.value(number);
            }
        };
        return TypeAdapters.FLOAT;
    }

    private TypeAdapter<Number> longAdapter(LongSerializationPolicy longSerializationPolicy) {
        if (longSerializationPolicy != LongSerializationPolicy.DEFAULT) return new TypeAdapter<Number>(){

            @Override
            public Number read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() != JsonToken.NULL) return jsonReader.nextLong();
                jsonReader.nextNull();
                return null;
            }

            @Override
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                if (number == null) {
                    jsonWriter.nullValue();
                    return;
                }
                jsonWriter.value(number.toString());
            }
        };
        return TypeAdapters.LONG;
    }

    private JsonWriter newJsonWriter(Writer closeable) throws IOException {
        if (this.generateNonExecutableJson) {
            ((Writer)closeable).write(JSON_NON_EXECUTABLE_PREFIX);
        }
        closeable = new JsonWriter((Writer)closeable);
        if (this.prettyPrinting) {
            ((JsonWriter)closeable).setIndent("  ");
        }
        ((JsonWriter)closeable).setSerializeNulls(this.serializeNulls);
        return closeable;
    }

    public <T> T fromJson(JsonElement jsonElement, Class<T> clazz) throws JsonSyntaxException {
        jsonElement = this.fromJson(jsonElement, (Type)clazz);
        return Primitives.wrap(clazz).cast(jsonElement);
    }

    public <T> T fromJson(JsonElement jsonElement, Type type) throws JsonSyntaxException {
        if (jsonElement != null) return this.fromJson(new JsonTreeReader(jsonElement), type);
        return null;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public <T> T fromJson(JsonReader jsonReader, Type type) throws JsonIOException, JsonSyntaxException {
        boolean bl2 = true;
        boolean bl3 = jsonReader.isLenient();
        jsonReader.setLenient(true);
        try {
            jsonReader.peek();
            bl2 = false;
            type = this.getAdapter(TypeToken.get(type)).read(jsonReader);
            return (T)type;
        }
        catch (EOFException eOFException) {
            if (!bl2) throw new JsonSyntaxException(eOFException);
            return null;
        }
        catch (IllegalStateException illegalStateException) {
            throw new JsonSyntaxException(illegalStateException);
        }
        catch (IOException iOException) {
            throw new JsonSyntaxException(iOException);
        }
        finally {
            jsonReader.setLenient(bl3);
        }
    }

    public <T> T fromJson(Reader closeable, Class<T> clazz) throws JsonSyntaxException, JsonIOException {
        closeable = new JsonReader((Reader)closeable);
        T t2 = this.fromJson((JsonReader)closeable, clazz);
        Gson.assertFullConsumption(t2, (JsonReader)closeable);
        return Primitives.wrap(clazz).cast(t2);
    }

    public <T> T fromJson(Reader closeable, Type type) throws JsonIOException, JsonSyntaxException {
        closeable = new JsonReader((Reader)closeable);
        type = this.fromJson((JsonReader)closeable, type);
        Gson.assertFullConsumption(type, (JsonReader)closeable);
        return (T)type;
    }

    public <T> T fromJson(String string2, Class<T> clazz) throws JsonSyntaxException {
        string2 = this.fromJson(string2, (Type)clazz);
        return Primitives.wrap(clazz).cast(string2);
    }

    public <T> T fromJson(String string2, Type type) throws JsonSyntaxException {
        if (string2 != null) return this.fromJson((Reader)new StringReader(string2), type);
        return null;
    }

    public <T> TypeAdapter<T> getAdapter(TypeToken<T> typeToken) {
        Object object = this.typeTokenCache.get(typeToken);
        if (object != null) {
            return object;
        }
        object = this.calls.get();
        FutureTypeAdapter<T> futureTypeAdapter = (FutureTypeAdapter<T>)object.get(typeToken);
        if (futureTypeAdapter != null) {
            return futureTypeAdapter;
        }
        futureTypeAdapter = new FutureTypeAdapter<T>();
        object.put(typeToken, futureTypeAdapter);
        try {
            TypeAdapter<T> typeAdapter;
            Iterator<TypeAdapterFactory> iterator = this.factories.iterator();
            do {
                if (!iterator.hasNext()) throw new IllegalArgumentException("GSON cannot handle " + typeToken);
            } while ((typeAdapter = iterator.next().create(this, typeToken)) == null);
            futureTypeAdapter.setDelegate(typeAdapter);
            this.typeTokenCache.put(typeToken, typeAdapter);
            return typeAdapter;
        }
        finally {
            object.remove(typeToken);
        }
    }

    public <T> TypeAdapter<T> getAdapter(Class<T> clazz) {
        return this.getAdapter(TypeToken.get(clazz));
    }

    public <T> TypeAdapter<T> getDelegateAdapter(TypeAdapterFactory typeAdapterFactory, TypeToken<T> typeToken) {
        boolean bl2 = false;
        Iterator<TypeAdapterFactory> iterator = this.factories.iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            if (!bl2) {
                if (object != typeAdapterFactory) continue;
                bl2 = true;
                continue;
            }
            if ((object = object.create(this, typeToken)) != null) return object;
        }
        throw new IllegalArgumentException("GSON cannot serialize " + typeToken);
    }

    public String toJson(JsonElement jsonElement) {
        StringWriter stringWriter = new StringWriter();
        this.toJson(jsonElement, (Appendable)stringWriter);
        return stringWriter.toString();
    }

    public String toJson(Object object) {
        if (object != null) return this.toJson(object, object.getClass());
        return this.toJson(JsonNull.INSTANCE);
    }

    public String toJson(Object object, Type type) {
        StringWriter stringWriter = new StringWriter();
        this.toJson(object, type, stringWriter);
        return stringWriter.toString();
    }

    public void toJson(JsonElement jsonElement, JsonWriter jsonWriter) throws JsonIOException {
        boolean bl2 = jsonWriter.isLenient();
        jsonWriter.setLenient(true);
        boolean bl3 = jsonWriter.isHtmlSafe();
        jsonWriter.setHtmlSafe(this.htmlSafe);
        boolean bl4 = jsonWriter.getSerializeNulls();
        jsonWriter.setSerializeNulls(this.serializeNulls);
        try {
            Streams.write(jsonElement, jsonWriter);
            return;
        }
        catch (IOException iOException) {
            throw new JsonIOException(iOException);
        }
        finally {
            jsonWriter.setLenient(bl2);
            jsonWriter.setHtmlSafe(bl3);
            jsonWriter.setSerializeNulls(bl4);
        }
    }

    public void toJson(JsonElement jsonElement, Appendable appendable) throws JsonIOException {
        try {
            this.toJson(jsonElement, this.newJsonWriter(Streams.writerForAppendable(appendable)));
            return;
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
    }

    public void toJson(Object object, Appendable appendable) throws JsonIOException {
        if (object != null) {
            this.toJson(object, object.getClass(), appendable);
            return;
        }
        this.toJson((JsonElement)JsonNull.INSTANCE, appendable);
    }

    public void toJson(Object object, Type object2, JsonWriter jsonWriter) throws JsonIOException {
        object2 = this.getAdapter(TypeToken.get((Type)object2));
        boolean bl2 = jsonWriter.isLenient();
        jsonWriter.setLenient(true);
        boolean bl3 = jsonWriter.isHtmlSafe();
        jsonWriter.setHtmlSafe(this.htmlSafe);
        boolean bl4 = jsonWriter.getSerializeNulls();
        jsonWriter.setSerializeNulls(this.serializeNulls);
        try {
            ((TypeAdapter)object2).write(jsonWriter, object);
            return;
        }
        catch (IOException iOException) {
            throw new JsonIOException(iOException);
        }
        finally {
            jsonWriter.setLenient(bl2);
            jsonWriter.setHtmlSafe(bl3);
            jsonWriter.setSerializeNulls(bl4);
        }
    }

    public void toJson(Object object, Type type, Appendable appendable) throws JsonIOException {
        try {
            this.toJson(object, type, this.newJsonWriter(Streams.writerForAppendable(appendable)));
            return;
        }
        catch (IOException iOException) {
            throw new JsonIOException(iOException);
        }
    }

    public JsonElement toJsonTree(Object object) {
        if (object != null) return this.toJsonTree(object, object.getClass());
        return JsonNull.INSTANCE;
    }

    public JsonElement toJsonTree(Object object, Type type) {
        JsonTreeWriter jsonTreeWriter = new JsonTreeWriter();
        this.toJson(object, type, jsonTreeWriter);
        return jsonTreeWriter.get();
    }

    public String toString() {
        return "{" + "serializeNulls:" + this.serializeNulls + "factories:" + this.factories + ",instanceCreators:" + this.constructorConstructor + "}";
    }

    static class FutureTypeAdapter<T>
    extends TypeAdapter<T> {
        private TypeAdapter<T> delegate;

        FutureTypeAdapter() {
        }

        @Override
        public T read(JsonReader jsonReader) throws IOException {
            if (this.delegate != null) return this.delegate.read(jsonReader);
            throw new IllegalStateException();
        }

        public void setDelegate(TypeAdapter<T> typeAdapter) {
            if (this.delegate != null) {
                throw new AssertionError();
            }
            this.delegate = typeAdapter;
        }

        @Override
        public void write(JsonWriter jsonWriter, T t2) throws IOException {
            if (this.delegate == null) {
                throw new IllegalStateException();
            }
            this.delegate.write(jsonWriter, t2);
        }
    }
}

