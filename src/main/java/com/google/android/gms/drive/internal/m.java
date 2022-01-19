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
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.internal.GetMetadataRequest;
import com.google.android.gms.drive.internal.OnMetadataResponse;
import com.google.android.gms.drive.internal.UpdateMetadataRequest;
import com.google.android.gms.drive.internal.g;
import com.google.android.gms.drive.internal.i;
import com.google.android.gms.drive.internal.j;
import com.google.android.gms.drive.internal.p;

public class m
implements DriveResource {
    private final DriveId nV;

    public m(DriveId driveId) {
        this.nV = driveId;
    }

    @Override
    public DriveId getDriveId() {
        return this.nV;
    }

    @Override
    public PendingResult<DriveResource.MetadataResult, DriveResource.OnMetadataRetrievedCallback> getMetadata(GoogleApiClient googleApiClient) {
        return googleApiClient.a(new a(){

            @Override
            protected void a(j j2) {
                try {
                    j2.cu().a(new GetMetadataRequest(m.this.nV), (p)new b(this));
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
    }

    @Override
    public PendingResult<DriveResource.MetadataResult, DriveResource.OnMetadataUpdatedCallback> updateMetadata(GoogleApiClient googleApiClient, final MetadataChangeSet metadataChangeSet) {
        if (metadataChangeSet != null) return googleApiClient.b(new d(){

            @Override
            protected void a(j j2) {
                try {
                    j2.cu().a(new UpdateMetadataRequest(m.this.nV, metadataChangeSet.ct()), (p)new b(this));
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
        throw new IllegalArgumentException("ChangeSet must be provided.");
    }

    private abstract class a
    extends i<DriveResource.MetadataResult, DriveResource.OnMetadataRetrievedCallback> {
        private a() {
        }

        @Override
        protected void a(DriveResource.OnMetadataRetrievedCallback onMetadataRetrievedCallback, DriveResource.MetadataResult metadataResult) {
            onMetadataRetrievedCallback.onMetadataRetrieved(metadataResult);
        }

        @Override
        public /* synthetic */ Result b(Status status) {
            return this.j(status);
        }

        public DriveResource.MetadataResult j(Status status) {
            return new c(status, null);
        }
    }

    private static class b
    extends com.google.android.gms.drive.internal.a {
        private final a.c<DriveResource.MetadataResult> jN;

        public b(a.c<DriveResource.MetadataResult> c2) {
            this.jN = c2;
        }

        @Override
        public void a(OnMetadataResponse onMetadataResponse) throws RemoteException {
            this.jN.a(new c(Status.kW, new g(onMetadataResponse.cB())));
        }

        @Override
        public void d(Status status) throws RemoteException {
            this.jN.a(new c(status, null));
        }
    }

    private static class c
    implements DriveResource.MetadataResult {
        private final Status jP;
        private final Metadata oE;

        public c(Status status, Metadata metadata) {
            this.jP = status;
            this.oE = metadata;
        }

        @Override
        public Metadata getMetadata() {
            return this.oE;
        }

        @Override
        public Status getStatus() {
            return this.jP;
        }
    }

    private abstract class d
    extends i<DriveResource.MetadataResult, DriveResource.OnMetadataUpdatedCallback> {
        private d() {
        }

        @Override
        protected void a(DriveResource.OnMetadataUpdatedCallback onMetadataUpdatedCallback, DriveResource.MetadataResult metadataResult) {
            onMetadataUpdatedCallback.onMetadataUpdated(metadataResult);
        }

        @Override
        public /* synthetic */ Result b(Status status) {
            return this.j(status);
        }

        public DriveResource.MetadataResult j(Status status) {
            return new c(status, null);
        }
    }
}

