/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.RemoteException
 *  android.util.Log
 */
package com.google.android.gms.drive.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.o;
import com.google.android.gms.internal.dh;
import com.google.android.gms.internal.dk;
import com.google.android.gms.internal.dq;
import com.google.android.gms.internal.du;

public class j
extends dk<o> {
    private final String jD;
    private DriveId ou;

    public j(Context context, dh dh2, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, String[] stringArray) {
        super(context, connectionCallbacks, onConnectionFailedListener, stringArray);
        this.jD = du.c(dh2.bt(), "Must call Api.ClientBuilder.setAccountName()");
    }

    @Override
    protected void a(int n2, IBinder iBinder, Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(this.getClass().getClassLoader());
            this.ou = (DriveId)bundle.getParcelable("com.google.android.gms.drive.root_id");
        }
        super.a(n2, iBinder, bundle);
    }

    @Override
    protected void a(dq dq2, dk.d d2) throws RemoteException {
        String string2 = this.getContext().getPackageName();
        du.f(d2);
        du.f(string2);
        du.f(this.bA());
        Log.d((String)"DriveClientImpl", (String)"Retrieving drive service");
        dq2.a(d2, 4132500, string2, this.bA(), this.jD, new Bundle());
    }

    @Override
    protected String am() {
        return "com.google.android.gms.drive.ApiService.START";
    }

    @Override
    protected String an() {
        return "com.google.android.gms.drive.internal.IDriveService";
    }

    public o cu() {
        return (o)this.bC();
    }

    public DriveId cv() {
        return this.ou;
    }

    @Override
    protected /* synthetic */ IInterface p(IBinder iBinder) {
        return this.z(iBinder);
    }

    protected o z(IBinder iBinder) {
        return o.a.A(iBinder);
    }
}

