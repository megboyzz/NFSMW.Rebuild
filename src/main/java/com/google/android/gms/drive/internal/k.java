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
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.CloseContentsRequest;
import com.google.android.gms.drive.internal.OnContentsResponse;
import com.google.android.gms.drive.internal.OnDownloadProgressResponse;
import com.google.android.gms.drive.internal.OpenContentsRequest;
import com.google.android.gms.drive.internal.h;
import com.google.android.gms.drive.internal.i;
import com.google.android.gms.drive.internal.j;
import com.google.android.gms.drive.internal.m;
import com.google.android.gms.drive.internal.p;
import com.google.android.gms.drive.internal.z;

public class k
extends m
implements DriveFile {
    public k(DriveId driveId) {
        super(driveId);
    }

    @Override
    public PendingResult<Status, DriveFile.OnContentsClosedCallback> commitAndCloseContents(GoogleApiClient googleApiClient, final Contents contents) {
        if (contents != null) return googleApiClient.b(new a(){

            @Override
            protected void a(j j2) {
                try {
                    contents.close();
                    j2.cu().a(new CloseContentsRequest(contents, true), (p)new z(this));
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
        throw new IllegalArgumentException("Contents must be provided.");
    }

    @Override
    public PendingResult<Status, DriveApi.OnContentsDiscardedCallback> discardContents(GoogleApiClient googleApiClient, Contents contents) {
        return Drive.DriveApi.discardContents(googleApiClient, contents);
    }

    @Override
    public PendingResult<DriveApi.ContentsResult, DriveFile.OnContentsOpenedCallback> openContents(GoogleApiClient googleApiClient, final int n2, final DriveFile.DownloadProgressListener downloadProgressListener) {
        if (n2 == 0x10000000) return googleApiClient.a(new c(){

            @Override
            protected void a(j j2) {
                try {
                    j2.cu().a(new OpenContentsRequest(k.this.getDriveId(), n2), (p)new b(this, downloadProgressListener));
                    return;
                }
                catch (RemoteException remoteException) {
                    this.a(new h.a(new Status(8, remoteException.getLocalizedMessage(), null), null));
                    return;
                }
            }

            @Override
            protected /* synthetic */ void b(Api.a a2) {
                this.a((j)a2);
            }
        });
        if (n2 == 0x20000000) return googleApiClient.a(new /* invalid duplicate definition of identical inner class */);
        if (n2 == 0x30000000) return googleApiClient.a(new /* invalid duplicate definition of identical inner class */);
        throw new IllegalArgumentException("Invalid mode provided.");
    }

    private abstract class a
    extends i<Status, DriveFile.OnContentsClosedCallback> {
        private a() {
        }

        @Override
        protected void a(DriveFile.OnContentsClosedCallback onContentsClosedCallback, Status status) {
            onContentsClosedCallback.onClose(status);
        }

        @Override
        public /* synthetic */ Result b(Status status) {
            return this.e(status);
        }

        public Status e(Status status) {
            return status;
        }
    }

    private static class b
    extends com.google.android.gms.drive.internal.a {
        private final a.c<DriveApi.ContentsResult> jN;
        private final DriveFile.DownloadProgressListener oy;

        public b(a.c<DriveApi.ContentsResult> c2, DriveFile.DownloadProgressListener downloadProgressListener) {
            this.jN = c2;
            this.oy = downloadProgressListener;
        }

        @Override
        public void a(OnContentsResponse onContentsResponse) throws RemoteException {
            this.jN.a(new h.a(Status.kW, onContentsResponse.cx()));
        }

        @Override
        public void a(OnDownloadProgressResponse onDownloadProgressResponse) throws RemoteException {
            if (this.oy == null) return;
            this.oy.onProgress(onDownloadProgressResponse.cy(), onDownloadProgressResponse.cz());
        }

        @Override
        public void d(Status status) throws RemoteException {
            this.jN.a(new h.a(status, null));
        }
    }

    private abstract class c
    extends i<DriveApi.ContentsResult, DriveFile.OnContentsOpenedCallback> {
        private c() {
        }

        @Override
        protected void a(DriveFile.OnContentsOpenedCallback onContentsOpenedCallback, DriveApi.ContentsResult contentsResult) {
            onContentsOpenedCallback.onOpen(contentsResult);
        }

        @Override
        public /* synthetic */ Result b(Status status) {
            return this.f(status);
        }

        public DriveApi.ContentsResult f(Status status) {
            return new h.a(status, null);
        }
    }
}

