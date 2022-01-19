/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Build$VERSION
 *  android.provider.Settings$Secure
 */
package com.ea.nimble.tracking;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import com.ea.nimble.ApplicationEnvironment;
import com.ea.nimble.IHttpRequest;
import com.ea.nimble.Log;
import com.ea.nimble.LogSource;
import com.ea.nimble.Network;
import com.ea.nimble.OperationalTelemetryDispatch;
import com.ea.nimble.SynergyEnvironment;
import com.ea.nimble.SynergyIdManager;
import com.ea.nimble.SynergyRequest;
import com.ea.nimble.Utility;
import com.ea.nimble.tracking.NimbleTrackingImplBase;
import com.ea.nimble.tracking.SynergyConstants;
import com.ea.nimble.tracking.Tracking;
import com.ea.nimble.tracking.TrackingBaseSessionObject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

class NimbleTrackingSynergyImpl
extends NimbleTrackingImplBase
implements LogSource {
    private static final String EVENT_PREFIX = "SYNERGYTRACKING::";
    private static final int MAX_CUSTOM_EVENT_PARAMETERS = 20;
    private int m_eventNumber;
    private Map<String, String> m_mainAuthenticator;
    private final BroadcastReceiver m_mainAuthenticatorUpdateReceiver;
    private List<Map<String, String>> m_pendingEvents;
    private final BroadcastReceiver m_pidInfoUpdateReceiver = new BroadcastReceiver(){

        public void onReceive(Context context, final Intent intent) {
            NimbleTrackingSynergyImpl.this.m_threadManager.runInWorkerThread(new Runnable(){

                @Override
                public void run() {
                    NimbleTrackingSynergyImpl.this.onPidInfoUpdate(intent);
                }
            });
        }
    };
    private Map<String, String> m_pidMap;
    private String m_sessionId;
    private SynergyIdChangedReceiver m_synergyIdChangedReceiver;

    NimbleTrackingSynergyImpl() {
        this.m_mainAuthenticatorUpdateReceiver = new BroadcastReceiver(){

            public void onReceive(Context context, final Intent intent) {
                NimbleTrackingSynergyImpl.this.m_threadManager.runInWorkerThread(new Runnable(){

                    @Override
                    public void run() {
                        NimbleTrackingSynergyImpl.this.onMainAuthenticatorUpdate(intent);
                    }
                });
            }
        };
        this.m_synergyIdChangedReceiver = new SynergyIdChangedReceiver();
        this.m_pendingEvents = new ArrayList<Map<String, String>>();
    }

    private void addPushTNGTrackingParams(Tracking.Event event, Map<String, String> map) {
        map.put("eventKeyType01", String.valueOf(SynergyConstants.EVT_KEYTYPE_MESSAGEID.value));
        map.put("eventValue01", event.parameters.get("NIMBLESTANDARD::KEY_PN_MESSAGE_ID"));
        map.put("eventKeyType02", String.valueOf(SynergyConstants.EVT_KEYTYPE_ENUMERATION.value));
        map.put("eventValue02", event.parameters.get("NIMBLESTANDARD::KEY_PN_MESSAGE_TYPE"));
        map.put("eventKeyType03", String.valueOf(SynergyConstants.EVT_KEYTYPE_ENUMERATION.value));
        map.put("eventValue03", event.parameters.get("NIMBLESTANDARD::KEY_PN_DEVICE_ID"));
    }

    /*
     * Unable to fully structure code
     */
    private Map<String, Object> generateSessionInfoDictionary(String var1_1) {
        var12_2 = SynergyEnvironment.getComponent();
        var10_3 = SynergyIdManager.getComponent();
        var9_4 = ApplicationEnvironment.getComponent();
        var8_5 = new HashMap<String, Object>();
        var6_6 = "";
        var4_7 = true;
        try {
            var7_8 = ApplicationEnvironment.getComponent().getGoogleAdvertisingId();
            var6_6 = var7_8;
            var4_7 = var5_10 = ApplicationEnvironment.getComponent().isLimitAdTrackingEnabled();
            var6_6 = var7_8;
lbl12:
            // 2 sources

            while (true) {
                var8_5.put("advertiserID", var6_6);
                break;
            }
        }
        catch (Exception var7_9) {
            Log.Helper.LOGW(this, "Exception when getting advertising ID for Android", new Object[0]);
            ** continue;
        }
        var8_5.put("limitAdTracking", var4_7);
        var7_8 = var12_2.getSellId();
        var11_11 = var12_2.getEAHardwareId();
        var12_2 = var12_2.getEADeviceId();
        var13_12 = Build.VERSION.RELEASE;
        var6_6 = ApplicationEnvironment.getComponent().getCarrier();
        var14_13 = ApplicationEnvironment.getComponent().getApplicationVersion();
        var15_14 = String.format(Locale.US, "%tZ", new Object[]{Calendar.getInstance()});
        var8_5.put("carrier", var6_6);
        var8_5.put("timezone", var15_14);
        var6_6 = var9_4.isAppCracked() != false ? "1" : "0";
        var8_5.put("pflag", var6_6);
        var6_6 = var9_4.isDeviceRooted() != false ? "1" : "0";
        var8_5.put("jflag", var6_6);
        var8_5.put("firmwareVer", var13_12);
        var8_5.put("sellId", Utility.safeString((String)var7_8));
        var8_5.put("buildId", Utility.safeString(var14_13));
        var8_5.put("sdkVer", "1.23.14.1217");
        var8_5.put("sdkCfg", "DL");
        var8_5.put("deviceId", Utility.safeString((String)var12_2));
        var8_5.put("hwId", Utility.safeString(var11_11));
        var8_5.put("schemaVer", "2");
        var8_5.put("platform", "android");
        var6_6 = "N";
        var7_8 = Network.getComponent();
        if (var7_8.getStatus() == Network.Status.OK) {
            var6_6 = var7_8.isNetworkWifi() != false ? "W" : "G";
        }
        var8_5.put("networkAccess", var6_6);
        var6_6 = this.m_loggedInToOrigin != false ? "Y" : "N";
        var8_5.put("originUser", var6_6);
        if (Utility.validString(var1_1)) lbl-1000:
        // 2 sources

        {
            while (true) {
                if (var1_1 != null) {
                    var8_5.put("uid", Utility.safeString(var1_1));
                }
                var8_5.put("androidId", Utility.safeString(Settings.Secure.getString((ContentResolver)var9_4.getApplicationContext().getContentResolver(), (String)"android_id")));
                var8_5.put("macHash", Utility.safeString(Utility.SHA256HashString(var9_4.getMACAddress())));
                var8_5.put("aut", Utility.safeString(""));
                if (this.m_pidMap != null && this.m_pidMap.size() > 0) {
                    var8_5.put("pidMap", this.m_pidMap);
                }
                if (var9_4 != null && (var1_1 = var9_4.getGameSpecifiedPlayerId()) != null && var1_1.length() > 0) {
                    var8_5.put("gamePlayerId", var1_1);
                }
                if ((var3_15 = this.m_customSessionData.size()) <= 0) return var8_5;
                var2_16 = 0;
                while (var2_16 < var3_15) {
                    var8_5.put(((NimbleTrackingImplBase.SessionData)this.m_customSessionData.get((int)var2_16)).key, ((NimbleTrackingImplBase.SessionData)this.m_customSessionData.get((int)var2_16)).value);
                    ++var2_16;
                }
                return var8_5;
            }
        }
        var1_1 = var10_3.getSynergyId();
        ** while (true)
    }

    private String generateSynergySessionId() {
        Object object = Utility.getUTCDateStringFormat(new Date()).replace("_", "");
        StringBuilder stringBuilder = new StringBuilder(24);
        stringBuilder.append((String)object);
        int n2 = stringBuilder.length();
        object = new Random();
        int n3 = 0;
        while (n3 < 24 - n2) {
            stringBuilder.append(((Random)object).nextInt(10));
            ++n3;
        }
        return stringBuilder.toString();
    }

    private static boolean isSynergyEvent(String string2) {
        if (string2 != null) return string2.startsWith(EVENT_PREFIX);
        return false;
    }

    private void onMainAuthenticatorUpdate(Intent object) {
        if ((object = (HashMap)object.getSerializableExtra("NIMBLESTANDARD::KEY_IDENTITY_SOURCE")) == null) return;
        if (((HashMap)object).size() <= 0) return;
        this.m_mainAuthenticator = object;
    }

    private void onPidInfoUpdate(Intent object) {
        if ((object = (HashMap)object.getSerializableExtra("pidMapId")) == null) return;
        if (((HashMap)object).size() <= 0) return;
        this.m_pidMap = object;
        this.m_currentSessionObject.sessionData.put("pidMap", this.m_pidMap);
    }

    private void onSynergyIdChanged(Intent object) {
        String string2 = object.getStringExtra("previousSynergyId");
        object = object.getStringExtra("currentSynergyId");
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("eventType", String.valueOf(SynergyConstants.EVT_SESSION_END_SYNERGYID_CHANGE.value));
        hashMap.put("keyType01", String.valueOf(SynergyConstants.EVT_KEYTYPE_SYNERGYID.value));
        hashMap.put("keyValue01", Utility.safeString(string2));
        hashMap.put("keyType02", String.valueOf(SynergyConstants.EVT_KEYTYPE_SYNERGYID.value));
        hashMap.put("keyValue02", Utility.safeString((String)object));
        this.logEvent("SYNERGYTRACKING::CUSTOM", hashMap);
        this.m_currentSessionObject.sessionData = new HashMap<String, Object>(this.generateSessionInfoDictionary(string2));
        this.queueCurrentEventsForPost();
        hashMap.put("eventType", String.valueOf(SynergyConstants.EVT_NEW_SESSION_START_SYNERGYID_CHANGE.value));
        this.logEvent("SYNERGYTRACKING::CUSTOM", hashMap);
    }

    /*
     * Exception decompiling
     */
    private void parseCustomParameters(Map<String, String> var1_1, Map<String, String> var2_2) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 1[TRYBLOCK] [2 : 171->177)] java.lang.NumberFormatException
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2283)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:415)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompileToZip(CFRDecompiler.java:306)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.lambda$null$1(ResourceDecompiling.java:114)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling$$Lambda$144/691390785.run(Unknown Source)
         *     at java.lang.Thread.run(Unknown Source)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private void resetSession() {
        this.m_sessionId = this.generateSynergySessionId();
        this.m_eventNumber = 1;
    }

    private void sleep() {
        Utility.unregisterReceiver(this.m_synergyIdChangedReceiver);
    }

    private void wakeup() {
        Utility.registerReceiver("nimble.synergyidmanager.notification.synergy_id_changed", this.m_synergyIdChangedReceiver);
    }

    @Override
    protected boolean canDropSession(List<TrackingBaseSessionObject> iterator) {
        String string2;
        iterator = iterator.get(0);
        if (((TrackingBaseSessionObject)((Object)iterator)).events.size() == 0) {
            Log.Helper.LOGE(this, "Trying to drop session with no events", new Object[0]);
            return true;
        }
        iterator = ((TrackingBaseSessionObject)((Object)iterator)).events.iterator();
        do {
            if (!iterator.hasNext()) return true;
        } while ((string2 = iterator.next().get("eventType")) == null || !string2.equals(String.valueOf(SynergyConstants.EVT_APPSTART_AFTERINSTALL.value)));
        return false;
    }

    @Override
    protected void cleanup() {
        this.sleep();
        super.cleanup();
    }

    /*
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    @Override
    protected List<Map<String, String>> convertEvent(Tracking.Event arrayList) {
        Object object;
        Object object2222222;
        HashMap<String, String> hashMap;
        Object object3;
        Object object4;
        block83: {
            object4 = SynergyConstants.EVT_UNDEFINED;
            object3 = -1;
            hashMap = new HashMap<String, String>();
            if (!Tracking.isNimbleStandardEvent(((Tracking.Event)((Object)arrayList)).type) && !NimbleTrackingSynergyImpl.isSynergyEvent(((Tracking.Event)((Object)arrayList)).type)) {
                return null;
            }
            if (((Tracking.Event)((Object)arrayList)).type.equals("NIMBLESTANDARD::APPSTART_NORMAL")) {
                object4 = SynergyConstants.EVT_APPSTART_NORMALLY;
                object2222222 = object3;
            } else if (((Tracking.Event)((Object)arrayList)).type.equals("NIMBLESTANDARD::APPSTART_AFTERINSTALL")) {
                object4 = SynergyConstants.EVT_APPSTART_AFTERINSTALL;
                object2222222 = object3;
            } else if (((Tracking.Event)((Object)arrayList)).type.equals("NIMBLESTANDARD::APPSTART_AFTERUPGRADE")) {
                object4 = SynergyConstants.EVT_APPSTART_AFTERUPGRADE;
                object2222222 = object3;
            } else if (((Tracking.Event)((Object)arrayList)).type.equals("NIMBLESTANDARD::APPSTART_FROMURL")) {
                object4 = SynergyConstants.EVT_APPSTART_FROM_URL;
                object2222222 = object3;
            } else if (((Tracking.Event)((Object)arrayList)).type.equals("NIMBLESTANDARD::APPSTART_FROMPUSH")) {
                object4 = SynergyConstants.EVT_APPSTART_FROMPUSH;
                try {
                    object2222222 = ApplicationEnvironment.getComponent().getApplicationContext().getSharedPreferences("PushNotification", 0).getString("messageId", null);
                    if (object2222222 == null) {
                        this.addPushTNGTrackingParams((Tracking.Event)((Object)arrayList), (Map<String, String>)hashMap);
                        object2222222 = object3;
                    }
                    hashMap.put("eventKeyType01", String.valueOf(SynergyConstants.EVT_KEYTYPE_MESSAGEID.value));
                    hashMap.put("eventValue01", (String)object2222222);
                    ApplicationEnvironment.getComponent().getApplicationContext().getSharedPreferences("PushNotification", 0).edit().remove("messageId").commit();
                    ApplicationEnvironment.getComponent().getApplicationContext().getSharedPreferences("PushNotification", 0).edit().remove("PushNotification").commit();
                    object2222222 = object3;
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                    object2222222 = object3;
                }
            } else if (((Tracking.Event)((Object)arrayList)).type.equals("NIMBLESTANDARD::APPRESUME_FROMURL")) {
                object4 = SynergyConstants.EVT_APP_ENTER_FOREGROUND_FROM_URL;
                object2222222 = object3;
            } else if (((Tracking.Event)((Object)arrayList)).type.equals("NIMBLESTANDARD::APPRESUME_FROMEBISU")) {
                object4 = SynergyConstants.EVT_APP_ENTER_FOREGROUND_FROM_EBISU;
                object2222222 = object3;
            } else if (((Tracking.Event)((Object)arrayList)).type.equals("NIMBLESTANDARD::APPRESUME_FROMPUSH")) {
                object4 = SynergyConstants.EVT_APP_RESUME_FROM_PUSH;
                try {
                    object2222222 = ApplicationEnvironment.getComponent().getApplicationContext().getSharedPreferences("PushNotification", 0).getString("messageId", null);
                    if (object2222222 == null) {
                        this.addPushTNGTrackingParams((Tracking.Event)((Object)arrayList), (Map<String, String>)hashMap);
                        object2222222 = object3;
                    }
                    hashMap.put("eventKeyType01", String.valueOf(SynergyConstants.EVT_KEYTYPE_MESSAGEID.value));
                    hashMap.put("eventValue01", (String)object2222222);
                    ApplicationEnvironment.getComponent().getApplicationContext().getSharedPreferences("PushNotification", 0).edit().remove("messageId").commit();
                    ApplicationEnvironment.getComponent().getApplicationContext().getSharedPreferences("PushNotification", 0).edit().remove("PushNotification").commit();
                    object2222222 = object3;
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                    object2222222 = object3;
                }
            } else if (((Tracking.Event)((Object)arrayList)).type.equals("NIMBLESTANDARD::SESSION_START")) {
                object4 = SynergyConstants.EVT_APP_SESSION_START;
                object2222222 = object3;
            } else if (((Tracking.Event)((Object)arrayList)).type.equals("NIMBLESTANDARD::SESSION_END")) {
                object4 = SynergyConstants.EVT_APP_SESSION_END;
                object2222222 = object3;
            } else if (((Tracking.Event)((Object)arrayList)).type.equals("NIMBLESTANDARD::SESSION_TIME")) {
                object4 = SynergyConstants.EVT_APP_SESSION_TIME;
                hashMap.put("eventKeyType01", String.valueOf(SynergyConstants.EVT_KEYTYPE_DURATION.value));
                hashMap.put("eventValue01", ((Tracking.Event)((Object)arrayList)).parameters.get("NIMBLESTANDARD::KEY_DURATION"));
                object2222222 = object3;
            } else if (((Tracking.Event)((Object)arrayList)).type.equals("NIMBLESTANDARD::MTX_ITEM_BEGIN_PURCHASE")) {
                object4 = SynergyConstants.EVT_MTXVIEW_ITEMPURCHASE;
                hashMap.put("eventKeyType01", String.valueOf(SynergyConstants.EVT_KEYTYPE_MTX_SELLID.value));
                hashMap.put("eventValue01", ((Tracking.Event)((Object)arrayList)).parameters.get("NIMBLESTANDARD::KEY_MTX_SELLID"));
                object2222222 = object3;
            } else if (((Tracking.Event)((Object)arrayList)).type.equals("NIMBLESTANDARD::MTX_ITEM_PURCHASED")) {
                object4 = SynergyConstants.EVT_MTXVIEW_ITEM_PURCHASED;
                hashMap.put("eventKeyType01", String.valueOf(SynergyConstants.EVT_KEYTYPE_MTX_SELLID.value));
                hashMap.put("eventValue01", ((Tracking.Event)((Object)arrayList)).parameters.get("NIMBLESTANDARD::KEY_MTX_SELLID"));
                object2222222 = object3;
            } else if (((Tracking.Event)((Object)arrayList)).type.equals("NIMBLESTANDARD::MTX_FREEITEM_DOWNLOADED")) {
                object4 = SynergyConstants.EVT_MTXVIEW_FREEITEM_DOWNLOADED;
                hashMap.put("eventKeyType01", String.valueOf(SynergyConstants.EVT_KEYTYPE_MTX_SELLID.value));
                hashMap.put("eventValue01", ((Tracking.Event)((Object)arrayList)).parameters.get("NIMBLESTANDARD::KEY_MTX_SELLID"));
                object2222222 = object3;
            } else if (((Tracking.Event)((Object)arrayList)).type.equals("NIMBLESTANDARD::USER_TRACKING_OPTOUT")) {
                object4 = SynergyConstants.EVT_USER_TRACKING_OPTOUT;
                object2222222 = object3;
            } else if (((Tracking.Event)((Object)arrayList)).type.equals("NIMBLESTANDARD::PN_DISPLAY_OPT_IN")) {
                object4 = SynergyConstants.EVT_USER_SHOWN_PN_OPTIN_PROMPT;
                object2222222 = object3;
            } else if (((Tracking.Event)((Object)arrayList)).type.equals("NIMBLESTANDARD::PN_USER_OPT_IN")) {
                object4 = SynergyConstants.EVT_USER_SHOWN_PN_OPTIN_PROMPT;
                hashMap.put("eventKeyType02", ((Tracking.Event)((Object)arrayList)).parameters.get(SynergyConstants.EVT_KEYTYPE_ENUMERATION.value));
                hashMap.put("eventValue02", "Yes");
                object2222222 = object3;
            } else if (((Tracking.Event)((Object)arrayList)).type.equals("NIMBLESTANDARD::PN_SHOWN_TO_USER")) {
                object = SynergyConstants.EVT_PN_SHOWN_TO_USER;
                hashMap.put("eventKeyType01", String.valueOf(SynergyConstants.EVT_KEYTYPE_MESSAGEID.value));
                hashMap.put("eventValue01", ((Tracking.Event)((Object)arrayList)).parameters.get("NIMBLESTANDARD::KEY_PN_MESSAGE_ID"));
                if (((Tracking.Event)((Object)arrayList)).parameters.containsKey("NIMBLESTANDARD::KEY_PN_MESSAGE_ID")) {
                    hashMap.put("eventKeyType02", String.valueOf(SynergyConstants.EVT_KEYTYPE_ENUMERATION.value));
                    hashMap.put("eventValue02", ((Tracking.Event)((Object)arrayList)).parameters.get("NIMBLESTANDARD::KEY_PN_MESSAGE_TYPE"));
                }
                object4 = object;
                object2222222 = object3;
                if (((Tracking.Event)((Object)arrayList)).parameters.containsKey("NIMBLESTANDARD::KEY_PN_DEVICE_ID")) {
                    hashMap.put("eventKeyType03", String.valueOf(SynergyConstants.EVT_KEYTYPE_ENUMERATION.value));
                    hashMap.put("eventValue03", ((Tracking.Event)((Object)arrayList)).parameters.get("NIMBLESTANDARD::KEY_PN_DEVICE_ID"));
                    object4 = object;
                    object2222222 = object3;
                }
            } else if (((Tracking.Event)((Object)arrayList)).type.equals("NIMBLESTANDARD::PN_RECEIVED")) {
                object4 = SynergyConstants.EVT_PN_RECEIVED;
                this.addPushTNGTrackingParams((Tracking.Event)((Object)arrayList), (Map<String, String>)hashMap);
                object2222222 = object3;
            } else if (((Tracking.Event)((Object)arrayList)).type.equals("NIMBLESTANDARD::PN_DEVICE_REGISTERED")) {
                object4 = SynergyConstants.EVT_PN_DEVICE_REGISTERED;
                hashMap.put("eventKeyType01", String.valueOf(SynergyConstants.EVT_KEYTYPE_ENUMERATION.value));
                hashMap.put("eventValue01", ((Tracking.Event)((Object)arrayList)).parameters.get("NIMBLESTANDARD::KEY_PN_DATE_OF_BIRTH"));
                hashMap.put("eventKeyType02", String.valueOf(SynergyConstants.EVT_KEYTYPE_ENUMERATION.value));
                hashMap.put("eventValue02", ((Tracking.Event)((Object)arrayList)).parameters.get("NIMBLESTANDARD::KEY_PN_DISABLED_FLAG"));
                hashMap.put("eventKeyType03", String.valueOf(SynergyConstants.EVT_KEYTYPE_ENUMERATION.value));
                hashMap.put("eventValue03", ((Tracking.Event)((Object)arrayList)).parameters.get("NIMBLESTANDARD::KEY_PN_DEVICE_ID"));
                object2222222 = object3;
            } else if (((Tracking.Event)((Object)arrayList)).type.equals("NIMBLESTANDARD::PN_USER_CLICKED_OK")) {
                object4 = SynergyConstants.EVT_PN_SHOWN_TO_USER;
                hashMap.put("eventKeyType01", String.valueOf(SynergyConstants.EVT_KEYTYPE_MESSAGEID.value));
                hashMap.put("eventValue01", ((Tracking.Event)((Object)arrayList)).parameters.get("NIMBLESTANDARD::KEY_PN_MESSAGE_ID"));
                hashMap.put("eventKeyType02", ((Tracking.Event)((Object)arrayList)).parameters.get(SynergyConstants.EVT_KEYTYPE_ENUMERATION.value));
                hashMap.put("eventValue02", "Ok");
                object2222222 = object3;
            } else if (((Tracking.Event)((Object)arrayList)).type.equals("NIMBLESTANDARD::IDENTITY_MIGRATION")) {
                object4 = SynergyConstants.EVT_IDENTITY_MIGRATION;
                hashMap.put("eventKeyType01", String.valueOf(SynergyConstants.EVT_KEYTYPE_ENUMERATION.value));
                hashMap.put("eventValue01", ((Tracking.Event)((Object)arrayList)).parameters.get("NIMBLESTANDARD::KEY_MIGRATION_GAME_TRIGGERED"));
                hashMap.put("eventKeyType02", String.valueOf(SynergyConstants.EVT_KEYTYPE_JSON_MAP.value));
                hashMap.put("eventValue02", ((Tracking.Event)((Object)arrayList)).parameters.get("NIMBLESTANDARD::KEY_IDENTITY_SOURCE"));
                hashMap.put("eventKeyType02", String.valueOf(SynergyConstants.EVT_KEYTYPE_JSON_MAP.value));
                hashMap.put("eventValue02", ((Tracking.Event)((Object)arrayList)).parameters.get("NIMBLESTANDARD::KEY_IDENTITY_TARGET"));
                object2222222 = object3;
            } else if (((Tracking.Event)((Object)arrayList)).type.equals("NIMBLESTANDARD::IDENTITY_LOGIN")) {
                object4 = SynergyConstants.EVT_IDENTITY_LOGIN;
                hashMap.put("eventKeyType01", String.valueOf(SynergyConstants.EVT_KEYTYPE_JSON_MAP.value));
                hashMap.put("eventValue01", ((Tracking.Event)((Object)arrayList)).parameters.get("NIMBLESTANDARD::KEY_IDENTITY_PIDMAP_LOGIN"));
                hashMap.put("eventKeyType02", String.valueOf(SynergyConstants.EVT_KEYTYPE_JSON_MAP.value));
                hashMap.put("eventValue02", ((Tracking.Event)((Object)arrayList)).parameters.get("NIMBLESTANDARD::KEY_IDENTITY_TARGET"));
                object2222222 = new HashMap();
                for (Object object5 : Utility.convertJSONObjectStringToMap(((Tracking.Event)((Object)arrayList)).parameters.get("NIMBLESTANDARD::KEY_IDENTITY_PIDMAP_LOGIN")).entrySet()) {
                    object2222222.put(object5.getKey(), object5.getValue().toString());
                }
                for (Object object5 : Utility.convertJSONObjectStringToMap(((Tracking.Event)((Object)arrayList)).parameters.get("NIMBLESTANDARD::KEY_IDENTITY_TARGET")).entrySet()) {
                    object2222222.put(object5.getKey(), object5.getValue().toString());
                }
                this.m_pidMap = object2222222;
                this.m_currentSessionObject.sessionData.put("pidMap", this.m_pidMap);
                object2222222 = object3;
            } else if (((Tracking.Event)((Object)arrayList)).type.equals("NIMBLESTANDARD::IDENTITY_LOGOUT")) {
                object4 = SynergyConstants.EVT_IDENTITY_LOGOUT;
                hashMap.put("eventKeyType01", String.valueOf(SynergyConstants.EVT_KEYTYPE_JSON_MAP.value));
                hashMap.put("eventValue01", ((Tracking.Event)((Object)arrayList)).parameters.get("NIMBLESTANDARD::KEY_IDENTITY_SOURCE"));
                hashMap.put("eventKeyType02", String.valueOf(SynergyConstants.EVT_KEYTYPE_JSON_MAP.value));
                hashMap.put("eventValue02", ((Tracking.Event)((Object)arrayList)).parameters.get("NIMBLESTANDARD::KEY_IDENTITY_PIDMAP_LOGOUT"));
                object2222222 = new HashMap();
                for (Object object5 : Utility.convertJSONObjectStringToMap(((Tracking.Event)((Object)arrayList)).parameters.get("NIMBLESTANDARD::KEY_IDENTITY_PIDMAP_LOGOUT")).entrySet()) {
                    object2222222.put(object5.getKey(), object5.getValue().toString());
                }
                this.m_pidMap = object2222222;
                this.m_currentSessionObject.sessionData.put("pidMap", this.m_pidMap);
                object2222222 = object3;
            } else if (((Tracking.Event)((Object)arrayList)).type.equals("NIMBLESTANDARD::IDENTITY_MIGRATION_STARTED")) {
                object4 = SynergyConstants.EVT_IDENTITY_MIGRATION_STARTED;
                hashMap.put("eventKeyType01", String.valueOf(SynergyConstants.EVT_KEYTYPE_ENUMERATION.value));
                hashMap.put("eventValue01", ((Tracking.Event)((Object)arrayList)).parameters.get("NIMBLESTANDARD::KEY_MIGRATION_GAME_TRIGGERED"));
                hashMap.put("eventKeyType02", String.valueOf(SynergyConstants.EVT_KEYTYPE_JSON_MAP.value));
                hashMap.put("eventValue02", ((Tracking.Event)((Object)arrayList)).parameters.get("NIMBLESTANDARD::KEY_IDENTITY_SOURCE"));
                hashMap.put("eventKeyType03", String.valueOf(SynergyConstants.EVT_KEYTYPE_JSON_MAP.value));
                hashMap.put("eventValue03", ((Tracking.Event)((Object)arrayList)).parameters.get("NIMBLESTANDARD::KEY_IDENTITY_TARGET"));
                object2222222 = object3;
            } else if (((Tracking.Event)((Object)arrayList)).type.equals("NIMBLESTANDARD::TUTORIAL_COMPLETE")) {
                object4 = SynergyConstants.EVT_GAMEPLAY_PROGRESSION_TUTORIAL_COMPLETE;
                object2222222 = object3;
            } else if (((Tracking.Event)((Object)arrayList)).type.equals("NIMBLESTANDARD::LEVEL_UP")) {
                object4 = SynergyConstants.EVT_GP_LEVEL_PROMOTION;
                hashMap.put("eventKeyType01", String.valueOf(SynergyConstants.EVT_KEYTYPE_DURATION.value));
                hashMap.put("eventValue01", ((Tracking.Event)((Object)arrayList)).parameters.get("NIMBLESTANDARD::KEY_DURATION"));
                hashMap.put("eventKeyType02", String.valueOf(SynergyConstants.EVT_KEYTYPE_DURATION.value));
                hashMap.put("eventValue02", ((Tracking.Event)((Object)arrayList)).parameters.get("NIMBLESTANDARD::KEY_GAMEPLAY_DURATION"));
                hashMap.put("eventKeyType03", String.valueOf(SynergyConstants.EVT_KEYTYPE_ENUMERATION.value));
                hashMap.put("eventValue03", ((Tracking.Event)((Object)arrayList)).parameters.get("NIMBLESTANDARD::KEY_USER_LEVEL"));
                object2222222 = object3;
            } else {
                if (!((Tracking.Event)((Object)arrayList)).type.equals("SYNERGYTRACKING::CUSTOM")) return null;
                object4 = ((Tracking.Event)((Object)arrayList)).parameters.get("eventType");
                int n2 = Integer.parseInt((String)object4);
                object4 = SynergyConstants.fromInt(n2);
                if (object4 == SynergyConstants.EVT_UNDEFINED) {
                    object3 = n2;
                }
                this.parseCustomParameters(((Tracking.Event)((Object)arrayList)).parameters, hashMap);
                object2222222 = object3;
            }
            object = hashMap.keySet().iterator();
            break block83;
            catch (NumberFormatException numberFormatException) {
                Log.Helper.LOGE(this, "Error: Invalid format for eventType parameter. Expected integer value, got " + (String)object4, new Object[0]);
                return null;
            }
        }
        while (object.hasNext()) {
            Object object5;
            object5 = (String)object.next();
            object3 = (String)hashMap.get(object5);
            if (!Utility.validString((String)object3) || !((String)object3).startsWith("${") || !((String)object3).endsWith("}")) continue;
            if ((object3 = (String)this.m_trackingAttributes.get(((String)object3).substring(2, ((String)object3).length() - 1))) == null) {
                object3 = "";
            }
            hashMap.put((String)object5, (String)object3);
        }
        object3 = Utility.getUTCDateStringFormat(((Tracking.Event)((Object)arrayList)).timestamp);
        arrayList = new ArrayList<Map<String, String>>();
        if ((Integer)object2222222 != -1) {
            hashMap.put("eventType", String.valueOf(object2222222));
        } else {
            hashMap.put("eventType", String.valueOf(object4.value));
        }
        hashMap.put("timestamp", (String)object3);
        if (object4.isSessionStartEventType()) {
            if (this.m_currentSessionObject.sessionData.size() > 0) {
                this.queueCurrentEventsForPost();
            }
            this.resetSession();
            for (Object object2222222 : this.m_pendingEvents) {
                object2222222.put("session", this.m_sessionId);
                object2222222.put("step", String.valueOf(this.m_eventNumber));
                ++this.m_eventNumber;
                arrayList.add((Map<String, String>)object2222222);
            }
            this.m_pendingEvents.clear();
        } else if (this.m_sessionId == null) {
            this.m_pendingEvents.add(hashMap);
            return null;
        }
        hashMap.put("session", this.m_sessionId);
        hashMap.put("step", String.valueOf(this.m_eventNumber));
        ++this.m_eventNumber;
        if (object4.isSessionStartEventType()) {
            Log.Helper.LOGD(this, "Logging session start event, %s. Posting event queue now.", object4);
            this.resetPostTimer(0.0);
        }
        if (object4 == SynergyConstants.EVT_APP_SESSION_END) {
            this.m_sessionId = null;
        }
        arrayList.add(hashMap);
        return arrayList;
    }

    @Override
    protected SynergyRequest createPostRequest(TrackingBaseSessionObject object) {
        Object object2 = SynergyEnvironment.getComponent().getServerUrlWithKey("synergy.tracking");
        if (object2 == null) {
            Log.Helper.LOGI(this, "Tracking server URL from NimbleEnvironment is nil. Adding observer for environment update finish.", new Object[0]);
            this.addObserverForSynergyEnvironmentUpdateFinished();
            return null;
        }
        Object object3 = ((TrackingBaseSessionObject)object).sessionData;
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.putAll((Map<String, Object>)object3);
        hashMap.put("now_timestamp", Utility.getUTCDateStringFormat(new Date()));
        object3 = new ArrayList<Map<String, String>>(((TrackingBaseSessionObject)object).events);
        for (int i2 = 0; i2 < object3.size(); ++i2) {
            ((Map)object3.get(i2)).put("repostCount", String.valueOf(((TrackingBaseSessionObject)object).repostCount));
        }
        hashMap.put("events", object3);
        if (hashMap.get("uid") == null) {
            object = SynergyIdManager.getComponent().getSynergyId();
            if (Utility.validString((String)object)) {
                Log.Helper.LOGV(this, "Creating post request. No uid in session info dictionary, inserting uid value %s now.", object);
                hashMap.put("uid", object);
            } else {
                Log.Helper.LOGV(this, "Creating post request. No uid in session info dictionary, still no uid available now.", new Object[0]);
            }
        }
        object = SynergyEnvironment.getComponent();
        object3 = hashMap.get("sellId").toString();
        if (object3 == null || ((String)object3).equals("")) {
            object3 = Utility.safeString(object.getSellId());
            if (object3 == null || ((String)object3).equals("")) {
                Log.Helper.LOGE(this, "Creating POST request. Missing sell id.", new Object[0]);
            } else {
                hashMap.put("sellId", object3);
            }
        }
        if ((object3 = hashMap.get("hwId").toString()) == null || ((String)object3).equals("")) {
            object3 = Utility.safeString(object.getEAHardwareId());
            if (object3 == null || ((String)object3).equals("")) {
                Log.Helper.LOGE(this, "Creating POST request. Missing hw id.", new Object[0]);
            } else {
                hashMap.put("hwId", object3);
            }
        }
        if ((object3 = hashMap.get("deviceId").toString()) == null || ((String)object3).equals("")) {
            if ((object = Utility.safeString(object.getEADeviceId())) == null || ((String)object).equals("")) {
                Log.Helper.LOGE(this, "Creating POST request. Missing device id.", new Object[0]);
            } else {
                hashMap.put("deviceId", object);
            }
        }
        object = new SynergyRequest("/tracking/api/core/logEvent", IHttpRequest.Method.POST, null);
        ((SynergyRequest)object).baseUrl = object2;
        ((SynergyRequest)object).jsonData = hashMap;
        object2 = OperationalTelemetryDispatch.getComponent();
        if (object2 != null) {
            object3 = new HashMap<String, String>();
            ((HashMap)object3).put("BASEURL", ((SynergyRequest)object).baseUrl);
            ((HashMap)object3).put("API", ((SynergyRequest)object).api);
            ((HashMap)object3).put("POSTDATA", Utility.convertObjectToJSONString(hashMap));
            object2.logEvent("com.ea.nimble.trackingimpl.synergy", (Map<String, String>)object3);
        }
        Utility.sendBroadcast("nimble.notification.trackingimpl.synergy.postingToServer", null);
        return object;
    }

    @Override
    public String getComponentId() {
        return "com.ea.nimble.trackingimpl.synergy";
    }

    @Override
    public String getLogSourceTitle() {
        return "TrackingSynergy";
    }

    @Override
    protected String getPersistenceIdentifier() {
        return "Synergy";
    }

    @Override
    protected boolean isSameSession(TrackingBaseSessionObject object, TrackingBaseSessionObject object2) {
        if (((TrackingBaseSessionObject)object).events.size() == 0 || ((TrackingBaseSessionObject)object2).events.size() == 0) {
            Log.Helper.LOGE(this, "Trying to compare session with no events", new Object[0]);
            return true;
        }
        object = ((TrackingBaseSessionObject)object).events.get(0).get("session");
        object2 = ((TrackingBaseSessionObject)object2).events.get(0).get("session");
        if (object != null) {
            if (object2 != null) return ((String)object).equals(object2);
        }
        Log.Helper.LOGE(this, "Trying to compare event with no session", new Object[0]);
        return true;
    }

    @Override
    protected void packageCurrentSession() {
        if (this.m_currentSessionObject.countOfEvents() <= 0) return;
        Log.Helper.LOGV(this, "Preparing for post, generating session info dictionary.", new Object[0]);
        this.m_currentSessionObject.sessionData = new HashMap<String, Object>(this.generateSessionInfoDictionary(null));
        this.queueCurrentEventsForPost();
    }

    @Override
    protected void restore() {
        super.restore();
        Utility.registerReceiver("nimble.notification.identity.authenticator.pid.info.update", this.m_pidInfoUpdateReceiver);
        Utility.registerReceiver("nimble.notification.identity.main.authenticator.change", this.m_mainAuthenticatorUpdateReceiver);
        this.wakeup();
    }

    @Override
    public void setEnable(boolean bl2) {
        super.setEnable(bl2);
        if (!bl2) {
            this.m_sessionId = null;
        }
        if (this.m_sessionId != null) return;
        if (!bl2) return;
        this.resetSession();
        this.logEvent("NIMBLESTANDARD::SESSION_START", null);
    }

    private class SynergyIdChangedReceiver
    extends BroadcastReceiver {
        private SynergyIdChangedReceiver() {
        }

        public void onReceive(Context context, final Intent intent) {
            NimbleTrackingSynergyImpl.this.m_threadManager.runInWorkerThread(new Runnable(){

                @Override
                public void run() {
                    NimbleTrackingSynergyImpl.this.onSynergyIdChanged(intent);
                }
            });
        }
    }
}

