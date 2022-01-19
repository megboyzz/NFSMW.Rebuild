/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal;

import com.google.android.gms.internal.hs;
import com.google.android.gms.internal.hv;
import java.io.IOException;

public final class hq {
    private int CJ;
    private int CK;
    private int CL;
    private int CM;
    private int CN = Integer.MAX_VALUE;
    private int CO = 64;
    private int CP = 0x4000000;
    private final byte[] buffer;

    private hq(byte[] byArray, int n2, int n3) {
        this.buffer = byArray;
        this.CJ = n2;
        this.CK = n2 + n3;
        this.CL = n2;
    }

    public static hq a(byte[] byArray, int n2, int n3) {
        return new hq(byArray, n2, n3);
    }

    public static long j(long l2) {
        return l2 >>> 1 ^ -(1L & l2);
    }

    public void bp(int n2) throws hs {
        if (this.CM == n2) return;
        throw hs.fP();
    }

    public boolean bq(int n2) throws IOException {
        switch (hv.bz(n2)) {
            default: {
                throw hs.fQ();
            }
            case 0: {
                this.fB();
                return true;
            }
            case 1: {
                this.fG();
                return true;
            }
            case 2: {
                this.bs(this.fD());
                return true;
            }
            case 3: {
                this.fA();
                this.bp(hv.g(hv.bA(n2), 4));
                return true;
            }
            case 4: {
                return false;
            }
            case 5: 
        }
        this.fF();
        return true;
    }

    public byte[] br(int n2) throws IOException {
        if (n2 < 0) {
            throw hs.fM();
        }
        if (this.CL + n2 > this.CN) {
            this.bs(this.CN - this.CL);
            throw hs.fL();
        }
        if (n2 > this.CK - this.CL) throw hs.fL();
        byte[] byArray = new byte[n2];
        System.arraycopy(this.buffer, this.CL, byArray, 0, n2);
        this.CL += n2;
        return byArray;
    }

    public void bs(int n2) throws IOException {
        if (n2 < 0) {
            throw hs.fM();
        }
        if (this.CL + n2 > this.CN) {
            this.bs(this.CN - this.CL);
            throw hs.fL();
        }
        if (n2 > this.CK - this.CL) throw hs.fL();
        this.CL += n2;
    }

    public void fA() throws IOException {
        int n2;
        do {
            if ((n2 = this.fz()) == 0) return;
        } while (this.bq(n2));
    }

    public int fB() throws IOException {
        return this.fD();
    }

    public long fC() throws IOException {
        return hq.j(this.fE());
    }

    public int fD() throws IOException {
        int n2 = this.fI();
        if (n2 >= 0) {
            return n2;
        }
        n2 &= 0x7F;
        int n3 = this.fI();
        if (n3 >= 0) {
            return n2 | n3 << 7;
        }
        n2 |= (n3 & 0x7F) << 7;
        n3 = this.fI();
        if (n3 >= 0) {
            return n2 | n3 << 14;
        }
        n2 |= (n3 & 0x7F) << 14;
        int n4 = this.fI();
        if (n4 >= 0) {
            return n2 | n4 << 21;
        }
        n3 = this.fI();
        n2 = n4 = n2 | (n4 & 0x7F) << 21 | n3 << 28;
        if (n3 >= 0) return n2;
        n3 = 0;
        while (n3 < 5) {
            n2 = n4;
            if (this.fI() >= 0) return n2;
            ++n3;
        }
        throw hs.fN();
    }

    public long fE() throws IOException {
        int n2 = 0;
        long l2 = 0L;
        while (n2 < 64) {
            byte by2 = this.fI();
            l2 |= (long)(by2 & 0x7F) << n2;
            if ((by2 & 0x80) == 0) {
                return l2;
            }
            n2 += 7;
        }
        throw hs.fN();
    }

    public int fF() throws IOException {
        return this.fI() & 0xFF | (this.fI() & 0xFF) << 8 | (this.fI() & 0xFF) << 16 | (this.fI() & 0xFF) << 24;
    }

    public long fG() throws IOException {
        byte by2 = this.fI();
        byte by3 = this.fI();
        byte by4 = this.fI();
        byte by5 = this.fI();
        byte by6 = this.fI();
        byte by7 = this.fI();
        byte by8 = this.fI();
        byte by9 = this.fI();
        long l2 = by2;
        return ((long)by3 & 0xFFL) << 8 | l2 & 0xFFL | ((long)by4 & 0xFFL) << 16 | ((long)by5 & 0xFFL) << 24 | ((long)by6 & 0xFFL) << 32 | ((long)by7 & 0xFFL) << 40 | ((long)by8 & 0xFFL) << 48 | ((long)by9 & 0xFFL) << 56;
    }

    public boolean fH() {
        if (this.CL != this.CK) return false;
        return true;
    }

    public byte fI() throws IOException {
        if (this.CL == this.CK) {
            throw hs.fL();
        }
        byte[] byArray = this.buffer;
        int n2 = this.CL;
        this.CL = n2 + 1;
        return byArray[n2];
    }

    public int fz() throws IOException {
        if (this.fH()) {
            this.CM = 0;
            return 0;
        }
        this.CM = this.fD();
        if (this.CM != 0) return this.CM;
        throw hs.fO();
    }

    public String readString() throws IOException {
        int n2 = this.fD();
        if (n2 > this.CK - this.CL) return new String(this.br(n2), "UTF-8");
        if (n2 <= 0) return new String(this.br(n2), "UTF-8");
        String string2 = new String(this.buffer, this.CL, n2, "UTF-8");
        this.CL = n2 + this.CL;
        return string2;
    }
}

