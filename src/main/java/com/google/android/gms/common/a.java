/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.ServiceConnection
 *  android.os.IBinder
 */
package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class a
implements ServiceConnection {
    boolean jX = false;
    private final BlockingQueue<IBinder> jY = new LinkedBlockingQueue<IBinder>();

    public IBinder aS() throws InterruptedException {
        if (this.jX) {
            throw new IllegalStateException();
        }
        this.jX = true;
        return this.jY.take();
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            this.jY.put(iBinder);
            return;
        }
        catch (InterruptedException interruptedException) {
            return;
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}

