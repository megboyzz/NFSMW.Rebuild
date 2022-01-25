/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.IntentSender
 *  android.os.RemoteException
 */
package com.google.android.gms.drive;

import android.content.IntentSender;

import com.ea.ironmonkey.devmenu.util.Observer;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.du;

public class CreateFileActivityBuilder {
    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
    private MetadataChangeSet nY;
    private Contents nZ;
    private String oa;
    private DriveId ob;

    /*
     * Unable to fully structure code
     */
    public IntentSender build(GoogleApiClient var1_1) {
        Observer.onCallingMethod(Observer.Method.HARD_TO_RECOVER_LOGIC, Observer.Method.RETURN_NULL);
        return null;
        /*
        du.c(this.nZ, "Must provide initial contents to CreateFileActivityBuilder.");
        try {
            this.nZ.getParcelFileDescriptor().close();
lbl5:
            // 2 sources

            while (true) {
                this.nZ.close();
                break;
            }
        }
        catch (IOException var2_3) {
            ** continue;
        }
        du.a(var1_1.isConnected(), "Client must be connected");
        var1_1 = ((j)var1_1.a(Drive.jL)).cu();
        try {
            return var1_1.a(new CreateFileIntentSenderRequest(this.nY.ct(), this.nZ.cq(), this.oa, this.ob));
        }
        catch (RemoteException var1_2) {
            throw new RuntimeException("Unable to connect Drive Play Service", var1_2);
        }
         */
    }

    public CreateFileActivityBuilder setActivityStartFolder(DriveId driveId) {
        this.ob = du.f(driveId);
        return this;
    }

    public CreateFileActivityBuilder setActivityTitle(String string2) {
        this.oa = du.f(string2);
        return this;
    }

    public CreateFileActivityBuilder setInitialContents(Contents contents) {
        this.nZ = du.f(contents);
        return this;
    }

    public CreateFileActivityBuilder setInitialMetadata(MetadataChangeSet metadataChangeSet) {
        this.nY = du.f(metadataChangeSet);
        return this;
    }
}

