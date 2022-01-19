/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.FrameLayout
 */
package com.google.android.gms.plus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.internal.du;
import com.google.android.gms.internal.dx;
import com.google.android.gms.internal.gr;

public final class PlusOneButton
extends FrameLayout {
    public static final int ANNOTATION_BUBBLE = 1;
    public static final int ANNOTATION_INLINE = 2;
    public static final int ANNOTATION_NONE = 0;
    public static final int DEFAULT_ACTIVITY_REQUEST_CODE = -1;
    public static final int SIZE_MEDIUM = 1;
    public static final int SIZE_SMALL = 0;
    public static final int SIZE_STANDARD = 3;
    public static final int SIZE_TALL = 2;
    private String iD;
    private int mSize;
    private View zo;
    private int zp;
    private int zq;
    private OnPlusOneClickListener zr;

    public PlusOneButton(Context context) {
        this(context, null);
    }

    public PlusOneButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSize = PlusOneButton.getSize(context, attributeSet);
        this.zp = PlusOneButton.getAnnotation(context, attributeSet);
        this.zq = -1;
        this.p(this.getContext());
        if (!this.isInEditMode()) return;
    }

    protected static int getAnnotation(Context object, AttributeSet attributeSet) {
        int n2 = 0;
        if ("INLINE".equalsIgnoreCase((String)(object = dx.a("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "annotation", object, attributeSet, true, false, "PlusOneButton")))) {
            return 2;
        }
        if ("NONE".equalsIgnoreCase((String)object)) return n2;
        return 1;
    }

    protected static int getSize(Context object, AttributeSet attributeSet) {
        if ("SMALL".equalsIgnoreCase((String)(object = dx.a("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "size", object, attributeSet, true, false, "PlusOneButton")))) {
            return 0;
        }
        if ("MEDIUM".equalsIgnoreCase((String)object)) {
            return 1;
        }
        if (!"TALL".equalsIgnoreCase((String)object)) return 3;
        return 2;
    }

    private void p(Context context) {
        if (this.zo != null) {
            this.removeView(this.zo);
        }
        this.zo = gr.a(context, this.mSize, this.zp, this.iD, this.zq);
        this.setOnPlusOneClickListener(this.zr);
        this.addView(this.zo);
    }

    public void initialize(String string2, int n2) {
        du.a(this.getContext() instanceof Activity, "To use this method, the PlusOneButton must be placed in an Activity. Use initialize(PlusClient, String, OnPlusOneClickListener).");
        this.iD = string2;
        this.zq = n2;
        this.p(this.getContext());
    }

    public void initialize(String string2, OnPlusOneClickListener onPlusOneClickListener) {
        this.iD = string2;
        this.zq = 0;
        this.p(this.getContext());
        this.setOnPlusOneClickListener(onPlusOneClickListener);
    }

    protected void onLayout(boolean bl2, int n2, int n3, int n4, int n5) {
        this.zo.layout(0, 0, n4 - n2, n5 - n3);
    }

    protected void onMeasure(int n2, int n3) {
        View view = this.zo;
        this.measureChild(view, n2, n3);
        this.setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void setAnnotation(int n2) {
        this.zp = n2;
        this.p(this.getContext());
    }

    public void setOnPlusOneClickListener(OnPlusOneClickListener onPlusOneClickListener) {
        this.zr = onPlusOneClickListener;
        this.zo.setOnClickListener((View.OnClickListener)new DefaultOnPlusOneClickListener(onPlusOneClickListener));
    }

    public void setSize(int n2) {
        this.mSize = n2;
        this.p(this.getContext());
    }

    protected class DefaultOnPlusOneClickListener
    implements View.OnClickListener,
    OnPlusOneClickListener {
        private final OnPlusOneClickListener zs;

        public DefaultOnPlusOneClickListener(OnPlusOneClickListener onPlusOneClickListener) {
            this.zs = onPlusOneClickListener;
        }

        public void onClick(View view) {
            view = (Intent)PlusOneButton.this.zo.getTag();
            if (this.zs != null) {
                this.zs.onPlusOneClick((Intent)view);
                return;
            }
            this.onPlusOneClick((Intent)view);
        }

        @Override
        public void onPlusOneClick(Intent intent) {
            Context context = PlusOneButton.this.getContext();
            if (!(context instanceof Activity)) return;
            if (intent == null) return;
            ((Activity)context).startActivityForResult(intent, PlusOneButton.this.zq);
        }
    }

    public static interface OnPlusOneClickListener {
        public void onPlusOneClick(Intent var1);
    }
}

