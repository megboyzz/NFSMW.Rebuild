/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.ImageButton
 */
package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.google.android.gms.internal.cr;

public final class bp
extends FrameLayout
implements View.OnClickListener {
    private final ImageButton gY;
    private final Activity gr;

    public bp(Activity activity, int n2) {
        super((Context)activity);
        this.gr = activity;
        this.setOnClickListener(this);
        this.gY = new ImageButton((Context)activity);
        this.gY.setImageResource(17301527);
        this.gY.setBackgroundColor(0);
        this.gY.setOnClickListener((View.OnClickListener)this);
        this.gY.setPadding(0, 0, 0, 0);
        n2 = cr.a((Context)activity, n2);
        this.addView((View)this.gY, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(n2, n2, 17));
    }

    public void g(boolean bl2) {
        ImageButton imageButton = this.gY;
        int n2 = bl2 ? 4 : 0;
        imageButton.setVisibility(n2);
    }

    public void onClick(View view) {
        this.gr.finish();
    }
}

