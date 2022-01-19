/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public abstract class dj
implements SafeParcelable {
    private static final Object mw = new Object();
    private static ClassLoader mx = null;
    private static Integer my = null;
    private boolean mz = false;

    protected static boolean D(String string2) {
        ClassLoader classLoader = dj.bx();
        if (classLoader == null) {
            return true;
        }
        try {
            return dj.a(classLoader.loadClass(string2));
        }
        catch (Exception exception) {
            return false;
        }
    }

    private static boolean a(Class<?> clazz) {
        try {
            return "SAFE_PARCELABLE_NULL_STRING".equals(clazz.getField("NULL").get(null));
        }
        catch (IllegalAccessException illegalAccessException) {
            return false;
        }
        catch (NoSuchFieldException noSuchFieldException) {
            return false;
        }
    }

    protected static ClassLoader bx() {
        Object object = mw;
        synchronized (object) {
            return mx;
        }
    }

    protected static Integer by() {
        Object object = mw;
        synchronized (object) {
            return my;
        }
    }

    protected boolean bz() {
        return this.mz;
    }
}

