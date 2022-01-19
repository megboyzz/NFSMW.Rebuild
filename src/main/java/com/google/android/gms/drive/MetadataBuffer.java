/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.drive;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.b;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.metadata.internal.c;
import java.util.ArrayList;
import java.util.Iterator;

public final class MetadataBuffer
extends DataBuffer<Metadata> {
    private static final String[] oh;
    private final String oi;

    static {
        ArrayList<String> arrayList = new ArrayList<String>();
        Iterator<MetadataField<?>> iterator = c.cD().iterator();
        while (true) {
            if (!iterator.hasNext()) {
                oh = arrayList.toArray(new String[0]);
                return;
            }
            arrayList.addAll(iterator.next().cC());
        }
    }

    public MetadataBuffer(DataHolder dataHolder, String string2) {
        super(dataHolder);
        this.oi = string2;
    }

    @Override
    public Metadata get(int n2) {
        return new a(this.lb, n2);
    }

    public String getNextPageToken() {
        return this.oi;
    }

    private static class a
    extends Metadata {
        private final DataHolder lb;
        private final int le;
        private final int oj;

        public a(DataHolder dataHolder, int n2) {
            this.lb = dataHolder;
            this.oj = n2;
            this.le = dataHolder.t(n2);
        }

        @Override
        protected <T> T a(MetadataField<T> metadataField) {
            return metadataField.c(this.lb, this.oj, this.le);
        }

        public Metadata cr() {
            MetadataBundle metadataBundle = MetadataBundle.cE();
            Iterator<MetadataField<?>> iterator = c.cD().iterator();
            while (iterator.hasNext()) {
                iterator.next().a(this.lb, metadataBundle, this.oj, this.le);
            }
            return new b(metadataBundle);
        }

        @Override
        public /* synthetic */ Object freeze() {
            return this.cr();
        }

        @Override
        public boolean isDataValid() {
            if (this.lb.isClosed()) return false;
            return true;
        }
    }
}

