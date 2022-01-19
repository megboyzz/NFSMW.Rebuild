/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.OrderedMetadataField;
import java.util.Date;

public class b
extends OrderedMetadataField<Date> {
    public b(String string2) {
        super(string2);
    }

    @Override
    protected void a(Bundle bundle, Date date) {
        bundle.putLong(this.getName(), date.getTime());
    }

    @Override
    protected /* synthetic */ Object b(DataHolder dataHolder, int n2, int n3) {
        return this.f(dataHolder, n2, n3);
    }

    @Override
    protected /* synthetic */ Object e(Bundle bundle) {
        return this.h(bundle);
    }

    protected Date f(DataHolder dataHolder, int n2, int n3) {
        return new Date(dataHolder.getLong(this.getName(), n2, n3));
    }

    protected Date h(Bundle bundle) {
        return new Date(bundle.getLong(this.getName()));
    }
}

