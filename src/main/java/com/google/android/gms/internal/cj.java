/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal;

import com.google.android.gms.internal.at;
import com.google.android.gms.internal.au;
import com.google.android.gms.internal.aw;
import com.google.android.gms.internal.bc;
import com.google.android.gms.internal.cv;
import com.google.android.gms.internal.v;
import com.google.android.gms.internal.x;
import java.util.Collections;
import java.util.List;

public final class cj {
    public final int errorCode;
    public final List<String> fK;
    public final List<String> fL;
    public final long fO;
    public final cv gI;
    public final at ga;
    public final bc gb;
    public final String gc;
    public final aw gd;
    public final v hp;
    public final String hs;
    public final long hv;
    public final boolean hw;
    public final long hx;
    public final List<String> hy;
    public final au ip;
    public final x iq;
    public final int orientation;

    public cj(v list, cv cv2, List<String> list2, int n2, List<String> list3, List<String> list4, int n3, long l2, String string2, boolean bl2, at at2, bc bc2, String string3, au au2, aw aw2, long l3, x x2, long l4) {
        this.hp = list;
        this.gI = cv2;
        list = list2 != null ? Collections.unmodifiableList(list2) : null;
        this.fK = list;
        this.errorCode = n2;
        list = list3 != null ? Collections.unmodifiableList(list3) : null;
        this.fL = list;
        list = list4 != null ? Collections.unmodifiableList(list4) : null;
        this.hy = list;
        this.orientation = n3;
        this.fO = l2;
        this.hs = string2;
        this.hw = bl2;
        this.ga = at2;
        this.gb = bc2;
        this.gc = string3;
        this.ip = au2;
        this.gd = aw2;
        this.hx = l3;
        this.iq = x2;
        this.hv = l4;
    }
}

