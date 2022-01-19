/*
 * Decompiled with CFR 0.152.
 */
package com.eamobile.licensing;

import com.eamobile.licensing.LicenseServerActivity;
import com.eamobile.licensing.s;
import com.eamobile.licensing.t;
import com.eamobile.licensing.u;
import com.eamobile.licensing.v;
import com.eamobile.licensing.w;
import com.eamobile.licensing.x;
import com.eamobile.licensing.y;

class o
implements Runnable {
    final /* synthetic */ LicenseServerActivity a;

    o(LicenseServerActivity licenseServerActivity) {
        this.a = licenseServerActivity;
    }

    @Override
    public void run() {
        LicenseServerActivity licenseServerActivity = LicenseServerActivity.getInstance();
        switch (LicenseServerActivity.b(licenseServerActivity).hashCode() % 7) {
            default: {
                licenseServerActivity.f.post((Runnable)new s(this.a));
                return;
            }
            case 0: {
                licenseServerActivity.f.post((Runnable)new s(this.a));
                return;
            }
            case 1: {
                licenseServerActivity.f.post((Runnable)new t(this.a));
                return;
            }
            case 2: {
                licenseServerActivity.f.post((Runnable)new u(this.a));
                return;
            }
            case 3: {
                licenseServerActivity.f.post((Runnable)new v(this.a));
                return;
            }
            case 4: {
                licenseServerActivity.f.post((Runnable)new w(this.a));
                return;
            }
            case 5: {
                licenseServerActivity.f.post((Runnable)new x(this.a));
                return;
            }
            case 6: 
        }
        licenseServerActivity.f.post((Runnable)new y(this.a));
    }
}

