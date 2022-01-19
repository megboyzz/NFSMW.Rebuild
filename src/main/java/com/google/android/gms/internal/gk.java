/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.RemoteException
 */
package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.internal.dk;
import com.google.android.gms.internal.dq;
import com.google.android.gms.internal.gi;
import com.google.android.gms.internal.gj;
import com.google.android.gms.panorama.a;

public class gk
extends dk<gj> {
    public gk(Context context, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, connectionCallbacks, onConnectionFailedListener, null);
    }

    public void a(a.c<a.b> c2, Uri uri, boolean bl2) {
        Object object = bl2 ? uri : null;
        this.a(new b(null, c2, (Uri)object), uri, null, bl2);
    }

    @Override
    protected void a(dq dq2, dk.d d2) throws RemoteException {
        Bundle bundle = new Bundle();
        dq2.a(d2, 4132500, this.getContext().getPackageName(), bundle);
    }

    public void a(b b2, Uri uri, Bundle bundle, boolean bl2) {
        this.bB();
        if (bl2) {
            this.getContext().grantUriPermission("com.google.android.gms", uri, 1);
        }
        try {
            ((gj)this.bC()).a(b2, uri, bundle, bl2);
            return;
        }
        catch (RemoteException remoteException) {
            b2.a(8, null, 0, null);
            return;
        }
    }

    @Override
    protected String am() {
        return "com.google.android.gms.panorama.service.START";
    }

    @Override
    protected String an() {
        return "com.google.android.gms.panorama.internal.IPanoramaService";
    }

    public gj aq(IBinder iBinder) {
        return gj.a.ap(iBinder);
    }

    @Override
    public /* synthetic */ IInterface p(IBinder iBinder) {
        return this.aq(iBinder);
    }

    final class a
    extends dk.b<a.c<a.a>>
    implements a.a {
        public final int type;
        public final Status zf;
        public final Intent zg;

        public a(a.c<a.a> c2, Status status, int n2, Intent intent) {
            super(c2);
            this.zf = status;
            this.type = n2;
            this.zg = intent;
        }

        @Override
        protected void aQ() {
        }

        @Override
        protected /* synthetic */ void b(Object object) {
            this.c((a.c)object);
        }

        protected void c(a.c<a.a> c2) {
            c2.a(this);
        }

        @Override
        public Intent eo() {
            return this.zg;
        }

        @Override
        public Status getStatus() {
            return this.zf;
        }
    }

    final class b
    extends gi.a {
        private final a.c<a.a> zi;
        private final a.c<a.b> zj;
        private final Uri zk;

        public b(a.c<a.a> c2, a.c<a.b> c3, Uri uri) {
            this.zi = c2;
            this.zj = c3;
            this.zk = uri;
        }

        @Override
        public void a(int n2, Bundle object, int n3, Intent intent) {
            if (this.zk != null) {
                gk.this.getContext().revokeUriPermission(this.zk, 1);
            }
            object = object != null ? (PendingIntent)object.getParcelable("pendingIntent") : null;
            object = new Status(n2, null, (PendingIntent)object);
            if (this.zj != null) {
                gk.this.a(new c(this.zj, (Status)object, intent));
                return;
            }
            if (this.zi == null) return;
            gk.this.a(new a(this.zi, (Status)object, n3, intent));
        }
    }

    final class c
    extends dk.b<a.c<a.b>>
    implements a.b {
        private final Status zf;
        private final Intent zg;

        public c(a.c<a.b> c2, Status status, Intent intent) {
            super(c2);
            this.zf = status;
            this.zg = intent;
        }

        @Override
        protected void aQ() {
        }

        @Override
        protected /* synthetic */ void b(Object object) {
            this.c((a.c)object);
        }

        protected void c(a.c<a.b> c2) {
            c2.a(this);
        }

        @Override
        public Intent eo() {
            return this.zg;
        }

        @Override
        public Status getStatus() {
            return this.zf;
        }
    }
}

