/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Message
 */
package com.eamobile.licensing;

import android.os.Handler;
import android.os.Message;
import com.eamobile.licensing.LicenseServerActivity;

final class i
extends Handler {
    final /* synthetic */ LicenseServerActivity a;

    i(LicenseServerActivity licenseServerActivity) {
        this.a = licenseServerActivity;
    }

    public void handleMessage(Message message) {
        try {
            this.a.b.e();
            return;
        }
        catch (Exception exception) {
            return;
        }
    }
}

