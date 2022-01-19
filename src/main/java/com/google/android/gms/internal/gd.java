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
import com.google.android.gms.internal.ge;
import java.util.List;

public final class gd
implements SafeParcelable {
    public static final ge CREATOR = new ge();
    public final String name;
    public final int versionCode;
    public final String xa;
    public final String xb;
    public final String xc;
    public final List<String> xd;

    public gd(int n2, String string2, String string3, String string4, String string5, List<String> list) {
        this.versionCode = n2;
        this.name = string2;
        this.xa = string3;
        this.xb = string4;
        this.xc = string5;
        this.xd = list;
    }

    public int describeContents() {
        ge ge2 = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof gd)) {
            return false;
        }
        object = (gd)object;
        if (!ds.equal(this.name, ((gd)object).name)) return false;
        if (!ds.equal(this.xa, ((gd)object).xa)) return false;
        if (!ds.equal(this.xb, ((gd)object).xb)) return false;
        if (!ds.equal(this.xc, ((gd)object).xc)) return false;
        if (ds.equal(this.xd, ((gd)object).xd)) return true;
        return false;
    }

    public int hashCode() {
        return ds.hashCode(this.name, this.xa, this.xb, this.xc);
    }

    public String toString() {
        return ds.e(this).a("name", this.name).a("address", this.xa).a("internationalPhoneNumber", this.xb).a("regularOpenHours", this.xc).a("attributions", this.xd).toString();
    }

    public void writeToParcel(Parcel parcel, int n2) {
        ge ge2 = CREATOR;
        ge.a(this, parcel, n2);
    }
}

