/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.RemoteException
 */
package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.dk;
import com.google.android.gms.internal.dq;
import com.google.android.gms.internal.ek;
import com.google.android.gms.internal.gl;
import com.google.android.gms.internal.gm;
import com.google.android.gms.internal.gp;
import com.google.android.gms.internal.gs;
import com.google.android.gms.internal.gx;
import com.google.android.gms.internal.ha;
import com.google.android.gms.plus.PlusClient;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class gq
extends dk<gp>
implements GooglePlayServicesClient {
    private Person zx;
    private gs zy;

    public gq(Context context, gs gs2, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, connectionCallbacks, onConnectionFailedListener, gs2.ew());
        this.zy = gs2;
    }

    @Override
    protected void a(int n2, IBinder iBinder, Bundle bundle) {
        if (n2 == 0 && bundle != null && bundle.containsKey("loaded_person")) {
            this.zx = ha.g(bundle.getByteArray("loaded_person"));
        }
        super.a(n2, iBinder, bundle);
    }

    @Override
    protected void a(dq dq2, dk.d d2) throws RemoteException {
        Bundle bundle = new Bundle();
        bundle.putStringArray("request_visible_actions", this.zy.ex());
        dq2.a(d2, 4132500, this.zy.eA(), this.zy.ez(), this.bA(), this.zy.getAccountName(), bundle);
    }

    public void a(PlusClient.OnPeopleLoadedListener object, Collection<String> collection) {
        this.bB();
        object = new c((PlusClient.OnPeopleLoadedListener)object);
        try {
            ((gp)this.bC()).a((gm)object, new ArrayList<String>(collection));
            return;
        }
        catch (RemoteException remoteException) {
            ((c)object).a(DataHolder.empty(8), null);
            return;
        }
    }

    public void a(PlusClient.OnPeopleLoadedListener onPeopleLoadedListener, String[] stringArray) {
        this.a(onPeopleLoadedListener, Arrays.asList(stringArray));
    }

    public boolean aj(String string2) {
        return Arrays.asList(this.bA()).contains(string2);
    }

    @Override
    protected String am() {
        return "com.google.android.gms.plus.service.START";
    }

    @Override
    protected String an() {
        return "com.google.android.gms.plus.internal.IPlusService";
    }

    protected gp av(IBinder iBinder) {
        return gp.a.au(iBinder);
    }

    public void clearDefaultAccount() {
        this.bB();
        try {
            this.zx = null;
            ((gp)this.bC()).clearDefaultAccount();
            return;
        }
        catch (RemoteException remoteException) {
            throw new IllegalStateException(remoteException);
        }
    }

    public String getAccountName() {
        this.bB();
        try {
            return ((gp)this.bC()).getAccountName();
        }
        catch (RemoteException remoteException) {
            throw new IllegalStateException(remoteException);
        }
    }

    public Person getCurrentPerson() {
        this.bB();
        return this.zx;
    }

    public void loadMoments(PlusClient.OnMomentsLoadedListener onMomentsLoadedListener) {
        this.loadMoments(onMomentsLoadedListener, 20, null, null, null, "me");
    }

    public void loadMoments(PlusClient.OnMomentsLoadedListener object, int n2, String string2, Uri uri, String string3, String string4) {
        this.bB();
        object = object != null ? new a((PlusClient.OnMomentsLoadedListener)object) : null;
        try {
            ((gp)this.bC()).a((gm)object, n2, string2, uri, string3, string4);
            return;
        }
        catch (RemoteException remoteException) {
            ((a)object).a(DataHolder.empty(8), null, null);
            return;
        }
    }

    public void loadVisiblePeople(PlusClient.OnPeopleLoadedListener object, int n2, String string2) {
        this.bB();
        object = new c((PlusClient.OnPeopleLoadedListener)object);
        try {
            ((gp)this.bC()).a((gm)object, 1, n2, -1, string2);
            return;
        }
        catch (RemoteException remoteException) {
            ((c)object).a(DataHolder.empty(8), null);
            return;
        }
    }

    public void loadVisiblePeople(PlusClient.OnPeopleLoadedListener onPeopleLoadedListener, String string2) {
        this.loadVisiblePeople(onPeopleLoadedListener, 0, string2);
    }

    @Override
    protected /* synthetic */ IInterface p(IBinder iBinder) {
        return this.av(iBinder);
    }

    public void removeMoment(String string2) {
        this.bB();
        try {
            ((gp)this.bC()).removeMoment(string2);
            return;
        }
        catch (RemoteException remoteException) {
            throw new IllegalStateException(remoteException);
        }
    }

    public void revokeAccessAndDisconnect(PlusClient.OnAccessRevokedListener object) {
        this.bB();
        this.clearDefaultAccount();
        object = new e((PlusClient.OnAccessRevokedListener)object);
        try {
            ((gp)this.bC()).b((gm)object);
            return;
        }
        catch (RemoteException remoteException) {
            ((e)object).b(8, null);
            return;
        }
    }

    public void writeMoment(Moment object) {
        this.bB();
        try {
            object = ek.a((gx)object);
            ((gp)this.bC()).a((ek)object);
            return;
        }
        catch (RemoteException remoteException) {
            throw new IllegalStateException(remoteException);
        }
    }

    final class a
    extends gl {
        private final PlusClient.OnMomentsLoadedListener zz;

        public a(PlusClient.OnMomentsLoadedListener onMomentsLoadedListener) {
            this.zz = onMomentsLoadedListener;
        }

        @Override
        public void a(DataHolder dataHolder, String string2, String string3) {
            Object object = dataHolder.getMetadata() != null ? (PendingIntent)dataHolder.getMetadata().getParcelable("pendingIntent") : null;
            object = new ConnectionResult(dataHolder.getStatusCode(), (PendingIntent)object);
            if (!((ConnectionResult)object).isSuccess() && dataHolder != null) {
                if (!dataHolder.isClosed()) {
                    dataHolder.close();
                }
                dataHolder = null;
            }
            gq.this.a(new b(this.zz, (ConnectionResult)object, dataHolder, string2, string3));
        }
    }

    final class b
    extends dk.c<PlusClient.OnMomentsLoadedListener> {
        private final String oi;
        private final ConnectionResult zB;
        private final String zC;

        public b(PlusClient.OnMomentsLoadedListener onMomentsLoadedListener, ConnectionResult connectionResult, DataHolder dataHolder, String string2, String string3) {
            super(onMomentsLoadedListener, dataHolder);
            this.zB = connectionResult;
            this.oi = string2;
            this.zC = string3;
        }

        @Override
        protected void a(PlusClient.OnMomentsLoadedListener onMomentsLoadedListener, DataHolder object) {
            ConnectionResult connectionResult = this.zB;
            object = object != null ? new MomentBuffer((DataHolder)object) : null;
            onMomentsLoadedListener.onMomentsLoaded(connectionResult, (MomentBuffer)object, this.oi, this.zC);
        }
    }

    final class c
    extends gl {
        private final PlusClient.OnPeopleLoadedListener zD;

        public c(PlusClient.OnPeopleLoadedListener onPeopleLoadedListener) {
            this.zD = onPeopleLoadedListener;
        }

        @Override
        public void a(DataHolder dataHolder, String string2) {
            Object object = dataHolder.getMetadata() != null ? (PendingIntent)dataHolder.getMetadata().getParcelable("pendingIntent") : null;
            object = new ConnectionResult(dataHolder.getStatusCode(), (PendingIntent)object);
            if (!((ConnectionResult)object).isSuccess() && dataHolder != null) {
                if (!dataHolder.isClosed()) {
                    dataHolder.close();
                }
                dataHolder = null;
            }
            gq.this.a(new d(this.zD, (ConnectionResult)object, dataHolder, string2));
        }
    }

    final class d
    extends dk.c<PlusClient.OnPeopleLoadedListener> {
        private final String oi;
        private final ConnectionResult zB;

        public d(PlusClient.OnPeopleLoadedListener onPeopleLoadedListener, ConnectionResult connectionResult, DataHolder dataHolder, String string2) {
            super(onPeopleLoadedListener, dataHolder);
            this.zB = connectionResult;
            this.oi = string2;
        }

        @Override
        protected void a(PlusClient.OnPeopleLoadedListener onPeopleLoadedListener, DataHolder object) {
            ConnectionResult connectionResult = this.zB;
            object = object != null ? new PersonBuffer((DataHolder)object) : null;
            onPeopleLoadedListener.onPeopleLoaded(connectionResult, (PersonBuffer)object, this.oi);
        }
    }

    final class e
    extends gl {
        private final PlusClient.OnAccessRevokedListener zE;

        public e(PlusClient.OnAccessRevokedListener onAccessRevokedListener) {
            this.zE = onAccessRevokedListener;
        }

        @Override
        public void b(int n2, Bundle object) {
            PendingIntent pendingIntent = null;
            if (object != null) {
                pendingIntent = (PendingIntent)object.getParcelable("pendingIntent");
            }
            object = new ConnectionResult(n2, pendingIntent);
            gq.this.a(new f(this.zE, (ConnectionResult)object));
        }
    }

    final class f
    extends dk.b<PlusClient.OnAccessRevokedListener> {
        private final ConnectionResult zB;

        public f(PlusClient.OnAccessRevokedListener onAccessRevokedListener, ConnectionResult connectionResult) {
            super(onAccessRevokedListener);
            this.zB = connectionResult;
        }

        protected void a(PlusClient.OnAccessRevokedListener onAccessRevokedListener) {
            gq.this.disconnect();
            if (onAccessRevokedListener == null) return;
            onAccessRevokedListener.onAccessRevoked(this.zB);
        }

        @Override
        protected void aQ() {
        }

        @Override
        protected /* synthetic */ void b(Object object) {
            this.a((PlusClient.OnAccessRevokedListener)object);
        }
    }
}

