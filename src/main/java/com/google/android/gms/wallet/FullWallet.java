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
import com.google.android.gms.wallet.ProxyCard;
import com.google.android.gms.wallet.d;

public final class FullWallet
implements SafeParcelable {
    public static final Parcelable.Creator<FullWallet> CREATOR = new d();
    String BN;
    String BO;
    ProxyCard BP;
    String BQ;
    Address BR;
    Address BS;
    String[] BT;
    private final int kZ;

    FullWallet() {
        this.kZ = 1;
    }

    FullWallet(int n2, String string2, String string3, ProxyCard proxyCard, String string4, Address address, Address address2, String[] stringArray) {
        this.kZ = n2;
        this.BN = string2;
        this.BO = string3;
        this.BP = proxyCard;
        this.BQ = string4;
        this.BR = address;
        this.BS = address2;
        this.BT = stringArray;
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

    public String getMerchantTransactionId() {
        return this.BO;
    }

    public String[] getPaymentDescriptions() {
        return this.BT;
    }

    public ProxyCard getProxyCard() {
        return this.BP;
    }

    public Address getShippingAddress() {
        return this.BS;
    }

    public int getVersionCode() {
        return this.kZ;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        d.a(this, parcel, n2);
    }
}

