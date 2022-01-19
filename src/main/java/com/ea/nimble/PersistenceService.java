/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.backup.BackupAgent
 *  android.app.backup.BackupDataInput
 *  android.app.backup.BackupDataOutput
 *  android.content.Context
 *  android.os.ParcelFileDescriptor
 */
package com.ea.nimble;

import android.app.backup.BackupAgent;
import android.app.backup.BackupDataInput;
import android.app.backup.BackupDataOutput;
import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.ea.nimble.ApplicationEnvironment;
import com.ea.nimble.BaseCore;
import com.ea.nimble.IPersistenceService;
import com.ea.nimble.Log;
import com.ea.nimble.Persistence;
import com.ea.nimble.PersistenceServiceImpl;
import com.ea.nimble.Utility;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class PersistenceService {
    private static final String APPLICATION_PERSISTENCE_ID = "[APPLICATION]";
    public static final String COMPONENT_ID = "com.ea.nimble.persistence";
    private static final String NIMBLE_COMPONENT_PERSISTENCE_ID_TEMPLATE = "[COMPONENT]%s";

    public static void cleanReferenceToPersistence(String string2, Persistence.Storage storage) {
        if (!Utility.validString(string2)) {
            Log.Helper.LOGF("Persistence", "Invalid componentId " + string2 + " for component persistence", new Object[0]);
            return;
        }
        string2 = String.format(NIMBLE_COMPONENT_PERSISTENCE_ID_TEMPLATE, string2);
        PersistenceService.getComponent().cleanPersistenceReference(string2, storage);
    }

    public static Persistence getAppPersistence(Persistence.Storage storage) {
        return PersistenceService.getComponent().getPersistence(APPLICATION_PERSISTENCE_ID, storage);
    }

    public static IPersistenceService getComponent() {
        return BaseCore.getInstance().getPersistenceService();
    }

    public static Persistence getPersistenceForNimbleComponent(String string2, Persistence.Storage storage) {
        if (!Utility.validString(string2)) {
            Log.Helper.LOGF("Persistence", "Invalid componentId " + string2 + " for component persistence", new Object[0]);
            return null;
        }
        string2 = String.format(NIMBLE_COMPONENT_PERSISTENCE_ID_TEMPLATE, string2);
        return PersistenceService.getComponent().getPersistence(string2, storage);
    }

    /*
     * Unable to fully structure code
     */
    static void readBackup(BackupDataInput var0, int var1_1, ParcelFileDescriptor var2_2, Context var3_4) throws IOException {
        while (var0.readNextHeader()) {
            var2_2 = var0.getKey();
            var1_1 = var0.getDataSize();
            var5_7 = new byte[var1_1];
            var0.readEntityData(var5_7, 0, var1_1);
            var2_2 = Persistence.getPersistencePath((String)var2_2, Persistence.Storage.DOCUMENT, var3_4);
            var4_6 = null;
            try {
                var2_2 = new FileOutputStream((String)var2_2);
            }
            catch (Throwable var2_3) {
                var0 = var4_6;
lbl13:
                // 2 sources

                while (true) {
                    if (var0 == null) throw var2_2;
                    var0.close();
                    throw var2_2;
                }
            }
            try {
                var2_2.write(var5_7);
                if (var2_2 == null) continue;
            }
            catch (Throwable var3_5) {
                var0 = var2_2;
                var2_2 = var3_5;
                ** continue;
            }
            var2_2.close();
        }
        if (ApplicationEnvironment.isMainApplicationRunning() == false) return;
        var0 = ((PersistenceServiceImpl)PersistenceService.getComponent()).m_persistences.values().iterator();
        while (var0.hasNext() != false) {
            var2_2 = (Persistence)var0.next();
            if (!var2_2.getBackUp()) continue;
            var2_2.restore(false, null);
        }
    }

    public static void removePersistenceForNimbleComponent(String string2, Persistence.Storage storage) {
        if (!Utility.validString(string2)) {
            Log.Helper.LOGF("Persistence", "Invalid componentId " + string2 + " for component persistence", new Object[0]);
            return;
        }
        string2 = String.format(NIMBLE_COMPONENT_PERSISTENCE_ID_TEMPLATE, string2);
        PersistenceService.getComponent().removePersistence(string2, storage);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    static void writeBackup(ParcelFileDescriptor var0, BackupDataOutput var1_5, ParcelFileDescriptor var2_12, Context var3_14) throws IOException {
        block30: {
            block32: {
                block31: {
                    var15_15 = null;
                    var16_17 = null;
                    var4_18 = 0;
                    var7_19 = 0L;
                    if (var0 != null) {
                        var0 = new FileInputStream(var0.getFileDescriptor());
                    }
lbl9:
                    // 6 sources

                    while (true) {
                        var15_15 = new ArrayList<File>(Arrays.asList(Persistence.getPersistenceDirectory(Persistence.Storage.DOCUMENT, (Context)var3_14).listFiles()));
                        var16_17 = new ArrayList<Object>();
                        var5_20 = 0;
                        var9_21 = 0L;
                        var17_22 = var15_15.iterator();
                        block18: while (var17_22.hasNext()) {
                            var18_26 = (File)var17_22.next();
                            var0 = var18_26.getName();
                            var6_23 = var0.lastIndexOf(".");
                            if (var6_23 < 0) lbl-1000:
                            // 2 sources

                            {
                                while (true) {
                                    var0 = new Persistence((String)var0, Persistence.Storage.DOCUMENT, null);
                                    var0.restore(true, (Context)var3_14);
                                    if (var0.getBackUp()) {
                                        ++var5_20;
                                        var13_25 = var18_26.lastModified();
                                        var11_24 = var9_21;
                                        if (var13_25 > var9_21) {
                                            var11_24 = var13_25;
                                        }
                                        var16_17.add(var0);
                                        var9_21 = var11_24;
                                        continue block18;
                                    }
                                    break;
                                }
                            } else {
                                var0 = var0.substring(0, var6_23);
                                ** continue;
                            }
                            var17_22.remove();
                        }
                        if (var5_20 == var4_18 && var7_19 == var9_21) break block30;
                        var4_18 = 0;
lbl40:
                        // 2 sources

                        while (var4_18 < var15_15.size()) {
                            var17_22 = (Persistence)var16_17.get(var4_18);
                            var3_14 = (File)var15_15.get(var4_18);
                            var18_26 = new byte[(int)var3_14.length()];
                            var0 = null;
                            var3_14 = new FileInputStream((File)var3_14);
                            break block31;
                        }
                        break block30;
                        break;
                    }
                    var0 = new DataInputStream((InputStream)var0);
                    try {
                        var4_18 = var0.readInt();
                        var7_19 = var0.readLong();
                        if (var0 == null) ** GOTO lbl9
                    }
                    catch (IOException var15_16) {
                        ** GOTO lbl59
                    }
                    var0.close();
                    ** GOTO lbl9
                    catch (IOException var0_1) {
                        var0 = var16_17;
lbl59:
                        // 3 sources

                        while (true) {
                            var5_20 = 0;
                            var9_21 = 0L;
                            var4_18 = var5_20;
                            var7_19 = var9_21;
                            if (var0 == null) ** GOTO lbl9
                            var0.close();
                            var4_18 = var5_20;
                            var7_19 = var9_21;
                            ** continue;
                            break;
                        }
                    }
                    catch (Throwable var0_3) {
                        var1_5 /* !! */  = var15_15;
                        ** GOTO lbl79
                    }
                    catch (IOException var0_4) {
                        var0 = var16_17;
                        ** continue;
                    }
                    catch (Throwable var0_2) {
                        var1_5 /* !! */  = var15_15;
lbl79:
                        // 3 sources

                        while (true) {
                            if (var1_5 /* !! */  == null) throw var0;
                            var1_5 /* !! */ .close();
                            throw var0;
                        }
                    }
                    catch (Throwable var2_13) {
                        var1_5 /* !! */  = var0;
                        var0 = var2_13;
                        ** continue;
                    }
                }
                try {
                    var3_14.read((byte[])var18_26);
                    if (var3_14 == null) break block32;
                }
                catch (Throwable var1_11) {
                    var0 = var3_14;
                    ** continue;
                }
                var3_14.close();
            }
            var1_5 /* !! */ .writeEntityHeader(var17_22.getIdentifier(), ((Object)var18_26).length);
            var1_5 /* !! */ .writeEntityData((byte[])var18_26, ((Object)var18_26).length);
            ++var4_18;
            ** GOTO lbl40
            catch (Throwable var1_6) lbl-1000:
            // 2 sources

            {
                while (true) {
                    if (var0 == null) throw var1_7;
                    var0.close();
                    throw var1_7;
                }
            }
        }
        var1_5 /* !! */  = new FileOutputStream(var2_12.getFileDescriptor());
        var0 = null;
        var2_12 = new DataOutputStream((OutputStream)var1_5 /* !! */ );
lbl-1000:
        // 2 sources

        {
            while (true) {
                if (var0 == null) throw var1_9;
                var0.close();
                throw var1_9;
            }
        }
        try {
            var2_12.writeInt(var5_20);
            var2_12.writeLong(var9_21);
            if (var2_12 == null) return;
        }
        catch (Throwable var1_10) {
            var0 = var2_12;
            ** GOTO lbl-1000
        }
        var2_12.close();
        return;
        catch (Throwable var1_8) {}
        ** while (true)
    }

    public static class PersistenceBackupAgent
    extends BackupAgent {
        public void onBackup(ParcelFileDescriptor parcelFileDescriptor, BackupDataOutput backupDataOutput, ParcelFileDescriptor parcelFileDescriptor2) throws IOException {
            Object object = Persistence.s_dataLock;
            synchronized (object) {
                PersistenceService.writeBackup(parcelFileDescriptor, backupDataOutput, parcelFileDescriptor2, (Context)this);
                return;
            }
        }

        public void onRestore(BackupDataInput backupDataInput, int n2, ParcelFileDescriptor parcelFileDescriptor) throws IOException {
            Object object = Persistence.s_dataLock;
            synchronized (object) {
                PersistenceService.readBackup(backupDataInput, n2, parcelFileDescriptor, (Context)this);
                return;
            }
        }
    }

    public static enum PersistenceMergePolicy {
        OVERWRITE,
        SOURCE_FIRST,
        TARGET_FIRST;

    }
}

