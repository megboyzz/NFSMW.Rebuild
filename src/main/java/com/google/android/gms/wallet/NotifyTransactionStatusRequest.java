/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  android.text.TextUtils
 */
package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.du;
import com.google.android.gms.wallet.j;

public final class NotifyTransactionStatusRequest
implements SafeParcelable {
    public static final Parcelable.Creator<NotifyTransactionStatusRequest> CREATOR = new j();
    String BN;
    String Cv;
    final int kZ;
    int status;

    NotifyTransactionStatusRequest() {
        this.kZ = 1;
    }

    NotifyTransactionStatusRequest(int n2, String string2, int n3, String string3) {
        this.kZ = n2;
        this.BN = string2;
        this.status = n3;
        this.Cv = string3;
    }

    public static Builder newBuilder() {
        NotifyTransactionStatusRequest notifyTransactionStatusRequest = new NotifyTransactionStatusRequest();
        notifyTransactionStatusRequest.getClass();
        return notifyTransactionStatusRequest.new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public String getDetailedReason() {
        return this.Cv;
    }

    public String getGoogleTransactionId() {
        return this.BN;
    }

    public int getStatus() {
        return this.status;
    }

    public int getVersionCode() {
        return this.kZ;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        j.a(this, parcel, n2);
    }

    public final class Builder {
        private Builder() {
        }

        public NotifyTransactionStatusRequest build() {
            boolean bl2 = true;
            boolean bl3 = !TextUtils.isEmpty((CharSequence)NotifyTransactionStatusRequest.this.BN);
            du.b(bl3, "googleTransactionId is required");
            bl3 = NotifyTransactionStatusRequest.this.status >= 1 && NotifyTransactionStatusRequest.this.status <= 8 ? bl2 : false;
            du.b(bl3, "status is an unrecognized value");
            return NotifyTransactionStatusRequest.this;
        }

        public Builder setDetailedReason(String string2) {
            NotifyTransactionStatusRequest.this.Cv = string2;
            return this;
        }

        public Builder setGoogleTransactionId(String string2) {
            NotifyTransactionStatusRequest.this.BN = string2;
            return this;
        }

        public Builder setStatus(int n2) {
            NotifyTransactionStatusRequest.this.status = n2;
            return this;
        }
    }

    public static interface Status {
        public static final int SUCCESS = 1;

        public static interface Error {
            public static final int AVS_DECLINE = 7;
            public static final int BAD_CARD = 4;
            public static final int BAD_CVC = 3;
            public static final int DECLINED = 5;
            public static final int FRAUD_DECLINE = 8;
            public static final int OTHER = 6;
            public static final int UNKNOWN = 2;
        }
    }
}

