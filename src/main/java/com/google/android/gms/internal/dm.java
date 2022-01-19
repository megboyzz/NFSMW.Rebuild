/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.IBinder
 *  android.os.Message
 */
package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.google.android.gms.internal.dk;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class dm
implements Handler.Callback {
    private static final Object mT = new Object();
    private static dm mU;
    private final Context iQ;
    private final Handler mHandler;
    private final HashMap<String, a> mV;

    private dm(Context context) {
        this.mHandler = new Handler(context.getMainLooper(), (Handler.Callback)this);
        this.mV = new HashMap();
        this.iQ = context.getApplicationContext();
    }

    public static dm s(Context context) {
        Object object = mT;
        synchronized (object) {
            if (mU != null) return mU;
            mU = new dm(context.getApplicationContext());
            return mU;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public boolean a(String object, dk.e e2) {
        HashMap<String, a> hashMap = this.mV;
        synchronized (hashMap) {
            a a2 = this.mV.get(object);
            if (a2 == null) {
                a2 = new a((String)object);
                a2.a(e2);
                e2 = new Intent((String)object).setPackage("com.google.android.gms");
                a2.o(this.iQ.bindService((Intent)e2, (ServiceConnection)a2.bH(), 129));
                this.mV.put((String)object, a2);
                object = a2;
                return ((a)object).isBound();
            } else {
                this.mHandler.removeMessages(0, (Object)a2);
                if (a2.c(e2)) {
                    throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  startServiceAction=" + (String)object);
                }
                a2.a(e2);
                switch (a2.getState()) {
                    case 1: {
                        e2.onServiceConnected(a2.getComponentName(), a2.getBinder());
                        object = a2;
                        return ((a)object).isBound();
                    }
                    case 2: {
                        object = new Intent((String)object).setPackage("com.google.android.gms");
                        a2.o(this.iQ.bindService((Intent)object, (ServiceConnection)a2.bH(), 129));
                        object = a2;
                        return ((a)object).isBound();
                    }
                    default: {
                        object = a2;
                    }
                }
            }
            return ((a)object).isBound();
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void b(String string2, dk.e e2) {
        HashMap<String, a> hashMap = this.mV;
        synchronized (hashMap) {
            a a2 = this.mV.get(string2);
            if (a2 == null) {
                throw new IllegalStateException("Nonexistent connection status for service action: " + string2);
            }
            if (!a2.c(e2)) {
                throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  startServiceAction=" + string2);
            }
            a2.b(e2);
            if (!a2.bJ()) return;
            string2 = this.mHandler.obtainMessage(0, (Object)a2);
            this.mHandler.sendMessageDelayed((Message)string2, 5000L);
            return;
        }
    }

    public boolean handleMessage(Message object) {
        switch (object.what) {
            default: {
                return false;
            }
            case 0: 
        }
        a a2 = (a)object.obj;
        object = this.mV;
        synchronized (object) {
            if (!a2.bJ()) return true;
            this.iQ.unbindService((ServiceConnection)a2.bH());
            this.mV.remove(a2.bI());
            return true;
        }
    }

    final class com.google.android.gms.internal.dm$a {
        private int mState;
        private final String mW;
        private final a mX;
        private final HashSet<dk.e> mY;
        private boolean mZ;
        private IBinder na;
        private ComponentName nb;

        public com.google.android.gms.internal.dm$a(String string2) {
            this.mW = string2;
            this.mX = new a();
            this.mY = new HashSet();
            this.mState = 0;
        }

        static /* synthetic */ int a(com.google.android.gms.internal.dm$a a2, int n2) {
            a2.mState = n2;
            return n2;
        }

        static /* synthetic */ ComponentName a(com.google.android.gms.internal.dm$a a2, ComponentName componentName) {
            a2.nb = componentName;
            return componentName;
        }

        static /* synthetic */ IBinder a(com.google.android.gms.internal.dm$a a2, IBinder iBinder) {
            a2.na = iBinder;
            return iBinder;
        }

        public void a(dk.e e2) {
            this.mY.add(e2);
        }

        public void b(dk.e e2) {
            this.mY.remove(e2);
        }

        public a bH() {
            return this.mX;
        }

        public String bI() {
            return this.mW;
        }

        public boolean bJ() {
            return this.mY.isEmpty();
        }

        public boolean c(dk.e e2) {
            return this.mY.contains(e2);
        }

        public IBinder getBinder() {
            return this.na;
        }

        public ComponentName getComponentName() {
            return this.nb;
        }

        public int getState() {
            return this.mState;
        }

        public boolean isBound() {
            return this.mZ;
        }

        public void o(boolean bl2) {
            this.mZ = bl2;
        }

        public class a
        implements ServiceConnection {
            /*
             * Enabled unnecessary exception pruning
             */
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                HashMap hashMap = dm.this.mV;
                synchronized (hashMap) {
                    com.google.android.gms.internal.dm$a.a(a.this, iBinder);
                    com.google.android.gms.internal.dm$a.a(a.this, componentName);
                    Iterator iterator = a.this.mY.iterator();
                    while (true) {
                        if (!iterator.hasNext()) {
                            com.google.android.gms.internal.dm$a.a(a.this, 1);
                            return;
                        }
                        ((dk.e)iterator.next()).onServiceConnected(componentName, iBinder);
                    }
                }
            }

            /*
             * Enabled unnecessary exception pruning
             */
            public void onServiceDisconnected(ComponentName componentName) {
                HashMap hashMap = dm.this.mV;
                synchronized (hashMap) {
                    com.google.android.gms.internal.dm$a.a(a.this, null);
                    com.google.android.gms.internal.dm$a.a(a.this, componentName);
                    Iterator iterator = a.this.mY.iterator();
                    while (true) {
                        if (!iterator.hasNext()) {
                            com.google.android.gms.internal.dm$a.a(a.this, 2);
                            return;
                        }
                        ((dk.e)iterator.next()).onServiceDisconnected(componentName);
                    }
                }
            }
        }
    }
}

