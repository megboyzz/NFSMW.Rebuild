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
import com.google.android.gms.wallet.Cart;
import com.google.android.gms.wallet.LineItem;
import java.util.ArrayList;

public class b
implements Parcelable.Creator<Cart> {
    static void a(Cart cart, Parcel parcel, int n2) {
        n2 = com.google.android.gms.common.internal.safeparcel.b.l(parcel);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 1, cart.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, cart.BJ, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, cart.BK, false);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, 4, cart.BL, false);
        com.google.android.gms.common.internal.safeparcel.b.D(parcel, n2);
    }

    public Cart aw(Parcel parcel) {
        String string2 = null;
        int n2 = a.k(parcel);
        int n3 = 0;
        ArrayList<LineItem> arrayList = new ArrayList<LineItem>();
        String string3 = null;
        block6: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new Cart(n3, string3, string2, arrayList);
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
            arrayList = a.c(parcel, n4, LineItem.CREATOR);
        }
    }

    public Cart[] be(int n2) {
        return new Cart[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.aw(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.be(n2);
    }
}

