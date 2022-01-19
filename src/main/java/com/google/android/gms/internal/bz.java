/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.os.Bundle
 *  android.os.Parcel
 */
package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ca;
import com.google.android.gms.internal.ct;
import com.google.android.gms.internal.v;
import com.google.android.gms.internal.x;

public final class bz
implements SafeParcelable {
    public static final ca CREATOR = new ca();
    public final String adUnitId;
    public final ApplicationInfo applicationInfo;
    public final ct ej;
    public final x em;
    public final Bundle ho;
    public final v hp;
    public final PackageInfo hq;
    public final String hr;
    public final String hs;
    public final String ht;
    public final int versionCode;

    bz(int n2, Bundle bundle, v v2, x x2, String string2, ApplicationInfo applicationInfo, PackageInfo packageInfo, String string3, String string4, String string5, ct ct2) {
        this.versionCode = n2;
        this.ho = bundle;
        this.hp = v2;
        this.em = x2;
        this.adUnitId = string2;
        this.applicationInfo = applicationInfo;
        this.hq = packageInfo;
        this.hr = string3;
        this.hs = string4;
        this.ht = string5;
        this.ej = ct2;
    }

    public bz(Bundle bundle, v v2, x x2, String string2, ApplicationInfo applicationInfo, PackageInfo packageInfo, String string3, String string4, String string5, ct ct2) {
        this(1, bundle, v2, x2, string2, applicationInfo, packageInfo, string3, string4, string5, ct2);
    }

    public bz(a a2, String string2) {
        this(a2.ho, a2.hp, a2.em, a2.adUnitId, a2.applicationInfo, a2.hq, string2, a2.hs, a2.ht, a2.ej);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        ca.a(this, parcel, n2);
    }

    public static final class a {
        public final String adUnitId;
        public final ApplicationInfo applicationInfo;
        public final ct ej;
        public final x em;
        public final Bundle ho;
        public final v hp;
        public final PackageInfo hq;
        public final String hs;
        public final String ht;

        public a(Bundle bundle, v v2, x x2, String string2, ApplicationInfo applicationInfo, PackageInfo packageInfo, String string3, String string4, ct ct2) {
            this.ho = bundle;
            this.hp = v2;
            this.em = x2;
            this.adUnitId = string2;
            this.applicationInfo = applicationInfo;
            this.hq = packageInfo;
            this.hs = string3;
            this.ht = string4;
            this.ej = ct2;
        }
    }
}

