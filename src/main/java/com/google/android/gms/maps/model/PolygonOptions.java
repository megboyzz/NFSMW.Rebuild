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
import com.google.android.gms.maps.model.PolygonOptionsCreator;
import com.google.android.gms.maps.model.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PolygonOptions
implements SafeParcelable {
    public static final PolygonOptionsCreator CREATOR = new PolygonOptionsCreator();
    private final int kZ;
    private final List<LatLng> yR;
    private final List<List<LatLng>> yS;
    private boolean yT = false;
    private float yp = 10.0f;
    private int yq = -16777216;
    private int yr = 0;
    private float ys = 0.0f;
    private boolean yt = true;

    public PolygonOptions() {
        this.kZ = 1;
        this.yR = new ArrayList<LatLng>();
        this.yS = new ArrayList<List<LatLng>>();
    }

    PolygonOptions(int n2, List<LatLng> list, List list2, float f2, int n3, int n4, float f3, boolean bl2, boolean bl3) {
        this.kZ = n2;
        this.yR = list;
        this.yS = list2;
        this.yp = f2;
        this.yq = n3;
        this.yr = n4;
        this.ys = f3;
        this.yt = bl2;
        this.yT = bl3;
    }

    public PolygonOptions add(LatLng latLng) {
        this.yR.add(latLng);
        return this;
    }

    public PolygonOptions add(LatLng ... latLngArray) {
        this.yR.addAll(Arrays.asList(latLngArray));
        return this;
    }

    public PolygonOptions addAll(Iterable<LatLng> object) {
        object = object.iterator();
        while (object.hasNext()) {
            LatLng latLng = (LatLng)object.next();
            this.yR.add(latLng);
        }
        return this;
    }

    public PolygonOptions addHole(Iterable<LatLng> object) {
        ArrayList<LatLng> arrayList = new ArrayList<LatLng>();
        object = object.iterator();
        while (true) {
            if (!object.hasNext()) {
                this.yS.add(arrayList);
                return this;
            }
            arrayList.add((LatLng)object.next());
        }
    }

    public int describeContents() {
        return 0;
    }

    List el() {
        return this.yS;
    }

    public PolygonOptions fillColor(int n2) {
        this.yr = n2;
        return this;
    }

    public PolygonOptions geodesic(boolean bl2) {
        this.yT = bl2;
        return this;
    }

    public int getFillColor() {
        return this.yr;
    }

    public List<List<LatLng>> getHoles() {
        return this.yS;
    }

    public List<LatLng> getPoints() {
        return this.yR;
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

    public boolean isGeodesic() {
        return this.yT;
    }

    public boolean isVisible() {
        return this.yt;
    }

    public PolygonOptions strokeColor(int n2) {
        this.yq = n2;
        return this;
    }

    public PolygonOptions strokeWidth(float f2) {
        this.yp = f2;
        return this;
    }

    public PolygonOptions visible(boolean bl2) {
        this.yt = bl2;
        return this;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        if (r.eh()) {
            g.a(this, parcel, n2);
            return;
        }
        PolygonOptionsCreator.a(this, parcel, n2);
    }

    public PolygonOptions zIndex(float f2) {
        this.ys = f2;
        return this;
    }
}

