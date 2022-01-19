/*
 * Decompiled with CFR 0.152.
 */
package com.eamobile.licensing;

import com.android.vending.licensing.ae;
import com.android.vending.licensing.ay;
import com.android.vending.licensing.e;
import com.eamobile.licensing.LicenseServerActivity;
import com.eamobile.licensing.p;

class w
implements Runnable {
    final /* synthetic */ LicenseServerActivity a;

    w(LicenseServerActivity licenseServerActivity) {
        this.a = licenseServerActivity;
    }

    @Override
    public void run() {
        LicenseServerActivity licenseServerActivity = LicenseServerActivity.getInstance();
        licenseServerActivity.c = new ay(LicenseServerActivity.e(licenseServerActivity), new e(licenseServerActivity.d, licenseServerActivity.e, LicenseServerActivity.b(licenseServerActivity)), LicenseServerActivity.b(licenseServerActivity), LicenseServerActivity.c(licenseServerActivity));
        LicenseServerActivity.a(licenseServerActivity, new ae(LicenseServerActivity.e(licenseServerActivity), licenseServerActivity.c, LicenseServerActivity.f(licenseServerActivity), LicenseServerActivity.b(licenseServerActivity)));
        licenseServerActivity.f.post((Runnable)new p(this.a));
    }
}

