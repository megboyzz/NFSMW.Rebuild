/*
 * Decompiled with CFR 0.152.
 */
package com.eamobile.licensing;

import com.android.vending.licensing.aq;
import com.android.vending.licensing.ar;
import com.eamobile.licensing.LicenseServerActivity;
import com.eamobile.licensing.h;
import java.security.SecureRandom;

class q
implements aq {
    int a = 0;
    final /* synthetic */ LicenseServerActivity b;

    private q(LicenseServerActivity licenseServerActivity) {
        this.b = licenseServerActivity;
    }

    /* synthetic */ q(LicenseServerActivity licenseServerActivity, h h2) {
        this(licenseServerActivity);
    }

    @Override
    public void a() {
    }

    @Override
    public void a(ar ar2) {
        this.a = 0;
        LicenseServerActivity.c((LicenseServerActivity)this.b).a = 19;
        int n2 = ar2.ordinal();
        int n3 = Math.abs(new SecureRandom().nextInt());
        LicenseServerActivity.getInstance().j = Integer.toString(n3 % 1000 + 1000) + Integer.toString(n2);
        this.b.g.sendEmptyMessage(1);
    }

    @Override
    public void b() {
    }

    @Override
    public void c() {
        this.a = 1;
        LicenseServerActivity licenseServerActivity = LicenseServerActivity.getInstance();
        if (LicenseServerActivity.d(licenseServerActivity) != LicenseServerActivity.b(licenseServerActivity)) return;
        this.b.g.sendEmptyMessage(1);
    }

    @Override
    public void d() {
        this.a = 0;
        this.b.g.sendEmptyMessage(1);
    }

    public void e() {
        LicenseServerActivity.getInstance().f.post((Runnable)this.b.x.get(this.a));
    }
}

