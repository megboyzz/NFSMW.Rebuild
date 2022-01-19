/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.MetadataField;

public class a
extends MetadataField<Boolean> {
    public a(String string2) {
        super(string2);
    }

    @Override
    protected void a(Bundle bundle, Boolean bl2) {
        bundle.putBoolean(this.getName(), bl2.booleanValue());
    }

    @Override
    protected /* synthetic */ Object b(DataHolder dataHolder, int n2, int n3) {
        return this.e(dataHolder, n2, n3);
    }

    protected Boolean e(DataHolder dataHolder, int n2, int n3) {
        return dataHolder.getBoolean(this.getName(), n2, n3);
    }

    @Override
    protected /* synthetic */ Object e(Bundle bundle) {
        return this.g(bundle);
    }

    protected Boolean g(Bundle bundle) {
        return bundle.getBoolean(this.getName());
    }
}

