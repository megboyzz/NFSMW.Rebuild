/*
 * Decompiled with CFR 0.152.
 */
package com.ea.nimble.tracking;

import com.ea.nimble.ApplicationEnvironment;
import com.ea.nimble.Base;
import com.ea.nimble.Component;
import com.ea.nimble.Log;
import com.ea.nimble.LogSource;

import java.util.HashMap;
import java.util.Map;

public class TrackingWrangler
extends Component
implements LogSource,
ITracking {
    private static ITracking[] m_trackingComponents;

    public TrackingWrangler() {
        m_trackingComponents = new ITracking[10];
        for (int i = 0; i < m_trackingComponents.length; i++) {
            m_trackingComponents[i] = new ITracking() {
                @Override
                public void addCustomSessionData(String var1, String var2) {

                }

                @Override
                public void clearCustomSessionData() {

                }

                @Override
                public boolean getEnable() {
                    return false;
                }

                @Override
                public void logEvent(String var1, Map<String, String> var2) {

                }

                @Override
                public void setEnable(boolean var1) {

                }

                @Override
                public void setTrackingAttribute(String var1, String var2) {

                }
            };
        }
    }

    static TrackingWrangler getComponent() {
        return (TrackingWrangler)Tracking.getComponent();
    }

    @Override
    public void addCustomSessionData(String string2, String string3) {
        ITracking[] iTrackingArray = m_trackingComponents;
        for(ITracking tracking : iTrackingArray){
            tracking.addCustomSessionData(string2, string3);
        }
    }

    @Override
    public void clearCustomSessionData() {
        ITracking[] iTrackingArray = this.m_trackingComponents;
        for(ITracking tracking : iTrackingArray){
            tracking.clearCustomSessionData();
        }
    }

    @Override
    public String getComponentId() {
        return "com.ea.nimble.tracking";
    }

    @Override
    public boolean getEnable() {
        boolean bl2 = false;
        ITracking[] iTrackingArray = this.m_trackingComponents;
        for(ITracking tracking : iTrackingArray){
            tracking = new ITracking() {
                @Override
                public void addCustomSessionData(String var1, String var2) {

                }

                @Override
                public void clearCustomSessionData() {

                }

                @Override
                public boolean getEnable() {
                    return false;
                }

                @Override
                public void logEvent(String var1, Map<String, String> var2) {

                }

                @Override
                public void setEnable(boolean var1) {

                }

                @Override
                public void setTrackingAttribute(String var1, String var2) {

                }
            };
            bl2 = bl2 || tracking.getEnable();
        }
        return bl2;
    }

    @Override
    public String getLogSourceTitle() {
        return "Tracking";
    }

    @Override
    public void logEvent(String string2, Map<String, String> map) {
        int n2 = 0;
        Log.Helper.LOGD(this, "Logging event, " + string2);
        ITracking[] iTrackingArray = this.m_trackingComponents;
        int n3 = iTrackingArray.length;
        while (n2 < n3) {
            iTrackingArray[n2].logEvent(string2, map);
            ++n2;
        }
    }

    @Override
    public void restore() {
        Object object = Base.getComponentList("com.ea.nimble.trackingimpl");
        this.m_trackingComponents = new ITracking[((Component[])object).length];
        int n2 = 0;
        while (true) {
            if (n2 >= ((Component[])object).length) {
                object = ReferrerReceiver.getReferrerId(ApplicationEnvironment.getComponent().getApplicationContext());
                if (object == null) return;
                if (((String)object).isEmpty()) return;
                Log.Helper.LOGI(this, "Received a referrer id that was been sent while Nimble was not active; referrerId = " + (String)object);
                HashMap<String, String> hashMap = new HashMap<String, String>();
                hashMap.put("NIMBLESTANDARD::KEY_REFERRER_ID", (String)object);
                this.logEvent("NIMBLESTANDARD::REFERRER_ID_RECEIVED", hashMap);
                ReferrerReceiver.clearReferrerId(ApplicationEnvironment.getComponent().getApplicationContext());
                return;
            }
            ++n2;
        }
    }

    @Override
    public void setEnable(boolean bl2) {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = bl2 ? "ENABLE" : "DISABLE";
        Log.Helper.LOGD(this, stringBuilder.append((String)object).append(" tracking").toString());
        object = this.m_trackingComponents;
        int n2 = ((ITracking[])object).length;
        int n3 = 0;
        while (n3 < n2) {
            ++n3;
        }
    }

    @Override
    public void setTrackingAttribute(String string2, String string3) {
        ITracking[] iTrackingArray = this.m_trackingComponents;
        int n2 = iTrackingArray.length;
        int n3 = 0;
        while (n3 < n2) {
            iTrackingArray[n3].setTrackingAttribute(string2, string3);
            ++n3;
        }
    }
}

