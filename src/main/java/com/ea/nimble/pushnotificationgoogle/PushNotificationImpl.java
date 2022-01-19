/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 */
package com.ea.nimble.pushnotificationgoogle;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.ea.nimble.ApplicationEnvironment;
import com.ea.nimble.Base;
import com.ea.nimble.Component;
import com.ea.nimble.Log;
import com.ea.nimble.LogSource;
import com.ea.nimble.Persistence;
import com.ea.nimble.PersistenceService;
import com.ea.nimble.SynergyEnvironment;
import com.ea.nimble.SynergyIdManager;
import com.ea.nimble.SynergyNetwork;
import com.ea.nimble.SynergyNetworkConnectionCallback;
import com.ea.nimble.SynergyNetworkConnectionHandle;
import com.ea.nimble.Utility;
import com.ea.nimble.identity.INimbleIdentity;
import com.ea.nimble.identity.INimbleIdentityAuthenticator;
import com.ea.nimble.pushnotificationgoogle.IPushNotification;
import com.ea.nimble.pushnotificationgoogle.PushNotification;
import com.ea.nimble.tracking.ITracking;
import com.google.android.gcm.GCMRegistrar;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class PushNotificationImpl
extends Component
implements LogSource,
IPushNotification {
    private BroadcastReceiver mAppLangChangedReceiver;
    private BroadcastReceiver m_IdentityChangedReceiver;
    private BroadcastReceiver m_handleMessageReceiver = new BroadcastReceiver(){

        public void onReceive(Context context, Intent intent) {
            Log.Helper.LOGV((Object)this, "got a message! someone loves me! wake up", new Object[0]);
        }
    };
    private BroadcastReceiver m_synergyIdChangedReceiver = new BroadcastReceiver(){

        public void onReceive(Context context, Intent intent) {
            PushNotificationImpl.this.onSynergyIdChanged(intent);
        }
    };

    public PushNotificationImpl() {
        this.mAppLangChangedReceiver = new BroadcastReceiver(){

            public void onReceive(Context context, Intent intent) {
                PushNotificationImpl.this.register();
            }
        };
        this.m_IdentityChangedReceiver = new BroadcastReceiver(){

            public void onReceive(Context object, Intent object2) {
                Log.Helper.LOGD((Object)this, "identity changed - PN system attempting to register", new Object[0]);
                if (object2 == null) return;
                if (object2.getExtras() == null) return;
                if (Base.getComponent("com.ea.nimble.identity") == null) {
                    Log.Helper.LOGD((Object)this, "identity changed - ID comp not found. Early out.", new Object[0]);
                    return;
                }
                object = object2.getExtras().getString("authenticatorId");
                object = ((INimbleIdentity)((Object)Base.getComponent("com.ea.nimble.identity"))).getAuthenticatorById((String)object);
                if (object == null || object.getPidInfo() == null) {
                    if (object == null) {
                        Log.Helper.LOGD((Object)this, "identity changed - authObj was null", new Object[0]);
                        return;
                    }
                    Log.Helper.LOGD((Object)this, "identity chagned - authObj.getPidInfo null", new Object[0]);
                    return;
                }
                object2 = object.getPidInfo().getPid();
                if (object.getState() == INimbleIdentityAuthenticator.NimbleIdentityAuthenticationState.NIMBLE_IDENTITY_AUTHENTICATION_SUCCESS) {
                    Log.Helper.LOGD((Object)this, "identity changed - PN system will store pid", new Object[0]);
                    PushNotification.callSynergyStorePushTokenByPid((String)object2);
                    return;
                }
                Log.Helper.LOGD((Object)this, "identity changed - PN system will revoke pid", new Object[0]);
                PushNotification.callSynergyRevokePushTokenByPid((String)object2);
            }
        };
    }

    private void checkNotNull(Object object, String string2) {
        if (object != null) return;
        throw new NullPointerException("Error: null ptr");
    }

    private void onSynergyIdChanged(Intent object) {
        String string2 = object.getStringExtra("previousSynergyId");
        if (!Utility.validString((String)(object = object.getStringExtra("currentSynergyId")))) return;
        if (PushNotification.s_registerId == null) return;
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("uid", (String)object);
        hashMap.put("registrationId", PushNotification.s_registerId);
        hashMap.put("language", Utility.safeString(ApplicationEnvironment.getComponent().getShortApplicationLanguageCode()));
        hashMap.put("localization", Utility.safeString(ApplicationEnvironment.getComponent().getApplicationLanguageCode()));
        hashMap.put("deviceLanguage", Utility.safeString(Locale.getDefault().getLanguage()));
        hashMap.put("deviceLocale", Utility.safeString(Locale.getDefault().toString()));
        hashMap.put("sellId", SynergyEnvironment.getComponent().getSellId());
        hashMap.put("network", "1");
        if (Utility.validString(string2)) {
            hashMap.put("revokeId", string2);
        }
        SynergyNetwork.getComponent().sendGetRequest(SynergyEnvironment.getComponent().getServerUrlWithKey("synergy.m2u"), "/m2u/api/android/storePushRegistrationId", hashMap, new SynergyNetworkConnectionCallback(){

            @Override
            public void callback(SynergyNetworkConnectionHandle synergyNetworkConnectionHandle) {
                if (synergyNetworkConnectionHandle.getResponse().getError() != null) {
                    Log.Helper.LOGD(this, "ERROR: unable to register token with synergy: " + synergyNetworkConnectionHandle.getResponse().getError(), new Object[0]);
                    return;
                }
                Log.Helper.LOGD(this, "PUSH NOTIFICATION TOKEN sent to synergy", new Object[0]);
            }
        });
    }

    @Override
    public void cleanup() {
        Context context = ApplicationEnvironment.getComponent().getApplicationContext();
        if (this.m_handleMessageReceiver != null) {
            context.unregisterReceiver(this.m_handleMessageReceiver);
        }
        GCMRegistrar.onDestroy(context);
        Utility.unregisterReceiver(this.m_synergyIdChangedReceiver);
        Utility.unregisterReceiver(this.m_IdentityChangedReceiver);
    }

    @Override
    public String getComponentId() {
        return "com.ea.nimble.pushnotificationgoogle";
    }

    @Override
    public String getLogSourceTitle() {
        return "PN";
    }

    @Override
    public void register() {
        this.trackStuff();
        this.checkNotNull("927779459434", "SENDER_ID");
        Log.Helper.LOGD(this, "Nimble PN Component is attempting to register this application for push notifications with the GCM service", new Object[0]);
        Object object = ApplicationEnvironment.getComponent().getApplicationContext();
        try {
            GCMRegistrar.checkDevice(object);
            GCMRegistrar.checkManifest(object);
        }
        catch (Exception exception) {
            Log.Helper.LOGD(this, "Nimble PN Component reports that GCMRegistrar checks have failed. PN service will not be available", new Object[0]);
            this.m_handleMessageReceiver = null;
            return;
        }
        Log.Helper.LOGD(this, "Nimble PN Component has passed GCMRegistrar checks and will now attempt to get a valid push token", new Object[0]);
        new IntentFilter("com.ea.nimble.pushnotificationgoogle.intent.RETRY").addCategory("com.ea.nimble.pushnotificationgoogle");
        object.registerReceiver(this.m_handleMessageReceiver, new IntentFilter("com.ea.nimble.pushnotificationgoogle.DISPLAY_MESSAGE"));
        final String string2 = GCMRegistrar.getRegistrationId(object);
        if (string2.equals("")) {
            Log.Helper.LOGV(this, "GCM - attempting to register with google", new Object[0]);
            GCMRegistrar.register(object, new String[]{"927779459434"});
            return;
        }
        Log.Helper.LOGV(this, "GCM - Already registered", new Object[0]);
        if (SynergyEnvironment.getComponent().getServerUrlWithKey("synergy.m2u") != null) {
            if (ApplicationEnvironment.getComponent() == null) return;
            if (!SynergyEnvironment.getComponent().isDataAvailable()) return;
            PushNotification.registerTokenWithSynergy(object, string2);
            return;
        }
        Log.Helper.LOGD(this, "GCM - Already registered but nimble does not have synergy URL so we can not store token yet... waiting...", new Object[0]);
        object = new BroadcastReceiver(){

            public void onReceive(Context context, Intent intent) {
                if ((intent = intent.getExtras()) == null) return;
                if (!intent.getString("result").equals("1")) return;
                Log.Helper.LOGD((Object)this, "GCM - received notification that environment is online. Sending token to synergy", new Object[0]);
                PushNotification.registerTokenWithSynergy(context, string2);
            }
        };
        Utility.registerReceiver("nimble.environment.notification.startup_requests_finished", (BroadcastReceiver)object);
        Utility.registerReceiver("nimble.environment.notification.restored_from_persistent", (BroadcastReceiver)object);
    }

    @Override
    public void restore() {
        Log.Helper.LOGD(this, "restore", new Object[0]);
        this.register();
        Utility.registerReceiver("nimble.synergyidmanager.notification.synergy_id_changed", this.m_synergyIdChangedReceiver);
        Utility.registerReceiver("nimble.notification.LanguageChanged", this.mAppLangChangedReceiver);
        Utility.registerReceiver("nimble.notification.identity.authenticator.pid.info.update", this.m_IdentityChangedReceiver);
    }

    @Override
    public void resume() {
        Log.Helper.LOGD(this, "resume", new Object[0]);
        this.register();
        Utility.registerReceiver("nimble.synergyidmanager.notification.synergy_id_changed", this.m_synergyIdChangedReceiver);
    }

    @Override
    public void sendPushNotificationTemplate(String string2, String string3, Map<String, String> arrayList, Map<String, String> object) {
        Object object2;
        Log.Helper.LOGI(this, "GCM- SYNERGY ", new Object[0]);
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        Object object3 = new ArrayList();
        if (!arrayList.isEmpty()) {
            for (Map.Entry object4 : arrayList.entrySet()) {
                object2 = new HashMap<String, String>();
                object2.put((String)object4.getKey(), (String)object4.getValue());
                ((ArrayList)object3).add(object2);
            }
        }
        hashMap.put("overrideValues", object3);
        arrayList = new ArrayList();
        if (!object.isEmpty()) {
            for (Map.Entry entry : object.entrySet()) {
                object3 = "custom_" + (String)entry.getKey();
                object2 = (String)entry.getValue();
                try {
                    String string4 = URLEncoder.encode((String)object3, "UTF-8").replaceAll("\\*", "%2A");
                    object2 = URLEncoder.encode((String)object2, "UTF-8").replaceAll("\\*", "%2A");
                    HashMap<String, Object> hashMap2 = new HashMap<String, Object>();
                    hashMap2.put("name", string4);
                    hashMap2.put("value", object2);
                    arrayList.add(hashMap2);
                }
                catch (UnsupportedEncodingException unsupportedEncodingException) {
                    Log.Helper.LOGD(this, "Error: PushNotificationTemplate can not parse the custom parameter fields for key" + (String)object3, new Object[0]);
                    unsupportedEncodingException.printStackTrace();
                }
            }
        }
        hashMap.put("customMessages", arrayList);
        hashMap.put("uid", Utility.safeString(SynergyIdManager.getComponent().getSynergyId()));
        hashMap.put("targetUserId", string2);
        hashMap.put("language", Utility.safeString(ApplicationEnvironment.getComponent().getShortApplicationLanguageCode()));
        hashMap.put("localization", Utility.safeString(ApplicationEnvironment.getComponent().getApplicationLanguageCode()));
        hashMap.put("deviceLanguage", Utility.safeString(Locale.getDefault().getLanguage()));
        hashMap.put("deviceLocale", Utility.safeString(Locale.getDefault().toString()));
        hashMap.put("sellId", Utility.safeString(SynergyEnvironment.getComponent().getSellId()));
        hashMap.put("clientApiVersion", "1.2.1");
        hashMap.put("templateCode", string3);
        hashMap.put("verificationCode", "");
        SynergyNetwork.getComponent().sendPostRequest(SynergyEnvironment.getComponent().getServerUrlWithKey("synergy.m2u"), "/m2u/api/android/sendPushNotificationTemplateByUid", null, hashMap, new SynergyNetworkConnectionCallback(){

            @Override
            public void callback(SynergyNetworkConnectionHandle synergyNetworkConnectionHandle) {
                if (synergyNetworkConnectionHandle.getResponse().getError() == null) {
                    Log.Helper.LOGD(this, "Push Notification sent to synergy. Status code: " + synergyNetworkConnectionHandle.getResponse().getHttpResponse().getStatusCode(), new Object[0]);
                    return;
                }
                Log.Helper.LOGD(this, "Error: PN unable to be sent. " + synergyNetworkConnectionHandle.getResponse().getHttpResponse().getStatusCode(), new Object[0]);
            }
        });
    }

    @Override
    public void setup() {
        Log.Helper.LOGD(this, "setup", new Object[0]);
    }

    @Override
    public void suspend() {
        Log.Helper.LOGD(this, "suspend", new Object[0]);
        Utility.unregisterReceiver(this.m_synergyIdChangedReceiver);
    }

    public void trackStuff() {
        Persistence persistence = PersistenceService.getPersistenceForNimbleComponent("GCMIntentService", Persistence.Storage.CACHE);
        Object object = (ArrayList)persistence.getValue("GCMMessageId");
        if (object == null) {
            return;
        }
        object = ((ArrayList)object).iterator();
        while (true) {
            ITracking iTracking;
            if (!object.hasNext()) {
                persistence.setValue("GCMMessageId", null);
                persistence.synchronize();
                return;
            }
            String string2 = (String)object.next();
            if (Base.getComponent("com.ea.nimble.tracking") == null || (iTracking = (ITracking)((Object)Base.getComponent("com.ea.nimble.tracking"))) == null) continue;
            HashMap<String, String> hashMap = new HashMap<String, String>();
            if (string2 != null) {
                hashMap.put("NIMBLESTANDARD::KEY_PN_MESSAGE_ID", string2);
            }
            iTracking.logEvent("NIMBLESTANDARD::PN_SHOWN_TO_USER", hashMap);
        }
    }
}

