/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal;

import com.google.android.gms.internal.hr;
import com.google.android.gms.internal.k;
import java.io.IOException;

class m
implements k {
    private hr dR;
    private byte[] dS;
    private final int dT;

    public m(int n2) {
        this.dT = n2;
        this.reset();
    }

    @Override
    public void b(int n2, long l2) throws IOException {
        this.dR.b(n2, l2);
    }

    @Override
    public void b(int n2, String string2) throws IOException {
        this.dR.b(n2, string2);
    }

    @Override
    public byte[] h() throws IOException {
        int n2 = this.dR.fJ();
        if (n2 < 0) {
            throw new IOException();
        }
        if (n2 == 0) {
            return this.dS;
        }
        byte[] byArray = new byte[this.dS.length - n2];
        System.arraycopy(this.dS, 0, byArray, 0, byArray.length);
        return byArray;
    }

    @Override
    public void reset() {
        this.dS = new byte[this.dT];
        this.dR = hr.i(this.dS);
    }
}

