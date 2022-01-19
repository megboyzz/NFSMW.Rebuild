/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.Bundle
 *  android.os.RemoteException
 *  android.util.DisplayMetrics
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.widget.ViewSwitcher
 */
package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ViewSwitcher;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.c;
import com.google.android.gms.internal.ab;
import com.google.android.gms.internal.ac;
import com.google.android.gms.internal.ae;
import com.google.android.gms.internal.al;
import com.google.android.gms.internal.av;
import com.google.android.gms.internal.az;
import com.google.android.gms.internal.bb;
import com.google.android.gms.internal.bk;
import com.google.android.gms.internal.bm;
import com.google.android.gms.internal.bn;
import com.google.android.gms.internal.bq;
import com.google.android.gms.internal.bu;
import com.google.android.gms.internal.bz;
import com.google.android.gms.internal.cj;
import com.google.android.gms.internal.ck;
import com.google.android.gms.internal.cl;
import com.google.android.gms.internal.cn;
import com.google.android.gms.internal.cr;
import com.google.android.gms.internal.cs;
import com.google.android.gms.internal.ct;
import com.google.android.gms.internal.cv;
import com.google.android.gms.internal.du;
import com.google.android.gms.internal.g;
import com.google.android.gms.internal.h;
import com.google.android.gms.internal.q;
import com.google.android.gms.internal.s;
import com.google.android.gms.internal.v;
import com.google.android.gms.internal.x;

public final class r
extends ac.a
implements al,
av,
bn,
bq,
bu.a,
q {
    private final bb ed;
    private final a ee;
    private final s ef;

    public r(Context context, x x2, String string2, bb bb2, ct ct2) {
        this.ee = new a(context, x2, string2, ct2);
        this.ed = bb2;
        this.ef = new s(this);
        cs.t("Use AdRequest.Builder.addTestDevice(\"" + cr.l(context) + "\") to get test ads on this device.");
        cn.i(context);
    }

    private void I() {
        cs.t("Ad closing.");
        if (this.ee.ek == null) return;
        try {
            this.ee.ek.onAdClosed();
            return;
        }
        catch (RemoteException remoteException) {
            cs.b("Could not call AdListener.onAdClosed().", remoteException);
            return;
        }
    }

    private void J() {
        cs.t("Ad leaving application.");
        if (this.ee.ek == null) return;
        try {
            this.ee.ek.onAdLeftApplication();
            return;
        }
        catch (RemoteException remoteException) {
            cs.b("Could not call AdListener.onAdLeftApplication().", remoteException);
            return;
        }
    }

    private void K() {
        cs.t("Ad opening.");
        if (this.ee.ek == null) return;
        try {
            this.ee.ek.onAdOpened();
            return;
        }
        catch (RemoteException remoteException) {
            cs.b("Could not call AdListener.onAdOpened().", remoteException);
            return;
        }
    }

    private void L() {
        cs.t("Ad finished loading.");
        if (this.ee.ek == null) return;
        try {
            this.ee.ek.onAdLoaded();
            return;
        }
        catch (RemoteException remoteException) {
            cs.b("Could not call AdListener.onAdLoaded().", remoteException);
            return;
        }
    }

    private boolean M() {
        boolean bl2 = true;
        if (!cn.a(this.ee.eh.getPackageManager(), this.ee.eh.getPackageName(), "android.permission.INTERNET")) {
            if (!this.ee.em.eG) {
                cr.a((ViewGroup)this.ee.eg, this.ee.em, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
            }
            bl2 = false;
        }
        if (!cn.h(this.ee.eh)) {
            if (!this.ee.em.eG) {
                cr.a((ViewGroup)this.ee.eg, this.ee.em, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
            }
            bl2 = false;
        }
        if (bl2) return bl2;
        if (this.ee.em.eG) return bl2;
        this.ee.eg.setVisibility(0);
        return bl2;
    }

    private void N() {
        if (this.ee.en == null) {
            cs.v("Ad state was null when trying to ping click URLs.");
            return;
        }
        cs.r("Pinging click URLs.");
        if (this.ee.en.fK != null) {
            cn.a(this.ee.eh, this.ee.ej.iF, this.ee.en.fK);
        }
        if (this.ee.en.ip == null) return;
        if (this.ee.en.ip.fK == null) return;
        az.a(this.ee.eh, this.ee.ej.iF, this.ee.en, this.ee.adUnitId, false, this.ee.en.ip.fK);
    }

    private void O() {
        if (this.ee.en == null) return;
        this.ee.en.gI.destroy();
        this.ee.en = null;
    }

    private void a(int n2) {
        cs.v("Failed to load ad: " + n2);
        if (this.ee.ek == null) return;
        try {
            this.ee.ek.onAdFailedToLoad(n2);
            return;
        }
        catch (RemoteException remoteException) {
            cs.b("Could not call AdListener.onAdFailedToLoad().", remoteException);
            return;
        }
    }

    private void b(View view) {
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -2);
        this.ee.eg.addView(view, layoutParams);
    }

    private void b(boolean bl2) {
        if (this.ee.en == null) {
            cs.v("Ad state was null when trying to ping impression URLs.");
            return;
        }
        cs.r("Pinging Impression URLs.");
        if (this.ee.en.fL != null) {
            cn.a(this.ee.eh, this.ee.ej.iF, this.ee.en.fL);
        }
        if (this.ee.en.ip != null && this.ee.en.ip.fL != null) {
            az.a(this.ee.eh, this.ee.ej.iF, this.ee.en, this.ee.adUnitId, bl2, this.ee.en.ip.fL);
        }
        if (this.ee.en.ga == null) return;
        if (this.ee.en.ga.fG == null) return;
        az.a(this.ee.eh, this.ee.ej.iF, this.ee.en, this.ee.adUnitId, bl2, this.ee.en.ga.fG);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private boolean b(cj cj2) {
        if (cj2.hw) {
            try {
                cj2 = (View)c.b(cj2.gb.getView());
            }
            catch (RemoteException remoteException) {
                cs.b("Could not get View from mediation adapter.", remoteException);
                return false;
            }
            View view = this.ee.eg.getNextView();
            if (view != null) {
                this.ee.eg.removeView(view);
            }
            try {
                this.b((View)cj2);
            }
            catch (Throwable throwable) {
                cs.b("Could not add mediation view to view hierarchy.", throwable);
                return false;
            }
        } else if (cj2.iq != null) {
            cj2.gI.a(cj2.iq);
            this.ee.eg.removeAllViews();
            this.ee.eg.setMinimumWidth(cj2.iq.widthPixels);
            this.ee.eg.setMinimumHeight(cj2.iq.heightPixels);
            this.b((View)cj2.gI);
        }
        if (this.ee.eg.getChildCount() > 1) {
            this.ee.eg.showNext();
        }
        if (this.ee.en != null) {
            cj2 = this.ee.eg.getNextView();
            if (cj2 instanceof cv) {
                ((cv)((Object)cj2)).a(this.ee.eh, this.ee.em);
            } else if (cj2 != null) {
                this.ee.eg.removeView((View)cj2);
            }
            if (this.ee.en.gb != null) {
                try {
                    this.ee.en.gb.destroy();
                }
                catch (RemoteException remoteException) {
                    cs.v("Could not destroy previous mediation adapter.");
                }
            }
        }
        this.ee.eg.setVisibility(0);
        return true;
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    private bz.a c(v v2) {
        void var8_8;
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo = this.ee.eh.getApplicationInfo();
        try {
            packageInfo = this.ee.eh.getPackageManager().getPackageInfo(applicationInfo.packageName, 0);
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            packageInfo = null;
        }
        while (!this.ee.em.eG && this.ee.eg.getParent() != null) {
            int[] nArray = new int[2];
            this.ee.eg.getLocationOnScreen(nArray);
            int n2 = nArray[0];
            int n3 = nArray[1];
            DisplayMetrics displayMetrics = this.ee.eh.getResources().getDisplayMetrics();
            int n4 = this.ee.eg.getWidth();
            int n5 = this.ee.eg.getHeight();
            int n6 = this.ee.eg.isShown() && n2 + n4 > 0 && n3 + n5 > 0 && n2 <= displayMetrics.widthPixels && n3 <= displayMetrics.heightPixels ? 1 : 0;
            Bundle bundle = new Bundle(5);
            bundle.putInt("x", n2);
            bundle.putInt("y", n3);
            bundle.putInt("width", n4);
            bundle.putInt("height", n5);
            bundle.putInt("visible", n6);
            return new bz.a((Bundle)var8_8, v2, this.ee.em, this.ee.adUnitId, applicationInfo, packageInfo, ck.ar(), ck.ir, this.ee.ej);
        }
        Object var8_9 = null;
        return new bz.a((Bundle)var8_8, v2, this.ee.em, this.ee.adUnitId, applicationInfo, packageInfo, ck.ar(), ck.ir, this.ee.ej);
    }

    @Override
    public void A() {
        if (this.ee.em.eG) {
            this.O();
        }
        this.I();
    }

    @Override
    public void B() {
        if (this.ee.em.eG) {
            this.b(false);
        }
        this.K();
    }

    @Override
    public void C() {
        this.w();
    }

    @Override
    public void D() {
        this.A();
    }

    @Override
    public void E() {
        this.z();
    }

    @Override
    public void F() {
        this.B();
    }

    @Override
    public void G() {
        if (this.ee.en != null) {
            cs.v("Mediation adapter " + this.ee.en.gc + " refreshed, but mediation adapters should never refresh.");
        }
        this.b(true);
        this.L();
    }

    @Override
    public void H() {
        du.B("recordManualImpression must be called on the main UI thread.");
        if (this.ee.en == null) {
            cs.v("Ad state was null when trying to ping manual tracking URLs.");
            return;
        }
        cs.r("Pinging manual tracking URLs.");
        if (this.ee.en.hy == null) return;
        cn.a(this.ee.eh, this.ee.ej.iF, this.ee.en.hy);
    }

    @Override
    public void a(ab ab2) {
        du.B("setAdListener must be called on the main UI thread.");
        this.ee.ek = ab2;
    }

    @Override
    public void a(ae ae2) {
        du.B("setAppEventListener must be called on the main UI thread.");
        this.ee.eo = ae2;
    }

    @Override
    public void a(cj cj2) {
        this.ee.el = null;
        if (cj2.errorCode == -1) {
            return;
        }
        boolean bl2 = cj2.hp.extras != null ? cj2.hp.extras.getBoolean("_noRefresh", false) : false;
        if (this.ee.em.eG) {
            cn.a(cj2.gI);
        } else if (!bl2) {
            if (cj2.fO > 0L) {
                this.ef.a(cj2.hp, cj2.fO);
            } else if (cj2.ip != null && cj2.ip.fO > 0L) {
                this.ef.a(cj2.hp, cj2.ip.fO);
            } else if (!cj2.hw && cj2.errorCode == 2) {
                this.ef.d(cj2.hp);
            }
        }
        if (cj2.errorCode == 3 && cj2.ip != null && cj2.ip.fM != null) {
            cs.r("Pinging no fill URLs.");
            az.a(this.ee.eh, this.ee.ej.iF, cj2, this.ee.adUnitId, false, cj2.ip.fM);
        }
        if (cj2.errorCode != -2) {
            this.a(cj2.errorCode);
            return;
        }
        if (!this.ee.em.eG && !this.b(cj2)) {
            this.a(0);
            return;
        }
        if (this.ee.en != null && this.ee.en.gd != null) {
            this.ee.en.gd.a((av)null);
        }
        if (cj2.gd != null) {
            cj2.gd.a(this);
        }
        this.ee.en = cj2;
        if (cj2.iq != null) {
            this.ee.em = cj2.iq;
        }
        if (!this.ee.em.eG) {
            this.b(false);
        }
        this.L();
    }

    @Override
    public void a(x x2) {
        du.B("setAdSize must be called on the main UI thread.");
        this.ee.em = x2;
        if (this.ee.en != null) {
            this.ee.en.gI.a(x2);
        }
        if (this.ee.eg.getChildCount() > 1) {
            this.ee.eg.removeView(this.ee.eg.getNextView());
        }
        this.ee.eg.setMinimumWidth(x2.widthPixels);
        this.ee.eg.setMinimumHeight(x2.heightPixels);
        this.ee.eg.requestLayout();
    }

    @Override
    public boolean a(v object) {
        du.B("loadAd must be called on the main UI thread.");
        if (this.ee.el != null) {
            cs.v("An ad request is already in progress. Aborting.");
            return false;
        }
        if (this.ee.em.eG && this.ee.en != null) {
            cs.v("An interstitial is already loading. Aborting.");
            return false;
        }
        if (!this.M()) return false;
        cs.t("Starting ad request.");
        this.ef.cancel();
        bz.a a2 = this.c((v)object);
        if (this.ee.em.eG) {
            object = cv.a(this.ee.eh, this.ee.em, false, false, this.ee.ei, this.ee.ej);
            ((cv)((Object)object)).aB().a(this, null, this, this, true);
        } else {
            object = this.ee.eg.getNextView();
            if (object instanceof cv) {
                object = (cv)((Object)object);
                ((cv)((Object)object)).a(this.ee.eh, this.ee.em);
            } else {
                if (object != null) {
                    this.ee.eg.removeView((View)object);
                }
                cv cv2 = cv.a(this.ee.eh, this.ee.em, false, false, this.ee.ei, this.ee.ej);
                object = cv2;
                if (this.ee.em.eH == null) {
                    this.b((View)cv2);
                    object = cv2;
                }
            }
            ((cv)((Object)object)).aB().a(this, this, this, this, false);
        }
        this.ee.el = bu.a(this.ee.eh, a2, this.ee.ei, (cv)((Object)object), this.ed, this);
        return true;
    }

    public void b(v v2) {
        ViewParent viewParent = this.ee.eg.getParent();
        if (viewParent instanceof View && ((View)viewParent).isShown() && cn.as()) {
            this.a(v2);
            return;
        }
        cs.t("Ad is not visible. Not refreshing ad.");
        this.ef.d(v2);
    }

    @Override
    public void destroy() {
        du.B("destroy must be called on the main UI thread.");
        this.ee.ek = null;
        this.ee.eo = null;
        this.ef.cancel();
        this.stopLoading();
        if (this.ee.eg != null) {
            this.ee.eg.removeAllViews();
        }
        if (this.ee.en == null) return;
        if (this.ee.en.gI == null) return;
        this.ee.en.gI.destroy();
    }

    @Override
    public boolean isReady() {
        du.B("isLoaded must be called on the main UI thread.");
        if (this.ee.el != null) return false;
        if (this.ee.en == null) return false;
        return true;
    }

    @Override
    public void onAppEvent(String string2, String string3) {
        if (this.ee.eo == null) return;
        try {
            this.ee.eo.onAppEvent(string2, string3);
            return;
        }
        catch (RemoteException remoteException) {
            cs.b("Could not call the AppEventListener.", remoteException);
            return;
        }
    }

    @Override
    public void pause() {
        du.B("pause must be called on the main UI thread.");
        if (this.ee.en == null) return;
        cn.a(this.ee.en.gI);
    }

    @Override
    public void resume() {
        du.B("resume must be called on the main UI thread.");
        if (this.ee.en == null) return;
        cn.b(this.ee.en.gI);
    }

    @Override
    public void showInterstitial() {
        du.B("showInterstitial must be called on the main UI thread.");
        if (!this.ee.em.eG) {
            cs.v("Cannot call showInterstitial on a banner ad.");
            return;
        }
        if (this.ee.en == null) {
            cs.v("The interstitial has not loaded.");
            return;
        }
        if (this.ee.en.gI.aE()) {
            cs.v("The interstitial is already showing.");
            return;
        }
        this.ee.en.gI.l(true);
        if (!this.ee.en.hw) {
            bm bm2 = new bm(this, this, this, this.ee.en.gI, this.ee.en.orientation, this.ee.ej);
            bk.a(this.ee.eh, bm2);
            return;
        }
        try {
            this.ee.en.gb.showInterstitial();
            return;
        }
        catch (RemoteException remoteException) {
            cs.b("Could not show interstitial.", remoteException);
            this.O();
            return;
        }
    }

    @Override
    public void stopLoading() {
        du.B("stopLoading must be called on the main UI thread.");
        if (this.ee.en != null) {
            this.ee.en.gI.stopLoading();
            this.ee.en = null;
        }
        if (this.ee.el == null) return;
        this.ee.el.cancel();
    }

    @Override
    public void w() {
        this.N();
    }

    @Override
    public b x() {
        du.B("getAdFrame must be called on the main UI thread.");
        return c.h(this.ee.eg);
    }

    @Override
    public x y() {
        du.B("getAdSize must be called on the main UI thread.");
        return this.ee.em;
    }

    @Override
    public void z() {
        this.J();
    }

    private static final class a {
        public final String adUnitId;
        public final ViewSwitcher eg;
        public final Context eh;
        public final h ei;
        public final ct ej;
        public ab ek;
        public cl el;
        public x em;
        public cj en;
        public ae eo;

        public a(Context context, x x2, String string2, ct ct2) {
            if (x2.eG) {
                this.eg = null;
            } else {
                this.eg = new ViewSwitcher(context);
                this.eg.setMinimumWidth(x2.widthPixels);
                this.eg.setMinimumHeight(x2.heightPixels);
                this.eg.setVisibility(4);
            }
            this.em = x2;
            this.adUnitId = string2;
            this.eh = context;
            this.ei = new h(g.a(ct2.iF, context));
            this.ej = ct2;
        }
    }
}

