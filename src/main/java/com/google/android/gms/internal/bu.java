/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.bb;
import com.google.android.gms.internal.bv;
import com.google.android.gms.internal.bz;
import com.google.android.gms.internal.cj;
import com.google.android.gms.internal.cl;
import com.google.android.gms.internal.cv;
import com.google.android.gms.internal.h;

public final class bu {
    public static cl a(Context object, bz.a a2, h h2, cv cv2, bb bb2, a a3) {
        object = new bv((Context)object, a2, h2, cv2, bb2, a3);
        ((cl)object).start();
        return object;
    }

    public static interface a {
        public void a(cj var1);
    }
}

