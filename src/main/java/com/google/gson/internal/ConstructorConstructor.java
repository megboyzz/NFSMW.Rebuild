/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal;

import com.google.gson.InstanceCreator;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.UnsafeAllocator;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public final class ConstructorConstructor {
    private final Map<Type, InstanceCreator<?>> instanceCreators;

    public ConstructorConstructor() {
        this(Collections.emptyMap());
    }

    public ConstructorConstructor(Map<Type, InstanceCreator<?>> map) {
        this.instanceCreators = map;
    }

    private <T> ObjectConstructor<T> newDefaultConstructor(Class<? super T> object) {
        try {
            object = ((Class)object).getDeclaredConstructor(new Class[0]);
            if (((AccessibleObject)object).isAccessible()) return new ObjectConstructor<T>((Constructor)object){
                final /* synthetic */ Constructor val$constructor;
                {
                    this.val$constructor = constructor;
                }

                @Override
                public T construct() {
                    try {
                        Object t2 = this.val$constructor.newInstance(null);
                        return t2;
                    }
                    catch (InstantiationException instantiationException) {
                        throw new RuntimeException("Failed to invoke " + this.val$constructor + " with no args", instantiationException);
                    }
                    catch (InvocationTargetException invocationTargetException) {
                        throw new RuntimeException("Failed to invoke " + this.val$constructor + " with no args", invocationTargetException.getTargetException());
                    }
                    catch (IllegalAccessException illegalAccessException) {
                        throw new AssertionError((Object)illegalAccessException);
                    }
                }
            };
            ((AccessibleObject)object).setAccessible(true);
            return new /* invalid duplicate definition of identical inner class */;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            return null;
        }
    }

    private <T> ObjectConstructor<T> newDefaultImplementationConstructor(Class<? super T> clazz) {
        if (!Collection.class.isAssignableFrom(clazz)) {
            if (!Map.class.isAssignableFrom(clazz)) return null;
            return new ObjectConstructor<T>(){

                @Override
                public T construct() {
                    return new LinkedHashMap();
                }
            };
        }
        if (SortedSet.class.isAssignableFrom(clazz)) {
            return new ObjectConstructor<T>(){

                @Override
                public T construct() {
                    return new TreeSet();
                }
            };
        }
        if (Set.class.isAssignableFrom(clazz)) {
            return new ObjectConstructor<T>(){

                @Override
                public T construct() {
                    return new LinkedHashSet();
                }
            };
        }
        if (!Queue.class.isAssignableFrom(clazz)) return new ObjectConstructor<T>(){

            @Override
            public T construct() {
                return new ArrayList();
            }
        };
        return new ObjectConstructor<T>(){

            @Override
            public T construct() {
                return new LinkedList();
            }
        };
    }

    private <T> ObjectConstructor<T> newUnsafeAllocator(final Type type, final Class<? super T> clazz) {
        return new ObjectConstructor<T>(){
            private final UnsafeAllocator unsafeAllocator = UnsafeAllocator.create();

            @Override
            public T construct() {
                try {
                    Object t2 = this.unsafeAllocator.newInstance(clazz);
                    return t2;
                }
                catch (Exception exception) {
                    throw new RuntimeException("Unable to invoke no-args constructor for " + type + ". " + "Register an InstanceCreator with Gson for this type may fix this problem.", exception);
                }
            }
        };
    }

    public <T> ObjectConstructor<T> get(TypeToken<T> objectConstructor) {
        ObjectConstructor objectConstructor2;
        Type type = ((TypeToken)((Object)objectConstructor)).getType();
        Class<T> clazz = ((TypeToken)((Object)objectConstructor)).getRawType();
        objectConstructor = this.instanceCreators.get(type);
        if (objectConstructor != null) {
            return new ObjectConstructor<T>((InstanceCreator)((Object)objectConstructor), type){
                final /* synthetic */ InstanceCreator val$creator;
                final /* synthetic */ Type val$type;
                {
                    this.val$creator = instanceCreator;
                    this.val$type = type;
                }

                @Override
                public T construct() {
                    return this.val$creator.createInstance(this.val$type);
                }
            };
        }
        objectConstructor = objectConstructor2 = this.newDefaultConstructor(clazz);
        if (objectConstructor2 != null) return objectConstructor;
        objectConstructor = this.newDefaultImplementationConstructor(clazz);
        if (objectConstructor == null) return this.newUnsafeAllocator(type, clazz);
        return objectConstructor;
    }

    public String toString() {
        return this.instanceCreators.toString();
    }
}

