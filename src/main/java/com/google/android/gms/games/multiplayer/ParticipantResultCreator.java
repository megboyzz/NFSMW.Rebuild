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
import com.google.android.gms.games.multiplayer.ParticipantResult;

public class ParticipantResultCreator
implements Parcelable.Creator<ParticipantResult> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void a(ParticipantResult participantResult, Parcel parcel, int n2) {
        n2 = b.l(parcel);
        b.a(parcel, 1, participantResult.getParticipantId(), false);
        b.c(parcel, 1000, participantResult.getVersionCode());
        b.c(parcel, 2, participantResult.getResult());
        b.c(parcel, 3, participantResult.getPlacing());
        b.D(parcel, n2);
    }

    public ParticipantResult createFromParcel(Parcel parcel) {
        int n2 = 0;
        int n3 = a.k(parcel);
        String string2 = null;
        int n4 = 0;
        int n5 = 0;
        block6: while (true) {
            if (parcel.dataPosition() >= n3) {
                if (parcel.dataPosition() == n3) return new ParticipantResult(n5, string2, n4, n2);
                throw new a.a("Overread allowed size end=" + n3, parcel);
            }
            int n6 = a.j(parcel);
            switch (a.A(n6)) {
                default: {
                    a.b(parcel, n6);
                    continue block6;
                }
                case 1: {
                    string2 = a.m(parcel, n6);
                    continue block6;
                }
                case 1000: {
                    n5 = a.g(parcel, n6);
                    continue block6;
                }
                case 2: {
                    n4 = a.g(parcel, n6);
                    continue block6;
                }
                case 3: 
            }
            n2 = a.g(parcel, n6);
        }
    }

    public ParticipantResult[] newArray(int n2) {
        return new ParticipantResult[n2];
    }
}

