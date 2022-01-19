/*
 * Decompiled with CFR 0.152.
 */
package com.google.ads.mediation;

import com.google.android.gms.internal.cs;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Deprecated
public abstract class MediationServerParameters {
    protected void a() {
    }

    public void load(Map<String, String> object) throws MappingException {
        HashMap<String, Field> hashMap = new HashMap<String, Field>();
        for (Field field : this.getClass().getFields()) {
            Parameter parameter = field.getAnnotation(Parameter.class);
            if (parameter == null) continue;
            hashMap.put(parameter.name(), field);
        }
        if (hashMap.isEmpty()) {
            cs.v("No server options fields detected. To suppress this message either add a field with the @Parameter annotation, or override the load() method.");
        }
        for (Map.Entry entry : object.entrySet()) {
            Field field;
            field = (Field)hashMap.remove(entry.getKey());
            if (field != null) {
                try {
                    field.set(this, entry.getValue());
                }
                catch (IllegalAccessException illegalAccessException) {
                    cs.v("Server option \"" + (String)entry.getKey() + "\" could not be set: Illegal Access");
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    cs.v("Server option \"" + (String)entry.getKey() + "\" could not be set: Bad Type");
                }
                continue;
            }
            cs.r("Unexpected server option: " + (String)entry.getKey() + " = \"" + (String)entry.getValue() + "\"");
        }
        object = new StringBuilder();
        for (Field field : hashMap.values()) {
            if (!field.getAnnotation(Parameter.class).required()) continue;
            cs.v("Required server option missing: " + field.getAnnotation(Parameter.class).name());
            if (((StringBuilder)object).length() > 0) {
                ((StringBuilder)object).append(", ");
            }
            ((StringBuilder)object).append(field.getAnnotation(Parameter.class).name());
        }
        if (((StringBuilder)object).length() > 0) {
            throw new MappingException("Required server option(s) missing: " + ((StringBuilder)object).toString());
        }
        this.a();
    }

    public static final class MappingException
    extends Exception {
        public MappingException(String string) {
            super(string);
        }
    }

    @Retention(value=RetentionPolicy.RUNTIME)
    @Target(value={ElementType.FIELD})
    protected static @interface Parameter {
        public String name();

        public boolean required() default true;
    }
}

