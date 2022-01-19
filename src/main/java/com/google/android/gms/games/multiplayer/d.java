/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.games.multiplayer;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.games.multiplayer.ParticipantResult;

public class d
implements Parcelable.Creator<ParticipantEntity> {
    static void a(ParticipantEntity participantEntity, Parcel parcel, int n2) {
        int n3 = b.l(parcel);
        b.a(parcel, 1, participantEntity.getParticipantId(), false);
        b.c(parcel, 1000, participantEntity.getVersionCode());
        b.a(parcel, 2, participantEntity.getDisplayName(), false);
        b.a(parcel, 3, (Parcelable)participantEntity.getIconImageUri(), n2, false);
        b.a(parcel, 4, (Parcelable)participantEntity.getHiResImageUri(), n2, false);
        b.c(parcel, 5, participantEntity.getStatus());
        b.a(parcel, 6, participantEntity.dm(), false);
        b.a(parcel, 7, participantEntity.isConnectedToRoom());
        b.a(parcel, 8, participantEntity.getPlayer(), n2, false);
        b.c(parcel, 9, participantEntity.getCapabilities());
        b.a(parcel, 10, participantEntity.getResult(), n2, false);
        b.D(parcel, n3);
    }

    public ParticipantEntity X(Parcel parcel) {
        int n2 = 0;
        ParticipantResult participantResult = null;
        int n3 = a.k(parcel);
        PlayerEntity playerEntity = null;
        boolean bl2 = false;
        String string2 = null;
        int n4 = 0;
        Uri uri = null;
        Uri uri2 = null;
        String string3 = null;
        String string4 = null;
        int n5 = 0;
        block13: while (true) {
            if (parcel.dataPosition() >= n3) {
                if (parcel.dataPosition() == n3) return new ParticipantEntity(n5, string4, string3, uri2, uri, n4, string2, bl2, playerEntity, n2, participantResult);
                throw new a.a("Overread allowed size end=" + n3, parcel);
            }
            int n6 = a.j(parcel);
            switch (a.A(n6)) {
                default: {
                    a.b(parcel, n6);
                    continue block13;
                }
                case 1: {
                    string4 = a.m(parcel, n6);
                    continue block13;
                }
                case 1000: {
                    n5 = a.g(parcel, n6);
                    continue block13;
                }
                case 2: {
                    string3 = a.m(parcel, n6);
                    continue block13;
                }
                case 3: {
                    uri2 = (Uri)a.a(parcel, n6, Uri.CREATOR);
                    continue block13;
                }
                case 4: {
                    uri = (Uri)a.a(parcel, n6, Uri.CREATOR);
                    continue block13;
                }
                case 5: {
                    n4 = a.g(parcel, n6);
                    continue block13;
                }
                case 6: {
                    string2 = a.m(parcel, n6);
                    continue block13;
                }
                case 7: {
                    bl2 = a.c(parcel, n6);
                    continue block13;
                }
                case 8: {
                    playerEntity = a.a(parcel, n6, PlayerEntity.CREATOR);
                    continue block13;
                }
                case 9: {
                    n2 = a.g(parcel, n6);
                    continue block13;
                }
                case 10: 
            }
            participantResult = a.a(parcel, n6, ParticipantResult.CREATOR);
        }
    }

    public ParticipantEntity[] ax(int n2) {
        return new ParticipantEntity[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.X(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.ax(n2);
    }
}

