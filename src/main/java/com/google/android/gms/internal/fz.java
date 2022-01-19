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
import com.google.android.gms.internal.du;
import com.google.android.gms.internal.fr;
import com.google.android.gms.internal.ga;
import com.google.android.gms.internal.gb;

public final class fz
extends fr
implements SafeParcelable {
    public static final ga CREATOR = new ga();
    private static final fz wG = new fz(0, new gb[0], new float[0]);
    final int kZ;
    private final gb[] wH;
    private final float[] wI;

    fz(int n2, gb[] gbArray, float[] fArray) {
        boolean bl2 = gbArray.length == fArray.length;
        du.b(bl2, "mismatched places to probabilities arrays");
        this.kZ = n2;
        this.wH = gbArray;
        this.wI = fArray;
    }

    public gb[] dC() {
        return this.wH;
    }

    float[] dD() {
        return this.wI;
    }

    public int describeContents() {
        ga ga2 = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof fz)) {
            return false;
        }
        object = (fz)object;
        if (!this.wH.equals(((fz)object).wH)) return false;
        if (this.wI.equals(((fz)object).wI)) return true;
        return false;
    }

    public int hashCode() {
        return ds.hashCode(this.wH, this.wI);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("PlaceEstimate{");
        int n2 = 0;
        while (true) {
            if (n2 >= this.wH.length) {
                stringBuilder.append("}");
                return stringBuilder.toString();
            }
            stringBuilder.append(String.format("(%f, %s)", Float.valueOf(this.wI[n2]), this.wH[n2].toString()));
            if (n2 != this.wH.length - 1) {
                stringBuilder.append(",");
            }
            ++n2;
        }
    }

    public void writeToParcel(Parcel parcel, int n2) {
        ga ga2 = CREATOR;
        ga.a(this, parcel, n2);
    }
}

