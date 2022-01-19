/*
 * Decompiled with CFR 0.152.
 */
package com.eamobile.licensing;

import com.eamobile.licensing.LicenseServerActivity;

class p
implements Runnable {
    final /* synthetic */ LicenseServerActivity a;

    p(LicenseServerActivity licenseServerActivity) {
        this.a = licenseServerActivity;
    }

    @Override
    public void run() {
        LicenseServerActivity licenseServerActivity = LicenseServerActivity.getInstance();
        LicenseServerActivity.g(licenseServerActivity).a(licenseServerActivity.b);
    }
}

