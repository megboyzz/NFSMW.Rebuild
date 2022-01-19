/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.view.View
 */
package com.google.android.gms.internal;

import android.os.Parcel;
import android.view.View;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.dt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class dh {
    private final View kQ;
    private final a mt;

    public dh(String string2, Collection<String> collection, int n2, View view, String string3) {
        this.mt = new a(string2, collection, n2, string3);
        this.kQ = view;
    }

    public String bt() {
        return this.mt.bt();
    }

    public List<String> bu() {
        return this.mt.bu();
    }

    public static final class a
    implements SafeParcelable {
        public static final dt CREATOR = new dt();
        private final String jD;
        private final int kP;
        private final String kR;
        private final int kZ;
        private final List<String> mu = new ArrayList<String>();

        a(int n2, String string2, List<String> list, int n3, String string3) {
            this.kZ = n2;
            this.jD = string2;
            this.mu.addAll(list);
            this.kP = n3;
            this.kR = string3;
        }

        public a(String string2, Collection<String> collection, int n2, String string3) {
            this(3, string2, new ArrayList<String>(collection), n2, string3);
        }

        public String bt() {
            if (this.jD == null) return "<<default account>>";
            return this.jD;
        }

        public List<String> bu() {
            return new ArrayList<String>(this.mu);
        }

        public int bv() {
            return this.kP;
        }

        public String bw() {
            return this.kR;
        }

        public int describeContents() {
            return 0;
        }

        public String getAccountName() {
            return this.jD;
        }

        public int getVersionCode() {
            return this.kZ;
        }

        public void writeToParcel(Parcel parcel, int n2) {
            dt.a(this, parcel, n2);
        }
    }
}

