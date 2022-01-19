/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.os.AsyncTask
 *  android.os.Handler
 *  android.os.Looper
 *  android.view.View$MeasureSpec
 *  android.webkit.WebView
 */
package com.google.ads.mediation.jsadapter;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.webkit.WebView;
import com.google.ads.mediation.jsadapter.JavascriptAdapter;
import com.google.android.gms.internal.cs;

public final class AdViewCheckTask
implements Runnable {
    public static final int BACKGROUND_COLOR = 0;
    private final JavascriptAdapter r;
    private final Handler s;
    private final long t;
    private long u;

    public AdViewCheckTask(JavascriptAdapter javascriptAdapter, long l2, long l3) {
        this.r = javascriptAdapter;
        this.t = l2;
        this.u = l3;
        this.s = new Handler(Looper.getMainLooper());
    }

    static /* synthetic */ long a(AdViewCheckTask adViewCheckTask) {
        long l2;
        adViewCheckTask.u = l2 = adViewCheckTask.u - 1L;
        return l2;
    }

    @Override
    public void run() {
        if (this.r == null) return;
        if (this.r.shouldStopAdCheck()) {
            return;
        }
        new a(this.r.getWebViewWidth(), this.r.getWebViewHeight(), this.r.getWebView()).execute(new Void[0]);
    }

    public void start() {
        this.s.postDelayed((Runnable)this, this.t);
    }

    private final class a
    extends AsyncTask<Void, Void, Boolean> {
        private final int v;
        private final int w;
        private final WebView x;
        private Bitmap y;

        public a(int n2, int n3, WebView webView) {
            this.v = n3;
            this.w = n2;
            this.x = webView;
        }

        /*
         * Enabled unnecessary exception pruning
         */
        protected Boolean a(Void ... object) {
            synchronized (this) {
                int n2 = this.y.getWidth();
                int n3 = this.y.getHeight();
                if (n2 == 0) return false;
                if (n3 == 0) {
                    return false;
                }
                int n4 = 0;
                int n5 = 0;
                while (true) {
                    if (n4 < n2) {
                    } else {
                        boolean bl2 = (double)n5 / ((double)(n2 * n3) / 100.0) > 0.1;
                        return bl2;
                    }
                    for (int i2 = 0; i2 < n3; i2 += 10) {
                        int n6 = n5;
                        if (this.y.getPixel(n4, i2) != 0) {
                            n6 = n5 + 1;
                        }
                        n5 = n6;
                    }
                    n4 += 10;
                }
            }
        }

        protected void a(Boolean bl2) {
            AdViewCheckTask.a(AdViewCheckTask.this);
            if (bl2.booleanValue()) {
                AdViewCheckTask.this.r.sendAdReceivedUpdate();
                return;
            }
            if (AdViewCheckTask.this.u <= 0L) {
                cs.r("Ad not detected, Not scheduling anymore runs.");
                AdViewCheckTask.this.r.sendAdNotReceivedUpdate();
                return;
            }
            if (cs.n(2)) {
                cs.r("Ad not detected, scheduling another run.");
            }
            AdViewCheckTask.this.s.postDelayed((Runnable)AdViewCheckTask.this, AdViewCheckTask.this.t);
        }

        protected /* synthetic */ Object doInBackground(Object[] objectArray) {
            return this.a((Void[])objectArray);
        }

        protected /* synthetic */ void onPostExecute(Object object) {
            this.a((Boolean)object);
        }

        protected void onPreExecute() {
            synchronized (this) {
                this.y = Bitmap.createBitmap((int)this.w, (int)this.v, (Bitmap.Config)Bitmap.Config.ARGB_8888);
                this.x.setVisibility(0);
                this.x.measure(View.MeasureSpec.makeMeasureSpec((int)this.w, (int)0), View.MeasureSpec.makeMeasureSpec((int)this.v, (int)0));
                this.x.layout(0, 0, this.w, this.v);
                Canvas canvas = new Canvas(this.y);
                this.x.draw(canvas);
                this.x.invalidate();
                return;
            }
        }
    }
}

