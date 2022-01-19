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
import com.google.android.gms.internal.ai;
import com.google.android.gms.internal.bz;
import com.google.android.gms.internal.cb;
import com.google.android.gms.internal.ce;
import com.google.android.gms.internal.ci;
import com.google.android.gms.internal.cn;
import com.google.android.gms.internal.cs;
import com.google.android.gms.internal.v;
import com.google.android.gms.internal.x;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class cf {
    private static final SimpleDateFormat hH = new SimpleDateFormat("yyyyMMdd");

    /*
     * Enabled unnecessary exception pruning
     */
    public static cb a(Context object, bz object2, String string2) {
        try {
            int n2;
            JSONObject jSONObject = new JSONObject(string2);
            string2 = jSONObject.optString("ad_base_url", null);
            Object object3 = jSONObject.optString("ad_url", null);
            String string3 = jSONObject.optString("ad_size", null);
            String string4 = jSONObject.optString("ad_html", null);
            long l2 = jSONObject.has("interstitial_timeout") ? (long)(jSONObject.getDouble("interstitial_timeout") * 1000.0) : -1L;
            Object object4 = jSONObject.optString("orientation", null);
            int n3 = -1;
            if ("portrait".equals(object4)) {
                n3 = cn.au();
            } else if ("landscape".equals(object4)) {
                n3 = cn.at();
            }
            if (TextUtils.isEmpty((CharSequence)string4)) {
                if (TextUtils.isEmpty((CharSequence)object3)) {
                    cs.v("Could not parse the mediation config: Missing required ad_html or ad_url field.");
                    return new cb(0);
                }
                object3 = ce.a((Context)object, ((bz)object2).ej.iF, (String)object3);
                string2 = ((cb)object3).gK;
                string4 = ((cb)object3).hu;
            } else {
                if (TextUtils.isEmpty((CharSequence)string2)) {
                    cs.v("Could not parse the mediation config: Missing required ad_base_url field");
                    return new cb(0);
                }
                object3 = null;
            }
            object4 = jSONObject.optJSONArray("click_urls");
            object = object3 == null ? null : ((cb)object3).fK;
            if (object4 == null) {
                object4 = object;
            } else {
                object2 = object;
                if (object == null) {
                    object2 = new LinkedList();
                }
                for (n2 = 0; n2 < object4.length(); ++n2) {
                    object2.add(object4.getString(n2));
                }
                object4 = object2;
            }
            Object object5 = jSONObject.optJSONArray("impression_urls");
            object = object3 == null ? null : ((cb)object3).fL;
            if (object5 == null) {
                object5 = object;
            } else {
                object2 = object;
                if (object == null) {
                    object2 = new LinkedList();
                }
                for (n2 = 0; n2 < object5.length(); ++n2) {
                    object2.add(object5.getString(n2));
                }
                object5 = object2;
            }
            jSONObject = jSONObject.optJSONArray("manual_impression_urls");
            object = object3 == null ? null : ((cb)object3).hy;
            if (jSONObject != null) {
                object2 = object;
                if (object == null) {
                    object2 = new LinkedList();
                }
                for (n2 = 0; n2 < jSONObject.length(); ++n2) {
                    object2.add(jSONObject.getString(n2));
                }
                object = object2;
            }
            long l3 = l2;
            n2 = n3;
            if (object3 == null) return new cb(string2, string4, (List<String>)object4, (List<String>)object5, l3, false, -1L, (List<String>)object, -1L, n2, string3);
            if (((cb)object3).orientation != -1) {
                n3 = ((cb)object3).orientation;
            }
            l3 = l2;
            n2 = n3;
            if (((cb)object3).hv <= 0L) return new cb(string2, string4, (List<String>)object4, (List<String>)object5, l3, false, -1L, (List<String>)object, -1L, n2, string3);
            l3 = ((cb)object3).hv;
            n2 = n3;
            return new cb(string2, string4, (List<String>)object4, (List<String>)object5, l3, false, -1L, (List<String>)object, -1L, n2, string3);
        }
        catch (JSONException jSONException) {
            cs.v("Could not parse the mediation config: " + jSONException.getMessage());
            return new cb(0);
        }
    }

    /*
     * WARNING - combined exceptions agressively - possible behaviour change.
     * Enabled unnecessary exception pruning
     */
    public static String a(bz object, ci ci2, Location object2) {
        try {
            object2 = new HashMap();
            if (((bz)object).ho != null) {
                ((HashMap)object2).put("ad_pos", ((bz)object).ho);
            }
            cf.a((HashMap<String, Object>)object2, ((bz)object).hp);
            ((HashMap)object2).put("format", ((bz)object).em.eF);
            if (((bz)object).em.width == -1) {
                ((HashMap)object2).put("smart_w", "full");
            }
            if (((bz)object).em.height == -2) {
                ((HashMap)object2).put("smart_h", "auto");
            }
            if (((bz)object).em.eH != null) {
                StringBuilder stringBuilder = new StringBuilder();
                for (x x2 : ((bz)object).em.eH) {
                    if (stringBuilder.length() != 0) {
                        stringBuilder.append("|");
                    }
                    int n2 = x2.width == -1 ? (int)((float)x2.widthPixels / ci2.im) : x2.width;
                    stringBuilder.append(n2);
                    stringBuilder.append("x");
                    n2 = x2.height == -2 ? (int)((float)x2.heightPixels / ci2.im) : x2.height;
                    stringBuilder.append(n2);
                }
                ((HashMap)object2).put("sz", stringBuilder);
            }
            ((HashMap)object2).put("slotname", ((bz)object).adUnitId);
            ((HashMap)object2).put("pn", ((bz)object).applicationInfo.packageName);
            if (((bz)object).hq != null) {
                ((HashMap)object2).put("vc", ((bz)object).hq.versionCode);
            }
            ((HashMap)object2).put("ms", ((bz)object).hr);
            ((HashMap)object2).put("seq_num", ((bz)object).hs);
            ((HashMap)object2).put("session_id", ((bz)object).ht);
            ((HashMap)object2).put("js", ((bz)object).ej.iF);
            cf.a((HashMap<String, Object>)object2, ci2);
            if (((bz)object).hp.versionCode >= 2 && ((bz)object).hp.eE != null) {
                cf.a((HashMap<String, Object>)object2, ((bz)object).hp.eE);
            }
            if (!cs.n(2)) return cn.m(object2).toString();
            object = cn.m(object2).toString(2);
            cs.u("Ad Request JSON: " + (String)object);
            return cn.m(object2).toString();
        }
        catch (JSONException jSONException) {
            cs.v("Problem serializing ad request to JSON: " + jSONException.getMessage());
            return null;
        }
    }

    private static void a(HashMap<String, Object> hashMap, Location location) {
        HashMap<String, Number> hashMap2 = new HashMap<String, Number>();
        float f2 = location.getAccuracy();
        long l2 = location.getTime();
        long l3 = (long)(location.getLatitude() * 1.0E7);
        long l4 = (long)(location.getLongitude() * 1.0E7);
        hashMap2.put("radius", Float.valueOf(f2 * 1000.0f));
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
                string2 = var3_2;
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
        if (!TextUtils.isEmpty((CharSequence)ci2.if)) {
            hashMap.put("mv", ci2.if);
        }
        hashMap.put("muv", ci2.ig);
        if (ci2.ih != -2) {
            hashMap.put("cnt", ci2.ih);
        }
        hashMap.put("gnt", ci2.ii);
        hashMap.put("pt", ci2.ij);
        hashMap.put("rm", ci2.ik);
        hashMap.put("riv", ci2.il);
        hashMap.put("u_sd", Float.valueOf(ci2.im));
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

