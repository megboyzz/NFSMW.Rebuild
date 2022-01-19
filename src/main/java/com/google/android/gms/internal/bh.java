/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ActivityNotFoundException
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.text.TextUtils
 */
package com.google.android.gms.internal;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.internal.bj;
import com.google.android.gms.internal.bq;
import com.google.android.gms.internal.cs;

public final class bh {
    public static boolean a(Context context, bj bj2, bq bq2) {
        if (bj2 == null) {
            cs.v("No intent data for launcher overlay.");
            return false;
        }
        Intent intent = new Intent();
        if (TextUtils.isEmpty((CharSequence)bj2.gn)) {
            cs.v("Open GMSG did not contain a URL.");
            return false;
        }
        if (!TextUtils.isEmpty((CharSequence)bj2.mimeType)) {
            intent.setDataAndType(Uri.parse((String)bj2.gn), bj2.mimeType);
        } else {
            intent.setData(Uri.parse((String)bj2.gn));
        }
        intent.setAction("android.intent.action.VIEW");
        if (!TextUtils.isEmpty((CharSequence)bj2.packageName)) {
            intent.setPackage(bj2.packageName);
        }
        if (!TextUtils.isEmpty((CharSequence)bj2.go)) {
            String[] stringArray = bj2.go.split("/", 2);
            if (stringArray.length < 2) {
                cs.v("Could not parse component name from open GMSG: " + bj2.go);
                return false;
            }
            intent.setClassName(stringArray[0], stringArray[1]);
        }
        try {
            cs.u("Launching an intent: " + intent);
            context.startActivity(intent);
            bq2.z();
            return true;
        }
        catch (ActivityNotFoundException activityNotFoundException) {
            cs.v(activityNotFoundException.getMessage());
            return false;
        }
    }
}

