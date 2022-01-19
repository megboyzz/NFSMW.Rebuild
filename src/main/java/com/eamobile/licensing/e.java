/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 */
package com.eamobile.licensing;

import android.content.DialogInterface;
import com.eamobile.licensing.LicenseServerActivity;
import com.eamobile.licensing.d;

final class e
implements DialogInterface.OnClickListener {
    final /* synthetic */ d a;

    e(d d2) {
        this.a = d2;
    }

    public void onClick(DialogInterface dialogInterface, int n2) {
        try {
            LicenseServerActivity.getInstance().a();
            return;
        }
        catch (Throwable throwable) {
            return;
        }
    }
}

