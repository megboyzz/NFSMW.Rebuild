/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.view.View
 */
package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.internal.dh;
import com.google.android.gms.internal.dl;
import com.google.android.gms.internal.du;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public final class GoogleApiClient {
    private final dl kB;
    private final Queue<a<?>> kC;
    private ConnectionResult kD;
    private int kE;
    private int kF = 3;
    private int kG;
    private final Bundle kH;
    private final Map<Api.b<?>, Api.a> kI;
    private boolean kJ;
    private final ConnectionCallbacks kK;
    private final dl.b kL;
    private final Object kt = new Object();

    private GoogleApiClient(Context context, dh dh2, Map<Api, ApiOptions> map, Set<ConnectionCallbacks> iterator, final Set<OnConnectionFailedListener> b2) {
        Object object;
        this.kC = new LinkedList();
        this.kH = new Bundle();
        this.kI = new HashMap();
        this.kK = new ConnectionCallbacks(){

            @Override
            public void onConnected(Bundle bundle) {
                Object object = GoogleApiClient.this.kt;
                synchronized (object) {
                    if (GoogleApiClient.this.kF != 1) return;
                    if (bundle != null) {
                        GoogleApiClient.this.kH.putAll(bundle);
                    }
                    GoogleApiClient.this.aY();
                    return;
                }
            }

            @Override
            public void onDisconnected() {
                GoogleApiClient.this.ba();
            }
        };
        this.kL = new dl.b(){

            @Override
            public boolean bb() {
                return GoogleApiClient.this.kJ;
            }

            @Override
            public Bundle bc() {
                return null;
            }

            @Override
            public boolean isConnected() {
                return GoogleApiClient.this.isConnected();
            }
        };
        this.kB = new dl(context, this.kL);
        iterator = iterator.iterator();
        while (iterator.hasNext()) {
            object = (ConnectionCallbacks)iterator.next();
            this.kB.registerConnectionCallbacks((GooglePlayServicesClient.ConnectionCallbacks)object);
        }
        iterator = b2.iterator();
        while (iterator.hasNext()) {
            b2 = iterator.next();
            this.kB.registerConnectionFailedListener((GooglePlayServicesClient.OnConnectionFailedListener)((Object)b2));
        }
        iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            object = (Api)iterator.next();
            b2 = ((Api)object).aV();
            object = map.get(object);
            this.kI.put(b2, (Api.a)b2.b(context, dh2, (ApiOptions)object, this.kK, new OnConnectionFailedListener(){

                @Override
                public void onConnectionFailed(ConnectionResult connectionResult) {
                    Object object = GoogleApiClient.this.kt;
                    synchronized (object) {
                        if (GoogleApiClient.this.kD == null || b2.getPriority() < GoogleApiClient.this.kE) {
                            GoogleApiClient.a(GoogleApiClient.this, connectionResult);
                            GoogleApiClient.a(GoogleApiClient.this, b2.getPriority());
                        }
                        GoogleApiClient.this.aY();
                        return;
                    }
                }
            }));
        }
    }

    static /* synthetic */ int a(GoogleApiClient googleApiClient, int n2) {
        googleApiClient.kE = n2;
        return n2;
    }

    static /* synthetic */ ConnectionResult a(GoogleApiClient googleApiClient, ConnectionResult connectionResult) {
        googleApiClient.kD = connectionResult;
        return connectionResult;
    }

    private <A extends Api.a> void a(a<A> a2) {
        Object object = this.kt;
        synchronized (object) {
            du.a(this.isConnected(), "GoogleApiClient is not connected yet.");
            boolean bl2 = a2.aV() != null;
            du.a(bl2, "This task can not be executed or enqueued (it's probably a Batch or malformed)");
            a2.a(this.a((a.a)((Object)a2.aV())));
            return;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private void aY() {
        Object object = this.kt;
        synchronized (object) {
            --this.kG;
            if (this.kG != 0) return;
            if (this.kD != null) {
                this.kF = 3;
                Iterator<Api.a> iterator = this.kI.values().iterator();
                while (iterator.hasNext()) {
                    iterator.next().disconnect();
                }
                this.kB.a(this.kD);
            } else {
                this.kF = 2;
                Bundle bundle = this.kH.isEmpty() ? null : this.kH;
                this.kB.b(bundle);
                this.aZ();
            }
            return;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private void aZ() {
        du.a(this.isConnected(), "GoogleApiClient is not connected yet.");
        Object object = this.kt;
        synchronized (object) {
            while (!this.kC.isEmpty()) {
                this.a((a.a)this.kC.remove());
            }
            return;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private void ba() {
        Object object = this.kt;
        synchronized (object) {
            this.kJ = false;
            this.kC.clear();
            Iterator<Api.a> iterator = this.kI.values().iterator();
            while (true) {
                if (!iterator.hasNext()) {
                    if (this.kF == 3) return;
                    this.kF = 3;
                    this.kB.bG();
                    return;
                }
                iterator.next().disconnect();
            }
        }
    }

    public <C extends Api.a> C a(Api.b<C> object) {
        object = this.kI.get(object);
        du.c(object, "Appropriate Api was not requested.");
        return (C)object;
    }

    public <A extends Api.a, T extends a.a<?, ?, A>> T a(T t2) {
        Object object = this.kt;
        synchronized (object) {
            if (this.isConnected()) {
                this.b(t2);
            } else {
                this.kC.add(t2);
            }
            return t2;
        }
    }

    public <A extends Api.a, T extends a.a<?, ?, A>> T b(T t2) {
        du.a(this.isConnected(), "GoogleApiClient is not connected yet.");
        this.aZ();
        this.a(t2);
        return t2;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void connect() {
        Object object = this.kt;
        synchronized (object) {
            if (this.isConnected()) return;
            if (this.isConnecting()) {
                return;
            }
            this.kJ = true;
            this.kD = null;
            this.kF = 1;
            this.kH.clear();
            this.kG = this.kI.size();
            Iterator<Api.a> iterator = this.kI.values().iterator();
            while (iterator.hasNext()) {
                iterator.next().connect();
            }
            return;
        }
    }

    public void disconnect() {
        this.ba();
    }

    public boolean isConnected() {
        Object object = this.kt;
        synchronized (object) {
            if (this.kF != 2) return false;
            return true;
        }
    }

    public boolean isConnecting() {
        boolean bl2 = true;
        Object object = this.kt;
        synchronized (object) {
            if (this.kF != 1) return false;
            return bl2;
        }
    }

    public boolean isConnectionCallbacksRegistered(ConnectionCallbacks connectionCallbacks) {
        return this.kB.isConnectionCallbacksRegistered(connectionCallbacks);
    }

    public boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener onConnectionFailedListener) {
        return this.kB.isConnectionFailedListenerRegistered(onConnectionFailedListener);
    }

    public void reconnect() {
        this.disconnect();
        this.connect();
    }

    public void registerConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
        this.kB.registerConnectionCallbacks(connectionCallbacks);
    }

    public void registerConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
        this.kB.registerConnectionFailedListener(onConnectionFailedListener);
    }

    public void unregisterConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
        this.kB.unregisterConnectionCallbacks(connectionCallbacks);
    }

    public void unregisterConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
        this.kB.unregisterConnectionFailedListener(onConnectionFailedListener);
    }

    public static interface ApiOptions {
    }

    public static final class Builder {
        private String jD;
        private final Set<String> kO = new HashSet<String>();
        private int kP;
        private View kQ;
        private String kR;
        private final Map<Api, ApiOptions> kS = new HashMap<Api, ApiOptions>();
        private final Set<ConnectionCallbacks> kT = new HashSet<ConnectionCallbacks>();
        private final Set<OnConnectionFailedListener> kU = new HashSet<OnConnectionFailedListener>();
        private final Context mContext;

        public Builder(Context context) {
            this.mContext = context;
            this.kR = context.getPackageName();
        }

        public Builder(Context context, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            this(context);
            du.c(connectionCallbacks, "Must provide a connected listener");
            this.kT.add(connectionCallbacks);
            du.c(onConnectionFailedListener, "Must provide a connection failed listener");
            this.kU.add(onConnectionFailedListener);
        }

        public Builder addApi(Api api) {
            return this.addApi(api, null);
        }

        public Builder addApi(Api object, ApiOptions apiOptions) {
            this.kS.put((Api)object, apiOptions);
            object = ((Api)object).aW();
            int n2 = object.size();
            int n3 = 0;
            while (n3 < n2) {
                this.kO.add(((Scope)object.get(n3)).be());
                ++n3;
            }
            return this;
        }

        public Builder addConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
            this.kT.add(connectionCallbacks);
            return this;
        }

        public Builder addOnConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
            this.kU.add(onConnectionFailedListener);
            return this;
        }

        public Builder addScope(Scope scope) {
            this.kO.add(scope.be());
            return this;
        }

        public dh bd() {
            return new dh(this.jD, this.kO, this.kP, this.kQ, this.kR);
        }

        public GoogleApiClient build() {
            return new GoogleApiClient(this.mContext, this.bd(), this.kS, this.kT, this.kU);
        }

        public Builder setAccountName(String string2) {
            this.jD = string2;
            return this;
        }

        public Builder setGravityForPopups(int n2) {
            this.kP = n2;
            return this;
        }

        public Builder setViewForPopups(View view) {
            this.kQ = view;
            return this;
        }

        public Builder useDefaultAccount() {
            return this.setAccountName("<<default account>>");
        }
    }

    public static interface ConnectionCallbacks
    extends GooglePlayServicesClient.ConnectionCallbacks {
    }

    public static interface OnConnectionFailedListener
    extends GooglePlayServicesClient.OnConnectionFailedListener {
    }

    public static interface a<A extends Api.a> {
        public void a(A var1);

        public Api.b<A> aV();
    }
}

