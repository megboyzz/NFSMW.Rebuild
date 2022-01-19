/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.ea.nimble.mtx.googleplay.util;

import com.ea.nimble.ApplicationEnvironment;
import com.ea.nimble.mtx.googleplay.GooglePlay;
import com.ea.nimble.mtx.googleplay.GooglePlayTransaction;
import org.json.JSONException;
import org.json.JSONObject;

public class Purchase {
    String mDeveloperPayload;
    String mNimbleMTXTransactionId;
    String mOrderId;
    String mOriginalJson;
    String mPackageName;
    int mPurchaseState;
    long mPurchaseTime;
    String mSignature;
    String mSku;
    String mToken;

    public Purchase(GooglePlayTransaction googlePlayTransaction) throws IllegalArgumentException {
        Object object = googlePlayTransaction.getAdditionalInfo();
        if (object == null) {
            throw new IllegalArgumentException("Can't construct Purchase from GooglePlayTransaction without additional info bundle");
        }
        String string2 = (String)object.get(GooglePlay.GOOGLEPLAY_ADDITIONALINFO_KEY_ORDERID);
        String string3 = ApplicationEnvironment.getComponent().getApplicationBundleId();
        String string4 = googlePlayTransaction.getItemSku();
        long l2 = (Long)object.get(GooglePlay.GOOGLEPLAY_ADDITIONALINFO_KEY_PURCHASETIME);
        int n2 = (Integer)object.get(GooglePlay.GOOGLEPLAY_ADDITIONALINFO_KEY_PURCHASESTATE);
        String string5 = googlePlayTransaction.getNonce();
        object = (String)object.get(GooglePlay.GOOGLEPLAY_ADDITIONALINFO_KEY_TOKEN);
        String string6 = googlePlayTransaction.getReceipt();
        if (string2 == null) throw new IllegalArgumentException("Missing data to construct a Purchase object.");
        if (string3 == null) throw new IllegalArgumentException("Missing data to construct a Purchase object.");
        if (string4 == null) throw new IllegalArgumentException("Missing data to construct a Purchase object.");
        if (string5 == null) throw new IllegalArgumentException("Missing data to construct a Purchase object.");
        if (object == null) throw new IllegalArgumentException("Missing data to construct a Purchase object.");
        if (string6 == null) {
            throw new IllegalArgumentException("Missing data to construct a Purchase object.");
        }
        this.mOrderId = string2;
        this.mPackageName = string3;
        this.mSku = string4;
        this.mPurchaseTime = l2;
        this.mPurchaseState = n2;
        this.mDeveloperPayload = string5;
        this.mToken = object;
        this.mSignature = string6;
        this.mOriginalJson = "{\"constructedFromTransaction\":1}";
        this.mNimbleMTXTransactionId = googlePlayTransaction.getTransactionId();
    }

    public Purchase(String string2, String string3) throws JSONException {
        this.mOriginalJson = string2;
        string2 = new JSONObject(this.mOriginalJson);
        this.mOrderId = string2.optString("orderId");
        this.mPackageName = string2.optString("packageName");
        this.mSku = string2.optString("productId");
        this.mPurchaseTime = string2.optLong("purchaseTime");
        this.mPurchaseState = string2.optInt("purchaseState");
        this.mDeveloperPayload = string2.optString("developerPayload");
        this.mToken = string2.optString("token", string2.optString("purchaseToken"));
        this.mSignature = string3;
    }

    public String getDeveloperPayload() {
        return this.mDeveloperPayload;
    }

    public String getNimbleMTXTransactionId() {
        return this.mNimbleMTXTransactionId;
    }

    public String getOrderId() {
        return this.mOrderId;
    }

    public String getOriginalJson() {
        return this.mOriginalJson;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public int getPurchaseState() {
        return this.mPurchaseState;
    }

    public long getPurchaseTime() {
        return this.mPurchaseTime;
    }

    public String getSignature() {
        return this.mSignature;
    }

    public String getSku() {
        return this.mSku;
    }

    public String getToken() {
        return this.mToken;
    }

    public String toString() {
        return "PurchaseInfo:" + this.mOriginalJson;
    }
}

