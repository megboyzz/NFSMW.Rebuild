/*
 * Decompiled with CFR 0.152.
 */
package com.eamobile.licensing;

import com.android.vending.licensing.av;
import com.android.vending.licensing.b;
import com.android.vending.licensing.s;
import com.eamobile.licensing.LicenseServerActivity;
import com.eamobile.licensing.p;

class t
implements Runnable {
    final /* synthetic */ LicenseServerActivity a;

    t(LicenseServerActivity licenseServerActivity) {
        this.a = licenseServerActivity;
    }

    @Override
    public void run() {
        LicenseServerActivity licenseServerActivity = LicenseServerActivity.getInstance();
        licenseServerActivity.c = new av(LicenseServerActivity.e(licenseServerActivity), new b(licenseServerActivity.d, licenseServerActivity.e, LicenseServerActivity.b(licenseServerActivity)), LicenseServerActivity.b(licenseServerActivity), LicenseServerActivity.c(licenseServerActivity));
        LicenseServerActivity.a(licenseServerActivity, new s(LicenseServerActivity.e(licenseServerActivity), licenseServerActivity.c, LicenseServerActivity.f(licenseServerActivity), LicenseServerActivity.b(licenseServerActivity)));
        licenseServerActivity.f.post((Runnable)new p(this.a));
    }
}

