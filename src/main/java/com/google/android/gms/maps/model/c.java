/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 */
package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.model.GroundOverlayOptions;

public class c {
    static void a(GroundOverlayOptions groundOverlayOptions, Parcel parcel, int n2) {
        int n3 = b.l(parcel);
        b.c(parcel, 1, groundOverlayOptions.getVersionCode());
        b.a(parcel, 2, groundOverlayOptions.ej(), false);
        b.a(parcel, 3, groundOverlayOptions.getLocation(), n2, false);
        b.a(parcel, 4, groundOverlayOptions.getWidth());
        b.a(parcel, 5, groundOverlayOptions.getHeight());
        b.a(parcel, 6, groundOverlayOptions.getBounds(), n2, false);
        b.a(parcel, 7, groundOverlayOptions.getBearing());
        b.a(parcel, 8, groundOverlayOptions.getZIndex());
        b.a(parcel, 9, groundOverlayOptions.isVisible());
        b.a(parcel, 10, groundOverlayOptions.getTransparency());
        b.a(parcel, 11, groundOverlayOptions.getAnchorU());
        b.a(parcel, 12, groundOverlayOptions.getAnchorV());
        b.D(parcel, n3);
    }
}

