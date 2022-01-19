/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.et;
import com.google.android.gms.internal.eu;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class c {
    private static Map<String, MetadataField<?>> oS = new HashMap();

    static {
        c.b(et.oU);
        c.b(et.TITLE);
        c.b(et.MIME_TYPE);
        c.b(et.STARRED);
        c.b(et.TRASHED);
        c.b(et.oV);
        c.b(et.oW);
        c.b(et.PARENTS);
        c.b(eu.oZ);
        c.b(eu.oX);
        c.b(eu.oY);
        c.b(eu.pa);
    }

    public static MetadataField<?> P(String string2) {
        return oS.get(string2);
    }

    private static void b(MetadataField<?> metadataField) {
        if (oS.containsKey(metadataField.getName())) {
            throw new IllegalArgumentException("Duplicate field name registered: " + metadataField.getName());
        }
        oS.put(metadataField.getName(), metadataField);
    }

    public static Collection<MetadataField<?>> cD() {
        return Collections.unmodifiableCollection(oS.values());
    }
}

