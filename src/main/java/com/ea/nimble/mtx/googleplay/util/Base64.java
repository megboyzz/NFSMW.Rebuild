/*
 * Decompiled with CFR 0.152.
 */
package com.ea.nimble.mtx.googleplay.util;

import com.ea.nimble.mtx.googleplay.util.Base64DecoderException;

public class Base64 {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final byte[] ALPHABET;
    private static final byte[] DECODABET;
    public static final boolean DECODE = false;
    public static final boolean ENCODE = true;
    private static final byte EQUALS_SIGN = 61;
    private static final byte EQUALS_SIGN_ENC = -1;
    private static final byte NEW_LINE = 10;
    private static final byte[] WEBSAFE_ALPHABET;
    private static final byte[] WEBSAFE_DECODABET;
    private static final byte WHITE_SPACE_ENC = -5;

    static {
        boolean bl2 = !Base64.class.desiredAssertionStatus();
        $assertionsDisabled = bl2;
        ALPHABET = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        WEBSAFE_ALPHABET = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        DECODABET = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9};
        WEBSAFE_DECODABET = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9};
    }

    private Base64() {
    }

    public static byte[] decode(String object) throws Base64DecoderException {
        object = ((String)object).getBytes();
        return Base64.decode((byte[])object, 0, ((Object)object).length);
    }

    public static byte[] decode(byte[] byArray) throws Base64DecoderException {
        return Base64.decode(byArray, 0, byArray.length);
    }

    public static byte[] decode(byte[] byArray, int n2, int n3) throws Base64DecoderException {
        return Base64.decode(byArray, n2, n3, DECODABET);
    }

    /*
     * Unable to fully structure code
     */
    public static byte[] decode(byte[] var0, int var1_1, int var2_2, byte[] var3_3) throws Base64DecoderException {
        var10_4 = new byte[var2_2 * 3 / 4 + 2];
        var6_5 = 0;
        var11_6 = new byte[4];
        var7_7 = 0;
        var5_8 = 0;
        while (true) {
            if (var7_7 >= var2_2) ** GOTO lbl-1000
            var4_9 = (byte)(var0[var7_7 + var1_1] & 127);
            var8_10 = var3_3[var4_9];
            if (var8_10 < -5) throw new Base64DecoderException("Bad Base64 input character at " + var7_7 + ": " + var0[var7_7 + var1_1] + "(decimal)");
            if (var8_10 >= -1) {
                if (var4_9 != 61) {
                    var9_11 = var5_8 + 1;
                    var11_6[var5_8] = var4_9;
                    var5_8 = var9_11;
                    var8_10 = var6_5;
                    if (var9_11 == 4) {
                        var8_10 = var6_5 + Base64.decode4to3(var11_6, 0, var10_4, var6_5, var3_3);
                        var5_8 = 0;
                    }
                } else {
                    var8_10 = var2_2 - var7_7;
                    var1_1 = (byte)(var0[var2_2 - 1 + var1_1] & 127);
                    if (var5_8 == 0) throw new Base64DecoderException("invalid padding byte '=' at byte offset " + var7_7);
                    if (var5_8 == 1) {
                        throw new Base64DecoderException("invalid padding byte '=' at byte offset " + var7_7);
                    }
                    if (var5_8 == 3) {
                        if (var8_10 > 2) throw new Base64DecoderException("padding byte '=' falsely signals end of encoded value at offset " + var7_7);
                    }
                    if (var5_8 == 4 && var8_10 > 1) {
                        throw new Base64DecoderException("padding byte '=' falsely signals end of encoded value at offset " + var7_7);
                    }
                    if (var1_1 != 61 && var1_1 != 10) {
                        throw new Base64DecoderException("encoded value has invalid trailing byte");
                    } else {
                        ** GOTO lbl-1000
                    }
                }
            }
            ** GOTO lbl41
lbl-1000:
            // 3 sources

            {
                if (var5_8 != 0) {
                    if (var5_8 == 1) {
                        throw new Base64DecoderException("single trailing character at offset " + (var2_2 - 1));
                    }
                    var11_6[var5_8] = 61;
                    var6_5 += Base64.decode4to3(var11_6, 0, var10_4, var6_5, var3_3);
                }
                var0 = new byte[var6_5];
                System.arraycopy(var10_4, 0, var0, 0, var6_5);
                return var0;
lbl41:
                // 1 sources

                var8_10 = var6_5;
            }
            ++var7_7;
            var6_5 = var8_10;
        }
    }

    private static int decode4to3(byte[] byArray, int n2, byte[] byArray2, int n3, byte[] byArray3) {
        if (byArray[n2 + 2] == 61) {
            byArray2[n3] = (byte)((byArray3[byArray[n2]] << 24 >>> 6 | byArray3[byArray[n2 + 1]] << 24 >>> 12) >>> 16);
            return 1;
        }
        if (byArray[n2 + 3] == 61) {
            n2 = byArray3[byArray[n2]] << 24 >>> 6 | byArray3[byArray[n2 + 1]] << 24 >>> 12 | byArray3[byArray[n2 + 2]] << 24 >>> 18;
            byArray2[n3] = (byte)(n2 >>> 16);
            byArray2[n3 + 1] = (byte)(n2 >>> 8);
            return 2;
        }
        n2 = byArray3[byArray[n2]] << 24 >>> 6 | byArray3[byArray[n2 + 1]] << 24 >>> 12 | byArray3[byArray[n2 + 2]] << 24 >>> 18 | byArray3[byArray[n2 + 3]] << 24 >>> 24;
        byArray2[n3] = (byte)(n2 >> 16);
        byArray2[n3 + 1] = (byte)(n2 >> 8);
        byArray2[n3 + 2] = (byte)n2;
        return 3;
    }

    public static byte[] decodeWebSafe(String object) throws Base64DecoderException {
        object = ((String)object).getBytes();
        return Base64.decodeWebSafe((byte[])object, 0, ((Object)object).length);
    }

    public static byte[] decodeWebSafe(byte[] byArray) throws Base64DecoderException {
        return Base64.decodeWebSafe(byArray, 0, byArray.length);
    }

    public static byte[] decodeWebSafe(byte[] byArray, int n2, int n3) throws Base64DecoderException {
        return Base64.decode(byArray, n2, n3, WEBSAFE_DECODABET);
    }

    public static String encode(byte[] byArray) {
        return Base64.encode(byArray, 0, byArray.length, ALPHABET, true);
    }

    public static String encode(byte[] byArray, int n2, int n3, byte[] byArray2, boolean bl2) {
        byArray = Base64.encode(byArray, n2, n3, byArray2, Integer.MAX_VALUE);
        n2 = byArray.length;
        while (!bl2) {
            if (n2 <= 0) return new String(byArray, 0, n2);
            if (byArray[n2 - 1] != 61) {
                return new String(byArray, 0, n2);
            }
            --n2;
        }
        return new String(byArray, 0, n2);
    }

    public static byte[] encode(byte[] byArray, int n2, int n3, byte[] byArray2, int n4) {
        int n5;
        int n6;
        int n7 = (n3 + 2) / 3 * 4;
        byte[] byArray3 = new byte[n7 / n4 + n7];
        n7 = 0;
        int n8 = 0;
        for (n6 = 0; n6 < n3 - 2; n6 += 3) {
            n5 = byArray[n6 + n2] << 24 >>> 8 | byArray[n6 + 1 + n2] << 24 >>> 16 | byArray[n6 + 2 + n2] << 24 >>> 24;
            byArray3[n7] = byArray2[n5 >>> 18];
            byArray3[n7 + 1] = byArray2[n5 >>> 12 & 0x3F];
            byArray3[n7 + 2] = byArray2[n5 >>> 6 & 0x3F];
            byArray3[n7 + 3] = byArray2[n5 & 0x3F];
            int n9 = n8 + 4;
            n5 = n7;
            n8 = n9;
            if (n9 == n4) {
                byArray3[n7 + 4] = 10;
                n5 = n7 + 1;
                n8 = 0;
            }
            n7 = n5 + 4;
        }
        n5 = n7;
        if (n6 < n3) {
            Base64.encode3to4(byArray, n6 + n2, n3 - n6, byArray3, n7, byArray2);
            n2 = n7;
            if (n8 + 4 == n4) {
                byArray3[n7 + 4] = 10;
                n2 = n7 + 1;
            }
            n5 = n2 + 4;
        }
        if ($assertionsDisabled) return byArray3;
        if (n5 == byArray3.length) return byArray3;
        throw new AssertionError();
    }

    private static byte[] encode3to4(byte[] byArray, int n2, int n3, byte[] byArray2, int n4, byte[] byArray3) {
        int n5 = 0;
        int n6 = n3 > 0 ? byArray[n2] << 24 >>> 8 : 0;
        int n7 = n3 > 1 ? byArray[n2 + 1] << 24 >>> 16 : 0;
        if (n3 > 2) {
            n5 = byArray[n2 + 2] << 24 >>> 24;
        }
        n2 = n7 | n6 | n5;
        switch (n3) {
            default: {
                return byArray2;
            }
            case 3: {
                byArray2[n4] = byArray3[n2 >>> 18];
                byArray2[n4 + 1] = byArray3[n2 >>> 12 & 0x3F];
                byArray2[n4 + 2] = byArray3[n2 >>> 6 & 0x3F];
                byArray2[n4 + 3] = byArray3[n2 & 0x3F];
                return byArray2;
            }
            case 2: {
                byArray2[n4] = byArray3[n2 >>> 18];
                byArray2[n4 + 1] = byArray3[n2 >>> 12 & 0x3F];
                byArray2[n4 + 2] = byArray3[n2 >>> 6 & 0x3F];
                byArray2[n4 + 3] = 61;
                return byArray2;
            }
            case 1: 
        }
        byArray2[n4] = byArray3[n2 >>> 18];
        byArray2[n4 + 1] = byArray3[n2 >>> 12 & 0x3F];
        byArray2[n4 + 2] = 61;
        byArray2[n4 + 3] = 61;
        return byArray2;
    }

    public static String encodeWebSafe(byte[] byArray, boolean bl2) {
        return Base64.encode(byArray, 0, byArray.length, WEBSAFE_ALPHABET, bl2);
    }
}

