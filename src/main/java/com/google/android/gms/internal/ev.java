/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.f;
import java.util.Arrays;

public class ev
extends f<DriveId> {
    public static final ev pb = new ev();

    private ev() {
        super("driveId", Arrays.asList("sqlId", "resourceId"));
    }

    @Override
    protected /* synthetic */ Object b(DataHolder dataHolder, int n2, int n3) {
        return this.g(dataHolder, n2, n3);
    }

    protected DriveId g(DataHolder dataHolder, int n2, int n3) {
        String string2;
        long l2 = dataHolder.getMetadata().getLong("dbInstanceId");
        String string3 = string2 = dataHolder.getString("resourceId", n2, n3);
        if (string2 == null) return new DriveId(string3, dataHolder.getLong("sqlId", n2, n3), l2);
        string3 = string2;
        if (!string2.startsWith("generated-android-")) return new DriveId(string3, dataHolder.getLong("sqlId", n2, n3), l2);
        string3 = null;
        return new DriveId(string3, dataHolder.getLong("sqlId", n2, n3), l2);
    }
}

