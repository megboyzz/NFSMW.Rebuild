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
import com.google.android.gms.wallet.Cart;
import com.google.android.gms.wallet.CountrySpecification;
import com.google.android.gms.wallet.i;

public final class MaskedWalletRequest
implements SafeParcelable {
    public static final Parcelable.Creator<MaskedWalletRequest> CREATOR = new i();
    String BK;
    String BO;
    Cart BU;
    boolean Ck;
    boolean Cl;
    boolean Cm;
    String Cn;
    String Co;
    boolean Cp;
    boolean Cq;
    CountrySpecification[] Cr;
    boolean Cs;
    boolean Ct;
    private final int kZ;

    MaskedWalletRequest() {
        this.kZ = 3;
        this.Cs = true;
        this.Ct = true;
    }

    MaskedWalletRequest(int n2, String string2, boolean bl2, boolean bl3, boolean bl4, String string3, String string4, String string5, Cart cart, boolean bl5, boolean bl6, CountrySpecification[] countrySpecificationArray, boolean bl7, boolean bl8) {
        this.kZ = n2;
        this.BO = string2;
        this.Ck = bl2;
        this.Cl = bl3;
        this.Cm = bl4;
        this.Cn = string3;
        this.BK = string4;
        this.Co = string5;
        this.BU = cart;
        this.Cp = bl5;
        this.Cq = bl6;
        this.Cr = countrySpecificationArray;
        this.Cs = bl7;
        this.Ct = bl8;
    }

    public static Builder newBuilder() {
        MaskedWalletRequest maskedWalletRequest = new MaskedWalletRequest();
        maskedWalletRequest.getClass();
        return maskedWalletRequest.new Builder();
    }

    public boolean allowDebitCard() {
        return this.Ct;
    }

    public boolean allowPrepaidCard() {
        return this.Cs;
    }

    public int describeContents() {
        return 0;
    }

    public CountrySpecification[] getAllowedShippingCountrySpecifications() {
        return this.Cr;
    }

    public Cart getCart() {
        return this.BU;
    }

    public String getCurrencyCode() {
        return this.BK;
    }

    public String getEstimatedTotalPrice() {
        return this.Cn;
    }

    public String getMerchantName() {
        return this.Co;
    }

    public String getMerchantTransactionId() {
        return this.BO;
    }

    public int getVersionCode() {
        return this.kZ;
    }

    public boolean isBillingAgreement() {
        return this.Cq;
    }

    public boolean isPhoneNumberRequired() {
        return this.Ck;
    }

    public boolean isShippingAddressRequired() {
        return this.Cl;
    }

    public boolean shouldRetrieveWalletObjects() {
        return this.Cp;
    }

    public boolean useMinimalBillingAddress() {
        return this.Cm;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        i.a(this, parcel, n2);
    }

    public final class Builder {
        private Builder() {
        }

        public MaskedWalletRequest build() {
            return MaskedWalletRequest.this;
        }

        public Builder setAllowDebitCard(boolean bl2) {
            MaskedWalletRequest.this.Ct = bl2;
            return this;
        }

        public Builder setAllowPrepaidCard(boolean bl2) {
            MaskedWalletRequest.this.Cs = bl2;
            return this;
        }

        public Builder setAllowedShippingCountrySpecifications(CountrySpecification[] countrySpecificationArray) {
            MaskedWalletRequest.this.Cr = countrySpecificationArray;
            return this;
        }

        public Builder setCart(Cart cart) {
            MaskedWalletRequest.this.BU = cart;
            return this;
        }

        public Builder setCurrencyCode(String string2) {
            MaskedWalletRequest.this.BK = string2;
            return this;
        }

        public Builder setEstimatedTotalPrice(String string2) {
            MaskedWalletRequest.this.Cn = string2;
            return this;
        }

        public Builder setIsBillingAgreement(boolean bl2) {
            MaskedWalletRequest.this.Cq = bl2;
            return this;
        }

        public Builder setMerchantName(String string2) {
            MaskedWalletRequest.this.Co = string2;
            return this;
        }

        public Builder setMerchantTransactionId(String string2) {
            MaskedWalletRequest.this.BO = string2;
            return this;
        }

        public Builder setPhoneNumberRequired(boolean bl2) {
            MaskedWalletRequest.this.Ck = bl2;
            return this;
        }

        public Builder setShippingAddressRequired(boolean bl2) {
            MaskedWalletRequest.this.Cl = bl2;
            return this;
        }

        public Builder setShouldRetrieveWalletObjects(boolean bl2) {
            MaskedWalletRequest.this.Cp = bl2;
            return this;
        }

        public Builder setUseMinimalBillingAddress(boolean bl2) {
            MaskedWalletRequest.this.Cm = bl2;
            return this;
        }
    }
}

