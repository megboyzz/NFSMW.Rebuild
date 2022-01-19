/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.stream;

final class StringPool {
    private final String[] pool = new String[512];

    StringPool() {
    }

    public String get(char[] object, int n2, int n3) {
        int n4;
        int n5 = 0;
        for (n4 = n2; n4 < n2 + n3; ++n4) {
            n5 = n5 * 31 + object[n4];
        }
        n4 = n5 ^ (n5 >>> 20 ^ n5 >>> 12);
        String string2 = this.pool[n5 = (n4 ^ (n4 >>> 7 ^ n4 >>> 4)) & this.pool.length - 1];
        if (string2 == null || string2.length() != n3) {
            object = new String((char[])object, n2, n3);
            this.pool[n5] = object;
            return object;
        }
        n4 = 0;
        while (n4 < n3) {
            if (string2.charAt(n4) != object[n2 + n4]) {
                object = new String((char[])object, n2, n3);
                this.pool[n5] = object;
                return object;
            }
            ++n4;
        }
        return string2;
    }
}

