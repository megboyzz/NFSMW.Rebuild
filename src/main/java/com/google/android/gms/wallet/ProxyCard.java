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
import com.google.android.gms.wallet.l;

public final class ProxyCard
implements SafeParcelable {
    public static final Parcelable.Creator<ProxyCard> CREATOR = new l();
    int CA;
    int CB;
    String Cy;
    String Cz;
    private final int kZ;

    ProxyCard(int n2, String string2, String string3, int n3, int n4) {
        this.kZ = n2;
        this.Cy = string2;
        this.Cz = string3;
        this.CA = n3;
        this.CB = n4;
    }

    public int describeContents() {
        return 0;
    }

    public String getCvn() {
        return this.Cz;
    }

    public int getExpirationMonth() {
        return this.CA;
    }

    public int getExpirationYear() {
        return this.CB;
    }

    public String getPan() {
        return this.Cy;
    }

    public int getVersionCode() {
        return this.kZ;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        l.a(this, parcel, n2);
    }
}

