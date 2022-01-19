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
import com.google.android.gms.internal.gs;

public class gu
implements Parcelable.Creator<gs> {
    static void a(gs gs2, Parcel parcel, int n2) {
        n2 = b.l(parcel);
        b.a(parcel, 1, gs2.getAccountName(), false);
        b.c(parcel, 1000, gs2.getVersionCode());
        b.a(parcel, 2, gs2.ew(), false);
        b.a(parcel, 3, gs2.ex(), false);
        b.a(parcel, 4, gs2.ey(), false);
        b.a(parcel, 5, gs2.ez(), false);
        b.a(parcel, 6, gs2.eA(), false);
        b.a(parcel, 7, gs2.eB(), false);
        b.a(parcel, 8, gs2.eC(), false);
        b.D(parcel, n2);
    }

    public gs[] aQ(int n2) {
        return new gs[n2];
    }

    public gs ai(Parcel parcel) {
        String string2 = null;
        int n2 = a.k(parcel);
        int n3 = 0;
        String string3 = null;
        String string4 = null;
        String string5 = null;
        String[] stringArray = null;
        String[] stringArray2 = null;
        String[] stringArray3 = null;
        String string6 = null;
        block11: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new gs(n3, string6, stringArray3, stringArray2, stringArray, string5, string4, string3, string2);
                throw new a.a("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.j(parcel);
            switch (a.A(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block11;
                }
                case 1: {
                    string6 = a.m(parcel, n4);
                    continue block11;
                }
                case 1000: {
                    n3 = a.g(parcel, n4);
                    continue block11;
                }
                case 2: {
                    stringArray3 = a.x(parcel, n4);
                    continue block11;
                }
                case 3: {
                    stringArray2 = a.x(parcel, n4);
                    continue block11;
                }
                case 4: {
                    stringArray = a.x(parcel, n4);
                    continue block11;
                }
                case 5: {
                    string5 = a.m(parcel, n4);
                    continue block11;
                }
                case 6: {
                    string4 = a.m(parcel, n4);
                    continue block11;
                }
                case 7: {
                    string3 = a.m(parcel, n4);
                    continue block11;
                }
                case 8: 
            }
            string2 = a.m(parcel, n4);
        }
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.ai(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.aQ(n2);
    }
}

