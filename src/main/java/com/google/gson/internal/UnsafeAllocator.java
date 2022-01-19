/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class UnsafeAllocator {
    public static UnsafeAllocator create() {
        try {
            Class<?> clazz = Class.forName("sun.misc.Unsafe");
            Object object = clazz.getDeclaredField("theUnsafe");
            ((AccessibleObject)object).setAccessible(true);
            object = ((Field)object).get(null);
            return new UnsafeAllocator(clazz.getMethod("allocateInstance", Class.class), object){
                final /* synthetic */ Method val$allocateInstance;
                final /* synthetic */ Object val$unsafe;
                {
                    this.val$allocateInstance = method;
                    this.val$unsafe = object;
                }

                @Override
                public <T> T newInstance(Class<T> clazz) throws Exception {
                    return (T)this.val$allocateInstance.invoke(this.val$unsafe, clazz);
                }
            };
        }
        catch (Exception exception) {
            try {
                final Method method = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                method.setAccessible(true);
                return new UnsafeAllocator(){

                    @Override
                    public <T> T newInstance(Class<T> clazz) throws Exception {
                        return (T)method.invoke(null, clazz, Object.class);
                    }
                };
            }
            catch (Exception exception2) {
                try {
                    Object object = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                    ((AccessibleObject)object).setAccessible(true);
                    int n2 = (Integer)((Method)object).invoke(null, Object.class);
                    object = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                    ((AccessibleObject)object).setAccessible(true);
                    return new UnsafeAllocator((Method)object, n2){
                        final /* synthetic */ int val$constructorId;
                        final /* synthetic */ Method val$newInstance;
                        {
                            this.val$newInstance = method;
                            this.val$constructorId = n2;
                        }

                        @Override
                        public <T> T newInstance(Class<T> clazz) throws Exception {
                            return (T)this.val$newInstance.invoke(null, clazz, this.val$constructorId);
                        }
                    };
                }
                catch (Exception exception3) {
                    return new UnsafeAllocator(){

                        @Override
                        public <T> T newInstance(Class<T> clazz) {
                            throw new UnsupportedOperationException("Cannot allocate " + clazz);
                        }
                    };
                }
            }
        }
    }

    public abstract <T> T newInstance(Class<T> var1) throws Exception;
}

