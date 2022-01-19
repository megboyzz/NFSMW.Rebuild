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
import com.google.android.gms.wallet.Cart;
import com.google.android.gms.wallet.FullWalletRequest;

public class e
implements Parcelable.Creator<FullWalletRequest> {
    static void a(FullWalletRequest fullWalletRequest, Parcel parcel, int n2) {
        int n3 = b.l(parcel);
        b.c(parcel, 1, fullWalletRequest.getVersionCode());
        b.a(parcel, 2, fullWalletRequest.BN, false);
        b.a(parcel, 3, fullWalletRequest.BO, false);
        b.a(parcel, 4, fullWalletRequest.BU, n2, false);
        b.D(parcel, n3);
    }

    public FullWalletRequest az(Parcel parcel) {
        Cart cart = null;
        int n2 = a.k(parcel);
        int n3 = 0;
        String string2 = null;
        String string3 = null;
        block6: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new FullWalletRequest(n3, string3, string2, cart);
                throw new a.a("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.j(parcel);
            switch (a.A(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block6;
                }
                case 1: {
                    n3 = a.g(parcel, n4);
                    continue block6;
                }
                case 2: {
                    string3 = a.m(parcel, n4);
                    continue block6;
                }
                case 3: {
                    string2 = a.m(parcel, n4);
                    continue block6;
                }
                case 4: 
            }
            cart = a.a(parcel, n4, Cart.CREATOR);
        }
    }

    public FullWalletRequest[] bh(int n2) {
        return new FullWalletRequest[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.az(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.bh(n2);
    }
}

