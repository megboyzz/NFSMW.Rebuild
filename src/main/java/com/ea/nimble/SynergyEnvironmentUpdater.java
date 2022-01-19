/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  android.preference.PreferenceManager
 *  android.provider.Settings$Secure
 *  android.telephony.TelephonyManager
 */
package com.ea.nimble;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.ea.nimble.ApplicationEnvironment;
import com.ea.nimble.Base;
import com.ea.nimble.BaseCore;
import com.ea.nimble.EASPDataLoader;
import com.ea.nimble.EnvironmentDataContainer;
import com.ea.nimble.Error;
import com.ea.nimble.Log;
import com.ea.nimble.LogSource;
import com.ea.nimble.Network;
import com.ea.nimble.SynergyIdManager;
import com.ea.nimble.SynergyNetwork;
import com.ea.nimble.SynergyNetworkConnectionCallback;
import com.ea.nimble.SynergyNetworkConnectionHandle;
import com.ea.nimble.SynergyServerError;
import com.ea.nimble.Utility;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SynergyEnvironmentUpdater
implements LogSource {
    private static final int GET_ANONUID_MAX_RETRY_ATTEMPTS = 3;
    private static final int GET_DIRECTION_MAX_RETRY_ATTEMPTS = 3;
    private static final int GET_EADEVICEID_MAX_RETRY_ATTEMPTS = 3;
    private static final int SYNERGY_DIRECTOR_RESPONSE_ERROR_CODE_SERVERS_FULL = -70002;
    private static final int SYNERGY_USER_VALIDATE_EADEVICEID_RESPONSE_ERROR_CODE_CLEAR_CLIENT_CACHED_EADEVICEID = -20094;
    private static final int SYNERGY_USER_VALIDATE_EADEVICEID_RESPONSE_ERROR_CODE_VALIDATION_FAILED = -20093;
    private static final int VALIDATE_EADEVICEID_MAX_RETRY_ATTEMPTS = 3;
    private CompletionCallback m_completionCallback;
    private BaseCore m_core;
    private EnvironmentDataContainer m_environmentForSynergyStartUp;
    private long m_getAnonUIDRetryCount;
    private long m_getDirectionRetryCount;
    private long m_getEADeviceIDRetryCount;
    private EnvironmentDataContainer m_previousValidEnvironmentData;
    private SynergyNetworkConnectionHandle m_synergyNetworkConnectionHandle;
    private long m_validateEADeviceIDRetryCount;

    SynergyEnvironmentUpdater(BaseCore baseCore) {
        this.m_core = baseCore;
        this.m_environmentForSynergyStartUp = new EnvironmentDataContainer();
        this.m_completionCallback = null;
        this.m_previousValidEnvironmentData = null;
        this.m_synergyNetworkConnectionHandle = null;
        this.m_validateEADeviceIDRetryCount = 0L;
        this.m_getEADeviceIDRetryCount = 0L;
    }

    static /* synthetic */ SynergyNetworkConnectionHandle access$002(SynergyEnvironmentUpdater synergyEnvironmentUpdater, SynergyNetworkConnectionHandle synergyNetworkConnectionHandle) {
        synergyEnvironmentUpdater.m_synergyNetworkConnectionHandle = synergyNetworkConnectionHandle;
        return synergyNetworkConnectionHandle;
    }

    static /* synthetic */ long access$1002(SynergyEnvironmentUpdater synergyEnvironmentUpdater, long l2) {
        synergyEnvironmentUpdater.m_getEADeviceIDRetryCount = l2;
        return l2;
    }

    static /* synthetic */ long access$1008(SynergyEnvironmentUpdater synergyEnvironmentUpdater) {
        long l2 = synergyEnvironmentUpdater.m_getEADeviceIDRetryCount;
        synergyEnvironmentUpdater.m_getEADeviceIDRetryCount = 1L + l2;
        return l2;
    }

    static /* synthetic */ long access$1102(SynergyEnvironmentUpdater synergyEnvironmentUpdater, long l2) {
        synergyEnvironmentUpdater.m_validateEADeviceIDRetryCount = l2;
        return l2;
    }

    static /* synthetic */ long access$1108(SynergyEnvironmentUpdater synergyEnvironmentUpdater) {
        long l2 = synergyEnvironmentUpdater.m_validateEADeviceIDRetryCount;
        synergyEnvironmentUpdater.m_validateEADeviceIDRetryCount = 1L + l2;
        return l2;
    }

    static /* synthetic */ long access$1202(SynergyEnvironmentUpdater synergyEnvironmentUpdater, long l2) {
        synergyEnvironmentUpdater.m_getAnonUIDRetryCount = l2;
        return l2;
    }

    static /* synthetic */ long access$1208(SynergyEnvironmentUpdater synergyEnvironmentUpdater) {
        long l2 = synergyEnvironmentUpdater.m_getAnonUIDRetryCount;
        synergyEnvironmentUpdater.m_getAnonUIDRetryCount = 1L + l2;
        return l2;
    }

    static /* synthetic */ long access$702(SynergyEnvironmentUpdater synergyEnvironmentUpdater, long l2) {
        synergyEnvironmentUpdater.m_getDirectionRetryCount = l2;
        return l2;
    }

    static /* synthetic */ long access$708(SynergyEnvironmentUpdater synergyEnvironmentUpdater) {
        long l2 = synergyEnvironmentUpdater.m_getDirectionRetryCount;
        synergyEnvironmentUpdater.m_getDirectionRetryCount = 1L + l2;
        return l2;
    }

    private void callSynergyGetAnonUid() {
        Object object = SynergyIdManager.getComponent().getAnonymousSynergyId();
        if (object != null) {
            Log.Helper.LOGD(this, "Not getting anonymous ID from Synergy since it was loaded from persistence", new Object[0]);
            this.m_environmentForSynergyStartUp.setSynergyAnonymousId((String)object);
            this.onStartUpSequenceFinished(null);
            return;
        }
        object = new HashMap();
        object.put("apiVer", "1.0.0");
        object.put("updatePriority", "false");
        object.put("hwId", this.m_environmentForSynergyStartUp.getEAHardwareId());
        if (Utility.validString(this.m_environmentForSynergyStartUp.getEADeviceId())) {
            object.put("eadeviceid", this.m_environmentForSynergyStartUp.getEADeviceId());
            this.m_synergyNetworkConnectionHandle = SynergyNetwork.getComponent().sendGetRequest(this.m_environmentForSynergyStartUp.getServerUrlWithKey("synergy.user"), "/user/api/android/getAnonUid", (Map<String, String>)object, new SynergyNetworkConnectionCallback(){

                @Override
                public void callback(SynergyNetworkConnectionHandle synergyNetworkConnectionHandle) {
                    SynergyEnvironmentUpdater.access$002(SynergyEnvironmentUpdater.this, null);
                    Exception exception = synergyNetworkConnectionHandle.getResponse().getError();
                    if (exception == null) {
                        Log.Helper.LOGD(this, "GETANON Success", new Object[0]);
                        SynergyEnvironmentUpdater.this.m_environmentForSynergyStartUp.setSynergyAnonymousId(synergyNetworkConnectionHandle.getResponse().getJsonData().get("uid").toString());
                        SynergyEnvironmentUpdater.this.onStartUpSequenceFinished(null);
                        return;
                    }
                    if (!SynergyEnvironmentUpdater.this.isTimeoutError(exception) && SynergyEnvironmentUpdater.this.m_getAnonUIDRetryCount < 3L) {
                        SynergyEnvironmentUpdater.access$1208(SynergyEnvironmentUpdater.this);
                        Log.Helper.LOGD(this, "GetAnonUid, call failed. Making retry attempt number %d.", SynergyEnvironmentUpdater.this.m_getAnonUIDRetryCount);
                        SynergyEnvironmentUpdater.this.callSynergyGetAnonUid();
                        return;
                    }
                    SynergyEnvironmentUpdater.access$1202(SynergyEnvironmentUpdater.this, 0L);
                    Log.Helper.LOGD(this, "GETANON Error, (%s)", synergyNetworkConnectionHandle.getResponse().getError().toString());
                    SynergyEnvironmentUpdater.this.onStartUpSequenceFinished(new Error(Error.Code.SYNERGY_GET_ANONYMOUS_ID_FAILURE, "Synergy \"get anonymous id\" call failed.", exception));
                }
            });
            return;
        }
        Log.Helper.LOGE(this, "getAnonUid got an invalid EA Device ID.", new Object[0]);
        this.onStartUpSequenceFinished(new Error(Error.Code.INVALID_ARGUMENT, "EA Device ID is invalid"));
    }

    private void callSynergyGetDirection() {
        String string2 = ApplicationEnvironment.getComponent().getApplicationBundleId();
        String string3 = ApplicationEnvironment.getComponent().getDeviceString();
        String string4 = ApplicationEnvironment.getComponent().getDeviceCodename();
        String string5 = ApplicationEnvironment.getComponent().getDeviceManufacturer();
        String string6 = ApplicationEnvironment.getComponent().getDeviceModel();
        String string7 = ApplicationEnvironment.getComponent().getDeviceBrand();
        String string8 = ApplicationEnvironment.getComponent().getDeviceFingerprint();
        if (!Utility.validString(string2)) {
            Log.Helper.LOGE(this, "GETDIRECTION bundleId is invalid", new Object[0]);
            this.onStartUpSequenceFinished(new Error(Error.Code.INVALID_ARGUMENT, "bundleId is invalid"));
            return;
        }
        if (!Utility.validString(string3)) {
            Log.Helper.LOGE(this, "GETDIRECTION deviceString is invalid", new Object[0]);
            this.onStartUpSequenceFinished(new Error(Error.Code.INVALID_ARGUMENT, "deviceString is invalid"));
            return;
        }
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("packageId", string2);
        hashMap.put("deviceString", string3);
        hashMap.put("deviceCodename", string4);
        hashMap.put("manufacturer", string5);
        hashMap.put("model", string6);
        hashMap.put("brand", string7);
        hashMap.put("fingerprint", string8);
        hashMap.put("serverEnvironment", this.getSynergyServerEnvironmentName());
        hashMap.put("sdkVersion", "1.23.14.1217");
        hashMap.put("apiVer", "1.0.0");
        this.m_synergyNetworkConnectionHandle = SynergyNetwork.getComponent().sendGetRequest(this.m_environmentForSynergyStartUp.getSynergyDirectorServerUrl(Base.getConfiguration()), "/director/api/android/getDirectionByPackage", hashMap, new SynergyNetworkConnectionCallback(){

            @Override
            public void callback(SynergyNetworkConnectionHandle object) {
                Log.Helper.LOGD(this, "GETDIRECTION FINISHED", new Object[0]);
                SynergyEnvironmentUpdater.access$002(SynergyEnvironmentUpdater.this, null);
                Object object2 = object.getResponse().getError();
                if (object2 == null) {
                    SynergyEnvironmentUpdater.this.m_environmentForSynergyStartUp.setMostRecentDirectorResponseTimestamp(System.currentTimeMillis());
                    SynergyEnvironmentUpdater.this.m_environmentForSynergyStartUp.setGetDirectionResponseDictionary(object.getResponse().getJsonData());
                    object = (List)SynergyEnvironmentUpdater.this.m_environmentForSynergyStartUp.getGetDirectionResponseDictionary().get("serverData");
                    SynergyEnvironmentUpdater.this.m_environmentForSynergyStartUp.setServerUrls(new HashMap<String, String>());
                    if (object != null) {
                        object = object.iterator();
                        while (object.hasNext()) {
                            object2 = (Map)object.next();
                            SynergyEnvironmentUpdater.this.m_environmentForSynergyStartUp.getServerUrls().put((String)object2.get("key"), (String)object2.get("value"));
                        }
                    }
                    if (SynergyEnvironmentUpdater.this.m_environmentForSynergyStartUp.getServerUrls().size() == 0) {
                        SynergyEnvironmentUpdater.this.onStartUpSequenceFinished(new Error(Error.Code.NOT_AVAILABLE, "No Synergy server URLs available."));
                        return;
                    }
                    if (SynergyEnvironmentUpdater.this.m_previousValidEnvironmentData != null && Utility.validString(SynergyEnvironmentUpdater.this.m_previousValidEnvironmentData.getEADeviceId())) {
                        SynergyEnvironmentUpdater.this.callSynergyValidateEADeviceId(SynergyEnvironmentUpdater.this.m_previousValidEnvironmentData.getEADeviceId());
                        return;
                    }
                    object = EASPDataLoader.loadEADeviceId();
                    if (object != null) {
                        SynergyEnvironmentUpdater.this.callSynergyValidateEADeviceId((String)object);
                        return;
                    }
                    SynergyEnvironmentUpdater.this.callSynergyGetEADeviceId();
                    return;
                }
                if (object2 instanceof SynergyServerError) {
                    if (!((SynergyServerError)object2).isError(-70002)) return;
                    SynergyEnvironmentUpdater.this.onStartUpSequenceFinished(new Error(Error.Code.SYNERGY_SERVER_FULL, "Synergy ServerUnavailable signal received.", (Throwable)object2));
                    return;
                }
                boolean bl2 = SynergyEnvironmentUpdater.this.isTimeoutError((Exception)object2);
                if (!bl2 && SynergyEnvironmentUpdater.this.m_getDirectionRetryCount < 3L) {
                    SynergyEnvironmentUpdater.access$708(SynergyEnvironmentUpdater.this);
                    Log.Helper.LOGD(this, "GetDirection, call failed. Making retry attempt number %d.", SynergyEnvironmentUpdater.this.m_getDirectionRetryCount);
                    SynergyEnvironmentUpdater.this.callSynergyGetDirection();
                    return;
                }
                SynergyEnvironmentUpdater.access$702(SynergyEnvironmentUpdater.this, 0L);
                if (bl2) {
                    SynergyEnvironmentUpdater.this.onStartUpSequenceFinished(new Error(Error.Code.SYNERGY_GET_DIRECTION_TIMEOUT, "Synergy /getDirectionByPackage request timed out.", (Throwable)object2));
                    return;
                }
                SynergyEnvironmentUpdater.this.onStartUpSequenceFinished((Exception)object2);
            }
        });
    }

    private void callSynergyGetEADeviceId() {
        Object object = this.m_environmentForSynergyStartUp;
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("apiVer", "1.0.0");
        hashMap.put("hwId", object.getEAHardwareId());
        object = ApplicationEnvironment.getComponent().getMACAddress();
        if (Utility.validString((String)object) && (object = Utility.SHA256HashString((String)object)) != null) {
            hashMap.put("macHash", (String)object);
        }
        Object object2 = ApplicationEnvironment.getComponent();
        object = null;
        if (object2 != null) {
            object = object2.getApplicationContext();
        }
        if (object != null && (object2 = Settings.Secure.getString((ContentResolver)object2.getApplicationContext().getContentResolver(), (String)"android_id")) != null) {
            hashMap.put("androidId", (String)object2);
        }
        if (object != null) {
            int n2;
            object2 = (TelephonyManager)object.getSystemService("phone");
            PackageManager packageManager = object.getPackageManager();
            if (object2 != null && packageManager.checkPermission("android.permission.READ_PHONE_STATE", object.getPackageName()) == 0 && (n2 = object2.getPhoneType()) != 0 && Utility.validString((String)(object2 = object2.getDeviceId()))) {
                object = "imei";
                if (n2 == 2) {
                    object = "meid";
                }
                hashMap.put((String)object, (String)object2);
            }
        }
        this.m_synergyNetworkConnectionHandle = SynergyNetwork.getComponent().sendGetRequest(this.m_environmentForSynergyStartUp.getServerUrlWithKey("synergy.user"), "/user/api/android/getDeviceID", hashMap, new SynergyNetworkConnectionCallback(){

            @Override
            public void callback(SynergyNetworkConnectionHandle synergyNetworkConnectionHandle) {
                SynergyEnvironmentUpdater.access$002(SynergyEnvironmentUpdater.this, null);
                Exception exception = synergyNetworkConnectionHandle.getResponse().getError();
                if (exception == null) {
                    Log.Helper.LOGD(this, "GetEADeviceID Success", new Object[0]);
                    SynergyEnvironmentUpdater.this.m_environmentForSynergyStartUp.setEADeviceId((String)synergyNetworkConnectionHandle.getResponse().getJsonData().get("deviceId"));
                    SynergyEnvironmentUpdater.this.callSynergyGetAnonUid();
                    return;
                }
                if (!SynergyEnvironmentUpdater.this.isTimeoutError(exception) && SynergyEnvironmentUpdater.this.m_getEADeviceIDRetryCount < 3L) {
                    SynergyEnvironmentUpdater.access$1008(SynergyEnvironmentUpdater.this);
                    Log.Helper.LOGD(this, "GetEADeviceID, call failed. Making retry attempt number %d.", SynergyEnvironmentUpdater.this.m_getEADeviceIDRetryCount);
                    SynergyEnvironmentUpdater.this.callSynergyGetEADeviceId();
                    return;
                }
                SynergyEnvironmentUpdater.access$1002(SynergyEnvironmentUpdater.this, 0L);
                Log.Helper.LOGD(this, "GetEADeviceID Error (%s)", synergyNetworkConnectionHandle.getResponse().getError());
                SynergyEnvironmentUpdater.this.onStartUpSequenceFinished(new Error(Error.Code.SYNERGY_GET_EA_DEVICE_ID_FAILURE, "GetEADevideId call failed", synergyNetworkConnectionHandle.getResponse().getError()));
            }
        });
    }

    private void callSynergyValidateEADeviceId(final String string2) {
        Object object = this.m_environmentForSynergyStartUp;
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("apiVer", "1.0.0");
        hashMap.put("hwId", object.getEAHardwareId());
        hashMap.put("eadeviceid", string2);
        object = ApplicationEnvironment.getComponent().getMACAddress();
        if (Utility.validString((String)object) && (object = Utility.SHA256HashString((String)object)) != null) {
            hashMap.put("macHash", (String)object);
        }
        Object object2 = ApplicationEnvironment.getComponent();
        object = null;
        if (object2 != null) {
            object = object2.getApplicationContext();
        }
        if (object != null && (object2 = Settings.Secure.getString((ContentResolver)object2.getApplicationContext().getContentResolver(), (String)"android_id")) != null) {
            hashMap.put("androidId", (String)object2);
        }
        if (object != null) {
            int n2;
            object2 = (TelephonyManager)object.getSystemService("phone");
            PackageManager packageManager = object.getPackageManager();
            if (object2 != null && packageManager.checkPermission("android.permission.READ_PHONE_STATE", object.getPackageName()) == 0 && (n2 = object2.getPhoneType()) != 0 && Utility.validString((String)(object2 = object2.getDeviceId()))) {
                object = "imei";
                if (n2 == 2) {
                    object = "meid";
                }
                hashMap.put((String)object, (String)object2);
            }
        }
        this.m_synergyNetworkConnectionHandle = SynergyNetwork.getComponent().sendGetRequest(this.m_environmentForSynergyStartUp.getServerUrlWithKey("synergy.user"), "/user/api/android/validateDeviceID", hashMap, new SynergyNetworkConnectionCallback(){

            @Override
            public void callback(SynergyNetworkConnectionHandle object) {
                SynergyEnvironmentUpdater.access$002(SynergyEnvironmentUpdater.this, null);
                Exception exception = object.getResponse().getError();
                if (exception == null) {
                    Log.Helper.LOGD(this, "ValidateEADeviceID Success", new Object[0]);
                    SynergyEnvironmentUpdater.this.m_environmentForSynergyStartUp.setEADeviceId((String)object.getResponse().getJsonData().get("deviceId"));
                    SynergyEnvironmentUpdater.this.callSynergyGetAnonUid();
                    return;
                }
                Log.Helper.LOGD(this, "ValidateEADeviceID Error (%s)", exception);
                if (exception instanceof SynergyServerError) {
                    object = (SynergyServerError)exception;
                    if (((SynergyServerError)object).isError(-20094)) {
                        if (SynergyEnvironmentUpdater.this.m_previousValidEnvironmentData != null) {
                            SynergyEnvironmentUpdater.this.m_previousValidEnvironmentData.setEADeviceId(null);
                        }
                        Log.Helper.LOGD(this, "ValidateEADeviceID, Server signal received to delete cached EA Device ID. Making request to get a new EA Device ID.", new Object[0]);
                        SynergyEnvironmentUpdater.this.callSynergyGetEADeviceId();
                        return;
                    }
                    if (((SynergyServerError)object).isError(-20093)) {
                        Log.Helper.LOGD(this, "ValidateEADeviceID, EADeviceID validation failed. Making request to get a new EA Device ID.", new Object[0]);
                        SynergyEnvironmentUpdater.this.callSynergyGetEADeviceId();
                        return;
                    }
                }
                if (!SynergyEnvironmentUpdater.this.isTimeoutError(exception) && SynergyEnvironmentUpdater.this.m_validateEADeviceIDRetryCount < 3L) {
                    SynergyEnvironmentUpdater.access$1108(SynergyEnvironmentUpdater.this);
                    Log.Helper.LOGD(this, "ValidateEADeviceID, call failed. Making retry attempt number %d.", SynergyEnvironmentUpdater.this.m_validateEADeviceIDRetryCount);
                    SynergyEnvironmentUpdater.this.callSynergyValidateEADeviceId(string2);
                    return;
                }
                SynergyEnvironmentUpdater.access$1102(SynergyEnvironmentUpdater.this, 0L);
                SynergyEnvironmentUpdater.this.onStartUpSequenceFinished(new Error(Error.Code.SYNERGY_GET_EA_DEVICE_ID_FAILURE, "ValidateEADeviceId call failed", exception));
            }
        });
    }

    private String getSynergyServerEnvironmentName() {
        switch (5.$SwitchMap$com$ea$nimble$NimbleConfiguration[this.m_core.getConfiguration().ordinal()]) {
            default: {
                Log.Helper.LOGF(this, "Request for Synergy server environment name with unknown NimbleConfiguration %s", this.m_core.getConfiguration().toString());
                return "live";
            }
            case 1: 
            case 2: 
            case 3: {
                return this.m_core.getConfiguration().toString();
            }
            case 4: 
        }
        return PreferenceManager.getDefaultSharedPreferences((Context)ApplicationEnvironment.getComponent().getApplicationContext()).getString("NimbleCustomizedSynergyServerEnvironmentName", "live");
    }

    private boolean isTimeoutError(Exception exception) {
        if (!(exception instanceof Error)) return false;
        if (!((Error)exception).isError(Error.Code.NETWORK_TIMEOUT)) return false;
        return true;
    }

    private void onStartUpSequenceFinished(Exception exception) {
        if (this.m_completionCallback != null) {
            this.m_completionCallback.callback(exception);
            return;
        }
        Log.Helper.LOGW(this, "Startup sequence finished, but no completion callback set.", new Object[0]);
    }

    public void cancel() {
        SynergyNetworkConnectionHandle synergyNetworkConnectionHandle = this.m_synergyNetworkConnectionHandle;
        if (synergyNetworkConnectionHandle != null) {
            Log.Helper.LOGD(this, "Canceling network connection.", new Object[0]);
            synergyNetworkConnectionHandle.cancel();
            this.m_synergyNetworkConnectionHandle = null;
        }
        this.onStartUpSequenceFinished(new Error(Error.Code.NETWORK_OPERATION_CANCELLED, "Synergy startup sequence canceled."));
    }

    EnvironmentDataContainer getEnvironmentDataContainer() {
        return this.m_environmentForSynergyStartUp;
    }

    @Override
    public String getLogSourceTitle() {
        return "SynergyEnv";
    }

    public void startSynergyStartupSequence(EnvironmentDataContainer environmentDataContainer, CompletionCallback completionCallback) {
        this.m_completionCallback = completionCallback;
        this.m_previousValidEnvironmentData = environmentDataContainer;
        if (Network.getComponent().getStatus() != Network.Status.OK) {
            this.onStartUpSequenceFinished(new Error(Error.Code.NETWORK_NO_CONNECTION, "Device is not connected to Wifi or wireless."));
            return;
        }
        this.callSynergyGetDirection();
    }

    static interface CompletionCallback {
        public void callback(Exception var1);
    }
}

