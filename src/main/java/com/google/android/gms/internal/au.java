/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.internal;

import com.google.android.gms.internal.at;
import com.google.android.gms.internal.az;
import com.google.android.gms.internal.cs;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class au {
    public final List<at> fI;
    public final long fJ;
    public final List<String> fK;
    public final List<String> fL;
    public final List<String> fM;
    public final String fN;
    public final long fO;

    public au(String string2) throws JSONException {
        string2 = new JSONObject(string2);
        if (cs.n(2)) {
            cs.u("Mediation Response JSON: " + string2.toString(2));
        }
        JSONArray jSONArray = string2.getJSONArray("ad_networks");
        ArrayList<at> arrayList = new ArrayList<at>(jSONArray.length());
        for (int i2 = 0; i2 < jSONArray.length(); ++i2) {
            arrayList.add(new at(jSONArray.getJSONObject(i2)));
        }
        this.fI = Collections.unmodifiableList(arrayList);
        this.fN = string2.getString("qdata");
        if ((string2 = string2.optJSONObject("settings")) == null) {
            this.fJ = -1L;
            this.fK = null;
            this.fL = null;
            this.fM = null;
            this.fO = -1L;
            return;
        }
        this.fJ = string2.optLong("ad_network_timeout_millis", -1L);
        this.fK = az.a((JSONObject)string2, "click_urls");
        this.fL = az.a((JSONObject)string2, "imp_urls");
        this.fM = az.a((JSONObject)string2, "nofill_urls");
        long l2 = string2.optLong("refresh", -1L);
        l2 = l2 > 0L ? (l2 *= 1000L) : -1L;
        this.fO = l2;
    }
}

