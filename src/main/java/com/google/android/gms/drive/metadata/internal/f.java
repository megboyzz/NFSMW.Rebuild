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
import com.google.android.gms.drive.metadata.MetadataField;
import java.util.Collection;

public abstract class f<T extends Parcelable>
extends MetadataField<T> {
    public f(String string2, Collection<String> collection) {
        super(string2, collection);
    }

    @Override
    protected void a(Bundle bundle, T t2) {
        bundle.putParcelable(this.getName(), t2);
    }

    @Override
    protected /* synthetic */ Object e(Bundle bundle) {
        return this.j(bundle);
    }

    protected T j(Bundle bundle) {
        return (T)bundle.getParcelable(this.getName());
    }
}

