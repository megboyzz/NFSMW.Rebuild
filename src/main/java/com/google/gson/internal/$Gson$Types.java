/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal;

import com.google.gson.internal.$Gson$Preconditions;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

public final class $Gson$Types {
    static final Type[] EMPTY_TYPE_ARRAY = new Type[0];

    private $Gson$Types() {
    }

    public static GenericArrayType arrayOf(Type type) {
        return new GenericArrayTypeImpl(type);
    }

    public static Type canonicalize(Type type) {
        if (type instanceof Class) {
            Class clazz = (Class)type;
            type = clazz;
            if (!clazz.isArray()) return type;
            return new GenericArrayTypeImpl($Gson$Types.canonicalize(clazz.getComponentType()));
        }
        if (type instanceof ParameterizedType) {
            type = (ParameterizedType)type;
            return new ParameterizedTypeImpl(type.getOwnerType(), type.getRawType(), type.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            return new GenericArrayTypeImpl(((GenericArrayType)type).getGenericComponentType());
        }
        if (!(type instanceof WildcardType)) return type;
        type = (WildcardType)type;
        return new WildcardTypeImpl(type.getUpperBounds(), type.getLowerBounds());
    }

    private static void checkNotPrimitive(Type type) {
        boolean bl2 = !(type instanceof Class) || !((Class)type).isPrimitive();
        $Gson$Preconditions.checkArgument(bl2);
    }

    private static Class<?> declaringClassOf(TypeVariable<?> typeVariable) {
        if (!((typeVariable = typeVariable.getGenericDeclaration()) instanceof Class)) return null;
        return (Class)((Object)typeVariable);
    }

    static boolean equal(Object object, Object object2) {
        if (object == object2) return true;
        if (object == null) return false;
        if (!object.equals(object2)) return false;
        return true;
    }

    public static boolean equals(Type type, Type type2) {
        boolean bl2;
        boolean bl3 = true;
        boolean bl4 = true;
        boolean bl5 = true;
        boolean bl6 = false;
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            bl2 = bl6;
            if (!(type2 instanceof ParameterizedType)) return bl2;
            type = (ParameterizedType)type;
            type2 = (ParameterizedType)type2;
            if (!$Gson$Types.equal(type.getOwnerType(), type2.getOwnerType())) return false;
            if (!type.getRawType().equals(type2.getRawType())) return false;
            if (!Arrays.equals(type.getActualTypeArguments(), type2.getActualTypeArguments())) return false;
            return bl5;
        }
        if (type instanceof GenericArrayType) {
            bl2 = bl6;
            if (!(type2 instanceof GenericArrayType)) return bl2;
            type = (GenericArrayType)type;
            type2 = (GenericArrayType)type2;
            return $Gson$Types.equals(type.getGenericComponentType(), type2.getGenericComponentType());
        }
        if (type instanceof WildcardType) {
            bl2 = bl6;
            if (!(type2 instanceof WildcardType)) return bl2;
            type = (WildcardType)type;
            type2 = (WildcardType)type2;
            if (!Arrays.equals(type.getUpperBounds(), type2.getUpperBounds())) return false;
            if (!Arrays.equals(type.getLowerBounds(), type2.getLowerBounds())) return false;
            return bl3;
        }
        bl2 = bl6;
        if (!(type instanceof TypeVariable)) return bl2;
        bl2 = bl6;
        if (!(type2 instanceof TypeVariable)) return bl2;
        type = (TypeVariable)type;
        type2 = (TypeVariable)type2;
        if (type.getGenericDeclaration() != type2.getGenericDeclaration()) return false;
        if (!type.getName().equals(type2.getName())) return false;
        return bl4;
    }

    public static Type getArrayComponentType(Type type) {
        if (!(type instanceof GenericArrayType)) return ((Class)type).getComponentType();
        return ((GenericArrayType)type).getGenericComponentType();
    }

    public static Type getCollectionElementType(Type type, Class<?> type2) {
        type = type2 = $Gson$Types.getSupertype(type, type2, Collection.class);
        if (type2 instanceof WildcardType) {
            type = ((WildcardType)type2).getUpperBounds()[0];
        }
        if (!(type instanceof ParameterizedType)) return Object.class;
        return ((ParameterizedType)type).getActualTypeArguments()[0];
    }

    static Type getGenericSupertype(Type object, Class<?> object2, Class<?> clazz) {
        if (clazz == object2) {
            return object;
        }
        if (clazz.isInterface()) {
            object = ((Class)object2).getInterfaces();
            int n2 = ((Class<?>[])object).length;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (object[i2] == clazz) {
                    return ((Class)object2).getGenericInterfaces()[i2];
                }
                if (!clazz.isAssignableFrom(object[i2])) continue;
                return $Gson$Types.getGenericSupertype(((Class)object2).getGenericInterfaces()[i2], object[i2], clazz);
            }
        }
        if (((Class)object2).isInterface()) return clazz;
        while (object2 != Object.class) {
            object = ((Class)object2).getSuperclass();
            if (object == clazz) {
                return ((Class)object2).getGenericSuperclass();
            }
            if (clazz.isAssignableFrom((Class<?>)object)) {
                return $Gson$Types.getGenericSupertype(((Class)object2).getGenericSuperclass(), object, clazz);
            }
            object2 = object;
        }
        return clazz;
    }

    public static Type[] getMapKeyAndValueTypes(Type type, Class<?> clazz) {
        if (type == Properties.class) {
            return new Type[]{String.class, String.class};
        }
        if (!((type = $Gson$Types.getSupertype(type, clazz, Map.class)) instanceof ParameterizedType)) return new Type[]{Object.class, Object.class};
        return ((ParameterizedType)type).getActualTypeArguments();
    }

    public static Class<?> getRawType(Type type) {
        String string2;
        if (type instanceof Class) {
            return (Class)type;
        }
        if (type instanceof ParameterizedType) {
            type = ((ParameterizedType)type).getRawType();
            $Gson$Preconditions.checkArgument(type instanceof Class);
            return (Class)type;
        }
        if (type instanceof GenericArrayType) {
            return Array.newInstance($Gson$Types.getRawType(((GenericArrayType)type).getGenericComponentType()), 0).getClass();
        }
        if (type instanceof TypeVariable) {
            return Object.class;
        }
        if (type instanceof WildcardType) {
            return $Gson$Types.getRawType(((WildcardType)type).getUpperBounds()[0]);
        }
        if (type == null) {
            string2 = "null";
            throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + string2);
        }
        string2 = type.getClass().getName();
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + string2);
    }

    static Type getSupertype(Type type, Class<?> clazz, Class<?> clazz2) {
        $Gson$Preconditions.checkArgument(clazz2.isAssignableFrom(clazz));
        return $Gson$Types.resolve(type, clazz, $Gson$Types.getGenericSupertype(type, clazz, clazz2));
    }

    private static int hashCodeOrZero(Object object) {
        if (object == null) return 0;
        return object.hashCode();
    }

    private static int indexOf(Object[] objectArray, Object object) {
        int n2 = 0;
        while (n2 < objectArray.length) {
            if (object.equals(objectArray[n2])) {
                return n2;
            }
            ++n2;
        }
        throw new NoSuchElementException();
    }

    public static ParameterizedType newParameterizedTypeWithOwner(Type type, Type type2, Type ... typeArray) {
        return new ParameterizedTypeImpl(type, type2, typeArray);
    }

    public static Type resolve(Type type, Class<?> clazz, Type typeArray) {
        Type type2;
        Type type3;
        while (typeArray instanceof TypeVariable) {
            type3 = (TypeVariable)typeArray;
            type2 = $Gson$Types.resolveTypeVariable(type, clazz, type3);
            typeArray = type2;
            if (type2 != type3) continue;
            return type2;
        }
        if (typeArray instanceof Class && ((Class)typeArray).isArray()) {
            type2 = (typeArray = (Class)typeArray).getComponentType();
            if (type2 != (type = $Gson$Types.resolve(type, clazz, type2))) return $Gson$Types.arrayOf(type);
            return typeArray;
        }
        if (typeArray instanceof GenericArrayType) {
            type2 = (typeArray = (GenericArrayType)typeArray).getGenericComponentType();
            if (type2 == (type = $Gson$Types.resolve(type, clazz, type2))) return typeArray;
            return $Gson$Types.arrayOf(type);
        }
        if (typeArray instanceof ParameterizedType) {
            type3 = (ParameterizedType)typeArray;
            Type type4 = $Gson$Types.resolve(type, clazz, typeArray = type3.getOwnerType());
            boolean bl2 = type4 != typeArray;
            type2 = type3.getActualTypeArguments();
            int n2 = 0;
            int n3 = ((Type)type2).length;
            while (true) {
                if (n2 >= n3) {
                    typeArray = type3;
                    if (!bl2) return typeArray;
                    return $Gson$Types.newParameterizedTypeWithOwner(type4, type3.getRawType(), (Type[])type2);
                }
                Type type5 = $Gson$Types.resolve(type, clazz, type2[n2]);
                typeArray = type2;
                boolean bl3 = bl2;
                if (type5 != type2[n2]) {
                    typeArray = type2;
                    bl3 = bl2;
                    if (!bl2) {
                        typeArray = (Type[])type2.clone();
                        bl3 = true;
                    }
                    typeArray[n2] = type5;
                }
                ++n2;
                type2 = typeArray;
                bl2 = bl3;
            }
        }
        if (!(typeArray instanceof WildcardType)) return typeArray;
        type2 = (WildcardType)typeArray;
        type3 = type2.getLowerBounds();
        Type[] typeArray2 = type2.getUpperBounds();
        if (((Type)type3).length == 1) {
            type = $Gson$Types.resolve(type, clazz, type3[0]);
            typeArray = type2;
            if (type == type3[0]) return typeArray;
            return $Gson$Types.supertypeOf(type);
        }
        typeArray = type2;
        if (typeArray2.length != 1) return typeArray;
        type = $Gson$Types.resolve(type, clazz, typeArray2[0]);
        typeArray = type2;
        if (type == typeArray2[0]) return typeArray;
        return $Gson$Types.subtypeOf(type);
    }

    static Type resolveTypeVariable(Type type, Class<?> clazz, TypeVariable<?> typeVariable) {
        Class<?> clazz2 = $Gson$Types.declaringClassOf(typeVariable);
        if (clazz2 == null) {
            return typeVariable;
        }
        if (!((type = $Gson$Types.getGenericSupertype(type, clazz, clazz2)) instanceof ParameterizedType)) return typeVariable;
        int n2 = $Gson$Types.indexOf(clazz2.getTypeParameters(), typeVariable);
        return ((ParameterizedType)type).getActualTypeArguments()[n2];
    }

    public static WildcardType subtypeOf(Type type) {
        Type[] typeArray = EMPTY_TYPE_ARRAY;
        return new WildcardTypeImpl(new Type[]{type}, typeArray);
    }

    public static WildcardType supertypeOf(Type type) {
        return new WildcardTypeImpl(new Type[]{Object.class}, new Type[]{type});
    }

    public static String typeToString(Type type) {
        if (!(type instanceof Class)) return type.toString();
        return ((Class)type).getName();
    }

    private static final class GenericArrayTypeImpl
    implements Serializable,
    GenericArrayType {
        private static final long serialVersionUID = 0L;
        private final Type componentType;

        public GenericArrayTypeImpl(Type type) {
            this.componentType = $Gson$Types.canonicalize(type);
        }

        public boolean equals(Object object) {
            if (!(object instanceof GenericArrayType)) return false;
            if (!$Gson$Types.equals(this, (GenericArrayType)object)) return false;
            return true;
        }

        @Override
        public Type getGenericComponentType() {
            return this.componentType;
        }

        public int hashCode() {
            return this.componentType.hashCode();
        }

        public String toString() {
            return $Gson$Types.typeToString(this.componentType) + "[]";
        }
    }

    private static final class ParameterizedTypeImpl
    implements Serializable,
    ParameterizedType {
        private static final long serialVersionUID = 0L;
        private final Type ownerType;
        private final Type rawType;
        private final Type[] typeArguments;

        public ParameterizedTypeImpl(Type type, Type type2, Type ... typeArray) {
            block3: {
                boolean bl2;
                block5: {
                    block4: {
                        boolean bl3 = false;
                        if (!(type2 instanceof Class)) break block3;
                        Class clazz = (Class)type2;
                        bl2 = type != null || clazz.getEnclosingClass() == null;
                        $Gson$Preconditions.checkArgument(bl2);
                        if (type == null) break block4;
                        bl2 = bl3;
                        if (clazz.getEnclosingClass() == null) break block5;
                    }
                    bl2 = true;
                }
                $Gson$Preconditions.checkArgument(bl2);
            }
            type = type == null ? null : $Gson$Types.canonicalize(type);
            this.ownerType = type;
            this.rawType = $Gson$Types.canonicalize(type2);
            this.typeArguments = (Type[])typeArray.clone();
            int n2 = 0;
            while (n2 < this.typeArguments.length) {
                $Gson$Preconditions.checkNotNull(this.typeArguments[n2]);
                $Gson$Types.checkNotPrimitive(this.typeArguments[n2]);
                this.typeArguments[n2] = $Gson$Types.canonicalize(this.typeArguments[n2]);
                ++n2;
            }
        }

        public boolean equals(Object object) {
            if (!(object instanceof ParameterizedType)) return false;
            if (!$Gson$Types.equals(this, (ParameterizedType)object)) return false;
            return true;
        }

        @Override
        public Type[] getActualTypeArguments() {
            return (Type[])this.typeArguments.clone();
        }

        @Override
        public Type getOwnerType() {
            return this.ownerType;
        }

        @Override
        public Type getRawType() {
            return this.rawType;
        }

        public int hashCode() {
            return Arrays.hashCode(this.typeArguments) ^ this.rawType.hashCode() ^ $Gson$Types.hashCodeOrZero(this.ownerType);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder((this.typeArguments.length + 1) * 30);
            stringBuilder.append($Gson$Types.typeToString(this.rawType));
            if (this.typeArguments.length == 0) {
                return stringBuilder.toString();
            }
            stringBuilder.append("<").append($Gson$Types.typeToString(this.typeArguments[0]));
            int n2 = 1;
            while (n2 < this.typeArguments.length) {
                stringBuilder.append(", ").append($Gson$Types.typeToString(this.typeArguments[n2]));
                ++n2;
            }
            return stringBuilder.append(">").toString();
        }
    }

    private static final class WildcardTypeImpl
    implements Serializable,
    WildcardType {
        private static final long serialVersionUID = 0L;
        private final Type lowerBound;
        private final Type upperBound;

        public WildcardTypeImpl(Type[] typeArray, Type[] typeArray2) {
            boolean bl2 = true;
            boolean bl3 = typeArray2.length <= 1;
            $Gson$Preconditions.checkArgument(bl3);
            bl3 = typeArray.length == 1;
            $Gson$Preconditions.checkArgument(bl3);
            if (typeArray2.length != 1) {
                $Gson$Preconditions.checkNotNull(typeArray[0]);
                $Gson$Types.checkNotPrimitive(typeArray[0]);
                this.lowerBound = null;
                this.upperBound = $Gson$Types.canonicalize(typeArray[0]);
                return;
            }
            $Gson$Preconditions.checkNotNull(typeArray2[0]);
            $Gson$Types.checkNotPrimitive(typeArray2[0]);
            bl3 = typeArray[0] == Object.class ? bl2 : false;
            $Gson$Preconditions.checkArgument(bl3);
            this.lowerBound = $Gson$Types.canonicalize(typeArray2[0]);
            this.upperBound = Object.class;
        }

        public boolean equals(Object object) {
            if (!(object instanceof WildcardType)) return false;
            if (!$Gson$Types.equals(this, (WildcardType)object)) return false;
            return true;
        }

        @Override
        public Type[] getLowerBounds() {
            if (this.lowerBound == null) return EMPTY_TYPE_ARRAY;
            return new Type[]{this.lowerBound};
        }

        @Override
        public Type[] getUpperBounds() {
            return new Type[]{this.upperBound};
        }

        public int hashCode() {
            int n2;
            if (this.lowerBound != null) {
                n2 = this.lowerBound.hashCode() + 31;
                return n2 ^ this.upperBound.hashCode() + 31;
            }
            n2 = 1;
            return n2 ^ this.upperBound.hashCode() + 31;
        }

        public String toString() {
            if (this.lowerBound != null) {
                return "? super " + $Gson$Types.typeToString(this.lowerBound);
            }
            if (this.upperBound != Object.class) return "? extends " + $Gson$Types.typeToString(this.upperBound);
            return "?";
        }
    }
}

