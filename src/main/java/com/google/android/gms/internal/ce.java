/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.google.android.gms.internal;

import android.content.Context;

import com.ea.ironmonkey.devmenu.util.Observer;

import java.util.List;
import java.util.Map;

public final class ce
extends a {
    private static final Object hA = new Object();
    private static ce hB;
    private final aq hC;
    private final Context mContext;

    private ce(Context context, aq aq2) {
        this.mContext = context;
        this.hC = aq2;
    }

    private static cb a(final Context context, aq object, final bz bz2) {
        String string2;
        cs.r("Starting ad request from service.");
        object.init();
        ci ci2 = new ci(context);
        if (ci2.ih == -1) {
            cs.r("Device is offline.");
            return new cb(2);
        }
        final cg cg2 = new cg();
        if (bz2.hp.extras != null && (string2 = bz2.hp.extras.getString("_ad")) != null) {
            return cf.a(context, bz2, string2);
        }
        return new cb(cg2.getErrorCode());
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    public static cb a(Context var0, String var1_3, String var2_4) {
        Observer.onCallingMethod(
                Observer.Method.RETURN_NULL,
                Observer.Method.HARD_TO_RECOVER_LOGIC
        );
       return null;
    }

    public static ce a(Context object, aq aq2) {
        Object object2 = hA;
        synchronized (object2) {
            if (hB != null) return hB;
            hB = new ce(object.getApplicationContext(), aq2);
            return hB;
        }
    }

    private static void a(String object, Map<String, List<String>> map, String string2, int n2) {
        if (!cs.n(2)) return;
        cs.u("Http Response: {\n  URL:\n    " + (String)((Object)object) + "\n  Headers:");
        if (map != null) {
            for (String string3 : map.keySet()) {
                cs.u("    " + string3 + ":");
                for (String string4 : map.get(string3)) {
                    cs.u("      " + string4);
                }
            }
        }
        cs.u("  Body:");
        if (string2 != null) {
            for (int i2 = 0; i2 < Math.min(string2.length(), 100000); i2 += 1000) {
                cs.u(string2.substring(i2, Math.min(string2.length(), i2 + 1000)));
            }
        } else {
            cs.u("    null");
        }
        cs.u("  Response Code:\n    " + n2 + "\n}");
    }
}

