/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson;

import com.google.gson.FieldNamingStrategy;
import java.lang.reflect.Field;

public enum FieldNamingPolicy implements FieldNamingStrategy
{
    IDENTITY{

        @Override
        public String translateName(Field field) {
            return field.getName();
        }
    }
    ,
    UPPER_CAMEL_CASE{

        @Override
        public String translateName(Field field) {
            return FieldNamingPolicy.upperCaseFirstLetter(field.getName());
        }
    }
    ,
    UPPER_CAMEL_CASE_WITH_SPACES{

        @Override
        public String translateName(Field field) {
            return FieldNamingPolicy.upperCaseFirstLetter(FieldNamingPolicy.separateCamelCase(field.getName(), " "));
        }
    }
    ,
    LOWER_CASE_WITH_UNDERSCORES{

        @Override
        public String translateName(Field field) {
            return FieldNamingPolicy.separateCamelCase(field.getName(), "_").toLowerCase();
        }
    }
    ,
    LOWER_CASE_WITH_DASHES{

        @Override
        public String translateName(Field field) {
            return FieldNamingPolicy.separateCamelCase(field.getName(), "-").toLowerCase();
        }
    };


    private static String modifyString(char c2, String string2, int n2) {
        if (n2 >= string2.length()) return String.valueOf(c2);
        return c2 + string2.substring(n2);
    }

    private static String separateCamelCase(String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = 0;
        while (n2 < string2.length()) {
            char c2 = string2.charAt(n2);
            if (Character.isUpperCase(c2) && stringBuilder.length() != 0) {
                stringBuilder.append(string3);
            }
            stringBuilder.append(c2);
            ++n2;
        }
        return stringBuilder.toString();
    }

    private static String upperCaseFirstLetter(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = 0;
        char c2 = string2.charAt(0);
        while (true) {
            if (n2 >= string2.length() - 1 || Character.isLetter(c2)) {
                if (n2 != string2.length()) break;
                return stringBuilder.toString();
            }
            stringBuilder.append(c2);
            c2 = string2.charAt(++n2);
        }
        String string3 = string2;
        if (Character.isUpperCase(c2)) return string3;
        return stringBuilder.append(FieldNamingPolicy.modifyString(Character.toUpperCase(c2), string2, n2 + 1)).toString();
    }
}

