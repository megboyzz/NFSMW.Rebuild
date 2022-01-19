/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.ea.nimble.mtx.googleplay.util;

import org.json.JSONException;
import org.json.JSONObject;

public class SkuDetails {
    String mCurrencyCode;
    String mDescription;
    String mJson;
    String mPrice;
    String mPriceMicros;
    String mSku;
    String mTitle;
    String mType;

    public SkuDetails(String string2) throws JSONException {
        this.mJson = string2;
        string2 = new JSONObject(this.mJson);
        this.mSku = string2.optString("productId");
        this.mType = string2.optString("type");
        this.mPrice = string2.optString("price");
        this.mPriceMicros = string2.optString("price_amount_micros");
        this.mCurrencyCode = string2.optString("price_currency_code");
        this.mTitle = string2.optString("title");
        this.mDescription = string2.optString("description");
    }

    public String getCurrencyCode() {
        return this.mCurrencyCode;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public String getPrice() {
        return this.mPrice;
    }

    public String getPriceMicros() {
        return this.mPriceMicros;
    }

    public String getSku() {
        return this.mSku;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getType() {
        return this.mType;
    }

    public String toString() {
        return "SkuDetails:" + this.mJson;
    }
}

