/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Parcelable
 */
package com.google.android.c2dm;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;

public class C2DMessaging {
    public static final String BACKOFF = "backoff";
    private static final long DEFAULT_BACKOFF = 30000L;
    public static final String EXTRA_APPLICATION_PENDING_INTENT = "app";
    public static final String EXTRA_SENDER = "sender";
    public static final String GSF_PACKAGE = "com.google.android.gsf";
    public static final String LAST_REGISTRATION_CHANGE = "last_registration_change";
    static final String PREFERENCE = "com.google.android.c2dm";
    public static final String REQUEST_REGISTRATION_INTENT = "com.google.android.c2dm.intent.REGISTER";
    public static final String REQUEST_UNREGISTRATION_INTENT = "com.google.android.c2dm.intent.UNREGISTER";

    static void clearRegistrationId(Context context) {
        context = context.getSharedPreferences(PREFERENCE, 0).edit();
        context.putString("dm_registration", "");
        context.putLong(LAST_REGISTRATION_CHANGE, System.currentTimeMillis());
        context.commit();
    }

    static long getBackoff(Context context) {
        return context.getSharedPreferences(PREFERENCE, 0).getLong(BACKOFF, 30000L);
    }

    public static long getLastRegistrationChange(Context context) {
        return context.getSharedPreferences(PREFERENCE, 0).getLong(LAST_REGISTRATION_CHANGE, 0L);
    }

    public static String getRegistrationId(Context context) {
        return context.getSharedPreferences(PREFERENCE, 0).getString("dm_registration", "");
    }

    public static void register(Context context, String string) {
        Intent intent = new Intent(REQUEST_REGISTRATION_INTENT);
        intent.setPackage(GSF_PACKAGE);
        intent.putExtra(EXTRA_APPLICATION_PENDING_INTENT, (Parcelable)PendingIntent.getBroadcast((Context)context, (int)0, (Intent)new Intent(), (int)0));
        intent.putExtra(EXTRA_SENDER, string);
        context.startService(intent);
    }

    static void setBackoff(Context context, long l2) {
        context = context.getSharedPreferences(PREFERENCE, 0).edit();
        context.putLong(BACKOFF, l2);
        context.commit();
    }

    static void setRegistrationId(Context context, String string) {
        context = context.getSharedPreferences(PREFERENCE, 0).edit();
        context.putString("dm_registration", string);
        context.commit();
    }

    public static void unregister(Context context) {
        Intent intent = new Intent(REQUEST_UNREGISTRATION_INTENT);
        intent.setPackage(GSF_PACKAGE);
        intent.putExtra(EXTRA_APPLICATION_PENDING_INTENT, (Parcelable)PendingIntent.getBroadcast((Context)context, (int)0, (Intent)new Intent(), (int)0));
        context.startService(intent);
    }
}

