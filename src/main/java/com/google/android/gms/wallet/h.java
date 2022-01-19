/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.wallet.Address;
import com.google.android.gms.wallet.LoyaltyWalletObject;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.OfferWalletObject;

public class h
implements Parcelable.Creator<MaskedWallet> {
    static void a(MaskedWallet maskedWallet, Parcel parcel, int n2) {
        int n3 = b.l(parcel);
        b.c(parcel, 1, maskedWallet.getVersionCode());
        b.a(parcel, 2, maskedWallet.BN, false);
        b.a(parcel, 3, maskedWallet.BO, false);
        b.a(parcel, 4, maskedWallet.BT, false);
        b.a(parcel, 5, maskedWallet.BQ, false);
        b.a(parcel, 6, maskedWallet.BR, n2, false);
        b.a(parcel, 7, maskedWallet.BS, n2, false);
        b.a((Parcel)parcel, (int)8, (Parcelable[])maskedWallet.Ci, (int)n2, (boolean)false);
        b.a((Parcel)parcel, (int)9, (Parcelable[])maskedWallet.Cj, (int)n2, (boolean)false);
        b.D(parcel, n3);
    }

    public MaskedWallet aC(Parcel parcel) {
        OfferWalletObject[] offerWalletObjectArray = null;
        int n2 = a.k(parcel);
        int n3 = 0;
        LoyaltyWalletObject[] loyaltyWalletObjectArray = null;
        Address address = null;
        Address address2 = null;
        String string2 = null;
        String[] stringArray = null;
        String string3 = null;
        String string4 = null;
        block11: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new MaskedWallet(n3, string4, string3, stringArray, string2, address2, address, loyaltyWalletObjectArray, offerWalletObjectArray);
                throw new a.a("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.j(parcel);
            switch (a.A(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block11;
                }
                case 1: {
                    n3 = a.g(parcel, n4);
                    continue block11;
                }
                case 2: {
                    string4 = a.m(parcel, n4);
                    continue block11;
                }
                case 3: {
                    string3 = a.m(parcel, n4);
                    continue block11;
                }
                case 4: {
                    stringArray = a.x(parcel, n4);
                    continue block11;
                }
                case 5: {
                    string2 = a.m(parcel, n4);
                    continue block11;
                }
                case 6: {
                    address2 = a.a(parcel, n4, Address.CREATOR);
                    continue block11;
                }
                case 7: {
                    address = a.a(parcel, n4, Address.CREATOR);
                    continue block11;
                }
                case 8: {
                    loyaltyWalletObjectArray = a.b(parcel, n4, LoyaltyWalletObject.CREATOR);
                    continue block11;
                }
                case 9: 
            }
            offerWalletObjectArray = a.b(parcel, n4, OfferWalletObject.CREATOR);
        }
    }

    public MaskedWallet[] bk(int n2) {
        return new MaskedWallet[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.aC(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.bk(n2);
    }
}

