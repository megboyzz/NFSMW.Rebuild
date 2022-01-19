/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 */
package com.google.android.gms.panorama;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.dh;
import com.google.android.gms.internal.gk;

public final class a {
    public static final Api API;
    static final Api.b<gk> jL;

    static {
        jL = new Api.b<gk>(){

            @Override
            public /* synthetic */ Api.a b(Context context, dh dh2, GoogleApiClient.ApiOptions apiOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
                return this.d(context, dh2, apiOptions, connectionCallbacks, onConnectionFailedListener);
            }

            public gk d(Context context, dh dh2, GoogleApiClient.ApiOptions apiOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
                return new gk(context, connectionCallbacks, onConnectionFailedListener);
            }

            @Override
            public int getPriority() {
                return Integer.MAX_VALUE;
            }
        };
        API = new Api(jL, new Scope[0]);
    }

    public static interface a
    extends b {
    }

    public static interface b
    extends Result {
        public Intent eo();
    }
}

