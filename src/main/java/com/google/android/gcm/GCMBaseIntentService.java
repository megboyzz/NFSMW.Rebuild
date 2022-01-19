/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.AlarmManager
 *  android.app.IntentService
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.Intent
 *  android.os.PowerManager
 *  android.os.PowerManager$WakeLock
 *  android.os.SystemClock
 *  android.util.Log
 */
package com.google.android.gcm;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gcm.GCMRegistrar;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public abstract class GCMBaseIntentService
extends IntentService {
    private static final String EXTRA_TOKEN = "token";
    private static final Object LOCK = GCMBaseIntentService.class;
    private static final int MAX_BACKOFF_MS;
    public static final String TAG = "GCMBaseIntentService";
    private static final String TOKEN;
    private static final String WAKELOCK_KEY = "GCM_LIB";
    private static int sCounter;
    private static final Random sRandom;
    private static PowerManager.WakeLock sWakeLock;
    private final String[] mSenderIds;

    static {
        sCounter = 0;
        sRandom = new Random();
        MAX_BACKOFF_MS = (int)TimeUnit.SECONDS.toMillis(3600L);
        TOKEN = Long.toBinaryString(sRandom.nextLong());
    }

    protected GCMBaseIntentService() {
        this(GCMBaseIntentService.getName("DynamicSenderIds"), (String[])null);
    }

    private GCMBaseIntentService(String string, String[] stringArray) {
        super(string);
        this.mSenderIds = stringArray;
    }

    protected GCMBaseIntentService(String ... stringArray) {
        this(GCMBaseIntentService.getName(stringArray), stringArray);
    }

    private static String getName(String charSequence) {
        int n2;
        charSequence = new StringBuilder().append("GCMIntentService-").append((String)charSequence).append("-");
        sCounter = n2 = sCounter + 1;
        charSequence = ((StringBuilder)charSequence).append(n2).toString();
        Log.v((String)TAG, (String)("Intent service name: " + (String)charSequence));
        return charSequence;
    }

    private static String getName(String[] stringArray) {
        return GCMBaseIntentService.getName(GCMRegistrar.getFlatSenderIds(stringArray));
    }

    private void handleRegistration(Context context, Intent object) {
        String string = object.getStringExtra("registration_id");
        String string2 = object.getStringExtra("error");
        object = object.getStringExtra("unregistered");
        Log.d((String)TAG, (String)("handleRegistration: registrationId = " + string + ", error = " + string2 + ", unregistered = " + (String)object));
        if (string != null) {
            GCMRegistrar.resetBackoff(context);
            GCMRegistrar.setRegistrationId(context, string);
            this.onRegistered(context, string);
            return;
        }
        if (object != null) {
            GCMRegistrar.resetBackoff(context);
            this.onUnregistered(context, GCMRegistrar.clearRegistrationId(context));
            return;
        }
        Log.d((String)TAG, (String)("Registration error: " + string2));
        if (!"SERVICE_NOT_AVAILABLE".equals(string2)) {
            this.onError(context, string2);
            return;
        }
        if (this.onRecoverableError(context, string2)) {
            int n2 = GCMRegistrar.getBackoff(context);
            int n3 = n2 / 2 + sRandom.nextInt(n2);
            Log.d((String)TAG, (String)("Scheduling registration retry, backoff = " + n3 + " (" + n2 + ")"));
            object = new Intent("com.google.android.gcm.intent.RETRY");
            object.putExtra(EXTRA_TOKEN, TOKEN);
            object = PendingIntent.getBroadcast((Context)context, (int)0, (Intent)object, (int)0);
            ((AlarmManager)context.getSystemService("alarm")).set(3, SystemClock.elapsedRealtime() + (long)n3, (PendingIntent)object);
            if (n2 >= MAX_BACKOFF_MS) return;
            GCMRegistrar.setBackoff(context, n2 * 2);
            return;
        }
        Log.d((String)TAG, (String)"Not retrying failed operation");
    }

    /*
     * Enabled unnecessary exception pruning
     */
    static void runIntentInService(Context context, Intent intent, String string) {
        Object object = LOCK;
        synchronized (object) {
            if (sWakeLock == null) {
                sWakeLock = ((PowerManager)context.getSystemService("power")).newWakeLock(1, WAKELOCK_KEY);
            }
        }
        Log.v((String)TAG, (String)"Acquiring wakelock");
        sWakeLock.acquire();
        intent.setClassName(context, string);
        context.startService(intent);
    }

    protected String[] getSenderIds(Context context) {
        if (this.mSenderIds != null) return this.mSenderIds;
        throw new IllegalStateException("sender id not set on constructor");
    }

    protected void onDeletedMessages(Context context, int n2) {
    }

    protected abstract void onError(Context var1, String var2);

    /*
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    public final void onHandleIntent(Intent object) {
        try {
            Context context = this.getApplicationContext();
            String string = object.getAction();
            if (string.equals("com.google.android.c2dm.intent.REGISTRATION")) {
                GCMRegistrar.setRetryBroadcastReceiver(context);
                this.handleRegistration(context, (Intent)object);
                return;
            }
            if (string.equals("com.google.android.c2dm.intent.RECEIVE")) {
                string = object.getStringExtra("message_type");
                if (string == null) {
                    this.onMessage(context, (Intent)object);
                    return;
                }
                if (!string.equals("deleted_messages")) {
                    Log.e((String)TAG, (String)("Received unknown special message: " + string));
                    return;
                }
                if ((object = object.getStringExtra("total_deleted")) == null) return;
                try {
                    int n2 = Integer.parseInt((String)object);
                    Log.v((String)TAG, (String)("Received deleted messages notification: " + n2));
                    this.onDeletedMessages(context, n2);
                    return;
                }
                catch (NumberFormatException numberFormatException) {
                    Log.e((String)TAG, (String)("GCM returned invalid number of deleted messages: " + (String)object));
                    return;
                }
            }
            if (!string.equals("com.google.android.gcm.intent.RETRY")) return;
            if (!TOKEN.equals(object = object.getStringExtra(EXTRA_TOKEN))) {
                Log.e((String)TAG, (String)("Received invalid token: " + (String)object));
                return;
            }
            if (GCMRegistrar.isRegistered(context)) {
                GCMRegistrar.internalUnregister(context);
                return;
            }
            GCMRegistrar.internalRegister(context, this.getSenderIds(context));
            return;
        }
        finally {
            object = LOCK;
        }
    }

    protected abstract void onMessage(Context var1, Intent var2);

    protected boolean onRecoverableError(Context context, String string) {
        return true;
    }

    protected abstract void onRegistered(Context var1, String var2);

    protected abstract void onUnregistered(Context var1, String var2);
}

