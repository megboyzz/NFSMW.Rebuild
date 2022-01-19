/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 */
package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.internal.CreateFileRequest;
import com.google.android.gms.drive.internal.CreateFolderRequest;
import com.google.android.gms.drive.internal.OnDriveIdResponse;
import com.google.android.gms.drive.internal.h;
import com.google.android.gms.drive.internal.i;
import com.google.android.gms.drive.internal.j;
import com.google.android.gms.drive.internal.k;
import com.google.android.gms.drive.internal.m;
import com.google.android.gms.drive.internal.p;
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
        if (metadataChangeSet == null) {
            throw new IllegalArgumentException("MetatadataChangeSet must be provided.");
        }
        if (contents == null) {
            throw new IllegalArgumentException("Contents must be provided.");
        }
        if (!"application/vnd.google-apps.folder".equals(metadataChangeSet.getMimeType())) return googleApiClient.b(new i<DriveFolder.DriveFileResult, DriveFolder.OnCreateFileCallback>(){

            @Override
            protected void a(DriveFolder.OnCreateFileCallback onCreateFileCallback, DriveFolder.DriveFileResult driveFileResult) {
                onCreateFileCallback.onCreateFile(driveFileResult);
            }

            @Override
            protected void a(j j2) {
                try {
                    contents.close();
                    j2.cu().a(new CreateFileRequest(l.this.getDriveId(), metadataChangeSet.ct(), contents), (p)new a(this));
                    return;
                }
                catch (RemoteException remoteException) {
                    this.a(new d(new Status(8, remoteException.getLocalizedMessage(), null), null));
                    return;
                }
            }

            @Override
            public /* synthetic */ Result b(Status status) {
                return this.h(status);
            }

            @Override
            protected /* synthetic */ void b(Api.a a2) {
                this.a((j)a2);
            }

            public DriveFolder.DriveFileResult h(Status status) {
                return new d(status, null);
            }
        });
        throw new IllegalArgumentException("May not create folders (mimetype: application/vnd.google-apps.folder) using this method. Use DriveFolder.createFolder() instead.");
    }

    @Override
    public PendingResult<DriveFolder.DriveFolderResult, DriveFolder.OnCreateFolderCallback> createFolder(GoogleApiClient googleApiClient, final MetadataChangeSet metadataChangeSet) {
        if (metadataChangeSet == null) {
            throw new IllegalArgumentException("MetatadataChangeSet must be provided.");
        }
        if (metadataChangeSet.getMimeType() == null) return googleApiClient.b(new c(){

            @Override
            protected void a(j j2) {
                try {
                    j2.cu().a(new CreateFolderRequest(l.this.getDriveId(), metadataChangeSet.ct()), (p)new b(this));
                    return;
                }
                catch (RemoteException remoteException) {
                    this.a(new e(new Status(8, remoteException.getLocalizedMessage(), null), null));
                    return;
                }
            }

            @Override
            protected /* synthetic */ void b(Api.a a2) {
                this.a((j)a2);
            }
        });
        if (metadataChangeSet.getMimeType().equals("application/vnd.google-apps.folder")) return googleApiClient.b(new /* invalid duplicate definition of identical inner class */);
        throw new IllegalArgumentException("The mimetype must be of type application/vnd.google-apps.folder");
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
        private final a.c<DriveFolder.DriveFileResult> jN;

        public a(a.c<DriveFolder.DriveFileResult> c2) {
            this.jN = c2;
        }

        @Override
        public void a(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
            this.jN.a(new d(Status.kW, new k(onDriveIdResponse.getDriveId())));
        }

        @Override
        public void d(Status status) throws RemoteException {
            this.jN.a(new d(status, null));
        }
    }

    private static class b
    extends com.google.android.gms.drive.internal.a {
        private final a.c<DriveFolder.DriveFolderResult> jN;

        public b(a.c<DriveFolder.DriveFolderResult> c2) {
            this.jN = c2;
        }

        @Override
        public void a(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
            this.jN.a(new e(Status.kW, new l(onDriveIdResponse.getDriveId())));
        }

        @Override
        public void d(Status status) throws RemoteException {
            this.jN.a(new e(status, null));
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
        public /* synthetic */ Result b(Status status) {
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

