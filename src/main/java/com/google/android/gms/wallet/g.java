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
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.wallet.LoyaltyWalletObject;

public class g
implements Parcelable.Creator<LoyaltyWalletObject> {
    static void a(LoyaltyWalletObject loyaltyWalletObject, Parcel parcel, int n2) {
        n2 = b.l(parcel);
        b.c(parcel, 1, loyaltyWalletObject.getVersionCode());
        b.a(parcel, 2, loyaltyWalletObject.Ca, false);
        b.a(parcel, 3, loyaltyWalletObject.Cb, false);
        b.a(parcel, 4, loyaltyWalletObject.Cc, false);
        b.a(parcel, 5, loyaltyWalletObject.Cd, false);
        b.a(parcel, 6, loyaltyWalletObject.Ce, false);
        b.a(parcel, 7, loyaltyWalletObject.Cf, false);
        b.a(parcel, 8, loyaltyWalletObject.Cg, false);
        b.a(parcel, 9, loyaltyWalletObject.Ch, false);
        b.D(parcel, n2);
    }

    public LoyaltyWalletObject aB(Parcel parcel) {
        String string2 = null;
        int n2 = a.k(parcel);
        int n3 = 0;
        String string3 = null;
        String string4 = null;
        String string5 = null;
        String string6 = null;
        String string7 = null;
        String string8 = null;
        String string9 = null;
        block11: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new LoyaltyWalletObject(n3, string9, string8, string7, string6, string5, string4, string3, string2);
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
                    string9 = a.m(parcel, n4);
                    continue block11;
                }
                case 3: {
                    string8 = a.m(parcel, n4);
                    continue block11;
                }
                case 4: {
                    string7 = a.m(parcel, n4);
                    continue block11;
                }
                case 5: {
                    string6 = a.m(parcel, n4);
                    continue block11;
                }
                case 6: {
                    string5 = a.m(parcel, n4);
                    continue block11;
                }
                case 7: {
                    string4 = a.m(parcel, n4);
                    continue block11;
                }
                case 8: {
                    string3 = a.m(parcel, n4);
                    continue block11;
                }
                case 9: 
            }
            string2 = a.m(parcel, n4);
        }
    }

    public LoyaltyWalletObject[] bj(int n2) {
        return new LoyaltyWalletObject[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.aB(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.bj(n2);
    }
}

