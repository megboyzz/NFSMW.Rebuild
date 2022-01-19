/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 */
package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.gv;
import com.google.android.gms.internal.gy;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class gx
extends ee
implements SafeParcelable,
Moment {
    public static final gy CREATOR = new gy();
    private static final HashMap<String, ee.a<?, ?>> zP = new HashMap();
    private String AE;
    private gv AM;
    private gv AN;
    private final int kZ;
    private String wF;
    private String wJ;
    private final Set<Integer> zQ;

    static {
        zP.put("id", ee.a.f("id", 2));
        zP.put("result", ee.a.a("result", 4, gv.class));
        zP.put("startDate", ee.a.f("startDate", 5));
        zP.put("target", ee.a.a("target", 6, gv.class));
        zP.put("type", ee.a.f("type", 7));
    }

    public gx() {
        this.kZ = 1;
        this.zQ = new HashSet<Integer>();
    }

    gx(Set<Integer> set, int n2, String string2, gv gv2, String string3, gv gv3, String string4) {
        this.zQ = set;
        this.kZ = n2;
        this.wJ = string2;
        this.AM = gv2;
        this.AE = string3;
        this.AN = gv3;
        this.wF = string4;
    }

    public gx(Set<Integer> set, String string2, gv gv2, String string3, gv gv3, String string4) {
        this.zQ = set;
        this.kZ = 1;
        this.wJ = string2;
        this.AM = gv2;
        this.AE = string3;
        this.AN = gv3;
        this.wF = string4;
    }

    @Override
    protected Object J(String string2) {
        return null;
    }

    @Override
    protected boolean K(String string2) {
        return false;
    }

    @Override
    protected boolean a(ee.a a2) {
        return this.zQ.contains(a2.bX());
    }

    @Override
    protected Object b(ee.a a2) {
        switch (a2.bX()) {
            default: {
                throw new IllegalStateException("Unknown safe parcelable id=" + a2.bX());
            }
            case 2: {
                return this.wJ;
            }
            case 4: {
                return this.AM;
            }
            case 5: {
                return this.AE;
            }
            case 6: {
                return this.AN;
            }
            case 7: 
        }
        return this.wF;
    }

    @Override
    public HashMap<String, ee.a<?, ?>> bQ() {
        return zP;
    }

    public int describeContents() {
        gy gy2 = CREATOR;
        return 0;
    }

    Set<Integer> eF() {
        return this.zQ;
    }

    gv eW() {
        return this.AM;
    }

    gv eX() {
        return this.AN;
    }

    public gx eY() {
        return this;
    }

    public boolean equals(Object object) {
        if (!(object instanceof gx)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        object = (gx)object;
        Iterator<ee.a<?, ?>> iterator = zP.values().iterator();
        while (iterator.hasNext()) {
            ee.a<?, ?> a2 = iterator.next();
            if (this.a(a2)) {
                if (!((gx)object).a(a2)) return false;
                if (this.b(a2).equals(((gx)object).b(a2))) continue;
                return false;
            }
            if (((gx)object).a(a2)) return false;
        }
        return true;
    }

    @Override
    public /* synthetic */ Object freeze() {
        return this.eY();
    }

    @Override
    public String getId() {
        return this.wJ;
    }

    @Override
    public ItemScope getResult() {
        return this.AM;
    }

    @Override
    public String getStartDate() {
        return this.AE;
    }

    @Override
    public ItemScope getTarget() {
        return this.AN;
    }

    @Override
    public String getType() {
        return this.wF;
    }

    int getVersionCode() {
        return this.kZ;
    }

    @Override
    public boolean hasId() {
        return this.zQ.contains(2);
    }

    @Override
    public boolean hasResult() {
        return this.zQ.contains(4);
    }

    @Override
    public boolean hasStartDate() {
        return this.zQ.contains(5);
    }

    @Override
    public boolean hasTarget() {
        return this.zQ.contains(6);
    }

    @Override
    public boolean hasType() {
        return this.zQ.contains(7);
    }

    public int hashCode() {
        Iterator<ee.a<?, ?>> iterator = zP.values().iterator();
        int n2 = 0;
        while (iterator.hasNext()) {
            ee.a<?, ?> a2 = iterator.next();
            if (!this.a(a2)) continue;
            int n3 = a2.bX();
            n2 = this.b(a2).hashCode() + (n2 + n3);
        }
        return n2;
    }

    @Override
    public boolean isDataValid() {
        return true;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        gy gy2 = CREATOR;
        gy.a(this, parcel, n2);
    }
}

