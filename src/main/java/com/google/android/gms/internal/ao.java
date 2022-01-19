/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal;

import com.google.android.gms.internal.an;
import com.google.android.gms.internal.bj;
import com.google.android.gms.internal.cn;
import com.google.android.gms.internal.cs;
import com.google.android.gms.internal.cv;
import com.google.android.gms.internal.cw;
import java.util.Map;

public final class ao
implements an {
    private static boolean a(Map<String, String> map) {
        return "1".equals(map.get("custom_close"));
    }

    private static int b(Map<String, String> object) {
        if ((object = object.get("o")) == null) return -1;
        if ("p".equalsIgnoreCase((String)object)) {
            return cn.au();
        }
        if (!"l".equalsIgnoreCase((String)object)) return -1;
        return cn.at();
    }

    @Override
    public void a(cv object, Map<String, String> map) {
        String string2 = map.get("a");
        if (string2 == null) {
            cs.v("Action missing from an open GMSG.");
            return;
        }
        cw cw2 = object.aB();
        if ("expand".equalsIgnoreCase(string2)) {
            if (object.aE()) {
                cs.v("Cannot expand WebView that is already expanded.");
                return;
            }
            cw2.a(ao.a(map), ao.b(map));
            return;
        }
        if (!"webapp".equalsIgnoreCase(string2)) {
            cw2.a(new bj(map.get("i"), map.get("u"), map.get("m"), map.get("p"), map.get("c"), map.get("f"), map.get("e")));
            return;
        }
        object = map.get("u");
        if (object != null) {
            cw2.a(ao.a(map), ao.b(map), (String)object);
            return;
        }
        cw2.a(ao.a(map), ao.b(map), map.get("html"), map.get("baseurl"));
    }
}

