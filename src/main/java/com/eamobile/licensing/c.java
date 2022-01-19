/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.drawable.Drawable
 */
package com.eamobile.licensing;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.eamobile.licensing.b;

class c
extends Drawable {
    final /* synthetic */ b a;

    c(b b2) {
        this.a = b2;
    }

    public void draw(Canvas canvas) {
        if (this.a.c == null) return;
        canvas.drawBitmap(this.a.c, (float)(canvas.getWidth() - this.a.c.getWidth() >> 1), (float)(canvas.getHeight() - this.a.c.getHeight() >> 1), null);
    }

    public int getOpacity() {
        return 0;
    }

    public void setAlpha(int n2) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}

