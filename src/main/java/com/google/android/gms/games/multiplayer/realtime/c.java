/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import java.util.ArrayList;

public class c
implements Parcelable.Creator<RoomEntity> {
    static void a(RoomEntity roomEntity, Parcel parcel, int n2) {
        n2 = b.l(parcel);
        b.a(parcel, 1, roomEntity.getRoomId(), false);
        b.c(parcel, 1000, roomEntity.getVersionCode());
        b.a(parcel, 2, roomEntity.getCreatorId(), false);
        b.a(parcel, 3, roomEntity.getCreationTimestamp());
        b.c(parcel, 4, roomEntity.getStatus());
        b.a(parcel, 5, roomEntity.getDescription(), false);
        b.c(parcel, 6, roomEntity.getVariant());
        b.a(parcel, 7, roomEntity.getAutoMatchCriteria(), false);
        b.b(parcel, 8, roomEntity.getParticipants(), false);
        b.c(parcel, 9, roomEntity.getAutoMatchWaitEstimateSeconds());
        b.D(parcel, n2);
    }

    public RoomEntity Z(Parcel parcel) {
        int n2 = 0;
        ArrayList<ParticipantEntity> arrayList = null;
        int n3 = a.k(parcel);
        long l2 = 0L;
        Bundle bundle = null;
        int n4 = 0;
        String string2 = null;
        int n5 = 0;
        String string3 = null;
        String string4 = null;
        int n6 = 0;
        block12: while (true) {
            if (parcel.dataPosition() >= n3) {
                if (parcel.dataPosition() == n3) return new RoomEntity(n6, string4, string3, l2, n5, string2, n4, bundle, arrayList, n2);
                throw new a.a("Overread allowed size end=" + n3, parcel);
            }
            int n7 = a.j(parcel);
            switch (a.A(n7)) {
                default: {
                    a.b(parcel, n7);
                    continue block12;
                }
                case 1: {
                    string4 = a.m(parcel, n7);
                    continue block12;
                }
                case 1000: {
                    n6 = a.g(parcel, n7);
                    continue block12;
                }
                case 2: {
                    string3 = a.m(parcel, n7);
                    continue block12;
                }
                case 3: {
                    l2 = a.h(parcel, n7);
                    continue block12;
                }
                case 4: {
                    n5 = a.g(parcel, n7);
                    continue block12;
                }
                case 5: {
                    string2 = a.m(parcel, n7);
                    continue block12;
                }
                case 6: {
                    n4 = a.g(parcel, n7);
                    continue block12;
                }
                case 7: {
                    bundle = a.o(parcel, n7);
                    continue block12;
                }
                case 8: {
                    arrayList = a.c(parcel, n7, ParticipantEntity.CREATOR);
                    continue block12;
                }
                case 9: 
            }
            n2 = a.g(parcel, n7);
        }
    }

    public RoomEntity[] az(int n2) {
        return new RoomEntity[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.Z(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.az(n2);
    }
}

