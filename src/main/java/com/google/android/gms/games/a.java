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
import com.google.android.gms.games.GameEntity;

public class a
implements Parcelable.Creator<GameEntity> {
    static void a(GameEntity gameEntity, Parcel parcel, int n2) {
        int n3 = b.l(parcel);
        b.a(parcel, 1, gameEntity.getApplicationId(), false);
        b.a(parcel, 2, gameEntity.getDisplayName(), false);
        b.a(parcel, 3, gameEntity.getPrimaryCategory(), false);
        b.a(parcel, 4, gameEntity.getSecondaryCategory(), false);
        b.a(parcel, 5, gameEntity.getDescription(), false);
        b.a(parcel, 6, gameEntity.getDeveloperName(), false);
        b.a(parcel, 7, (Parcelable)gameEntity.getIconImageUri(), n2, false);
        b.a(parcel, 8, (Parcelable)gameEntity.getHiResImageUri(), n2, false);
        b.a(parcel, 9, (Parcelable)gameEntity.getFeaturedImageUri(), n2, false);
        b.a(parcel, 10, gameEntity.isPlayEnabledGame());
        b.a(parcel, 11, gameEntity.isInstanceInstalled());
        b.a(parcel, 12, gameEntity.getInstancePackageName(), false);
        b.c(parcel, 13, gameEntity.getGameplayAclStatus());
        b.c(parcel, 14, gameEntity.getAchievementTotalCount());
        b.c(parcel, 15, gameEntity.getLeaderboardCount());
        b.a(parcel, 17, gameEntity.isTurnBasedMultiplayerEnabled());
        b.a(parcel, 16, gameEntity.isRealTimeMultiplayerEnabled());
        b.c(parcel, 1000, gameEntity.getVersionCode());
        b.D(parcel, n3);
    }

    public GameEntity U(Parcel parcel) {
        int n2 = com.google.android.gms.common.internal.safeparcel.a.k(parcel);
        int n3 = 0;
        String string2 = null;
        String string3 = null;
        String string4 = null;
        String string5 = null;
        String string6 = null;
        String string7 = null;
        Uri uri = null;
        Uri uri2 = null;
        Uri uri3 = null;
        boolean bl2 = false;
        boolean bl3 = false;
        String string8 = null;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        boolean bl4 = false;
        boolean bl5 = false;
        block20: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new GameEntity(n3, string2, string3, string4, string5, string6, string7, uri, uri2, uri3, bl2, bl3, string8, n4, n5, n6, bl4, bl5);
                throw new a.a("Overread allowed size end=" + n2, parcel);
            }
            int n7 = com.google.android.gms.common.internal.safeparcel.a.j(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.A(n7)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, n7);
                    continue block20;
                }
                case 1: {
                    string2 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, n7);
                    continue block20;
                }
                case 2: {
                    string3 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, n7);
                    continue block20;
                }
                case 3: {
                    string4 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, n7);
                    continue block20;
                }
                case 4: {
                    string5 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, n7);
                    continue block20;
                }
                case 5: {
                    string6 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, n7);
                    continue block20;
                }
                case 6: {
                    string7 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, n7);
                    continue block20;
                }
                case 7: {
                    uri = (Uri)com.google.android.gms.common.internal.safeparcel.a.a(parcel, n7, Uri.CREATOR);
                    continue block20;
                }
                case 8: {
                    uri2 = (Uri)com.google.android.gms.common.internal.safeparcel.a.a(parcel, n7, Uri.CREATOR);
                    continue block20;
                }
                case 9: {
                    uri3 = (Uri)com.google.android.gms.common.internal.safeparcel.a.a(parcel, n7, Uri.CREATOR);
                    continue block20;
                }
                case 10: {
                    bl2 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, n7);
                    continue block20;
                }
                case 11: {
                    bl3 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, n7);
                    continue block20;
                }
                case 12: {
                    string8 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, n7);
                    continue block20;
                }
                case 13: {
                    n4 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, n7);
                    continue block20;
                }
                case 14: {
                    n5 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, n7);
                    continue block20;
                }
                case 15: {
                    n6 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, n7);
                    continue block20;
                }
                case 17: {
                    bl5 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, n7);
                    continue block20;
                }
                case 16: {
                    bl4 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, n7);
                    continue block20;
                }
                case 1000: 
            }
            n3 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, n7);
        }
    }

    public GameEntity[] am(int n2) {
        return new GameEntity[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.U(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.am(n2);
    }
}

