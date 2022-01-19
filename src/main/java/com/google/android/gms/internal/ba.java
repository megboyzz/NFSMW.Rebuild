/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 */
package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.internal.bb;
import com.google.android.gms.internal.bc;
import com.google.android.gms.internal.be;
import com.google.android.gms.internal.cs;
import java.util.Map;

public final class ba
extends bb.a {
    private Map<Class<? extends NetworkExtras>, NetworkExtras> ge;

    private <NETWORK_EXTRAS extends com.google.ads.mediation.NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> bc m(String string2) throws RemoteException {
        try {
            MediationAdapter mediationAdapter = (MediationAdapter)Class.forName(string2).newInstance();
            return new be(mediationAdapter, (com.google.ads.mediation.NetworkExtras)this.ge.get(mediationAdapter.getAdditionalParametersType()));
        }
        catch (Throwable throwable) {
            cs.v("Could not instantiate mediation adapter: " + string2 + ". " + throwable.getMessage());
            throw new RemoteException();
        }
    }

    public void c(Map<Class<? extends NetworkExtras>, NetworkExtras> map) {
        this.ge = map;
    }

    @Override
    public bc l(String string2) throws RemoteException {
        return this.m(string2);
    }
}

