/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.internal.h;

public class Operator
implements SafeParcelable {
    public static final Parcelable.Creator<Operator> CREATOR = new h();
    public static final Operator pr = new Operator("=");
    public static final Operator ps = new Operator("<");
    public static final Operator pt = new Operator("<=");
    public static final Operator pu = new Operator(">");
    public static final Operator pv = new Operator(">=");
    public static final Operator pw = new Operator("and");
    public static final Operator px = new Operator("or");
    public static final Operator py = new Operator("not");
    public static final Operator pz = new Operator("contains");
    final int kZ;
    final String mTag;

    Operator(int n2, String string2) {
        this.kZ = n2;
        this.mTag = string2;
    }

    private Operator(String string2) {
        this(1, string2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        object = (Operator)object;
        if (this.mTag == null) {
            if (((Operator)object).mTag == null) return true;
            return false;
        }
        if (this.mTag.equals(((Operator)object).mTag)) return true;
        return false;
    }

    public int hashCode() {
        if (this.mTag == null) {
            return 31;
        }
        int n2 = this.mTag.hashCode();
        return n2 + 31;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        h.a(this, parcel, n2);
    }
}

