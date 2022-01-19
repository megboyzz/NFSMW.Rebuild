/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcelable
 */
package com.google.android.gms.maps.internal;

import android.os.Bundle;
import android.os.Parcelable;

public final class p {
    private p() {
    }

    public static void a(Bundle bundle, String string2, Parcelable parcelable) {
        Bundle bundle2;
        bundle.setClassLoader(p.class.getClassLoader());
        Bundle bundle3 = bundle2 = bundle.getBundle("map_state");
        if (bundle2 == null) {
            bundle3 = new Bundle();
        }
        bundle3.setClassLoader(p.class.getClassLoader());
        bundle3.putParcelable(string2, parcelable);
        bundle.putBundle("map_state", bundle3);
    }
}

