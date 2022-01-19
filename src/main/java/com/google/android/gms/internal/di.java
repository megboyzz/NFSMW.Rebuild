/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ActivityNotFoundException
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.util.Log
 */
package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;

public class di
implements DialogInterface.OnClickListener {
    private final Activity gr;
    private final Intent mIntent;
    private final int mv;

    public di(Activity activity, Intent intent, int n2) {
        this.gr = activity;
        this.mIntent = intent;
        this.mv = n2;
    }

    public void onClick(DialogInterface dialogInterface, int n2) {
        try {
            if (this.mIntent != null) {
                this.gr.startActivityForResult(this.mIntent, this.mv);
            }
            dialogInterface.dismiss();
            return;
        }
        catch (ActivityNotFoundException activityNotFoundException) {
            Log.e((String)"SettingsRedirect", (String)"Can't redirect to app settings for Google Play services");
            return;
        }
    }
}

