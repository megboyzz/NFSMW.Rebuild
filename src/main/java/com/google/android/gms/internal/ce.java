/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.internal.am;
import com.google.android.gms.internal.aq;
import com.google.android.gms.internal.bz;
import com.google.android.gms.internal.cb;
import com.google.android.gms.internal.cd;
import com.google.android.gms.internal.cf;
import com.google.android.gms.internal.cg;
import com.google.android.gms.internal.ch;
import com.google.android.gms.internal.ci;
import com.google.android.gms.internal.cn;
import com.google.android.gms.internal.cr;
import com.google.android.gms.internal.cs;
import com.google.android.gms.internal.cv;
import com.google.android.gms.internal.cw;
import com.google.android.gms.internal.x;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public final class ce
extends cd.a {
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
        if ((object = cf.a(bz2, ci2, object.a(250L))) == null) {
            return new cb(0);
        }
        cr.iE.post(new Runnable((String)object){
            final /* synthetic */ String hG;
            {
                this.hG = string2;
            }

            @Override
            public void run() {
                cv cv2 = cv.a(context, new x(), false, false, null, bz2.ej);
                cv2.setWillNotDraw(true);
                cg2.b(cv2);
                cw cw2 = cv2.aB();
                cw2.a("/invalidRequest", cg2.hJ);
                cw2.a("/loadAdURL", cg2.hK);
                cw2.a("/log", am.fs);
                cs.r("Getting the ad request URL.");
                cv2.loadDataWithBaseURL("http://googleads.g.doubleclick.net", "<!DOCTYPE html><html><head><script src=\"http://googleads.g.doubleclick.net/mads/static/sdk/native/sdk-core-v40.js\"></script><script>AFMA_buildAdURL(" + this.hG + ");</script></head><body></body></html>", "text/html", "UTF-8", null);
            }
        });
        object = cg2.ap();
        if (!TextUtils.isEmpty((CharSequence)object)) return ce.a(context, bz2.ej.iF, (String)object);
        return new cb(cg2.getErrorCode());
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    public static cb a(Context var0, String var1_3, String var2_4) {
        var6_5 = new ch();
        var2_4 = new URL((String)var2_4);
        var3_6 = 0;
lbl5:
        // 2 sources

        while (true) {
            var5_8 = (HttpURLConnection)var2_4.openConnection();
            break;
        }
        {
            block18: {
                block16: {
                    block17: {
                        catch (IOException var0_1) {
                            cs.v("Error while connecting to ad server: " + var0_1.getMessage());
                            return new cb(2);
                        }
                        cn.a(var0 /* !! */ , var1_3, false, var5_8);
                        var4_7 = var5_8.getResponseCode();
                        var7_9 = var5_8.getHeaderFields();
                        if (var4_7 >= 200 && var4_7 < 300) {
                            var0 /* !! */  = var2_4.toString();
                            var1_3 = cn.a(new InputStreamReader(var5_8.getInputStream()));
                            ce.a((String)var0 /* !! */ , var7_9, var1_3, var4_7);
                            var6_5.a((String)var0 /* !! */ , var7_9, var1_3);
                            var0 /* !! */  = var6_5.aq();
                            {
                                var5_8.disconnect();
                                return var0 /* !! */ ;
                            }
                        }
                        ce.a(var2_4.toString(), var7_9, null, var4_7);
                        if (var4_7 < 300 || var4_7 >= 400) break block16;
                        var2_4 = var5_8.getHeaderField("Location");
                        if (!TextUtils.isEmpty((CharSequence)var2_4)) break block17;
                        cs.v("No location header to follow redirect.");
                        var0 /* !! */  = new cb(0);
                        {
                            var5_8.disconnect();
                            return var0 /* !! */ ;
                        }
                    }
                    var2_4 = new URL((String)var2_4);
                    if (++var3_6 <= 5) break block18;
                    cs.v("Too many redirects.");
                    var0 /* !! */  = new cb(0);
                    {
                        var5_8.disconnect();
                        return var0 /* !! */ ;
                    }
                }
                try {
                    cs.v("Received error HTTP response code: " + var4_7);
                    var0 /* !! */  = new cb(0);
                    {
                        var5_8.disconnect();
                        return var0 /* !! */ ;
                    }
                }
                catch (Throwable var0_2) {}
                {
                    var5_8.disconnect();
                    throw var0_2;
                }
            }
            var6_5.d(var7_9);
            {
                var5_8.disconnect();
                ** continue;
            }
        }
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

    @Override
    public cb b(bz bz2) {
        return ce.a(this.mContext, this.hC, bz2);
    }
}

