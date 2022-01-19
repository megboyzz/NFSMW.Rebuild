/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.os.IBinder
 *  android.os.RemoteException
 *  android.util.Log
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 */
package com.google.android.gms.plus;

import android.app.PendingIntent;
import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.internal.du;
import com.google.android.gms.internal.go;
import com.google.android.gms.internal.gr;
import com.google.android.gms.plus.PlusOneButton;
import com.google.android.gms.plus.PlusOneDummyView;

public final class PlusOneButtonWithPopup
extends ViewGroup {
    private String iD;
    private String jD;
    private int mSize;
    private View zo;
    private int zp;
    private View.OnClickListener zu;

    public PlusOneButtonWithPopup(Context context) {
        this(context, null);
    }

    public PlusOneButtonWithPopup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSize = PlusOneButton.getSize(context, attributeSet);
        this.zp = PlusOneButton.getAnnotation(context, attributeSet);
        this.zo = new PlusOneDummyView(context, this.mSize);
        this.addView(this.zo);
    }

    private int c(int n2, int n3) {
        int n4 = View.MeasureSpec.getMode((int)n2);
        switch (n4) {
            default: {
                return n2;
            }
            case -2147483648: 
            case 0x40000000: 
        }
        return View.MeasureSpec.makeMeasureSpec((int)(View.MeasureSpec.getSize((int)n2) - n3), (int)n4);
    }

    private void eq() {
        if (this.zo != null) {
            this.removeView(this.zo);
        }
        this.zo = gr.a(this.getContext(), this.mSize, this.zp, this.iD, this.jD);
        if (this.zu != null) {
            this.setOnClickListener(this.zu);
        }
        this.addView(this.zo);
    }

    private go er() throws RemoteException {
        go go2 = go.a.at((IBinder)this.zo.getTag());
        if (go2 != null) return go2;
        if (!Log.isLoggable((String)"PlusOneButtonWithPopup", (int)5)) throw new RemoteException();
        Log.w((String)"PlusOneButtonWithPopup", (String)"Failed to get PlusOneDelegate");
        throw new RemoteException();
    }

    public void cancelClick() {
        if (this.zo == null) return;
        try {
            this.er().cancelClick();
            return;
        }
        catch (RemoteException remoteException) {
            return;
        }
    }

    public PendingIntent getResolution() {
        if (this.zo == null) return null;
        try {
            return this.er().getResolution();
        }
        catch (RemoteException remoteException) {
            // empty catch block
        }
        return null;
    }

    public void initialize(String string2, String string3) {
        du.c(string2, "Url must not be null");
        this.iD = string2;
        this.jD = string3;
        this.eq();
    }

    protected void onLayout(boolean bl2, int n2, int n3, int n4, int n5) {
        this.zo.layout(this.getPaddingLeft(), this.getPaddingTop(), n4 - n2 - this.getPaddingRight(), n5 - n3 - this.getPaddingBottom());
    }

    protected void onMeasure(int n2, int n3) {
        int n4 = this.getPaddingLeft() + this.getPaddingRight();
        int n5 = this.getPaddingTop() + this.getPaddingBottom();
        this.zo.measure(this.c(n2, n4), this.c(n3, n5));
        this.setMeasuredDimension(n4 + this.zo.getMeasuredWidth(), n5 + this.zo.getMeasuredHeight());
    }

    public void reinitialize() {
        if (this.zo == null) return;
        try {
            this.er().reinitialize();
            return;
        }
        catch (RemoteException remoteException) {
            return;
        }
    }

    public void setAnnotation(int n2) {
        this.zp = n2;
        this.eq();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.zu = onClickListener;
        this.zo.setOnClickListener(onClickListener);
    }

    public void setSize(int n2) {
        this.mSize = n2;
        this.eq();
    }
}

