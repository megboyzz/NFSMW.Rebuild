/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.IntentSender
 *  android.os.RemoteException
 */
package com.google.android.gms.drive;

import android.content.IntentSender;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.OpenFileIntentSenderRequest;
import com.google.android.gms.drive.internal.j;
import com.google.android.gms.internal.du;

public class OpenFileActivityBuilder {
    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
    private String oa;
    private DriveId ob;
    private String[] ol;

    public IntentSender build(GoogleApiClient object) {
        du.c(this.ol, "setMimeType(String[]) must be called on this builder before calling build()");
        du.a(((GoogleApiClient)object).isConnected(), "Client must be connected");
        object = ((j)((Object)((GoogleApiClient)object).a(Drive.jL))).cu();
        try {
            return object.a(new OpenFileIntentSenderRequest(this.oa, this.ol, this.ob));
        }
        catch (RemoteException remoteException) {
            throw new RuntimeException("Unable to connect Drive Play Service", remoteException);
        }
    }

    public OpenFileActivityBuilder setActivityStartFolder(DriveId driveId) {
        this.ob = du.f(driveId);
        return this;
    }

    public OpenFileActivityBuilder setActivityTitle(String string2) {
        this.oa = du.f(string2);
        return this;
    }

    public OpenFileActivityBuilder setMimeType(String[] stringArray) {
        boolean bl2 = stringArray != null && stringArray.length > 0;
        du.b(bl2, "mimeTypes may not be null and must contain at least one value");
        this.ol = stringArray;
        return this;
    }
}

