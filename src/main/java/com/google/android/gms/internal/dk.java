/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.ServiceConnection
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Looper
 *  android.os.Message
 *  android.os.RemoteException
 *  android.util.Log
 */
package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.dl;
import com.google.android.gms.internal.dm;
import com.google.android.gms.internal.dp;
import com.google.android.gms.internal.dq;
import com.google.android.gms.internal.du;
import java.util.ArrayList;

public abstract class dk<T extends IInterface>
implements GooglePlayServicesClient,
Api.a,
dl.b {
    public static final String[] mG = new String[]{"service_esmobile", "service_googleme"};
    private final String[] jC;
    private final dl kB;
    private T mA;
    private final ArrayList<b<?>> mB = new ArrayList();
    private e mC;
    private final Context mContext;
    boolean mD = false;
    boolean mE = false;
    private final Object mF = new Object();
    final Handler mHandler;

    protected dk(Context context, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener, String ... stringArray) {
        this.mContext = du.f(context);
        this.kB = new dl(context, this, null);
        this.mHandler = new a(context.getMainLooper());
        this.a(stringArray);
        this.jC = stringArray;
        this.registerConnectionCallbacks(du.f(connectionCallbacks));
        this.registerConnectionFailedListener(du.f(onConnectionFailedListener));
    }

    static /* synthetic */ IInterface a(dk dk2, IInterface iInterface) {
        dk2.mA = iInterface;
        return iInterface;
    }

    static /* synthetic */ e a(dk dk2, e e2) {
        dk2.mC = e2;
        return e2;
    }

    protected void a(int n2, IBinder iBinder, Bundle bundle) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, (Object)new f(n2, iBinder, bundle)));
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void a(b<?> b2) {
        ArrayList<b<?>> arrayList = this.mB;
        synchronized (arrayList) {
            this.mB.add(b2);
        }
        this.mHandler.sendMessage(this.mHandler.obtainMessage(2, b2));
    }

    protected abstract void a(dq var1, d var2) throws RemoteException;

    protected void a(String ... stringArray) {
    }

    protected abstract String am();

    protected abstract String an();

    public final String[] bA() {
        return this.jC;
    }

    protected final void bB() {
        if (this.isConnected()) return;
        throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
    }

    protected final T bC() {
        this.bB();
        return this.mA;
    }

    @Override
    public boolean bb() {
        return this.mD;
    }

    @Override
    public Bundle bc() {
        return null;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    @Override
    public void connect() {
        this.mD = true;
        Object object = this.mF;
        synchronized (object) {
            this.mE = true;
        }
        int n2 = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.mContext);
        if (n2 != 0) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(3, (Object)n2));
            return;
        }
        if (this.mC != null) {
            Log.e((String)"GmsClient", (String)"Calling connect() while still connected, missing disconnect().");
            this.mA = null;
            dm.s(this.mContext).b(this.am(), this.mC);
        }
        this.mC = new e();
        if (dm.s(this.mContext).a(this.am(), this.mC)) return;
        Log.e((String)"GmsClient", (String)("unable to connect to service: " + this.am()));
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3, (Object)9));
    }

    /*
     * Enabled unnecessary exception pruning
     */
    @Override
    public void disconnect() {
        this.mD = false;
        ArrayList<b<?>> arrayList = this.mF;
        synchronized (arrayList) {
            this.mE = false;
        }
        arrayList = this.mB;
        synchronized (arrayList) {
            int n2 = this.mB.size();
            int n3 = 0;
            while (true) {
                if (n3 >= n2) {
                    this.mB.clear();
                    // MONITOREXIT @DISABLED, blocks:[6, 7, 8] lbl13 : MonitorExitStatement: MONITOREXIT : var3_1
                    this.mA = null;
                    if (this.mC == null) return;
                    dm.s(this.mContext).b(this.am(), this.mC);
                    this.mC = null;
                    return;
                }
                this.mB.get(n3).bE();
                ++n3;
            }
        }
    }

    public final Context getContext() {
        return this.mContext;
    }

    @Override
    public boolean isConnected() {
        if (this.mA == null) return false;
        return true;
    }

    @Override
    public boolean isConnecting() {
        Object object = this.mF;
        synchronized (object) {
            return this.mE;
        }
    }

    @Override
    public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks) {
        return this.kB.isConnectionCallbacksRegistered(connectionCallbacks);
    }

    @Override
    public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
        return this.kB.isConnectionFailedListenerRegistered(onConnectionFailedListener);
    }

    protected abstract T p(IBinder var1);

    @Override
    public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks) {
        this.kB.registerConnectionCallbacks(connectionCallbacks);
    }

    public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.kB.registerConnectionCallbacks(connectionCallbacks);
    }

    @Override
    public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.kB.registerConnectionFailedListener(onConnectionFailedListener);
    }

    public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.kB.registerConnectionFailedListener(onConnectionFailedListener);
    }

    protected final void u(IBinder iBinder) {
        try {
            this.a(dq.a.w(iBinder), new d(this));
            return;
        }
        catch (RemoteException remoteException) {
            Log.w((String)"GmsClient", (String)"service died");
            return;
        }
    }

    @Override
    public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks) {
        this.kB.unregisterConnectionCallbacks(connectionCallbacks);
    }

    @Override
    public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.kB.unregisterConnectionFailedListener(onConnectionFailedListener);
    }

    final class a
    extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        /*
         * Enabled unnecessary exception pruning
         * Converted monitor instructions to comments
         */
        public void handleMessage(Message object) {
            if (((Message)object).what == 1 && !dk.this.isConnecting()) {
                object = (b)((Message)object).obj;
                ((b)object).aQ();
                ((b)object).unregister();
                return;
            }
            Object object2 = dk.this.mF;
            // MONITORENTER : object2
            dk.this.mE = false;
            // MONITOREXIT : object2
            if (((Message)object).what == 3) {
                dk.this.kB.a(new ConnectionResult((Integer)((Message)object).obj, null));
                return;
            }
            if (((Message)object).what == 2 && !dk.this.isConnected()) {
                object = (b)((Message)object).obj;
                ((b)object).aQ();
                ((b)object).unregister();
                return;
            }
            if (((Message)object).what != 2 && ((Message)object).what != 1) {
                Log.wtf((String)"GmsClient", (String)"Don't know how to handle this message.");
                return;
            }
            ((b)((Message)object).obj).bD();
        }
    }

    protected abstract class b<TListener> {
        private boolean mI;
        private TListener mListener;

        public b(TListener TListener) {
            this.mListener = TListener;
            this.mI = false;
        }

        protected abstract void aQ();

        protected abstract void b(TListener var1);

        /*
         * Enabled unnecessary exception pruning
         * Converted monitor instructions to comments
         */
        public void bD() {
            // MONITORENTER : this
            TListener TListener = this.mListener;
            if (this.mI) {
                Log.w((String)"GmsClient", (String)("Callback proxy " + this + " being reused. This is not safe."));
            }
            // MONITOREXIT : this
            if (TListener != null) {
                try {
                    this.b(TListener);
                }
                catch (RuntimeException runtimeException) {
                    this.aQ();
                    throw runtimeException;
                }
            } else {
                this.aQ();
            }
            // MONITORENTER : this
            this.mI = true;
            // MONITOREXIT : this
            this.unregister();
        }

        public void bE() {
            synchronized (this) {
                this.mListener = null;
                return;
            }
        }

        public void unregister() {
            this.bE();
            ArrayList arrayList = dk.this.mB;
            synchronized (arrayList) {
                dk.this.mB.remove(this);
                return;
            }
        }
    }

    public abstract class c<TListener>
    extends b<TListener> {
        private final DataHolder lb;

        public c(TListener TListener, DataHolder dataHolder) {
            super(TListener);
            this.lb = dataHolder;
        }

        protected abstract void a(TListener var1, DataHolder var2);

        @Override
        protected void aQ() {
            if (this.lb == null) return;
            this.lb.close();
        }

        @Override
        protected final void b(TListener TListener) {
            this.a(TListener, this.lb);
        }
    }

    public static final class d
    extends dp.a {
        private dk mJ;

        public d(dk dk2) {
            this.mJ = dk2;
        }

        @Override
        public void b(int n2, IBinder iBinder, Bundle bundle) {
            du.c("onPostInitComplete can be called only once per call to getServiceFromBroker", this.mJ);
            this.mJ.a(n2, iBinder, bundle);
            this.mJ = null;
        }
    }

    final class e
    implements ServiceConnection {
        e() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            dk.this.u(iBinder);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            dk.a(dk.this, null);
            dk.this.kB.bG();
        }
    }

    protected final class f
    extends b<Boolean> {
        public final Bundle mK;
        public final IBinder mL;
        public final int statusCode;

        public f(int n2, IBinder iBinder, Bundle bundle) {
            super(true);
            this.statusCode = n2;
            this.mL = iBinder;
            this.mK = bundle;
        }

        @Override
        protected void aQ() {
        }

        /*
         * Loose catch block
         */
        @Override
        protected void b(Boolean object) {
            if (object == null) {
                return;
            }
            switch (this.statusCode) {
                default: {
                    object = this.mK != null ? (PendingIntent)this.mK.getParcelable("pendingIntent") : null;
                }
                case 0: {
                    object = this.mL.getInterfaceDescriptor();
                    if (dk.this.an().equals(object)) {
                        dk.a(dk.this, dk.this.p(this.mL));
                        if (dk.this.mA != null) {
                            dk.this.kB.bF();
                            return;
                        }
                    }
                }
                catch (RemoteException remoteException) {
                    // empty catch block
                }
                dm.s(dk.this.mContext).b(dk.this.am(), dk.this.mC);
                dk.a(dk.this, null);
                dk.a(dk.this, null);
                dk.this.kB.a(new ConnectionResult(8, null));
                return;
                case 10: {
                    throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
                }
            }
            if (dk.this.mC != null) {
                dm.s(dk.this.mContext).b(dk.this.am(), dk.this.mC);
                dk.a(dk.this, null);
            }
            dk.a(dk.this, null);
            dk.this.kB.a(new ConnectionResult(this.statusCode, (PendingIntent)object));
        }
    }
}

