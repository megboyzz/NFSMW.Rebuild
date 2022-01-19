/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal;

public final class em {
    public static void a(StringBuilder stringBuilder, double[] dArray) {
        int n2 = dArray.length;
        int n3 = 0;
        while (n3 < n2) {
            if (n3 != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(Double.toString(dArray[n3]));
            ++n3;
        }
    }

    public static void a(StringBuilder stringBuilder, float[] fArray) {
        int n2 = fArray.length;
        int n3 = 0;
        while (n3 < n2) {
            if (n3 != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(Float.toString(fArray[n3]));
            ++n3;
        }
    }

    public static void a(StringBuilder stringBuilder, int[] nArray) {
        int n2 = nArray.length;
        int n3 = 0;
        while (n3 < n2) {
            if (n3 != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(Integer.toString(nArray[n3]));
            ++n3;
        }
    }

    public static void a(StringBuilder stringBuilder, long[] lArray) {
        int n2 = lArray.length;
        int n3 = 0;
        while (n3 < n2) {
            if (n3 != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(Long.toString(lArray[n3]));
            ++n3;
        }
    }

    public static <T> void a(StringBuilder stringBuilder, T[] TArray) {
        int n2 = TArray.length;
        int n3 = 0;
        while (n3 < n2) {
            if (n3 != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(TArray[n3].toString());
            ++n3;
        }
    }

    public static void a(StringBuilder stringBuilder, String[] stringArray) {
        int n2 = stringArray.length;
        int n3 = 0;
        while (n3 < n2) {
            if (n3 != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append("\"").append(stringArray[n3]).append("\"");
            ++n3;
        }
    }

    public static void a(StringBuilder stringBuilder, boolean[] blArray) {
        int n2 = blArray.length;
        int n3 = 0;
        while (n3 < n2) {
            if (n3 != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(Boolean.toString(blArray[n3]));
            ++n3;
        }
    }
}

