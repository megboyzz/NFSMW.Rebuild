/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.android.gms.appstate;

import android.content.Context;
import com.google.android.gms.appstate.AppStateBuffer;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.db;
import com.google.android.gms.internal.dh;

public final class b {
    public static final Api API;
    static final Api.b<db> jL;
    public static final Scope jM;

    static {
        jL = new Api.b<db>(){

            public db a(Context context, dh dh2, GoogleApiClient.ApiOptions apiOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
                return new db(context, (GooglePlayServicesClient.ConnectionCallbacks)connectionCallbacks, (GooglePlayServicesClient.OnConnectionFailedListener)onConnectionFailedListener, dh2.bt(), dh2.bu().toArray(new String[0]));
            }

            @Override
            public /* synthetic */ Api.a b(Context context, dh dh2, GoogleApiClient.ApiOptions apiOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
                return this.a(context, dh2, apiOptions, connectionCallbacks, onConnectionFailedListener);
            }

            @Override
            public int getPriority() {
                return Integer.MAX_VALUE;
            }
        };
        jM = new Scope("https://www.googleapis.com/auth/appstate");
        API = new Api(jL, jM);
    }

    public static interface a
    extends Result {
        public int aK();

        public String aL();

        public byte[] aM();

        public byte[] getLocalData();
    }

    public static interface b
    extends Result {
        public int aK();
    }

    public static interface c
    extends Releasable,
    Result {
        public AppStateBuffer aN();
    }

    public static interface d
    extends Result {
        public int aK();

        public byte[] getLocalData();
    }

    public static interface e
    extends Releasable,
    Result {
        public d aO();

        public a aP();
    }
}

