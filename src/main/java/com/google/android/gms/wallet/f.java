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
import com.google.android.gms.wallet.LineItem;

public class f
implements Parcelable.Creator<LineItem> {
    static void a(LineItem lineItem, Parcel parcel, int n2) {
        n2 = b.l(parcel);
        b.c(parcel, 1, lineItem.getVersionCode());
        b.a(parcel, 2, lineItem.description, false);
        b.a(parcel, 3, lineItem.BW, false);
        b.a(parcel, 4, lineItem.BX, false);
        b.a(parcel, 5, lineItem.BJ, false);
        b.c(parcel, 6, lineItem.BY);
        b.a(parcel, 7, lineItem.BK, false);
        b.D(parcel, n2);
    }

    public LineItem aA(Parcel parcel) {
        int n2 = 0;
        String string2 = null;
        int n3 = a.k(parcel);
        String string3 = null;
        String string4 = null;
        String string5 = null;
        String string6 = null;
        int n4 = 0;
        block9: while (true) {
            if (parcel.dataPosition() >= n3) {
                if (parcel.dataPosition() == n3) return new LineItem(n4, string6, string5, string4, string3, n2, string2);
                throw new a.a("Overread allowed size end=" + n3, parcel);
            }
            int n5 = a.j(parcel);
            switch (a.A(n5)) {
                default: {
                    a.b(parcel, n5);
                    continue block9;
                }
                case 1: {
                    n4 = a.g(parcel, n5);
                    continue block9;
                }
                case 2: {
                    string6 = a.m(parcel, n5);
                    continue block9;
                }
                case 3: {
                    string5 = a.m(parcel, n5);
                    continue block9;
                }
                case 4: {
                    string4 = a.m(parcel, n5);
                    continue block9;
                }
                case 5: {
                    string3 = a.m(parcel, n5);
                    continue block9;
                }
                case 6: {
                    n2 = a.g(parcel, n5);
                    continue block9;
                }
                case 7: 
            }
            string2 = a.m(parcel, n5);
        }
    }

    public LineItem[] bi(int n2) {
        return new LineItem[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.aA(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.bi(n2);
    }
}

