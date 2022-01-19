/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 */
package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.model.VisibleRegion;

public class k {
    static void a(VisibleRegion visibleRegion, Parcel parcel, int n2) {
        int n3 = b.l(parcel);
        b.c(parcel, 1, visibleRegion.getVersionCode());
        b.a(parcel, 2, visibleRegion.nearLeft, n2, false);
        b.a(parcel, 3, visibleRegion.nearRight, n2, false);
        b.a(parcel, 4, visibleRegion.farLeft, n2, false);
        b.a(parcel, 5, visibleRegion.farRight, n2, false);
        b.a(parcel, 6, visibleRegion.latLngBounds, n2, false);
        b.D(parcel, n3);
    }
}

