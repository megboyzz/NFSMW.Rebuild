/*
 * Decompiled with CFR 0.152.
 */
package com.eamobile.licensing;

import com.android.vending.licensing.aw;
import com.android.vending.licensing.c;
import com.android.vending.licensing.w;
import com.eamobile.licensing.LicenseServerActivity;
import com.eamobile.licensing.p;

class u
implements Runnable {
    final /* synthetic */ LicenseServerActivity a;

    u(LicenseServerActivity licenseServerActivity) {
        this.a = licenseServerActivity;
    }

    @Override
    public void run() {
        LicenseServerActivity licenseServerActivity = LicenseServerActivity.getInstance();
        licenseServerActivity.c = new aw(LicenseServerActivity.e(licenseServerActivity), new c(licenseServerActivity.d, licenseServerActivity.e, LicenseServerActivity.b(licenseServerActivity)), LicenseServerActivity.b(licenseServerActivity), LicenseServerActivity.c(licenseServerActivity));
        LicenseServerActivity.a(licenseServerActivity, new w(LicenseServerActivity.e(licenseServerActivity), licenseServerActivity.c, LicenseServerActivity.f(licenseServerActivity), LicenseServerActivity.b(licenseServerActivity)));
        licenseServerActivity.f.post((Runnable)new p(this.a));
    }
}

