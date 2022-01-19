/*
 * Decompiled with CFR 0.152.
 */
package com.ea.nimble;

import com.ea.nimble.Component;
import com.ea.nimble.Encryptor;
import com.ea.nimble.IPersistenceService;
import com.ea.nimble.Log;
import com.ea.nimble.LogSource;
import com.ea.nimble.Persistence;
import com.ea.nimble.PersistenceService;
import com.ea.nimble.Utility;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class PersistenceServiceImpl
extends Component
implements IPersistenceService,
LogSource {
    private Encryptor m_encryptor;
    protected ConcurrentMap<String, Persistence> m_persistences;

    /*
     * Enabled unnecessary exception pruning
     */
    private Persistence loadPersistenceById(String object, Persistence.Storage storage) {
        Object object2 = Persistence.s_dataLock;
        synchronized (object2) {
            String string2 = (String)object + "-" + storage.toString();
            Persistence persistence = (Persistence)this.m_persistences.get(string2);
            if (persistence != null) {
                return persistence;
            }
            if (!new File(Persistence.getPersistencePath((String)object, storage)).exists()) {
                return null;
            }
            object = new Persistence((String)object, storage, this.m_encryptor);
            ((Persistence)object).restore(false, null);
            this.m_persistences.put(string2, (Persistence)object);
            return object;
        }
    }

    private void synchronize() {
        Iterator iterator = this.m_persistences.values().iterator();
        while (iterator.hasNext()) {
            ((Persistence)iterator.next()).synchronize();
        }
    }

    @Override
    public void cleanPersistenceReference(String string2, Persistence.Storage storage) {
        if (!Utility.validString(string2)) {
            Log.Helper.LOGF(this, "Invalid identifier " + string2 + " for persistence", new Object[0]);
            return;
        }
        Object object = Persistence.s_dataLock;
        synchronized (object) {
            this.m_persistences.remove(string2 + "-" + storage.toString());
            return;
        }
    }

    @Override
    public String getComponentId() {
        return "com.ea.nimble.persistence";
    }

    @Override
    public String getLogSourceTitle() {
        return "Persistence";
    }

    /*
     * Enabled unnecessary exception pruning
     */
    @Override
    public Persistence getPersistence(String string2, Persistence.Storage storage) {
        if (!Utility.validString(string2)) {
            Log.Helper.LOGF(this, "Invalid identifier " + string2 + " for persistence", new Object[0]);
            return null;
        }
        Object object = Persistence.s_dataLock;
        synchronized (object) {
            Persistence persistence = this.loadPersistenceById(string2, storage);
            if (persistence != null) {
                return persistence;
            }
            persistence = new Persistence(string2, storage, this.m_encryptor);
            this.m_persistences.put(string2 + "-" + storage.toString(), persistence);
            return persistence;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    @Override
    public void migratePersistence(String object, Persistence.Storage object2, String string2, PersistenceService.PersistenceMergePolicy persistenceMergePolicy) {
        if (!Utility.validString((String)object) || !Utility.validString(string2)) {
            Log.Helper.LOGF(this, "Invalid identifiers " + (String)object + " or " + string2 + " for component persistence", new Object[0]);
            return;
        }
        Object object3 = Persistence.s_dataLock;
        synchronized (object3) {
            String string3 = string2 + "-" + ((Enum)object2).toString();
            object = this.loadPersistenceById((String)object, (Persistence.Storage)((Object)object2));
            if (object == null) {
                if (persistenceMergePolicy != PersistenceService.PersistenceMergePolicy.OVERWRITE) return;
                this.m_persistences.remove(string3);
                new File(Persistence.getPersistencePath(string2, (Persistence.Storage)((Object)object2))).delete();
                return;
            }
            if ((object2 = this.loadPersistenceById(string2, (Persistence.Storage)((Object)object2))) == null) {
                object = new Persistence((Persistence)object, string2);
                this.m_persistences.put(string3, (Persistence)object);
                ((Persistence)object).synchronize();
            } else {
                ((Persistence)object2).merge((Persistence)object, persistenceMergePolicy);
            }
            return;
        }
    }

    @Override
    public void removePersistence(String string2, Persistence.Storage storage) {
        if (!Utility.validString(string2)) {
            Log.Helper.LOGF(this, "Invalid identifier " + string2 + " for persistence", new Object[0]);
            return;
        }
        this.cleanPersistenceReference(string2, storage);
    }

    @Override
    public void setup() {
        this.m_persistences = new ConcurrentHashMap<String, Persistence>();
        this.m_encryptor = new Encryptor();
    }

    @Override
    public void suspend() {
        this.synchronize();
    }

    @Override
    public void teardown() {
        this.synchronize();
        Object object = Persistence.s_dataLock;
        synchronized (object) {
            this.m_persistences = null;
            this.m_encryptor = null;
            return;
        }
    }
}

