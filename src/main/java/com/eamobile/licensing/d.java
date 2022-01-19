/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.AlertDialog$Builder
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface$OnClickListener
 *  android.view.View
 */
package com.eamobile.licensing;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import com.eamobile.licensing.LicenseServerActivity;
import com.eamobile.licensing.b;
import com.eamobile.licensing.e;
import com.eamobile.licensing.g;

public class d
extends b {
    Dialog a;

    public d(Context context) {
        super(context);
        this.b = context;
    }

    private void a(View object) {
        String string2 = g.a(1);
        LicenseServerActivity licenseServerActivity = LicenseServerActivity.getInstance();
        object = string2;
        if (licenseServerActivity.j != null) {
            object = string2 + "  " + licenseServerActivity.j;
        }
        string2 = new AlertDialog.Builder(this.b);
        string2.setMessage((CharSequence)object).setCancelable(false).setPositiveButton((CharSequence)g.a(0), (DialogInterface.OnClickListener)new e(this));
        this.a = string2.create();
        this.a.show();
    }

    @Override
    public void a() {
        super.a();
        this.a((View)this);
    }

    @Override
    public void b() {
        super.b();
        try {
            this.a.dismiss();
            return;
        }
        catch (Exception exception) {
            return;
        }
    }
}

