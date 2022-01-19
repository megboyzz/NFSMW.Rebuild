/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.model.TileOverlayOptions;

public class TileOverlayOptionsCreator
implements Parcelable.Creator<TileOverlayOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void a(TileOverlayOptions tileOverlayOptions, Parcel parcel, int n2) {
        n2 = b.l(parcel);
        b.c(parcel, 1, tileOverlayOptions.getVersionCode());
        b.a(parcel, 2, tileOverlayOptions.em(), false);
        b.a(parcel, 3, tileOverlayOptions.isVisible());
        b.a(parcel, 4, tileOverlayOptions.getZIndex());
        b.a(parcel, 5, tileOverlayOptions.getFadeIn());
        b.D(parcel, n2);
    }

    public TileOverlayOptions createFromParcel(Parcel parcel) {
        boolean bl2 = false;
        int n2 = a.k(parcel);
        IBinder iBinder = null;
        float f2 = 0.0f;
        boolean bl3 = true;
        int n3 = 0;
        block7: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new TileOverlayOptions(n3, iBinder, bl2, f2, bl3);
                throw new a.a("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.j(parcel);
            switch (a.A(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block7;
                }
                case 1: {
                    n3 = a.g(parcel, n4);
                    continue block7;
                }
                case 2: {
                    iBinder = a.n(parcel, n4);
                    continue block7;
                }
                case 3: {
                    bl2 = a.c(parcel, n4);
                    continue block7;
                }
                case 4: {
                    f2 = a.j(parcel, n4);
                    continue block7;
                }
                case 5: 
            }
            bl3 = a.c(parcel, n4);
        }
    }

    public TileOverlayOptions[] newArray(int n2) {
        return new TileOverlayOptions[n2];
    }
}

