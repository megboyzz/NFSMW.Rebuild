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
import com.google.android.gms.wallet.e;

public final class FullWalletRequest
implements SafeParcelable {
    public static final Parcelable.Creator<FullWalletRequest> CREATOR = new e();
    String BN;
    String BO;
    Cart BU;
    private final int kZ;

    FullWalletRequest() {
        this.kZ = 1;
    }

    FullWalletRequest(int n2, String string2, String string3, Cart cart) {
        this.kZ = n2;
        this.BN = string2;
        this.BO = string3;
        this.BU = cart;
    }

    public static Builder newBuilder() {
        FullWalletRequest fullWalletRequest = new FullWalletRequest();
        fullWalletRequest.getClass();
        return fullWalletRequest.new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public Cart getCart() {
        return this.BU;
    }

    public String getGoogleTransactionId() {
        return this.BN;
    }

    public String getMerchantTransactionId() {
        return this.BO;
    }

    public int getVersionCode() {
        return this.kZ;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        e.a(this, parcel, n2);
    }

    public final class Builder {
        private Builder() {
        }

        public FullWalletRequest build() {
            return FullWalletRequest.this;
        }

        public Builder setCart(Cart cart) {
            FullWalletRequest.this.BU = cart;
            return this;
        }

        public Builder setGoogleTransactionId(String string2) {
            FullWalletRequest.this.BN = string2;
            return this;
        }

        public Builder setMerchantTransactionId(String string2) {
            FullWalletRequest.this.BO = string2;
            return this;
        }
    }
}

