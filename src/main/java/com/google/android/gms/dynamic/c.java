/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.dynamic;

import com.google.android.gms.dynamic.b;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

public final class c<T>
extends b.a {
    private final T pS;

    private c(T t2) {
        this.pS = t2;
    }

    public static <T> T b(b object) {
        if (object instanceof c) {
            return ((c)object).pS;
        }
        Object object2 = (object = object.asBinder()).getClass().getDeclaredFields();
        if (((Field[])object2).length != 1) throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly *one* declared private field for the wrapped object.  Preferably, this is an instance of the ObjectWrapper<T> class.");
        if (((AccessibleObject)(object2 = object2[0])).isAccessible()) throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly one declared *private* field for the wrapped object. Preferably, this is an instance of the ObjectWrapper<T> class.");
        ((AccessibleObject)object2).setAccessible(true);
        try {
            object = ((Field)object2).get(object);
            return (T)object;
        }
        catch (NullPointerException nullPointerException) {
            throw new IllegalArgumentException("Binder object is null.", nullPointerException);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException("remoteBinder is the wrong class.", illegalArgumentException);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new IllegalArgumentException("Could not access the field in remoteBinder.", illegalAccessException);
        }
    }

    public static <T> b h(T t2) {
        return new c<T>(t2);
    }
}

