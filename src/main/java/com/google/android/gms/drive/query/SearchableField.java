/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.drive.query;

import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.CollectionMetadataField;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.OrderedMetadataField;
import com.google.android.gms.internal.et;
import com.google.android.gms.internal.eu;
import java.util.Date;

public class SearchableField {
    public static final MetadataField<String> MIME_TYPE;
    public static final OrderedMetadataField<Date> MODIFIED_DATE;
    public static final CollectionMetadataField<DriveId> PARENTS;
    public static final MetadataField<Boolean> STARRED;
    public static final MetadataField<String> TITLE;
    public static final MetadataField<Boolean> TRASHED;
    public static final OrderedMetadataField<Date> pa;

    static {
        TITLE = et.TITLE;
        MIME_TYPE = et.MIME_TYPE;
        TRASHED = et.TRASHED;
        PARENTS = et.PARENTS;
        pa = eu.pa;
        STARRED = et.STARRED;
        MODIFIED_DATE = eu.oX;
    }
}

