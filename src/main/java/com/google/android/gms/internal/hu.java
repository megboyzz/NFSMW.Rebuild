/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal;

import com.google.android.gms.internal.ht;
import java.lang.reflect.Array;
import java.lang.reflect.Field;

public final class hu {
    private static String O(String string2) {
        int n2 = string2.length();
        StringBuilder stringBuilder = new StringBuilder(n2);
        int n3 = 0;
        while (n3 < n2) {
            char c2 = string2.charAt(n3);
            if (c2 >= ' ' && c2 <= '~' && c2 != '\"' && c2 != '\'') {
                stringBuilder.append(c2);
            } else {
                stringBuilder.append(String.format("\\u%04x", c2));
            }
            ++n3;
        }
        return stringBuilder.toString();
    }

    private static void a(String string2, Class<?> fieldArray, Object object, StringBuffer stringBuffer, StringBuffer stringBuffer2) throws IllegalAccessException {
        int n2;
        if (object == null) {
            return;
        }
        if (ht.class.isAssignableFrom((Class<?>)fieldArray)) {
            n2 = stringBuffer.length();
            if (string2 != null) {
                stringBuffer2.append(stringBuffer).append(hu.ao(string2)).append(" <\n");
                stringBuffer.append("  ");
            }
        } else {
            string2 = hu.ao(string2);
            stringBuffer2.append(stringBuffer).append(string2).append(": ");
            if (object instanceof String) {
                string2 = hu.ap((String)object);
                stringBuffer2.append("\"").append(string2).append("\"");
            } else if (object instanceof byte[]) {
                hu.a((byte[])object, stringBuffer2);
            } else {
                stringBuffer2.append(object);
            }
            stringBuffer2.append("\n");
            return;
        }
        fieldArray = fieldArray.getFields();
        int n3 = fieldArray.length;
        int n4 = 0;
        while (true) {
            if (n4 >= n3) {
                if (string2 == null) return;
                stringBuffer.setLength(n2);
                stringBuffer2.append(stringBuffer).append(">\n");
                return;
            }
            Object object2 = fieldArray[n4];
            int n5 = ((Field)object2).getModifiers();
            String string3 = ((Field)object2).getName();
            if ((n5 & 1) == 1 && (n5 & 8) != 8 && !string3.startsWith("_") && !string3.endsWith("_")) {
                Class<?> clazz = ((Field)object2).getType();
                object2 = ((Field)object2).get(object);
                if (clazz.isArray()) {
                    Class<?> clazz2 = clazz.getComponentType();
                    if (clazz2 == Byte.TYPE) {
                        hu.a(string3, clazz, object2, stringBuffer, stringBuffer2);
                    } else {
                        n5 = object2 == null ? 0 : Array.getLength(object2);
                        for (int i2 = 0; i2 < n5; ++i2) {
                            hu.a(string3, clazz2, Array.get(object2, i2), stringBuffer, stringBuffer2);
                        }
                    }
                } else {
                    hu.a(string3, clazz, object2, stringBuffer, stringBuffer2);
                }
            }
            ++n4;
        }
    }

    private static void a(byte[] byArray, StringBuffer stringBuffer) {
        if (byArray == null) {
            stringBuffer.append("\"\"");
            return;
        }
        stringBuffer.append('\"');
        int n2 = 0;
        while (true) {
            if (n2 >= byArray.length) {
                stringBuffer.append('\"');
                return;
            }
            byte by2 = byArray[n2];
            if (by2 == 92 || by2 == 34) {
                stringBuffer.append('\\').append((char)by2);
            } else if (by2 >= 32 && by2 < 127) {
                stringBuffer.append((char)by2);
            } else {
                stringBuffer.append(String.format("\\%03o", by2));
            }
            ++n2;
        }
    }

    private static String ao(String string2) {
        StringBuffer stringBuffer = new StringBuffer();
        int n2 = 0;
        while (n2 < string2.length()) {
            char c2 = string2.charAt(n2);
            if (n2 == 0) {
                stringBuffer.append(Character.toLowerCase(c2));
            } else if (Character.isUpperCase(c2)) {
                stringBuffer.append('_').append(Character.toLowerCase(c2));
            } else {
                stringBuffer.append(c2);
            }
            ++n2;
        }
        return stringBuffer.toString();
    }

    private static String ap(String string2) {
        String string3 = string2;
        if (string2.startsWith("http")) return hu.O(string3);
        string3 = string2;
        if (string2.length() <= 200) return hu.O(string3);
        string3 = string2.substring(0, 200) + "[...]";
        return hu.O(string3);
    }

    public static <T extends ht> String b(T t2) {
        if (t2 == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            hu.a(null, t2.getClass(), t2, new StringBuffer(), stringBuffer);
            return stringBuffer.toString();
        }
        catch (IllegalAccessException illegalAccessException) {
            return "Error printing proto: " + illegalAccessException.getMessage();
        }
    }
}

