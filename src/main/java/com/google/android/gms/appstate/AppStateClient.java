/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.android.gms.appstate;

import android.content.Context;
import com.google.android.gms.appstate.OnSignOutCompleteListener;
import com.google.android.gms.appstate.OnStateDeletedListener;
import com.google.android.gms.appstate.OnStateListLoadedListener;
import com.google.android.gms.appstate.OnStateLoadedListener;
import com.google.android.gms.appstate.b;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.internal.db;
import com.google.android.gms.internal.dg;
import com.google.android.gms.internal.du;

public final class AppStateClient
implements GooglePlayServicesClient {
    public static final int STATUS_CLIENT_RECONNECT_REQUIRED = 2;
    public static final int STATUS_DEVELOPER_ERROR = 7;
    public static final int STATUS_INTERNAL_ERROR = 1;
    public static final int STATUS_NETWORK_ERROR_NO_DATA = 4;
    public static final int STATUS_NETWORK_ERROR_OPERATION_DEFERRED = 5;
    public static final int STATUS_NETWORK_ERROR_OPERATION_FAILED = 6;
    public static final int STATUS_NETWORK_ERROR_STALE_DATA = 3;
    public static final int STATUS_OK = 0;
    public static final int STATUS_STATE_KEY_LIMIT_EXCEEDED = 2003;
    public static final int STATUS_STATE_KEY_NOT_FOUND = 2002;
    public static final int STATUS_WRITE_OUT_OF_DATE_VERSION = 2000;
    public static final int STATUS_WRITE_SIZE_EXCEEDED = 2001;
    private final db ju;

    private AppStateClient(Context context, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener, String string, String[] stringArray) {
        this.ju = new db(context, connectionCallbacks, onConnectionFailedListener, string, stringArray);
    }

    @Override
    public void connect() {
        this.ju.connect();
    }

    public void deleteState(final OnStateDeletedListener onStateDeletedListener, int n2) {
        this.ju.a(new a.c<b.b>(){

            @Override
            public void a(b.b b2) {
                onStateDeletedListener.onStateDeleted(b2.getStatus().getStatusCode(), b2.aK());
            }
        }, n2);
    }

    @Override
    public void disconnect() {
        this.ju.disconnect();
    }

    public int getMaxNumKeys() {
        return this.ju.getMaxNumKeys();
    }

    public int getMaxStateSize() {
        return this.ju.getMaxStateSize();
    }

    @Override
    public boolean isConnected() {
        return this.ju.isConnected();
    }

    @Override
    public boolean isConnecting() {
        return this.ju.isConnecting();
    }

    @Override
    public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks) {
        return this.ju.isConnectionCallbacksRegistered(connectionCallbacks);
    }

    @Override
    public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
        return this.ju.isConnectionFailedListenerRegistered(onConnectionFailedListener);
    }

    public void listStates(final OnStateListLoadedListener onStateListLoadedListener) {
        this.ju.a(new a.c<b.c>(){

            @Override
            public void a(b.c c2) {
                onStateListLoadedListener.onStateListLoaded(c2.getStatus().getStatusCode(), c2.aN());
            }
        });
    }

    public void loadState(OnStateLoadedListener onStateLoadedListener, int n2) {
        this.ju.b(new a(onStateLoadedListener), n2);
    }

    public void reconnect() {
        this.ju.disconnect();
        this.ju.connect();
    }

    @Override
    public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks) {
        this.ju.registerConnectionCallbacks(connectionCallbacks);
    }

    @Override
    public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.ju.registerConnectionFailedListener(onConnectionFailedListener);
    }

    public void resolveState(OnStateLoadedListener onStateLoadedListener, int n2, String string, byte[] byArray) {
        this.ju.a(new a(onStateLoadedListener), n2, string, byArray);
    }

    public void signOut() {
        this.ju.b(new a.c<Status>(){

            @Override
            public void a(Status status) {
            }
        });
    }

    public void signOut(final OnSignOutCompleteListener onSignOutCompleteListener) {
        du.c(onSignOutCompleteListener, "Must provide a valid listener");
        this.ju.b(new a.c<Status>(){

            @Override
            public void a(Status status) {
                onSignOutCompleteListener.onSignOutComplete();
            }
        });
    }

    @Override
    public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks) {
        this.ju.unregisterConnectionCallbacks(connectionCallbacks);
    }

    @Override
    public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.ju.unregisterConnectionFailedListener(onConnectionFailedListener);
    }

    public void updateState(int n2, byte[] byArray) {
        this.ju.a(new a(null), n2, byArray);
    }

    public void updateStateImmediate(OnStateLoadedListener onStateLoadedListener, int n2, byte[] byArray) {
        du.c(onStateLoadedListener, "Must provide a valid listener");
        this.ju.a(new a(onStateLoadedListener), n2, byArray);
    }

    public static final class Builder {
        private static final String[] jz = new String[]{"https://www.googleapis.com/auth/appstate"};
        private GooglePlayServicesClient.ConnectionCallbacks jA;
        private GooglePlayServicesClient.OnConnectionFailedListener jB;
        private String[] jC;
        private String jD;
        private Context mContext;

        public Builder(Context context, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
            this.mContext = context;
            this.jA = connectionCallbacks;
            this.jB = onConnectionFailedListener;
            this.jC = jz;
            this.jD = "<<default account>>";
        }

        public AppStateClient create() {
            return new AppStateClient(this.mContext, this.jA, this.jB, this.jD, this.jC);
        }

        public Builder setAccountName(String string) {
            this.jD = du.f(string);
            return this;
        }

        public Builder setScopes(String ... stringArray) {
            this.jC = stringArray;
            return this;
        }
    }

    private static final class a
    implements a.c<b.e> {
        private final OnStateLoadedListener jE;

        a(OnStateLoadedListener onStateLoadedListener) {
            this.jE = onStateLoadedListener;
        }

        @Override
        public void a(b.e result) {
            if (this.jE == null) {
                return;
            }
            if (result.getStatus().getStatusCode() == 2000) {
                result = result.aP();
                dg.d(result);
                this.jE.onStateConflict(result.aK(), result.aL(), result.getLocalData(), result.aM());
                return;
            }
            result = result.aO();
            dg.d(result);
            this.jE.onStateLoaded(result.getStatus().getStatusCode(), result.aK(), result.getLocalData());
        }
    }
}

