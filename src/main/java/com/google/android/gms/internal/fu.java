/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 */
package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ds;
import com.google.android.gms.internal.fs;
import com.google.android.gms.internal.fv;
import com.google.android.gms.location.LocationRequest;

public final class fu
implements SafeParcelable {
    public static final fv CREATOR = new fv();
    final int kZ;
    private final LocationRequest ui;
    private final fs uj;

    public fu(int n2, LocationRequest locationRequest, fs fs2) {
        this.kZ = n2;
        this.ui = locationRequest;
        this.uj = fs2;
    }

    public LocationRequest dA() {
        return this.ui;
    }

    public fs dB() {
        return this.uj;
    }

    public int describeContents() {
        fv fv2 = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof fu)) {
            return false;
        }
        object = (fu)object;
        if (!this.ui.equals(((fu)object).ui)) return false;
        if (this.uj.equals(((fu)object).uj)) return true;
        return false;
    }

    public int hashCode() {
        return ds.hashCode(this.ui, this.uj);
    }

    public String toString() {
        return ds.e(this).a("locationRequest", this.ui).a("filter", this.uj).toString();
    }

    public void writeToParcel(Parcel parcel, int n2) {
        fv fv2 = CREATOR;
        fv.a(this, parcel, n2);
    }
}

