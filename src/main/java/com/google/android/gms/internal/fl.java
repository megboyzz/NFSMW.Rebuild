/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.ContentProviderClient
 *  android.content.Context
 *  android.location.Location
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  android.os.RemoteException
 *  android.util.Log
 */
package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.internal.du;
import com.google.android.gms.internal.fk;
import com.google.android.gms.internal.fp;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.a;
import java.util.HashMap;
import java.util.Iterator;

public class fl {
    private final Context mContext;
    private final fp<fk> tM;
    private ContentProviderClient tN = null;
    private boolean tO = false;
    private HashMap<LocationListener, b> tP = new HashMap();

    public fl(Context context, fp<fk> fp2) {
        this.mContext = context;
        this.tM = fp2;
    }

    public void dq() {
        if (!this.tO) return;
        this.setMockMode(false);
    }

    public Location getLastLocation() {
        this.tM.bB();
        try {
            return this.tM.bC().dp();
        }
        catch (RemoteException remoteException) {
            throw new IllegalStateException(remoteException);
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void removeAllListeners() {
        Iterator<b> iterator;
        try {
            HashMap<LocationListener, b> hashMap = this.tP;
            synchronized (hashMap) {
                iterator = this.tP.values().iterator();
            }
        }
        catch (RemoteException remoteException) {
            throw new IllegalStateException(remoteException);
        }
        {
            while (true) {
                if (!iterator.hasNext()) {
                    this.tP.clear();
                    return;
                }
                b b2 = iterator.next();
                if (b2 == null) continue;
                this.tM.bC().a(b2);
            }
        }
    }

    public void removeLocationUpdates(PendingIntent pendingIntent) {
        this.tM.bB();
        try {
            this.tM.bC().a(pendingIntent);
            return;
        }
        catch (RemoteException remoteException) {
            throw new IllegalStateException(remoteException);
        }
    }

    public void removeLocationUpdates(LocationListener object) {
        this.tM.bB();
        du.c(object, "Invalid null listener");
        HashMap<LocationListener, b> hashMap = this.tP;
        synchronized (hashMap) {
            object = this.tP.remove(object);
            if (this.tN != null && this.tP.isEmpty()) {
                this.tN.release();
                this.tN = null;
            }
            if (object == null) return;
            ((b)object).release();
            try {
                this.tM.bC().a((com.google.android.gms.location.a)object);
                return;
            }
            catch (RemoteException remoteException) {
                throw new IllegalStateException(remoteException);
            }
        }
    }

    public void requestLocationUpdates(LocationRequest locationRequest, PendingIntent pendingIntent) {
        this.tM.bB();
        try {
            this.tM.bC().a(locationRequest, pendingIntent);
            return;
        }
        catch (RemoteException remoteException) {
            throw new IllegalStateException(remoteException);
        }
    }

    public void requestLocationUpdates(LocationRequest locationRequest, LocationListener locationListener, Looper object) {
        this.tM.bB();
        if (object == null) {
            du.c(Looper.myLooper(), "Can't create handler inside thread that has not called Looper.prepare()");
        }
        HashMap<LocationListener, b> hashMap = this.tP;
        synchronized (hashMap) {
            b b2 = this.tP.get(locationListener);
            object = b2 == null ? new b(locationListener, (Looper)object) : b2;
            this.tP.put(locationListener, (b)object);
            try {
                this.tM.bC().a(locationRequest, (com.google.android.gms.location.a)object, this.mContext.getPackageName());
                return;
            }
            catch (RemoteException remoteException) {
                throw new IllegalStateException(remoteException);
            }
        }
    }

    public void setMockLocation(Location location) {
        this.tM.bB();
        try {
            this.tM.bC().setMockLocation(location);
            return;
        }
        catch (RemoteException remoteException) {
            throw new IllegalStateException(remoteException);
        }
    }

    public void setMockMode(boolean bl2) {
        this.tM.bB();
        try {
            this.tM.bC().setMockMode(bl2);
            this.tO = bl2;
            return;
        }
        catch (RemoteException remoteException) {
            throw new IllegalStateException(remoteException);
        }
    }

    private static class a
    extends Handler {
        private final LocationListener tQ;

        public a(LocationListener locationListener) {
            this.tQ = locationListener;
        }

        public a(LocationListener locationListener, Looper looper) {
            super(looper);
            this.tQ = locationListener;
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                default: {
                    Log.e((String)"LocationClientHelper", (String)"unknown message in LocationHandler.handleMessage");
                    return;
                }
                case 1: 
            }
            message = new Location((Location)message.obj);
            this.tQ.onLocationChanged((Location)message);
        }
    }

    private static class b
    extends a.a {
        private Handler tR;

        b(LocationListener object, Looper looper) {
            object = looper == null ? new a((LocationListener)object) : new a((LocationListener)object, looper);
            this.tR = object;
        }

        @Override
        public void onLocationChanged(Location location) {
            if (this.tR == null) {
                Log.e((String)"LocationClientHelper", (String)"Received a location in client after calling removeLocationUpdates.");
                return;
            }
            Message message = Message.obtain();
            message.what = 1;
            message.obj = location;
            this.tR.sendMessage(message);
        }

        public void release() {
            this.tR = null;
        }
    }
}

