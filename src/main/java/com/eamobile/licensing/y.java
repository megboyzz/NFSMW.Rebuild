/*
 * Decompiled with CFR 0.152.
 */
package com.eamobile.licensing;

import com.android.vending.licensing.am;
import com.android.vending.licensing.ba;
import com.android.vending.licensing.g;
import com.eamobile.licensing.LicenseServerActivity;
import com.eamobile.licensing.p;

class y
implements Runnable {
    final /* synthetic */ LicenseServerActivity a;

    y(LicenseServerActivity licenseServerActivity) {
        this.a = licenseServerActivity;
    }

    @Override
    public void run() {
        LicenseServerActivity licenseServerActivity = LicenseServerActivity.getInstance();
        licenseServerActivity.c = new ba(LicenseServerActivity.e(licenseServerActivity), new g(licenseServerActivity.d, licenseServerActivity.e, LicenseServerActivity.b(licenseServerActivity)), LicenseServerActivity.b(licenseServerActivity), LicenseServerActivity.c(licenseServerActivity));
        LicenseServerActivity.a(licenseServerActivity, new am(LicenseServerActivity.e(licenseServerActivity), licenseServerActivity.c, LicenseServerActivity.f(licenseServerActivity), LicenseServerActivity.b(licenseServerActivity)));
        licenseServerActivity.f.post((Runnable)new p(this.a));
    }
}

