/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.reflect;

import com.google.gson.internal.$Gson$Preconditions;
import com.google.gson.internal.$Gson$Types;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;

public class TypeToken<T> {
    final int hashCode;
    final Class<? super T> rawType;
    final Type type;

    protected TypeToken() {
        this.type = TypeToken.getSuperclassTypeParameter(this.getClass());
        this.rawType = $Gson$Types.getRawType(this.type);
        this.hashCode = this.type.hashCode();
    }

    TypeToken(Type type) {
        this.type = $Gson$Types.canonicalize($Gson$Preconditions.checkNotNull(type));
        this.rawType = $Gson$Types.getRawType(this.type);
        this.hashCode = this.type.hashCode();
    }

    private static AssertionError buildUnexpectedTypeError(Type type, Class<?> ... classArray) {
        StringBuilder stringBuilder = new StringBuilder("Unexpected type. Expected one of: ");
        int n2 = classArray.length;
        int n3 = 0;
        while (true) {
            if (n3 >= n2) {
                stringBuilder.append("but got: ").append(type.getClass().getName()).append(", for type token: ").append(type.toString()).append('.');
                return new AssertionError((Object)stringBuilder.toString());
            }
            stringBuilder.append(classArray[n3].getName()).append(", ");
            ++n3;
        }
    }

    public static <T> TypeToken<T> get(Class<T> clazz) {
        return new TypeToken<T>(clazz);
    }

    public static TypeToken<?> get(Type type) {
        return new TypeToken(type);
    }

    static Type getSuperclassTypeParameter(Class<?> type) {
        if (!((type = type.getGenericSuperclass()) instanceof Class)) return $Gson$Types.canonicalize(((ParameterizedType)type).getActualTypeArguments()[0]);
        throw new RuntimeException("Missing type parameter.");
    }

    private static boolean isAssignableFrom(Type clazz, GenericArrayType type) {
        Type type2 = type.getGenericComponentType();
        if (!(type2 instanceof ParameterizedType)) return true;
        type = clazz;
        if (clazz instanceof GenericArrayType) {
            type = ((GenericArrayType)((Object)clazz)).getGenericComponentType();
            return TypeToken.isAssignableFrom(type, (ParameterizedType)type2, new HashMap<String, Type>());
        }
        if (!(clazz instanceof Class)) return TypeToken.isAssignableFrom(type, (ParameterizedType)type2, new HashMap<String, Type>());
        clazz = clazz;
        while (true) {
            if (!clazz.isArray()) {
                type = clazz;
                return TypeToken.isAssignableFrom(type, (ParameterizedType)type2, new HashMap<String, Type>());
            }
            clazz = clazz.getComponentType();
        }
    }

    private static boolean isAssignableFrom(Type object, ParameterizedType parameterizedType, Map<String, Type> map) {
        int n2;
        if (object == null) {
            return false;
        }
        if (parameterizedType.equals(object)) {
            return true;
        }
        Class<?> clazz = $Gson$Types.getRawType((Type)object);
        ParameterizedType parameterizedType2 = null;
        if (object instanceof ParameterizedType) {
            parameterizedType2 = (ParameterizedType)object;
        }
        if (parameterizedType2 != null) {
            Type[] typeArray = parameterizedType2.getActualTypeArguments();
            TypeVariable<Class<?>>[] typeVariableArray = clazz.getTypeParameters();
            for (n2 = 0; n2 < typeArray.length; ++n2) {
                object = typeArray[n2];
                TypeVariable<Class<?>> typeVariable = typeVariableArray[n2];
                while (object instanceof TypeVariable) {
                    object = map.get(((TypeVariable)object).getName());
                }
                map.put(typeVariable.getName(), (Type)object);
            }
            if (TypeToken.typeEquals(parameterizedType2, parameterizedType, map)) {
                return true;
            }
        }
        object = clazz.getGenericInterfaces();
        int n3 = ((Type[])object).length;
        n2 = 0;
        while (n2 < n3) {
            if (TypeToken.isAssignableFrom(object[n2], parameterizedType, new HashMap<String, Type>(map))) {
                return true;
            }
            ++n2;
        }
        return TypeToken.isAssignableFrom(clazz.getGenericSuperclass(), parameterizedType, new HashMap<String, Type>(map));
    }

    private static boolean matches(Type type, Type type2, Map<String, Type> map) {
        if (type2.equals(type)) return true;
        if (!(type instanceof TypeVariable)) return false;
        if (!type2.equals(map.get(((TypeVariable)type).getName()))) return false;
        return true;
    }

    private static boolean typeEquals(ParameterizedType typeArray, ParameterizedType typeArray2, Map<String, Type> map) {
        if (!typeArray.getRawType().equals(typeArray2.getRawType())) return false;
        typeArray = typeArray.getActualTypeArguments();
        typeArray2 = typeArray2.getActualTypeArguments();
        int n2 = 0;
        while (n2 < typeArray.length) {
            if (!TypeToken.matches(typeArray[n2], typeArray2[n2], map)) {
                return false;
            }
            ++n2;
        }
        return true;
    }

    public final boolean equals(Object object) {
        if (!(object instanceof TypeToken)) return false;
        if (!$Gson$Types.equals(this.type, ((TypeToken)object).type)) return false;
        return true;
    }

    public final Class<? super T> getRawType() {
        return this.rawType;
    }

    public final Type getType() {
        return this.type;
    }

    public final int hashCode() {
        return this.hashCode;
    }

    @Deprecated
    public boolean isAssignableFrom(TypeToken<?> typeToken) {
        return this.isAssignableFrom(typeToken.getType());
    }

    @Deprecated
    public boolean isAssignableFrom(Class<?> clazz) {
        return this.isAssignableFrom((Type)clazz);
    }

    @Deprecated
    public boolean isAssignableFrom(Type type) {
        if (type == null) {
            return false;
        }
        if (this.type.equals(type)) {
            return true;
        }
        if (this.type instanceof Class) {
            return this.rawType.isAssignableFrom($Gson$Types.getRawType(type));
        }
        if (this.type instanceof ParameterizedType) {
            return TypeToken.isAssignableFrom(type, (ParameterizedType)this.type, new HashMap<String, Type>());
        }
        if (!(this.type instanceof GenericArrayType)) {
            throw TypeToken.buildUnexpectedTypeError(this.type, Class.class, ParameterizedType.class, GenericArrayType.class);
        }
        if (!this.rawType.isAssignableFrom($Gson$Types.getRawType(type))) return false;
        if (!TypeToken.isAssignableFrom(type, (GenericArrayType)this.type)) return false;
        return true;
    }

    public final String toString() {
        return $Gson$Types.typeToString(this.type);
    }
}

