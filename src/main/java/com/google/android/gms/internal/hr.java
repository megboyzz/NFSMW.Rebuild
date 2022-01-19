/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal;

import com.google.android.gms.internal.hv;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public final class hr {
    private final int CQ;
    private final byte[] buffer;
    private int position;

    private hr(byte[] byArray, int n2, int n3) {
        this.buffer = byArray;
        this.position = n2;
        this.CQ = n2 + n3;
    }

    public static int an(String object) {
        try {
            object = ((String)object).getBytes("UTF-8");
            int n2 = hr.by(((Object)object).length);
            int n3 = ((Object)object).length;
            return n3 + n2;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new RuntimeException("UTF-8 not supported.");
        }
    }

    public static hr b(byte[] byArray, int n2, int n3) {
        return new hr(byArray, n2, n3);
    }

    public static int bu(int n2) {
        if (n2 < 0) return 10;
        return hr.by(n2);
    }

    public static int bw(int n2) {
        return hr.by(hv.g(n2, 0));
    }

    public static int by(int n2) {
        if ((n2 & 0xFFFFFF80) == 0) {
            return 1;
        }
        if ((n2 & 0xFFFFC000) == 0) {
            return 2;
        }
        if ((0xFFE00000 & n2) == 0) {
            return 3;
        }
        if ((0xF0000000 & n2) != 0) return 5;
        return 4;
    }

    public static int d(int n2, long l2) {
        return hr.bw(n2) + hr.m(l2);
    }

    public static int d(int n2, String string2) {
        return hr.bw(n2) + hr.an(string2);
    }

    public static int e(int n2, int n3) {
        return hr.bw(n2) + hr.bu(n3);
    }

    public static hr i(byte[] byArray) {
        return hr.b(byArray, 0, byArray.length);
    }

    public static int m(long l2) {
        return hr.o(hr.p(l2));
    }

    public static int o(long l2) {
        if ((0xFFFFFFFFFFFFFF80L & l2) == 0L) {
            return 1;
        }
        if ((0xFFFFFFFFFFFFC000L & l2) == 0L) {
            return 2;
        }
        if ((0xFFFFFFFFFFE00000L & l2) == 0L) {
            return 3;
        }
        if ((0xFFFFFFFFF0000000L & l2) == 0L) {
            return 4;
        }
        if ((0xFFFFFFF800000000L & l2) == 0L) {
            return 5;
        }
        if ((0xFFFFFC0000000000L & l2) == 0L) {
            return 6;
        }
        if ((0xFFFE000000000000L & l2) == 0L) {
            return 7;
        }
        if ((0xFF00000000000000L & l2) == 0L) {
            return 8;
        }
        if ((Long.MIN_VALUE & l2) != 0L) return 10;
        return 9;
    }

    public static long p(long l2) {
        return l2 << 1 ^ l2 >> 63;
    }

    public void am(String object) throws IOException {
        object = ((String)object).getBytes("UTF-8");
        this.bx(((Object)object).length);
        this.j((byte[])object);
    }

    public void b(byte by2) throws IOException {
        if (this.position == this.CQ) {
            throw new a(this.position, this.CQ);
        }
        byte[] byArray = this.buffer;
        int n2 = this.position;
        this.position = n2 + 1;
        byArray[n2] = by2;
    }

    public void b(int n2, long l2) throws IOException {
        this.f(n2, 0);
        this.k(l2);
    }

    public void b(int n2, String string2) throws IOException {
        this.f(n2, 2);
        this.am(string2);
    }

    public void bt(int n2) throws IOException {
        if (n2 >= 0) {
            this.bx(n2);
            return;
        }
        this.n(n2);
    }

    public void bv(int n2) throws IOException {
        this.b((byte)n2);
    }

    public void bx(int n2) throws IOException {
        while (true) {
            if ((n2 & 0xFFFFFF80) == 0) {
                this.bv(n2);
                return;
            }
            this.bv(n2 & 0x7F | 0x80);
            n2 >>>= 7;
        }
    }

    public void c(int n2, long l2) throws IOException {
        this.f(n2, 0);
        this.l(l2);
    }

    public void c(byte[] byArray, int n2, int n3) throws IOException {
        if (this.CQ - this.position < n3) throw new a(this.position, this.CQ);
        System.arraycopy(byArray, n2, this.buffer, this.position, n3);
        this.position += n3;
    }

    public void d(int n2, int n3) throws IOException {
        this.f(n2, 0);
        this.bt(n3);
    }

    public void f(int n2, int n3) throws IOException {
        this.bx(hv.g(n2, n3));
    }

    public int fJ() {
        return this.CQ - this.position;
    }

    public void fK() {
        if (this.fJ() == 0) return;
        throw new IllegalStateException("Did not write as much data as expected.");
    }

    public void j(byte[] byArray) throws IOException {
        this.c(byArray, 0, byArray.length);
    }

    public void k(long l2) throws IOException {
        this.n(l2);
    }

    public void l(long l2) throws IOException {
        this.n(hr.p(l2));
    }

    public void n(long l2) throws IOException {
        while (true) {
            if ((0xFFFFFFFFFFFFFF80L & l2) == 0L) {
                this.bv((int)l2);
                return;
            }
            this.bv((int)l2 & 0x7F | 0x80);
            l2 >>>= 7;
        }
    }

    public static class a
    extends IOException {
        a(int n2, int n3) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + n2 + " limit " + n3 + ").");
        }
    }
}

