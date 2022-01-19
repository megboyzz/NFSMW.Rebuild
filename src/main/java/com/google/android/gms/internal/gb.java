/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.Parcel
 */
package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ds;
import com.google.android.gms.internal.fq;
import com.google.android.gms.internal.fw;
import com.google.android.gms.internal.gc;
import com.google.android.gms.internal.gd;
import com.google.android.gms.internal.gf;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public final class gb
extends fq
implements SafeParcelable {
    public static final gc CREATOR = new gc();
    final int kZ;
    private final String wJ;
    private final Bundle wK;
    private final gd wL;
    private final LatLng wM;
    private final float wN;
    private final LatLngBounds wO;
    private final String wP;
    private final Uri wQ;
    private final boolean wR;
    private final float wS;
    private final int wT;
    private final long wU;
    private final List<fw> wV;
    private final Map<fw, String> wW;
    private final TimeZone wX;
    private Locale wY;
    private gf wZ;

    gb(int n2, String object, List<fw> object2, Bundle bundle, gd object3, LatLng latLng, float f2, LatLngBounds latLngBounds, String string2, Uri uri, boolean bl2, float f3, int n3, long l2) {
        this.kZ = n2;
        this.wJ = object;
        this.wV = Collections.unmodifiableList(object2);
        this.wK = bundle;
        this.wL = object3;
        this.wM = latLng;
        this.wN = f2;
        this.wO = latLngBounds;
        this.wP = string2;
        this.wQ = uri;
        this.wR = bl2;
        this.wS = f3;
        this.wT = n3;
        this.wU = l2;
        object = new HashMap();
        object2 = bundle.keySet().iterator();
        while (true) {
            if (!object2.hasNext()) {
                this.wW = Collections.unmodifiableMap(object);
                this.wX = TimeZone.getTimeZone(this.wP);
                this.wY = null;
                this.wZ = null;
                return;
            }
            object3 = (String)object2.next();
            ((HashMap)object).put(fw.ab((String)object3), bundle.getString((String)object3));
        }
    }

    private void ac(String string2) {
        if (this.wZ == null) return;
        this.wZ.b(this.wJ, "PlaceImpl", string2);
    }

    public List<fw> dE() {
        this.ac("getTypes");
        return this.wV;
    }

    public LatLng dF() {
        this.ac("getLatLng");
        return this.wM;
    }

    public float dG() {
        this.ac("getLevelNumber");
        return this.wN;
    }

    public LatLngBounds dH() {
        this.ac("getViewport");
        return this.wO;
    }

    public Uri dI() {
        this.ac("getWebsiteUri");
        return this.wQ;
    }

    public boolean dJ() {
        this.ac("isPermanentlyClosed");
        return this.wR;
    }

    public int dK() {
        this.ac("getPriceLevel");
        return this.wT;
    }

    public long dL() {
        return this.wU;
    }

    public Bundle dM() {
        return this.wK;
    }

    public gd dN() {
        return this.wL;
    }

    public String dO() {
        return this.wP;
    }

    public int describeContents() {
        gc gc2 = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof gb)) {
            return false;
        }
        object = (gb)object;
        if (!this.wJ.equals(((gb)object).wJ)) return false;
        if (!ds.equal(this.wY, ((gb)object).wY)) return false;
        if (this.wU == ((gb)object).wU) return true;
        return false;
    }

    public String getId() {
        this.ac("getId");
        return this.wJ;
    }

    public float getRating() {
        this.ac("getRating");
        return this.wS;
    }

    public int hashCode() {
        return ds.hashCode(this.wJ, this.wY, this.wU);
    }

    public String toString() {
        return ds.e(this).a("id", this.wJ).a("localization", this.wL).a("locale", this.wY).a("latlng", this.wM).a("levelNumber", Float.valueOf(this.wN)).a("viewport", this.wO).a("timeZone", this.wP).a("websiteUri", this.wQ).a("isPermanentlyClosed", this.wR).a("priceLevel", this.wT).a("timestampSecs", this.wU).toString();
    }

    public void writeToParcel(Parcel parcel, int n2) {
        gc gc2 = CREATOR;
        gc.a(this, parcel, n2);
    }
}

