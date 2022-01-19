/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.RemoteException
 */
package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.internal.cd;
import com.google.android.gms.internal.dk;
import com.google.android.gms.internal.dq;

public class by
extends dk<cd> {
    private final int hn;

    public by(Context context, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener, int n2) {
        super(context, connectionCallbacks, onConnectionFailedListener, new String[0]);
        this.hn = n2;
    }

    @Override
    protected void a(dq dq2, dk.d d2) throws RemoteException {
        Bundle bundle = new Bundle();
        dq2.g(d2, this.hn, this.getContext().getPackageName(), bundle);
    }

    @Override
    protected String am() {
        return "com.google.android.gms.ads.service.START";
    }

    @Override
    protected String an() {
        return "com.google.android.gms.ads.internal.request.IAdRequestService";
    }

    public cd ao() {
        return (cd)super.bC();
    }

    protected cd o(IBinder iBinder) {
        return cd.a.q(iBinder);
    }

    @Override
    protected /* synthetic */ IInterface p(IBinder iBinder) {
        return this.o(iBinder);
    }
}

