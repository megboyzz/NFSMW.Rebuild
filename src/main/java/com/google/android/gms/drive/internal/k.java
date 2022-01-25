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
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveId;

import java.util.concurrent.TimeUnit;

public class k
        extends m
        implements DriveFile {
    public k(DriveId driveId) {
        super(driveId);
    }

    @Override
    public PendingResult<Status, DriveFile.OnContentsClosedCallback> commitAndCloseContents(GoogleApiClient googleApiClient, final Contents contents) {
        return new PendingResult<Status, OnContentsClosedCallback>() {
            @Override
            public void addResultCallback(OnContentsClosedCallback var1) {

            }

            @Override
            public Status await() {
                return new Status();
            }

            @Override
            public Status await(long var1, TimeUnit var3) {
                return new Status();
            }

            @Override
            public Status b(Status var1) {
                return new Status();
            }

            @Override
            public void release() {

            }
        };
    }

    @Override
    public PendingResult<Status, DriveApi.OnContentsDiscardedCallback> discardContents(GoogleApiClient googleApiClient, Contents contents) {
        return Drive.DriveApi.discardContents(googleApiClient, contents);
    }

    @Override
    public PendingResult<DriveApi.ContentsResult, DriveFile.OnContentsOpenedCallback> openContents(GoogleApiClient googleApiClient, final int n2, final DriveFile.DownloadProgressListener downloadProgressListener) {
        return new PendingResult<DriveApi.ContentsResult, OnContentsOpenedCallback>() {
            @Override
            public void addResultCallback(OnContentsOpenedCallback var1) {

            }

            @Override
            public DriveApi.ContentsResult await() {
                return null;
            }

            @Override
            public DriveApi.ContentsResult await(long var1, TimeUnit var3) {
                return null;
            }

            @Override
            public DriveApi.ContentsResult b(Status var1) {
                return null;
            }

            @Override
            public void release() {

            }
        };
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
        public /* synthetic */ Status b(Status status) {
            return this.e(status);
        }

        public Status e(Status status) {
            return status;
        }
    }

    private static class b
            extends com.google.android.gms.drive.internal.a {
        private final Object jN = new Object();
        private final DriveFile.DownloadProgressListener oy = (var1, var3) -> {};

        public b(Object c2, DriveFile.DownloadProgressListener downloadProgressListener) {
            Observer.onCallingMethod(Observer.Method.VERY_SUSPICIOUS_METHOD, Observer.Method.HARD_TO_RECOVER_LOGIC);
        }

        @Override
        public void a(OnContentsResponse onContentsResponse) throws RemoteException {
        }

        @Override
        public void a(OnDownloadProgressResponse onDownloadProgressResponse) throws RemoteException {
            if (this.oy == null) return;
            this.oy.onProgress(onDownloadProgressResponse.cy(), onDownloadProgressResponse.cz());
        }

        @Override
        public void d(Status status) throws RemoteException {
            Observer.onCallingMethod(Observer.Method.VERY_SUSPICIOUS_METHOD, Observer.Method.HARD_TO_RECOVER_LOGIC);
        }
    }

    private abstract static class c
            extends i<DriveApi.ContentsResult, DriveFile.OnContentsOpenedCallback> {
        private c() {
        }

        @Override
        protected void a(DriveFile.OnContentsOpenedCallback onContentsOpenedCallback, DriveApi.ContentsResult contentsResult) {
            onContentsOpenedCallback.onOpen(contentsResult);
        }

        @Override
        public /* synthetic */ DriveApi.ContentsResult b(Status status) {
            return this.f(status);
        }

        public DriveApi.ContentsResult f(Status status) {
            return new h.a(status, null);
        }
    }
}

