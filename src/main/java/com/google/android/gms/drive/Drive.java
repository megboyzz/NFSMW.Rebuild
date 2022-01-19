/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.android.gms.drive;

import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.internal.h;
import com.google.android.gms.drive.internal.j;
import com.google.android.gms.internal.dh;

public final class Drive {
    public static final Api API;
    public static final DriveApi DriveApi;
    public static final Scope SCOPE_FILE;
    public static final Api.b<j> jL;

    static {
        jL = new Api.b<j>(){

            @Override
            public /* synthetic */ Api.a b(Context context, dh dh2, GoogleApiClient.ApiOptions apiOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
                return this.c(context, dh2, apiOptions, connectionCallbacks, onConnectionFailedListener);
            }

            public j c(Context context, dh dh2, GoogleApiClient.ApiOptions object, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
                object = dh2.bu();
                return new j(context, dh2, connectionCallbacks, onConnectionFailedListener, object.toArray(new String[object.size()]));
            }

            @Override
            public int getPriority() {
                return Integer.MAX_VALUE;
            }
        };
        SCOPE_FILE = new Scope("https://www.googleapis.com/auth/drive.file");
        API = new Api(jL, new Scope[0]);
        DriveApi = new h();
    }

    private Drive() {
    }
}

