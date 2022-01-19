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
import com.google.android.gms.internal.dz;
import com.google.android.gms.internal.ef;
import com.google.android.gms.internal.eh;
import com.google.android.gms.internal.ek;
import com.google.android.gms.internal.en;
import com.google.android.gms.internal.eq;
import com.google.android.gms.internal.er;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class ee {
    private void a(StringBuilder stringBuilder, a a2, Object object) {
        if (a2.bO() == 11) {
            stringBuilder.append(a2.bY().cast(object).toString());
            return;
        }
        if (a2.bO() == 7) {
            stringBuilder.append("\"");
            stringBuilder.append(eq.O((String)object));
            stringBuilder.append("\"");
            return;
        }
        stringBuilder.append(object);
    }

    private void a(StringBuilder stringBuilder, a a2, ArrayList<Object> arrayList) {
        stringBuilder.append("[");
        int n2 = 0;
        int n3 = arrayList.size();
        while (true) {
            Object object;
            if (n2 >= n3) {
                stringBuilder.append("]");
                return;
            }
            if (n2 > 0) {
                stringBuilder.append(",");
            }
            if ((object = arrayList.get(n2)) != null) {
                this.a(stringBuilder, a2, object);
            }
            ++n2;
        }
    }

    protected abstract Object J(String var1);

    protected abstract boolean K(String var1);

    protected boolean L(String string2) {
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    protected boolean M(String string2) {
        throw new UnsupportedOperationException("Concrete type arrays not supported");
    }

    protected <O, I> I a(a<I, O> a2, Object object) {
        Object object2 = object;
        if (((a)a2).nG == null) return (I)object2;
        object2 = a2.g(object);
        return (I)object2;
    }

    protected boolean a(a a2) {
        if (a2.bP() != 11) return this.K(a2.bW());
        if (!a2.bV()) return this.L(a2.bW());
        return this.M(a2.bW());
    }

    protected Object b(a hashMap) {
        boolean bl2 = true;
        String string2 = ((a)((Object)hashMap)).bW();
        if (((a)((Object)hashMap)).bY() == null) return this.J(((a)((Object)hashMap)).bW());
        if (this.J(((a)((Object)hashMap)).bW()) != null) {
            bl2 = false;
        }
        du.a(bl2, "Concrete field shouldn't be value object: " + ((a)((Object)hashMap)).bW());
        hashMap = ((a)((Object)hashMap)).bV() ? this.bS() : this.bR();
        if (hashMap != null) {
            return hashMap.get(string2);
        }
        try {
            hashMap = "get" + Character.toUpperCase(string2.charAt(0)) + string2.substring(1);
            return this.getClass().getMethod((String)((Object)hashMap), new Class[0]).invoke(this, new Object[0]);
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public abstract HashMap<String, a<?, ?>> bQ();

    public HashMap<String, Object> bR() {
        return null;
    }

    public HashMap<String, Object> bS() {
        return null;
    }

    public String toString() {
        HashMap<String, a<?, ?>> hashMap = this.bQ();
        StringBuilder stringBuilder = new StringBuilder(100);
        block5: for (String string2 : hashMap.keySet()) {
            a<?, ?> a2 = hashMap.get(string2);
            if (!this.a(a2)) continue;
            Object obj = this.a(a2, this.b(a2));
            if (stringBuilder.length() == 0) {
                stringBuilder.append("{");
            } else {
                stringBuilder.append(",");
            }
            stringBuilder.append("\"").append(string2).append("\":");
            if (obj == null) {
                stringBuilder.append("null");
                continue;
            }
            switch (a2.bP()) {
                default: {
                    if (!a2.bU()) break;
                    this.a(stringBuilder, a2, (ArrayList)obj);
                    continue block5;
                }
                case 8: {
                    stringBuilder.append("\"").append(en.b((byte[])obj)).append("\"");
                    continue block5;
                }
                case 9: {
                    stringBuilder.append("\"").append(en.c((byte[])obj)).append("\"");
                    continue block5;
                }
                case 10: {
                    er.a(stringBuilder, (HashMap)obj);
                    continue block5;
                }
            }
            this.a(stringBuilder, a2, obj);
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
        stringBuilder.append("{}");
        return stringBuilder.toString();
    }

    public static class a<I, O>
    implements SafeParcelable {
        public static final ef CREATOR = new ef();
        private final int kZ;
        protected final boolean nA;
        protected final String nB;
        protected final int nC;
        protected final Class<? extends ee> nD;
        protected final String nE;
        private eh nF;
        private b<I, O> nG;
        protected final int nx;
        protected final boolean ny;
        protected final int nz;

        a(int n2, int n3, boolean bl2, int n4, boolean bl3, String string2, int n5, String string3, dz dz2) {
            this.kZ = n2;
            this.nx = n3;
            this.ny = bl2;
            this.nz = n4;
            this.nA = bl3;
            this.nB = string2;
            this.nC = n5;
            if (string3 == null) {
                this.nD = null;
                this.nE = null;
            } else {
                this.nD = ek.class;
                this.nE = string3;
            }
            if (dz2 == null) {
                this.nG = null;
                return;
            }
            this.nG = dz2.bM();
        }

        protected a(int n2, boolean bl2, int n3, boolean bl3, String string2, int n4, Class<? extends ee> clazz, b<I, O> b2) {
            this.kZ = 1;
            this.nx = n2;
            this.ny = bl2;
            this.nz = n3;
            this.nA = bl3;
            this.nB = string2;
            this.nC = n4;
            this.nD = clazz;
            this.nE = clazz == null ? null : clazz.getCanonicalName();
            this.nG = b2;
        }

        public static a a(String string2, int n2, b<?, ?> b2, boolean bl2) {
            return new a(b2.bO(), bl2, b2.bP(), false, string2, n2, null, b2);
        }

        public static <T extends ee> a<T, T> a(String string2, int n2, Class<T> clazz) {
            return new a(11, false, 11, false, string2, n2, clazz, null);
        }

        public static <T extends ee> a<ArrayList<T>, ArrayList<T>> b(String string2, int n2, Class<T> clazz) {
            return new a<ArrayList<T>, ArrayList<T>>(11, true, 11, true, string2, n2, clazz, null);
        }

        public static a<Integer, Integer> c(String string2, int n2) {
            return new a<Integer, Integer>(0, false, 0, false, string2, n2, null, null);
        }

        public static a<Double, Double> d(String string2, int n2) {
            return new a<Double, Double>(4, false, 4, false, string2, n2, null, null);
        }

        public static a<Boolean, Boolean> e(String string2, int n2) {
            return new a<Boolean, Boolean>(6, false, 6, false, string2, n2, null, null);
        }

        public static a<String, String> f(String string2, int n2) {
            return new a<String, String>(7, false, 7, false, string2, n2, null, null);
        }

        public static a<ArrayList<String>, ArrayList<String>> g(String string2, int n2) {
            return new a<ArrayList<String>, ArrayList<String>>(7, true, 7, true, string2, n2, null, null);
        }

        public void a(eh eh2) {
            this.nF = eh2;
        }

        public int bO() {
            return this.nx;
        }

        public int bP() {
            return this.nz;
        }

        public a<I, O> bT() {
            return new a<I, O>(this.kZ, this.nx, this.ny, this.nz, this.nA, this.nB, this.nC, this.nE, this.cb());
        }

        public boolean bU() {
            return this.ny;
        }

        public boolean bV() {
            return this.nA;
        }

        public String bW() {
            return this.nB;
        }

        public int bX() {
            return this.nC;
        }

        public Class<? extends ee> bY() {
            return this.nD;
        }

        String bZ() {
            if (this.nE != null) return this.nE;
            return null;
        }

        public boolean ca() {
            if (this.nG == null) return false;
            return true;
        }

        dz cb() {
            if (this.nG != null) return dz.a(this.nG);
            return null;
        }

        public HashMap<String, a<?, ?>> cc() {
            du.f(this.nE);
            du.f(this.nF);
            return this.nF.N(this.nE);
        }

        public int describeContents() {
            ef ef2 = CREATOR;
            return 0;
        }

        public I g(O o2) {
            return this.nG.g(o2);
        }

        public int getVersionCode() {
            return this.kZ;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Field\n");
            stringBuilder.append("            versionCode=").append(this.kZ).append('\n');
            stringBuilder.append("                 typeIn=").append(this.nx).append('\n');
            stringBuilder.append("            typeInArray=").append(this.ny).append('\n');
            stringBuilder.append("                typeOut=").append(this.nz).append('\n');
            stringBuilder.append("           typeOutArray=").append(this.nA).append('\n');
            stringBuilder.append("        outputFieldName=").append(this.nB).append('\n');
            stringBuilder.append("      safeParcelFieldId=").append(this.nC).append('\n');
            stringBuilder.append("       concreteTypeName=").append(this.bZ()).append('\n');
            if (this.bY() != null) {
                stringBuilder.append("     concreteType.class=").append(this.bY().getCanonicalName()).append('\n');
            }
            StringBuilder stringBuilder2 = stringBuilder.append("          converterName=");
            String string2 = this.nG == null ? "null" : this.nG.getClass().getCanonicalName();
            stringBuilder2.append(string2).append('\n');
            return stringBuilder.toString();
        }

        public void writeToParcel(Parcel parcel, int n2) {
            ef ef2 = CREATOR;
            ef.a(this, parcel, n2);
        }
    }

    public static interface b<I, O> {
        public int bO();

        public int bP();

        public I g(O var1);
    }
}

