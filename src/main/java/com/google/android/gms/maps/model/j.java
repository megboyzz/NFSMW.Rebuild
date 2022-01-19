/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 */
package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.model.TileOverlayOptions;

public class j {
    static void a(TileOverlayOptions tileOverlayOptions, Parcel parcel, int n2) {
        n2 = b.l(parcel);
        b.c(parcel, 1, tileOverlayOptions.getVersionCode());
        b.a(parcel, 2, tileOverlayOptions.em(), false);
        b.a(parcel, 3, tileOverlayOptions.isVisible());
        b.a(parcel, 4, tileOverlayOptions.getZIndex());
        b.D(parcel, n2);
    }
}

