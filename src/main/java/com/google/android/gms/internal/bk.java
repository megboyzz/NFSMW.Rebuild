/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.view.Window
 *  android.webkit.WebChromeClient$CustomViewCallback
 *  android.widget.FrameLayout
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 */
package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.internal.bh;
import com.google.android.gms.internal.bm;
import com.google.android.gms.internal.bo;
import com.google.android.gms.internal.bp;
import com.google.android.gms.internal.bs;
import com.google.android.gms.internal.cn;
import com.google.android.gms.internal.co;
import com.google.android.gms.internal.cs;
import com.google.android.gms.internal.cv;
import com.google.android.gms.internal.cw;

public final class bk
extends bs.a {
    private boolean gA = false;
    private RelativeLayout gB;
    private final Activity gr;
    private bm gs;
    private bo gt;
    private cv gu;
    private b gv;
    private bp gw;
    private FrameLayout gx;
    private WebChromeClient.CustomViewCallback gy;
    private boolean gz = false;

    public bk(Activity activity) {
        this.gr = activity;
    }

    private void Z() {
        if (!this.gr.isFinishing()) return;
        if (this.gA) {
            return;
        }
        this.gA = true;
        if (!this.gr.isFinishing()) return;
        if (this.gu != null) {
            this.gu.ay();
            this.gB.removeView((View)this.gu);
            if (this.gv != null) {
                this.gu.l(false);
                this.gv.gE.addView((View)this.gu, this.gv.index, this.gv.gD);
            }
        }
        if (this.gs == null) return;
        if (this.gs.gH == null) return;
        this.gs.gH.A();
    }

    private static RelativeLayout.LayoutParams a(int n2, int n3, int n4, int n5) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(n4, n5);
        layoutParams.setMargins(n2, n3, 0, 0);
        layoutParams.addRule(10);
        layoutParams.addRule(9);
        return layoutParams;
    }

    public static void a(Context context, bm bm2) {
        Intent intent = new Intent();
        intent.setClassName(context, "com.google.android.gms.ads.AdActivity");
        intent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", bm2.ej.iI);
        bm.a(intent, bm2);
        intent.addFlags(524288);
        context.startActivity(intent);
    }

    private void h(boolean bl2) throws a {
        this.gr.requestWindowFeature(1);
        Window window = this.gr.getWindow();
        window.setFlags(1024, 1024);
        this.setRequestedOrientation(this.gs.orientation);
        if (Build.VERSION.SDK_INT >= 11) {
            cs.r("Enabling hardware acceleration on the AdActivity window.");
            co.a(window);
        }
        this.gB = new RelativeLayout((Context)this.gr);
        this.gB.setBackgroundColor(-16777216);
        this.gr.setContentView((View)this.gB);
        boolean bl3 = this.gs.gI.aB().aI();
        if (bl2) {
            this.gu = cv.a((Context)this.gr, this.gs.gI.y(), true, bl3, null, this.gs.ej);
            this.gu.aB().a(null, null, this.gs.gJ, this.gs.gN, true);
            this.gu.aB().a(new cw.a(){

                @Override
                public void a(cv cv2) {
                    cv2.az();
                }
            });
            if (this.gs.gn != null) {
                this.gu.loadUrl(this.gs.gn);
            } else {
                if (this.gs.gM == null) throw new a("No URL or HTML to display in ad overlay.");
                this.gu.loadDataWithBaseURL(this.gs.gK, this.gs.gM, "text/html", "UTF-8", null);
            }
        } else {
            this.gu = this.gs.gI;
            this.gu.setContext((Context)this.gr);
        }
        this.gu.a(this);
        this.gB.addView((View)this.gu, -1, -1);
        if (!bl2) {
            this.gu.az();
        }
        this.f(bl3);
    }

    public bo W() {
        return this.gt;
    }

    public void X() {
        if (this.gs != null) {
            this.setRequestedOrientation(this.gs.orientation);
        }
        if (this.gx != null) {
            this.gr.setContentView((View)this.gB);
            this.gx.removeAllViews();
            this.gx = null;
        }
        if (this.gy == null) return;
        this.gy.onCustomViewHidden();
        this.gy = null;
    }

    public void Y() {
        this.gB.removeView((View)this.gw);
        this.f(true);
    }

    public void a(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        this.gx = new FrameLayout((Context)this.gr);
        this.gx.setBackgroundColor(-16777216);
        this.gx.addView(view, -1, -1);
        this.gr.setContentView((View)this.gx);
        this.gy = customViewCallback;
    }

    public void b(int n2, int n3, int n4, int n5) {
        if (this.gt == null) return;
        this.gt.setLayoutParams((ViewGroup.LayoutParams)bk.a(n2, n3, n4, n5));
    }

    public void c(int n2, int n3, int n4, int n5) {
        if (this.gt != null) return;
        this.gt = new bo((Context)this.gr, this.gu);
        this.gB.addView((View)this.gt, 0, (ViewGroup.LayoutParams)bk.a(n2, n3, n4, n5));
        this.gu.aB().m(false);
    }

    public void close() {
        this.gr.finish();
    }

    public void f(boolean bl2) {
        int n2 = bl2 ? 50 : 32;
        this.gw = new bp(this.gr, n2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        n2 = bl2 ? 11 : 9;
        layoutParams.addRule(n2);
        this.gw.g(this.gs.gL);
        this.gB.addView((View)this.gw, (ViewGroup.LayoutParams)layoutParams);
    }

    public void g(boolean bl2) {
        if (this.gw == null) return;
        this.gw.g(bl2);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    @Override
    public void onCreate(Bundle bundle) {
        boolean bl2 = false;
        if (bundle != null) {
            bl2 = bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        }
        this.gz = bl2;
        try {
            this.gs = bm.a(this.gr.getIntent());
            if (this.gs == null) {
                throw new a("Could not get info for ad overlay.");
            }
            if (bundle == null) {
                if (this.gs.gH != null) {
                    this.gs.gH.B();
                }
                if (this.gs.gO != 1 && this.gs.gG != null) {
                    this.gs.gG.w();
                }
            }
            switch (this.gs.gO) {
                case 1: {
                    this.h(false);
                    return;
                }
                case 2: {
                    this.gv = new b(this.gs.gI);
                    this.h(false);
                    return;
                }
                case 3: {
                    this.h(true);
                    return;
                }
                case 4: {
                    if (this.gz) {
                        this.gr.finish();
                        return;
                    }
                    if (bh.a((Context)this.gr, this.gs.gF, this.gs.gN)) return;
                    this.gr.finish();
                    return;
                }
            }
            throw new a("Could not determine ad overlay type.");
        }
        catch (a a2) {
            cs.v(a2.getMessage());
            this.gr.finish();
            return;
        }
    }

    @Override
    public void onDestroy() {
        if (this.gt != null) {
            this.gt.destroy();
        }
        if (this.gu != null) {
            this.gB.removeView((View)this.gu);
        }
        this.Z();
    }

    @Override
    public void onPause() {
        if (this.gt != null) {
            this.gt.pause();
        }
        this.X();
        if (!(this.gu == null || this.gr.isFinishing() && this.gv != null)) {
            cn.a(this.gu);
        }
        this.Z();
    }

    @Override
    public void onRestart() {
    }

    @Override
    public void onResume() {
        if (this.gs != null && this.gs.gO == 4) {
            if (this.gz) {
                this.gr.finish();
            } else {
                this.gz = true;
            }
        }
        if (this.gu == null) return;
        cn.b(this.gu);
    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.gz);
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
        this.Z();
    }

    public void setRequestedOrientation(int n2) {
        this.gr.setRequestedOrientation(n2);
    }

    private static final class a
    extends Exception {
        public a(String string2) {
            super(string2);
        }
    }

    private static final class b {
        public final ViewGroup.LayoutParams gD;
        public final ViewGroup gE;
        public final int index;

        public b(cv cv2) throws a {
            this.gD = cv2.getLayoutParams();
            ViewParent viewParent = cv2.getParent();
            if (!(viewParent instanceof ViewGroup)) throw new a("Could not get the parent of the WebView for an overlay.");
            this.gE = (ViewGroup)viewParent;
            this.index = this.gE.indexOfChild((View)cv2);
            this.gE.removeView((View)cv2);
            cv2.l(true);
        }
    }
}

