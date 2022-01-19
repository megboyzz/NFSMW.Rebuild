/*
 * Decompiled with CFR 0.152.
 */
package com.eamobile.licensing;

import com.eamobile.licensing.LicenseServerActivity;

class l
implements Runnable {
    final /* synthetic */ LicenseServerActivity a;

    l(LicenseServerActivity licenseServerActivity) {
        this.a = licenseServerActivity;
    }

    @Override
    public void run() {
        LicenseServerActivity licenseServerActivity = LicenseServerActivity.getInstance();
        if (licenseServerActivity.w == null) return;
        licenseServerActivity.i.sendEmptyMessage(1);
    }
}

