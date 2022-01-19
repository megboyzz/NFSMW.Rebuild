/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 */
package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.cu;

public final class ct
implements SafeParcelable {
    public static final cu CREATOR = new cu();
    public String iF;
    public int iG;
    public int iH;
    public boolean iI;
    public final int versionCode;

    public ct(int n2, int n3, boolean bl2) {
        StringBuilder stringBuilder = new StringBuilder().append("afma-sdk-a-v").append(n2).append(".").append(n3).append(".");
        String string2 = bl2 ? "0" : "1";
        this(1, stringBuilder.append(string2).toString(), n2, n3, bl2);
    }

    ct(int n2, String string2, int n3, int n4, boolean bl2) {
        this.versionCode = n2;
        this.iF = string2;
        this.iG = n3;
        this.iH = n4;
        this.iI = bl2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        cu.a(this, parcel, n2);
    }
}

