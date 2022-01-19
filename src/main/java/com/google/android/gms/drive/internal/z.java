/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 */
package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.drive.internal.a;

public class z
extends a {
    private final a.c<Status> jN;

    public z(a.c<Status> c2) {
        this.jN = c2;
    }

    @Override
    public void d(Status status) throws RemoteException {
        this.jN.a(status);
    }

    @Override
    public void onSuccess() throws RemoteException {
        this.jN.a(Status.kW);
    }
}

