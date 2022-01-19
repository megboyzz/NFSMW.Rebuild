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
import com.google.android.gms.wallet.Cart;
import com.google.android.gms.wallet.CountrySpecification;
import com.google.android.gms.wallet.MaskedWalletRequest;

public class i
implements Parcelable.Creator<MaskedWalletRequest> {
    static void a(MaskedWalletRequest maskedWalletRequest, Parcel parcel, int n2) {
        int n3 = b.l(parcel);
        b.c(parcel, 1, maskedWalletRequest.getVersionCode());
        b.a(parcel, 2, maskedWalletRequest.BO, false);
        b.a(parcel, 3, maskedWalletRequest.Ck);
        b.a(parcel, 4, maskedWalletRequest.Cl);
        b.a(parcel, 5, maskedWalletRequest.Cm);
        b.a(parcel, 6, maskedWalletRequest.Cn, false);
        b.a(parcel, 7, maskedWalletRequest.BK, false);
        b.a(parcel, 8, maskedWalletRequest.Co, false);
        b.a(parcel, 9, maskedWalletRequest.BU, n2, false);
        b.a(parcel, 10, maskedWalletRequest.Cp);
        b.a(parcel, 11, maskedWalletRequest.Cq);
        b.a((Parcel)parcel, (int)12, (Parcelable[])maskedWalletRequest.Cr, (int)n2, (boolean)false);
        b.a(parcel, 13, maskedWalletRequest.Cs);
        b.a(parcel, 14, maskedWalletRequest.Ct);
        b.D(parcel, n3);
    }

    public MaskedWalletRequest aD(Parcel parcel) {
        int n2 = a.k(parcel);
        int n3 = 0;
        String string2 = null;
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = false;
        String string3 = null;
        String string4 = null;
        String string5 = null;
        Cart cart = null;
        boolean bl5 = false;
        boolean bl6 = false;
        CountrySpecification[] countrySpecificationArray = null;
        boolean bl7 = true;
        boolean bl8 = true;
        block16: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new MaskedWalletRequest(n3, string2, bl2, bl3, bl4, string3, string4, string5, cart, bl5, bl6, countrySpecificationArray, bl7, bl8);
                throw new a.a("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.j(parcel);
            switch (a.A(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block16;
                }
                case 1: {
                    n3 = a.g(parcel, n4);
                    continue block16;
                }
                case 2: {
                    string2 = a.m(parcel, n4);
                    continue block16;
                }
                case 3: {
                    bl2 = a.c(parcel, n4);
                    continue block16;
                }
                case 4: {
                    bl3 = a.c(parcel, n4);
                    continue block16;
                }
                case 5: {
                    bl4 = a.c(parcel, n4);
                    continue block16;
                }
                case 6: {
                    string3 = a.m(parcel, n4);
                    continue block16;
                }
                case 7: {
                    string4 = a.m(parcel, n4);
                    continue block16;
                }
                case 8: {
                    string5 = a.m(parcel, n4);
                    continue block16;
                }
                case 9: {
                    cart = a.a(parcel, n4, Cart.CREATOR);
                    continue block16;
                }
                case 10: {
                    bl5 = a.c(parcel, n4);
                    continue block16;
                }
                case 11: {
                    bl6 = a.c(parcel, n4);
                    continue block16;
                }
                case 12: {
                    countrySpecificationArray = a.b(parcel, n4, CountrySpecification.CREATOR);
                    continue block16;
                }
                case 13: {
                    bl7 = a.c(parcel, n4);
                    continue block16;
                }
                case 14: 
            }
            bl8 = a.c(parcel, n4);
        }
    }

    public MaskedWalletRequest[] bl(int n2) {
        return new MaskedWalletRequest[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.aD(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.bl(n2);
    }
}

