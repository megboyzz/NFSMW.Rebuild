/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public final class ck {
    private static final Object hA;
    public static final String ir;
    private static BigInteger is;

    /*
     * Unable to fully structure code
     */
    static {
        var1 = UUID.randomUUID();
        var3_1 = BigInteger.valueOf(var1.getLeastSignificantBits()).toByteArray();
        var4_2 = BigInteger.valueOf(var1.getMostSignificantBits()).toByteArray();
        var1 = new BigInteger(1, var3_1).toString();
        var0_3 = 0;
        block2: while (true) {
            if (var0_3 >= 2) {
                ck.ir = var1;
                ck.hA = new Object();
                ck.is = BigInteger.ONE;
                return;
            }
            try {
                var2_4 = MessageDigest.getInstance("MD5");
                var2_4.update(var3_1);
                var2_4.update(var4_2);
                var5_6 = new byte[8];
                System.arraycopy(var2_4.digest(), 0, var5_6, 0, 8);
                var1 = var2_4 = new BigInteger(1, var5_6).toString();
lbl19:
                // 2 sources

                while (true) {
                    ++var0_3;
                    continue block2;
                    break;
                }
            }
            catch (NoSuchAlgorithmException var2_5) {
                ** continue;
            }
        }
    }

    public static String ar() {
        Object object = hA;
        synchronized (object) {
            String string2 = is.toString();
            is.add(BigInteger.ONE);
            return string2;
        }
    }
}

