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
import com.google.android.gms.wallet.LineItem;
import com.google.android.gms.wallet.b;
import java.util.ArrayList;
import java.util.List;

public final class Cart
implements SafeParcelable {
    public static final Parcelable.Creator<Cart> CREATOR = new b();
    String BJ;
    String BK;
    ArrayList<LineItem> BL;
    private final int kZ;

    Cart() {
        this.kZ = 1;
        this.BL = new ArrayList();
    }

    Cart(int n2, String string2, String string3, ArrayList<LineItem> arrayList) {
        this.kZ = n2;
        this.BJ = string2;
        this.BK = string3;
        this.BL = arrayList;
    }

    public static Builder newBuilder() {
        Cart cart = new Cart();
        cart.getClass();
        return cart.new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public String getCurrencyCode() {
        return this.BK;
    }

    public ArrayList<LineItem> getLineItems() {
        return this.BL;
    }

    public String getTotalPrice() {
        return this.BJ;
    }

    public int getVersionCode() {
        return this.kZ;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        b.a(this, parcel, n2);
    }

    public final class Builder {
        private Builder() {
        }

        public Builder addLineItem(LineItem lineItem) {
            Cart.this.BL.add(lineItem);
            return this;
        }

        public Cart build() {
            return Cart.this;
        }

        public Builder setCurrencyCode(String string2) {
            Cart.this.BK = string2;
            return this;
        }

        public Builder setLineItems(List<LineItem> list) {
            Cart.this.BL.clear();
            Cart.this.BL.addAll(list);
            return this;
        }

        public Builder setTotalPrice(String string2) {
            Cart.this.BJ = string2;
            return this;
        }
    }
}

