/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.google.android.gms.drive.metadata;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.du;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public abstract class MetadataField<T> {
    private final String oQ;
    private final Set<String> oR;

    protected MetadataField(String string2) {
        this.oQ = du.c(string2, "fieldName");
        this.oR = Collections.singleton(string2);
    }

    protected MetadataField(String string2, Collection<String> collection) {
        this.oQ = du.c(string2, "fieldName");
        this.oR = Collections.unmodifiableSet(new HashSet<String>(collection));
    }

    protected abstract void a(Bundle var1, T var2);

    public final void a(DataHolder dataHolder, MetadataBundle metadataBundle, int n2, int n3) {
        du.c(dataHolder, "dataHolder");
        du.c(metadataBundle, "bundle");
        metadataBundle.b(this, this.c(dataHolder, n2, n3));
    }

    public final void a(T t2, Bundle bundle) {
        du.c(bundle, "bundle");
        if (t2 == null) {
            bundle.putString(this.getName(), null);
            return;
        }
        this.a(bundle, t2);
    }

    protected abstract T b(DataHolder var1, int var2, int var3);

    public final T c(DataHolder dataHolder, int n2, int n3) {
        Iterator<String> iterator = this.oR.iterator();
        do {
            if (!iterator.hasNext()) return this.b(dataHolder, n2, n3);
        } while (!dataHolder.hasNull(iterator.next(), n2, n3));
        return null;
    }

    public final Collection<String> cC() {
        return this.oR;
    }

    public final T d(Bundle bundle) {
        du.c(bundle, "bundle");
        if (bundle.get(this.getName()) == null) return null;
        return this.e(bundle);
    }

    protected abstract T e(Bundle var1);

    public final String getName() {
        return this.oQ;
    }

    public String toString() {
        return this.oQ;
    }
}

