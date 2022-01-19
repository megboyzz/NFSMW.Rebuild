/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.multiplayer.InvitationEntity;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import java.util.ArrayList;

public class a
implements Parcelable.Creator<InvitationEntity> {
    static void a(InvitationEntity invitationEntity, Parcel parcel, int n2) {
        int n3 = b.l(parcel);
        b.a(parcel, 1, invitationEntity.getGame(), n2, false);
        b.c(parcel, 1000, invitationEntity.getVersionCode());
        b.a(parcel, 2, invitationEntity.getInvitationId(), false);
        b.a(parcel, 3, invitationEntity.getCreationTimestamp());
        b.c(parcel, 4, invitationEntity.getInvitationType());
        b.a(parcel, 5, invitationEntity.getInviter(), n2, false);
        b.b(parcel, 6, invitationEntity.getParticipants(), false);
        b.c(parcel, 7, invitationEntity.getVariant());
        b.D(parcel, n3);
    }

    public InvitationEntity W(Parcel parcel) {
        int n2 = 0;
        ArrayList<ParticipantEntity> arrayList = null;
        int n3 = com.google.android.gms.common.internal.safeparcel.a.k(parcel);
        long l2 = 0L;
        ParticipantEntity participantEntity = null;
        int n4 = 0;
        String string2 = null;
        GameEntity gameEntity = null;
        int n5 = 0;
        block10: while (true) {
            if (parcel.dataPosition() >= n3) {
                if (parcel.dataPosition() == n3) return new InvitationEntity(n5, gameEntity, string2, l2, n4, participantEntity, arrayList, n2);
                throw new a.a("Overread allowed size end=" + n3, parcel);
            }
            int n6 = com.google.android.gms.common.internal.safeparcel.a.j(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.A(n6)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, n6);
                    continue block10;
                }
                case 1: {
                    gameEntity = com.google.android.gms.common.internal.safeparcel.a.a(parcel, n6, GameEntity.CREATOR);
                    continue block10;
                }
                case 1000: {
                    n5 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, n6);
                    continue block10;
                }
                case 2: {
                    string2 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, n6);
                    continue block10;
                }
                case 3: {
                    l2 = com.google.android.gms.common.internal.safeparcel.a.h(parcel, n6);
                    continue block10;
                }
                case 4: {
                    n4 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, n6);
                    continue block10;
                }
                case 5: {
                    participantEntity = com.google.android.gms.common.internal.safeparcel.a.a(parcel, n6, ParticipantEntity.CREATOR);
                    continue block10;
                }
                case 6: {
                    arrayList = com.google.android.gms.common.internal.safeparcel.a.c(parcel, n6, ParticipantEntity.CREATOR);
                    continue block10;
                }
                case 7: 
            }
            n2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, n6);
        }
    }

    public InvitationEntity[] aw(int n2) {
        return new InvitationEntity[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.W(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.aw(n2);
    }
}

