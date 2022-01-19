/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.plus.model.people;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.c;
import com.google.android.gms.internal.ha;
import com.google.android.gms.internal.hl;
import com.google.android.gms.plus.model.people.Person;

public final class PersonBuffer
extends DataBuffer<Person> {
    private final c<ha> Bz;

    public PersonBuffer(DataHolder dataHolder) {
        super(dataHolder);
        if (dataHolder.getMetadata() != null && dataHolder.getMetadata().getBoolean("com.google.android.gms.plus.IsSafeParcelable", false)) {
            this.Bz = new c<ha>(dataHolder, ha.CREATOR);
            return;
        }
        this.Bz = null;
    }

    @Override
    public Person get(int n2) {
        if (this.Bz == null) return new hl(this.lb, n2);
        return this.Bz.s(n2);
    }
}

