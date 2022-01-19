/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 */
package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.r;
import com.google.android.gms.maps.model.CircleOptionsCreator;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.b;

public final class CircleOptions
implements SafeParcelable {
    public static final CircleOptionsCreator CREATOR = new CircleOptionsCreator();
    private final int kZ;
    private LatLng yn = null;
    private double yo = 0.0;
    private float yp = 10.0f;
    private int yq = -16777216;
    private int yr = 0;
    private float ys = 0.0f;
    private boolean yt = true;

    public CircleOptions() {
        this.kZ = 1;
    }

    CircleOptions(int n2, LatLng latLng, double d2, float f2, int n3, int n4, float f3, boolean bl2) {
        this.kZ = n2;
        this.yn = latLng;
        this.yo = d2;
        this.yp = f2;
        this.yq = n3;
        this.yr = n4;
        this.ys = f3;
        this.yt = bl2;
    }

    public CircleOptions center(LatLng latLng) {
        this.yn = latLng;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public CircleOptions fillColor(int n2) {
        this.yr = n2;
        return this;
    }

    public LatLng getCenter() {
        return this.yn;
    }

    public int getFillColor() {
        return this.yr;
    }

    public double getRadius() {
        return this.yo;
    }

    public int getStrokeColor() {
        return this.yq;
    }

    public float getStrokeWidth() {
        return this.yp;
    }

    int getVersionCode() {
        return this.kZ;
    }

    public float getZIndex() {
        return this.ys;
    }

    public boolean isVisible() {
        return this.yt;
    }

    public CircleOptions radius(double d2) {
        this.yo = d2;
        return this;
    }

    public CircleOptions strokeColor(int n2) {
        this.yq = n2;
        return this;
    }

    public CircleOptions strokeWidth(float f2) {
        this.yp = f2;
        return this;
    }

    public CircleOptions visible(boolean bl2) {
        this.yt = bl2;
        return this;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        if (r.eh()) {
            b.a(this, parcel, n2);
            return;
        }
        CircleOptionsCreator.a(this, parcel, n2);
    }

    public CircleOptions zIndex(float f2) {
        this.ys = f2;
        return this;
    }
}

