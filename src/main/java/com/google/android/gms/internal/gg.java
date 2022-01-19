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
import com.google.android.gms.internal.gh;

public class gg
implements SafeParcelable {
    public static final gh CREATOR = new gh();
    public final int versionCode;
    public final String xj;
    public final String xk;

    public gg(int n2, String string2, String string3) {
        this.versionCode = n2;
        this.xj = string2;
        this.xk = string3;
    }

    public int describeContents() {
        gh gh2 = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (!(object instanceof gg)) {
            return false;
        }
        object = (gg)object;
        if (!this.xk.equals(((gg)object).xk)) return false;
        if (this.xj.equals(((gg)object).xj)) return true;
        return false;
    }

    public int hashCode() {
        return ds.hashCode(this.xj, this.xk);
    }

    public String toString() {
        return ds.e(this).a("clientPackageName", this.xj).a("locale", this.xk).toString();
    }

    public void writeToParcel(Parcel parcel, int n2) {
        gh gh2 = CREATOR;
        gh.a(this, parcel, n2);
    }
}

