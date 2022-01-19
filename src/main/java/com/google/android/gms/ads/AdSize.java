/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.internal.cr;
import com.google.android.gms.internal.x;

public final class AdSize {
    public static final int AUTO_HEIGHT = -2;
    public static final AdSize BANNER = new AdSize(320, 50, "320x50_mb");
    public static final AdSize FULL_BANNER = new AdSize(468, 60, "468x60_as");
    public static final int FULL_WIDTH = -1;
    public static final AdSize LEADERBOARD = new AdSize(728, 90, "728x90_as");
    public static final AdSize MEDIUM_RECTANGLE = new AdSize(300, 250, "300x250_as");
    public static final AdSize SMART_BANNER;
    public static final AdSize WIDE_SKYSCRAPER;
    private final String dY;
    private final int v;
    private final int w;

    static {
        WIDE_SKYSCRAPER = new AdSize(160, 600, "160x600_as");
        SMART_BANNER = new AdSize(-1, -2, "smart_banner");
    }

    public AdSize(int n2, int n3) {
        StringBuilder stringBuilder = new StringBuilder();
        String string = n2 == -1 ? "FULL" : String.valueOf(n2);
        stringBuilder = stringBuilder.append(string).append("x");
        string = n3 == -2 ? "AUTO" : String.valueOf(n3);
        this(n2, n3, stringBuilder.append(string).append("_as").toString());
    }

    AdSize(int n2, int n3, String string) {
        if (n2 < 0 && n2 != -1) {
            throw new IllegalArgumentException("Invalid width for AdSize: " + n2);
        }
        if (n3 < 0 && n3 != -2) {
            throw new IllegalArgumentException("Invalid height for AdSize: " + n3);
        }
        this.w = n2;
        this.v = n3;
        this.dY = string;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof AdSize)) {
            return false;
        }
        object = (AdSize)object;
        if (this.w != ((AdSize)object).w) return false;
        if (this.v != ((AdSize)object).v) return false;
        if (this.dY.equals(((AdSize)object).dY)) return true;
        return false;
    }

    public int getHeight() {
        return this.v;
    }

    public int getHeightInPixels(Context context) {
        if (this.v != -2) return cr.a(context, this.v);
        return x.b(context.getResources().getDisplayMetrics());
    }

    public int getWidth() {
        return this.w;
    }

    public int getWidthInPixels(Context context) {
        if (this.w != -1) return cr.a(context, this.w);
        return x.a(context.getResources().getDisplayMetrics());
    }

    public int hashCode() {
        return this.dY.hashCode();
    }

    public boolean isAutoHeight() {
        if (this.v != -2) return false;
        return true;
    }

    public boolean isFullWidth() {
        if (this.w != -1) return false;
        return true;
    }

    public String toString() {
        return this.dY;
    }
}

