/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.CollectionMetadataField;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.StringMetadataField;
import com.google.android.gms.drive.metadata.internal.a;
import com.google.android.gms.drive.metadata.internal.e;
import com.google.android.gms.internal.ev;

public class et {
    public static final MetadataField<String> MIME_TYPE;
    public static final CollectionMetadataField<DriveId> PARENTS;
    public static final MetadataField<Boolean> STARRED;
    public static final MetadataField<String> TITLE;
    public static final MetadataField<Boolean> TRASHED;
    public static final MetadataField<DriveId> oU;
    public static final MetadataField<Boolean> oV;
    public static final MetadataField<Boolean> oW;

    static {
        oU = ev.pb;
        TITLE = new StringMetadataField("title");
        MIME_TYPE = new StringMetadataField("mimeType");
        STARRED = new a("starred");
        TRASHED = new a("trashed"){

            @Override
            protected /* synthetic */ Object b(DataHolder dataHolder, int n2, int n3) {
                return this.e(dataHolder, n2, n3);
            }

            @Override
            protected Boolean e(DataHolder dataHolder, int n2, int n3) {
                boolean bl2;
                if (dataHolder.getInteger(this.getName(), n2, n3) != 0) {
                    bl2 = true;
                    return bl2;
                }
                bl2 = false;
                return bl2;
            }
        };
        oV = new a("isEditable");
        oW = new a("isPinned");
        PARENTS = new e<DriveId>("parents");
    }
}

