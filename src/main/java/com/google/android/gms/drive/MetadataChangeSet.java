/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.drive;

import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.et;

public final class MetadataChangeSet {
    private final MetadataBundle ok;

    private MetadataChangeSet(MetadataBundle metadataBundle) {
        this.ok = MetadataBundle.a(metadataBundle);
    }

    public MetadataBundle ct() {
        return this.ok;
    }

    public String getMimeType() {
        return this.ok.a(et.MIME_TYPE);
    }

    public String getTitle() {
        return this.ok.a(et.TITLE);
    }

    public Boolean isStarred() {
        return this.ok.a(et.STARRED);
    }

    public static class Builder {
        private final MetadataBundle ok = MetadataBundle.cE();

        public MetadataChangeSet build() {
            return new MetadataChangeSet(this.ok);
        }

        public Builder setMimeType(String string2) {
            this.ok.b(et.MIME_TYPE, string2);
            return this;
        }

        public Builder setStarred(boolean bl2) {
            this.ok.b(et.STARRED, bl2);
            return this;
        }

        public Builder setTitle(String string2) {
            this.ok.b(et.TITLE, string2);
            return this;
        }
    }
}

