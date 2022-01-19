/*
 * Decompiled with CFR 0.152.
 */
package com.eamobile.licensing;

import com.android.vending.licensing.at;
import com.eamobile.licensing.LicenseServerActivity;
import com.eamobile.licensing.h;

class r
implements at {
    public int a = 21;
    final /* synthetic */ LicenseServerActivity b;

    private r(LicenseServerActivity licenseServerActivity) {
        this.b = licenseServerActivity;
    }

    /* synthetic */ r(LicenseServerActivity licenseServerActivity, h h2) {
        this(licenseServerActivity);
    }

    @Override
    public void a() {
        this.a = 15;
    }

    @Override
    public void b() {
        this.a = 15;
    }

    @Override
    public void c() {
        LicenseServerActivity licenseServerActivity = LicenseServerActivity.getInstance();
        LicenseServerActivity.a(licenseServerActivity, LicenseServerActivity.b(licenseServerActivity));
    }
}

