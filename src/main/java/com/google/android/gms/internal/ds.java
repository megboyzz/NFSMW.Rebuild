/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal;

import com.google.android.gms.internal.du;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ds {
    public static a e(Object object) {
        return new a(object);
    }

    public static boolean equal(Object object, Object object2) {
        if (object == object2) return true;
        if (object == null) return false;
        if (!object.equals(object2)) return false;
        return true;
    }

    public static int hashCode(Object ... objectArray) {
        return Arrays.hashCode(objectArray);
    }

    public static final class a {
        private final List<String> nh;
        private final Object ni;

        private a(Object object) {
            this.ni = du.f(object);
            this.nh = new ArrayList<String>();
        }

        public a a(String string2, Object object) {
            this.nh.add(du.f(string2) + "=" + String.valueOf(object));
            return this;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(100).append(this.ni.getClass().getSimpleName()).append('{');
            int n2 = this.nh.size();
            int n3 = 0;
            while (n3 < n2) {
                stringBuilder.append(this.nh.get(n3));
                if (n3 < n2 - 1) {
                    stringBuilder.append(", ");
                }
                ++n3;
            }
            return stringBuilder.append('}').toString();
        }
    }
}

