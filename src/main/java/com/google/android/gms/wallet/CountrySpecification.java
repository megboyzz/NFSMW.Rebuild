/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.c;

public class CountrySpecification
implements SafeParcelable {
    public static final Parcelable.Creator<CountrySpecification> CREATOR = new c();
    String ia;
    private final int kZ;

    CountrySpecification(int n2, String string2) {
        this.kZ = n2;
        this.ia = string2;
    }

    public CountrySpecification(String string2) {
        this.kZ = 1;
        this.ia = string2;
    }

    public int describeContents() {
        return 0;
    }

    public String getCountryCode() {
        return this.ia;
    }

    public int getVersionCode() {
        return this.kZ;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        c.a(this, parcel, n2);
    }
}

