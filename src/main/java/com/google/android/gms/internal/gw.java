/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.gv;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class gw
implements Parcelable.Creator<gv> {
    static void a(gv gv2, Parcel parcel, int n2) {
        int n3 = b.l(parcel);
        Set<Integer> set = gv2.eF();
        if (set.contains(1)) {
            b.c(parcel, 1, gv2.getVersionCode());
        }
        if (set.contains(2)) {
            b.a(parcel, 2, gv2.eG(), n2, true);
        }
        if (set.contains(3)) {
            b.a(parcel, 3, gv2.getAdditionalName(), true);
        }
        if (set.contains(4)) {
            b.a(parcel, 4, gv2.eH(), n2, true);
        }
        if (set.contains(5)) {
            b.a(parcel, 5, gv2.getAddressCountry(), true);
        }
        if (set.contains(6)) {
            b.a(parcel, 6, gv2.getAddressLocality(), true);
        }
        if (set.contains(7)) {
            b.a(parcel, 7, gv2.getAddressRegion(), true);
        }
        if (set.contains(8)) {
            b.b(parcel, 8, gv2.eI(), true);
        }
        if (set.contains(9)) {
            b.c(parcel, 9, gv2.getAttendeeCount());
        }
        if (set.contains(10)) {
            b.b(parcel, 10, gv2.eJ(), true);
        }
        if (set.contains(11)) {
            b.a(parcel, 11, gv2.eK(), n2, true);
        }
        if (set.contains(12)) {
            b.b(parcel, 12, gv2.eL(), true);
        }
        if (set.contains(13)) {
            b.a(parcel, 13, gv2.getBestRating(), true);
        }
        if (set.contains(14)) {
            b.a(parcel, 14, gv2.getBirthDate(), true);
        }
        if (set.contains(15)) {
            b.a(parcel, 15, gv2.eM(), n2, true);
        }
        if (set.contains(17)) {
            b.a(parcel, 17, gv2.getContentSize(), true);
        }
        if (set.contains(16)) {
            b.a(parcel, 16, gv2.getCaption(), true);
        }
        if (set.contains(19)) {
            b.b(parcel, 19, gv2.eN(), true);
        }
        if (set.contains(18)) {
            b.a(parcel, 18, gv2.getContentUrl(), true);
        }
        if (set.contains(21)) {
            b.a(parcel, 21, gv2.getDateModified(), true);
        }
        if (set.contains(20)) {
            b.a(parcel, 20, gv2.getDateCreated(), true);
        }
        if (set.contains(23)) {
            b.a(parcel, 23, gv2.getDescription(), true);
        }
        if (set.contains(22)) {
            b.a(parcel, 22, gv2.getDatePublished(), true);
        }
        if (set.contains(25)) {
            b.a(parcel, 25, gv2.getEmbedUrl(), true);
        }
        if (set.contains(24)) {
            b.a(parcel, 24, gv2.getDuration(), true);
        }
        if (set.contains(27)) {
            b.a(parcel, 27, gv2.getFamilyName(), true);
        }
        if (set.contains(26)) {
            b.a(parcel, 26, gv2.getEndDate(), true);
        }
        if (set.contains(29)) {
            b.a(parcel, 29, gv2.eO(), n2, true);
        }
        if (set.contains(28)) {
            b.a(parcel, 28, gv2.getGender(), true);
        }
        if (set.contains(31)) {
            b.a(parcel, 31, gv2.getHeight(), true);
        }
        if (set.contains(30)) {
            b.a(parcel, 30, gv2.getGivenName(), true);
        }
        if (set.contains(34)) {
            b.a(parcel, 34, gv2.eP(), n2, true);
        }
        if (set.contains(32)) {
            b.a(parcel, 32, gv2.getId(), true);
        }
        if (set.contains(33)) {
            b.a(parcel, 33, gv2.getImage(), true);
        }
        if (set.contains(38)) {
            b.a(parcel, 38, gv2.getLongitude());
        }
        if (set.contains(39)) {
            b.a(parcel, 39, gv2.getName(), true);
        }
        if (set.contains(36)) {
            b.a(parcel, 36, gv2.getLatitude());
        }
        if (set.contains(37)) {
            b.a(parcel, 37, gv2.eQ(), n2, true);
        }
        if (set.contains(42)) {
            b.a(parcel, 42, gv2.getPlayerType(), true);
        }
        if (set.contains(43)) {
            b.a(parcel, 43, gv2.getPostOfficeBoxNumber(), true);
        }
        if (set.contains(40)) {
            b.a(parcel, 40, gv2.eR(), n2, true);
        }
        if (set.contains(41)) {
            b.b(parcel, 41, gv2.eS(), true);
        }
        if (set.contains(46)) {
            b.a(parcel, 46, gv2.eT(), n2, true);
        }
        if (set.contains(47)) {
            b.a(parcel, 47, gv2.getStartDate(), true);
        }
        if (set.contains(44)) {
            b.a(parcel, 44, gv2.getPostalCode(), true);
        }
        if (set.contains(45)) {
            b.a(parcel, 45, gv2.getRatingValue(), true);
        }
        if (set.contains(51)) {
            b.a(parcel, 51, gv2.getThumbnailUrl(), true);
        }
        if (set.contains(50)) {
            b.a(parcel, 50, gv2.eU(), n2, true);
        }
        if (set.contains(49)) {
            b.a(parcel, 49, gv2.getText(), true);
        }
        if (set.contains(48)) {
            b.a(parcel, 48, gv2.getStreetAddress(), true);
        }
        if (set.contains(55)) {
            b.a(parcel, 55, gv2.getWidth(), true);
        }
        if (set.contains(54)) {
            b.a(parcel, 54, gv2.getUrl(), true);
        }
        if (set.contains(53)) {
            b.a(parcel, 53, gv2.getType(), true);
        }
        if (set.contains(52)) {
            b.a(parcel, 52, gv2.getTickerSymbol(), true);
        }
        if (set.contains(56)) {
            b.a(parcel, 56, gv2.getWorstRating(), true);
        }
        b.D(parcel, n3);
    }

    public gv[] aR(int n2) {
        return new gv[n2];
    }

    public gv aj(Parcel parcel) {
        int n2 = a.k(parcel);
        HashSet<Integer> hashSet = new HashSet<Integer>();
        int n3 = 0;
        gv gv2 = null;
        ArrayList<String> arrayList = null;
        gv gv3 = null;
        String string2 = null;
        String string3 = null;
        String string4 = null;
        ArrayList<gv> arrayList2 = null;
        int n4 = 0;
        ArrayList<gv> arrayList3 = null;
        gv gv4 = null;
        ArrayList<gv> arrayList4 = null;
        String string5 = null;
        String string6 = null;
        gv gv5 = null;
        String string7 = null;
        String string8 = null;
        String string9 = null;
        ArrayList<gv> arrayList5 = null;
        String string10 = null;
        String string11 = null;
        String string12 = null;
        String string13 = null;
        String string14 = null;
        String string15 = null;
        String string16 = null;
        String string17 = null;
        String string18 = null;
        gv gv6 = null;
        String string19 = null;
        String string20 = null;
        String string21 = null;
        String string22 = null;
        gv gv7 = null;
        double d2 = 0.0;
        gv gv8 = null;
        double d3 = 0.0;
        String string23 = null;
        gv gv9 = null;
        ArrayList<gv> arrayList6 = null;
        String string24 = null;
        String string25 = null;
        String string26 = null;
        String string27 = null;
        gv gv10 = null;
        String string28 = null;
        String string29 = null;
        String string30 = null;
        gv gv11 = null;
        String string31 = null;
        String string32 = null;
        String string33 = null;
        String string34 = null;
        String string35 = null;
        String string36 = null;
        block57: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new gv(hashSet, n3, gv2, arrayList, gv3, string2, string3, string4, arrayList2, n4, arrayList3, gv4, arrayList4, string5, string6, gv5, string7, string8, string9, arrayList5, string10, string11, string12, string13, string14, string15, string16, string17, string18, gv6, string19, string20, string21, string22, gv7, d2, gv8, d3, string23, gv9, arrayList6, string24, string25, string26, string27, gv10, string28, string29, string30, gv11, string31, string32, string33, string34, string35, string36);
                throw new a.a("Overread allowed size end=" + n2, parcel);
            }
            int n5 = a.j(parcel);
            switch (a.A(n5)) {
                default: {
                    a.b(parcel, n5);
                    continue block57;
                }
                case 1: {
                    n3 = a.g(parcel, n5);
                    hashSet.add(1);
                    continue block57;
                }
                case 2: {
                    gv2 = a.a(parcel, n5, gv.CREATOR);
                    hashSet.add(2);
                    continue block57;
                }
                case 3: {
                    arrayList = a.y(parcel, n5);
                    hashSet.add(3);
                    continue block57;
                }
                case 4: {
                    gv3 = a.a(parcel, n5, gv.CREATOR);
                    hashSet.add(4);
                    continue block57;
                }
                case 5: {
                    string2 = a.m(parcel, n5);
                    hashSet.add(5);
                    continue block57;
                }
                case 6: {
                    string3 = a.m(parcel, n5);
                    hashSet.add(6);
                    continue block57;
                }
                case 7: {
                    string4 = a.m(parcel, n5);
                    hashSet.add(7);
                    continue block57;
                }
                case 8: {
                    arrayList2 = a.c(parcel, n5, gv.CREATOR);
                    hashSet.add(8);
                    continue block57;
                }
                case 9: {
                    n4 = a.g(parcel, n5);
                    hashSet.add(9);
                    continue block57;
                }
                case 10: {
                    arrayList3 = a.c(parcel, n5, gv.CREATOR);
                    hashSet.add(10);
                    continue block57;
                }
                case 11: {
                    gv4 = a.a(parcel, n5, gv.CREATOR);
                    hashSet.add(11);
                    continue block57;
                }
                case 12: {
                    arrayList4 = a.c(parcel, n5, gv.CREATOR);
                    hashSet.add(12);
                    continue block57;
                }
                case 13: {
                    string5 = a.m(parcel, n5);
                    hashSet.add(13);
                    continue block57;
                }
                case 14: {
                    string6 = a.m(parcel, n5);
                    hashSet.add(14);
                    continue block57;
                }
                case 15: {
                    gv5 = a.a(parcel, n5, gv.CREATOR);
                    hashSet.add(15);
                    continue block57;
                }
                case 17: {
                    string8 = a.m(parcel, n5);
                    hashSet.add(17);
                    continue block57;
                }
                case 16: {
                    string7 = a.m(parcel, n5);
                    hashSet.add(16);
                    continue block57;
                }
                case 19: {
                    arrayList5 = a.c(parcel, n5, gv.CREATOR);
                    hashSet.add(19);
                    continue block57;
                }
                case 18: {
                    string9 = a.m(parcel, n5);
                    hashSet.add(18);
                    continue block57;
                }
                case 21: {
                    string11 = a.m(parcel, n5);
                    hashSet.add(21);
                    continue block57;
                }
                case 20: {
                    string10 = a.m(parcel, n5);
                    hashSet.add(20);
                    continue block57;
                }
                case 23: {
                    string13 = a.m(parcel, n5);
                    hashSet.add(23);
                    continue block57;
                }
                case 22: {
                    string12 = a.m(parcel, n5);
                    hashSet.add(22);
                    continue block57;
                }
                case 25: {
                    string15 = a.m(parcel, n5);
                    hashSet.add(25);
                    continue block57;
                }
                case 24: {
                    string14 = a.m(parcel, n5);
                    hashSet.add(24);
                    continue block57;
                }
                case 27: {
                    string17 = a.m(parcel, n5);
                    hashSet.add(27);
                    continue block57;
                }
                case 26: {
                    string16 = a.m(parcel, n5);
                    hashSet.add(26);
                    continue block57;
                }
                case 29: {
                    gv6 = a.a(parcel, n5, gv.CREATOR);
                    hashSet.add(29);
                    continue block57;
                }
                case 28: {
                    string18 = a.m(parcel, n5);
                    hashSet.add(28);
                    continue block57;
                }
                case 31: {
                    string20 = a.m(parcel, n5);
                    hashSet.add(31);
                    continue block57;
                }
                case 30: {
                    string19 = a.m(parcel, n5);
                    hashSet.add(30);
                    continue block57;
                }
                case 34: {
                    gv7 = a.a(parcel, n5, gv.CREATOR);
                    hashSet.add(34);
                    continue block57;
                }
                case 32: {
                    string21 = a.m(parcel, n5);
                    hashSet.add(32);
                    continue block57;
                }
                case 33: {
                    string22 = a.m(parcel, n5);
                    hashSet.add(33);
                    continue block57;
                }
                case 38: {
                    d3 = a.k(parcel, n5);
                    hashSet.add(38);
                    continue block57;
                }
                case 39: {
                    string23 = a.m(parcel, n5);
                    hashSet.add(39);
                    continue block57;
                }
                case 36: {
                    d2 = a.k(parcel, n5);
                    hashSet.add(36);
                    continue block57;
                }
                case 37: {
                    gv8 = a.a(parcel, n5, gv.CREATOR);
                    hashSet.add(37);
                    continue block57;
                }
                case 42: {
                    string24 = a.m(parcel, n5);
                    hashSet.add(42);
                    continue block57;
                }
                case 43: {
                    string25 = a.m(parcel, n5);
                    hashSet.add(43);
                    continue block57;
                }
                case 40: {
                    gv9 = a.a(parcel, n5, gv.CREATOR);
                    hashSet.add(40);
                    continue block57;
                }
                case 41: {
                    arrayList6 = a.c(parcel, n5, gv.CREATOR);
                    hashSet.add(41);
                    continue block57;
                }
                case 46: {
                    gv10 = a.a(parcel, n5, gv.CREATOR);
                    hashSet.add(46);
                    continue block57;
                }
                case 47: {
                    string28 = a.m(parcel, n5);
                    hashSet.add(47);
                    continue block57;
                }
                case 44: {
                    string26 = a.m(parcel, n5);
                    hashSet.add(44);
                    continue block57;
                }
                case 45: {
                    string27 = a.m(parcel, n5);
                    hashSet.add(45);
                    continue block57;
                }
                case 51: {
                    string31 = a.m(parcel, n5);
                    hashSet.add(51);
                    continue block57;
                }
                case 50: {
                    gv11 = a.a(parcel, n5, gv.CREATOR);
                    hashSet.add(50);
                    continue block57;
                }
                case 49: {
                    string30 = a.m(parcel, n5);
                    hashSet.add(49);
                    continue block57;
                }
                case 48: {
                    string29 = a.m(parcel, n5);
                    hashSet.add(48);
                    continue block57;
                }
                case 55: {
                    string35 = a.m(parcel, n5);
                    hashSet.add(55);
                    continue block57;
                }
                case 54: {
                    string34 = a.m(parcel, n5);
                    hashSet.add(54);
                    continue block57;
                }
                case 53: {
                    string33 = a.m(parcel, n5);
                    hashSet.add(53);
                    continue block57;
                }
                case 52: {
                    string32 = a.m(parcel, n5);
                    hashSet.add(52);
                    continue block57;
                }
                case 56: 
            }
            string36 = a.m(parcel, n5);
            hashSet.add(56);
        }
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.aj(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.aR(n2);
    }
}

