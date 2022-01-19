/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.preference.PreferenceManager
 */
package com.ea.nimble;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.preference.PreferenceManager;
import com.ea.nimble.ApplicationEnvironment;
import com.ea.nimble.BaseCore;
import com.ea.nimble.Component;
import com.ea.nimble.EASPDataLoader;
import com.ea.nimble.EnvironmentDataContainer;
import com.ea.nimble.Error;
import com.ea.nimble.ISynergyEnvironment;
import com.ea.nimble.Log;
import com.ea.nimble.LogSource;
import com.ea.nimble.Network;
import com.ea.nimble.NimbleConfiguration;
import com.ea.nimble.Persistence;
import com.ea.nimble.PersistenceService;
import com.ea.nimble.SynergyEnvironmentUpdater;
import com.ea.nimble.Utility;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class SynergyEnvironmentImpl
extends Component
implements ISynergyEnvironment,
LogSource {
    private static final String PERSISTENCE_DATA_ID = "environmentData";
    public static final int SYNERGY_APP_VERSION_OK = 0;
    public static final int SYNERGY_APP_VERSION_UPDATE_RECOMMENDED = 1;
    public static final int SYNERGY_APP_VERSION_UPDATE_REQUIRED = 2;
    private static final String SYNERGY_INT_SERVER_URL = "https://director-int.sn.eamobile.com";
    private static final String SYNERGY_LIVE_SERVER_URL = "https://syn-dir.sn.eamobile.com";
    private static final String SYNERGY_STAGE_SERVER_URL = "https://director-stage.sn.eamobile.com";
    public static final double SYNERGY_UPDATE_RATE_LIMIT_PERIOD_IN_SECONDS = 60.0;
    public static final double SYNERGY_UPDATE_REFRESH_PERIOD_IN_SECONDS = 300.0;
    private BaseCore m_core;
    private boolean m_dataLoadedOnComponentSetup;
    private EnvironmentDataContainer m_environmentDataContainer;
    private BroadcastReceiver m_networkStatusChangeReceiver;
    private EnvironmentDataContainer m_previousValidEnvironmentDataContainer;
    private Long m_synergyEnvironmentUpdateRateLimitTriggerTimestamp;
    private SynergyEnvironmentUpdater m_synergyStartupObject;

    SynergyEnvironmentImpl(BaseCore baseCore) {
        this.m_core = baseCore;
        this.m_networkStatusChangeReceiver = null;
        this.m_dataLoadedOnComponentSetup = false;
    }

    static /* synthetic */ BroadcastReceiver access$002(SynergyEnvironmentImpl synergyEnvironmentImpl, BroadcastReceiver broadcastReceiver) {
        synergyEnvironmentImpl.m_networkStatusChangeReceiver = broadcastReceiver;
        return broadcastReceiver;
    }

    static /* synthetic */ SynergyEnvironmentUpdater access$202(SynergyEnvironmentImpl synergyEnvironmentImpl, SynergyEnvironmentUpdater synergyEnvironmentUpdater) {
        synergyEnvironmentImpl.m_synergyStartupObject = synergyEnvironmentUpdater;
        return synergyEnvironmentUpdater;
    }

    static /* synthetic */ EnvironmentDataContainer access$302(SynergyEnvironmentImpl synergyEnvironmentImpl, EnvironmentDataContainer environmentDataContainer) {
        synergyEnvironmentImpl.m_environmentDataContainer = environmentDataContainer;
        return environmentDataContainer;
    }

    private void clearSynergyEnvironmentUpdateRateLimiting() {
        this.m_synergyEnvironmentUpdateRateLimitTriggerTimestamp = null;
    }

    private boolean isInSynergyEnvironmentUpdateRateLimitingPeriod() {
        if (this.m_synergyEnvironmentUpdateRateLimitTriggerTimestamp == null) return false;
        if (!((double)(System.currentTimeMillis() - this.m_synergyEnvironmentUpdateRateLimitTriggerTimestamp) <= 60000.0)) return false;
        return true;
    }

    private boolean restoreEnvironmentDataFromPersistent(boolean bl2) {
        boolean bl3 = true;
        Object object = PersistenceService.getPersistenceForNimbleComponent("com.ea.nimble.synergyEnvironment", Persistence.Storage.CACHE);
        if (object != null) {
            if ((object = ((Persistence)object).getValue(PERSISTENCE_DATA_ID)) == null) {
                Log.Helper.LOGD(this, "Environment persistence data value not found in persistence object. Probably first install.", new Object[0]);
            } else {
                try {
                    this.m_environmentDataContainer = (EnvironmentDataContainer)object;
                    Log.Helper.LOGD(this, "Restored environment data from persistent. Restored data timestamp, %s", this.m_environmentDataContainer.getMostRecentDirectorResponseTimestamp());
                    if (this.m_environmentDataContainer.getEADeviceId() == null) {
                        this.m_environmentDataContainer.setEADeviceId(EASPDataLoader.loadEADeviceId());
                    }
                    if (bl2) return bl3;
                    Utility.sendBroadcast("nimble.environment.notification.restored_from_persistent", null);
                    return true;
                }
                catch (ClassCastException classCastException) {
                    Log.Helper.LOGE(this, "Environment persistence data value is not the expected type.", new Object[0]);
                }
            }
        } else {
            Log.Helper.LOGE(this, "Could not get environment persistence object to restore from", new Object[0]);
        }
        this.m_environmentDataContainer = null;
        return false;
    }

    private void saveEnvironmentDataToPersistent() {
        Persistence persistence = PersistenceService.getPersistenceForNimbleComponent("com.ea.nimble.synergyEnvironment", Persistence.Storage.CACHE);
        if (persistence != null) {
            Log.Helper.LOGD(this, "Saving environment data to persistent.", new Object[0]);
            persistence.setValue(PERSISTENCE_DATA_ID, this.m_environmentDataContainer);
            persistence.synchronize();
            return;
        }
        Log.Helper.LOGE(this, "Could not get environment persistence object to save to.", new Object[0]);
    }

    private void startSynergyEnvironmentUpdate() {
        if (this.isUpdateInProgress()) {
            Log.Helper.LOGD(this, "Attempt made to start Synergy environment update while a previous one is active. Exiting.", new Object[0]);
            return;
        }
        if (Network.getComponent().getStatus() != Network.Status.OK) {
            if (this.m_networkStatusChangeReceiver != null) return;
            this.m_networkStatusChangeReceiver = new BroadcastReceiver(){

                public void onReceive(Context context, Intent intent) {
                    if (!intent.getAction().equals("nimble.notification.networkStatusChanged")) return;
                    if (Network.getComponent().getStatus() != Network.Status.OK) return;
                    Log.Helper.LOGD((Object)this, "Network restored. Starting Synergy environment update.", new Object[0]);
                    Utility.unregisterReceiver(SynergyEnvironmentImpl.this.m_networkStatusChangeReceiver);
                    SynergyEnvironmentImpl.access$002(SynergyEnvironmentImpl.this, null);
                    SynergyEnvironmentImpl.this.startSynergyEnvironmentUpdate();
                }
            };
            Log.Helper.LOGD(this, "Network not available to perform environment update. Setting receiver to listen for network status change.", new Object[0]);
            Utility.registerReceiver("nimble.notification.networkStatusChanged", this.m_networkStatusChangeReceiver);
            return;
        }
        this.m_synergyStartupObject = new SynergyEnvironmentUpdater(this.m_core);
        this.m_previousValidEnvironmentDataContainer = this.m_environmentDataContainer;
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("result", "1");
        Utility.sendBroadcast("nimble.environment.notification.startup_requests_started", hashMap);
        this.m_synergyStartupObject.startSynergyStartupSequence(this.m_previousValidEnvironmentDataContainer, new SynergyEnvironmentUpdater.CompletionCallback(){

            @Override
            public void callback(Exception serializable) {
                if (serializable == null) {
                    if (SynergyEnvironmentImpl.this.m_synergyStartupObject != null && SynergyEnvironmentImpl.this.m_synergyStartupObject.getEnvironmentDataContainer() != null) {
                        SynergyEnvironmentImpl.access$302(SynergyEnvironmentImpl.this, SynergyEnvironmentImpl.this.m_synergyStartupObject.getEnvironmentDataContainer());
                        SynergyEnvironmentImpl.this.saveEnvironmentDataToPersistent();
                        if (SynergyEnvironmentImpl.this.m_environmentDataContainer.getKeysOfDifferences(SynergyEnvironmentImpl.this.m_previousValidEnvironmentDataContainer) != null) {
                            Utility.sendBroadcast("nimble.environment.notification.startup_environment_data_changed", null);
                        }
                        serializable = new HashMap();
                        serializable.put("result", "1");
                        if (ApplicationEnvironment.isMainApplicationRunning() && ApplicationEnvironment.getCurrentActivity() != null) {
                            Log.Helper.LOGD(this, "App is running in forground, send the NOTIFICATION_STARTUP_REQUESTS_FINISHED notification", new Object[0]);
                            Utility.sendBroadcast("nimble.environment.notification.startup_requests_finished", (Map<String, String>)((Object)serializable));
                        } else {
                            Log.Helper.LOGI(this, "App is not running in forground, discard the NOTIFICATION_STARTUP_REQUESTS_FINISHED notification", new Object[0]);
                        }
                    } else {
                        Log.Helper.LOGD(this, "Synergy Environment Update object or dataContainer null at callback. More than one update was being peroformed", new Object[0]);
                    }
                } else {
                    Serializable serializable2;
                    Log.Helper.LOGE(this, "StartupError(%s)", serializable);
                    if (serializable instanceof Error) {
                        serializable2 = (Error)serializable;
                        if (((Error)serializable2).isError(Error.Code.SYNERGY_GET_DIRECTION_TIMEOUT) || ((Error)serializable2).isError(Error.Code.SYNERGY_SERVER_FULL)) {
                            Log.Helper.LOGD(this, "GetDirection request timed out or ServerUnavailable signal received. Start rate limiting of /getDirection call.", new Object[0]);
                            SynergyEnvironmentImpl.this.startSynergyEnvironmentUpdateRateLimiting();
                        }
                    } else if (SynergyEnvironmentImpl.this.m_synergyStartupObject == null || SynergyEnvironmentImpl.this.m_synergyStartupObject.getEnvironmentDataContainer() == null) {
                        Log.Helper.LOGD(this, "Synergy Environment Update object or dataContainer null at callback. More than one update was being peroformed", new Object[0]);
                    }
                    serializable2 = new HashMap();
                    serializable2.put("result", "0");
                    serializable2.put("error", ((Throwable)serializable).toString());
                    if (ApplicationEnvironment.isMainApplicationRunning() && ApplicationEnvironment.getCurrentActivity() != null) {
                        Log.Helper.LOGD(this, "App is running in forground, send the NOTIFICATION_STARTUP_REQUESTS_FINISHED notification", new Object[0]);
                        Utility.sendBroadcast("nimble.environment.notification.startup_requests_finished", (Map<String, String>)((Object)serializable2));
                    } else {
                        Log.Helper.LOGI(this, "App is not running in forground, discard the NOTIFICATION_STARTUP_REQUESTS_FINISHED notification", new Object[0]);
                    }
                }
                SynergyEnvironmentImpl.access$202(SynergyEnvironmentImpl.this, null);
            }
        });
    }

    private void startSynergyEnvironmentUpdateRateLimiting() {
        this.m_synergyEnvironmentUpdateRateLimitTriggerTimestamp = System.currentTimeMillis();
    }

    @Override
    public Error checkAndInitiateSynergyEnvironmentUpdate() {
        if (this.isUpdateInProgress()) {
            return new Error(Error.Code.SYNERGY_ENVIRONMENT_UPDATE_FAILURE, "Update in progress.");
        }
        if (this.m_environmentDataContainer != null && this.m_environmentDataContainer.getMostRecentDirectorResponseTimestamp() != null) {
            return new Error(Error.Code.SYNERGY_ENVIRONMENT_UPDATE_FAILURE, "Environment data already cached.");
        }
        if (this.isInSynergyEnvironmentUpdateRateLimitingPeriod()) {
            Log.Helper.LOGD(this, "Attempt to re-initiate Synergy environment update blocked by rate limiting. %.2f seconds of rate limiting left", 60.0 - (double)(System.currentTimeMillis() - this.m_synergyEnvironmentUpdateRateLimitTriggerTimestamp) / 1000.0);
            return new Error(Error.Code.SYNERGY_ENVIRONMENT_UPDATE_FAILURE, "Synergy environment update rate limit in effect.");
        }
        this.startSynergyEnvironmentUpdate();
        return null;
    }

    @Override
    public void cleanup() {
        Log.Helper.LOGD(this, "cleanup", new Object[0]);
        if (this.m_synergyStartupObject != null) {
            this.m_synergyStartupObject.cancel();
            this.m_synergyStartupObject = null;
        }
        if (this.m_networkStatusChangeReceiver != null) {
            Utility.unregisterReceiver(this.m_networkStatusChangeReceiver);
            this.m_networkStatusChangeReceiver = null;
        }
        this.saveEnvironmentDataToPersistent();
        this.m_environmentDataContainer = null;
    }

    @Override
    public String getComponentId() {
        return "com.ea.nimble.synergyEnvironment";
    }

    @Override
    public String getEADeviceId() {
        this.checkAndInitiateSynergyEnvironmentUpdate();
        if (this.m_environmentDataContainer != null) return this.m_environmentDataContainer.getEADeviceId();
        return null;
    }

    @Override
    public String getEAHardwareId() {
        this.checkAndInitiateSynergyEnvironmentUpdate();
        if (this.m_environmentDataContainer != null) return this.m_environmentDataContainer.getEAHardwareId();
        return null;
    }

    @Override
    public String getGosMdmAppKey() {
        this.checkAndInitiateSynergyEnvironmentUpdate();
        if (this.m_environmentDataContainer != null) return this.m_environmentDataContainer.getGosMdmAppKey();
        return null;
    }

    @Override
    public int getLatestAppVersionCheckResult() {
        if (this.m_environmentDataContainer != null) return this.m_environmentDataContainer.getLatestAppVersionCheckResult();
        return 0;
    }

    @Override
    public String getLogSourceTitle() {
        return "SynergyEnv";
    }

    @Override
    public String getNexusClientId() {
        this.checkAndInitiateSynergyEnvironmentUpdate();
        if (this.m_environmentDataContainer != null) return this.m_environmentDataContainer.getNexusClientId();
        return null;
    }

    @Override
    public String getNexusClientSecret() {
        this.checkAndInitiateSynergyEnvironmentUpdate();
        if (this.m_environmentDataContainer != null) return this.m_environmentDataContainer.getNexusClientSecret();
        return null;
    }

    @Override
    public String getProductId() {
        this.checkAndInitiateSynergyEnvironmentUpdate();
        if (this.m_environmentDataContainer != null) return this.m_environmentDataContainer.getProductId();
        return null;
    }

    @Override
    public String getSellId() {
        this.checkAndInitiateSynergyEnvironmentUpdate();
        if (this.m_environmentDataContainer != null) return this.m_environmentDataContainer.getSellId();
        return null;
    }

    @Override
    public String getServerUrlWithKey(String string2) {
        this.checkAndInitiateSynergyEnvironmentUpdate();
        if (this.m_environmentDataContainer != null) return this.m_environmentDataContainer.getServerUrlWithKey(string2);
        return null;
    }

    @Override
    public String getSynergyDirectorServerUrl(NimbleConfiguration nimbleConfiguration) {
        switch (3.$SwitchMap$com$ea$nimble$NimbleConfiguration[nimbleConfiguration.ordinal()]) {
            default: {
                Log.Helper.LOGF(this, "Request for Synergy Director server URL with unknown NimbleConfiguration, %d.", new Object[]{nimbleConfiguration});
                return SYNERGY_LIVE_SERVER_URL;
            }
            case 1: {
                return SYNERGY_INT_SERVER_URL;
            }
            case 2: {
                return SYNERGY_STAGE_SERVER_URL;
            }
            case 3: {
                return SYNERGY_LIVE_SERVER_URL;
            }
            case 4: 
        }
        return PreferenceManager.getDefaultSharedPreferences((Context)ApplicationEnvironment.getComponent().getApplicationContext()).getString("NimbleCustomizedSynergyServerEndpointUrl", SYNERGY_LIVE_SERVER_URL);
    }

    @Override
    public String getSynergyId() {
        this.checkAndInitiateSynergyEnvironmentUpdate();
        if (this.m_environmentDataContainer != null) return this.m_environmentDataContainer.getSynergyId();
        return null;
    }

    @Override
    public int getTrackingPostInterval() {
        if (this.m_environmentDataContainer != null) return this.m_environmentDataContainer.getTrackingPostInterval();
        return -1;
    }

    @Override
    public boolean isDataAvailable() {
        if (this.m_environmentDataContainer == null) return false;
        return true;
    }

    @Override
    public boolean isUpdateInProgress() {
        if (this.m_synergyStartupObject == null) return false;
        return true;
    }

    @Override
    public void restore() {
        Log.Helper.LOGD(this, "restore", new Object[0]);
        if (this.m_dataLoadedOnComponentSetup) {
            this.m_dataLoadedOnComponentSetup = false;
            Utility.sendBroadcast("nimble.environment.notification.restored_from_persistent", null);
        } else {
            this.restoreEnvironmentDataFromPersistent(false);
        }
        if (this.m_environmentDataContainer != null && this.m_environmentDataContainer.getMostRecentDirectorResponseTimestamp() != null && !((double)(System.currentTimeMillis() - this.m_environmentDataContainer.getMostRecentDirectorResponseTimestamp()) / 1000.0 > 300.0)) {
            this.checkAndInitiateSynergyEnvironmentUpdate();
            return;
        }
        this.startSynergyEnvironmentUpdate();
    }

    @Override
    public void resume() {
        Log.Helper.LOGD(this, "resume", new Object[0]);
        this.clearSynergyEnvironmentUpdateRateLimiting();
        if (this.m_environmentDataContainer != null && this.m_environmentDataContainer.getMostRecentDirectorResponseTimestamp() != null) {
            if (!((double)(System.currentTimeMillis() - this.m_environmentDataContainer.getMostRecentDirectorResponseTimestamp()) / 1000.0 > 300.0)) return;
        }
        this.startSynergyEnvironmentUpdate();
    }

    @Override
    public void setup() {
        Log.Helper.LOGD(this, "setup", new Object[0]);
        this.m_dataLoadedOnComponentSetup = this.restoreEnvironmentDataFromPersistent(true);
    }

    @Override
    public void suspend() {
        Log.Helper.LOGD(this, "suspend", new Object[0]);
        if (this.m_synergyStartupObject != null) {
            this.m_synergyStartupObject.cancel();
            this.m_synergyStartupObject = null;
        }
        if (this.m_networkStatusChangeReceiver != null) {
            Utility.unregisterReceiver(this.m_networkStatusChangeReceiver);
            this.m_networkStatusChangeReceiver = null;
        }
        this.saveEnvironmentDataToPersistent();
    }

    @Override
    public void teardown() {
        this.m_environmentDataContainer = null;
    }
}

