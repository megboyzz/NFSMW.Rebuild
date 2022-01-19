/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal;

public class hp {
    private final byte[] CG = new byte[256];
    private int CH;
    private int CI;

    public hp(byte[] byArray) {
        int n2;
        for (n2 = 0; n2 < 256; ++n2) {
            this.CG[n2] = (byte)n2;
        }
        int n3 = 0;
        n2 = 0;
        while (true) {
            if (n2 >= 256) {
                this.CH = 0;
                this.CI = 0;
                return;
            }
            n3 = n3 + this.CG[n2] + byArray[n2 % byArray.length] & 0xFF;
            byte by2 = this.CG[n2];
            this.CG[n2] = this.CG[n3];
            this.CG[n3] = by2;
            ++n2;
        }
    }

    public void h(byte[] byArray) {
        int n2 = this.CH;
        int n3 = this.CI;
        int n4 = 0;
        while (true) {
            if (n4 >= byArray.length) {
                this.CH = n2;
                this.CI = n3;
                return;
            }
            n2 = n2 + 1 & 0xFF;
            n3 = n3 + this.CG[n2] & 0xFF;
            byte by2 = this.CG[n2];
            this.CG[n2] = this.CG[n3];
            this.CG[n3] = by2;
            byArray[n4] = (byte)(byArray[n4] ^ this.CG[this.CG[n2] + this.CG[n3] & 0xFF]);
            ++n4;
        }
    }
}

