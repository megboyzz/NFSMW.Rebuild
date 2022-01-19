/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 */
package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.bi;

public final class bj
implements SafeParcelable {
    public static final bi CREATOR = new bi();
    public final String gm;
    public final String gn;
    public final String go;
    public final String gp;
    public final String gq;
    public final String mimeType;
    public final String packageName;
    public final int versionCode;

    public bj(int n2, String string2, String string3, String string4, String string5, String string6, String string7, String string8) {
        this.versionCode = n2;
        this.gm = string2;
        this.gn = string3;
        this.mimeType = string4;
        this.packageName = string5;
        this.go = string6;
        this.gp = string7;
        this.gq = string8;
    }

    public bj(String string2, String string3, String string4, String string5, String string6, String string7, String string8) {
        this(1, string2, string3, string4, string5, string6, string7, string8);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        bi.a(this, parcel, n2);
    }
}

