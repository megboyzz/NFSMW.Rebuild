/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.RemoteException
 *  android.util.Log
 */
package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.appstate.AppStateBuffer;
import com.google.android.gms.appstate.b;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.da;
import com.google.android.gms.internal.dc;
import com.google.android.gms.internal.dd;
import com.google.android.gms.internal.dk;
import com.google.android.gms.internal.dp;
import com.google.android.gms.internal.dq;
import com.google.android.gms.internal.du;

public final class db
extends dk<dd> {
    private final String jD;

    public db(Context context, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener, String string2, String[] stringArray) {
        super(context, connectionCallbacks, onConnectionFailedListener, stringArray);
        this.jD = du.f(string2);
    }

    @Override
    public void a(a.c<b.c> c2) {
        try {
            ((dd)this.bC()).a(new c(c2));
            return;
        }
        catch (RemoteException remoteException) {
            Log.w((String)"AppStateClient", (String)"service died");
            return;
        }
    }

    public void a(a.c<b.b> c2, int n2) {
        try {
            ((dd)this.bC()).b(new a(c2), n2);
            return;
        }
        catch (RemoteException remoteException) {
            Log.w((String)"AppStateClient", (String)"service died");
            return;
        }
    }

    public void a(a.c<b.e> c2, int n2, String string2, byte[] byArray) {
        try {
            ((dd)this.bC()).a(new e(c2), n2, string2, byArray);
            return;
        }
        catch (RemoteException remoteException) {
            Log.w((String)"AppStateClient", (String)"service died");
            return;
        }
    }

    /*
     * Unable to fully structure code
     */
    public void a(a.c<b.e> var1_1, int var2_3, byte[] var3_4) {
        if (var1_1 != null) ** GOTO lbl-1000
        var1_1 = null;
        try {}
        catch (RemoteException var1_2) {
            Log.w((String)"AppStateClient", (String)"service died");
            return;
        }
        ** GOTO lbl10
lbl-1000:
        // 1 sources

        {
            var1_1 = new e((a.c<b.e>)var1_1);
lbl10:
            // 2 sources

            ((dd)this.bC()).a((dc)var1_1, var2_3, var3_4);
            return;
        }
    }

    @Override
    protected void a(dq dq2, dk.d d2) throws RemoteException {
        dq2.a((dp)d2, 4132500, this.getContext().getPackageName(), this.jD, this.bA());
    }

    @Override
    protected void a(String ... stringArray) {
        int n2 = 0;
        boolean bl2 = false;
        while (true) {
            if (n2 >= stringArray.length) {
                du.a(bl2, String.format("App State APIs requires %s to function.", "https://www.googleapis.com/auth/appstate"));
                return;
            }
            if (stringArray[n2].equals("https://www.googleapis.com/auth/appstate")) {
                bl2 = true;
            }
            ++n2;
        }
    }

    @Override
    protected String am() {
        return "com.google.android.gms.appstate.service.START";
    }

    @Override
    protected String an() {
        return "com.google.android.gms.appstate.internal.IAppStateService";
    }

    public void b(a.c<Status> c2) {
        try {
            ((dd)this.bC()).b(new g(c2));
            return;
        }
        catch (RemoteException remoteException) {
            Log.w((String)"AppStateClient", (String)"service died");
            return;
        }
    }

    public void b(a.c<b.e> c2, int n2) {
        try {
            ((dd)this.bC()).a(new e(c2), n2);
            return;
        }
        catch (RemoteException remoteException) {
            Log.w((String)"AppStateClient", (String)"service died");
            return;
        }
    }

    public int getMaxNumKeys() {
        try {
            return ((dd)this.bC()).getMaxNumKeys();
        }
        catch (RemoteException remoteException) {
            Log.w((String)"AppStateClient", (String)"service died");
            return 2;
        }
    }

    public int getMaxStateSize() {
        try {
            return ((dd)this.bC()).getMaxStateSize();
        }
        catch (RemoteException remoteException) {
            Log.w((String)"AppStateClient", (String)"service died");
            return 2;
        }
    }

    @Override
    protected /* synthetic */ IInterface p(IBinder iBinder) {
        return this.r(iBinder);
    }

    protected dd r(IBinder iBinder) {
        return dd.a.t(iBinder);
    }

    final class a
    extends da {
        private final a.c<b.b> jN;

        public a(a.c<b.b> c2) {
            this.jN = du.c(c2, "Result holder must not be null");
        }

        @Override
        public void onStateDeleted(int n2, int n3) {
            Status status = new Status(n2);
            db.this.a(new b(this.jN, status, n3));
        }
    }

    final class b
    extends dk.b<a.c<b.b>>
    implements b.b {
        private final Status jP;
        private final int jQ;

        public b(a.c<b.b> c2, Status status, int n2) {
            super(c2);
            this.jP = status;
            this.jQ = n2;
        }

        @Override
        public int aK() {
            return this.jQ;
        }

        @Override
        protected void aQ() {
        }

        @Override
        public /* synthetic */ void b(Object object) {
            this.c((a.c)object);
        }

        public void c(a.c<b.b> c2) {
            c2.a(this);
        }

        @Override
        public Status getStatus() {
            return this.jP;
        }
    }

    final class c
    extends da {
        private final a.c<b.c> jN;

        public c(a.c<b.c> c2) {
            this.jN = du.c(c2, "Result holder must not be null");
        }

        @Override
        public void a(DataHolder dataHolder) {
            Status status = new Status(dataHolder.getStatusCode());
            db.this.a(new d(this.jN, status, dataHolder));
        }
    }

    final class d
    extends dk.c<a.c<b.c>>
    implements b.c {
        private final Status jP;
        private final AppStateBuffer jR;

        public d(a.c<b.c> c2, Status status, DataHolder dataHolder) {
            super(c2, dataHolder);
            this.jP = status;
            this.jR = new AppStateBuffer(dataHolder);
        }

        @Override
        public void a(a.c<b.c> c2, DataHolder dataHolder) {
            c2.a(this);
        }

        @Override
        public AppStateBuffer aN() {
            return this.jR;
        }

        @Override
        public Status getStatus() {
            return this.jP;
        }

        @Override
        public void release() {
            if (this.jR == null) return;
            this.jR.close();
        }
    }

    final class e
    extends da {
        private final a.c<b.e> jN;

        public e(a.c<b.e> c2) {
            this.jN = du.c(c2, "Result holder must not be null");
        }

        @Override
        public void a(int n2, DataHolder dataHolder) {
            db.this.a(new f(this.jN, n2, dataHolder));
        }
    }

    final class f
    extends dk.c<a.c<b.e>>
    implements b.a,
    b.d,
    b.e {
        private final Status jP;
        private final int jQ;
        private final AppStateBuffer jR;

        public f(a.c<b.e> c2, int n2, DataHolder dataHolder) {
            super(c2, dataHolder);
            this.jQ = n2;
            this.jP = new Status(dataHolder.getStatusCode());
            this.jR = new AppStateBuffer(dataHolder);
        }

        private boolean aR() {
            if (this.jP.getStatusCode() != 2000) return false;
            return true;
        }

        @Override
        public void a(a.c<b.e> c2, DataHolder dataHolder) {
            c2.a(this);
        }

        @Override
        public int aK() {
            return this.jQ;
        }

        @Override
        public String aL() {
            if (this.jR.getCount() != 0) return this.jR.get(0).getConflictVersion();
            return null;
        }

        @Override
        public byte[] aM() {
            if (this.jR.getCount() != 0) return this.jR.get(0).getConflictData();
            return null;
        }

        @Override
        public b.d aO() {
            f f2 = this;
            if (!this.aR()) return f2;
            return null;
        }

        @Override
        public b.a aP() {
            if (!this.aR()) return null;
            return this;
        }

        @Override
        public byte[] getLocalData() {
            if (this.jR.getCount() != 0) return this.jR.get(0).getLocalData();
            return null;
        }

        @Override
        public Status getStatus() {
            return this.jP;
        }

        @Override
        public void release() {
            if (this.jR == null) return;
            this.jR.close();
        }
    }

    final class g
    extends da {
        a.c<Status> jN;

        public g(a.c<Status> c2) {
            this.jN = du.c(c2, "Holder must not be null");
        }

        @Override
        public void onSignOutComplete() {
            Status status = new Status(0);
            db.this.a(new h(this.jN, status));
        }
    }

    final class h
    extends dk.b<a.c<Status>> {
        private final Status jP;

        public h(a.c<Status> c2, Status status) {
            super(c2);
            this.jP = status;
        }

        @Override
        protected void aQ() {
        }

        @Override
        public /* synthetic */ void b(Object object) {
            this.c((a.c)object);
        }

        public void c(a.c<Status> c2) {
            c2.a(this.jP);
        }
    }
}

