/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.ea.nimble.tracking;

import com.ea.nimble.IHttpRequest;
import com.ea.nimble.Log;
import com.ea.nimble.LogSource;
import com.ea.nimble.SynergyEnvironment;
import com.ea.nimble.SynergyIdManager;
import com.ea.nimble.SynergyNetworkConnectionHandle;
import com.ea.nimble.SynergyRequest;
import com.ea.nimble.Utility;
import com.ea.nimble.tracking.NimbleTrackingImplBase;
import com.ea.nimble.tracking.Tracking;
import com.ea.nimble.tracking.TrackingBaseSessionObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

class NimbleTrackingS2SImpl
extends NimbleTrackingImplBase
implements LogSource {
    public static final int EVENT_APPRESUMED = 103;
    public static final int EVENT_APPSTARTED = 102;
    public static final int EVENT_APPSTARTED_AFTERINSTALL = 101;
    public static final int EVENT_LEVEL_UP = 108;
    public static final int EVENT_MTXVIEW_ITEM_PURCHASED = 105;
    private static final String EVENT_PREFIX = "SYNERGYS2S::";
    public static final int EVENT_REFERRERID_RECEIVED = 106;
    public static final int EVENT_TUTORIAL_COMPLETE = 107;
    public static final int EVENT_USER_REGISTERED = 104;
    private static final double MARS_DEFAULT_POST_INTERVAL = 60.0;
    private static final double MARS_MAX_POST_RETRY_DELAY = 86400.0;
    private static final String SYNERGY_API_POST_EVENTS = "/s2s/api/core/postEvents";

    NimbleTrackingS2SImpl() {
    }

    /*
     * Exception decompiling
     */
    private Map<String, Object> createEventRequestPostMap() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 7[UNCONDITIONALDOLOOP]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
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

    private static boolean isS2SEvent(String string2) {
        if (string2 != null) return string2.startsWith(EVENT_PREFIX);
        return false;
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
        } while ((string2 = iterator.next().get("eventType")) == null || !string2.equals(String.valueOf(101)));
        return false;
    }

    @Override
    protected List<Map<String, String>> convertEvent(Tracking.Event object) {
        String string2;
        String string3;
        String string4;
        String string5;
        int n2;
        String string6 = null;
        String string7 = null;
        String string8 = null;
        String string9 = null;
        String string10 = null;
        String string11 = null;
        String string12 = null;
        if (!Tracking.isNimbleStandardEvent(((Tracking.Event)object).type) && !NimbleTrackingS2SImpl.isS2SEvent(((Tracking.Event)object).type)) {
            return null;
        }
        HashMap<String, Object> hashMap = new HashMap<String, Object>(7);
        if (((Tracking.Event)object).type.equals("NIMBLESTANDARD::APPSTART_AFTERINSTALL")) {
            n2 = 101;
            string6 = "Launch";
            string5 = string12;
            string4 = string10;
            string3 = string11;
            string2 = string9;
        } else if (((Tracking.Event)object).type.equals("NIMBLESTANDARD::APPSTART_NORMAL") || ((Tracking.Event)object).type.equals("NIMBLESTANDARD::APPSTART_AFTERUPGRADE") || ((Tracking.Event)object).type.equals("NIMBLESTANDARD::APPSTART_FROMURL")) {
            n2 = 102;
            string6 = "Launch";
            string2 = string9;
            string3 = string11;
            string4 = string10;
            string5 = string12;
        } else if (((Tracking.Event)object).type.equals("NIMBLESTANDARD::APPSTART_FROMPUSH")) {
            n2 = 102;
            string6 = "NotificationLaunch";
            string2 = string9;
            string3 = string11;
            string4 = string10;
            string5 = string12;
        } else if (((Tracking.Event)object).type.equals("NIMBLESTANDARD::APPRESUME_NORMAL") || ((Tracking.Event)object).type.equals("NIMBLESTANDARD::SESSION_START") || ((Tracking.Event)object).type.equals("NIMBLESTANDARD::APPRESUME_FROMURL") || ((Tracking.Event)object).type.equals("NIMBLESTANDARD::APPRESUME_FROMEBISU")) {
            n2 = 103;
            string6 = "Resume";
            string2 = string9;
            string3 = string11;
            string4 = string10;
            string5 = string12;
        } else if (((Tracking.Event)object).type.equals("NIMBLESTANDARD::APPRESUME_FROMPUSH")) {
            n2 = 103;
            string6 = "NotificationResume";
            string2 = string9;
            string3 = string11;
            string4 = string10;
            string5 = string12;
        } else if (((Tracking.Event)object).type.equals("NIMBLESTANDARD::USER_REGISTERED")) {
            int n3 = 104;
            String string13 = "Registration";
            String string14 = "username";
            String string15 = ((Tracking.Event)object).parameters.get("NIMBLESTANDARD::KEY_USERNAME");
            string7 = string14;
            string2 = string9;
            string3 = string11;
            string8 = string15;
            string4 = string10;
            string5 = string12;
            string6 = string13;
            n2 = n3;
            if (string15 == null) {
                Log.Helper.LOGE(this, "Error: missing event parameter \"%s\"", "NIMBLESTANDARD::KEY_USERNAME");
                string7 = string14;
                string2 = string9;
                string3 = string11;
                string8 = string15;
                string4 = string10;
                string5 = string12;
                string6 = string13;
                n2 = n3;
            }
        } else if (((Tracking.Event)object).type.equals("NIMBLESTANDARD::MTX_ITEM_PURCHASED")) {
            int n4 = 105;
            string9 = "Purchase";
            string10 = "tvalue";
            String string16 = ((Tracking.Event)object).parameters.get("NIMBLESTANDARD::KEY_MTX_CURRENCY");
            String string17 = "fvalue";
            String string18 = ((Tracking.Event)object).parameters.get("NIMBLESTANDARD::KEY_MTX_PRICE");
            if (string16 == null) {
                Log.Helper.LOGE(this, "Error: missing event parameter \"%s\"", "NIMBLESTANDARD::KEY_MTX_CURRENCY");
            }
            string7 = string10;
            string2 = string17;
            string3 = string11;
            string8 = string16;
            string4 = string18;
            string5 = string12;
            string6 = string9;
            n2 = n4;
            if (string18 == null) {
                Log.Helper.LOGE(this, "Error: missing event parameter \"%s\"", "NIMBLESTANDARD::KEY_MTX_PRICE");
                string7 = string10;
                string2 = string17;
                string3 = string11;
                string8 = string16;
                string4 = string18;
                string5 = string12;
                string6 = string9;
                n2 = n4;
            }
        } else if (((Tracking.Event)object).type.equals("NIMBLESTANDARD::REFERRER_ID_RECEIVED")) {
            string8 = ((Tracking.Event)object).parameters.get("NIMBLESTANDARD::KEY_REFERRER_ID");
            if (string8 == null) {
                Log.Helper.LOGE(this, "Error: invalid (null) referrer id.", new Object[0]);
                return null;
            }
            n2 = 106;
            string6 = "Referrer";
            string7 = "referrerId";
            string2 = string9;
            string3 = string11;
            string4 = string10;
            string5 = string12;
        } else if (((Tracking.Event)object).type.equals("NIMBLESTANDARD::TUTORIAL_COMPLETE")) {
            n2 = 107;
            string6 = "TutorialComplete";
            string2 = string9;
            string3 = string11;
            string4 = string10;
            string5 = string12;
        } else if (((Tracking.Event)object).type.equals("NIMBLESTANDARD::LEVEL_UP")) {
            n2 = 108;
            string6 = "LevelUp";
            string7 = "duration";
            string8 = ((Tracking.Event)object).parameters.get("NIMBLESTANDARD::KEY_DURATION");
            string2 = "gameplayDuration";
            string4 = ((Tracking.Event)object).parameters.get("NIMBLESTANDARD::KEY_GAMEPLAY_DURATION");
            string3 = "userLevel";
            string5 = ((Tracking.Event)object).parameters.get("NIMBLESTANDARD::KEY_USER_LEVEL");
        } else {
            if (!((Tracking.Event)object).type.equals("SYNERGYS2S::CUSTOM")) return null;
            n2 = Integer.parseInt(((Tracking.Event)object).parameters.get("eventType"));
            string7 = ((Tracking.Event)object).parameters.get("keyType01");
            string8 = ((Tracking.Event)object).parameters.get("keyValue01");
            string2 = ((Tracking.Event)object).parameters.get("keyType02");
            string4 = ((Tracking.Event)object).parameters.get("keyValue02");
            string3 = ((Tracking.Event)object).parameters.get("keyType03");
            string5 = ((Tracking.Event)object).parameters.get("keyValue03");
        }
        hashMap.put("eventType", String.valueOf(n2));
        hashMap.put("eventName", string6);
        hashMap.put("timestamp", Utility.getUTCDateStringFormat(((Tracking.Event)object).timestamp));
        object = string7 == null ? "0" : string7;
        hashMap.put("eventKeyType01", object);
        object = string8 == null ? "" : string8;
        hashMap.put("eventValue01", object);
        object = string2 == null ? "0" : string2;
        hashMap.put("eventKeyType02", object);
        object = string4 == null ? "" : string4;
        hashMap.put("eventValue02", object);
        object = string3 == null ? "0" : string3;
        hashMap.put("eventKeyType03", object);
        object = string5 == null ? "" : string5;
        hashMap.put("eventValue03", object);
        hashMap.put("transactionId", UUID.randomUUID().toString());
        if (n2 == 101 || n2 == 102 || n2 == 103) {
            if (this.m_currentSessionObject.sessionData.size() > 0) {
                this.queueCurrentEventsForPost();
            }
            Log.Helper.LOGD(this, "Logging session start event. Posting event queue now.", new Object[0]);
            this.resetPostTimer(0.0);
        }
        object = new ArrayList<Map<String, String>>();
        object.add(hashMap);
        return object;
    }

    @Override
    protected SynergyRequest createPostRequest(TrackingBaseSessionObject serializable) {
        Object object;
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("apiVer", "1.0.0");
        String string2 = SynergyEnvironment.getComponent().getServerUrlWithKey("synergy.s2s");
        if (string2 == null) {
            Log.Helper.LOGI(this, "Tracking server URL from NimbleEnvironment is nil. Adding observer for environment update finish.", new Object[0]);
            super.addObserverForSynergyEnvironmentUpdateFinished();
            return null;
        }
        serializable = new HashMap<String, Object>(((TrackingBaseSessionObject)serializable).sessionData);
        serializable.put("now_timestamp", Utility.getUTCDateStringFormat(new Date()));
        if (serializable.get("synergyId") == null || serializable.get("synergyId").toString().length() == 0) {
            object = SynergyIdManager.getComponent().getSynergyId();
            if (Utility.validString((String)object)) {
                Log.Helper.LOGV(this, "Creating post request. No synergyId in session info dictionary, inserting synergyId value %s now.", object);
                serializable.put("synergyId", object);
            } else {
                Log.Helper.LOGV(this, "Creating post request. No synergyId in session info dictionary, still no synergyId available now.", new Object[0]);
            }
        }
        object = new SynergyRequest(SYNERGY_API_POST_EVENTS, IHttpRequest.Method.POST, null);
        ((SynergyRequest)object).baseUrl = string2;
        ((SynergyRequest)object).urlParameters = hashMap;
        ((SynergyRequest)object).jsonData = serializable;
        return object;
    }

    @Override
    public String getComponentId() {
        return "com.ea.nimble.trackingimpl.s2s";
    }

    @Override
    public String getLogSourceTitle() {
        return "TrackingS2S";
    }

    @Override
    protected String getPersistenceIdentifier() {
        return "S2S";
    }

    /*
     * Unable to fully structure code
     */
    public double getRetryTime(SynergyNetworkConnectionHandle var1_1) {
        block10: {
            block9: {
                var4_3 = 1.0;
                var8_5 = var9_4 = -1;
                if (var1_1 == null) ** GOTO lbl18
                var8_5 = var9_4;
                var2_6 = var4_3;
                try {
                    if (var1_1.getResponse() != null) {
                        var2_6 = var4_3;
                        var1_1 = var1_1.getResponse().getJsonData();
                        var8_5 = var9_4;
                        if (var1_1 != null) {
                            var2_6 = var4_3;
                            var1_1 = new JSONObject((Map)var1_1).getString("resultCode");
                            var2_6 = var4_3;
                            Log.Helper.LOGD(this, "getMessage result code " + (String)var1_1 + "~", new Object[0]);
                            var2_6 = var4_3;
                            var8_5 = Integer.parseInt((String)var1_1);
                        }
                    }
lbl18:
                    // 6 sources

                    if (var8_5 <= -21000 && var8_5 >= -22000) {
                        var2_6 = var4_3;
                        if (this.m_postRetryDelay < 60.0) {
                            var2_6 = var4_3;
                            this.m_postRetryDelay = 60.0;
                        }
                        var2_6 = var4_3;
                        var2_6 = var6_7 = this.m_postRetryDelay;
                        this.m_postRetryDelay *= 10.0;
                        var4_3 = var6_7;
                        var2_6 = var6_7;
                        if (this.m_postRetryDelay > 86400.0) {
                            var2_6 = var6_7;
                            this.m_postRetryDelay = 86400.0;
                            var4_3 = var6_7;
                        }
                        break block9;
                    }
                    var2_6 = var4_3;
                    break block10;
                }
                catch (JSONException var1_2) {
                    Log.Helper.LOGD(this, "Failed to parse result code in TrackingS2S retransmission check. Defaulting to retryTime of:" + var2_6, new Object[0]);
                    return var2_6;
                }
            }
lbl39:
            // 3 sources

            while (true) {
                var2_6 = var4_3;
                Log.Helper.LOGD(this, "S2S retry delay result code is:" + var8_5 + ". Delay will be:" + var4_3, new Object[0]);
                return var4_3;
            }
        }
        var2_6 = var6_8 = this.m_postRetryDelay;
        this.m_postRetryDelay *= 2.0;
        var4_3 = var6_8;
        var2_6 = var6_8;
        if (!(this.m_postRetryDelay > 300.0)) ** GOTO lbl39
        var2_6 = var6_8;
        this.m_postRetryDelay = 300.0;
        var4_3 = var6_8;
        ** while (true)
    }

    @Override
    protected void packageCurrentSession() {
        if (this.m_currentSessionObject.countOfEvents() <= 0) return;
        this.m_currentSessionObject.sessionData = new HashMap<String, Object>(this.createEventRequestPostMap());
        if (((ArrayList)this.m_currentSessionObject.sessionData.get("adEvents")).isEmpty()) return;
        this.queueCurrentEventsForPost();
    }

    public boolean shouldAttemptReTrans(SynergyNetworkConnectionHandle object) {
        boolean bl2;
        block6: {
            boolean bl3 = true;
            if (object == null || object.getResponse() == null) {
                Log.Helper.LOGF(this, "S2S retrans had no network handle response. Network probably failed to connect. \nWe should attempt retrans.", new Object[0]);
                return true;
            }
            int n2 = -1;
            try {
                object = object.getResponse().getJsonData();
                if (object != null) {
                    object = new JSONObject((Map)object).getString("resultCode");
                    Log.Helper.LOGV(this, "getMessage result code " + (String)object + "~", new Object[0]);
                    n2 = Integer.parseInt((String)object);
                }
                if (n2 <= -20000) {
                    bl2 = bl3;
                    if (n2 >= -21000) break block6;
                    bl2 = bl3;
                    if (n2 <= -22000) break block6;
                }
                bl2 = false;
            }
            catch (JSONException jSONException) {
                Log.Helper.LOGD(this, "Failed to parse result code in TrackingS2S retransmission check. Defaulting to NO.", new Object[0]);
                bl2 = false;
            }
        }
        Log.Helper.LOGV(this, "S2S retransmission is: " + bl2, new Object[0]);
        return bl2;
    }
}

