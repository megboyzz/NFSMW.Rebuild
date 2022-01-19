/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Excluder
implements TypeAdapterFactory,
Cloneable {
    public static final Excluder DEFAULT = new Excluder();
    private static final double IGNORE_VERSIONS = -1.0;
    private List<ExclusionStrategy> deserializationStrategies;
    private int modifiers = 136;
    private boolean requireExpose;
    private List<ExclusionStrategy> serializationStrategies = Collections.emptyList();
    private boolean serializeInnerClasses = true;
    private double version = -1.0;

    public Excluder() {
        this.deserializationStrategies = Collections.emptyList();
    }

    private boolean isAnonymousOrLocal(Class<?> clazz) {
        if (Enum.class.isAssignableFrom(clazz)) return false;
        if (clazz.isAnonymousClass()) return true;
        if (!clazz.isLocalClass()) return false;
        return true;
    }

    private boolean isInnerClass(Class<?> clazz) {
        if (!clazz.isMemberClass()) return false;
        if (this.isStatic(clazz)) return false;
        return true;
    }

    private boolean isStatic(Class<?> clazz) {
        if ((clazz.getModifiers() & 8) == 0) return false;
        return true;
    }

    private boolean isValidSince(Since since) {
        if (since == null) return true;
        if (!(since.value() > this.version)) return true;
        return false;
    }

    private boolean isValidUntil(Until until) {
        if (until == null) return true;
        if (!(until.value() <= this.version)) return true;
        return false;
    }

    private boolean isValidVersion(Since since, Until until) {
        if (!this.isValidSince(since)) return false;
        if (!this.isValidUntil(until)) return false;
        return true;
    }

    protected Excluder clone() {
        try {
            return (Excluder)super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new AssertionError();
        }
    }

    @Override
    public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> typeToken) {
        Class<T> clazz = typeToken.getRawType();
        final boolean bl2 = this.excludeClass(clazz, true);
        final boolean bl3 = this.excludeClass(clazz, false);
        if (bl2) return new TypeAdapter<T>(){
            private TypeAdapter<T> delegate;

            private TypeAdapter<T> delegate() {
                TypeAdapter typeAdapter = this.delegate;
                if (typeAdapter != null) {
                    return typeAdapter;
                }
                this.delegate = typeAdapter = gson.getDelegateAdapter(Excluder.this, typeToken);
                return typeAdapter;
            }

            @Override
            public T read(JsonReader jsonReader) throws IOException {
                if (!bl3) return this.delegate().read(jsonReader);
                jsonReader.skipValue();
                return null;
            }

            @Override
            public void write(JsonWriter jsonWriter, T t2) throws IOException {
                if (bl2) {
                    jsonWriter.nullValue();
                    return;
                }
                this.delegate().write(jsonWriter, t2);
            }
        };
        if (bl3) return new /* invalid duplicate definition of identical inner class */;
        return null;
    }

    public Excluder disableInnerClassSerialization() {
        Excluder excluder = this.clone();
        excluder.serializeInnerClasses = false;
        return excluder;
    }

    public boolean excludeClass(Class<?> clazz, boolean bl2) {
        if (this.version != -1.0 && !this.isValidVersion(clazz.getAnnotation(Since.class), clazz.getAnnotation(Until.class))) {
            return true;
        }
        if (!this.serializeInnerClasses && this.isInnerClass(clazz)) {
            return true;
        }
        if (this.isAnonymousOrLocal(clazz)) {
            return true;
        }
        List<ExclusionStrategy> list = bl2 ? this.serializationStrategies : this.deserializationStrategies;
        list = list.iterator();
        do {
            if (!list.hasNext()) return false;
        } while (!((ExclusionStrategy)list.next()).shouldSkipClass(clazz));
        return true;
    }

    public boolean excludeField(Field object, boolean bl2) {
        Object object2;
        if ((this.modifiers & ((Field)object).getModifiers()) != 0) {
            return true;
        }
        if (this.version != -1.0 && !this.isValidVersion(((Field)object).getAnnotation(Since.class), ((Field)object).getAnnotation(Until.class))) {
            return true;
        }
        if (((Field)object).isSynthetic()) {
            return true;
        }
        if (this.requireExpose) {
            object2 = ((Field)object).getAnnotation(Expose.class);
            if (object2 == null) return true;
            if (bl2) {
                if (!object2.serialize()) {
                    return true;
                }
            } else if (!object2.deserialize()) return true;
        }
        if (!this.serializeInnerClasses && this.isInnerClass(((Field)object).getType())) {
            return true;
        }
        if (this.isAnonymousOrLocal(((Field)object).getType())) {
            return true;
        }
        object2 = bl2 ? this.serializationStrategies : this.deserializationStrategies;
        if (object2.isEmpty()) return false;
        object = new FieldAttributes((Field)object);
        object2 = object2.iterator();
        do {
            if (!object2.hasNext()) return false;
        } while (!((ExclusionStrategy)object2.next()).shouldSkipField((FieldAttributes)object));
        return true;
    }

    public Excluder excludeFieldsWithoutExposeAnnotation() {
        Excluder excluder = this.clone();
        excluder.requireExpose = true;
        return excluder;
    }

    public Excluder withExclusionStrategy(ExclusionStrategy exclusionStrategy, boolean bl2, boolean bl3) {
        Excluder excluder = this.clone();
        if (bl2) {
            excluder.serializationStrategies = new ArrayList<ExclusionStrategy>(this.serializationStrategies);
            excluder.serializationStrategies.add(exclusionStrategy);
        }
        if (!bl3) return excluder;
        excluder.deserializationStrategies = new ArrayList<ExclusionStrategy>(this.deserializationStrategies);
        excluder.deserializationStrategies.add(exclusionStrategy);
        return excluder;
    }

    public Excluder withModifiers(int ... nArray) {
        Excluder excluder = this.clone();
        excluder.modifiers = 0;
        int n2 = nArray.length;
        int n3 = 0;
        while (n3 < n2) {
            int n4 = nArray[n3];
            excluder.modifiers |= n4;
            ++n3;
        }
        return excluder;
    }

    public Excluder withVersion(double d2) {
        Excluder excluder = this.clone();
        excluder.version = d2;
        return excluder;
    }
}

