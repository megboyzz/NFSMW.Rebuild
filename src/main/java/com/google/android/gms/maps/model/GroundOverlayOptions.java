/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 */
package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.internal.du;
import com.google.android.gms.maps.internal.r;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.GroundOverlayOptionsCreator;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.c;

public final class GroundOverlayOptions
implements SafeParcelable {
    public static final GroundOverlayOptionsCreator CREATOR = new GroundOverlayOptionsCreator();
    public static final float NO_DIMENSION = -1.0f;
    private final int kZ;
    private float yA = 0.0f;
    private float yB = 0.5f;
    private float yC = 0.5f;
    private float yl;
    private float ys;
    private boolean yt = true;
    private BitmapDescriptor yv;
    private LatLng yw;
    private float yx;
    private float yy;
    private LatLngBounds yz;

    public GroundOverlayOptions() {
        this.kZ = 1;
    }

    GroundOverlayOptions(int n2, IBinder iBinder, LatLng latLng, float f2, float f3, LatLngBounds latLngBounds, float f4, float f5, boolean bl2, float f6, float f7, float f8) {
        this.kZ = n2;
        this.yv = new BitmapDescriptor(b.a.C(iBinder));
        this.yw = latLng;
        this.yx = f2;
        this.yy = f3;
        this.yz = latLngBounds;
        this.yl = f4;
        this.ys = f5;
        this.yt = bl2;
        this.yA = f6;
        this.yB = f7;
        this.yC = f8;
    }

    private GroundOverlayOptions a(LatLng latLng, float f2, float f3) {
        this.yw = latLng;
        this.yx = f2;
        this.yy = f3;
        return this;
    }

    public GroundOverlayOptions anchor(float f2, float f3) {
        this.yB = f2;
        this.yC = f3;
        return this;
    }

    public GroundOverlayOptions bearing(float f2) {
        this.yl = (f2 % 360.0f + 360.0f) % 360.0f;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    IBinder ej() {
        return this.yv.dP().asBinder();
    }

    public float getAnchorU() {
        return this.yB;
    }

    public float getAnchorV() {
        return this.yC;
    }

    public float getBearing() {
        return this.yl;
    }

    public LatLngBounds getBounds() {
        return this.yz;
    }

    public float getHeight() {
        return this.yy;
    }

    public BitmapDescriptor getImage() {
        return this.yv;
    }

    public LatLng getLocation() {
        return this.yw;
    }

    public float getTransparency() {
        return this.yA;
    }

    int getVersionCode() {
        return this.kZ;
    }

    public float getWidth() {
        return this.yx;
    }

    public float getZIndex() {
        return this.ys;
    }

    public GroundOverlayOptions image(BitmapDescriptor bitmapDescriptor) {
        this.yv = bitmapDescriptor;
        return this;
    }

    public boolean isVisible() {
        return this.yt;
    }

    public GroundOverlayOptions position(LatLng latLng, float f2) {
        boolean bl2 = true;
        boolean bl3 = this.yz == null;
        du.a(bl3, "Position has already been set using positionFromBounds");
        bl3 = latLng != null;
        du.b(bl3, "Location must be specified");
        bl3 = f2 >= 0.0f ? bl2 : false;
        du.b(bl3, "Width must be non-negative");
        return this.a(latLng, f2, -1.0f);
    }

    public GroundOverlayOptions position(LatLng latLng, float f2, float f3) {
        boolean bl2 = true;
        boolean bl3 = this.yz == null;
        du.a(bl3, "Position has already been set using positionFromBounds");
        bl3 = latLng != null;
        du.b(bl3, "Location must be specified");
        bl3 = f2 >= 0.0f;
        du.b(bl3, "Width must be non-negative");
        bl3 = f3 >= 0.0f ? bl2 : false;
        du.b(bl3, "Height must be non-negative");
        return this.a(latLng, f2, f3);
    }

    public GroundOverlayOptions positionFromBounds(LatLngBounds latLngBounds) {
        boolean bl2 = this.yw == null;
        du.a(bl2, "Position has already been set using position: " + this.yw);
        this.yz = latLngBounds;
        return this;
    }

    public GroundOverlayOptions transparency(float f2) {
        boolean bl2 = f2 >= 0.0f && f2 <= 1.0f;
        du.b(bl2, "Transparency must be in the range [0..1]");
        this.yA = f2;
        return this;
    }

    public GroundOverlayOptions visible(boolean bl2) {
        this.yt = bl2;
        return this;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        if (r.eh()) {
            c.a(this, parcel, n2);
            return;
        }
        GroundOverlayOptionsCreator.a(this, parcel, n2);
    }

    public GroundOverlayOptions zIndex(float f2) {
        this.ys = f2;
        return this;
    }
}

