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
import com.google.android.gms.wallet.f;

public final class LineItem
implements SafeParcelable {
    public static final Parcelable.Creator<LineItem> CREATOR = new f();
    String BJ;
    String BK;
    String BW;
    String BX;
    int BY;
    String description;
    private final int kZ;

    LineItem() {
        this.kZ = 1;
        this.BY = 0;
    }

    LineItem(int n2, String string2, String string3, String string4, String string5, int n3, String string6) {
        this.kZ = n2;
        this.description = string2;
        this.BW = string3;
        this.BX = string4;
        this.BJ = string5;
        this.BY = n3;
        this.BK = string6;
    }

    public static Builder newBuilder() {
        LineItem lineItem = new LineItem();
        lineItem.getClass();
        return lineItem.new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public String getCurrencyCode() {
        return this.BK;
    }

    public String getDescription() {
        return this.description;
    }

    public String getQuantity() {
        return this.BW;
    }

    public int getRole() {
        return this.BY;
    }

    public String getTotalPrice() {
        return this.BJ;
    }

    public String getUnitPrice() {
        return this.BX;
    }

    public int getVersionCode() {
        return this.kZ;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        f.a(this, parcel, n2);
    }

    public final class Builder {
        private Builder() {
        }

        public LineItem build() {
            return LineItem.this;
        }

        public Builder setCurrencyCode(String string2) {
            LineItem.this.BK = string2;
            return this;
        }

        public Builder setDescription(String string2) {
            LineItem.this.description = string2;
            return this;
        }

        public Builder setQuantity(String string2) {
            LineItem.this.BW = string2;
            return this;
        }

        public Builder setRole(int n2) {
            LineItem.this.BY = n2;
            return this;
        }

        public Builder setTotalPrice(String string2) {
            LineItem.this.BJ = string2;
            return this;
        }

        public Builder setUnitPrice(String string2) {
            LineItem.this.BX = string2;
            return this;
        }
    }

    public static interface Role {
        public static final int REGULAR = 0;
        public static final int SHIPPING = 2;
        public static final int TAX = 1;
    }
}

