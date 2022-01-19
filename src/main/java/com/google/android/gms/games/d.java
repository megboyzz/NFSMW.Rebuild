/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.PlayerEntity;

public class d
implements Parcelable.Creator<PlayerEntity> {
    static void a(PlayerEntity playerEntity, Parcel parcel, int n2) {
        int n3 = b.l(parcel);
        b.a(parcel, 1, playerEntity.getPlayerId(), false);
        b.c(parcel, 1000, playerEntity.getVersionCode());
        b.a(parcel, 2, playerEntity.getDisplayName(), false);
        b.a(parcel, 3, (Parcelable)playerEntity.getIconImageUri(), n2, false);
        b.a(parcel, 4, (Parcelable)playerEntity.getHiResImageUri(), n2, false);
        b.a(parcel, 5, playerEntity.getRetrievedTimestamp());
        b.D(parcel, n3);
    }

    public PlayerEntity V(Parcel parcel) {
        Uri uri = null;
        int n2 = a.k(parcel);
        int n3 = 0;
        long l2 = 0L;
        Uri uri2 = null;
        String string2 = null;
        String string3 = null;
        block8: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new PlayerEntity(n3, string3, string2, uri2, uri, l2);
                throw new a.a("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.j(parcel);
            switch (a.A(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block8;
                }
                case 1: {
                    string3 = a.m(parcel, n4);
                    continue block8;
                }
                case 1000: {
                    n3 = a.g(parcel, n4);
                    continue block8;
                }
                case 2: {
                    string2 = a.m(parcel, n4);
                    continue block8;
                }
                case 3: {
                    uri2 = (Uri)a.a(parcel, n4, Uri.CREATOR);
                    continue block8;
                }
                case 4: {
                    uri = (Uri)a.a(parcel, n4, Uri.CREATOR);
                    continue block8;
                }
                case 5: 
            }
            l2 = a.h(parcel, n4);
        }
    }

    public PlayerEntity[] an(int n2) {
        return new PlayerEntity[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.V(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.an(n2);
    }
}

