/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

class d {
    static MetadataField<?> b(MetadataBundle object) {
        if ((object = ((MetadataBundle)object).cF()).size() == 1) return (MetadataField)object.iterator().next();
        throw new IllegalArgumentException("bundle should have exactly 1 populated field");
    }
}

