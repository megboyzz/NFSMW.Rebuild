/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.AlertDialog$Builder
 *  android.app.Notification
 *  android.app.NotificationManager
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Bundle
 *  android.util.Log
 */
package com.ea.nimble.pushnotificationgoogle;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.ea.nimble.ApplicationEnvironment;
import com.ea.nimble.Base;
import com.ea.nimble.Log;
import com.ea.nimble.Persistence;
import com.ea.nimble.PersistenceService;
import com.ea.nimble.pushnotificationgoogle.IPushNotification;
import com.ea.nimble.pushnotificationgoogle.PushNotification;
import com.ea.nimble.tracking.ITracking;
import com.google.android.gcm.GCMBaseIntentService;
import com.google.android.gcm.GCMRegistrar;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class GCMIntentService
extends GCMBaseIntentService {
    public static final String GCMPersistentMessageID = "GCMMessageId";
    public static final String TAG = "GCMIntentService";

    public GCMIntentService() {
        super("927779459434");
    }

    protected static void generateNotification(Context context, String string2, String string3, String string4, Bundle bundle) {
        int n2;
        long l2 = System.currentTimeMillis();
        NotificationManager notificationManager = (NotificationManager)context.getSystemService("notification");
        String string5 = (String)context.getPackageManager().getApplicationLabel(context.getApplicationInfo());
        int n3 = n2 = context.getResources().getIdentifier("icon_pushnotification_custom", "drawable", context.getPackageName());
        if (n2 == 0) {
            n3 = context.getApplicationContext().getApplicationInfo().icon;
        }
        Context context2 = context.getApplicationContext();
        Intent intent = context2.getPackageManager().getLaunchIntentForPackage(context2.getPackageName());
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.putExtra("PushNotification", "true");
        if (string3 != null && string3.length() > 0) {
            intent.putExtra("messageId", string3);
        }
        intent.setFlags(0x24000000);
        string3 = PendingIntent.getActivity((Context)context, (int)0, (Intent)intent, (int)0x10000000);
        bundle = new Notification(n3, (CharSequence)string2, l2);
        if (string4 != null && string4.length() > 0) {
            if (context2.getResources().getIdentifier(string4, "raw", context2.getPackageName()) != 0) {
                bundle.sound = Uri.parse((String)("android.resource://" + context.getPackageName() + "/raw/" + string4));
            } else {
                Log.e((String)TAG, (String)("Attempt to play sound file " + string4 + " but the resource was not found"));
            }
        }
        bundle.setLatestEventInfo(context, (CharSequence)string5, (CharSequence)string2, (PendingIntent)string3);
        bundle.flags |= 0x10;
        notificationManager.notify(0, (Notification)bundle);
    }

    @Override
    protected void onDeletedMessages(Context context, int n2) {
        Log.i((String)TAG, (String)"Received deleted messages notification");
        GCMIntentService.generateNotification(context, "Message deleted", null, null, null);
    }

    @Override
    protected void onError(Context context, String string2) {
        Log.i((String)TAG, (String)("Received error: " + string2));
        if (!string2.equals("ACCOUNT_MISSING")) return;
        if (Base.getComponent("com.ea.nimble.pushnotificationgoogle") == null) return;
        ((IPushNotification)((Object)Base.getComponent("com.ea.nimble.pushnotificationgoogle"))).cleanup();
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @Override
    protected void onMessage(Context var1_1, Intent var2_2) {
        block11: {
            Log.v((String)"GCMIntentService", (String)"Real - onMessage start");
            var4_3 = "";
            var3_4 = "";
            var5_5 = "";
            var7_8 = var2_2 /* !! */ .getExtras();
            Log.v((String)"GCMIntentService", (String)("Real - message stuff: " + var7_8.toString()));
            var2_2 /* !! */  = ApplicationEnvironment.isMainApplicationRunning() != false ? ApplicationEnvironment.getComponent().getShortApplicationLanguageCode() : Locale.getDefault().getLanguage();
            var8_9 = "eamobile-message_" + (String)var2_2 /* !! */ ;
            var9_10 = var7_8.keySet().iterator();
            var2_2 /* !! */  = var5_5;
            block4: while (var9_10.hasNext()) {
                var10_12 = (String)var9_10.next();
                var5_5 = var4_3;
                if (var10_12.startsWith((String)var8_9)) {
                    var5_5 = URLDecoder.decode(var7_8.getString(var10_12), "UTF-8");
                }
lbl19:
                // 4 sources

                while (true) {
                    var6_11 = var3_4;
                    if (var10_12.startsWith("messageId")) {
                        Log.v((String)"GCMIntentService", (String)("message id is " + var7_8.getString("messageId")));
                        var6_11 = var7_8.getString("messageId");
                    }
                    var4_3 = var5_5;
                    var3_4 = var6_11;
                    if (!var10_12.startsWith("eamobile-song")) continue block4;
                    var2_2 /* !! */  = var7_8.getString("eamobile-song");
                    Log.v((String)"GCMIntentService", (String)("sound file to play is " + (String)var2_2 /* !! */ ));
                    var4_3 = var5_5;
                    var3_4 = var6_11;
                    continue block4;
                    break;
                }
            }
            if (var4_3.length() == 0) {
                Log.v((String)"GCMIntentService", (String)"*****Recieved PN but message payload did not match app selected language. Suppressing PN*****");
                return;
            }
            ** try [egrp 1[TRYBLOCK] [1 : 301->388)] { 
lbl39:
            // 1 sources

            break block11;
lbl40:
            // 1 sources

            catch (Exception var5_6) {
                Log.Helper.LOGD((Object)this, "GCM failed to save campaign ID to persistent. App was probably killed.", new Object[0]);
                var5_6.printStackTrace();
            }
lbl43:
            // 4 sources

            while (true) {
                this.processIncomingMessage(var1_1, (String)var4_3, (String)var3_4, (String)var2_2 /* !! */ , var7_8);
                return;
            }
            catch (Exception var5_7) {
                var5_5 = var4_3;
                ** continue;
            }
        }
        if (!ApplicationEnvironment.isMainApplicationRunning()) ** GOTO lbl43
        Log.v((String)"GCMIntentService", (String)"Attempting to save PN details to persistent cache. Assumption is that the application is running");
        if (var3_4 == null || var3_4.length() <= 0) ** GOTO lbl43
        var8_9 = PersistenceService.getPersistenceForNimbleComponent("GCMIntentService", Persistence.Storage.CACHE);
        var6_11 = (ArrayList)var8_9.getValue("GCMMessageId");
        var5_5 = var6_11;
        if (var6_11 == null) {
            var5_5 = new ArrayList<String>();
        }
        var5_5.add((String)var3_4);
        var8_9.setValue("GCMMessageId", var5_5);
        var8_9.synchronize();
        ** while (true)
    }

    @Override
    protected boolean onRecoverableError(Context context, String string2) {
        Log.i((String)TAG, (String)("Received recoverable error: " + string2));
        return super.onRecoverableError(context, string2);
    }

    @Override
    protected void onRegistered(Context context, String string2) {
        Log.i((String)TAG, (String)("Real - Device registered: regId = " + string2));
        PushNotification.register(context, string2);
    }

    @Override
    protected void onUnregistered(Context context, String string2) {
        Log.i((String)TAG, (String)"Device unregistered");
        if (GCMRegistrar.isRegisteredOnServer(context)) {
            PushNotification.unregister(context, string2);
            return;
        }
        Log.i((String)TAG, (String)"Ignoring unregister callback");
    }

    protected void processIncomingMessage(Context context, String string2, String string3, String string4, Bundle bundle) {
        if (ApplicationEnvironment.isMainApplicationRunning() && ApplicationEnvironment.getCurrentActivity() != null) {
            this.showMessage(string2, string3);
            return;
        }
        GCMIntentService.generateNotification(context, string2, string3, string4, bundle);
    }

    protected void showMessage(String string2, final String string3) {
        if (string2 == null) {
            return;
        }
        if (!ApplicationEnvironment.isMainApplicationRunning()) return;
        final AlertDialog.Builder builder = new AlertDialog.Builder((Context)ApplicationEnvironment.getCurrentActivity());
        builder.setTitle((CharSequence)"");
        builder.setMessage((CharSequence)string2);
        builder.setNegativeButton((CharSequence)"OK", new DialogInterface.OnClickListener(){

            public void onClick(DialogInterface dialogInterface, int n2) {
                ITracking iTracking;
                if (Base.getComponent("com.ea.nimble.tracking") != null && (iTracking = (ITracking)((Object)Base.getComponent("com.ea.nimble.tracking"))) != null) {
                    HashMap<String, String> hashMap = new HashMap<String, String>();
                    if (string3 != null) {
                        hashMap.put("NIMBLESTANDARD::KEY_PN_MESSAGE_ID", string3);
                    }
                    iTracking.logEvent("NIMBLESTANDARD::PN_USER_CLICKED_OK", hashMap);
                }
                dialogInterface.cancel();
            }
        });
        ApplicationEnvironment.getCurrentActivity().runOnUiThread(new Runnable(){

            @Override
            public void run() {
                builder.show();
            }
        });
    }
}

