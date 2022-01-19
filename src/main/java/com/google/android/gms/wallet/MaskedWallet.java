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
import com.google.android.gms.wallet.Address;
import com.google.android.gms.wallet.LoyaltyWalletObject;
import com.google.android.gms.wallet.OfferWalletObject;
import com.google.android.gms.wallet.h;

public final class MaskedWallet
implements SafeParcelable {
    public static final Parcelable.Creator<MaskedWallet> CREATOR = new h();
    String BN;
    String BO;
    String BQ;
    Address BR;
    Address BS;
    String[] BT;
    LoyaltyWalletObject[] Ci;
    OfferWalletObject[] Cj;
    private final int kZ;

    MaskedWallet() {
        this.kZ = 2;
    }

    MaskedWallet(int n2, String string2, String string3, String[] stringArray, String string4, Address address, Address address2, LoyaltyWalletObject[] loyaltyWalletObjectArray, OfferWalletObject[] offerWalletObjectArray) {
        this.kZ = n2;
        this.BN = string2;
        this.BO = string3;
        this.BT = stringArray;
        this.BQ = string4;
        this.BR = address;
        this.BS = address2;
        this.Ci = loyaltyWalletObjectArray;
        this.Cj = offerWalletObjectArray;
    }

    public int describeContents() {
        return 0;
    }

    public Address getBillingAddress() {
        return this.BR;
    }

    public String getEmail() {
        return this.BQ;
    }

    public String getGoogleTransactionId() {
        return this.BN;
    }

    public LoyaltyWalletObject[] getLoyaltyWalletObjects() {
        return this.Ci;
    }

    public String getMerchantTransactionId() {
        return this.BO;
    }

    public OfferWalletObject[] getOfferWalletObjects() {
        return this.Cj;
    }

    public String[] getPaymentDescriptions() {
        return this.BT;
    }

    public Address getShippingAddress() {
        return this.BS;
    }

    public int getVersionCode() {
        return this.kZ;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        h.a(this, parcel, n2);
    }
}

