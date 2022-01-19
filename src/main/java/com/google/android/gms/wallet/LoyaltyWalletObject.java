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
import com.google.android.gms.wallet.g;

public final class LoyaltyWalletObject
implements SafeParcelable {
    public static final Parcelable.Creator<LoyaltyWalletObject> CREATOR = new g();
    String Ca;
    String Cb;
    String Cc;
    String Cd;
    String Ce;
    String Cf;
    String Cg;
    String Ch;
    private final int kZ;

    LoyaltyWalletObject() {
        this.kZ = 3;
    }

    LoyaltyWalletObject(int n2, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9) {
        this.kZ = n2;
        this.Ca = string2;
        this.Cb = string3;
        this.Cc = string4;
        this.Cd = string5;
        this.Ce = string6;
        this.Cf = string7;
        this.Cg = string8;
        this.Ch = string9;
    }

    public int describeContents() {
        return 0;
    }

    public String getAccountId() {
        return this.Cb;
    }

    public String getAccountName() {
        return this.Ce;
    }

    public String getBarcodeAlternateText() {
        return this.Cf;
    }

    public String getBarcodeType() {
        return this.Cg;
    }

    public String getBarcodeValue() {
        return this.Ch;
    }

    public String getId() {
        return this.Ca;
    }

    public String getIssuerName() {
        return this.Cc;
    }

    public String getProgramName() {
        return this.Cd;
    }

    public int getVersionCode() {
        return this.kZ;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        g.a(this, parcel, n2);
    }
}

