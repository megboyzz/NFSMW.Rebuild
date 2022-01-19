/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Parcel
 *  com.google.android.gms.R$styleable
 */
package com.google.android.gms.maps.model;

import android.content.Context;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ds;
import com.google.android.gms.internal.du;
import com.google.android.gms.maps.internal.r;
import com.google.android.gms.maps.model.CameraPositionCreator;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.a;

public final class CameraPosition
implements SafeParcelable {
    public static final CameraPositionCreator CREATOR = new CameraPositionCreator();
    public final float bearing;
    private final int kZ;
    public final LatLng target;
    public final float tilt;
    public final float zoom;

    CameraPosition(int n2, LatLng latLng, float f2, float f3, float f4) {
        du.c(latLng, "null camera target");
        boolean bl2 = 0.0f <= f3 && f3 <= 90.0f;
        du.b(bl2, "Tilt needs to be between 0 and 90 inclusive");
        this.kZ = n2;
        this.target = latLng;
        this.zoom = f2;
        this.tilt = f3 + 0.0f;
        f2 = f4;
        if ((double)f4 <= 0.0) {
            f2 = f4 % 360.0f + 360.0f;
        }
        this.bearing = f2 % 360.0f;
    }

    public CameraPosition(LatLng latLng, float f2, float f3, float f4) {
        this(1, latLng, f2, f3, f4);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(CameraPosition cameraPosition) {
        return new Builder(cameraPosition);
    }

    public static CameraPosition createFromAttributes(Context context, AttributeSet object) {
        if (object == null) {
            return null;
        }
        float f2 = (context = context.getResources().obtainAttributes((AttributeSet)object, R.styleable.MapAttrs)).hasValue(2) ? context.getFloat(2, 0.0f) : 0.0f;
        float f3 = context.hasValue(3) ? context.getFloat(3, 0.0f) : 0.0f;
        object = new LatLng(f2, f3);
        Builder builder = CameraPosition.builder();
        builder.target((LatLng)object);
        if (context.hasValue(5)) {
            builder.zoom(context.getFloat(5, 0.0f));
        }
        if (context.hasValue(1)) {
            builder.bearing(context.getFloat(1, 0.0f));
        }
        if (!context.hasValue(4)) return builder.build();
        builder.tilt(context.getFloat(4, 0.0f));
        return builder.build();
    }

    public static final CameraPosition fromLatLngZoom(LatLng latLng, float f2) {
        return new CameraPosition(latLng, f2, 0.0f, 0.0f);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof CameraPosition)) {
            return false;
        }
        object = (CameraPosition)object;
        if (!this.target.equals(((CameraPosition)object).target)) return false;
        if (Float.floatToIntBits(this.zoom) != Float.floatToIntBits(((CameraPosition)object).zoom)) return false;
        if (Float.floatToIntBits(this.tilt) != Float.floatToIntBits(((CameraPosition)object).tilt)) return false;
        if (Float.floatToIntBits(this.bearing) == Float.floatToIntBits(((CameraPosition)object).bearing)) return true;
        return false;
    }

    int getVersionCode() {
        return this.kZ;
    }

    public int hashCode() {
        return ds.hashCode(this.target, Float.valueOf(this.zoom), Float.valueOf(this.tilt), Float.valueOf(this.bearing));
    }

    public String toString() {
        return ds.e(this).a("target", this.target).a("zoom", Float.valueOf(this.zoom)).a("tilt", Float.valueOf(this.tilt)).a("bearing", Float.valueOf(this.bearing)).toString();
    }

    public void writeToParcel(Parcel parcel, int n2) {
        if (r.eh()) {
            a.a(this, parcel, n2);
            return;
        }
        CameraPositionCreator.a(this, parcel, n2);
    }

    public static final class Builder {
        private LatLng yi;
        private float yj;
        private float yk;
        private float yl;

        public Builder() {
        }

        public Builder(CameraPosition cameraPosition) {
            this.yi = cameraPosition.target;
            this.yj = cameraPosition.zoom;
            this.yk = cameraPosition.tilt;
            this.yl = cameraPosition.bearing;
        }

        public Builder bearing(float f2) {
            this.yl = f2;
            return this;
        }

        public CameraPosition build() {
            return new CameraPosition(this.yi, this.yj, this.yk, this.yl);
        }

        public Builder target(LatLng latLng) {
            this.yi = latLng;
            return this;
        }

        public Builder tilt(float f2) {
            this.yk = f2;
            return this;
        }

        public Builder zoom(float f2) {
            this.yj = f2;
            return this;
        }
    }
}

