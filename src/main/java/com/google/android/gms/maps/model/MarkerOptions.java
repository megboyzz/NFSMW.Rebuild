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
import com.google.android.gms.maps.internal.r;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptionsCreator;
import com.google.android.gms.maps.model.f;

public final class MarkerOptions
implements SafeParcelable {
    public static final MarkerOptionsCreator CREATOR = new MarkerOptionsCreator();
    private final int kZ;
    private float mAlpha = 1.0f;
    private String oa;
    private float yB = 0.5f;
    private float yC = 1.0f;
    private LatLng yI;
    private String yJ;
    private BitmapDescriptor yK;
    private boolean yL;
    private boolean yM = false;
    private float yN = 0.0f;
    private float yO = 0.5f;
    private float yP = 0.0f;
    private boolean yt = true;

    public MarkerOptions() {
        this.kZ = 1;
    }

    MarkerOptions(int n2, LatLng object, String string2, String string3, IBinder iBinder, float f2, float f3, boolean bl2, boolean bl3, boolean bl4, float f4, float f5, float f6, float f7) {
        this.kZ = n2;
        this.yI = object;
        this.oa = string2;
        this.yJ = string3;
        object = iBinder == null ? null : new BitmapDescriptor(b.a.C(iBinder));
        this.yK = object;
        this.yB = f2;
        this.yC = f3;
        this.yL = bl2;
        this.yt = bl3;
        this.yM = bl4;
        this.yN = f4;
        this.yO = f5;
        this.yP = f6;
        this.mAlpha = f7;
    }

    public MarkerOptions alpha(float f2) {
        this.mAlpha = f2;
        return this;
    }

    public MarkerOptions anchor(float f2, float f3) {
        this.yB = f2;
        this.yC = f3;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public MarkerOptions draggable(boolean bl2) {
        this.yL = bl2;
        return this;
    }

    IBinder ek() {
        if (this.yK != null) return this.yK.dP().asBinder();
        return null;
    }

    public MarkerOptions flat(boolean bl2) {
        this.yM = bl2;
        return this;
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    public float getAnchorU() {
        return this.yB;
    }

    public float getAnchorV() {
        return this.yC;
    }

    public BitmapDescriptor getIcon() {
        return this.yK;
    }

    public float getInfoWindowAnchorU() {
        return this.yO;
    }

    public float getInfoWindowAnchorV() {
        return this.yP;
    }

    public LatLng getPosition() {
        return this.yI;
    }

    public float getRotation() {
        return this.yN;
    }

    public String getSnippet() {
        return this.yJ;
    }

    public String getTitle() {
        return this.oa;
    }

    int getVersionCode() {
        return this.kZ;
    }

    public MarkerOptions icon(BitmapDescriptor bitmapDescriptor) {
        this.yK = bitmapDescriptor;
        return this;
    }

    public MarkerOptions infoWindowAnchor(float f2, float f3) {
        this.yO = f2;
        this.yP = f3;
        return this;
    }

    public boolean isDraggable() {
        return this.yL;
    }

    public boolean isFlat() {
        return this.yM;
    }

    public boolean isVisible() {
        return this.yt;
    }

    public MarkerOptions position(LatLng latLng) {
        this.yI = latLng;
        return this;
    }

    public MarkerOptions rotation(float f2) {
        this.yN = f2;
        return this;
    }

    public MarkerOptions snippet(String string2) {
        this.yJ = string2;
        return this;
    }

    public MarkerOptions title(String string2) {
        this.oa = string2;
        return this;
    }

    public MarkerOptions visible(boolean bl2) {
        this.yt = bl2;
        return this;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        if (r.eh()) {
            f.a(this, parcel, n2);
            return;
        }
        MarkerOptionsCreator.a(this, parcel, n2);
    }
}

