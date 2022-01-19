/*
 * Decompiled with CFR 0.152.
 */
package com.facebook.android;

public class FacebookError
extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private int mErrorCode = 0;
    private String mErrorType;

    public FacebookError(String string) {
        super(string);
    }

    public FacebookError(String string, String string2, int n2) {
        super(string);
        this.mErrorType = string2;
        this.mErrorCode = n2;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public String getErrorType() {
        return this.mErrorType;
    }
}

