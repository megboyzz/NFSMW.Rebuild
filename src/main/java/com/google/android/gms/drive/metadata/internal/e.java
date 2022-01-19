/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcelable
 */
package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.drive.metadata.CollectionMetadataField;
import java.util.ArrayList;
import java.util.Collection;

public class e<T extends Parcelable>
extends CollectionMetadataField<T> {
    public e(String string2) {
        super(string2);
    }

    @Override
    protected void a(Bundle bundle, Collection<T> collection) {
        bundle.putParcelableArrayList(this.getName(), new ArrayList<T>(collection));
    }

    @Override
    protected /* synthetic */ Object e(Bundle bundle) {
        return this.i(bundle);
    }

    protected Collection<T> i(Bundle bundle) {
        return bundle.getParcelableArrayList(this.getName());
    }
}

