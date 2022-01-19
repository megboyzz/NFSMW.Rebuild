/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Handler
 *  android.os.HandlerThread
 */
package com.eamobile.licensing;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.android.vending.licensing.as;
import com.android.vending.licensing.bd;
import com.eamobile.licensing.ILicenseServerActivityCallback;
import com.eamobile.licensing.a;
import com.eamobile.licensing.b;
import com.eamobile.licensing.d;
import com.eamobile.licensing.g;
import com.eamobile.licensing.h;
import com.eamobile.licensing.i;
import com.eamobile.licensing.j;
import com.eamobile.licensing.k;
import com.eamobile.licensing.l;
import com.eamobile.licensing.m;
import com.eamobile.licensing.n;
import com.eamobile.licensing.o;
import com.eamobile.licensing.q;
import com.eamobile.licensing.r;
import com.eamobile.licensing.z;
import java.util.ArrayList;

public class LicenseServerActivity {
    private static boolean G = false;
    private static Activity H;
    private static int M = 0;
    private static int N = 0;
    public static final String a = "com.android.vending.licensing.eapref";
    static final int k = -1;
    static final int l = 13;
    static final int m = 14;
    static final int n = 15;
    static final int o = 16;
    static final int p = 17;
    static final int q = 18;
    static final int r = 19;
    static final int s = 20;
    static final int t = 21;
    protected static final String u = "licenseserver/";
    protected static g v;
    private static LicenseServerActivity y;
    private as A;
    private String B;
    private Context C;
    private String D;
    private Handler E = null;
    private boolean F = false;
    private b I;
    private d J;
    private a K;
    private String L;
    private String O = "en";
    public q b;
    public bd c;
    byte[] d;
    String e;
    public Handler f = null;
    Handler g = null;
    public Handler h = null;
    public Handler i = null;
    public String j;
    ILicenseServerActivityCallback w = null;
    ArrayList x = new ArrayList();
    private r z;

    static {
        y = null;
        G = false;
        M = -1;
        N = -1;
    }

    private LicenseServerActivity() {
    }

    static /* synthetic */ Handler a(LicenseServerActivity licenseServerActivity) {
        return licenseServerActivity.E;
    }

    static /* synthetic */ as a(LicenseServerActivity licenseServerActivity, as as2) {
        licenseServerActivity.A = as2;
        return as2;
    }

    static /* synthetic */ String a(LicenseServerActivity licenseServerActivity, String string2) {
        licenseServerActivity.D = string2;
        return string2;
    }

    protected static Activity b() {
        return H;
    }

    static /* synthetic */ String b(LicenseServerActivity licenseServerActivity) {
        return licenseServerActivity.L;
    }

    static /* synthetic */ r c(LicenseServerActivity licenseServerActivity) {
        return licenseServerActivity.z;
    }

    static /* synthetic */ String d(LicenseServerActivity licenseServerActivity) {
        return licenseServerActivity.D;
    }

    static /* synthetic */ Context e(LicenseServerActivity licenseServerActivity) {
        return licenseServerActivity.C;
    }

    static /* synthetic */ String f(LicenseServerActivity licenseServerActivity) {
        return licenseServerActivity.B;
    }

    static /* synthetic */ as g(LicenseServerActivity licenseServerActivity) {
        return licenseServerActivity.A;
    }

    private void g() {
        if (this.A != null) {
            this.A.a();
            this.A = null;
        }
        H = null;
        y = null;
    }

    public static LicenseServerActivity getInstance() {
        if (y != null) return y;
        y = new LicenseServerActivity();
        return y;
    }

    private void h() {
        if (this.K != null) {
            this.K.b();
        }
        if (this.J == null) return;
        this.J.b();
    }

    public boolean LastCheckPointCheck() {
        if (!this.c.a().a().equals(this.L)) return false;
        return true;
    }

    public void a() {
        this.f.post((Runnable)new n(this));
    }

    /*
     * Exception decompiling
     */
    public void a(int var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 1[TRYBLOCK] [4 : 119->153)] java.lang.Exception
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2283)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:415)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompileToZip(CFRDecompiler.java:306)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.lambda$null$1(ResourceDecompiling.java:114)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling$$Lambda$144/691390785.run(Unknown Source)
         *     at java.lang.Thread.run(Unknown Source)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    protected void a(Context context) {
        if (this.K == null) {
            this.K = new a(context);
        }
        if (this.J != null) return;
        this.J = new d(context);
    }

    public void c() {
    }

    public int d() {
        return M;
    }

    public void destroyLicenseServerActvity() {
        this.h();
        G = false;
        M = -1;
        this.g();
    }

    protected int e() {
        return N;
    }

    protected void f() {
        this.h();
        G = false;
        M = -1;
        this.g();
    }

    public void initLicenseServerActivity(Activity object, ILicenseServerActivityCallback iLicenseServerActivityCallback, Context context, byte[] object2, String string2, String string3, String string4) {
        if (this.F) {
            return;
        }
        this.F = true;
        this.L = string4;
        if (this.L == null) {
            this.L = "001";
        }
        this.g = new h(this);
        this.B = string3;
        this.C = context;
        this.d = object2;
        this.e = string2;
        this.E = new i(this);
        this.h = new j(this);
        this.i = new k(this);
        object2 = new HandlerThread("waitting thread");
        object2.start();
        this.f = new Handler(object2.getLooper());
        this.b = new q(this, null);
        this.z = new r(this, null);
        this.x.add(new l(this));
        this.x.add(new m(this));
        this.f.post((Runnable)new o(this));
        if (H == null) {
            H = object;
            this.w = iLicenseServerActivityCallback;
        }
        if (v == null) {
            v = new g();
            this.O = context.getResources().getConfiguration().locale.toString();
            object = context.getResources().getConfiguration().locale.getLanguage();
            com.eamobile.licensing.z.a("Locale>>>>>:" + this.O);
            com.eamobile.licensing.z.a("Language>>>>>:" + (String)object);
            if (!v.a(this.O) && !v.a((String)object)) {
                this.O = "en";
                v.a("en");
            }
        }
        this.a(context);
        if (G) return;
        G = true;
        this.a(20);
    }
}

