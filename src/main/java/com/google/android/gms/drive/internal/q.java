/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.hq;
import com.google.android.gms.internal.hr;
import com.google.android.gms.internal.hs;
import com.google.android.gms.internal.ht;
import com.google.android.gms.internal.hv;
import java.io.IOException;

public final class q
extends ht {
    public static final q[] oG = new q[0];
    public String oH = "";
    public long oI = -1L;
    public long oJ = -1L;
    private int oK = -1;
    public int versionCode = 1;

    public static q e(byte[] byArray) throws hs {
        return ht.a(new q(), byArray);
    }

    public q a(hq hq2) throws IOException {
        block7: while (true) {
            int n2 = hq2.fz();
            switch (n2) {
                default: {
                    if (hv.a(hq2, n2)) continue block7;
                    return this;
                }
                case 8: {
                    this.versionCode = hq2.fB();
                    continue block7;
                }
                case 18: {
                    this.oH = hq2.readString();
                    continue block7;
                }
                case 24: {
                    this.oI = hq2.fC();
                    continue block7;
                }
                case 32: {
                    this.oJ = hq2.fC();
                    continue block7;
                }
                case 0: 
            }
            break;
        }
        return this;
    }

    @Override
    public void a(hr hr2) throws IOException {
        hr2.d(1, this.versionCode);
        hr2.b(2, this.oH);
        hr2.c(3, this.oI);
        hr2.c(4, this.oJ);
    }

    @Override
    public /* synthetic */ ht b(hq hq2) throws IOException {
        return this.a(hq2);
    }

    @Override
    public int cw() {
        int n2;
        this.oK = n2 = 0 + hr.e(1, this.versionCode) + hr.d(2, this.oH) + hr.d(3, this.oI) + hr.d(4, this.oJ);
        return n2;
    }
}

