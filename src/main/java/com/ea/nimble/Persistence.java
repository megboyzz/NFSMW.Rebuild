/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.backup.BackupManager
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.util.Log
 */
package com.ea.nimble;

import android.app.backup.BackupManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.ea.nimble.ApplicationEnvironment;
import com.ea.nimble.Encryptor;
import com.ea.nimble.Log;
import com.ea.nimble.LogSource;
import com.ea.nimble.PersistenceService;
import com.ea.nimble.Timer;
import com.ea.nimble.Utility;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Persistence
implements LogSource {
    private static int PERSISTENCE_VERSION = 101;
    static final Object s_dataLock = new Object();
    private boolean m_backUp;
    private boolean m_changed;
    private Map<String, byte[]> m_content;
    private boolean m_encryption;
    private Encryptor m_encryptor;
    private String m_identifier;
    private Storage m_storage;
    private Timer m_synchronizeTimer = new Timer(new Runnable(){

        @Override
        public void run() {
            Persistence.this.synchronize();
        }
    });

    Persistence(Persistence persistence, String string2) {
        this.m_content = new HashMap<String, byte[]>(persistence.m_content);
        this.m_identifier = string2;
        this.m_storage = persistence.m_storage;
        this.m_encryptor = persistence.m_encryptor;
        this.m_encryption = persistence.m_encryption;
        this.m_backUp = persistence.m_backUp;
        this.flagChange();
    }

    Persistence(String string2, Storage storage, Encryptor encryptor) {
        this.m_content = new HashMap<String, byte[]>();
        this.m_identifier = string2;
        this.m_storage = storage;
        this.m_encryptor = encryptor;
        this.m_encryption = false;
        this.m_backUp = false;
        this.m_changed = false;
    }

    private void clearSynchronizeTimer() {
        Object object = s_dataLock;
        synchronized (object) {
            this.m_synchronizeTimer.cancel();
            return;
        }
    }

    private void flagChange() {
        this.m_changed = true;
        Object object = s_dataLock;
        synchronized (object) {
            this.clearSynchronizeTimer();
            this.m_synchronizeTimer.schedule(0.5, false);
            return;
        }
    }

    static File getPersistenceDirectory(Storage storage) {
        Object object = ApplicationEnvironment.getComponent();
        switch (storage) {
            default: {
                Log.Helper.LOGES("Persistence", "Unknown storage type", new Object[0]);
                return null;
            }
            case DOCUMENT: {
                object = object.getDocumentPath();
                break;
            }
            case CACHE: {
                object = object.getCachePath();
                break;
            }
            case TEMP: {
                object = object.getTempPath();
            }
        }
        File file = new File((String)object + File.separator + "persistence");
        object = file;
        if (file.isDirectory()) return object;
        object = file;
        if (file.mkdirs()) return object;
        Log.Helper.LOGE("Persistence", "Cannot create persistence folder in storage(%s) %s", new Object[]{storage, file.toString()});
        return null;
    }

    static File getPersistenceDirectory(Storage storage, Context object) {
        Object object2;
        switch (storage) {
            default: {
                Log.e((String)"Nimble", (String)"Persistence : Unknown storage type");
                return null;
            }
            case DOCUMENT: {
                object2 = object.getFilesDir().getPath();
                break;
            }
            case CACHE: 
            case TEMP: {
                object2 = object.getCacheDir().getPath();
            }
        }
        PackageManager packageManager = object.getPackageManager();
        File file = null;
        try {
            object = packageManager.getApplicationInfo(object.getPackageName(), 128);
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            object = file;
        }
        object = ((ApplicationInfo)object).metaData.getString("com.ea.nimble.configuration");
        object = object2 = (String)object2 + File.separator + "Nimble" + File.separator + (String)object + File.separator + "persistence";
        if (storage == Storage.TEMP) {
            object = (String)object2 + File.separator + "temp";
        }
        file = new File((String)object);
        object2 = file;
        if (file.isDirectory()) return object2;
        object2 = file;
        if (file.mkdirs()) return object2;
        Log.e((String)"Nimble", (String)String.format("Persistence : Cannot create persistence folder in storage(%s) %s", new Object[]{storage, ((String)object).toString()}));
        return null;
    }

    static String getPersistencePath(String string2, Storage object) {
        if ((object = Persistence.getPersistenceDirectory(object)) != null) return (Object)object + File.separator + string2 + ".dat";
        return null;
    }

    static String getPersistencePath(String string2, Storage object, Context context) {
        if ((object = Persistence.getPersistenceDirectory(object, context)) != null) return (Object)object + File.separator + string2 + ".dat";
        return null;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    private void loadPersistenceData(boolean var1_1, Context var2_2) {
        block21: {
            var4_6 = var2_2 == null ? Persistence.getPersistencePath(this.m_identifier, this.m_storage) : Persistence.getPersistencePath(this.m_identifier, this.m_storage, (Context)var2_2);
            if (var4_6 == null) {
                return;
            }
            var3_8 = new File(var4_6);
            if (!var3_8.exists() || var3_8.length() == 0L) {
                Log.Helper.LOGD(this, "No persistence file for id[%s] to restore from storage %s", new Object[]{this.m_identifier, this.m_storage.toString()});
                return;
            }
            Log.Helper.LOGD(this, "Loading persistence file size %d", new Object[]{var3_8.length()});
            var2_2 = null;
            var6_10 = null;
            var3_8 = new FileInputStream((File)var3_8);
            {
                block20: {
                    catch (Throwable var3_9) lbl-1000:
                    // 2 sources

                    {
                        while (true) {
                            if (var2_2 == null) throw var3_8;
                            try {
                                var2_2.close();
                                throw var3_8;
                            }
                            catch (IOException var2_5) {
                                throw var3_8;
                            }
                            break;
                        }
                    }
                    catch (Exception var5_14) {
                        var3_8 = var6_10;
                        break block20;
                    }
                    try {
                        var5_11 = new ObjectInputStream((InputStream)var3_8);
                        if (var5_11.readInt() != Persistence.PERSISTENCE_VERSION) {
                            throw new InvalidClassException("com.ea.nimble.Persistence", "Persistence version doesn't match");
                        }
                    }
                    catch (Exception var5_12) {}
                }
                var2_2 = var3_8;
                {
                    Log.Helper.LOGE(this, "Can't read persistence (%s) file, %s: %s", new Object[]{this.m_identifier, var4_6, var5_13.toString()});
                    var2_2 = var3_8;
                    var5_13.printStackTrace();
                    if (var3_8 == null) return;
                }
                try {
                    var3_8.close();
                    return;
                }
                catch (IOException var2_3) {
                    return;
                }
            }
            try {
                this.m_encryption = var5_11.readBoolean();
                this.m_backUp = var5_11.readBoolean();
                if (var1_1) ** GOTO lbl53
                var2_2 = new BufferedInputStream((InputStream)var3_8);
                if (!this.m_encryption) break block21;
                var2_2 = this.m_encryptor.encryptInputStream((InputStream)var2_2);
lbl49:
                // 2 sources

                while (true) {
                    this.m_content = (Map)var2_2.readObject();
                    Log.Helper.LOGD(this, "Persistence file for id[%s] restored from storage %s", new Object[]{this.m_identifier, this.m_storage.toString()});
                    var2_2.close();
lbl53:
                    // 2 sources

                    var5_11.close();
                    if (var3_8 == null) return;
                    break;
                }
            }
            catch (Throwable var4_7) {
                var2_2 = var3_8;
                var3_8 = var4_7;
                ** continue;
            }
            {
                var3_8.close();
                return;
            }
        }
        var2_2 = new ObjectInputStream((InputStream)var2_2);
        ** continue;
        catch (IOException var2_4) {
            return;
        }
    }

    private void putValue(String string2, Serializable object) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(object);
        objectOutputStream.close();
        object = byteArrayOutputStream.toByteArray();
        if (object.equals(this.m_content.get(string2))) return;
        this.m_content.put(string2, (byte[])object);
        this.flagChange();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     */
    private void savePersistenceData() {
        var1_1 = Persistence.getPersistencePath(this.m_identifier, this.m_storage);
        if (var1_1 == null) {
            return;
        }
        var4_6 = new File((String)var1_1);
        var1_1 = null;
        var3_7 = null;
        var2_10 = new FileOutputStream(var4_6);
        ** GOTO lbl19
        {
            block19: {
                catch (Throwable var2_11) lbl-1000:
                // 2 sources

                {
                    while (true) {
                        if (var1_1 == null) throw var2_10;
                        try {
                            var1_1.close();
                            throw var2_10;
                        }
                        catch (IOException var1_5) {
                            throw var2_10;
                        }
                        break;
                    }
lbl19:
                    // 2 sources

                    var3_7 = new ObjectOutputStream((OutputStream)var2_10);
                    var3_7.writeInt(Persistence.PERSISTENCE_VERSION);
                    var3_7.writeBoolean(this.m_encryption);
                    var3_7.writeBoolean(this.m_backUp);
                    var3_7.flush();
                    var1_1 = new BufferedOutputStream((OutputStream)var2_10);
                    if (!this.m_encryption) ** GOTO lbl-1000
                    var1_1 = this.m_encryptor.encryptOutputStream((OutputStream)var1_1);
lbl28:
                    // 6 sources

                    while (true) {
                        Log.Helper.LOGD(this, "Saving persistence file size %d", new Object[]{var4_6.length()});
                        return;
                    }
                    while (true) {
                        try {
                            var2_10.close();
                        }
                        catch (IOException var1_4) {}
                        ** GOTO lbl28
                        break;
                    }
                }
                catch (Throwable var3_8) {
                    var1_1 = var2_10;
                    var2_10 = var3_8;
                    ** continue;
                }
                catch (Exception var3_9) {
                    break block19;
                }
lbl43:
                // 2 sources

                while (true) {
                    var1_1.writeObject(this.m_content);
                    Log.Helper.LOGD(this, "Synchronize persistence for id[%s] in storage %s", new Object[]{this.m_identifier, this.m_storage.toString()});
                    var1_1.close();
                    var3_7.close();
                    if (var2_10 == null) ** GOTO lbl28
                    var2_10.close();
                    break;
                }
lbl-1000:
                // 1 sources

                {
                    var1_1 = new ObjectOutputStream((OutputStream)var1_1);
                    ** continue;
                }
                catch (IOException var1_2) {}
                ** GOTO lbl28
                catch (Exception var1_3) {}
                var2_10 = var3_7;
                var3_7 = var1_3;
            }
            var1_1 = var2_10;
            {
                Log.Helper.LOGE(this, "Fail to save persistence file for id[%s] in storage %s: %s", new Object[]{this.m_identifier, this.m_storage.toString(), var3_7.toString()});
                var1_1 = var2_10;
                var3_7.printStackTrace();
                if (var2_10 != null) ** continue;
                ** continue;
            }
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void addEntries(Object ... objectArray) {
        Object object = s_dataLock;
        synchronized (object) {
            String string2 = null;
            int n2 = 0;
            while (n2 < objectArray.length) {
                block11: {
                    if (n2 % 2 == 0) {
                        try {
                            string2 = (String)objectArray[n2];
                            if (!Utility.validString(string2)) {
                                throw new RuntimeException("Invalid key");
                            }
                            break block11;
                        }
                        catch (Exception exception) {
                            Log.Helper.LOGF(this, "Invalid key in NimblePersistence.addEntries at index %d, not a string", n2);
                            return;
                        }
                    }
                    try {
                        this.putValue(string2, (Serializable)objectArray[n2]);
                    }
                    catch (Exception exception) {
                        Log.Helper.LOGF(this, "Invalid value in NimblePersistence.addEntries for key %s at index %d", string2, n2);
                        return;
                    }
                }
                ++n2;
            }
            return;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void addEntriesFromMap(Map<String, Serializable> map) {
        Object object = s_dataLock;
        synchronized (object) {
            Iterator<String> iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                String string2 = iterator.next();
                if (!Utility.validString(string2)) {
                    Log.Helper.LOGE(this, "Invalid key %s in NimblePersistence.addEntriesInDictionary, not a string, skip it", string2);
                    continue;
                }
                Serializable serializable = map.get(string2);
                if (serializable != null) {
                    try {
                        this.putValue(string2, serializable);
                        continue;
                    }
                    catch (IOException iOException) {
                        // empty catch block
                    }
                }
                Log.Helper.LOGE(this, "Invalid value in NimblePersistence.addEntries for key %s", string2);
            }
            return;
        }
    }

    public void clean() {
        Object object = s_dataLock;
        synchronized (object) {
            File file = new File(Persistence.getPersistencePath(this.m_identifier, this.m_storage));
            if (!file.exists()) return;
            if (file.delete()) return;
            Log.Helper.LOGE(this, "Fail to clean persistence file for id[%s] in storage %s", this.m_identifier, this.m_storage.toString());
            return;
        }
    }

    public boolean getBackUp() {
        return this.m_backUp;
    }

    public boolean getEncryption() {
        return this.m_encryption;
    }

    public String getIdentifier() {
        return this.m_identifier;
    }

    @Override
    public String getLogSourceTitle() {
        return "Persistence";
    }

    public Storage getStorage() {
        return this.m_storage;
    }

    public String getStringValue(String object) {
        object = this.getValue((String)object);
        try {
            return (String)object;
        }
        catch (ClassCastException classCastException) {
            Log.Helper.LOGF(this, "Invalid value type for getStringValueCall, value is " + object.getClass().getName(), new Object[0]);
            return null;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public Serializable getValue(String string2) {
        Object object = s_dataLock;
        synchronized (object) {
            Object object2 = this.m_content.get(string2);
            if (object2 == null) {
                return null;
            }
            try {
                return (Serializable)new ObjectInputStream(new ByteArrayInputStream((byte[])object2)).readObject();
            }
            catch (Exception exception) {
                Log.Helper.LOGD(this, "PERSIST: Exception getting value, " + string2 + ":" + exception, new Object[0]);
                return null;
            }
        }
    }

    void merge(Persistence persistence, PersistenceService.PersistenceMergePolicy object) {
        switch (2.$SwitchMap$com$ea$nimble$PersistenceService$PersistenceMergePolicy[((Enum)object).ordinal()]) {
            default: {
                return;
            }
            case 1: {
                this.m_content = new HashMap<String, byte[]>(persistence.m_content);
                return;
            }
            case 2: {
                this.m_content.putAll(persistence.m_content);
                return;
            }
            case 3: 
        }
        object = persistence.m_content.keySet().iterator();
        while (object.hasNext()) {
            String string2 = (String)object.next();
            if (this.m_content.get(string2) != null) continue;
            this.m_content.put(string2, persistence.m_content.get(string2));
        }
    }

    void restore(boolean bl2, Context context) {
        Object object = s_dataLock;
        synchronized (object) {
            this.loadPersistenceData(bl2, context);
            return;
        }
    }

    public void setBackUp(boolean bl2) {
        if (this.m_storage != Storage.DOCUMENT) {
            Log.Helper.LOGF(this, "Error: Backup flag not supported for storage: " + (Object)((Object)this.m_storage), new Object[0]);
            return;
        }
        this.m_backUp = bl2;
    }

    public void setEncryption(boolean bl2) {
        if (bl2 == this.m_encryption) return;
        this.m_encryption = bl2;
        this.flagChange();
    }

    /*
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    public void setValue(String string2, Serializable serializable) {
        Object object = s_dataLock;
        // MONITORENTER : object
        if (!Utility.validString(string2)) {
            Log.Helper.LOGF(this, "NimblePersistence cannot accept an invalid string " + string2 + " as key", new Object[0]);
            // MONITOREXIT : object
            return;
        }
        if (serializable == null) {
            if (this.m_content.get(string2) != null) {
                this.m_content.remove(string2);
                this.flagChange();
            }
            // MONITOREXIT : object
            return;
        }
        try {
            this.putValue(string2, serializable);
            // MONITOREXIT : object
            return;
        }
        catch (IOException iOException) {
            Log.Helper.LOGF(this, "NimblePersistence cannot archive value " + serializable.toString(), new Object[0]);
            return;
        }
    }

    public void synchronize() {
        Object object = s_dataLock;
        synchronized (object) {
            if (!this.m_changed) {
                Log.Helper.LOGD(this, "Not synchronizing to persistence for id[%s] since there is no change", this.m_identifier);
                return;
            }
            this.clearSynchronizeTimer();
            this.savePersistenceData();
            if (!this.m_backUp) return;
            new BackupManager(ApplicationEnvironment.getComponent().getApplicationContext()).dataChanged();
            return;
        }
    }

    public static enum Storage {
        DOCUMENT,
        CACHE,
        TEMP;

    }
}

