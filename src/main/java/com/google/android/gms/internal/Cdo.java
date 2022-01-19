package com.google.android.gms.internal;

import android.util.Log;

/* renamed from: com.google.android.gms.internal.do  reason: invalid class name */
/* loaded from: stdlib.jar:com/google/android/gms/internal/do.class */
public final class Cdo {
    private final String ng;

    public Cdo(String str) {
        this.ng = (String) du.f(str);
    }

    public void a(String str, String str2) {
        if (y(5)) {
            Log.w(str, str2);
        }
    }

    public void a(String str, String str2, Throwable th) {
        if (y(6)) {
            Log.e(str, str2, th);
        }
    }

    public void b(String str, String str2) {
        if (y(6)) {
            Log.e(str, str2);
        }
    }

    public boolean y(int i) {
        return Log.isLoggable(this.ng, i);
    }
}
