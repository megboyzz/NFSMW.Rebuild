/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.drive;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.et;
import com.google.android.gms.internal.eu;
import java.util.Date;

public abstract class Metadata
implements Freezable<Metadata> {
    protected abstract <T> T a(MetadataField<T> var1);

    public Date getCreatedDate() {
        return this.a(eu.oZ);
    }

    public DriveId getDriveId() {
        return this.a(et.oU);
    }

    public String getMimeType() {
        return this.a(et.MIME_TYPE);
    }

    public Date getModifiedByMeDate() {
        return this.a(eu.oY);
    }

    public Date getModifiedDate() {
        return this.a(eu.oX);
    }

    public Date getSharedWithMeDate() {
        return this.a(eu.pa);
    }

    public String getTitle() {
        return this.a(et.TITLE);
    }

    public boolean isEditable() {
        Boolean bl2 = this.a(et.oV);
        if (bl2 != null) return bl2;
        return false;
    }

    public boolean isFolder() {
        return "application/vnd.google-apps.folder".equals(this.getMimeType());
    }

    public boolean isStarred() {
        Boolean bl2 = this.a(et.STARRED);
        if (bl2 != null) return bl2;
        return false;
    }

    public boolean isTrashed() {
        Boolean bl2 = this.a(et.TRASHED);
        if (bl2 != null) return bl2;
        return false;
    }
}

