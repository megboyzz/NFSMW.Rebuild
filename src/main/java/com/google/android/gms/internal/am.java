/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.net.Uri
 */
package com.google.android.gms.internal;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.google.android.gms.internal.an;
import com.google.android.gms.internal.ao;
import com.google.android.gms.internal.ap;
import com.google.android.gms.internal.bk;
import com.google.android.gms.internal.cq;
import com.google.android.gms.internal.cs;
import com.google.android.gms.internal.cv;
import com.google.android.gms.internal.h;
import com.google.android.gms.internal.i;
import java.util.HashMap;
import java.util.Map;

public final class am {
    public static final an fn = new an(){

        @Override
        public void a(cv cv2, Map<String, String> object) {
            if ((object = object.get("urls")) == null) {
                cs.v("URLs missing in canOpenURLs GMSG.");
                return;
            }
            String[] stringArray = object.split(",");
            HashMap<String, Boolean> hashMap = new HashMap<String, Boolean>();
            PackageManager packageManager = cv2.getContext().getPackageManager();
            int n2 = stringArray.length;
            int n3 = 0;
            while (true) {
                if (n3 >= n2) {
                    cv2.a("openableURLs", hashMap);
                    return;
                }
                String string2 = stringArray[n3];
                object = string2.split(";", 2);
                String string3 = object[0].trim();
                object = ((String[])object).length > 1 ? object[1].trim() : "android.intent.action.VIEW";
                boolean bl2 = packageManager.resolveActivity(new Intent((String)object, Uri.parse((String)string3)), 65536) != null;
                hashMap.put(string2, bl2);
                ++n3;
            }
        }
    };
    public static final an fo = new an(){

        @Override
        public void a(cv cv2, Map<String, String> object) {
            String string2 = object.get("u");
            if (string2 == null) {
                cs.v("URL missing from click GMSG.");
                return;
            }
            object = Uri.parse((String)string2);
            try {
                h h2 = cv2.aC();
                if (h2 != null && h2.a((Uri)object)) {
                    h2 = h2.a((Uri)object, cv2.getContext());
                    object = h2;
                }
            }
            catch (i i2) {
                cs.v("Unable to append parameter to URL: " + string2);
            }
            object = object.toString();
            new cq(cv2.getContext(), cv2.aD().iF, (String)object).start();
        }
    };
    public static final an fp = new an(){

        @Override
        public void a(cv object, Map<String, String> map) {
            if ((object = ((cv)((Object)object)).aA()) == null) {
                cs.v("A GMSG tried to close something that wasn't an overlay.");
                return;
            }
            ((bk)object).close();
        }
    };
    public static final an fq = new an(){

        @Override
        public void a(cv object, Map<String, String> map) {
            if ((object = ((cv)((Object)object)).aA()) == null) {
                cs.v("A GMSG tried to use a custom close button on something that wasn't an overlay.");
                return;
            }
            ((bk)object).g("1".equals(map.get("custom_close")));
        }
    };
    public static final an fr = new an(){

        @Override
        public void a(cv cv2, Map<String, String> object) {
            if ((object = object.get("u")) == null) {
                cs.v("URL missing from httpTrack GMSG.");
                return;
            }
            new cq(cv2.getContext(), cv2.aD().iF, (String)object).start();
        }
    };
    public static final an fs = new an(){

        @Override
        public void a(cv cv2, Map<String, String> map) {
            cs.t("Received log message: " + map.get("string"));
        }
    };
    public static final an ft = new ao();
    public static final an fu = new an(){

        @Override
        public void a(cv object, Map<String, String> object2) {
            String string2 = object2.get("tx");
            String string3 = object2.get("ty");
            object2 = object2.get("td");
            try {
                int n2 = Integer.parseInt(string2);
                int n3 = Integer.parseInt(string3);
                int n4 = Integer.parseInt((String)object2);
                object = ((cv)((Object)object)).aC();
                if (object == null) return;
                ((h)object).g().a(n2, n3, n4);
                return;
            }
            catch (NumberFormatException numberFormatException) {
                cs.v("Could not parse touch parameters from gmsg.");
                return;
            }
        }
    };
    public static final an fv = new ap();
}

