/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal;

import com.google.android.gms.internal.hq;
import java.io.IOException;

public final class hv {
    static final int CR = hv.g(1, 3);
    static final int CS = hv.g(1, 4);
    static final int CT = hv.g(2, 0);
    static final int CU = hv.g(3, 2);
    public static final int[] CV = new int[0];
    public static final long[] CW = new long[0];
    public static final float[] CX = new float[0];
    public static final double[] CY = new double[0];
    public static final boolean[] CZ = new boolean[0];
    public static final String[] Da = new String[0];
    public static final byte[][] Db = new byte[0][];
    public static final byte[] Dc = new byte[0];

    public static boolean a(hq hq2, int n2) throws IOException {
        return hq2.bq(n2);
    }

    public static int bA(int n2) {
        return n2 >>> 3;
    }

    static int bz(int n2) {
        return n2 & 7;
    }

    static int g(int n2, int n3) {
        return n2 << 3 | n3;
    }
}

