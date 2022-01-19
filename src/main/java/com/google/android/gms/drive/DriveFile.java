/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveResource;

public interface DriveFile
extends DriveResource {
    public static final int MODE_READ_ONLY = 0x10000000;
    public static final int MODE_READ_WRITE = 0x30000000;
    public static final int MODE_WRITE_ONLY = 0x20000000;

    public PendingResult<Status, OnContentsClosedCallback> commitAndCloseContents(GoogleApiClient var1, Contents var2);

    public PendingResult<Status, DriveApi.OnContentsDiscardedCallback> discardContents(GoogleApiClient var1, Contents var2);

    public PendingResult<DriveApi.ContentsResult, OnContentsOpenedCallback> openContents(GoogleApiClient var1, int var2, DownloadProgressListener var3);

    public static interface DownloadProgressListener {
        public void onProgress(long var1, long var3);
    }

    public static interface OnContentsClosedCallback {
        public void onClose(Status var1);
    }

    public static interface OnContentsOpenedCallback {
        public void onOpen(DriveApi.ContentsResult var1);
    }
}

