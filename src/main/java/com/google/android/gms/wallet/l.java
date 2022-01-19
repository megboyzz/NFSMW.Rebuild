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
import com.google.android.gms.wallet.ProxyCard;

public class l
implements Parcelable.Creator<ProxyCard> {
    static void a(ProxyCard proxyCard, Parcel parcel, int n2) {
        n2 = b.l(parcel);
        b.c(parcel, 1, proxyCard.getVersionCode());
        b.a(parcel, 2, proxyCard.Cy, false);
        b.a(parcel, 3, proxyCard.Cz, false);
        b.c(parcel, 4, proxyCard.CA);
        b.c(parcel, 5, proxyCard.CB);
        b.D(parcel, n2);
    }

    public ProxyCard aG(Parcel parcel) {
        String string2 = null;
        int n2 = 0;
        int n3 = a.k(parcel);
        int n4 = 0;
        String string3 = null;
        int n5 = 0;
        block7: while (true) {
            if (parcel.dataPosition() >= n3) {
                if (parcel.dataPosition() == n3) return new ProxyCard(n5, string3, string2, n4, n2);
                throw new a.a("Overread allowed size end=" + n3, parcel);
            }
            int n6 = a.j(parcel);
            switch (a.A(n6)) {
                default: {
                    a.b(parcel, n6);
                    continue block7;
                }
                case 1: {
                    n5 = a.g(parcel, n6);
                    continue block7;
                }
                case 2: {
                    string3 = a.m(parcel, n6);
                    continue block7;
                }
                case 3: {
                    string2 = a.m(parcel, n6);
                    continue block7;
                }
                case 4: {
                    n4 = a.g(parcel, n6);
                    continue block7;
                }
                case 5: 
            }
            n2 = a.g(parcel, n6);
        }
    }

    public ProxyCard[] bo(int n2) {
        return new ProxyCard[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.aG(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.bo(n2);
    }
}

