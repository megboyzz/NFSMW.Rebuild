/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 */
package com.google.android.gms.plus;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.internal.gq;
import com.google.android.gms.internal.gt;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.Collection;

public class PlusClient
implements GooglePlayServicesClient {
    final gq zl;

    PlusClient(gq gq2) {
        this.zl = gq2;
    }

    public void clearDefaultAccount() {
        this.zl.clearDefaultAccount();
    }

    @Override
    public void connect() {
        this.zl.connect();
    }

    @Override
    public void disconnect() {
        this.zl.disconnect();
    }

    gq ep() {
        return this.zl;
    }

    public String getAccountName() {
        return this.zl.getAccountName();
    }

    public Person getCurrentPerson() {
        return this.zl.getCurrentPerson();
    }

    @Override
    public boolean isConnected() {
        return this.zl.isConnected();
    }

    @Override
    public boolean isConnecting() {
        return this.zl.isConnecting();
    }

    @Override
    public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks) {
        return this.zl.isConnectionCallbacksRegistered(connectionCallbacks);
    }

    @Override
    public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
        return this.zl.isConnectionFailedListenerRegistered(onConnectionFailedListener);
    }

    public void loadMoments(OnMomentsLoadedListener onMomentsLoadedListener) {
        this.zl.loadMoments(onMomentsLoadedListener);
    }

    public void loadMoments(OnMomentsLoadedListener onMomentsLoadedListener, int n2, String string2, Uri uri, String string3, String string4) {
        this.zl.loadMoments(onMomentsLoadedListener, n2, string2, uri, string3, string4);
    }

    public void loadPeople(OnPeopleLoadedListener onPeopleLoadedListener, Collection<String> collection) {
        this.zl.a(onPeopleLoadedListener, collection);
    }

    public void loadPeople(OnPeopleLoadedListener onPeopleLoadedListener, String ... stringArray) {
        this.zl.a(onPeopleLoadedListener, stringArray);
    }

    public void loadVisiblePeople(OnPeopleLoadedListener onPeopleLoadedListener, int n2, String string2) {
        this.zl.loadVisiblePeople(onPeopleLoadedListener, n2, string2);
    }

    public void loadVisiblePeople(OnPeopleLoadedListener onPeopleLoadedListener, String string2) {
        this.zl.loadVisiblePeople(onPeopleLoadedListener, string2);
    }

    @Override
    public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks) {
        this.zl.registerConnectionCallbacks(connectionCallbacks);
    }

    @Override
    public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.zl.registerConnectionFailedListener(onConnectionFailedListener);
    }

    public void removeMoment(String string2) {
        this.zl.removeMoment(string2);
    }

    public void revokeAccessAndDisconnect(OnAccessRevokedListener onAccessRevokedListener) {
        this.zl.revokeAccessAndDisconnect(onAccessRevokedListener);
    }

    @Override
    public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks) {
        this.zl.unregisterConnectionCallbacks(connectionCallbacks);
    }

    @Override
    public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.zl.unregisterConnectionFailedListener(onConnectionFailedListener);
    }

    public void writeMoment(Moment moment) {
        this.zl.writeMoment(moment);
    }

    public static class Builder {
        private final GooglePlayServicesClient.OnConnectionFailedListener jB;
        private final Context mContext;
        private final GooglePlayServicesClient.ConnectionCallbacks zm;
        private final gt zn;

        public Builder(Context context, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
            this.mContext = context;
            this.zm = connectionCallbacks;
            this.jB = onConnectionFailedListener;
            this.zn = new gt(this.mContext);
        }

        public PlusClient build() {
            return new PlusClient(new gq(this.mContext, this.zn.eE(), this.zm, this.jB));
        }

        public Builder clearScopes() {
            this.zn.eD();
            return this;
        }

        public Builder setAccountName(String string2) {
            this.zn.ak(string2);
            return this;
        }

        public Builder setActions(String ... stringArray) {
            this.zn.e(stringArray);
            return this;
        }

        public Builder setScopes(String ... stringArray) {
            this.zn.d(stringArray);
            return this;
        }
    }

    public static interface OnAccessRevokedListener {
        public void onAccessRevoked(ConnectionResult var1);
    }

    public static interface OnMomentsLoadedListener {
        public void onMomentsLoaded(ConnectionResult var1, MomentBuffer var2, String var3, String var4);
    }

    public static interface OnPeopleLoadedListener {
        public void onPeopleLoaded(ConnectionResult var1, PersonBuffer var2, String var3);
    }

    public static interface OrderBy {
        public static final int ALPHABETICAL = 0;
        public static final int BEST = 1;
    }
}

