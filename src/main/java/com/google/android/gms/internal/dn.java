/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.net.Uri
 */
package com.google.android.gms.internal;

import android.content.Intent;
import android.net.Uri;

public class dn {
    private static final Uri ne = Uri.parse((String)"http://plus.google.com/");
    private static final Uri nf = ne.buildUpon().appendPath("circles").appendPath("find").build();

    public static Intent E(String string2) {
        string2 = Uri.fromParts((String)"package", (String)string2, null);
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData((Uri)string2);
        return intent;
    }

    private static Uri F(String string2) {
        return Uri.parse((String)"market://details").buildUpon().appendQueryParameter("id", string2).build();
    }

    public static Intent G(String string2) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(dn.F(string2));
        intent.setPackage("com.android.vending");
        intent.addFlags(524288);
        return intent;
    }

    public static Intent H(String string2) {
        string2 = Uri.parse((String)("bazaar://search?q=pname:" + string2));
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData((Uri)string2);
        intent.setFlags(524288);
        return intent;
    }

    public static Intent bK() {
        return new Intent("android.settings.DATE_SETTINGS");
    }
}

