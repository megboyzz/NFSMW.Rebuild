/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.drive.metadata;

import com.google.android.gms.drive.metadata.MetadataField;
import java.util.Collection;

public abstract class OrderedMetadataField<T extends Comparable<T>>
extends MetadataField<T> {
    protected OrderedMetadataField(String string2) {
        super(string2);
    }

    protected OrderedMetadataField(String string2, Collection<String> collection) {
        super(string2, collection);
    }
}

