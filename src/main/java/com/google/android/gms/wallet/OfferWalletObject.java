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
import com.google.android.gms.wallet.k;

public final class OfferWalletObject
implements SafeParcelable {
    public static final Parcelable.Creator<OfferWalletObject> CREATOR = new k();
    String Ca;
    String Cx;
    private final int kZ;

    OfferWalletObject() {
        this.kZ = 2;
    }

    OfferWalletObject(int n2, String string2, String string3) {
        this.kZ = n2;
        this.Ca = string2;
        this.Cx = string3;
    }

    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.Ca;
    }

    public String getRedemptionCode() {
        return this.Cx;
    }

    public int getVersionCode() {
        return this.kZ;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        k.a(this, parcel, n2);
    }
}

