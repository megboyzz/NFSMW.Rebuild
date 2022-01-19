/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 */
package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.cc;
import java.util.Collections;
import java.util.List;

public final class cb
implements SafeParcelable {
    public static final cc CREATOR = new cc();
    public final int errorCode;
    public final List<String> fK;
    public final List<String> fL;
    public final long fO;
    public final String gK;
    public final String hu;
    public final long hv;
    public final boolean hw;
    public final long hx;
    public final List<String> hy;
    public final String hz;
    public final int orientation;
    public final int versionCode;

    public cb(int n2) {
        this(2, null, null, null, n2, null, -1L, false, -1L, null, -1L, -1, null);
    }

    cb(int n2, String list, String string2, List<String> list2, int n3, List<String> list3, long l2, boolean bl2, long l3, List<String> list4, long l4, int n4, String string3) {
        this.versionCode = n2;
        this.gK = list;
        this.hu = string2;
        list = list2 != null ? Collections.unmodifiableList(list2) : null;
        this.fK = list;
        this.errorCode = n3;
        list = list3 != null ? Collections.unmodifiableList(list3) : null;
        this.fL = list;
        this.hv = l2;
        this.hw = bl2;
        this.hx = l3;
        list = list4 != null ? Collections.unmodifiableList(list4) : null;
        this.hy = list;
        this.fO = l4;
        this.orientation = n4;
        this.hz = string3;
    }

    public cb(String string2, String string3, List<String> list, List<String> list2, long l2, boolean bl2, long l3, List<String> list3, long l4, int n2, String string4) {
        this(2, string2, string3, list, -2, list2, l2, bl2, l3, list3, l4, n2, string4);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        cc.a(this, parcel, n2);
    }
}

