/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.RemoteException
 *  android.util.Log
 */
package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.a;
import com.google.android.gms.internal.du;
import com.google.android.gms.internal.p;
import java.io.IOException;

public final class AdvertisingIdClient {
    private static a g(Context context) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            throw new GooglePlayServicesNotAvailableException(9);
        }
        try {}
        catch (GooglePlayServicesNotAvailableException googlePlayServicesNotAvailableException) {
            throw new IOException(googlePlayServicesNotAvailableException);
        }
        GooglePlayServicesUtil.m(context);
        a a2 = new a();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (!context.bindService(intent, (ServiceConnection)a2, 1)) throw new IOException("Connection failure");
        return a2;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public static Info getAdvertisingIdInfo(Context context) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        du.C("Calling this from your main thread can lead to deadlock");
        a a2 = AdvertisingIdClient.g(context);
        try {
            Object object = p.a.b(a2.aS());
            object = new Info(object.getId(), object.a(true));
            return object;
        }
        catch (RemoteException remoteException) {
            Log.i((String)"AdvertisingIdClient", (String)"GMS remote exception ", (Throwable)remoteException);
            throw new IOException("Remote exception");
        }
        catch (InterruptedException interruptedException) {
            throw new IOException("Interrupted exception");
        }
        finally {
            context.unbindService((ServiceConnection)a2);
        }
    }

    public static final class Info {
        private final String eb;
        private final boolean ec;

        Info(String string, boolean bl2) {
            this.eb = string;
            this.ec = bl2;
        }

        public String getId() {
            return this.eb;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.ec;
        }
    }
}

