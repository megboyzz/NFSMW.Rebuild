/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Color
 *  android.location.Location
 *  android.text.TextUtils
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.text.TextUtils;

import com.ea.ironmonkey.devmenu.util.Observer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public final class cf {
    private static final SimpleDateFormat hH = new SimpleDateFormat("yyyyMMdd");

    /*
     * Enabled unnecessary exception pruning
     */
    public static cb a(Context object, bz object2, String string2) {
        Observer.onCallingMethod(
                Observer.Method.HARD_TO_RECOVER_LOGIC,
                Observer.Method.RETURN_NULL
                );
        return null;
    }

    /*
     * WARNING - combined exceptions agressively - possible behaviour change.
     * Enabled unnecessary exception pruning
     */
    public static String a(bz object, ci ci2, Location object2) {
        Observer.onCallingMethod(Observer.Method.HARD_TO_RECOVER_LOGIC);
        return "";
    }

    private static void a(HashMap<String, Object> hashMap, Location location) {
        HashMap<String, Number> hashMap2 = new HashMap<String, Number>();
        float f2 = location.getAccuracy();
        long l2 = location.getTime();
        long l3 = (long)(location.getLatitude() * 1.0E7);
        long l4 = (long)(location.getLongitude() * 1.0E7);
        hashMap2.put("radius", f2 * 1000.0f);
        hashMap2.put("lat", l3);
        hashMap2.put("long", l4);
        hashMap2.put("time", l2 * 1000L);
        hashMap.put("uule", hashMap2);
    }

    private static void a(HashMap<String, Object> hashMap, ai ai2) {
        String string2;
        Object var3_2 = null;
        if (Color.alpha((int)ai2.eZ) != 0) {
            hashMap.put("acolor", cf.m(ai2.eZ));
        }
        if (Color.alpha((int)ai2.backgroundColor) != 0) {
            hashMap.put("bgcolor", cf.m(ai2.backgroundColor));
        }
        if (Color.alpha((int)ai2.fa) != 0 && Color.alpha((int)ai2.fb) != 0) {
            hashMap.put("gradientto", cf.m(ai2.fa));
            hashMap.put("gradientfrom", cf.m(ai2.fb));
        }
        if (Color.alpha((int)ai2.fc) != 0) {
            hashMap.put("bcolor", cf.m(ai2.fc));
        }
        hashMap.put("bthick", Integer.toString(ai2.fd));
        switch (ai2.fe) {
            default: {
                string2 = null;
                break;
            }
            case 0: {
                string2 = "none";
                break;
            }
            case 1: {
                string2 = "dashed";
                break;
            }
            case 2: {
                string2 = "dotted";
                break;
            }
            case 3: {
                string2 = "solid";
            }
        }
        if (string2 != null) {
            hashMap.put("btype", string2);
        }
        switch (ai2.ff) {
            default: {
                break;
            }
            case 2: {
                string2 = "dark";
                break;
            }
            case 0: {
                string2 = "light";
                break;
            }
            case 1: {
                string2 = "medium";
            }
        }
        if (string2 != null) {
            hashMap.put("callbuttoncolor", string2);
        }
        if (ai2.fg != null) {
            hashMap.put("channel", ai2.fg);
        }
        if (Color.alpha((int)ai2.fh) != 0) {
            hashMap.put("dcolor", cf.m(ai2.fh));
        }
        if (ai2.fi != null) {
            hashMap.put("font", ai2.fi);
        }
        if (Color.alpha((int)ai2.fj) != 0) {
            hashMap.put("hcolor", cf.m(ai2.fj));
        }
        hashMap.put("headersize", Integer.toString(ai2.fk));
        if (ai2.fl == null) return;
        hashMap.put("q", ai2.fl);
    }

    private static void a(HashMap<String, Object> hashMap, ci ci2) {
        hashMap.put("am", ci2.hW);
        hashMap.put("cog", cf.j(ci2.hX));
        hashMap.put("coh", cf.j(ci2.hY));
        if (!TextUtils.isEmpty((CharSequence)ci2.hZ)) {
            hashMap.put("carrier", ci2.hZ);
        }
        hashMap.put("gl", ci2.ia);
        if (ci2.ib) {
            hashMap.put("simulator", 1);
        }
        hashMap.put("ma", cf.j(ci2.ic));
        hashMap.put("sp", cf.j(ci2.id));
        hashMap.put("hl", ci2.ie);
        hashMap.put("muv", ci2.ig);
        if (ci2.ih != -2) {
            hashMap.put("cnt", ci2.ih);
        }
        hashMap.put("gnt", ci2.ii);
        hashMap.put("pt", ci2.ij);
        hashMap.put("rm", ci2.ik);
        hashMap.put("riv", ci2.il);
        hashMap.put("u_sd", ci2.im);
        hashMap.put("sh", ci2.io);
        hashMap.put("sw", ci2.in);
    }

    private static void a(HashMap<String, Object> hashMap, v v2) {
        if (v2.ex != -1L) {
            hashMap.put("cust_age", hH.format(new Date(v2.ex)));
        }
        if (v2.extras != null) {
            hashMap.put("extras", v2.extras);
        }
        if (v2.ey != -1) {
            hashMap.put("cust_gender", v2.ey);
        }
        if (v2.ez != null) {
            hashMap.put("kw", v2.ez);
        }
        if (v2.tagForChildDirectedTreatment != -1) {
            hashMap.put("tag_for_child_directed_treatment", v2.tagForChildDirectedTreatment);
        }
        if (v2.eA) {
            hashMap.put("adtest", "on");
        }
        if (v2.versionCode < 2) return;
        if (v2.eB) {
            hashMap.put("d_imp_hdr", 1);
        }
        if (!TextUtils.isEmpty((CharSequence)v2.eC)) {
            hashMap.put("ppid", v2.eC);
        }
        if (v2.eD == null) return;
        cf.a(hashMap, v2.eD);
    }

    private static Integer j(boolean bl2) {
        int n2;
        if (bl2) {
            n2 = 1;
            return n2;
        }
        n2 = 0;
        return n2;
    }

    private static String m(int n2) {
        return String.format(Locale.US, "#%06x", 0xFFFFFF & n2);
    }
}

