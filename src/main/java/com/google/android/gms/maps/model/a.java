/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 */
package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.model.CameraPosition;

public class a {
    static void a(CameraPosition cameraPosition, Parcel parcel, int n2) {
        int n3 = b.l(parcel);
        b.c(parcel, 1, cameraPosition.getVersionCode());
        b.a(parcel, 2, cameraPosition.target, n2, false);
        b.a(parcel, 3, cameraPosition.zoom);
        b.a(parcel, 4, cameraPosition.tilt);
        b.a(parcel, 5, cameraPosition.bearing);
        b.D(parcel, n3);
    }
}

