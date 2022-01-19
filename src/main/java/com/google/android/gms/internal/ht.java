/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal;

import com.google.android.gms.internal.hq;
import com.google.android.gms.internal.hr;
import com.google.android.gms.internal.hs;
import com.google.android.gms.internal.hu;
import java.io.IOException;

public abstract class ht {
    protected int oK = -1;

    public static final <T extends ht> T a(T t2, byte[] byArray) throws hs {
        return ht.b(t2, byArray, 0, byArray.length);
    }

    public static final void a(ht ht2, byte[] object, int n2, int n3) {
        try {
            object = hr.b((byte[])object, n2, n3);
            ht2.a((hr)object);
            ((hr)object).fK();
            return;
        }
        catch (IOException iOException) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", iOException);
        }
    }

    public static final byte[] a(ht ht2) {
        byte[] byArray = new byte[ht2.cw()];
        ht.a(ht2, byArray, 0, byArray.length);
        return byArray;
    }

    public static final <T extends ht> T b(T t2, byte[] object, int n2, int n3) throws hs {
        try {
            object = hq.a((byte[])object, n2, n3);
            t2.b((hq)object);
            ((hq)object).bp(0);
            return t2;
        }
        catch (hs hs2) {
            throw hs2;
        }
        catch (IOException iOException) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public abstract void a(hr var1) throws IOException;

    public abstract ht b(hq var1) throws IOException;

    public int cw() {
        this.oK = 0;
        return 0;
    }

    public String toString() {
        return hu.b(this);
    }
}

