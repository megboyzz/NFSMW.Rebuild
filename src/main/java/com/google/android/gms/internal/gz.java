/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 */
package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.b;
import com.google.android.gms.internal.gx;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;

public final class gz
extends b
implements Moment {
    private gx AO;

    public gz(DataHolder dataHolder, int n2) {
        super(dataHolder, n2);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private gx eZ() {
        synchronized (this) {
            if (this.AO != null) return this.AO;
            byte[] byArray = this.getByteArray("momentImpl");
            Parcel parcel = Parcel.obtain();
            parcel.unmarshall(byArray, 0, byArray.length);
            parcel.setDataPosition(0);
            this.AO = gx.CREATOR.ak(parcel);
            parcel.recycle();
            return this.AO;
        }
    }

    public gx eY() {
        return this.eZ();
    }

    @Override
    public /* synthetic */ Object freeze() {
        return this.eY();
    }

    @Override
    public String getId() {
        return this.eZ().getId();
    }

    @Override
    public ItemScope getResult() {
        return this.eZ().getResult();
    }

    @Override
    public String getStartDate() {
        return this.eZ().getStartDate();
    }

    @Override
    public ItemScope getTarget() {
        return this.eZ().getTarget();
    }

    @Override
    public String getType() {
        return this.eZ().getType();
    }

    @Override
    public boolean hasId() {
        return this.eZ().hasId();
    }

    @Override
    public boolean hasResult() {
        return this.eZ().hasId();
    }

    @Override
    public boolean hasStartDate() {
        return this.eZ().hasStartDate();
    }

    @Override
    public boolean hasTarget() {
        return this.eZ().hasTarget();
    }

    @Override
    public boolean hasType() {
        return this.eZ().hasType();
    }
}

