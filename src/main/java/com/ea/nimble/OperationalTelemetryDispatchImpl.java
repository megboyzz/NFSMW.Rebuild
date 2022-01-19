/*
 * Decompiled with CFR 0.152.
 */
package com.ea.nimble;

import com.ea.nimble.Component;
import com.ea.nimble.IOperationalTelemetryDispatch;
import com.ea.nimble.Log;
import com.ea.nimble.LogSource;
import com.ea.nimble.OperationalTelemetryEvent;
import com.ea.nimble.OperationalTelemetryEventImpl;
import com.ea.nimble.Utility;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class OperationalTelemetryDispatchImpl
extends Component
implements IOperationalTelemetryDispatch,
LogSource {
    private Map<String, Integer> m_maxEventQueueSizeDict;
    private List<OperationalTelemetryEvent> m_networkMetricsArray = new ArrayList<OperationalTelemetryEvent>();
    private List<OperationalTelemetryEvent> m_networkPayloadsArray = new ArrayList<OperationalTelemetryEvent>();

    public OperationalTelemetryDispatchImpl() {
        this.m_maxEventQueueSizeDict = new HashMap<String, Integer>();
        this.m_maxEventQueueSizeDict.put("com.ea.nimble.network", 100);
        this.m_maxEventQueueSizeDict.put("com.ea.nimble.trackingimpl.synergy", 100);
    }

    private boolean canLogEvent(String list) {
        boolean bl2;
        boolean bl3 = false;
        int n2 = this.getMaxEventCount((String)((Object)list));
        if (((String)((Object)list)).equals("com.ea.nimble.network")) {
            list = this.m_networkMetricsArray;
        } else {
            if (!((String)((Object)list)).equals("com.ea.nimble.trackingimpl.synergy")) {
                Log.Helper.LOGE(this, "canLogEvent, unsupported OT eventType, " + list + ".", new Object[0]);
                return false;
            }
            list = this.m_networkPayloadsArray;
        }
        boolean bl4 = list.size() < n2;
        boolean bl5 = n2 < 0;
        n2 = n2 == 0 ? 1 : 0;
        if (!bl4) {
            bl2 = bl3;
            if (!bl5) return bl2;
        }
        bl2 = bl3;
        if (n2 != 0) return bl2;
        return true;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private void purgeOldestEvent(List<OperationalTelemetryEvent> list) {
        synchronized (this) {
            if (list.size() == 0) {
                Log.Helper.LOGD(this, "purgeOldestEvent called with empty event array.", new Object[0]);
                return;
            }
            OperationalTelemetryEvent operationalTelemetryEvent = null;
            Iterator<OperationalTelemetryEvent> iterator = list.iterator();
            while (true) {
                if (!iterator.hasNext()) {
                    if (operationalTelemetryEvent == null) return;
                    list.remove(operationalTelemetryEvent);
                    return;
                }
                OperationalTelemetryEvent operationalTelemetryEvent2 = iterator.next();
                if (operationalTelemetryEvent != null && !operationalTelemetryEvent2.getLoggedTime().before(operationalTelemetryEvent.getLoggedTime())) continue;
                operationalTelemetryEvent = operationalTelemetryEvent2;
            }
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private void trimEventQueue(String list) {
        int n2 = this.getMaxEventCount((String)((Object)list));
        if (((String)((Object)list)).equals("com.ea.nimble.network")) {
            list = this.m_networkMetricsArray;
        } else {
            if (!((String)((Object)list)).equals("com.ea.nimble.trackingimpl.synergy")) {
                Log.Helper.LOGE(this, "trimEventQueue, unsupported OT eventType, " + list + ".", new Object[0]);
                return;
            }
            list = this.m_networkPayloadsArray;
        }
        if (n2 < 0) {
            return;
        }
        if (list.size() == 0) return;
        if (list.size() - n2 < 0) return;
        synchronized (this) {
            if (n2 == 0) {
                list.clear();
                return;
            }
            int n3 = n2 / 2;
            Log.Helper.LOGI(this, "trimEventQueues, queue threshold surprassed, purging " + n3 + " older events ", new Object[0]);
            n2 = 0;
            while (n2 < n3) {
                this.purgeOldestEvent(list);
                ++n2;
            }
            return;
        }
    }

    private void updateEventThresholdListeners() {
        HashMap<String, String> hashMap;
        int n2 = this.getMaxEventCount("com.ea.nimble.network");
        if (n2 > 0) {
            n2 = (int)((double)n2 * 0.75);
            if (this.m_networkMetricsArray.size() >= n2) {
                hashMap = new HashMap<String, String>();
                hashMap.put("eventType", "com.ea.nimble.network");
                Utility.sendBroadcast("nimble.notification.ot.eventthresholdwarning", hashMap);
                Log.Helper.LOGV(this, "updateEventThresholdListeners, notifying listeners event queue is approaching threshold.", new Object[0]);
            }
        }
        if ((n2 = this.getMaxEventCount("com.ea.nimble.trackingimpl.synergy")) <= 0) return;
        n2 = (int)((double)n2 * 0.75);
        if (this.m_networkPayloadsArray.size() < n2) return;
        hashMap = new HashMap();
        hashMap.put("eventType", "com.ea.nimble.trackingimpl.synergy");
        Utility.sendBroadcast("nimble.notification.ot.eventthresholdwarning", hashMap);
        Log.Helper.LOGV(this, "updateEventThresholdListeners, notifying listeners event queue is approaching threshold.", new Object[0]);
    }

    @Override
    protected void cleanup() {
    }

    @Override
    public String getComponentId() {
        return "com.ea.nimble.operationaltelemetrydispatch";
    }

    /*
     * Enabled unnecessary exception pruning
     */
    @Override
    public List<OperationalTelemetryEvent> getEvents(String string2) {
        if (!Utility.validString(string2)) {
            Log.Helper.LOGE(this, "getEvents called with null or empty eventType.", new Object[0]);
            return null;
        }
        List<OperationalTelemetryEvent> list = null;
        synchronized (this) {
            if (string2.equals("com.ea.nimble.network")) {
                list = this.m_networkMetricsArray;
                this.m_networkMetricsArray = new ArrayList<OperationalTelemetryEvent>();
            } else if (string2.equals("com.ea.nimble.trackingimpl.synergy")) {
                list = this.m_networkPayloadsArray;
                this.m_networkPayloadsArray = new ArrayList<OperationalTelemetryEvent>();
            }
        }
        if (list != null) return Collections.unmodifiableList(list);
        Log.Helper.LOGE(this, "getEvents, unsupported OT eventType, " + string2 + ".", new Object[0]);
        return Collections.unmodifiableList(list);
    }

    @Override
    public String getLogSourceTitle() {
        return "OTDispatch";
    }

    @Override
    public int getMaxEventCount(String object) {
        if (!Utility.validString((String)object)) {
            Log.Helper.LOGE(this, "getMaxEventCount called with null or empty eventType.", new Object[0]);
            return 100;
        }
        if ((object = this.m_maxEventQueueSizeDict.get(object)) == null) return 100;
        return (Integer)object;
    }

    /*
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    @Override
    public void logEvent(String string2, Map<String, String> object) {
        boolean bl2;
        block11: {
            block12: {
                block10: {
                    OperationalTelemetryEventImpl operationalTelemetryEventImpl;
                    block9: {
                        Log.Helper.LOGD(this, "LOGEVENT...", new Object[0]);
                        if (!Utility.validString(string2)) {
                            Log.Helper.LOGE(this, "logEvent called with null or empty eventType.", new Object[0]);
                            return;
                        }
                        if (operationalTelemetryEventImpl == null || operationalTelemetryEventImpl.size() == 0) {
                            Log.Helper.LOGE(this, "logEvent called with null or empty eventDictionary.", new Object[0]);
                            return;
                        }
                        operationalTelemetryEventImpl = new OperationalTelemetryEventImpl(string2, (Map<String, String>)((Object)operationalTelemetryEventImpl), new Date());
                        bl2 = false;
                        // MONITORENTER : this
                        if (!string2.equals("com.ea.nimble.network")) break block9;
                        if (!this.canLogEvent(string2)) {
                            this.trimEventQueue(string2);
                        }
                        if (this.canLogEvent(string2)) {
                            this.m_networkMetricsArray.add(operationalTelemetryEventImpl);
                        }
                        break block10;
                    }
                    if (!string2.equals("com.ea.nimble.trackingimpl.synergy")) break block11;
                    if (!this.canLogEvent(string2)) {
                        this.trimEventQueue(string2);
                    }
                    if (!this.canLogEvent(string2)) break block12;
                    this.m_networkPayloadsArray.add(operationalTelemetryEventImpl);
                    break block12;
                }
                bl2 = true;
                break block11;
            }
            bl2 = true;
        }
        // MONITOREXIT : this
        if (!bl2) {
            Log.Helper.LOGE(this, "logEvent, unsupported OT eventType, " + string2 + ".", new Object[0]);
        }
        this.updateEventThresholdListeners();
    }

    @Override
    protected void restore() {
    }

    @Override
    protected void resume() {
    }

    @Override
    public void setMaxEventCount(String string2, int n2) {
        if (!Utility.validString(string2)) {
            Log.Helper.LOGE(this, "setMaxEventCount called with null or empty eventType.", new Object[0]);
            return;
        }
        this.m_maxEventQueueSizeDict.put(string2, n2);
        this.trimEventQueue(string2);
    }

    @Override
    protected void suspend() {
    }
}

