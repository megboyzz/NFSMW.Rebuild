/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.internal.de;
import com.google.android.gms.internal.df;
import com.google.android.gms.internal.dg;
import com.google.android.gms.internal.ds;
import com.google.android.gms.internal.es;
import java.lang.ref.WeakReference;

public final class a {
    final a lM;
    private int lN = 0;
    private int lO = 0;
    int lP;
    private int lQ;
    private WeakReference<ImageManager.OnImageLoadedListener> lR;
    private WeakReference<ImageView> lS;
    private WeakReference<TextView> lT;
    private int lU = -1;
    private boolean lV = true;
    private boolean lW = false;

    public a(int n2) {
        this.lM = new a(null);
        this.lO = n2;
    }

    public a(Uri uri) {
        this.lM = new a(uri);
        this.lO = 0;
    }

    private de a(Drawable drawable, Drawable drawable2) {
        Drawable drawable3;
        if (drawable != null) {
            drawable3 = drawable;
            if (!(drawable instanceof de)) return new de(drawable3, drawable2);
            drawable3 = ((de)drawable).bq();
            return new de(drawable3, drawable2);
        }
        drawable3 = null;
        return new de(drawable3, drawable2);
    }

    private void a(Drawable drawable, boolean bl2, boolean bl3, boolean bl4) {
        switch (this.lP) {
            case 1: {
                if (bl3) return;
                ImageManager.OnImageLoadedListener onImageLoadedListener = (ImageManager.OnImageLoadedListener)this.lR.get();
                if (onImageLoadedListener == null) return;
                onImageLoadedListener.onImageLoaded(this.lM.uri, drawable, bl4);
                return;
            }
            case 2: {
                ImageView imageView = (ImageView)this.lS.get();
                if (imageView == null) return;
                this.a(imageView, drawable, bl2, bl3, bl4);
                return;
            }
            case 3: {
                TextView textView = (TextView)this.lT.get();
                if (textView == null) return;
                this.a(textView, this.lU, drawable, bl2, bl3);
                return;
            }
        }
    }

    private void a(ImageView object, Drawable drawable, boolean bl2, boolean bl3, boolean bl4) {
        int n2 = !bl3 && !bl4 ? 1 : 0;
        if (n2 != 0 && object instanceof df) {
            int n3 = ((df)((Object)object)).bs();
            if (this.lO != 0 && n3 == this.lO) {
                return;
            }
        }
        if (bl2 = this.a(bl2, bl3)) {
            drawable = this.a(object.getDrawable(), drawable);
        }
        object.setImageDrawable(drawable);
        if (object instanceof df) {
            df df2 = (df)((Object)object);
            object = bl4 ? this.lM.uri : null;
            df2.d((Uri)object);
            n2 = n2 != 0 ? this.lO : 0;
            df2.x(n2);
        }
        if (!bl2) return;
        ((de)drawable).startTransition(250);
    }

    private void a(TextView textView, int n2, Drawable drawable, boolean bl2, boolean bl3) {
        bl2 = this.a(bl2, bl3);
        Object object = es.cp() ? textView.getCompoundDrawablesRelative() : textView.getCompoundDrawables();
        Drawable drawable2 = object[n2];
        if (bl2) {
            drawable = this.a(drawable2, drawable);
        }
        drawable2 = n2 == 0 ? drawable : object[0];
        Drawable drawable3 = n2 == 1 ? drawable : object[1];
        Drawable drawable4 = n2 == 2 ? drawable : object[2];
        object = n2 == 3 ? drawable : object[3];
        if (es.cp()) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable2, drawable3, drawable4, object);
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds(drawable2, drawable3, drawable4, object);
        }
        if (!bl2) return;
        ((de)drawable).startTransition(250);
    }

    private boolean a(boolean bl2, boolean bl3) {
        if (!this.lV) return false;
        if (bl3) return false;
        if (!bl2) return true;
        if (!this.lW) return false;
        return true;
    }

    void a(Context context, Bitmap bitmap, boolean bl2) {
        dg.d(bitmap);
        this.a((Drawable)new BitmapDrawable(context.getResources(), bitmap), bl2, false, true);
    }

    public void a(ImageView imageView) {
        dg.d(imageView);
        this.lR = null;
        this.lS = new WeakReference<ImageView>(imageView);
        this.lT = null;
        this.lU = -1;
        this.lP = 2;
        this.lQ = imageView.hashCode();
    }

    public void a(ImageManager.OnImageLoadedListener onImageLoadedListener) {
        dg.d(onImageLoadedListener);
        this.lR = new WeakReference<ImageManager.OnImageLoadedListener>(onImageLoadedListener);
        this.lS = null;
        this.lT = null;
        this.lU = -1;
        this.lP = 1;
        this.lQ = ds.hashCode(onImageLoadedListener, this.lM);
    }

    void b(Context context, boolean bl2) {
        Drawable drawable = null;
        if (this.lO != 0) {
            drawable = context.getResources().getDrawable(this.lO);
        }
        this.a(drawable, bl2, false, false);
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (!(object instanceof a)) {
            return false;
        }
        boolean bl3 = bl2;
        if (this == object) return bl3;
        bl3 = bl2;
        if (((a)object).hashCode() == this.hashCode()) return bl3;
        return false;
    }

    public int hashCode() {
        return this.lQ;
    }

    void r(Context context) {
        Drawable drawable = null;
        if (this.lN != 0) {
            drawable = context.getResources().getDrawable(this.lN);
        }
        this.a(drawable, false, true, false);
    }

    public void w(int n2) {
        this.lO = n2;
    }

    public static final class a {
        public final Uri uri;

        public a(Uri uri) {
            this.uri = uri;
        }

        public boolean equals(Object object) {
            boolean bl2 = true;
            if (!(object instanceof a)) {
                return false;
            }
            boolean bl3 = bl2;
            if (this == object) return bl3;
            bl3 = bl2;
            if (((a)object).hashCode() == this.hashCode()) return bl3;
            return false;
        }

        public int hashCode() {
            return ds.hashCode(this.uri);
        }
    }
}

