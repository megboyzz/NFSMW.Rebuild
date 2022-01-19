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

final class h
extends Handler {
    final /* synthetic */ LicenseServerActivity a;

    h(LicenseServerActivity licenseServerActivity) {
        this.a = licenseServerActivity;
    }

    public void handleMessage(Message message) {
        try {
            this.a.a(LicenseServerActivity.c((LicenseServerActivity)this.a).a);
            return;
        }
        catch (Exception exception) {
            return;
        }
    }
}

