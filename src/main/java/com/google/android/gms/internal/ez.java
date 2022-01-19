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

public final class ez {
    public static final Intent c(Intent intent) {
        intent.setData(Uri.fromParts((String)"version", (String)Integer.toString(4132500), null));
        return intent;
    }
}

