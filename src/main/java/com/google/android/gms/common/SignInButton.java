/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.Button
 *  android.widget.FrameLayout
 */
package com.google.android.gms.common;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.internal.du;
import com.google.android.gms.internal.dv;
import com.google.android.gms.internal.dw;

public final class SignInButton
extends FrameLayout
implements View.OnClickListener {
    public static final int COLOR_DARK = 0;
    public static final int COLOR_LIGHT = 1;
    public static final int SIZE_ICON_ONLY = 2;
    public static final int SIZE_STANDARD = 0;
    public static final int SIZE_WIDE = 1;
    private int kn;
    private View ko;
    private View.OnClickListener kp = null;
    private int mSize;

    public SignInButton(Context context) {
        this(context, null);
    }

    public SignInButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SignInButton(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.setStyle(0, 0);
    }

    private static Button c(Context context, int n2, int n3) {
        dw dw2 = new dw(context);
        dw2.a(context.getResources(), n2, n3);
        return dw2;
    }

    private void p(Context context) {
        if (this.ko != null) {
            this.removeView(this.ko);
        }
        try {
            this.ko = dv.d(context, this.mSize, this.kn);
        }
        catch (e.a a2) {
            Log.w((String)"SignInButton", (String)"Sign in button not found, using placeholder instead");
            this.ko = SignInButton.c(context, this.mSize, this.kn);
        }
        this.addView(this.ko);
        this.ko.setEnabled(this.isEnabled());
        this.ko.setOnClickListener((View.OnClickListener)this);
    }

    public void onClick(View view) {
        if (this.kp == null) return;
        if (view != this.ko) return;
        this.kp.onClick((View)this);
    }

    public void setColorScheme(int n2) {
        this.setStyle(this.mSize, n2);
    }

    public void setEnabled(boolean bl2) {
        super.setEnabled(bl2);
        this.ko.setEnabled(bl2);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.kp = onClickListener;
        if (this.ko == null) return;
        this.ko.setOnClickListener((View.OnClickListener)this);
    }

    public void setSize(int n2) {
        this.setStyle(n2, this.kn);
    }

    public void setStyle(int n2, int n3) {
        boolean bl2 = true;
        boolean bl3 = n2 >= 0 && n2 < 3;
        du.a(bl3, "Unknown button size " + n2);
        bl3 = n3 >= 0 && n3 < 2 ? bl2 : false;
        du.a(bl3, "Unknown color scheme " + n3);
        this.mSize = n2;
        this.kn = n3;
        this.p(this.getContext());
    }
}

