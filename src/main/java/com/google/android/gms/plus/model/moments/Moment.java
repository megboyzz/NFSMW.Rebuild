/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.internal.gv;
import com.google.android.gms.internal.gx;
import com.google.android.gms.plus.model.moments.ItemScope;
import java.util.HashSet;
import java.util.Set;

public interface Moment
extends Freezable<Moment> {
    public String getId();

    public ItemScope getResult();

    public String getStartDate();

    public ItemScope getTarget();

    public String getType();

    public boolean hasId();

    public boolean hasResult();

    public boolean hasStartDate();

    public boolean hasTarget();

    public boolean hasType();

    public static class Builder {
        private String AE;
        private gv AM;
        private gv AN;
        private String wF;
        private String wJ;
        private final Set<Integer> zQ = new HashSet<Integer>();

        public Moment build() {
            return new gx(this.zQ, this.wJ, this.AM, this.AE, this.AN, this.wF);
        }

        public Builder setId(String string2) {
            this.wJ = string2;
            this.zQ.add(2);
            return this;
        }

        public Builder setResult(ItemScope itemScope) {
            this.AM = (gv)itemScope;
            this.zQ.add(4);
            return this;
        }

        public Builder setStartDate(String string2) {
            this.AE = string2;
            this.zQ.add(5);
            return this;
        }

        public Builder setTarget(ItemScope itemScope) {
            this.AN = (gv)itemScope;
            this.zQ.add(6);
            return this;
        }

        public Builder setType(String string2) {
            this.wF = string2;
            this.zQ.add(7);
            return this;
        }
    }
}

