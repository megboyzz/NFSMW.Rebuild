/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.location.Location
 */
package com.google.android.gms.ads;

import android.content.Context;
import android.location.Location;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.internal.af;
import java.util.Date;
import java.util.Set;

public final class AdRequest {
    public static final String DEVICE_ID_EMULATOR = af.DEVICE_ID_EMULATOR;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    public static final int GENDER_FEMALE = 2;
    public static final int GENDER_MALE = 1;
    public static final int GENDER_UNKNOWN = 0;
    private final af dW;

    private AdRequest(Builder builder) {
        this.dW = new af(builder.dX);
    }

    public Date getBirthday() {
        return this.dW.getBirthday();
    }

    public int getGender() {
        return this.dW.getGender();
    }

    public Set<String> getKeywords() {
        return this.dW.getKeywords();
    }

    public Location getLocation() {
        return this.dW.getLocation();
    }

    public <T extends NetworkExtras> T getNetworkExtras(Class<T> clazz) {
        return this.dW.getNetworkExtras(clazz);
    }

    public boolean isTestDevice(Context context) {
        return this.dW.isTestDevice(context);
    }

    af v() {
        return this.dW;
    }

    public static final class Builder {
        private final af.a dX = new af.a();

        public Builder addKeyword(String string) {
            this.dX.g(string);
            return this;
        }

        public Builder addNetworkExtras(NetworkExtras networkExtras) {
            this.dX.a(networkExtras);
            return this;
        }

        public Builder addTestDevice(String string) {
            this.dX.h(string);
            return this;
        }

        public AdRequest build() {
            return new AdRequest(this);
        }

        public Builder setBirthday(Date date) {
            this.dX.a(date);
            return this;
        }

        public Builder setGender(int n2) {
            this.dX.d(n2);
            return this;
        }

        public Builder setLocation(Location location) {
            this.dX.a(location);
            return this;
        }

        public Builder tagForChildDirectedTreatment(boolean bl2) {
            this.dX.e(bl2);
            return this;
        }
    }
}

