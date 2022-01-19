/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.os.SystemClock
 */
package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.google.android.gms.internal.es;

public final class de
extends Drawable
implements Drawable.Callback {
    private boolean lV = true;
    private int lX = 0;
    private long lY;
    private int lZ;
    private int ma;
    private int mb = 255;
    private int mc;
    private int md = 0;
    private boolean me;
    private b mf;
    private Drawable mg;
    private Drawable mh;
    private boolean mi;
    private boolean mj;
    private boolean mk;
    private int ml;

    public de(Drawable object, Drawable object2) {
        this(null);
        Drawable drawable = object;
        if (object == null) {
            drawable = a.mm;
        }
        this.mg = drawable;
        drawable.setCallback((Drawable.Callback)this);
        object = this.mf;
        object.mp |= drawable.getChangingConfigurations();
        object = object2;
        if (object2 == null) {
            object = a.mm;
        }
        this.mh = object;
        object.setCallback((Drawable.Callback)this);
        object2 = this.mf;
        object2.mp |= object.getChangingConfigurations();
    }

    de(b b2) {
        this.mf = new b(b2);
    }

    public Drawable bq() {
        return this.mh;
    }

    public boolean canConstantState() {
        if (this.mi) return this.mj;
        boolean bl2 = this.mg.getConstantState() != null && this.mh.getConstantState() != null;
        this.mj = bl2;
        this.mi = true;
        return this.mj;
    }

    public void draw(Canvas canvas) {
        int n2 = 1;
        int n3 = 1;
        int n4 = 0;
        switch (this.lX) {
            case 1: {
                this.lY = SystemClock.uptimeMillis();
                this.lX = 2;
                n3 = n4;
                break;
            }
            case 2: {
                if (this.lY < 0L) break;
                float f2 = (float)(SystemClock.uptimeMillis() - this.lY) / (float)this.mc;
                n3 = f2 >= 1.0f ? n2 : 0;
                if (n3 != 0) {
                    this.lX = 0;
                }
                f2 = Math.min(f2, 1.0f);
                float f3 = this.lZ;
                this.md = (int)(f2 * (float)(this.ma - this.lZ) + f3);
                break;
            }
        }
        n2 = this.md;
        boolean bl2 = this.lV;
        Drawable drawable = this.mg;
        Drawable drawable2 = this.mh;
        if (n3 != 0) {
            if (!bl2 || n2 == 0) {
                drawable.draw(canvas);
            }
            if (n2 != this.mb) return;
            drawable2.setAlpha(this.mb);
            drawable2.draw(canvas);
            return;
        }
        if (bl2) {
            drawable.setAlpha(this.mb - n2);
        }
        drawable.draw(canvas);
        if (bl2) {
            drawable.setAlpha(this.mb);
        }
        if (n2 > 0) {
            drawable2.setAlpha(n2);
            drawable2.draw(canvas);
            drawable2.setAlpha(this.mb);
        }
        this.invalidateSelf();
    }

    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.mf.mo | this.mf.mp;
    }

    public Drawable.ConstantState getConstantState() {
        if (!this.canConstantState()) return null;
        this.mf.mo = this.getChangingConfigurations();
        return this.mf;
    }

    public int getIntrinsicHeight() {
        return Math.max(this.mg.getIntrinsicHeight(), this.mh.getIntrinsicHeight());
    }

    public int getIntrinsicWidth() {
        return Math.max(this.mg.getIntrinsicWidth(), this.mh.getIntrinsicWidth());
    }

    public int getOpacity() {
        if (this.mk) return this.ml;
        this.ml = Drawable.resolveOpacity((int)this.mg.getOpacity(), (int)this.mh.getOpacity());
        this.mk = true;
        return this.ml;
    }

    public void invalidateDrawable(Drawable drawable) {
        if (!es.ck()) return;
        drawable = this.getCallback();
        if (drawable == null) return;
        drawable.invalidateDrawable((Drawable)this);
    }

    public Drawable mutate() {
        if (this.me) return this;
        if (super.mutate() != this) return this;
        if (!this.canConstantState()) {
            throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
        }
        this.mg.mutate();
        this.mh.mutate();
        this.me = true;
        return this;
    }

    protected void onBoundsChange(Rect rect) {
        this.mg.setBounds(rect);
        this.mh.setBounds(rect);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long l2) {
        if (!es.ck()) return;
        drawable = this.getCallback();
        if (drawable == null) return;
        drawable.scheduleDrawable((Drawable)this, runnable, l2);
    }

    public void setAlpha(int n2) {
        if (this.md == this.mb) {
            this.md = n2;
        }
        this.mb = n2;
        this.invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mg.setColorFilter(colorFilter);
        this.mh.setColorFilter(colorFilter);
    }

    public void startTransition(int n2) {
        this.lZ = 0;
        this.ma = this.mb;
        this.md = 0;
        this.mc = n2;
        this.lX = 1;
        this.invalidateSelf();
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (!es.ck()) return;
        drawable = this.getCallback();
        if (drawable == null) return;
        drawable.unscheduleDrawable((Drawable)this, runnable);
    }

    private static final class com.google.android.gms.internal.de$a
    extends Drawable {
        private static final com.google.android.gms.internal.de$a mm = new com.google.android.gms.internal.de$a();
        private static final a mn = new a();

        private com.google.android.gms.internal.de$a() {
        }

        public void draw(Canvas canvas) {
        }

        public Drawable.ConstantState getConstantState() {
            return mn;
        }

        public int getOpacity() {
            return -2;
        }

        public void setAlpha(int n2) {
        }

        public void setColorFilter(ColorFilter colorFilter) {
        }

        private static final class a
        extends Drawable.ConstantState {
            private a() {
            }

            public int getChangingConfigurations() {
                return 0;
            }

            public Drawable newDrawable() {
                return mm;
            }
        }
    }

    static final class b
    extends Drawable.ConstantState {
        int mo;
        int mp;

        b(b b2) {
            if (b2 == null) return;
            this.mo = b2.mo;
            this.mp = b2.mp;
        }

        public int getChangingConfigurations() {
            return this.mo;
        }

        public Drawable newDrawable() {
            return new de(this);
        }
    }
}

