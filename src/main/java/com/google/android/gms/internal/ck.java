/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal;

import java.math.BigInteger;

public final class ck {
    private static Object hA;
    public static String ir;
    private static BigInteger is;



    public static String ar() {
        Object object = hA;
        synchronized (object) {
            String string2 = is.toString();
            is.add(BigInteger.ONE);
            return string2;
        }
    }
}

