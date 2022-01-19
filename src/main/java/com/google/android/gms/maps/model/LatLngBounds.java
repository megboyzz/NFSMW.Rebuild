/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 */
package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ds;
import com.google.android.gms.internal.du;
import com.google.android.gms.maps.internal.r;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBoundsCreator;
import com.google.android.gms.maps.model.d;

public final class LatLngBounds
implements SafeParcelable {
    public static final LatLngBoundsCreator CREATOR = new LatLngBoundsCreator();
    private final int kZ;
    public final LatLng northeast;
    public final LatLng southwest;

    LatLngBounds(int n2, LatLng latLng, LatLng latLng2) {
        du.c(latLng, "null southwest");
        du.c(latLng2, "null northeast");
        boolean bl2 = latLng2.latitude >= latLng.latitude;
        du.a(bl2, "southern latitude exceeds northern latitude (%s > %s)", latLng.latitude, latLng2.latitude);
        this.kZ = n2;
        this.southwest = latLng;
        this.northeast = latLng2;
    }

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        this(1, latLng, latLng2);
    }

    private boolean a(double d2) {
        if (!(this.southwest.latitude <= d2)) return false;
        if (!(d2 <= this.northeast.latitude)) return false;
        return true;
    }

    private static double b(double d2, double d3) {
        return (d2 - d3 + 360.0) % 360.0;
    }

    private boolean b(double d2) {
        boolean bl2 = false;
        if (this.southwest.longitude <= this.northeast.longitude) {
            if (!(this.southwest.longitude <= d2)) return false;
            if (!(d2 <= this.northeast.longitude)) return false;
            return true;
        }
        if (this.southwest.longitude <= d2) return true;
        if (!(d2 <= this.northeast.longitude)) return bl2;
        return true;
    }

    public static Builder builder() {
        return new Builder();
    }

    private static double c(double d2, double d3) {
        return (d3 - d2 + 360.0) % 360.0;
    }

    public boolean contains(LatLng latLng) {
        if (!this.a(latLng.latitude)) return false;
        if (!this.b(latLng.longitude)) return false;
        return true;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof LatLngBounds)) {
            return false;
        }
        object = (LatLngBounds)object;
        if (!this.southwest.equals(((LatLngBounds)object).southwest)) return false;
        if (this.northeast.equals(((LatLngBounds)object).northeast)) return true;
        return false;
    }

    public LatLng getCenter() {
        double d2 = (this.southwest.latitude + this.northeast.latitude) / 2.0;
        double d3 = this.southwest.longitude;
        double d4 = this.northeast.longitude;
        if (d3 <= d4) {
            d4 = (d4 + d3) / 2.0;
            return new LatLng(d2, d4);
        }
        d4 = (d4 + 360.0 + d3) / 2.0;
        return new LatLng(d2, d4);
    }

    int getVersionCode() {
        return this.kZ;
    }

    public int hashCode() {
        return ds.hashCode(this.southwest, this.northeast);
    }

    public LatLngBounds including(LatLng latLng) {
        double d2 = Math.min(this.southwest.latitude, latLng.latitude);
        double d3 = Math.max(this.northeast.latitude, latLng.latitude);
        double d4 = this.northeast.longitude;
        double d5 = this.southwest.longitude;
        double d6 = latLng.longitude;
        if (this.b(d6)) {
            d6 = d5;
            return new LatLngBounds(new LatLng(d2, d6), new LatLng(d3, d4));
        }
        if (LatLngBounds.b(d5, d6) < LatLngBounds.c(d4, d6)) {
            return new LatLngBounds(new LatLng(d2, d6), new LatLng(d3, d4));
        }
        d4 = d6;
        d6 = d5;
        return new LatLngBounds(new LatLng(d2, d6), new LatLng(d3, d4));
    }

    public String toString() {
        return ds.e(this).a("southwest", this.southwest).a("northeast", this.northeast).toString();
    }

    public void writeToParcel(Parcel parcel, int n2) {
        if (r.eh()) {
            d.a(this, parcel, n2);
            return;
        }
        LatLngBoundsCreator.a(this, parcel, n2);
    }

    public static final class Builder {
        private double yD = Double.POSITIVE_INFINITY;
        private double yE = Double.NEGATIVE_INFINITY;
        private double yF = Double.NaN;
        private double yG = Double.NaN;

        private boolean b(double d2) {
            boolean bl2 = false;
            if (this.yF <= this.yG) {
                if (!(this.yF <= d2)) return false;
                if (!(d2 <= this.yG)) return false;
                return true;
            }
            if (this.yF <= d2) return true;
            if (!(d2 <= this.yG)) return bl2;
            return true;
        }

        public LatLngBounds build() {
            boolean bl2 = !Double.isNaN(this.yF);
            du.a(bl2, "no included points");
            return new LatLngBounds(new LatLng(this.yD, this.yF), new LatLng(this.yE, this.yG));
        }

        public Builder include(LatLng latLng) {
            this.yD = Math.min(this.yD, latLng.latitude);
            this.yE = Math.max(this.yE, latLng.latitude);
            double d2 = latLng.longitude;
            if (Double.isNaN(this.yF)) {
                this.yF = d2;
                this.yG = d2;
                return this;
            }
            if (this.b(d2)) return this;
            if (LatLngBounds.b(this.yF, d2) < LatLngBounds.c(this.yG, d2)) {
                this.yF = d2;
                return this;
            }
            this.yG = d2;
            return this;
        }
    }
}

