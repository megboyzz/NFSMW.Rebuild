/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.fw;
import com.google.android.gms.internal.gb;
import com.google.android.gms.internal.gd;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.ArrayList;

public class gc
implements Parcelable.Creator<gb> {
    static void a(gb gb2, Parcel parcel, int n2) {
        int n3 = b.l(parcel);
        b.a(parcel, 1, gb2.getId(), false);
        b.a(parcel, 2, gb2.dM(), false);
        b.a(parcel, 3, gb2.dN(), n2, false);
        b.a(parcel, 4, gb2.dF(), n2, false);
        b.a(parcel, 5, gb2.dG());
        b.a(parcel, 6, gb2.dH(), n2, false);
        b.a(parcel, 7, gb2.dO(), false);
        b.a(parcel, 8, (Parcelable)gb2.dI(), n2, false);
        b.a(parcel, 9, gb2.dJ());
        b.a(parcel, 10, gb2.getRating());
        b.c(parcel, 11, gb2.dK());
        b.a(parcel, 12, gb2.dL());
        b.b(parcel, 13, gb2.dE(), false);
        b.c(parcel, 1000, gb2.kZ);
        b.D(parcel, n3);
    }

    public gb[] aL(int n2) {
        return new gb[n2];
    }

    public gb af(Parcel parcel) {
        int n2 = a.k(parcel);
        int n3 = 0;
        String string2 = null;
        ArrayList<fw> arrayList = null;
        Bundle bundle = null;
        gd gd2 = null;
        LatLng latLng = null;
        float f2 = 0.0f;
        LatLngBounds latLngBounds = null;
        String string3 = null;
        Uri uri = null;
        boolean bl2 = false;
        float f3 = 0.0f;
        int n4 = 0;
        long l2 = 0L;
        block16: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new gb(n3, string2, arrayList, bundle, gd2, latLng, f2, latLngBounds, string3, uri, bl2, f3, n4, l2);
                throw new a.a("Overread allowed size end=" + n2, parcel);
            }
            int n5 = a.j(parcel);
            switch (a.A(n5)) {
                default: {
                    a.b(parcel, n5);
                    continue block16;
                }
                case 1: {
                    string2 = a.m(parcel, n5);
                    continue block16;
                }
                case 2: {
                    bundle = a.o(parcel, n5);
                    continue block16;
                }
                case 3: {
                    gd2 = a.a(parcel, n5, gd.CREATOR);
                    continue block16;
                }
                case 4: {
                    latLng = a.a(parcel, n5, LatLng.CREATOR);
                    continue block16;
                }
                case 5: {
                    f2 = a.j(parcel, n5);
                    continue block16;
                }
                case 6: {
                    latLngBounds = a.a(parcel, n5, LatLngBounds.CREATOR);
                    continue block16;
                }
                case 7: {
                    string3 = a.m(parcel, n5);
                    continue block16;
                }
                case 8: {
                    uri = (Uri)a.a(parcel, n5, Uri.CREATOR);
                    continue block16;
                }
                case 9: {
                    bl2 = a.c(parcel, n5);
                    continue block16;
                }
                case 10: {
                    f3 = a.j(parcel, n5);
                    continue block16;
                }
                case 11: {
                    n4 = a.g(parcel, n5);
                    continue block16;
                }
                case 12: {
                    l2 = a.h(parcel, n5);
                    continue block16;
                }
                case 13: {
                    arrayList = a.c(parcel, n5, fw.CREATOR);
                    continue block16;
                }
                case 1000: 
            }
            n3 = a.g(parcel, n5);
        }
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.af(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.aL(n2);
    }
}

