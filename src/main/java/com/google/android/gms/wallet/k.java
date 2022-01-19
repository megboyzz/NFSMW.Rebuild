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
import com.google.android.gms.wallet.OfferWalletObject;

public class k
implements Parcelable.Creator<OfferWalletObject> {
    static void a(OfferWalletObject offerWalletObject, Parcel parcel, int n2) {
        n2 = b.l(parcel);
        b.c(parcel, 1, offerWalletObject.getVersionCode());
        b.a(parcel, 2, offerWalletObject.Ca, false);
        b.a(parcel, 3, offerWalletObject.Cx, false);
        b.D(parcel, n2);
    }

    public OfferWalletObject aF(Parcel parcel) {
        String string2 = null;
        int n2 = a.k(parcel);
        int n3 = 0;
        String string3 = null;
        block5: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new OfferWalletObject(n3, string3, string2);
                throw new a.a("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.j(parcel);
            switch (a.A(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block5;
                }
                case 1: {
                    n3 = a.g(parcel, n4);
                    continue block5;
                }
                case 2: {
                    string3 = a.m(parcel, n4);
                    continue block5;
                }
                case 3: 
            }
            string2 = a.m(parcel, n4);
        }
    }

    public OfferWalletObject[] bn(int n2) {
        return new OfferWalletObject[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.aF(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.bn(n2);
    }
}

