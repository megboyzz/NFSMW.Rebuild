/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.$Gson$Preconditions;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

final class TreeTypeAdapter<T>
extends TypeAdapter<T> {
    private TypeAdapter<T> delegate;
    private final JsonDeserializer<T> deserializer;
    private final Gson gson;
    private final JsonSerializer<T> serializer;
    private final TypeAdapterFactory skipPast;
    private final TypeToken<T> typeToken;

    private TreeTypeAdapter(JsonSerializer<T> jsonSerializer, JsonDeserializer<T> jsonDeserializer, Gson gson, TypeToken<T> typeToken, TypeAdapterFactory typeAdapterFactory) {
        this.serializer = jsonSerializer;
        this.deserializer = jsonDeserializer;
        this.gson = gson;
        this.typeToken = typeToken;
        this.skipPast = typeAdapterFactory;
    }

    private TypeAdapter<T> delegate() {
        TypeAdapter<T> typeAdapter = this.delegate;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        this.delegate = typeAdapter = this.gson.getDelegateAdapter(this.skipPast, this.typeToken);
        return typeAdapter;
    }

    public static TypeAdapterFactory newFactory(TypeToken<?> typeToken, Object object) {
        return new SingleTypeFactory(object, typeToken, false, null);
    }

    public static TypeAdapterFactory newFactoryWithMatchRawType(TypeToken<?> typeToken, Object object) {
        boolean bl2;
        if (typeToken.getType() == typeToken.getRawType()) {
            bl2 = true;
            return new SingleTypeFactory(object, typeToken, bl2, null);
        }
        bl2 = false;
        return new SingleTypeFactory(object, typeToken, bl2, null);
    }

    public static TypeAdapterFactory newTypeHierarchyFactory(Class<?> clazz, Object object) {
        return new SingleTypeFactory(object, null, false, clazz);
    }

    @Override
    public T read(JsonReader object) throws IOException {
        if (this.deserializer == null) {
            return this.delegate().read((JsonReader)object);
        }
        if (!((JsonElement)(object = Streams.parse((JsonReader)object))).isJsonNull()) return this.deserializer.deserialize((JsonElement)object, this.typeToken.getType(), this.gson.deserializationContext);
        return null;
    }

    @Override
    public void write(JsonWriter jsonWriter, T t2) throws IOException {
        if (this.serializer == null) {
            this.delegate().write(jsonWriter, t2);
            return;
        }
        if (t2 == null) {
            jsonWriter.nullValue();
            return;
        }
        Streams.write(this.serializer.serialize(t2, this.typeToken.getType(), this.gson.serializationContext), jsonWriter);
    }

    private static class SingleTypeFactory
    implements TypeAdapterFactory {
        private final JsonDeserializer<?> deserializer;
        private final TypeToken<?> exactType;
        private final Class<?> hierarchyType;
        private final boolean matchRawType;
        private final JsonSerializer<?> serializer;

        private SingleTypeFactory(Object jsonDeserializer, TypeToken<?> typeToken, boolean bl2, Class<?> clazz) {
            JsonSerializer jsonSerializer = jsonDeserializer instanceof JsonSerializer ? (JsonSerializer)((Object)jsonDeserializer) : null;
            this.serializer = jsonSerializer;
            jsonDeserializer = jsonDeserializer instanceof JsonDeserializer ? (JsonDeserializer)jsonDeserializer : null;
            this.deserializer = jsonDeserializer;
            boolean bl3 = this.serializer != null || this.deserializer != null;
            $Gson$Preconditions.checkArgument(bl3);
            this.exactType = typeToken;
            this.matchRawType = bl2;
            this.hierarchyType = clazz;
        }

        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            boolean bl2 = this.exactType != null ? this.exactType.equals(typeToken) || this.matchRawType && this.exactType.getType() == typeToken.getRawType() : this.hierarchyType.isAssignableFrom(typeToken.getRawType());
            if (!bl2) return null;
            return new TreeTypeAdapter(this.serializer, this.deserializer, gson, typeToken, this);
        }
    }
}

