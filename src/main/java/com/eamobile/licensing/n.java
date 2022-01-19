/*
 * Decompiled with CFR 0.152.
 */
package com.eamobile.licensing;

import com.eamobile.licensing.LicenseServerActivity;

class n
implements Runnable {
    int a = 0;
    final /* synthetic */ LicenseServerActivity b;

    n(LicenseServerActivity licenseServerActivity) {
        this.b = licenseServerActivity;
    }

    @Override
    public void run() {
        LicenseServerActivity.a(this.b).sendEmptyMessage(1);
    }
}

