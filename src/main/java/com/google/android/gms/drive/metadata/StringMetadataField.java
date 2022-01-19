/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.google.android.gms.drive.metadata;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.MetadataField;

public final class StringMetadataField
extends MetadataField<String> {
    public StringMetadataField(String string2) {
        super(string2);
    }

    @Override
    protected void a(Bundle bundle, String string2) {
        bundle.putString(this.getName(), string2);
    }

    @Override
    protected /* synthetic */ Object b(DataHolder dataHolder, int n2, int n3) {
        return this.d(dataHolder, n2, n3);
    }

    protected String d(DataHolder dataHolder, int n2, int n3) {
        return dataHolder.getString(this.getName(), n2, n3);
    }

    @Override
    protected /* synthetic */ Object e(Bundle bundle) {
        return this.f(bundle);
    }

    protected String f(Bundle bundle) {
        return bundle.getString(this.getName());
    }
}

