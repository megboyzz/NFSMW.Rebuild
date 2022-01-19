/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.drive.metadata;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.MetadataField;
import java.util.Collection;

public abstract class CollectionMetadataField<T>
extends MetadataField<Collection<T>> {
    protected CollectionMetadataField(String string2) {
        super(string2);
    }

    protected Collection<T> a(DataHolder dataHolder, int n2, int n3) {
        throw new UnsupportedOperationException("Cannot read collections from a dataHolder.");
    }

    @Override
    protected /* synthetic */ Object b(DataHolder dataHolder, int n2, int n3) {
        return this.a(dataHolder, n2, n3);
    }
}

