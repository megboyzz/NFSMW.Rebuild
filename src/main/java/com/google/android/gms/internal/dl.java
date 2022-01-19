/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  android.util.Log
 */
package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.internal.du;
import java.util.ArrayList;

public final class dl {
    private final Handler mHandler;
    private final b mM;
    private ArrayList<GooglePlayServicesClient.ConnectionCallbacks> mN;
    final ArrayList<GooglePlayServicesClient.ConnectionCallbacks> mO = new ArrayList();
    private boolean mP = false;
    private ArrayList<GooglePlayServicesClient.OnConnectionFailedListener> mQ;
    private boolean mR = false;

    public dl(Context context, b b2) {
        this(context, b2, null);
    }

    dl(Context object, b b2, Handler handler) {
        object = handler;
        if (handler == null) {
            object = new a(Looper.getMainLooper());
        }
        this.mN = new ArrayList();
        this.mQ = new ArrayList();
        this.mM = b2;
        this.mHandler = object;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void a(ConnectionResult connectionResult) {
        this.mHandler.removeMessages(1);
        ArrayList<GooglePlayServicesClient.OnConnectionFailedListener> arrayList = this.mQ;
        synchronized (arrayList) {
            this.mR = true;
            ArrayList<GooglePlayServicesClient.OnConnectionFailedListener> arrayList2 = this.mQ;
            int n2 = arrayList2.size();
            int n3 = 0;
            while (true) {
                if (n3 >= n2) {
                    this.mR = false;
                    return;
                }
                if (!this.mM.bb()) {
                    return;
                }
                if (this.mQ.contains(arrayList2.get(n3))) {
                    arrayList2.get(n3).onConnectionFailed(connectionResult);
                }
                ++n3;
            }
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void b(Bundle bundle) {
        boolean bl2 = true;
        ArrayList<GooglePlayServicesClient.ConnectionCallbacks> arrayList = this.mN;
        synchronized (arrayList) {
            boolean bl3 = !this.mP;
            du.n(bl3);
            this.mHandler.removeMessages(1);
            this.mP = true;
            bl3 = this.mO.size() == 0 ? bl2 : false;
            du.n(bl3);
            ArrayList<GooglePlayServicesClient.ConnectionCallbacks> arrayList2 = this.mN;
            int n2 = arrayList2.size();
            int n3 = 0;
            while (true) {
                if (n3 >= n2 || !this.mM.bb() || !this.mM.isConnected()) {
                    this.mO.clear();
                    this.mP = false;
                    return;
                }
                this.mO.size();
                if (!this.mO.contains(arrayList2.get(n3))) {
                    arrayList2.get(n3).onConnected(bundle);
                }
                ++n3;
            }
        }
    }

    protected void bF() {
        ArrayList<GooglePlayServicesClient.ConnectionCallbacks> arrayList = this.mN;
        synchronized (arrayList) {
            this.b(this.mM.bc());
            return;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void bG() {
        this.mHandler.removeMessages(1);
        ArrayList<GooglePlayServicesClient.ConnectionCallbacks> arrayList = this.mN;
        synchronized (arrayList) {
            this.mP = true;
            ArrayList<GooglePlayServicesClient.ConnectionCallbacks> arrayList2 = this.mN;
            int n2 = arrayList2.size();
            int n3 = 0;
            while (true) {
                if (n3 >= n2 || !this.mM.bb()) {
                    this.mP = false;
                    return;
                }
                if (this.mN.contains(arrayList2.get(n3))) {
                    arrayList2.get(n3).onDisconnected();
                }
                ++n3;
            }
        }
    }

    public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks) {
        du.f(connectionCallbacks);
        ArrayList<GooglePlayServicesClient.ConnectionCallbacks> arrayList = this.mN;
        synchronized (arrayList) {
            return this.mN.contains(connectionCallbacks);
        }
    }

    public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
        du.f(onConnectionFailedListener);
        ArrayList<GooglePlayServicesClient.OnConnectionFailedListener> arrayList = this.mQ;
        synchronized (arrayList) {
            return this.mQ.contains(onConnectionFailedListener);
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks) {
        du.f(connectionCallbacks);
        ArrayList<GooglePlayServicesClient.ConnectionCallbacks> arrayList = this.mN;
        synchronized (arrayList) {
            if (this.mN.contains(connectionCallbacks)) {
                Log.w((String)"GmsClientEvents", (String)("registerConnectionCallbacks(): listener " + connectionCallbacks + " is already registered"));
            } else {
                if (this.mP) {
                    this.mN = new ArrayList<GooglePlayServicesClient.ConnectionCallbacks>(this.mN);
                }
                this.mN.add(connectionCallbacks);
            }
        }
        if (!this.mM.isConnected()) return;
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, (Object)connectionCallbacks));
    }

    public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
        du.f(onConnectionFailedListener);
        ArrayList<GooglePlayServicesClient.OnConnectionFailedListener> arrayList = this.mQ;
        synchronized (arrayList) {
            if (this.mQ.contains(onConnectionFailedListener)) {
                Log.w((String)"GmsClientEvents", (String)("registerConnectionFailedListener(): listener " + onConnectionFailedListener + " is already registered"));
            } else {
                if (this.mR) {
                    this.mQ = new ArrayList<GooglePlayServicesClient.OnConnectionFailedListener>(this.mQ);
                }
                this.mQ.add(onConnectionFailedListener);
            }
            return;
        }
    }

    public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks) {
        du.f(connectionCallbacks);
        ArrayList<GooglePlayServicesClient.ConnectionCallbacks> arrayList = this.mN;
        synchronized (arrayList) {
            if (this.mN == null) return;
            if (this.mP) {
                this.mN = new ArrayList<GooglePlayServicesClient.ConnectionCallbacks>(this.mN);
            }
            if (!this.mN.remove(connectionCallbacks)) {
                Log.w((String)"GmsClientEvents", (String)("unregisterConnectionCallbacks(): listener " + connectionCallbacks + " not found"));
            } else {
                if (!this.mP) return;
                if (this.mO.contains(connectionCallbacks)) return;
                this.mO.add(connectionCallbacks);
            }
            return;
        }
    }

    public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
        du.f(onConnectionFailedListener);
        ArrayList<GooglePlayServicesClient.OnConnectionFailedListener> arrayList = this.mQ;
        synchronized (arrayList) {
            if (this.mQ == null) return;
            if (this.mR) {
                this.mQ = new ArrayList<GooglePlayServicesClient.OnConnectionFailedListener>(this.mQ);
            }
            if (this.mQ.remove(onConnectionFailedListener)) return;
            Log.w((String)"GmsClientEvents", (String)("unregisterConnectionFailedListener(): listener " + onConnectionFailedListener + " not found"));
            return;
        }
    }

    final class a
    extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            if (message.what != 1) {
                Log.wtf((String)"GmsClientEvents", (String)"Don't know how to handle this message.");
                return;
            }
            ArrayList arrayList = dl.this.mN;
            synchronized (arrayList) {
                if (!dl.this.mM.bb()) return;
                if (!dl.this.mM.isConnected()) return;
                if (!dl.this.mN.contains(message.obj)) return;
                Bundle bundle = dl.this.mM.bc();
                ((GooglePlayServicesClient.ConnectionCallbacks)message.obj).onConnected(bundle);
                return;
            }
        }
    }

    public static interface b {
        public boolean bb();

        public Bundle bc();

        public boolean isConnected();
    }
}

