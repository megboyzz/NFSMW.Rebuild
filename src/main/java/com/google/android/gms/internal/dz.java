/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 */
package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ea;
import com.google.android.gms.internal.eb;
import com.google.android.gms.internal.ee;

public class dz
implements SafeParcelable {
    public static final ea CREATOR = new ea();
    private final int kZ;
    private final eb nr;

    dz(int n2, eb eb2) {
        this.kZ = n2;
        this.nr = eb2;
    }

    private dz(eb eb2) {
        this.kZ = 1;
        this.nr = eb2;
    }

    public static dz a(ee.b<?, ?> b2) {
        if (!(b2 instanceof eb)) throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
        return new dz((eb)b2);
    }

    eb bL() {
        return this.nr;
    }

    public ee.b<?, ?> bM() {
        if (this.nr == null) throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
        return this.nr;
    }

    public int describeContents() {
        ea ea2 = CREATOR;
        return 0;
    }

    int getVersionCode() {
        return this.kZ;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        ea ea2 = CREATOR;
        ea.a(this, parcel, n2);
    }
}

