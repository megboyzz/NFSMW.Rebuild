/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.wallet.Address;

public class a
implements Parcelable.Creator<Address> {
    static void a(Address address, Parcel parcel, int n2) {
        n2 = b.l(parcel);
        b.c(parcel, 1, address.getVersionCode());
        b.a(parcel, 2, address.name, false);
        b.a(parcel, 3, address.BA, false);
        b.a(parcel, 4, address.BB, false);
        b.a(parcel, 5, address.BC, false);
        b.a(parcel, 6, address.ia, false);
        b.a(parcel, 7, address.BD, false);
        b.a(parcel, 8, address.BE, false);
        b.a(parcel, 9, address.BF, false);
        b.a(parcel, 10, address.BG, false);
        b.a(parcel, 11, address.BH);
        b.a(parcel, 12, address.BI, false);
        b.D(parcel, n2);
    }

    public Address av(Parcel parcel) {
        int n2 = com.google.android.gms.common.internal.safeparcel.a.k(parcel);
        int n3 = 0;
        String string2 = null;
        String string3 = null;
        String string4 = null;
        String string5 = null;
        String string6 = null;
        String string7 = null;
        String string8 = null;
        String string9 = null;
        String string10 = null;
        boolean bl2 = false;
        String string11 = null;
        block14: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new Address(n3, string2, string3, string4, string5, string6, string7, string8, string9, string10, bl2, string11);
                throw new a.a("Overread allowed size end=" + n2, parcel);
            }
            int n4 = com.google.android.gms.common.internal.safeparcel.a.j(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.A(n4)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, n4);
                    continue block14;
                }
                case 1: {
                    n3 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, n4);
                    continue block14;
                }
                case 2: {
                    string2 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, n4);
                    continue block14;
                }
                case 3: {
                    string3 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, n4);
                    continue block14;
                }
                case 4: {
                    string4 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, n4);
                    continue block14;
                }
                case 5: {
                    string5 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, n4);
                    continue block14;
                }
                case 6: {
                    string6 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, n4);
                    continue block14;
                }
                case 7: {
                    string7 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, n4);
                    continue block14;
                }
                case 8: {
                    string8 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, n4);
                    continue block14;
                }
                case 9: {
                    string9 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, n4);
                    continue block14;
                }
                case 10: {
                    string10 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, n4);
                    continue block14;
                }
                case 11: {
                    bl2 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, n4);
                    continue block14;
                }
                case 12: 
            }
            string11 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, n4);
        }
    }

    public Address[] bd(int n2) {
        return new Address[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.av(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.bd(n2);
    }
}

