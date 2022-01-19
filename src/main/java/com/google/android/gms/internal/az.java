/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.cj;
import com.google.android.gms.internal.ck;
import com.google.android.gms.internal.cq;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class az {
    public static List<String> a(JSONObject jSONObject, String object) throws JSONException {
        if ((jSONObject = jSONObject.optJSONArray((String)object)) == null) return null;
        object = new ArrayList(jSONObject.length());
        int n2 = 0;
        while (n2 < jSONObject.length()) {
            object.add(jSONObject.getString(n2));
            ++n2;
        }
        return Collections.unmodifiableList(object);
    }

    public static void a(Context context, String string2, cj cj2, String string3, boolean bl2, List<String> object) {
        String string4 = bl2 ? "1" : "0";
        Iterator<String> iterator = object.iterator();
        while (iterator.hasNext()) {
            String string5 = iterator.next().replaceAll("@gw_adlocid@", string3).replaceAll("@gw_adnetrefresh@", string4).replaceAll("@gw_qdata@", cj2.ip.fN).replaceAll("@gw_sdkver@", string2).replaceAll("@gw_sessid@", ck.ir).replaceAll("@gw_seqnum@", cj2.hs);
            object = string5;
            if (cj2.ga != null) {
                object = string5.replaceAll("@gw_adnetid@", cj2.ga.fD).replaceAll("@gw_allocid@", cj2.ga.fF);
            }
            new cq(context, string2, (String)object).start();
        }
    }
}

