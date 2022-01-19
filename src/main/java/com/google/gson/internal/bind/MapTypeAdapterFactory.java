/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Streams;
import com.google.gson.internal.bind.TypeAdapterRuntimeTypeWrapper;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

public final class MapTypeAdapterFactory
implements TypeAdapterFactory {
    private final boolean complexMapKeySerialization;
    private final ConstructorConstructor constructorConstructor;

    public MapTypeAdapterFactory(ConstructorConstructor constructorConstructor, boolean bl2) {
        this.constructorConstructor = constructorConstructor;
        this.complexMapKeySerialization = bl2;
    }

    private TypeAdapter<?> getKeyAdapter(Gson gson, Type type) {
        if (type == Boolean.TYPE) return TypeAdapters.BOOLEAN_AS_STRING;
        if (type != Boolean.class) return gson.getAdapter(TypeToken.get(type));
        return TypeAdapters.BOOLEAN_AS_STRING;
    }

    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> object) {
        Type[] typeArray = ((TypeToken)object).getType();
        if (!Map.class.isAssignableFrom(((TypeToken)object).getRawType())) {
            return null;
        }
        typeArray = $Gson$Types.getMapKeyAndValueTypes((Type)typeArray, $Gson$Types.getRawType((Type)typeArray));
        TypeAdapter<?> typeAdapter = this.getKeyAdapter(gson, typeArray[0]);
        TypeAdapter<?> typeAdapter2 = gson.getAdapter(TypeToken.get(typeArray[1]));
        object = this.constructorConstructor.get(object);
        return new Adapter(gson, typeArray[0], typeAdapter, typeArray[1], typeAdapter2, (ObjectConstructor<Map<?, ?>>)object);
    }

    private final class Adapter<K, V>
    extends TypeAdapter<Map<K, V>> {
        private final ObjectConstructor<? extends Map<K, V>> constructor;
        private final TypeAdapter<K> keyTypeAdapter;
        private final TypeAdapter<V> valueTypeAdapter;

        public Adapter(Gson gson, Type type, TypeAdapter<K> typeAdapter, Type type2, TypeAdapter<V> typeAdapter2, ObjectConstructor<? extends Map<K, V>> objectConstructor) {
            this.keyTypeAdapter = new TypeAdapterRuntimeTypeWrapper<K>(gson, typeAdapter, type);
            this.valueTypeAdapter = new TypeAdapterRuntimeTypeWrapper<V>(gson, typeAdapter2, type2);
            this.constructor = objectConstructor;
        }

        private String keyToString(JsonElement jsonElement) {
            if (!jsonElement.isJsonPrimitive()) {
                if (!jsonElement.isJsonNull()) throw new AssertionError();
                return "null";
            }
            if (((JsonPrimitive)(jsonElement = jsonElement.getAsJsonPrimitive())).isNumber()) {
                return String.valueOf(((JsonPrimitive)jsonElement).getAsNumber());
            }
            if (((JsonPrimitive)jsonElement).isBoolean()) {
                return Boolean.toString(((JsonPrimitive)jsonElement).getAsBoolean());
            }
            if (!((JsonPrimitive)jsonElement).isString()) throw new AssertionError();
            return ((JsonPrimitive)jsonElement).getAsString();
        }

        @Override
        public Map<K, V> read(JsonReader jsonReader) throws IOException {
            JsonToken jsonToken = jsonReader.peek();
            if (jsonToken == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            Map<JsonToken, V> map = this.constructor.construct();
            if (jsonToken != JsonToken.BEGIN_ARRAY) {
                jsonReader.beginObject();
                do {
                    if (!jsonReader.hasNext()) {
                        jsonReader.endObject();
                        return map;
                    }
                    JsonReaderInternalAccess.INSTANCE.promoteNameToValue(jsonReader);
                } while (map.put(jsonToken = this.keyTypeAdapter.read(jsonReader), this.valueTypeAdapter.read(jsonReader)) == null);
                throw new JsonSyntaxException("duplicate key: " + (Object)((Object)jsonToken));
            }
            jsonReader.beginArray();
            while (true) {
                if (!jsonReader.hasNext()) {
                    jsonReader.endArray();
                    return map;
                }
                jsonReader.beginArray();
                jsonToken = this.keyTypeAdapter.read(jsonReader);
                if (map.put(jsonToken, this.valueTypeAdapter.read(jsonReader)) != null) {
                    throw new JsonSyntaxException("duplicate key: " + (Object)((Object)jsonToken));
                }
                jsonReader.endArray();
            }
        }

        @Override
        public void write(JsonWriter jsonWriter, Map<K, V> iterator) throws IOException {
            if (iterator == null) {
                jsonWriter.nullValue();
                return;
            }
            if (!MapTypeAdapterFactory.this.complexMapKeySerialization) {
                jsonWriter.beginObject();
                iterator = iterator.entrySet().iterator();
                while (true) {
                    if (!iterator.hasNext()) {
                        jsonWriter.endObject();
                        return;
                    }
                    Map.Entry entry = (Map.Entry)iterator.next();
                    jsonWriter.name(String.valueOf(entry.getKey()));
                    this.valueTypeAdapter.write(jsonWriter, entry.getValue());
                }
            }
            int n2 = 0;
            ArrayList<JsonElement> arrayList = new ArrayList<JsonElement>(iterator.size());
            ArrayList arrayList2 = new ArrayList(iterator.size());
            for (Map.Entry entry : iterator.entrySet()) {
                JsonElement jsonElement = this.keyTypeAdapter.toJsonTree(entry.getKey());
                arrayList.add(jsonElement);
                arrayList2.add(entry.getValue());
                int n3 = jsonElement.isJsonArray() || jsonElement.isJsonObject() ? 1 : 0;
                n2 |= n3;
            }
            if (n2 != 0) {
                jsonWriter.beginArray();
                n2 = 0;
                while (true) {
                    if (n2 >= arrayList.size()) {
                        jsonWriter.endArray();
                        return;
                    }
                    jsonWriter.beginArray();
                    Streams.write((JsonElement)arrayList.get(n2), jsonWriter);
                    this.valueTypeAdapter.write(jsonWriter, arrayList2.get(n2));
                    jsonWriter.endArray();
                    ++n2;
                }
            }
            jsonWriter.beginObject();
            n2 = 0;
            while (true) {
                if (n2 >= arrayList.size()) {
                    jsonWriter.endObject();
                    return;
                }
                jsonWriter.name(this.keyToString((JsonElement)arrayList.get(n2)));
                this.valueTypeAdapter.write(jsonWriter, arrayList2.get(n2));
                ++n2;
            }
        }
    }
}

