/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 */
package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ec;
import com.google.android.gms.internal.ed;
import com.google.android.gms.internal.ee;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class eb
implements SafeParcelable,
ee.b<String, Integer> {
    public static final ec CREATOR = new ec();
    private final int kZ;
    private final HashMap<String, Integer> ns;
    private final HashMap<Integer, String> nt;
    private final ArrayList<a> nu;

    public eb() {
        this.kZ = 1;
        this.ns = new HashMap();
        this.nt = new HashMap();
        this.nu = null;
    }

    eb(int n2, ArrayList<a> arrayList) {
        this.kZ = n2;
        this.ns = new HashMap();
        this.nt = new HashMap();
        this.nu = null;
        this.a(arrayList);
    }

    private void a(ArrayList<a> object) {
        object = ((ArrayList)object).iterator();
        while (object.hasNext()) {
            a a2 = (a)object.next();
            this.b(a2.nv, a2.nw);
        }
    }

    public String a(Integer object) {
        String string2 = this.nt.get(object);
        object = string2;
        if (string2 != null) return object;
        object = string2;
        if (!this.ns.containsKey("gms_unknown")) return object;
        return "gms_unknown";
    }

    public eb b(String string2, int n2) {
        this.ns.put(string2, n2);
        this.nt.put(n2, string2);
        return this;
    }

    ArrayList<a> bN() {
        ArrayList<a> arrayList = new ArrayList<a>();
        Iterator<String> iterator = this.ns.keySet().iterator();
        while (iterator.hasNext()) {
            String string2 = iterator.next();
            arrayList.add(new a(string2, this.ns.get(string2)));
        }
        return arrayList;
    }

    @Override
    public int bO() {
        return 7;
    }

    @Override
    public int bP() {
        return 0;
    }

    public int describeContents() {
        ec ec2 = CREATOR;
        return 0;
    }

    @Override
    public /* synthetic */ Object g(Object object) {
        return this.a((Integer)object);
    }

    int getVersionCode() {
        return this.kZ;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        ec ec2 = CREATOR;
        ec.a(this, parcel, n2);
    }

    public static final class a
    implements SafeParcelable {
        public static final ed CREATOR = new ed();
        final String nv;
        final int nw;
        final int versionCode;

        a(int n2, String string2, int n3) {
            this.versionCode = n2;
            this.nv = string2;
            this.nw = n3;
        }

        a(String string2, int n2) {
            this.versionCode = 1;
            this.nv = string2;
            this.nw = n2;
        }

        public int describeContents() {
            ed ed2 = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int n2) {
            ed ed2 = CREATOR;
            ed.a(this, parcel, n2);
        }
    }
}

