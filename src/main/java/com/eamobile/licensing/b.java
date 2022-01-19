/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.Button
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 */
package com.eamobile.licensing;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import com.eamobile.licensing.c;
import com.eamobile.licensing.f;
import java.io.IOException;
import java.io.InputStream;

public class b
extends LinearLayout
implements f {
    protected static final float d = 16.0f;
    protected Context b;
    Bitmap c = null;

    public b(Context context) {
        super(context);
        this.b = context;
        try {
            this.c = Bitmap.createBitmap((Bitmap)BitmapFactory.decodeStream((InputStream)context.getAssets().open("licenseserver/title.png")));
            return;
        }
        catch (IOException iOException) {
            this.c = null;
            return;
        }
    }

    public static Button a(Context context, LinearLayout linearLayout, String string2) {
        context = new Button(context);
        context.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2, 1.0f));
        context.setPadding(15, 15, 15, 15);
        context.setTextSize(16.0f);
        context.setText((CharSequence)string2);
        linearLayout.addView((View)context);
        return context;
    }

    @Override
    public void a() {
        this.c();
    }

    @Override
    public void b() {
    }

    protected void c() {
        this.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
        this.setOrientation(1);
        this.setGravity(48);
        this.setBackgroundDrawable(new c(this));
    }
}

