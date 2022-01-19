/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.MetadataChangeSet;

public interface DriveResource {
    public DriveId getDriveId();

    public PendingResult<MetadataResult, OnMetadataRetrievedCallback> getMetadata(GoogleApiClient var1);

    public PendingResult<MetadataResult, OnMetadataUpdatedCallback> updateMetadata(GoogleApiClient var1, MetadataChangeSet var2);

    public static interface MetadataResult
    extends Result {
        public Metadata getMetadata();
    }

    public static interface OnMetadataRetrievedCallback {
        public void onMetadataRetrieved(MetadataResult var1);
    }

    public static interface OnMetadataUpdatedCallback {
        public void onMetadataUpdated(MetadataResult var1);
    }
}

