/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 */
package com.google.android.gms.internal;

import android.util.Base64;
import com.google.android.gms.internal.j;

class a
implements j {
    a() {
    }

    @Override
    public String a(byte[] byArray, boolean bl2) {
        int n2;
        if (bl2) {
            n2 = 11;
            return Base64.encodeToString((byte[])byArray, (int)n2);
        }
        n2 = 2;
        return Base64.encodeToString((byte[])byArray, (int)n2);
    }

    @Override
    public byte[] a(String string2, boolean bl2) throws IllegalArgumentException {
        int n2;
        if (bl2) {
            n2 = 11;
            return Base64.decode((String)string2, (int)n2);
        }
        n2 = 2;
        return Base64.decode((String)string2, (int)n2);
    }
}

