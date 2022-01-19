/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.android.gms.common.api;

import android.content.Context;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.dh;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Api {
    private final b<?> kq;
    private final ArrayList<Scope> kr;

    public Api(b<?> b2, Scope ... scopeArray) {
        this.kq = b2;
        this.kr = new ArrayList<Scope>(Arrays.asList(scopeArray));
    }

    public b<?> aV() {
        return this.kq;
    }

    public List<Scope> aW() {
        return this.kr;
    }

    public static interface a {
        public void connect();

        public void disconnect();
    }

    public static interface b<T extends a> {
        public T b(Context var1, dh var2, GoogleApiClient.ApiOptions var3, GoogleApiClient.ConnectionCallbacks var4, GoogleApiClient.OnConnectionFailedListener var5);

        public int getPriority();
    }
}

