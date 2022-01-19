/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ActivityNotFoundException
 *  android.content.Context
 *  android.content.Intent
 *  android.content.MutableContextWrapper
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.webkit.DownloadListener
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  org.json.JSONException
 */
package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.net.Uri;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.google.android.gms.internal.bk;
import com.google.android.gms.internal.cn;
import com.google.android.gms.internal.co;
import com.google.android.gms.internal.cp;
import com.google.android.gms.internal.cs;
import com.google.android.gms.internal.ct;
import com.google.android.gms.internal.cw;
import com.google.android.gms.internal.cx;
import com.google.android.gms.internal.cy;
import com.google.android.gms.internal.cz;
import com.google.android.gms.internal.h;
import com.google.android.gms.internal.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

public final class cv
extends WebView
implements DownloadListener {
    private x fU;
    private final Object fx = new Object();
    private final h hc;
    private final cw iJ;
    private final a iK;
    private final ct iL;
    private bk iM;
    private boolean iN;
    private boolean iO;

    private cv(a a2, x x2, boolean bl2, boolean bl3, h h2, ct ct2) {
        super((Context)a2);
        this.iK = a2;
        this.fU = x2;
        this.iN = bl2;
        this.hc = h2;
        this.iL = ct2;
        this.setBackgroundColor(0);
        x2 = this.getSettings();
        x2.setJavaScriptEnabled(true);
        x2.setSavePassword(false);
        x2.setSupportMultipleWindows(true);
        x2.setJavaScriptCanOpenWindowsAutomatically(true);
        cn.a((Context)a2, ct2.iF, (WebSettings)x2);
        if (Build.VERSION.SDK_INT >= 17) {
            cp.a(this.getContext(), (WebSettings)x2);
        } else if (Build.VERSION.SDK_INT >= 11) {
            co.a(this.getContext(), (WebSettings)x2);
        }
        this.setDownloadListener(this);
        this.iJ = Build.VERSION.SDK_INT >= 11 ? new cy(this, bl3) : new cw(this, bl3);
        this.setWebViewClient(this.iJ);
        if (Build.VERSION.SDK_INT >= 14) {
            this.setWebChromeClient(new cz(this));
        } else if (Build.VERSION.SDK_INT >= 11) {
            this.setWebChromeClient(new cx(this));
        }
        this.aF();
    }

    public static cv a(Context context, x x2, boolean bl2, boolean bl3, h h2, ct ct2) {
        return new cv(new a(context), x2, bl2, bl3, h2, ct2);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private void aF() {
        Object object = this.fx;
        synchronized (object) {
            if (this.iN || this.fU.eG) {
                if (Build.VERSION.SDK_INT < 14) {
                    cs.r("Disabling hardware acceleration on an overlay.");
                    this.aG();
                } else {
                    cs.r("Enabling hardware acceleration on an overlay.");
                    this.aH();
                }
            } else if (Build.VERSION.SDK_INT < 18) {
                cs.r("Disabling hardware acceleration on an AdView.");
                this.aG();
            } else {
                cs.r("Enabling hardware acceleration on an AdView.");
                this.aH();
            }
            return;
        }
    }

    private void aG() {
        Object object = this.fx;
        synchronized (object) {
            if (!this.iO && Build.VERSION.SDK_INT >= 11) {
                co.c((View)this);
            }
            this.iO = true;
            return;
        }
    }

    private void aH() {
        Object object = this.fx;
        synchronized (object) {
            if (this.iO && Build.VERSION.SDK_INT >= 11) {
                co.d((View)this);
            }
            this.iO = false;
            return;
        }
    }

    public void a(Context context, x x2) {
        Object object = this.fx;
        synchronized (object) {
            this.iK.setBaseContext(context);
            this.iM = null;
            this.fU = x2;
            this.iN = false;
            cn.b(this);
            this.loadUrl("about:blank");
            this.iJ.reset();
            return;
        }
    }

    public void a(bk bk2) {
        Object object = this.fx;
        synchronized (object) {
            this.iM = bk2;
            return;
        }
    }

    public void a(x x2) {
        Object object = this.fx;
        synchronized (object) {
            this.fU = x2;
            this.requestLayout();
            return;
        }
    }

    public void a(String string2, Map<String, ?> map) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("javascript:AFMA_ReceiveMessage('");
        stringBuilder.append(string2);
        stringBuilder.append("'");
        if (map != null) {
            try {
                string2 = cn.m(map).toString();
                stringBuilder.append(",");
                stringBuilder.append(string2);
            }
            catch (JSONException jSONException) {
                cs.v("Could not convert AFMA event parameters to JSON.");
                return;
            }
        }
        stringBuilder.append(");");
        cs.u("Dispatching AFMA event: " + stringBuilder);
        this.loadUrl(stringBuilder.toString());
    }

    public bk aA() {
        Object object = this.fx;
        synchronized (object) {
            return this.iM;
        }
    }

    public cw aB() {
        return this.iJ;
    }

    public h aC() {
        return this.hc;
    }

    public ct aD() {
        return this.iL;
    }

    public boolean aE() {
        Object object = this.fx;
        synchronized (object) {
            return this.iN;
        }
    }

    public void ay() {
        HashMap<String, String> hashMap = new HashMap<String, String>(1);
        hashMap.put("version", this.iL.iF);
        this.a("onhide", hashMap);
    }

    public void az() {
        HashMap<String, String> hashMap = new HashMap<String, String>(1);
        hashMap.put("version", this.iL.iF);
        this.a("onshow", hashMap);
    }

    public void l(boolean bl2) {
        Object object = this.fx;
        synchronized (object) {
            this.iN = bl2;
            this.aF();
            return;
        }
    }

    public void onDownloadStart(String string2, String string3, String string4, String string5, long l2) {
        try {
            string3 = new Intent("android.intent.action.VIEW");
            string3.setDataAndType(Uri.parse((String)string2), string5);
            this.getContext().startActivity((Intent)string3);
            return;
        }
        catch (ActivityNotFoundException activityNotFoundException) {
            cs.r("Couldn't find an Activity to view url/mimetype: " + string2 + " / " + string5);
            return;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    protected void onMeasure(int n2, int n3) {
        int n4 = Integer.MAX_VALUE;
        Object object = this.fx;
        synchronized (object) {
            int n5;
            int n6;
            block12: {
                block11: {
                    if (this.isInEditMode() || this.iN) {
                        super.onMeasure(n2, n3);
                        return;
                    }
                    int n7 = View.MeasureSpec.getMode((int)n2);
                    n6 = View.MeasureSpec.getSize((int)n2);
                    int n8 = View.MeasureSpec.getMode((int)n3);
                    n5 = View.MeasureSpec.getSize((int)n3);
                    n2 = n7 != Integer.MIN_VALUE && n7 != 0x40000000 ? Integer.MAX_VALUE : n6;
                    if (n8 == Integer.MIN_VALUE) break block11;
                    n3 = n4;
                    if (n8 != 0x40000000) break block12;
                }
                n3 = n5;
            }
            if (this.fU.widthPixels > n2 || this.fU.heightPixels > n3) {
                cs.v("Not enough space to show ad. Needs " + this.fU.widthPixels + "x" + this.fU.heightPixels + " pixels, but only has " + n6 + "x" + n5 + " pixels.");
                if (this.getVisibility() != 8) {
                    this.setVisibility(4);
                }
                this.setMeasuredDimension(0, 0);
            } else {
                if (this.getVisibility() != 8) {
                    this.setVisibility(0);
                }
                this.setMeasuredDimension(this.fU.widthPixels, this.fU.heightPixels);
            }
            return;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.hc == null) return super.onTouchEvent(motionEvent);
        this.hc.a(motionEvent);
        return super.onTouchEvent(motionEvent);
    }

    public void setContext(Context context) {
        this.iK.setBaseContext(context);
    }

    public x y() {
        Object object = this.fx;
        synchronized (object) {
            return this.fU;
        }
    }

    private static class a
    extends MutableContextWrapper {
        private Activity iP;
        private Context iQ;

        public a(Context context) {
            super(context);
            this.setBaseContext(context);
        }

        public void setBaseContext(Context object) {
            this.iQ = object.getApplicationContext();
            object = object instanceof Activity ? (Activity)object : null;
            this.iP = object;
            super.setBaseContext(this.iQ);
        }

        public void startActivity(Intent intent) {
            if (this.iP != null) {
                this.iP.startActivity(intent);
                return;
            }
            intent.setFlags(0x10000000);
            this.iQ.startActivity(intent);
        }
    }
}

