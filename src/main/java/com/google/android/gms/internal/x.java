/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Parcel
 *  android.util.DisplayMetrics
 */
package com.google.android.gms.internal;

import android.content.Context;
import android.os.Parcel;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.cr;
import com.google.android.gms.internal.y;

public final class x
implements SafeParcelable {
    public static final y CREATOR = new y();
    public final String eF;
    public final boolean eG;
    public final x[] eH;
    public final int height;
    public final int heightPixels;
    public final int versionCode;
    public final int width;
    public final int widthPixels;

    public x() {
        this(2, "interstitial_mb", 0, 0, true, 0, 0, null);
    }

    x(int n2, String string2, int n3, int n4, boolean bl2, int n5, int n6, x[] xArray) {
        this.versionCode = n2;
        this.eF = string2;
        this.height = n3;
        this.heightPixels = n4;
        this.eG = bl2;
        this.width = n5;
        this.widthPixels = n6;
        this.eH = xArray;
    }

    public x(Context context, AdSize adSize) {
        this(context, new AdSize[]{adSize});
    }

    public x(Context context, AdSize[] adSizeArray) {
        int n2;
        int n3 = 0;
        AdSize adSize = adSizeArray[0];
        this.versionCode = 2;
        this.eG = false;
        this.width = adSize.getWidth();
        this.height = adSize.getHeight();
        int n4 = this.width == -1 ? 1 : 0;
        boolean bl2 = this.height == -2;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (n4 != 0) {
            this.widthPixels = x.a(displayMetrics);
            n2 = (int)((float)this.widthPixels / displayMetrics.density);
        } else {
            n2 = this.width;
            this.widthPixels = cr.a(displayMetrics, this.width);
        }
        int n5 = bl2 ? x.c(displayMetrics) : this.height;
        this.heightPixels = cr.a(displayMetrics, n5);
        this.eF = n4 != 0 || bl2 ? n2 + "x" + n5 + "_as" : adSize.toString();
        if (adSizeArray.length <= 1) {
            this.eH = null;
            return;
        }
        this.eH = new x[adSizeArray.length];
        n4 = n3;
        while (n4 < adSizeArray.length) {
            this.eH[n4] = new x(context, adSizeArray[n4]);
            ++n4;
        }
    }

    public x(x x2, x[] xArray) {
        this(2, x2.eF, x2.height, x2.heightPixels, x2.eG, x2.width, x2.widthPixels, xArray);
    }

    public static int a(DisplayMetrics displayMetrics) {
        return displayMetrics.widthPixels;
    }

    public static int b(DisplayMetrics displayMetrics) {
        return (int)((float)x.c(displayMetrics) * displayMetrics.density);
    }

    private static int c(DisplayMetrics displayMetrics) {
        int n2 = (int)((float)displayMetrics.heightPixels / displayMetrics.density);
        if (n2 <= 400) {
            return 32;
        }
        if (n2 > 720) return 90;
        return 50;
    }

    public AdSize P() {
        return a.a(this.width, this.height, this.eF);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        y.a(this, parcel, n2);
    }
}

