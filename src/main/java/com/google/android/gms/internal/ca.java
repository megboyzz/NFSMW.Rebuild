/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.bz;
import com.google.android.gms.internal.ct;
import com.google.android.gms.internal.v;
import com.google.android.gms.internal.x;

public class ca
implements Parcelable.Creator<bz> {
    static void a(bz bz2, Parcel parcel, int n2) {
        int n3 = b.l(parcel);
        b.c(parcel, 1, bz2.versionCode);
        b.a(parcel, 2, bz2.ho, false);
        b.a(parcel, 3, bz2.hp, n2, false);
        b.a(parcel, 4, bz2.em, n2, false);
        b.a(parcel, 5, bz2.adUnitId, false);
        b.a(parcel, 6, (Parcelable)bz2.applicationInfo, n2, false);
        b.a(parcel, 7, (Parcelable)bz2.hq, n2, false);
        b.a(parcel, 8, bz2.hr, false);
        b.a(parcel, 9, bz2.hs, false);
        b.a(parcel, 10, bz2.ht, false);
        b.a(parcel, 11, bz2.ej, n2, false);
        b.D(parcel, n3);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.f(parcel);
    }

    public bz f(Parcel parcel) {
        ct ct2 = null;
        int n2 = a.k(parcel);
        int n3 = 0;
        String string2 = null;
        String string3 = null;
        String string4 = null;
        PackageInfo packageInfo = null;
        ApplicationInfo applicationInfo = null;
        String string5 = null;
        x x2 = null;
        v v2 = null;
        Bundle bundle = null;
        block13: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new bz(n3, bundle, v2, x2, string5, applicationInfo, packageInfo, string4, string3, string2, ct2);
                throw new a.a("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.j(parcel);
            switch (a.A(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block13;
                }
                case 1: {
                    n3 = a.g(parcel, n4);
                    continue block13;
                }
                case 2: {
                    bundle = a.o(parcel, n4);
                    continue block13;
                }
                case 3: {
                    v2 = a.a(parcel, n4, v.CREATOR);
                    continue block13;
                }
                case 4: {
                    x2 = a.a(parcel, n4, x.CREATOR);
                    continue block13;
                }
                case 5: {
                    string5 = a.m(parcel, n4);
                    continue block13;
                }
                case 6: {
                    applicationInfo = (ApplicationInfo)a.a(parcel, n4, ApplicationInfo.CREATOR);
                    continue block13;
                }
                case 7: {
                    packageInfo = (PackageInfo)a.a(parcel, n4, PackageInfo.CREATOR);
                    continue block13;
                }
                case 8: {
                    string4 = a.m(parcel, n4);
                    continue block13;
                }
                case 9: {
                    string3 = a.m(parcel, n4);
                    continue block13;
                }
                case 10: {
                    string2 = a.m(parcel, n4);
                    continue block13;
                }
                case 11: 
            }
            ct2 = a.a(parcel, n4, ct.CREATOR);
        }
    }

    public bz[] k(int n2) {
        return new bz[n2];
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.k(n2);
    }
}

