/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 */
package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ds;
import com.google.android.gms.internal.gu;

public class gs
implements SafeParcelable {
    public static final gu CREATOR = new gu();
    private final String jD;
    private final int kZ;
    private final String[] zG;
    private final String[] zH;
    private final String[] zI;
    private final String zJ;
    private final String zK;
    private final String zL;
    private final String zM;

    gs(int n2, String string2, String[] stringArray, String[] stringArray2, String[] stringArray3, String string3, String string4, String string5, String string6) {
        this.kZ = n2;
        this.jD = string2;
        this.zG = stringArray;
        this.zH = stringArray2;
        this.zI = stringArray3;
        this.zJ = string3;
        this.zK = string4;
        this.zL = string5;
        this.zM = string6;
    }

    gs(String string2, String[] stringArray, String[] stringArray2, String[] stringArray3, String string3, String string4, String string5) {
        this.kZ = 1;
        this.jD = string2;
        this.zG = stringArray;
        this.zH = stringArray2;
        this.zI = stringArray3;
        this.zJ = string3;
        this.zK = string4;
        this.zL = string5;
        this.zM = null;
    }

    public int describeContents() {
        return 0;
    }

    public String eA() {
        return this.zK;
    }

    public String eB() {
        return this.zL;
    }

    public String eC() {
        return this.zM;
    }

    public boolean equals(Object object) {
        if (!(object instanceof gs)) {
            return false;
        }
        object = (gs)object;
        if (this.kZ != ((gs)object).kZ) return false;
        if (!ds.equal(this.jD, ((gs)object).jD)) return false;
        if (!ds.equal(this.zG, ((gs)object).zG)) return false;
        if (!ds.equal(this.zH, ((gs)object).zH)) return false;
        if (!ds.equal(this.zI, ((gs)object).zI)) return false;
        if (!ds.equal(this.zJ, ((gs)object).zJ)) return false;
        if (!ds.equal(this.zK, ((gs)object).zK)) return false;
        if (!ds.equal(this.zL, ((gs)object).zL)) return false;
        if (!ds.equal(this.zM, ((gs)object).zM)) return false;
        return true;
    }

    public String[] ew() {
        return this.zG;
    }

    public String[] ex() {
        return this.zH;
    }

    public String[] ey() {
        return this.zI;
    }

    public String ez() {
        return this.zJ;
    }

    public String getAccountName() {
        return this.jD;
    }

    public int getVersionCode() {
        return this.kZ;
    }

    public int hashCode() {
        return ds.hashCode(this.kZ, this.jD, this.zG, this.zH, this.zI, this.zJ, this.zK, this.zL, this.zM);
    }

    public String toString() {
        return ds.e(this).a("versionCode", this.kZ).a("accountName", this.jD).a("requestedScopes", this.zG).a("visibleActivities", this.zH).a("requiredFeatures", this.zI).a("packageNameForAuth", this.zJ).a("callingPackageName", this.zK).a("applicationName", this.zL).toString();
    }

    public void writeToParcel(Parcel parcel, int n2) {
        gu.a(this, parcel, n2);
    }
}

