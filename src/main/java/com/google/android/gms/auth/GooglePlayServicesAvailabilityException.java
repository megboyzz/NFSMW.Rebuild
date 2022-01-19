/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 */
package com.google.android.gms.auth;

import android.content.Intent;
import com.google.android.gms.auth.UserRecoverableAuthException;

public class GooglePlayServicesAvailabilityException
extends UserRecoverableAuthException {
    private final int jW;

    GooglePlayServicesAvailabilityException(int n2, String string2, Intent intent) {
        super(string2, intent);
        this.jW = n2;
    }

    public int getConnectionStatusCode() {
        return this.jW;
    }
}

