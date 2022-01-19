/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  android.os.Messenger
 *  android.os.Parcelable
 */
package com.google.android.gms.gcm;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class GoogleCloudMessaging {
    public static final String ERROR_MAIN_THREAD = "MAIN_THREAD";
    public static final String ERROR_SERVICE_NOT_AVAILABLE = "SERVICE_NOT_AVAILABLE";
    public static final String MESSAGE_TYPE_DELETED = "deleted_messages";
    public static final String MESSAGE_TYPE_MESSAGE = "gcm";
    public static final String MESSAGE_TYPE_SEND_ERROR = "send_error";
    static GoogleCloudMessaging tm;
    private Context eh;
    private PendingIntent tn;
    final BlockingQueue<Intent> to = new LinkedBlockingQueue<Intent>();
    private Handler tp = new Handler(Looper.getMainLooper()){

        public void handleMessage(Message message) {
            message = (Intent)message.obj;
            GoogleCloudMessaging.this.to.add((Intent)message);
        }
    };
    private Messenger tq = new Messenger(this.tp);

    private void b(String ... object) {
        object = this.c((String)object);
        Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
        intent.setPackage("com.google.android.gms");
        intent.putExtra("google.messenger", (Parcelable)this.tq);
        this.d(intent);
        intent.putExtra("sender", (String)object);
        this.eh.startService(intent);
    }

    private void dn() {
        Intent intent = new Intent("com.google.android.c2dm.intent.UNREGISTER");
        intent.setPackage("com.google.android.gms");
        this.to.clear();
        intent.putExtra("google.messenger", (Parcelable)this.tq);
        this.d(intent);
        this.eh.startService(intent);
    }

    public static GoogleCloudMessaging getInstance(Context object) {
        synchronized (GoogleCloudMessaging.class) {
            if (tm == null) {
                tm = new GoogleCloudMessaging();
                GoogleCloudMessaging.tm.eh = object;
            }
            object = tm;
            return object;
        }
    }

    String c(String ... stringArray) {
        if (stringArray == null) throw new IllegalArgumentException("No senderIds");
        if (stringArray.length == 0) {
            throw new IllegalArgumentException("No senderIds");
        }
        StringBuilder stringBuilder = new StringBuilder(stringArray[0]);
        int n2 = 1;
        while (n2 < stringArray.length) {
            stringBuilder.append(',').append(stringArray[n2]);
            ++n2;
        }
        return stringBuilder.toString();
    }

    public void close() {
        this.do();
    }

    void d(Intent intent) {
        synchronized (this) {
            if (this.tn == null) {
                this.tn = PendingIntent.getBroadcast((Context)this.eh, (int)0, (Intent)new Intent(), (int)0);
            }
            intent.putExtra("app", (Parcelable)this.tn);
            return;
        }
    }

    void do() {
        synchronized (this) {
            if (this.tn == null) return;
            this.tn.cancel();
            this.tn = null;
            return;
        }
    }

    public String getMessageType(Intent object) {
        if (!"com.google.android.c2dm.intent.RECEIVE".equals(object.getAction())) {
            return null;
        }
        String string2 = object.getStringExtra("message_type");
        object = string2;
        if (string2 != null) return object;
        return MESSAGE_TYPE_MESSAGE;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled unnecessary exception pruning
     */
    public String register(String ... object) throws IOException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException(ERROR_MAIN_THREAD);
        }
        this.to.clear();
        this.b((String[])object);
        try {
            object = this.to.poll(5000L, TimeUnit.MILLISECONDS);
            if (object == null) {
                throw new IOException(ERROR_SERVICE_NOT_AVAILABLE);
            }
        }
        catch (InterruptedException interruptedException) {
            throw new IOException(interruptedException.getMessage());
        }
        {
            String string2 = object.getStringExtra("registration_id");
            if (string2 != null) {
                return string2;
            }
            object.getStringExtra("error");
            object = object.getStringExtra("error");
            if (object == null) throw new IOException(ERROR_SERVICE_NOT_AVAILABLE);
            throw new IOException((String)object);
        }
    }

    public void send(String string2, String string3, long l2, Bundle bundle) throws IOException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException(ERROR_MAIN_THREAD);
        }
        if (string2 == null) {
            throw new IllegalArgumentException("Missing 'to'");
        }
        Intent intent = new Intent("com.google.android.gcm.intent.SEND");
        intent.putExtras(bundle);
        this.d(intent);
        intent.putExtra("google.to", string2);
        intent.putExtra("google.message_id", string3);
        intent.putExtra("google.ttl", Long.toString(l2));
        this.eh.sendOrderedBroadcast(intent, null);
    }

    public void send(String string2, String string3, Bundle bundle) throws IOException {
        this.send(string2, string3, -1L, bundle);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled unnecessary exception pruning
     */
    public void unregister() throws IOException {
        Object object;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException(ERROR_MAIN_THREAD);
        }
        this.dn();
        try {
            object = this.to.poll(5000L, TimeUnit.MILLISECONDS);
            if (object == null) {
                throw new IOException(ERROR_SERVICE_NOT_AVAILABLE);
            }
        }
        catch (InterruptedException interruptedException) {
            throw new IOException(interruptedException.getMessage());
        }
        {
            if (object.getStringExtra("unregistered") != null) {
                return;
            }
            if ((object = object.getStringExtra("error")) == null) throw new IOException(ERROR_SERVICE_NOT_AVAILABLE);
            throw new IOException((String)object);
        }
    }
}

