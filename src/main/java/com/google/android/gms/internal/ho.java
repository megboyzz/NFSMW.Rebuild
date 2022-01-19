/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 *  android.app.Activity
 *  android.app.PendingIntent
 *  android.app.PendingIntent$CanceledException
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentSender$SendIntentException
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcelable
 *  android.os.RemoteException
 *  android.text.TextUtils
 *  android.util.Log
 */
package com.google.android.gms.internal;

import android.accounts.Account;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.internal.dk;
import com.google.android.gms.internal.dq;
import com.google.android.gms.internal.hm;
import com.google.android.gms.internal.hn;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;

public class ho
extends dk<hm> {
    private final int CE;
    private final Activity gr;
    private final String jD;
    private final int mTheme;

    public ho(Activity activity, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener, int n2, String string2, int n3) {
        super((Context)activity, connectionCallbacks, onConnectionFailedListener, new String[0]);
        this.gr = activity;
        this.CE = n2;
        this.jD = string2;
        this.mTheme = n3;
    }

    private Bundle fy() {
        Bundle bundle = new Bundle();
        bundle.putInt("com.google.android.gms.wallet.EXTRA_ENVIRONMENT", this.CE);
        bundle.putString("androidPackageName", this.gr.getPackageName());
        if (!TextUtils.isEmpty((CharSequence)this.jD)) {
            bundle.putParcelable("com.google.android.gms.wallet.EXTRA_BUYER_ACCOUNT", (Parcelable)new Account(this.jD, "com.google"));
        }
        bundle.putInt("com.google.android.gms.wallet.EXTRA_THEME", this.mTheme);
        return bundle;
    }

    @Override
    protected void a(dq dq2, dk.d d2) throws RemoteException {
        dq2.a(d2, 4132500);
    }

    @Override
    protected String am() {
        return "com.google.android.gms.wallet.service.BIND";
    }

    @Override
    protected String an() {
        return "com.google.android.gms.wallet.internal.IOwService";
    }

    protected hm ay(IBinder iBinder) {
        return hm.a.aw(iBinder);
    }

    public void changeMaskedWallet(String string2, String string3, int n2) {
        Bundle bundle = this.fy();
        a a2 = new a(n2);
        try {
            ((hm)this.bC()).a(string2, string3, bundle, a2);
            return;
        }
        catch (RemoteException remoteException) {
            Log.e((String)"WalletClientImpl", (String)"RemoteException changing masked wallet", (Throwable)remoteException);
            a2.a(8, (MaskedWallet)null, (Bundle)null);
            return;
        }
    }

    public void checkForPreAuthorization(int n2) {
        Bundle bundle = this.fy();
        a a2 = new a(n2);
        try {
            ((hm)this.bC()).a(bundle, a2);
            return;
        }
        catch (RemoteException remoteException) {
            Log.e((String)"WalletClientImpl", (String)"RemoteException during checkForPreAuthorization", (Throwable)remoteException);
            a2.a(8, false, null);
            return;
        }
    }

    public void loadFullWallet(FullWalletRequest fullWalletRequest, int n2) {
        a a2 = new a(n2);
        Bundle bundle = this.fy();
        try {
            ((hm)this.bC()).a(fullWalletRequest, bundle, (hn)a2);
            return;
        }
        catch (RemoteException remoteException) {
            Log.e((String)"WalletClientImpl", (String)"RemoteException getting full wallet", (Throwable)remoteException);
            a2.a(8, (FullWallet)null, (Bundle)null);
            return;
        }
    }

    public void loadMaskedWallet(MaskedWalletRequest maskedWalletRequest, int n2) {
        Bundle bundle = this.fy();
        a a2 = new a(n2);
        try {
            ((hm)this.bC()).a(maskedWalletRequest, bundle, (hn)a2);
            return;
        }
        catch (RemoteException remoteException) {
            Log.e((String)"WalletClientImpl", (String)"RemoteException getting masked wallet", (Throwable)remoteException);
            a2.a(8, (MaskedWallet)null, (Bundle)null);
            return;
        }
    }

    public void notifyTransactionStatus(NotifyTransactionStatusRequest notifyTransactionStatusRequest) {
        Bundle bundle = this.fy();
        try {
            ((hm)this.bC()).a(notifyTransactionStatusRequest, bundle);
            return;
        }
        catch (RemoteException remoteException) {
            return;
        }
    }

    @Override
    protected /* synthetic */ IInterface p(IBinder iBinder) {
        return this.ay(iBinder);
    }

    final class a
    extends hn.a {
        private final int mv;

        public a(int n2) {
            this.mv = n2;
        }

        @Override
        public void a(int n2, FullWallet object, Bundle object2) {
            int n3;
            PendingIntent pendingIntent = null;
            if (object2 != null) {
                pendingIntent = (PendingIntent)object2.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
            }
            if (((ConnectionResult)(object2 = new ConnectionResult(n2, pendingIntent))).hasResolution()) {
                try {
                    ((ConnectionResult)object2).startResolutionForResult(ho.this.gr, this.mv);
                    return;
                }
                catch (IntentSender.SendIntentException sendIntentException) {
                    Log.w((String)"WalletClientImpl", (String)"Exception starting pending intent", (Throwable)sendIntentException);
                    return;
                }
            }
            if (((ConnectionResult)object2).isSuccess()) {
                n3 = -1;
                object2 = new Intent();
                object2.putExtra("com.google.android.gms.wallet.EXTRA_FULL_WALLET", (Parcelable)object);
                object = object2;
            } else {
                n3 = n2 == 408 ? 0 : 1;
                object = new Intent();
                object.putExtra("com.google.android.gms.wallet.EXTRA_ERROR_CODE", n2);
            }
            try {
                ho.this.gr.createPendingResult(this.mv, (Intent)object, 0x40000000).send(n3);
                return;
            }
            catch (PendingIntent.CanceledException canceledException) {
                Log.w((String)"WalletClientImpl", (String)"Exception setting pending result", (Throwable)canceledException);
                return;
            }
        }

        @Override
        public void a(int n2, MaskedWallet object, Bundle object2) {
            int n3;
            PendingIntent pendingIntent = null;
            if (object2 != null) {
                pendingIntent = (PendingIntent)object2.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
            }
            if (((ConnectionResult)(object2 = new ConnectionResult(n2, pendingIntent))).hasResolution()) {
                try {
                    ((ConnectionResult)object2).startResolutionForResult(ho.this.gr, this.mv);
                    return;
                }
                catch (IntentSender.SendIntentException sendIntentException) {
                    Log.w((String)"WalletClientImpl", (String)"Exception starting pending intent", (Throwable)sendIntentException);
                    return;
                }
            }
            if (((ConnectionResult)object2).isSuccess()) {
                n3 = -1;
                object2 = new Intent();
                object2.putExtra("com.google.android.gms.wallet.EXTRA_MASKED_WALLET", (Parcelable)object);
                object = object2;
            } else {
                n3 = n2 == 408 ? 0 : 1;
                object = new Intent();
                object.putExtra("com.google.android.gms.wallet.EXTRA_ERROR_CODE", n2);
            }
            try {
                ho.this.gr.createPendingResult(this.mv, (Intent)object, 0x40000000).send(n3);
                return;
            }
            catch (PendingIntent.CanceledException canceledException) {
                Log.w((String)"WalletClientImpl", (String)"Exception setting pending result", (Throwable)canceledException);
                return;
            }
        }

        @Override
        public void a(int n2, boolean bl2, Bundle bundle) {
            bundle = new Intent();
            bundle.putExtra("com.google.android.gm.wallet.EXTRA_IS_USER_PREAUTHORIZED", bl2);
            try {
                ho.this.gr.createPendingResult(this.mv, (Intent)bundle, 0x40000000).send(-1);
                return;
            }
            catch (PendingIntent.CanceledException canceledException) {
                Log.w((String)"WalletClientImpl", (String)"Exception setting pending result", (Throwable)canceledException);
                return;
            }
        }
    }
}

