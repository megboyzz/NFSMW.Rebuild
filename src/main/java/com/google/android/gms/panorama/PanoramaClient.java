/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 */
package com.google.android.gms.panorama;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.api.a;
import com.google.android.gms.internal.gk;
import com.google.android.gms.panorama.a;

public class PanoramaClient
implements GooglePlayServicesClient {
    private final gk zc;

    public PanoramaClient(Context context, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.zc = new gk(context, connectionCallbacks, onConnectionFailedListener);
    }

    @Override
    public void connect() {
        this.zc.connect();
    }

    @Override
    public void disconnect() {
        this.zc.disconnect();
    }

    @Override
    public boolean isConnected() {
        return this.zc.isConnected();
    }

    @Override
    public boolean isConnecting() {
        return this.zc.isConnecting();
    }

    @Override
    public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks) {
        return this.zc.isConnectionCallbacksRegistered(connectionCallbacks);
    }

    @Override
    public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
        return this.zc.isConnectionFailedListenerRegistered(onConnectionFailedListener);
    }

    public void loadPanoramaInfo(final OnPanoramaInfoLoadedListener onPanoramaInfoLoadedListener, Uri uri) {
        this.zc.a(new a.c<a.b>(){

            @Override
            public void a(a.b b2) {
                onPanoramaInfoLoadedListener.onPanoramaInfoLoaded(b2.getStatus().bh(), b2.eo());
            }
        }, uri, false);
    }

    public void loadPanoramaInfoAndGrantAccess(final OnPanoramaInfoLoadedListener onPanoramaInfoLoadedListener, Uri uri) {
        this.zc.a(new a.c<a.b>(){

            @Override
            public void a(a.b b2) {
                onPanoramaInfoLoadedListener.onPanoramaInfoLoaded(b2.getStatus().bh(), b2.eo());
            }
        }, uri, true);
    }

    @Override
    public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks) {
        this.zc.registerConnectionCallbacks(connectionCallbacks);
    }

    @Override
    public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.zc.registerConnectionFailedListener(onConnectionFailedListener);
    }

    @Override
    public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks) {
        this.zc.unregisterConnectionCallbacks(connectionCallbacks);
    }

    @Override
    public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.zc.unregisterConnectionFailedListener(onConnectionFailedListener);
    }

    public static interface OnPanoramaInfoLoadedListener {
        public void onPanoramaInfoLoaded(ConnectionResult var1, Intent var2);
    }
}

