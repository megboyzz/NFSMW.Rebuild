/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.view.View
 */
package com.eamobile.licensing;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import com.eamobile.licensing.b;

public class a
extends b {
    Dialog a;

    public a(Context context) {
        super(context);
        this.b = context;
    }

    private void a(View view) {
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

