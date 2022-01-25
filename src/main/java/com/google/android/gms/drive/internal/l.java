/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 */
package com.google.android.gms.drive.internal;

import android.os.RemoteException;

import com.ea.ironmonkey.devmenu.util.Observer;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.query.Filters;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.drive.query.SearchableField;

public class l
extends m
implements DriveFolder {
    public l(DriveId driveId) {
        super(driveId);
    }

    @Override
    public PendingResult<DriveFolder.DriveFileResult, DriveFolder.OnCreateFileCallback> createFile(GoogleApiClient googleApiClient, final MetadataChangeSet metadataChangeSet, final Contents contents) {
        Observer.onCallingMethod(
                Observer.Method.HARD_TO_RECOVER_LOGIC,
                Observer.Method.HAZARD_METHOD);

        if (metadataChangeSet == null) {
            throw new IllegalArgumentException("MetatadataChangeSet must be provided.");
        }
        if (contents == null) {
            throw new IllegalArgumentException("Contents must be provided.");
        }
        throw new IllegalArgumentException("May not create folders (mimetype: application/vnd.google-apps.folder) using this method. Use DriveFolder.createFolder() instead.");
    }

    @Override
    public PendingResult<DriveFolder.DriveFolderResult, DriveFolder.OnCreateFolderCallback> createFolder(GoogleApiClient googleApiClient, final MetadataChangeSet metadataChangeSet) {
        Observer.onCallingMethod(
                Observer.Method.HARD_TO_RECOVER_LOGIC,
                Observer.Method.VERY_SUSPICIOUS_METHOD,
                Observer.Method.RETURN_NULL);
        return null;
    }

    @Override
    public PendingResult<DriveApi.MetadataBufferResult, DriveFolder.OnChildrenRetrievedCallback> listChildren(GoogleApiClient googleApiClient) {
        return this.queryChildren(googleApiClient, null);
    }

    @Override
    public PendingResult<DriveApi.MetadataBufferResult, DriveFolder.OnChildrenRetrievedCallback> queryChildren(GoogleApiClient googleApiClient, Query query) {
        Query.Builder builder = new Query.Builder().addFilter(Filters.in(SearchableField.PARENTS, this.getDriveId()));
        if (query == null) return new h().query(googleApiClient, builder.build());
        if (query.getFilter() != null) {
            builder.addFilter(query.getFilter());
        }
        builder.setPageToken(query.getPageToken());
        return new h().query(googleApiClient, builder.build());
    }

    private static class a
    extends com.google.android.gms.drive.internal.a {
        private final Object jN;

        public a(Object c2) {
            this.jN = c2;
        }

        @Override
        public void a(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
            Observer.onCallingMethod(
                    Observer.Method.HARD_TO_RECOVER_LOGIC,
                    Observer.Method.VERY_SUSPICIOUS_METHOD);
        }

        @Override
        public void d(Status status) throws RemoteException {
            Observer.onCallingMethod(
                    Observer.Method.HARD_TO_RECOVER_LOGIC,
                    Observer.Method.VERY_SUSPICIOUS_METHOD);
        }
    }

    private static class b
    extends com.google.android.gms.drive.internal.a {
        private final Object jN;

        public b(Object c2) {
            this.jN = c2;
        }

        @Override
        public void a(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
            Observer.onCallingMethod(
                    Observer.Method.HARD_TO_RECOVER_LOGIC,
                    Observer.Method.VERY_SUSPICIOUS_METHOD);
        }

        @Override
        public void d(Status status) throws RemoteException {
            Observer.onCallingMethod(
                    Observer.Method.HARD_TO_RECOVER_LOGIC,
                    Observer.Method.VERY_SUSPICIOUS_METHOD);
        }
    }

    private abstract class c
    extends i<DriveFolder.DriveFolderResult, DriveFolder.OnCreateFolderCallback> {
        private c() {
        }

        @Override
        protected void a(DriveFolder.OnCreateFolderCallback onCreateFolderCallback, DriveFolder.DriveFolderResult driveFolderResult) {
            onCreateFolderCallback.onCreateFolder(driveFolderResult);
        }

        @Override
        public /* synthetic */ DriveFolderResult b(Status status) {
            return this.i(status);
        }

        public DriveFolder.DriveFolderResult i(Status status) {
            return new e(status, null);
        }
    }

    private static class d
    implements DriveFolder.DriveFileResult {
        private final Status jP;
        private final DriveFile oB;

        public d(Status status, DriveFile driveFile) {
            this.jP = status;
            this.oB = driveFile;
        }

        @Override
        public DriveFile getDriveFile() {
            return this.oB;
        }

        @Override
        public Status getStatus() {
            return this.jP;
        }
    }

    private static class e
    implements DriveFolder.DriveFolderResult {
        private final Status jP;
        private final DriveFolder oC;

        public e(Status status, DriveFolder driveFolder) {
            this.jP = status;
            this.oC = driveFolder;
        }

        @Override
        public DriveFolder getDriveFolder() {
            return this.oC;
        }

        @Override
        public Status getStatus() {
            return this.jP;
        }
    }
}

