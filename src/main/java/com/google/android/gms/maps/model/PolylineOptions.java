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
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolylineOptionsCreator;
import com.google.android.gms.maps.model.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PolylineOptions
implements SafeParcelable {
    public static final PolylineOptionsCreator CREATOR = new PolylineOptionsCreator();
    private final int kZ;
    private int kn = -16777216;
    private final List<LatLng> yR;
    private boolean yT = false;
    private float ys = 0.0f;
    private boolean yt = true;
    private float yx = 10.0f;

    public PolylineOptions() {
        this.kZ = 1;
        this.yR = new ArrayList<LatLng>();
    }

    PolylineOptions(int n2, List list, float f2, int n3, float f3, boolean bl2, boolean bl3) {
        this.kZ = n2;
        this.yR = list;
        this.yx = f2;
        this.kn = n3;
        this.ys = f3;
        this.yt = bl2;
        this.yT = bl3;
    }

    public PolylineOptions add(LatLng latLng) {
        this.yR.add(latLng);
        return this;
    }

    public PolylineOptions add(LatLng ... latLngArray) {
        this.yR.addAll(Arrays.asList(latLngArray));
        return this;
    }

    public PolylineOptions addAll(Iterable<LatLng> object) {
        object = object.iterator();
        while (object.hasNext()) {
            LatLng latLng = (LatLng)object.next();
            this.yR.add(latLng);
        }
        return this;
    }

    public PolylineOptions color(int n2) {
        this.kn = n2;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public PolylineOptions geodesic(boolean bl2) {
        this.yT = bl2;
        return this;
    }

    public int getColor() {
        return this.kn;
    }

    public List<LatLng> getPoints() {
        return this.yR;
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

    public boolean isGeodesic() {
        return this.yT;
    }

    public boolean isVisible() {
        return this.yt;
    }

    public PolylineOptions visible(boolean bl2) {
        this.yt = bl2;
        return this;
    }

    public PolylineOptions width(float f2) {
        this.yx = f2;
        return this;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        if (r.eh()) {
            h.a(this, parcel, n2);
            return;
        }
        PolylineOptionsCreator.a(this, parcel, n2);
    }

    public PolylineOptions zIndex(float f2) {
        this.ys = f2;
        return this;
    }
}

