/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.net.Uri
 *  android.widget.ImageView
 */
package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.net.Uri;
import android.widget.ImageView;

public final class df
extends ImageView {
    private Uri mq;
    private int mr;
    private int ms;

    public int bs() {
        return this.mr;
    }

    public void d(Uri uri) {
        this.mq = uri;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.ms == 0) return;
        canvas.drawColor(this.ms);
    }

    public void x(int n2) {
        this.mr = n2;
    }
}

