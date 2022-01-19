/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.drive;

import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public final class b
extends Metadata {
    private final MetadataBundle oc;

    public b(MetadataBundle metadataBundle) {
        this.oc = metadataBundle;
    }

    @Override
    protected <T> T a(MetadataField<T> metadataField) {
        return this.oc.a(metadataField);
    }

    public Metadata cr() {
        return new b(MetadataBundle.a(this.oc));
    }

    @Override
    public /* synthetic */ Object freeze() {
        return this.cr();
    }

    @Override
    public boolean isDataValid() {
        if (this.oc == null) return false;
        return true;
    }

    public String toString() {
        return "Metadata [mImpl=" + this.oc + "]";
    }
}

