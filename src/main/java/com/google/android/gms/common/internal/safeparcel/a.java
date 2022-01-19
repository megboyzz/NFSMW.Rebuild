/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class a {
    public static int A(int n2) {
        return 0xFFFF & n2;
    }

    public static Parcel[] A(Parcel parcel, int n2) {
        int n3 = a.a(parcel, n2);
        int n4 = parcel.dataPosition();
        if (n3 == 0) {
            return null;
        }
        int n5 = parcel.readInt();
        Parcel[] parcelArray = new Parcel[n5];
        n2 = 0;
        while (true) {
            if (n2 >= n5) {
                parcel.setDataPosition(n4 + n3);
                return parcelArray;
            }
            int n6 = parcel.readInt();
            if (n6 != 0) {
                int n7 = parcel.dataPosition();
                Parcel parcel2 = Parcel.obtain();
                parcel2.appendFrom(parcel, n7, n6);
                parcelArray[n2] = parcel2;
                parcel.setDataPosition(n6 + n7);
            } else {
                parcelArray[n2] = null;
            }
            ++n2;
        }
    }

    public static int a(Parcel parcel, int n2) {
        if ((n2 & 0xFFFF0000) == -65536) return parcel.readInt();
        return n2 >> 16 & 0xFFFF;
    }

    public static <T extends Parcelable> T a(Parcel parcel, int n2, Parcelable.Creator<T> parcelable) {
        n2 = a.a(parcel, n2);
        int n3 = parcel.dataPosition();
        if (n2 == 0) {
            return null;
        }
        parcelable = (Parcelable)parcelable.createFromParcel(parcel);
        parcel.setDataPosition(n2 + n3);
        return (T)parcelable;
    }

    private static void a(Parcel parcel, int n2, int n3) {
        if ((n2 = a.a(parcel, n2)) == n3) return;
        throw new a("Expected size " + n3 + " got " + n2 + " (0x" + Integer.toHexString(n2) + ")", parcel);
    }

    private static void a(Parcel parcel, int n2, int n3, int n4) {
        if (n3 == n4) return;
        throw new a("Expected size " + n4 + " got " + n3 + " (0x" + Integer.toHexString(n3) + ")", parcel);
    }

    public static void a(Parcel parcel, int n2, List list, ClassLoader classLoader) {
        n2 = a.a(parcel, n2);
        int n3 = parcel.dataPosition();
        if (n2 == 0) {
            return;
        }
        parcel.readList(list, classLoader);
        parcel.setDataPosition(n2 + n3);
    }

    public static void b(Parcel parcel, int n2) {
        parcel.setDataPosition(a.a(parcel, n2) + parcel.dataPosition());
    }

    public static <T> T[] b(Parcel parcel, int n2, Parcelable.Creator<T> objectArray) {
        n2 = a.a(parcel, n2);
        int n3 = parcel.dataPosition();
        if (n2 == 0) {
            return null;
        }
        objectArray = parcel.createTypedArray(objectArray);
        parcel.setDataPosition(n2 + n3);
        return objectArray;
    }

    public static <T> ArrayList<T> c(Parcel parcel, int n2, Parcelable.Creator<T> object) {
        n2 = a.a(parcel, n2);
        int n3 = parcel.dataPosition();
        if (n2 == 0) {
            return null;
        }
        object = parcel.createTypedArrayList(object);
        parcel.setDataPosition(n2 + n3);
        return object;
    }

    public static boolean c(Parcel parcel, int n2) {
        a.a(parcel, n2, 4);
        if (parcel.readInt() == 0) return false;
        return true;
    }

    public static Boolean d(Parcel parcel, int n2) {
        boolean bl2;
        int n3 = a.a(parcel, n2);
        if (n3 == 0) {
            return null;
        }
        a.a(parcel, n2, n3, 4);
        if (parcel.readInt() != 0) {
            bl2 = true;
            return bl2;
        }
        bl2 = false;
        return bl2;
    }

    public static byte e(Parcel parcel, int n2) {
        a.a(parcel, n2, 4);
        return (byte)parcel.readInt();
    }

    public static short f(Parcel parcel, int n2) {
        a.a(parcel, n2, 4);
        return (short)parcel.readInt();
    }

    public static int g(Parcel parcel, int n2) {
        a.a(parcel, n2, 4);
        return parcel.readInt();
    }

    public static long h(Parcel parcel, int n2) {
        a.a(parcel, n2, 8);
        return parcel.readLong();
    }

    public static BigInteger i(Parcel parcel, int n2) {
        n2 = a.a(parcel, n2);
        int n3 = parcel.dataPosition();
        if (n2 == 0) {
            return null;
        }
        byte[] byArray = parcel.createByteArray();
        parcel.setDataPosition(n2 + n3);
        return new BigInteger(byArray);
    }

    public static float j(Parcel parcel, int n2) {
        a.a(parcel, n2, 4);
        return parcel.readFloat();
    }

    public static int j(Parcel parcel) {
        return parcel.readInt();
    }

    public static double k(Parcel parcel, int n2) {
        a.a(parcel, n2, 8);
        return parcel.readDouble();
    }

    public static int k(Parcel parcel) {
        int n2 = a.j(parcel);
        int n3 = a.a(parcel, n2);
        int n4 = parcel.dataPosition();
        if (a.A(n2) != 20293) {
            throw new a("Expected object header. Got 0x" + Integer.toHexString(n2), parcel);
        }
        n2 = n4 + n3;
        if (n2 < n4) throw new a("Size read is invalid start=" + n4 + " end=" + n2, parcel);
        if (n2 <= parcel.dataSize()) return n2;
        throw new a("Size read is invalid start=" + n4 + " end=" + n2, parcel);
    }

    public static BigDecimal l(Parcel parcel, int n2) {
        n2 = a.a(parcel, n2);
        int n3 = parcel.dataPosition();
        if (n2 == 0) {
            return null;
        }
        byte[] byArray = parcel.createByteArray();
        int n4 = parcel.readInt();
        parcel.setDataPosition(n2 + n3);
        return new BigDecimal(new BigInteger(byArray), n4);
    }

    public static String m(Parcel parcel, int n2) {
        n2 = a.a(parcel, n2);
        int n3 = parcel.dataPosition();
        if (n2 == 0) {
            return null;
        }
        String string2 = parcel.readString();
        parcel.setDataPosition(n2 + n3);
        return string2;
    }

    public static IBinder n(Parcel parcel, int n2) {
        n2 = a.a(parcel, n2);
        int n3 = parcel.dataPosition();
        if (n2 == 0) {
            return null;
        }
        IBinder iBinder = parcel.readStrongBinder();
        parcel.setDataPosition(n2 + n3);
        return iBinder;
    }

    public static Bundle o(Parcel parcel, int n2) {
        n2 = a.a(parcel, n2);
        int n3 = parcel.dataPosition();
        if (n2 == 0) {
            return null;
        }
        Bundle bundle = parcel.readBundle();
        parcel.setDataPosition(n2 + n3);
        return bundle;
    }

    public static byte[] p(Parcel parcel, int n2) {
        n2 = a.a(parcel, n2);
        int n3 = parcel.dataPosition();
        if (n2 == 0) {
            return null;
        }
        byte[] byArray = parcel.createByteArray();
        parcel.setDataPosition(n2 + n3);
        return byArray;
    }

    public static boolean[] q(Parcel parcel, int n2) {
        n2 = a.a(parcel, n2);
        int n3 = parcel.dataPosition();
        if (n2 == 0) {
            return null;
        }
        boolean[] blArray = parcel.createBooleanArray();
        parcel.setDataPosition(n2 + n3);
        return blArray;
    }

    public static int[] r(Parcel parcel, int n2) {
        n2 = a.a(parcel, n2);
        int n3 = parcel.dataPosition();
        if (n2 == 0) {
            return null;
        }
        int[] nArray = parcel.createIntArray();
        parcel.setDataPosition(n2 + n3);
        return nArray;
    }

    public static long[] s(Parcel parcel, int n2) {
        n2 = a.a(parcel, n2);
        int n3 = parcel.dataPosition();
        if (n2 == 0) {
            return null;
        }
        long[] lArray = parcel.createLongArray();
        parcel.setDataPosition(n2 + n3);
        return lArray;
    }

    public static BigInteger[] t(Parcel parcel, int n2) {
        int n3 = a.a(parcel, n2);
        int n4 = parcel.dataPosition();
        if (n3 == 0) {
            return null;
        }
        int n5 = parcel.readInt();
        BigInteger[] bigIntegerArray = new BigInteger[n5];
        n2 = 0;
        while (true) {
            if (n2 >= n5) {
                parcel.setDataPosition(n4 + n3);
                return bigIntegerArray;
            }
            bigIntegerArray[n2] = new BigInteger(parcel.createByteArray());
            ++n2;
        }
    }

    public static float[] u(Parcel parcel, int n2) {
        n2 = a.a(parcel, n2);
        int n3 = parcel.dataPosition();
        if (n2 == 0) {
            return null;
        }
        float[] fArray = parcel.createFloatArray();
        parcel.setDataPosition(n2 + n3);
        return fArray;
    }

    public static double[] v(Parcel parcel, int n2) {
        n2 = a.a(parcel, n2);
        int n3 = parcel.dataPosition();
        if (n2 == 0) {
            return null;
        }
        double[] dArray = parcel.createDoubleArray();
        parcel.setDataPosition(n2 + n3);
        return dArray;
    }

    public static BigDecimal[] w(Parcel parcel, int n2) {
        int n3 = a.a(parcel, n2);
        int n4 = parcel.dataPosition();
        if (n3 == 0) {
            return null;
        }
        int n5 = parcel.readInt();
        BigDecimal[] bigDecimalArray = new BigDecimal[n5];
        n2 = 0;
        while (true) {
            if (n2 >= n5) {
                parcel.setDataPosition(n4 + n3);
                return bigDecimalArray;
            }
            byte[] byArray = parcel.createByteArray();
            int n6 = parcel.readInt();
            bigDecimalArray[n2] = new BigDecimal(new BigInteger(byArray), n6);
            ++n2;
        }
    }

    public static String[] x(Parcel parcel, int n2) {
        n2 = a.a(parcel, n2);
        int n3 = parcel.dataPosition();
        if (n2 == 0) {
            return null;
        }
        String[] stringArray = parcel.createStringArray();
        parcel.setDataPosition(n2 + n3);
        return stringArray;
    }

    public static ArrayList<String> y(Parcel parcel, int n2) {
        n2 = a.a(parcel, n2);
        int n3 = parcel.dataPosition();
        if (n2 == 0) {
            return null;
        }
        ArrayList arrayList = parcel.createStringArrayList();
        parcel.setDataPosition(n2 + n3);
        return arrayList;
    }

    public static Parcel z(Parcel parcel, int n2) {
        n2 = a.a(parcel, n2);
        int n3 = parcel.dataPosition();
        if (n2 == 0) {
            return null;
        }
        Parcel parcel2 = Parcel.obtain();
        parcel2.appendFrom(parcel, n3, n2);
        parcel.setDataPosition(n2 + n3);
        return parcel2;
    }

    public static class a
    extends RuntimeException {
        public a(String string2, Parcel parcel) {
            super(string2 + " Parcel: pos=" + parcel.dataPosition() + " size=" + parcel.dataSize());
        }
    }
}

