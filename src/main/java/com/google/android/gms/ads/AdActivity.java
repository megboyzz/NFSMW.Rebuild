/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.Bundle
 *  android.os.RemoteException
 */
package com.google.android.gms.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.br;
import com.google.android.gms.internal.bs;
import com.google.android.gms.internal.cs;

public final class AdActivity
extends Activity {
    public static final String CLASS_NAME = "com.google.android.gms.ads.AdActivity";
    public static final String SIMPLE_CLASS_NAME = "AdActivity";
    private bs dV;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dV = br.a(this);
        if (this.dV == null) {
            cs.v("Could not create ad overlay.");
            this.finish();
            return;
        }
        try {
            this.dV.onCreate(bundle);
            return;
        }
        catch (RemoteException remoteException) {
            cs.b("Could not forward onCreate to ad overlay:", remoteException);
            this.finish();
            return;
        }
    }

    protected void onDestroy() {
        try {
            if (this.dV != null) {
                this.dV.onDestroy();
            }
        }
        catch (RemoteException remoteException) {
            cs.b("Could not forward onDestroy to ad overlay:", remoteException);
        }
        super.onDestroy();
    }

    protected void onPause() {
        try {
            if (this.dV != null) {
                this.dV.onPause();
            }
        }
        catch (RemoteException remoteException) {
            cs.b("Could not forward onPause to ad overlay:", remoteException);
            this.finish();
        }
        super.onPause();
    }

    protected void onRestart() {
        super.onRestart();
        try {
            if (this.dV == null) return;
            this.dV.onRestart();
            return;
        }
        catch (RemoteException remoteException) {
            cs.b("Could not forward onRestart to ad overlay:", remoteException);
            this.finish();
            return;
        }
    }

    protected void onResume() {
        super.onResume();
        try {
            if (this.dV == null) return;
            this.dV.onResume();
            return;
        }
        catch (RemoteException remoteException) {
            cs.b("Could not forward onResume to ad overlay:", remoteException);
            this.finish();
            return;
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        try {
            if (this.dV != null) {
                this.dV.onSaveInstanceState(bundle);
            }
        }
        catch (RemoteException remoteException) {
            cs.b("Could not forward onSaveInstanceState to ad overlay:", remoteException);
            this.finish();
        }
        super.onSaveInstanceState(bundle);
    }

    protected void onStart() {
        super.onStart();
        try {
            if (this.dV == null) return;
            this.dV.onStart();
            return;
        }
        catch (RemoteException remoteException) {
            cs.b("Could not forward onStart to ad overlay:", remoteException);
            this.finish();
            return;
        }
    }

    protected void onStop() {
        try {
            if (this.dV != null) {
                this.dV.onStop();
            }
        }
        catch (RemoteException remoteException) {
            cs.b("Could not forward onStop to ad overlay:", remoteException);
            this.finish();
        }
        super.onStop();
    }
}

