/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.a;

public final class Address
implements SafeParcelable {
    public static final Parcelable.Creator<Address> CREATOR = new a();
    String BA;
    String BB;
    String BC;
    String BD;
    String BE;
    String BF;
    String BG;
    boolean BH;
    String BI;
    String ia;
    private final int kZ;
    String name;

    Address() {
        this.kZ = 1;
    }

    Address(int n2, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, boolean bl2, String string11) {
        this.kZ = n2;
        this.name = string2;
        this.BA = string3;
        this.BB = string4;
        this.BC = string5;
        this.ia = string6;
        this.BD = string7;
        this.BE = string8;
        this.BF = string9;
        this.BG = string10;
        this.BH = bl2;
        this.BI = string11;
    }

    public int describeContents() {
        return 0;
    }

    public String getAddress1() {
        return this.BA;
    }

    public String getAddress2() {
        return this.BB;
    }

    public String getAddress3() {
        return this.BC;
    }

    public String getCity() {
        return this.BD;
    }

    public String getCompanyName() {
        return this.BI;
    }

    public String getCountryCode() {
        return this.ia;
    }

    public String getName() {
        return this.name;
    }

    public String getPhoneNumber() {
        return this.BG;
    }

    public String getPostalCode() {
        return this.BF;
    }

    public String getState() {
        return this.BE;
    }

    public int getVersionCode() {
        return this.kZ;
    }

    public boolean isPostBox() {
        return this.BH;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        a.a(this, parcel, n2);
    }
}

