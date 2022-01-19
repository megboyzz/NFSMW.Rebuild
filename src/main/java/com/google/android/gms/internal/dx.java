/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources$NotFoundException
 *  android.util.Log
 */
package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;

public class dx {
    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static String a(String var0, String var1_1, Context var2_2, AttributeSet var3_4, boolean var4_5, boolean var5_6, String var6_7) {
        block3: {
            var0 /* !! */  = var3_4 == null ? null : var3_4.getAttributeValue(var0 /* !! */ , var1_1);
            var3_4 = var0 /* !! */ ;
            if (var0 /* !! */  == null) break block3;
            var3_4 = var0 /* !! */ ;
            if (!var0 /* !! */ .startsWith("@string/")) break block3;
            var3_4 = var0 /* !! */ ;
            if (!var4_5) break block3;
            var7_8 = var0 /* !! */ .substring("@string/".length());
            var8_9 = var2_2.getPackageName();
            var3_4 = new TypedValue();
            try {
                var2_2.getResources().getValue(var8_9 + ":string/" + var7_8, (TypedValue)var3_4, true);
lbl13:
                // 2 sources

                while (var3_4.string != null) {
                    var3_4 = var3_4.string.toString();
                    break block3;
                }
            }
            catch (Resources.NotFoundException var2_3) {
                Log.w((String)var6_7, (String)("Could not find resource for " + var1_1 + ": " + var0 /* !! */ ));
                ** GOTO lbl13
            }
            Log.w((String)var6_7, (String)("Resource " + var1_1 + " was not a string: " + var3_4));
            var3_4 = var0 /* !! */ ;
        }
        if (var5_6 == false) return var3_4;
        if (var3_4 != null) return var3_4;
        Log.w((String)var6_7, (String)("Required XML attribute \"" + var1_1 + "\" missing"));
        return var3_4;
    }
}

