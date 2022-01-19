/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Color
 *  android.location.Location
 */
package com.google.android.gms.ads.search;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.internal.af;

public final class SearchAdRequest {
    public static final int BORDER_TYPE_DASHED = 1;
    public static final int BORDER_TYPE_DOTTED = 2;
    public static final int BORDER_TYPE_NONE = 0;
    public static final int BORDER_TYPE_SOLID = 3;
    public static final int CALL_BUTTON_COLOR_DARK = 2;
    public static final int CALL_BUTTON_COLOR_LIGHT = 0;
    public static final int CALL_BUTTON_COLOR_MEDIUM = 1;
    public static final String DEVICE_ID_EMULATOR = af.DEVICE_ID_EMULATOR;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    private final af dW;
    private final int jg;
    private final int jh;
    private final int ji;
    private final int jj;
    private final int jk;
    private final int jl;
    private final int jm;
    private final int jn;
    private final String jo;
    private final int jp;
    private final String jq;
    private final int jr;
    private final int js;
    private final String jt;

    private SearchAdRequest(Builder builder) {
        this.jg = builder.jg;
        this.jh = builder.jh;
        this.ji = builder.ji;
        this.jj = builder.jj;
        this.jk = builder.jk;
        this.jl = builder.jl;
        this.jm = builder.jm;
        this.jn = builder.jn;
        this.jo = builder.jo;
        this.jp = builder.jp;
        this.jq = builder.jq;
        this.jr = builder.jr;
        this.js = builder.js;
        this.jt = builder.jt;
        this.dW = new af(builder.dX, this);
    }

    public int getAnchorTextColor() {
        return this.jg;
    }

    public int getBackgroundColor() {
        return this.jh;
    }

    public int getBackgroundGradientBottom() {
        return this.ji;
    }

    public int getBackgroundGradientTop() {
        return this.jj;
    }

    public int getBorderColor() {
        return this.jk;
    }

    public int getBorderThickness() {
        return this.jl;
    }

    public int getBorderType() {
        return this.jm;
    }

    public int getCallButtonColor() {
        return this.jn;
    }

    public String getCustomChannels() {
        return this.jo;
    }

    public int getDescriptionTextColor() {
        return this.jp;
    }

    public String getFontFace() {
        return this.jq;
    }

    public int getHeaderTextColor() {
        return this.jr;
    }

    public int getHeaderTextSize() {
        return this.js;
    }

    public Location getLocation() {
        return this.dW.getLocation();
    }

    public <T extends NetworkExtras> T getNetworkExtras(Class<T> clazz) {
        return this.dW.getNetworkExtras(clazz);
    }

    public String getQuery() {
        return this.jt;
    }

    public boolean isTestDevice(Context context) {
        return this.dW.isTestDevice(context);
    }

    af v() {
        return this.dW;
    }

    public static final class Builder {
        private final af.a dX = new af.a();
        private int jg;
        private int jh;
        private int ji;
        private int jj;
        private int jk;
        private int jl;
        private int jm = 0;
        private int jn;
        private String jo;
        private int jp;
        private String jq;
        private int jr;
        private int js;
        private String jt;

        public Builder addNetworkExtras(NetworkExtras networkExtras) {
            this.dX.a(networkExtras);
            return this;
        }

        public Builder addTestDevice(String string) {
            this.dX.h(string);
            return this;
        }

        public SearchAdRequest build() {
            return new SearchAdRequest(this);
        }

        public Builder setAnchorTextColor(int n2) {
            this.jg = n2;
            return this;
        }

        public Builder setBackgroundColor(int n2) {
            this.jh = n2;
            this.ji = Color.argb((int)0, (int)0, (int)0, (int)0);
            this.jj = Color.argb((int)0, (int)0, (int)0, (int)0);
            return this;
        }

        public Builder setBackgroundGradient(int n2, int n3) {
            this.jh = Color.argb((int)0, (int)0, (int)0, (int)0);
            this.ji = n3;
            this.jj = n2;
            return this;
        }

        public Builder setBorderColor(int n2) {
            this.jk = n2;
            return this;
        }

        public Builder setBorderThickness(int n2) {
            this.jl = n2;
            return this;
        }

        public Builder setBorderType(int n2) {
            this.jm = n2;
            return this;
        }

        public Builder setCallButtonColor(int n2) {
            this.jn = n2;
            return this;
        }

        public Builder setCustomChannels(String string) {
            this.jo = string;
            return this;
        }

        public Builder setDescriptionTextColor(int n2) {
            this.jp = n2;
            return this;
        }

        public Builder setFontFace(String string) {
            this.jq = string;
            return this;
        }

        public Builder setHeaderTextColor(int n2) {
            this.jr = n2;
            return this;
        }

        public Builder setHeaderTextSize(int n2) {
            this.js = n2;
            return this;
        }

        public Builder setLocation(Location location) {
            this.dX.a(location);
            return this;
        }

        public Builder setQuery(String string) {
            this.jt = string;
            return this;
        }

        public Builder tagForChildDirectedTreatment(boolean bl2) {
            this.dX.e(bl2);
            return this;
        }
    }
}

