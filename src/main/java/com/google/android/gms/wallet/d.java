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
import com.google.android.gms.wallet.Address;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.ProxyCard;

public class d
implements Parcelable.Creator<FullWallet> {
    static void a(FullWallet fullWallet, Parcel parcel, int n2) {
        int n3 = b.l(parcel);
        b.c(parcel, 1, fullWallet.getVersionCode());
        b.a(parcel, 2, fullWallet.BN, false);
        b.a(parcel, 3, fullWallet.BO, false);
        b.a(parcel, 4, fullWallet.BP, n2, false);
        b.a(parcel, 5, fullWallet.BQ, false);
        b.a(parcel, 6, fullWallet.BR, n2, false);
        b.a(parcel, 7, fullWallet.BS, n2, false);
        b.a(parcel, 8, fullWallet.BT, false);
        b.D(parcel, n3);
    }

    public FullWallet ay(Parcel parcel) {
        String[] stringArray = null;
        int n2 = a.k(parcel);
        int n3 = 0;
        Address address = null;
        Address address2 = null;
        String string2 = null;
        ProxyCard proxyCard = null;
        String string3 = null;
        String string4 = null;
        block10: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new FullWallet(n3, string4, string3, proxyCard, string2, address2, address, stringArray);
                throw new a.a("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.j(parcel);
            switch (a.A(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block10;
                }
                case 1: {
                    n3 = a.g(parcel, n4);
                    continue block10;
                }
                case 2: {
                    string4 = a.m(parcel, n4);
                    continue block10;
                }
                case 3: {
                    string3 = a.m(parcel, n4);
                    continue block10;
                }
                case 4: {
                    proxyCard = a.a(parcel, n4, ProxyCard.CREATOR);
                    continue block10;
                }
                case 5: {
                    string2 = a.m(parcel, n4);
                    continue block10;
                }
                case 6: {
                    address2 = a.a(parcel, n4, Address.CREATOR);
                    continue block10;
                }
                case 7: {
                    address = a.a(parcel, n4, Address.CREATOR);
                    continue block10;
                }
                case 8: 
            }
            stringArray = a.x(parcel, n4);
        }
    }

    public FullWallet[] bg(int n2) {
        return new FullWallet[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.ay(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.bg(n2);
    }
}

