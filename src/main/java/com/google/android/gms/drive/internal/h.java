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
import com.google.android.gms.drive.CreateFileActivityBuilder;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.OpenFileActivityBuilder;
import com.google.android.gms.drive.internal.CloseContentsRequest;
import com.google.android.gms.drive.internal.CreateContentsRequest;
import com.google.android.gms.drive.internal.OnContentsResponse;
import com.google.android.gms.drive.internal.OnListEntriesResponse;
import com.google.android.gms.drive.internal.QueryRequest;
import com.google.android.gms.drive.internal.i;
import com.google.android.gms.drive.internal.j;
import com.google.android.gms.drive.internal.k;
import com.google.android.gms.drive.internal.l;
import com.google.android.gms.drive.internal.p;
import com.google.android.gms.drive.internal.z;
import com.google.android.gms.drive.query.Query;

public class h
implements DriveApi {
    @Override
    public PendingResult<Status, DriveApi.OnContentsDiscardedCallback> discardContents(GoogleApiClient googleApiClient, final Contents contents) {
        return googleApiClient.b(new b(){

            @Override
            protected void a(j j2) {
                try {
                    j2.cu().a(new CloseContentsRequest(contents, false), (p)new z(this));
                    return;
                }
                catch (RemoteException remoteException) {
                    this.a(new Status(8, remoteException.getLocalizedMessage(), null));
                    return;
                }
            }

            @Override
            protected /* synthetic */ void b(Api.a a2) {
                this.a((j)a2);
            }
        });
    }

    @Override
    public DriveFile getFile(GoogleApiClient googleApiClient, DriveId driveId) {
        if (driveId == null) {
            throw new IllegalArgumentException("Id must be provided.");
        }
        if (googleApiClient.isConnected()) return new k(driveId);
        throw new IllegalStateException("Client must be connected");
    }

    @Override
    public DriveFolder getFolder(GoogleApiClient googleApiClient, DriveId driveId) {
        if (driveId == null) {
            throw new IllegalArgumentException("Id must be provided.");
        }
        if (googleApiClient.isConnected()) return new l(driveId);
        throw new IllegalStateException("Client must be connected");
    }

    @Override
    public DriveFolder getRootFolder(GoogleApiClient googleApiClient) {
        if (googleApiClient.isConnected()) return new l(((j)((Object)googleApiClient.a(Drive.jL))).cv());
        throw new IllegalStateException("Client must be connected");
    }

    @Override
    public PendingResult<DriveApi.ContentsResult, DriveApi.OnNewContentsCallback> newContents(GoogleApiClient googleApiClient) {
        return googleApiClient.a(new e(){

            @Override
            protected void a(j j2) {
                try {
                    j2.cu().a(new CreateContentsRequest(), (p)new d(this));
                    return;
                }
                catch (RemoteException remoteException) {
                    this.a(new a(new Status(8, remoteException.getLocalizedMessage(), null), null));
                    return;
                }
            }

            @Override
            protected /* synthetic */ void b(Api.a a2) {
                this.a((j)a2);
            }
        });
    }

    @Override
    public CreateFileActivityBuilder newCreateFileActivityBuilder() {
        return new CreateFileActivityBuilder();
    }

    @Override
    public OpenFileActivityBuilder newOpenFileActivityBuilder() {
        return new OpenFileActivityBuilder();
    }

    @Override
    public PendingResult<DriveApi.MetadataBufferResult, DriveFolder.OnChildrenRetrievedCallback> query(GoogleApiClient googleApiClient, final Query query) {
        if (query != null) return googleApiClient.a(new g(){

            @Override
            protected void a(j j2) {
                try {
                    j2.cu().a(new QueryRequest(query), (p)new f(this));
                    return;
                }
                catch (RemoteException remoteException) {
                    this.a(new c(new Status(8, remoteException.getLocalizedMessage(), null), null));
                    return;
                }
            }

            @Override
            protected /* synthetic */ void b(Api.a a2) {
                this.a((j)a2);
            }
        });
        throw new IllegalArgumentException("Query must be provided.");
    }

    @Override
    public PendingResult<Status, DriveApi.OnSyncFinishCallback> requestSync(GoogleApiClient googleApiClient) {
        return googleApiClient.b(new h(){

            @Override
            protected void a(j j2) {
                try {
                    j2.cu().a(new z(this));
                    return;
                }
                catch (RemoteException remoteException) {
                    this.a(new Status(8, remoteException.getLocalizedMessage(), null));
                    return;
                }
            }

            @Override
            protected /* synthetic */ void b(Api.a a2) {
                this.a((j)a2);
            }
        });
    }

    static class a
    implements DriveApi.ContentsResult {
        private final Status jP;
        private final Contents nZ;

        public a(Status status, Contents contents) {
            this.jP = status;
            this.nZ = contents;
        }

        @Override
        public Contents getContents() {
            return this.nZ;
        }

        @Override
        public Status getStatus() {
            return this.jP;
        }
    }

    abstract class b
    extends i<Status, DriveApi.OnContentsDiscardedCallback> {
        b() {
        }

        @Override
        protected void a(DriveApi.OnContentsDiscardedCallback onContentsDiscardedCallback, Status status) {
            onContentsDiscardedCallback.onContentsDiscarded(status);
        }

        @Override
        public /* synthetic */ Result b(Status status) {
            return this.e(status);
        }

        public Status e(Status status) {
            return status;
        }
    }

    static class c
    implements DriveApi.MetadataBufferResult {
        private final Status jP;
        private final MetadataBuffer ot;

        public c(Status status, MetadataBuffer metadataBuffer) {
            this.jP = status;
            this.ot = metadataBuffer;
        }

        @Override
        public MetadataBuffer getMetadataBuffer() {
            return this.ot;
        }

        @Override
        public Status getStatus() {
            return this.jP;
        }
    }

    private static class d
    extends com.google.android.gms.drive.internal.a {
        private final a.c<DriveApi.ContentsResult> jN;

        public d(a.c<DriveApi.ContentsResult> c2) {
            this.jN = c2;
        }

        @Override
        public void a(OnContentsResponse onContentsResponse) throws RemoteException {
            this.jN.a(new a(Status.kW, onContentsResponse.cx()));
        }

        @Override
        public void d(Status status) throws RemoteException {
            this.jN.a(new a(status, null));
        }
    }

    abstract class e
    extends i<DriveApi.ContentsResult, DriveApi.OnNewContentsCallback> {
        e() {
        }

        @Override
        protected void a(DriveApi.OnNewContentsCallback onNewContentsCallback, DriveApi.ContentsResult contentsResult) {
            onNewContentsCallback.onNewContents(contentsResult);
        }

        @Override
        public /* synthetic */ Result b(Status status) {
            return this.f(status);
        }

        public DriveApi.ContentsResult f(Status status) {
            return new a(status, null);
        }
    }

    static class f
    extends com.google.android.gms.drive.internal.a {
        private final a.c<DriveApi.MetadataBufferResult> jN;

        public f(a.c<DriveApi.MetadataBufferResult> c2) {
            this.jN = c2;
        }

        @Override
        public void a(OnListEntriesResponse object) throws RemoteException {
            object = new MetadataBuffer(((OnListEntriesResponse)object).cA(), null);
            this.jN.a(new c(Status.kW, (MetadataBuffer)object));
        }

        @Override
        public void d(Status status) throws RemoteException {
            this.jN.a(new c(status, null));
        }
    }

    abstract class g
    extends i<DriveApi.MetadataBufferResult, DriveFolder.OnChildrenRetrievedCallback> {
        g() {
        }

        @Override
        protected void a(DriveFolder.OnChildrenRetrievedCallback onChildrenRetrievedCallback, DriveApi.MetadataBufferResult metadataBufferResult) {
            onChildrenRetrievedCallback.onChildrenRetrieved(metadataBufferResult);
        }

        @Override
        public /* synthetic */ Result b(Status status) {
            return this.g(status);
        }

        public DriveApi.MetadataBufferResult g(Status status) {
            return new c(status, null);
        }
    }

    abstract class h
    extends i<Status, DriveApi.OnSyncFinishCallback> {
        h() {
        }

        @Override
        protected void a(DriveApi.OnSyncFinishCallback onSyncFinishCallback, Status status) {
            onSyncFinishCallback.onSyncFinish(status);
        }

        @Override
        public /* synthetic */ Result b(Status status) {
            return this.e(status);
        }

        public Status e(Status status) {
            return status;
        }
    }
}

