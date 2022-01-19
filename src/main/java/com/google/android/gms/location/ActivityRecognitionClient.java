/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.Context
 */
package com.google.android.gms.location;

import android.app.PendingIntent;
import android.content.Context;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.internal.fm;

public class ActivityRecognitionClient
implements GooglePlayServicesClient {
    private final fm ts;

    public ActivityRecognitionClient(Context context, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.ts = new fm(context, connectionCallbacks, onConnectionFailedListener, "activity_recognition");
    }

    @Override
    public void connect() {
        this.ts.connect();
    }

    @Override
    public void disconnect() {
        this.ts.disconnect();
    }

    @Override
    public boolean isConnected() {
        return this.ts.isConnected();
    }

    @Override
    public boolean isConnecting() {
        return this.ts.isConnecting();
    }

    @Override
    public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks) {
        return this.ts.isConnectionCallbacksRegistered(connectionCallbacks);
    }

    @Override
    public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
        return this.ts.isConnectionFailedListenerRegistered(onConnectionFailedListener);
    }

    @Override
    public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks) {
        this.ts.registerConnectionCallbacks(connectionCallbacks);
    }

    @Override
    public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.ts.registerConnectionFailedListener(onConnectionFailedListener);
    }

    public void removeActivityUpdates(PendingIntent pendingIntent) {
        this.ts.removeActivityUpdates(pendingIntent);
    }

    public void requestActivityUpdates(long l2, PendingIntent pendingIntent) {
        this.ts.requestActivityUpdates(l2, pendingIntent);
    }

    @Override
    public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks) {
        this.ts.unregisterConnectionCallbacks(connectionCallbacks);
    }

    @Override
    public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.ts.unregisterConnectionFailedListener(onConnectionFailedListener);
    }
}

