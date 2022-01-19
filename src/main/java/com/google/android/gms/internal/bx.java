/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.RemoteException
 */
package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.internal.ar;
import com.google.android.gms.internal.bw;
import com.google.android.gms.internal.by;
import com.google.android.gms.internal.bz;
import com.google.android.gms.internal.cb;
import com.google.android.gms.internal.cd;
import com.google.android.gms.internal.ce;
import com.google.android.gms.internal.cl;
import com.google.android.gms.internal.cs;

public abstract class bx
extends cl {
    private final bz fw;
    private final bw.a hl;

    public bx(bz bz2, bw.a a2) {
        this.fw = bz2;
        this.hl = a2;
    }

    private static cb a(cd object, bz bz2) {
        try {
            return object.b(bz2);
        }
        catch (RemoteException remoteException) {
            cs.b("Could not fetch ad response from ad request service.", remoteException);
            return null;
        }
    }

    @Override
    public final void ai() {
        try {
            Object object = this.al();
            if (object == null) {
                object = new cb(0);
            } else {
                cb cb2 = bx.a((cd)object, this.fw);
                object = cb2;
                if (cb2 == null) {
                    object = new cb(0);
                }
            }
            this.hl.a((cb)object);
            return;
        }
        finally {
            this.ak();
        }
    }

    public abstract void ak();

    public abstract cd al();

    @Override
    public final void onStop() {
        this.ak();
    }

    public static final class a
    extends bx {
        private final Context mContext;

        public a(Context context, bz bz2, bw.a a2) {
            super(bz2, a2);
            this.mContext = context;
        }

        @Override
        public void ak() {
        }

        @Override
        public cd al() {
            return ce.a(this.mContext, new ar());
        }
    }

    public static final class b
    extends bx
    implements GooglePlayServicesClient.ConnectionCallbacks,
    GooglePlayServicesClient.OnConnectionFailedListener {
        private final Object fx = new Object();
        private final bw.a hl;
        private final by hm;

        public b(Context context, bz bz2, bw.a a2) {
            super(bz2, a2);
            this.hl = a2;
            this.hm = new by(context, (GooglePlayServicesClient.ConnectionCallbacks)this, (GooglePlayServicesClient.OnConnectionFailedListener)this, bz2.ej.iH);
            this.hm.connect();
        }

        @Override
        public void ak() {
            Object object = this.fx;
            synchronized (object) {
                if (!this.hm.isConnected()) {
                    if (!this.hm.isConnecting()) return;
                }
                this.hm.disconnect();
                return;
            }
        }

        @Override
        public cd al() {
            Object object = this.fx;
            synchronized (object) {
                try {
                    return this.hm.ao();
                }
                catch (IllegalStateException illegalStateException) {
                    return null;
                }
            }
        }

        @Override
        public void onConnected(Bundle bundle) {
            this.start();
        }

        @Override
        public void onConnectionFailed(ConnectionResult connectionResult) {
            this.hl.a(new cb(0));
        }

        @Override
        public void onDisconnected() {
            cs.r("Disconnected from remote ad request service.");
        }
    }
}

