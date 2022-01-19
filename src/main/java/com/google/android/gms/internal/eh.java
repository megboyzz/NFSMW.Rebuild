/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 */
package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.du;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.eg;
import com.google.android.gms.internal.ei;
import com.google.android.gms.internal.ej;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class eh
implements SafeParcelable {
    public static final ei CREATOR = new ei();
    private final int kZ;
    private final HashMap<String, HashMap<String, ee.a<?, ?>>> nH;
    private final ArrayList<a> nI;
    private final String nJ;

    eh(int n2, ArrayList<a> arrayList, String string2) {
        this.kZ = n2;
        this.nI = null;
        this.nH = eh.b(arrayList);
        this.nJ = du.f(string2);
        this.cd();
    }

    public eh(Class<? extends ee> clazz) {
        this.kZ = 1;
        this.nI = null;
        this.nH = new HashMap();
        this.nJ = clazz.getCanonicalName();
    }

    private static HashMap<String, HashMap<String, ee.a<?, ?>>> b(ArrayList<a> arrayList) {
        HashMap hashMap = new HashMap();
        int n2 = arrayList.size();
        int n3 = 0;
        while (n3 < n2) {
            a a2 = arrayList.get(n3);
            hashMap.put(a2.className, a2.ch());
            ++n3;
        }
        return hashMap;
    }

    public HashMap<String, ee.a<?, ?>> N(String string2) {
        return this.nH.get(string2);
    }

    public void a(Class<? extends ee> clazz, HashMap<String, ee.a<?, ?>> hashMap) {
        this.nH.put(clazz.getCanonicalName(), hashMap);
    }

    public boolean b(Class<? extends ee> clazz) {
        return this.nH.containsKey(clazz.getCanonicalName());
    }

    public void cd() {
        Iterator<String> iterator = this.nH.keySet().iterator();
        block0: while (iterator.hasNext()) {
            Object object = iterator.next();
            object = this.nH.get(object);
            Iterator iterator2 = ((HashMap)object).keySet().iterator();
            while (true) {
                if (!iterator2.hasNext()) continue block0;
                ((ee.a)((HashMap)object).get((String)iterator2.next())).a(this);
            }
            break;
        }
        return;
    }

    public void ce() {
        Iterator<String> iterator = this.nH.keySet().iterator();
        while (iterator.hasNext()) {
            String string2 = iterator.next();
            HashMap<String, ee.a<?, ?>> hashMap = this.nH.get(string2);
            HashMap hashMap2 = new HashMap();
            for (String string3 : hashMap.keySet()) {
                hashMap2.put(string3, hashMap.get(string3).bT());
            }
            this.nH.put(string2, hashMap2);
        }
    }

    ArrayList<a> cf() {
        ArrayList<a> arrayList = new ArrayList<a>();
        Iterator<String> iterator = this.nH.keySet().iterator();
        while (iterator.hasNext()) {
            String string2 = iterator.next();
            arrayList.add(new a(string2, this.nH.get(string2)));
        }
        return arrayList;
    }

    public String cg() {
        return this.nJ;
    }

    public int describeContents() {
        ei ei2 = CREATOR;
        return 0;
    }

    int getVersionCode() {
        return this.kZ;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<String> iterator = this.nH.keySet().iterator();
        block0: while (iterator.hasNext()) {
            Object object = iterator.next();
            stringBuilder.append((String)object).append(":\n");
            object = this.nH.get(object);
            Iterator iterator2 = ((HashMap)object).keySet().iterator();
            while (true) {
                if (!iterator2.hasNext()) continue block0;
                String string2 = (String)iterator2.next();
                stringBuilder.append("  ").append(string2).append(": ");
                stringBuilder.append(((HashMap)object).get(string2));
            }
            break;
        }
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n2) {
        ei ei2 = CREATOR;
        ei.a(this, parcel, n2);
    }

    public static class a
    implements SafeParcelable {
        public static final ej CREATOR = new ej();
        final String className;
        final ArrayList<b> nK;
        final int versionCode;

        a(int n2, String string2, ArrayList<b> arrayList) {
            this.versionCode = n2;
            this.className = string2;
            this.nK = arrayList;
        }

        a(String string2, HashMap<String, ee.a<?, ?>> hashMap) {
            this.versionCode = 1;
            this.className = string2;
            this.nK = a.b(hashMap);
        }

        private static ArrayList<b> b(HashMap<String, ee.a<?, ?>> hashMap) {
            if (hashMap == null) {
                return null;
            }
            ArrayList<b> arrayList = new ArrayList<b>();
            Iterator<String> iterator = hashMap.keySet().iterator();
            while (iterator.hasNext()) {
                String string2 = iterator.next();
                arrayList.add(new b(string2, hashMap.get(string2)));
            }
            return arrayList;
        }

        HashMap<String, ee.a<?, ?>> ch() {
            HashMap hashMap = new HashMap();
            int n2 = this.nK.size();
            int n3 = 0;
            while (n3 < n2) {
                b b2 = this.nK.get(n3);
                hashMap.put(b2.nL, b2.nM);
                ++n3;
            }
            return hashMap;
        }

        public int describeContents() {
            ej ej2 = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int n2) {
            ej ej2 = CREATOR;
            ej.a(this, parcel, n2);
        }
    }

    public static class b
    implements SafeParcelable {
        public static final eg CREATOR = new eg();
        final String nL;
        final ee.a<?, ?> nM;
        final int versionCode;

        b(int n2, String string2, ee.a<?, ?> a2) {
            this.versionCode = n2;
            this.nL = string2;
            this.nM = a2;
        }

        b(String string2, ee.a<?, ?> a2) {
            this.versionCode = 1;
            this.nL = string2;
            this.nM = a2;
        }

        public int describeContents() {
            eg eg2 = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int n2) {
            eg eg2 = CREATOR;
            eg.a(this, parcel, n2);
        }
    }
}

