/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.internal;

import com.google.android.gms.internal.az;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class at {
    public final String adJson;
    public final String fD;
    public final List<String> fE;
    public final String fF;
    public final List<String> fG;
    public final String fH;

    public at(JSONObject object) throws JSONException {
        Object var4_2 = null;
        this.fD = object.getString("id");
        Object object2 = object.getJSONArray("adapters");
        ArrayList<String> arrayList = new ArrayList<String>(object2.length());
        for (int i2 = 0; i2 < object2.length(); ++i2) {
            arrayList.add(object2.getString(i2));
        }
        this.fE = Collections.unmodifiableList(arrayList);
        this.fF = object.optString("allocation_id", null);
        this.fG = az.a(object, "imp_urls");
        object2 = object.optJSONObject("ad");
        object2 = object2 != null ? object2.toString() : null;
        this.adJson = object2;
        object2 = object.optJSONObject("data");
        object = var4_2;
        if (object2 != null) {
            object = object2.toString();
        }
        this.fH = object;
    }
}

