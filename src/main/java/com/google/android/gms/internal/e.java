/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.DisplayMetrics
 *  android.view.MotionEvent
 */
package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d;
import com.google.android.gms.internal.hp;
import com.google.android.gms.internal.j;
import com.google.android.gms.internal.k;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public abstract class e
implements d {
    protected MotionEvent du;
    protected DisplayMetrics dv;
    protected j dw;
    private k dx;

    protected e(Context context, j j2, k k2) {
        this.dw = j2;
        this.dx = k2;
        try {
            this.dv = context.getResources().getDisplayMetrics();
            return;
        }
        catch (UnsupportedOperationException unsupportedOperationException) {
            this.dv = new DisplayMetrics();
            this.dv.density = 1.0f;
            return;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    private String a(Context object, String string2, boolean bl2) {
        block12: {
            this.b();
            if (bl2) {
                this.c((Context)object);
            } else {
                this.b((Context)object);
            }
            object = this.c();
            // MONITOREXIT : this
            if (((Context)object).length != 0) break block12;
            return Integer.toString(5);
        }
        try {
            return this.a((byte[])object, string2);
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            return Integer.toString(7);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            return Integer.toString(7);
        }
        catch (IOException iOException) {
            return Integer.toString(3);
        }
    }

    private void b() {
        this.dx.reset();
    }

    private byte[] c() throws IOException {
        return this.dx.h();
    }

    @Override
    public String a(Context context) {
        return this.a(context, null, false);
    }

    @Override
    public String a(Context context, String string2) {
        return this.a(context, string2, true);
    }

    String a(byte[] byArray, String string2) throws NoSuchAlgorithmException, UnsupportedEncodingException, IOException {
        Object object = byArray;
        if (byArray.length > 239) {
            this.b();
            this.a(20, 1L);
            object = this.c();
        }
        if (((byte[])object).length < 239) {
            byArray = new byte[239 - ((byte[])object).length];
            new SecureRandom().nextBytes(byArray);
            byArray = ByteBuffer.allocate(240).put((byte)((byte[])object).length).put((byte[])object).put(byArray).array();
        } else {
            byArray = ByteBuffer.allocate(240).put((byte)((byte[])object).length).put((byte[])object).array();
        }
        object = MessageDigest.getInstance("MD5");
        object.update(byArray);
        object = object.digest();
        byArray = ByteBuffer.allocate(256).put((byte[])object).put(byArray).array();
        object = new byte[256];
        new b().a(byArray, (byte[])object);
        if (string2 == null) return this.dw.a((byte[])object, true);
        if (string2.length() <= 0) return this.dw.a((byte[])object, true);
        this.a(string2, (byte[])object);
        return this.dw.a((byte[])object, true);
    }

    @Override
    public void a(int n2, int n3, int n4) {
        if (this.du != null) {
            this.du.recycle();
        }
        this.du = MotionEvent.obtain((long)0L, (long)n4, (int)1, (float)((float)n2 * this.dv.density), (float)((float)n3 * this.dv.density), (float)0.0f, (float)0.0f, (int)0, (float)0.0f, (float)0.0f, (int)0, (int)0);
    }

    protected void a(int n2, long l2) throws IOException {
        this.dx.b(n2, l2);
    }

    protected void a(int n2, String string2) throws IOException {
        this.dx.b(n2, string2);
    }

    @Override
    public void a(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 1) return;
        if (this.du != null) {
            this.du.recycle();
        }
        this.du = MotionEvent.obtain((MotionEvent)motionEvent);
    }

    void a(String string2, byte[] byArray) throws UnsupportedEncodingException {
        String string3 = string2;
        if (string2.length() > 32) {
            string3 = string2.substring(0, 32);
        }
        new hp(string3.getBytes("UTF-8")).h(byArray);
    }

    protected abstract void b(Context var1);

    protected abstract void c(Context var1);
}

