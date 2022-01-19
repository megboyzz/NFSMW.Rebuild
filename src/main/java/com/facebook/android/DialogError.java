/*
 * Decompiled with CFR 0.152.
 */
package com.facebook.android;

public class DialogError
extends Throwable {
    private static final long serialVersionUID = 1L;
    private int mErrorCode;
    private String mFailingUrl;

    public DialogError(String string, int n2, String string2) {
        super(string);
        this.mErrorCode = n2;
        this.mFailingUrl = string2;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public String getFailingUrl() {
        return this.mFailingUrl;
    }
}

