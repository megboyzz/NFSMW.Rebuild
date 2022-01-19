/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.location.Location
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Looper
 *  android.os.RemoteException
 *  android.util.Log
 */
package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.internal.dg;
import com.google.android.gms.internal.dk;
import com.google.android.gms.internal.dq;
import com.google.android.gms.internal.du;
import com.google.android.gms.internal.fj;
import com.google.android.gms.internal.fk;
import com.google.android.gms.internal.fl;
import com.google.android.gms.internal.fn;
import com.google.android.gms.internal.fp;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationStatusCodes;
import java.util.HashMap;
import java.util.List;

public class fm
extends dk<fk> {
    private final fp<fk> tM = new c();
    private final fl tS;
    private final HashMap tT = new HashMap();
    private final String tU;

    public fm(Context context, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener, String string2) {
        super(context, connectionCallbacks, onConnectionFailedListener, new String[0]);
        this.tS = new fl(context, this.tM);
        this.tU = string2;
    }

    protected fk J(IBinder iBinder) {
        return fk.a.I(iBinder);
    }

    @Override
    protected void a(dq dq2, dk.d d2) throws RemoteException {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", this.tU);
        dq2.e(d2, 4132500, this.getContext().getPackageName(), bundle);
    }

    /*
     * Unable to fully structure code
     */
    public void addGeofences(List<fn> var1_1, PendingIntent var2_3, LocationClient.OnAddGeofencesResultListener var3_4) {
        this.bB();
        var4_5 = var1_1 != null && var1_1.size() > 0;
        du.b(var4_5, "At least one geofence must be specified.");
        du.c(var2_3, "PendingIntent must be specified.");
        du.c(var3_4, "OnAddGeofencesResultListener not provided.");
        if (var3_4 != null) ** GOTO lbl-1000
        var3_4 = null;
        try {}
        catch (RemoteException var1_2) {
            throw new IllegalStateException(var1_2);
        }
        ** GOTO lbl15
lbl-1000:
        // 1 sources

        {
            var3_4 = new b((LocationClient.OnAddGeofencesResultListener)var3_4, this);
lbl15:
            // 2 sources

            ((fk)this.bC()).a(var1_1, var2_3, (fj)var3_4, this.getContext().getPackageName());
            return;
        }
    }

    @Override
    protected String am() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    @Override
    protected String an() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    @Override
    public void disconnect() {
        fl fl2 = this.tS;
        synchronized (fl2) {
            if (this.isConnected()) {
                this.tS.removeAllListeners();
                this.tS.dq();
            }
            super.disconnect();
            return;
        }
    }

    public Location getLastLocation() {
        return this.tS.getLastLocation();
    }

    @Override
    protected /* synthetic */ IInterface p(IBinder iBinder) {
        return this.J(iBinder);
    }

    public void removeActivityUpdates(PendingIntent pendingIntent) {
        this.bB();
        du.f(pendingIntent);
        try {
            ((fk)this.bC()).removeActivityUpdates(pendingIntent);
            return;
        }
        catch (RemoteException remoteException) {
            throw new IllegalStateException(remoteException);
        }
    }

    /*
     * Unable to fully structure code
     */
    public void removeGeofences(PendingIntent var1_1, LocationClient.OnRemoveGeofencesResultListener var2_3) {
        this.bB();
        du.c(var1_1, "PendingIntent must be specified.");
        du.c(var2_3, "OnRemoveGeofencesResultListener not provided.");
        if (var2_3 != null) ** GOTO lbl-1000
        var2_3 = null;
        try {}
        catch (RemoteException var1_2) {
            throw new IllegalStateException(var1_2);
        }
        ** GOTO lbl13
lbl-1000:
        // 1 sources

        {
            var2_3 = new b((LocationClient.OnRemoveGeofencesResultListener)var2_3, this);
lbl13:
            // 2 sources

            ((fk)this.bC()).a(var1_1, (fj)var2_3, this.getContext().getPackageName());
            return;
        }
    }

    /*
     * Unable to fully structure code
     */
    public void removeGeofences(List<String> var1_1, LocationClient.OnRemoveGeofencesResultListener var2_3) {
        this.bB();
        var3_4 = var1_1 != null && var1_1.size() > 0;
        du.b(var3_4, "geofenceRequestIds can't be null nor empty.");
        du.c(var2_3, "OnRemoveGeofencesResultListener not provided.");
        var4_5 = var1_1.toArray(new String[0]);
        if (var2_3 != null) ** GOTO lbl-1000
        var1_1 = null;
        try {}
        catch (RemoteException var1_2) {
            throw new IllegalStateException(var1_2);
        }
        ** GOTO lbl14
lbl-1000:
        // 1 sources

        {
            var1_1 = new b(var2_3, this);
lbl14:
            // 2 sources

            ((fk)this.bC()).a(var4_5, (fj)var1_1, this.getContext().getPackageName());
            return;
        }
    }

    public void removeLocationUpdates(PendingIntent pendingIntent) {
        this.tS.removeLocationUpdates(pendingIntent);
    }

    public void removeLocationUpdates(LocationListener locationListener) {
        this.tS.removeLocationUpdates(locationListener);
    }

    public void requestActivityUpdates(long l2, PendingIntent pendingIntent) {
        boolean bl2 = true;
        this.bB();
        du.f(pendingIntent);
        if (l2 < 0L) {
            bl2 = false;
        }
        du.b(bl2, "detectionIntervalMillis must be >= 0");
        try {
            ((fk)this.bC()).a(l2, true, pendingIntent);
            return;
        }
        catch (RemoteException remoteException) {
            throw new IllegalStateException(remoteException);
        }
    }

    public void requestLocationUpdates(LocationRequest locationRequest, PendingIntent pendingIntent) {
        this.tS.requestLocationUpdates(locationRequest, pendingIntent);
    }

    public void requestLocationUpdates(LocationRequest locationRequest, LocationListener locationListener) {
        this.requestLocationUpdates(locationRequest, locationListener, null);
    }

    public void requestLocationUpdates(LocationRequest locationRequest, LocationListener locationListener, Looper looper) {
        fl fl2 = this.tS;
        synchronized (fl2) {
            this.tS.requestLocationUpdates(locationRequest, locationListener, looper);
            return;
        }
    }

    public void setMockLocation(Location location) {
        this.tS.setMockLocation(location);
    }

    public void setMockMode(boolean bl2) {
        this.tS.setMockMode(bl2);
    }

    private final class a
    extends dk.b<LocationClient.OnAddGeofencesResultListener> {
        private final int ka;
        private final String[] tV;

        public a(LocationClient.OnAddGeofencesResultListener onAddGeofencesResultListener, int n2, String[] stringArray) {
            super(onAddGeofencesResultListener);
            this.ka = LocationStatusCodes.aD(n2);
            this.tV = stringArray;
        }

        protected void a(LocationClient.OnAddGeofencesResultListener onAddGeofencesResultListener) {
            if (onAddGeofencesResultListener == null) return;
            onAddGeofencesResultListener.onAddGeofencesResult(this.ka, this.tV);
        }

        @Override
        protected void aQ() {
        }

        @Override
        protected /* synthetic */ void b(Object object) {
            this.a((LocationClient.OnAddGeofencesResultListener)object);
        }
    }

    private static final class b
    extends fj.a {
        private LocationClient.OnAddGeofencesResultListener tX;
        private LocationClient.OnRemoveGeofencesResultListener tY;
        private fm tZ;

        public b(LocationClient.OnAddGeofencesResultListener onAddGeofencesResultListener, fm fm2) {
            this.tX = onAddGeofencesResultListener;
            this.tY = null;
            this.tZ = fm2;
        }

        public b(LocationClient.OnRemoveGeofencesResultListener onRemoveGeofencesResultListener, fm fm2) {
            this.tY = onRemoveGeofencesResultListener;
            this.tX = null;
            this.tZ = fm2;
        }

        @Override
        public void onAddGeofencesResult(int n2, String[] stringArray) throws RemoteException {
            if (this.tZ == null) {
                Log.wtf((String)"LocationClientImpl", (String)"onAddGeofenceResult called multiple times");
                return;
            }
            fm fm2 = this.tZ;
            fm fm3 = this.tZ;
            fm3.getClass();
            fm2.a(fm3.new a(this.tX, n2, stringArray));
            this.tZ = null;
            this.tX = null;
            this.tY = null;
        }

        @Override
        public void onRemoveGeofencesByPendingIntentResult(int n2, PendingIntent pendingIntent) {
            if (this.tZ == null) {
                Log.wtf((String)"LocationClientImpl", (String)"onRemoveGeofencesByPendingIntentResult called multiple times");
                return;
            }
            fm fm2 = this.tZ;
            fm fm3 = this.tZ;
            fm3.getClass();
            fm2.a(new d(fm3, 1, this.tY, n2, pendingIntent));
            this.tZ = null;
            this.tX = null;
            this.tY = null;
        }

        @Override
        public void onRemoveGeofencesByRequestIdsResult(int n2, String[] stringArray) {
            if (this.tZ == null) {
                Log.wtf((String)"LocationClientImpl", (String)"onRemoveGeofencesByRequestIdsResult called multiple times");
                return;
            }
            fm fm2 = this.tZ;
            fm fm3 = this.tZ;
            fm3.getClass();
            fm2.a(new d(fm3, 2, this.tY, n2, stringArray));
            this.tZ = null;
            this.tX = null;
            this.tY = null;
        }
    }

    private final class c
    implements fp<fk> {
        private c() {
        }

        @Override
        public void bB() {
            fm.this.bB();
        }

        @Override
        public /* synthetic */ IInterface bC() {
            return this.dr();
        }

        public fk dr() {
            return (fk)fm.this.bC();
        }
    }

    private final class d
    extends dk.b<LocationClient.OnRemoveGeofencesResultListener> {
        private final int ka;
        private final PendingIntent mPendingIntent;
        private final String[] tV;
        final /* synthetic */ fm tW;
        private final int ua;

        public d(fm fm2, int n2, LocationClient.OnRemoveGeofencesResultListener onRemoveGeofencesResultListener, int n3, PendingIntent pendingIntent) {
            boolean bl2 = true;
            this.tW = fm2;
            super(onRemoveGeofencesResultListener);
            if (n2 != 1) {
                bl2 = false;
            }
            dg.n(bl2);
            this.ua = n2;
            this.ka = LocationStatusCodes.aD(n3);
            this.mPendingIntent = pendingIntent;
            this.tV = null;
        }

        public d(fm fm2, int n2, LocationClient.OnRemoveGeofencesResultListener onRemoveGeofencesResultListener, int n3, String[] stringArray) {
            this.tW = fm2;
            super(onRemoveGeofencesResultListener);
            boolean bl2 = n2 == 2;
            dg.n(bl2);
            this.ua = n2;
            this.ka = LocationStatusCodes.aD(n3);
            this.tV = stringArray;
            this.mPendingIntent = null;
        }

        protected void a(LocationClient.OnRemoveGeofencesResultListener onRemoveGeofencesResultListener) {
            if (onRemoveGeofencesResultListener == null) return;
            switch (this.ua) {
                default: {
                    Log.wtf((String)"LocationClientImpl", (String)("Unsupported action: " + this.ua));
                    return;
                }
                case 1: {
                    onRemoveGeofencesResultListener.onRemoveGeofencesByPendingIntentResult(this.ka, this.mPendingIntent);
                    return;
                }
                case 2: 
            }
            onRemoveGeofencesResultListener.onRemoveGeofencesByRequestIdsResult(this.ka, this.tV);
        }

        @Override
        protected void aQ() {
        }

        @Override
        protected /* synthetic */ void b(Object object) {
            this.a((LocationClient.OnRemoveGeofencesResultListener)object);
        }
    }
}

