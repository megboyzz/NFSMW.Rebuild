/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.DisplayMetrics
 *  android.view.MotionEvent
 *  dalvik.system.DexClassLoader
 */
package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.google.android.gms.internal.e;
import com.google.android.gms.internal.j;
import com.google.android.gms.internal.k;
import com.google.android.gms.internal.l;
import com.google.android.gms.internal.n;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public abstract class f
extends e {
    private static Method dA;
    private static Method dB;
    private static Method dC;
    private static Method dD;
    private static String dE;
    private static l dF;
    static boolean dG;
    private static Method dy;
    private static Method dz;
    private static long startTime;

    static {
        startTime = 0L;
        dG = false;
    }

    protected f(Context context, j j2, k k2) {
        super(context, j2, k2);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled unnecessary exception pruning
     */
    static String a(Context object, j j2) throws a {
        if (dA == null) {
            throw new a();
        }
        try {
            object = (ByteBuffer)dA.invoke(null, object);
            if (object != null) return j2.a(((ByteBuffer)object).array(), true);
            throw new a();
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new a(illegalAccessException);
        }
        catch (InvocationTargetException invocationTargetException) {
            throw new a(invocationTargetException);
        }
    }

    static ArrayList<Long> a(MotionEvent object, DisplayMetrics displayMetrics) throws a {
        if (dB == null) throw new a();
        if (object == null) {
            throw new a();
        }
        try {
            return (ArrayList)dB.invoke(null, object, displayMetrics);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new a(illegalAccessException);
        }
        catch (InvocationTargetException invocationTargetException) {
            throw new a(invocationTargetException);
        }
    }

    protected static void a(String string2, Context context, j j2) {
        synchronized (f.class) {
            boolean bl2 = dG;
            if (bl2) return;
            try {
                dF = new l(j2, null);
                dE = string2;
                f.e(context);
                startTime = f.e();
                dG = true;
                return;
            }
            catch (UnsupportedOperationException unsupportedOperationException) {
                return;
            }
            catch (a a2) {
                return;
            }
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled unnecessary exception pruning
     */
    static String b(Context object, j j2) throws a {
        if (dD == null) {
            throw new a();
        }
        try {
            object = (ByteBuffer)dD.invoke(null, object);
            if (object != null) return j2.a(((ByteBuffer)object).array(), true);
            throw new a();
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new a(illegalAccessException);
        }
        catch (InvocationTargetException invocationTargetException) {
            throw new a(invocationTargetException);
        }
    }

    private static String b(byte[] object, String string2) throws a {
        try {
            return new String(dF.c((byte[])object, string2), "UTF-8");
        }
        catch (l.a a2) {
            throw new a(a2);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new a(unsupportedEncodingException);
        }
    }

    static String d() throws a {
        if (dE != null) return dE;
        throw new a();
    }

    static String d(Context object) throws a {
        if (dC == null) {
            throw new a();
        }
        try {
            object = (String)dC.invoke(null, object);
            if (object != null) return object;
            throw new a();
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new a(illegalAccessException);
        }
        catch (InvocationTargetException invocationTargetException) {
            throw new a(invocationTargetException);
        }
    }

    static Long e() throws a {
        if (dy == null) {
            throw new a();
        }
        try {
            return (Long)dy.invoke(null, new Object[0]);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new a(illegalAccessException);
        }
        catch (InvocationTargetException invocationTargetException) {
            throw new a(invocationTargetException);
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled unnecessary exception pruning
     */
    private static void e(Context object) throws a {
        File file;
        File file2;
        Object object2;
        byte[] byArray;
        try {
            byArray = dF.d(n.getKey());
            object2 = dF.c(byArray, n.i());
            file = file2 = object.getCacheDir();
            if (file2 == null) {
                file = file2 = object.getDir("dex", 0);
                if (file2 == null) {
                    throw new a();
                }
            }
        }
        catch (FileNotFoundException fileNotFoundException) {
            throw new a(fileNotFoundException);
        }
        catch (IOException iOException) {
            throw new a(iOException);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new a(classNotFoundException);
        }
        catch (l.a a2) {
            throw new a(a2);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new a(noSuchMethodException);
        }
        catch (NullPointerException nullPointerException) {
            throw new a(nullPointerException);
        }
        {
            file2 = File.createTempFile("ads", ".jar", file);
            Object object3 = new FileOutputStream(file2);
            ((FileOutputStream)object3).write((byte[])object2, 0, ((byte[])object2).length);
            ((FileOutputStream)object3).close();
            Object object4 = new DexClassLoader(file2.getAbsolutePath(), file.getAbsolutePath(), null, object.getClassLoader());
            object = object4.loadClass(f.b(byArray, n.j()));
            object2 = object4.loadClass(f.b(byArray, n.p()));
            object3 = object4.loadClass(f.b(byArray, n.n()));
            Class clazz = object4.loadClass(f.b(byArray, n.t()));
            Class clazz2 = object4.loadClass(f.b(byArray, n.l()));
            object4 = object4.loadClass(f.b(byArray, n.r()));
            dy = ((Class)object).getMethod(f.b(byArray, n.k()), new Class[0]);
            dz = ((Class)object2).getMethod(f.b(byArray, n.q()), new Class[0]);
            dA = ((Class)object3).getMethod(f.b(byArray, n.o()), Context.class);
            dB = clazz.getMethod(f.b(byArray, n.u()), MotionEvent.class, DisplayMetrics.class);
            dC = clazz2.getMethod(f.b(byArray, n.m()), Context.class);
            dD = ((Class)object4).getMethod(f.b(byArray, n.s()), Context.class);
            object = file2.getName();
            file2.delete();
            new File(file, ((String)object).replace(".jar", ".dex")).delete();
            return;
        }
    }

    static String f() throws a {
        if (dz == null) {
            throw new a();
        }
        try {
            return (String)dz.invoke(null, new Object[0]);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new a(illegalAccessException);
        }
        catch (InvocationTargetException invocationTargetException) {
            throw new a(invocationTargetException);
        }
    }

    @Override
    protected void b(Context context) {
        try {
            try {
                this.a(1, f.f());
            }
            catch (a a2) {}
            try {
                this.a(2, f.d());
            }
            catch (a a3) {}
            try {
                this.a(25, f.e());
            }
            catch (a a4) {}
            try {
                this.a(24, f.d(context));
                return;
            }
            catch (a a5) {
                return;
            }
        }
        catch (IOException iOException) {
            return;
        }
    }

    @Override
    protected void c(Context context) {
        try {
            try {
                this.a(2, f.d());
            }
            catch (a a2) {}
            try {
                this.a(1, f.f());
            }
            catch (a a3) {}
            try {
                long l2 = f.e();
                this.a(25, l2);
                if (startTime != 0L) {
                    this.a(17, l2 - startTime);
                    this.a(23, startTime);
                }
            }
            catch (a a4) {}
            try {
                ArrayList<Long> arrayList = f.a(this.du, this.dv);
                this.a(14, arrayList.get(0));
                this.a(15, arrayList.get(1));
                if (arrayList.size() >= 3) {
                    this.a(16, arrayList.get(2));
                }
            }
            catch (a a5) {}
            try {
                this.a(27, f.a(context, this.dw));
            }
            catch (a a6) {}
            try {
                this.a(29, f.b(context, this.dw));
                return;
            }
            catch (a a7) {
                return;
            }
        }
        catch (IOException iOException) {
            return;
        }
    }

    static class a
    extends Exception {
        public a() {
        }

        public a(Throwable throwable) {
            super(throwable);
        }
    }
}

