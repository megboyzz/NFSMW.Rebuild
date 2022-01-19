/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 */
package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.GoogleMapOptions;

public class a {
    static void a(GoogleMapOptions googleMapOptions, Parcel parcel, int n2) {
        int n3 = b.l(parcel);
        b.c(parcel, 1, googleMapOptions.getVersionCode());
        b.a(parcel, 2, googleMapOptions.dS());
        b.a(parcel, 3, googleMapOptions.dT());
        b.c(parcel, 4, googleMapOptions.getMapType());
        b.a(parcel, 5, googleMapOptions.getCamera(), n2, false);
        b.a(parcel, 6, googleMapOptions.dU());
        b.a(parcel, 7, googleMapOptions.dV());
        b.a(parcel, 8, googleMapOptions.dW());
        b.a(parcel, 9, googleMapOptions.dX());
        b.a(parcel, 10, googleMapOptions.dY());
        b.a(parcel, 11, googleMapOptions.dZ());
        b.D(parcel, n3);
    }
}

