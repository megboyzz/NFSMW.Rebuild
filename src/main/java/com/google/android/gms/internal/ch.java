/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal;

import com.google.android.gms.internal.cb;
import com.google.android.gms.internal.cn;
import com.google.android.gms.internal.cs;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class ch {
    private String hM;
    private String hN;
    private String hO;
    private List<String> hP;
    private List<String> hQ;
    private long hR = -1L;
    private boolean hS = false;
    private final long hT;
    private List<String> hU;
    private long hV = -1L;
    private int mOrientation = -1;

    public ch() {
        this.hT = -1L;
    }

    private static long a(Map<String, List<String>> object, String string2) {
        if ((object = object.get(string2)) == null) return -1L;
        if (object.isEmpty()) return -1L;
        object = (String)object.get(0);
        try {
            float f2 = Float.parseFloat((String)object);
            return (long)(f2 * 1000.0f);
        }
        catch (NumberFormatException numberFormatException) {
            cs.v("Could not parse float from " + string2 + " header: " + (String)object);
            return -1L;
        }
    }

    private static List<String> b(Map<String, List<String>> object, String string2) {
        if ((object = object.get(string2)) == null) return null;
        if (object.isEmpty()) return null;
        if ((object = (String)object.get(0)) == null) return null;
        return Arrays.asList(((String)object).trim().split("\\s+"));
    }

    private void e(Map<String, List<String>> object) {
        if ((object = object.get("X-Afma-Ad-Size")) == null) return;
        if (object.isEmpty()) return;
        this.hM = (String)object.get(0);
    }

    private void f(Map<String, List<String>> object) {
        if ((object = ch.b(object, "X-Afma-Click-Tracking-Urls")) == null) return;
        this.hP = object;
    }

    private void g(Map<String, List<String>> object) {
        if ((object = ch.b(object, "X-Afma-Tracking-Urls")) == null) return;
        this.hQ = object;
    }

    private void h(Map<String, List<String>> map) {
        long l2 = ch.a(map, "X-Afma-Interstitial-Timeout");
        if (l2 == -1L) return;
        this.hR = l2;
    }

    private void i(Map<String, List<String>> object) {
        if ((object = object.get("X-Afma-Mediation")) == null) return;
        if (object.isEmpty()) return;
        this.hS = Boolean.valueOf((String)object.get(0));
    }

    private void j(Map<String, List<String>> object) {
        if ((object = ch.b(object, "X-Afma-Manual-Tracking-Urls")) == null) return;
        this.hU = object;
    }

    private void k(Map<String, List<String>> map) {
        long l2 = ch.a(map, "X-Afma-Refresh-Rate");
        if (l2 == -1L) return;
        this.hV = l2;
    }

    private void l(Map<String, List<String>> object) {
        if ((object = object.get("X-Afma-Orientation")) == null) return;
        if (object.isEmpty()) return;
        if ("portrait".equalsIgnoreCase((String)(object = (String)object.get(0)))) {
            this.mOrientation = cn.au();
            return;
        }
        if (!"landscape".equalsIgnoreCase((String)object)) return;
        this.mOrientation = cn.at();
    }

    public void a(String string2, Map<String, List<String>> map, String string3) {
        this.hN = string2;
        this.hO = string3;
        this.d(map);
    }

    public cb aq() {
        return new cb(this.hN, this.hO, this.hP, this.hQ, this.hR, this.hS, -1L, this.hU, this.hV, this.mOrientation, this.hM);
    }

    public void d(Map<String, List<String>> map) {
        this.e(map);
        this.f(map);
        this.g(map);
        this.h(map);
        this.i(map);
        this.j(map);
        this.k(map);
        this.l(map);
    }
}

