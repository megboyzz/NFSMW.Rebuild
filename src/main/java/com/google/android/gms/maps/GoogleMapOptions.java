/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.os.Parcel
 *  com.google.android.gms.R$styleable
 */
package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.GoogleMapOptionsCreator;
import com.google.android.gms.maps.a;
import com.google.android.gms.maps.internal.r;
import com.google.android.gms.maps.model.CameraPosition;

public final class GoogleMapOptions
implements SafeParcelable {
    public static final GoogleMapOptionsCreator CREATOR = new GoogleMapOptionsCreator();
    private final int kZ;
    private Boolean xF;
    private Boolean xG;
    private int xH = -1;
    private CameraPosition xI;
    private Boolean xJ;
    private Boolean xK;
    private Boolean xL;
    private Boolean xM;
    private Boolean xN;
    private Boolean xO;

    public GoogleMapOptions() {
        this.kZ = 1;
    }

    GoogleMapOptions(int n2, byte by2, byte by3, int n3, CameraPosition cameraPosition, byte by4, byte by5, byte by6, byte by7, byte by8, byte by9) {
        this.kZ = n2;
        this.xF = com.google.android.gms.maps.internal.a.a(by2);
        this.xG = com.google.android.gms.maps.internal.a.a(by3);
        this.xH = n3;
        this.xI = cameraPosition;
        this.xJ = com.google.android.gms.maps.internal.a.a(by4);
        this.xK = com.google.android.gms.maps.internal.a.a(by5);
        this.xL = com.google.android.gms.maps.internal.a.a(by6);
        this.xM = com.google.android.gms.maps.internal.a.a(by7);
        this.xN = com.google.android.gms.maps.internal.a.a(by8);
        this.xO = com.google.android.gms.maps.internal.a.a(by9);
    }

    public static GoogleMapOptions createFromAttributes(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return null;
        }
        TypedArray typedArray = context.getResources().obtainAttributes(attributeSet, R.styleable.MapAttrs);
        GoogleMapOptions googleMapOptions = new GoogleMapOptions();
        if (typedArray.hasValue(0)) {
            googleMapOptions.mapType(typedArray.getInt(0, -1));
        }
        if (typedArray.hasValue(13)) {
            googleMapOptions.zOrderOnTop(typedArray.getBoolean(13, false));
        }
        if (typedArray.hasValue(12)) {
            googleMapOptions.useViewLifecycleInFragment(typedArray.getBoolean(12, false));
        }
        if (typedArray.hasValue(6)) {
            googleMapOptions.compassEnabled(typedArray.getBoolean(6, true));
        }
        if (typedArray.hasValue(7)) {
            googleMapOptions.rotateGesturesEnabled(typedArray.getBoolean(7, true));
        }
        if (typedArray.hasValue(8)) {
            googleMapOptions.scrollGesturesEnabled(typedArray.getBoolean(8, true));
        }
        if (typedArray.hasValue(9)) {
            googleMapOptions.tiltGesturesEnabled(typedArray.getBoolean(9, true));
        }
        if (typedArray.hasValue(11)) {
            googleMapOptions.zoomGesturesEnabled(typedArray.getBoolean(11, true));
        }
        if (typedArray.hasValue(10)) {
            googleMapOptions.zoomControlsEnabled(typedArray.getBoolean(10, true));
        }
        googleMapOptions.camera(CameraPosition.createFromAttributes(context, attributeSet));
        typedArray.recycle();
        return googleMapOptions;
    }

    public GoogleMapOptions camera(CameraPosition cameraPosition) {
        this.xI = cameraPosition;
        return this;
    }

    public GoogleMapOptions compassEnabled(boolean bl2) {
        this.xK = bl2;
        return this;
    }

    byte dS() {
        return com.google.android.gms.maps.internal.a.c(this.xF);
    }

    byte dT() {
        return com.google.android.gms.maps.internal.a.c(this.xG);
    }

    byte dU() {
        return com.google.android.gms.maps.internal.a.c(this.xJ);
    }

    byte dV() {
        return com.google.android.gms.maps.internal.a.c(this.xK);
    }

    byte dW() {
        return com.google.android.gms.maps.internal.a.c(this.xL);
    }

    byte dX() {
        return com.google.android.gms.maps.internal.a.c(this.xM);
    }

    byte dY() {
        return com.google.android.gms.maps.internal.a.c(this.xN);
    }

    byte dZ() {
        return com.google.android.gms.maps.internal.a.c(this.xO);
    }

    public int describeContents() {
        return 0;
    }

    public CameraPosition getCamera() {
        return this.xI;
    }

    public Boolean getCompassEnabled() {
        return this.xK;
    }

    public int getMapType() {
        return this.xH;
    }

    public Boolean getRotateGesturesEnabled() {
        return this.xO;
    }

    public Boolean getScrollGesturesEnabled() {
        return this.xL;
    }

    public Boolean getTiltGesturesEnabled() {
        return this.xN;
    }

    public Boolean getUseViewLifecycleInFragment() {
        return this.xG;
    }

    int getVersionCode() {
        return this.kZ;
    }

    public Boolean getZOrderOnTop() {
        return this.xF;
    }

    public Boolean getZoomControlsEnabled() {
        return this.xJ;
    }

    public Boolean getZoomGesturesEnabled() {
        return this.xM;
    }

    public GoogleMapOptions mapType(int n2) {
        this.xH = n2;
        return this;
    }

    public GoogleMapOptions rotateGesturesEnabled(boolean bl2) {
        this.xO = bl2;
        return this;
    }

    public GoogleMapOptions scrollGesturesEnabled(boolean bl2) {
        this.xL = bl2;
        return this;
    }

    public GoogleMapOptions tiltGesturesEnabled(boolean bl2) {
        this.xN = bl2;
        return this;
    }

    public GoogleMapOptions useViewLifecycleInFragment(boolean bl2) {
        this.xG = bl2;
        return this;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        if (r.eh()) {
            a.a(this, parcel, n2);
            return;
        }
        GoogleMapOptionsCreator.a(this, parcel, n2);
    }

    public GoogleMapOptions zOrderOnTop(boolean bl2) {
        this.xF = bl2;
        return this;
    }

    public GoogleMapOptions zoomControlsEnabled(boolean bl2) {
        this.xJ = bl2;
        return this;
    }

    public GoogleMapOptions zoomGesturesEnabled(boolean bl2) {
        this.xM = bl2;
        return this;
    }
}

