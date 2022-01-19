/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 */
package com.google.android.gms.wallet;

import android.app.Activity;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.internal.ho;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;

public class WalletClient
implements GooglePlayServicesClient {
    private final ho CC;

    public WalletClient(Activity activity, int n2, String string2, int n3, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.CC = new ho(activity, connectionCallbacks, onConnectionFailedListener, n2, string2, n3);
    }

    public WalletClient(Activity activity, int n2, String string2, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
        this(activity, n2, string2, 0, connectionCallbacks, onConnectionFailedListener);
    }

    public void changeMaskedWallet(String string2, String string3, int n2) {
        this.CC.changeMaskedWallet(string2, string3, n2);
    }

    public void checkForPreAuthorization(int n2) {
        this.CC.checkForPreAuthorization(n2);
    }

    @Override
    public void connect() {
        this.CC.connect();
    }

    @Override
    public void disconnect() {
        this.CC.disconnect();
    }

    @Override
    public boolean isConnected() {
        return this.CC.isConnected();
    }

    @Override
    public boolean isConnecting() {
        return this.CC.isConnecting();
    }

    @Override
    public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks) {
        return this.CC.isConnectionCallbacksRegistered(connectionCallbacks);
    }

    @Override
    public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
        return this.CC.isConnectionFailedListenerRegistered(onConnectionFailedListener);
    }

    public void loadFullWallet(FullWalletRequest fullWalletRequest, int n2) {
        this.CC.loadFullWallet(fullWalletRequest, n2);
    }

    public void loadMaskedWallet(MaskedWalletRequest maskedWalletRequest, int n2) {
        this.CC.loadMaskedWallet(maskedWalletRequest, n2);
    }

    public void notifyTransactionStatus(NotifyTransactionStatusRequest notifyTransactionStatusRequest) {
        this.CC.notifyTransactionStatus(notifyTransactionStatusRequest);
    }

    @Override
    public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks) {
        this.CC.registerConnectionCallbacks(connectionCallbacks);
    }

    @Override
    public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.CC.registerConnectionFailedListener(onConnectionFailedListener);
    }

    @Override
    public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks) {
        this.CC.unregisterConnectionCallbacks(connectionCallbacks);
    }

    @Override
    public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.CC.unregisterConnectionFailedListener(onConnectionFailedListener);
    }
}

