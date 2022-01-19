/*
 * Decompiled with CFR 0.152.
 */
package com.eamobile.licensing;

import com.android.vending.licensing.ai;
import com.android.vending.licensing.az;
import com.android.vending.licensing.f;
import com.eamobile.licensing.LicenseServerActivity;
import com.eamobile.licensing.p;

class x
implements Runnable {
    final /* synthetic */ LicenseServerActivity a;

    x(LicenseServerActivity licenseServerActivity) {
        this.a = licenseServerActivity;
    }

    @Override
    public void run() {
        LicenseServerActivity licenseServerActivity = LicenseServerActivity.getInstance();
        licenseServerActivity.c = new az(LicenseServerActivity.e(licenseServerActivity), new f(licenseServerActivity.d, licenseServerActivity.e, LicenseServerActivity.b(licenseServerActivity)), LicenseServerActivity.b(licenseServerActivity), LicenseServerActivity.c(licenseServerActivity));
        LicenseServerActivity.a(licenseServerActivity, new ai(LicenseServerActivity.e(licenseServerActivity), licenseServerActivity.c, LicenseServerActivity.f(licenseServerActivity), LicenseServerActivity.b(licenseServerActivity)));
        licenseServerActivity.f.post((Runnable)new p(this.a));
    }
}

