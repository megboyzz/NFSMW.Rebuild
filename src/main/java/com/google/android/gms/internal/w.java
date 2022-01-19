/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.location.Location
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.ai;
import com.google.android.gms.internal.v;
import java.util.ArrayList;

public class w
implements Parcelable.Creator<v> {
    static void a(v v2, Parcel parcel, int n2) {
        int n3 = b.l(parcel);
        b.c(parcel, 1, v2.versionCode);
        b.a(parcel, 2, v2.ex);
        b.a(parcel, 3, v2.extras, false);
        b.c(parcel, 4, v2.ey);
        b.a(parcel, 5, v2.ez, false);
        b.a(parcel, 6, v2.eA);
        b.c(parcel, 7, v2.tagForChildDirectedTreatment);
        b.a(parcel, 8, v2.eB);
        b.a(parcel, 9, v2.eC, false);
        b.a(parcel, 10, v2.eD, n2, false);
        b.a(parcel, 11, (Parcelable)v2.eE, n2, false);
        b.D(parcel, n3);
    }

    public v a(Parcel parcel) {
        int n2 = a.k(parcel);
        int n3 = 0;
        long l2 = 0L;
        Bundle bundle = null;
        int n4 = 0;
        ArrayList<String> arrayList = null;
        boolean bl2 = false;
        int n5 = 0;
        boolean bl3 = false;
        String string2 = null;
        ai ai2 = null;
        Location location = null;
        block13: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new v(n3, l2, bundle, n4, arrayList, bl2, n5, bl3, string2, ai2, location);
                throw new a.a("Overread allowed size end=" + n2, parcel);
            }
            int n6 = a.j(parcel);
            switch (a.A(n6)) {
                default: {
                    a.b(parcel, n6);
                    continue block13;
                }
                case 1: {
                    n3 = a.g(parcel, n6);
                    continue block13;
                }
                case 2: {
                    l2 = a.h(parcel, n6);
                    continue block13;
                }
                case 3: {
                    bundle = a.o(parcel, n6);
                    continue block13;
                }
                case 4: {
                    n4 = a.g(parcel, n6);
                    continue block13;
                }
                case 5: {
                    arrayList = a.y(parcel, n6);
                    continue block13;
                }
                case 6: {
                    bl2 = a.c(parcel, n6);
                    continue block13;
                }
                case 7: {
                    n5 = a.g(parcel, n6);
                    continue block13;
                }
                case 8: {
                    bl3 = a.c(parcel, n6);
                    continue block13;
                }
                case 9: {
                    string2 = a.m(parcel, n6);
                    continue block13;
                }
                case 10: {
                    ai2 = a.a(parcel, n6, ai.CREATOR);
                    continue block13;
                }
                case 11: 
            }
            location = (Location)a.a(parcel, n6, Location.CREATOR);
        }
    }

    public v[] b(int n2) {
        return new v[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.b(n2);
    }
}

