/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcel
 */
package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.du;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.eh;
import com.google.android.gms.internal.el;
import com.google.android.gms.internal.em;
import com.google.android.gms.internal.en;
import com.google.android.gms.internal.eq;
import com.google.android.gms.internal.er;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ek
extends ee
implements SafeParcelable {
    public static final el CREATOR = new el();
    private final int kZ;
    private final String mClassName;
    private final eh nF;
    private final Parcel nN;
    private final int nO;
    private int nP;
    private int nQ;

    ek(int n2, Parcel parcel, eh eh2) {
        this.kZ = n2;
        this.nN = du.f(parcel);
        this.nO = 2;
        this.nF = eh2;
        this.mClassName = this.nF == null ? null : this.nF.cg();
        this.nP = 2;
    }

    private ek(SafeParcelable safeParcelable, eh eh2, String string2) {
        this.kZ = 1;
        this.nN = Parcel.obtain();
        safeParcelable.writeToParcel(this.nN, 0);
        this.nO = 1;
        this.nF = du.f(eh2);
        this.mClassName = du.f(string2);
        this.nP = 2;
    }

    public static <T extends ee> ek a(T t2) {
        String string2 = t2.getClass().getCanonicalName();
        eh eh2 = ek.b(t2);
        return new ek((SafeParcelable)((Object)t2), eh2, string2);
    }

    private static void a(eh eh2, ee a2) {
        Class<?> clazz = a2.getClass();
        if (eh2.b(clazz)) return;
        HashMap<String, ee.a<?, ?>> hashMap = ((ee)((Object)a2)).bQ();
        eh2.a(clazz, ((ee)((Object)a2)).bQ());
        clazz = hashMap.keySet().iterator();
        while (clazz.hasNext()) {
            a2 = hashMap.get((String)clazz.next());
            Class<ee> clazz2 = a2.bY();
            if (clazz2 == null) continue;
            try {
                ek.a(eh2, clazz2.newInstance());
            }
            catch (InstantiationException instantiationException) {
                throw new IllegalStateException("Could not instantiate an object of type " + a2.bY().getCanonicalName(), instantiationException);
            }
            catch (IllegalAccessException illegalAccessException) {
                throw new IllegalStateException("Could not access object of type " + a2.bY().getCanonicalName(), illegalAccessException);
            }
        }
    }

    private void a(StringBuilder stringBuilder, int n2, Object object) {
        switch (n2) {
            default: {
                throw new IllegalArgumentException("Unknown type = " + n2);
            }
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: {
                stringBuilder.append(object);
                return;
            }
            case 7: {
                stringBuilder.append("\"").append(eq.O(object.toString())).append("\"");
                return;
            }
            case 8: {
                stringBuilder.append("\"").append(en.b((byte[])object)).append("\"");
                return;
            }
            case 9: {
                stringBuilder.append("\"").append(en.c((byte[])object));
                stringBuilder.append("\"");
                return;
            }
            case 10: {
                er.a(stringBuilder, (HashMap)object);
                return;
            }
            case 11: 
        }
        throw new IllegalArgumentException("Method does not accept concrete type.");
    }

    private void a(StringBuilder stringBuilder, ee.a<?, ?> a2, Parcel parcel, int n2) {
        switch (a2.bP()) {
            default: {
                throw new IllegalArgumentException("Unknown field out type = " + a2.bP());
            }
            case 0: {
                this.b(stringBuilder, a2, this.a(a2, a.g(parcel, n2)));
                return;
            }
            case 1: {
                this.b(stringBuilder, a2, this.a(a2, a.i(parcel, n2)));
                return;
            }
            case 2: {
                this.b(stringBuilder, a2, this.a(a2, a.h(parcel, n2)));
                return;
            }
            case 3: {
                this.b(stringBuilder, a2, this.a(a2, Float.valueOf(a.j(parcel, n2))));
                return;
            }
            case 4: {
                this.b(stringBuilder, a2, this.a(a2, a.k(parcel, n2)));
                return;
            }
            case 5: {
                this.b(stringBuilder, a2, this.a(a2, a.l(parcel, n2)));
                return;
            }
            case 6: {
                this.b(stringBuilder, a2, this.a(a2, a.c(parcel, n2)));
                return;
            }
            case 7: {
                this.b(stringBuilder, a2, this.a(a2, a.m(parcel, n2)));
                return;
            }
            case 8: 
            case 9: {
                this.b(stringBuilder, a2, this.a(a2, a.p(parcel, n2)));
                return;
            }
            case 10: {
                this.b(stringBuilder, a2, this.a(a2, ek.c(a.o(parcel, n2))));
                return;
            }
            case 11: 
        }
        throw new IllegalArgumentException("Method does not accept concrete type.");
    }

    private void a(StringBuilder stringBuilder, String string2, ee.a<?, ?> a2, Parcel parcel, int n2) {
        stringBuilder.append("\"").append(string2).append("\":");
        if (a2.ca()) {
            this.a(stringBuilder, a2, parcel, n2);
            return;
        }
        this.b(stringBuilder, a2, parcel, n2);
    }

    private void a(StringBuilder stringBuilder, HashMap<String, ee.a<?, ?>> hashMap, Parcel parcel) {
        hashMap = ek.c(hashMap);
        stringBuilder.append('{');
        int n2 = a.k(parcel);
        boolean bl2 = false;
        while (parcel.dataPosition() < n2) {
            int n3 = a.j(parcel);
            Map.Entry entry = (Map.Entry)hashMap.get(a.A(n3));
            if (entry == null) continue;
            if (bl2) {
                stringBuilder.append(",");
            }
            this.a(stringBuilder, (String)entry.getKey(), (ee.a)entry.getValue(), parcel, n3);
            bl2 = true;
        }
        if (parcel.dataPosition() != n2) {
            throw new a.a("Overread allowed size end=" + n2, parcel);
        }
        stringBuilder.append('}');
    }

    private static eh b(ee ee2) {
        eh eh2 = new eh(ee2.getClass());
        ek.a(eh2, ee2);
        eh2.ce();
        eh2.cd();
        return eh2;
    }

    private void b(StringBuilder stringBuilder, ee.a<?, ?> object, Parcel object2, int n2) {
        if (((ee.a)object).bV()) {
            stringBuilder.append("[");
            switch (((ee.a)object).bP()) {
                default: {
                    throw new IllegalStateException("Unknown field type out.");
                }
                case 0: {
                    em.a(stringBuilder, a.r((Parcel)object2, n2));
                    break;
                }
                case 1: {
                    em.a(stringBuilder, a.t((Parcel)object2, n2));
                    break;
                }
                case 2: {
                    em.a(stringBuilder, a.s((Parcel)object2, n2));
                    break;
                }
                case 3: {
                    em.a(stringBuilder, a.u((Parcel)object2, n2));
                    break;
                }
                case 4: {
                    em.a(stringBuilder, a.v((Parcel)object2, n2));
                    break;
                }
                case 5: {
                    em.a(stringBuilder, a.w((Parcel)object2, n2));
                    break;
                }
                case 6: {
                    em.a(stringBuilder, a.q((Parcel)object2, n2));
                    break;
                }
                case 7: {
                    em.a(stringBuilder, a.x((Parcel)object2, n2));
                    break;
                }
                case 8: 
                case 9: 
                case 10: {
                    throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                }
                case 11: {
                    object2 = a.A((Parcel)object2, n2);
                    int n3 = ((Parcel[])object2).length;
                    for (n2 = 0; n2 < n3; ++n2) {
                        if (n2 > 0) {
                            stringBuilder.append(",");
                        }
                        object2[n2].setDataPosition(0);
                        this.a(stringBuilder, ((ee.a)object).cc(), (Parcel)object2[n2]);
                    }
                }
            }
            stringBuilder.append("]");
            return;
        }
        switch (((ee.a)object).bP()) {
            default: {
                throw new IllegalStateException("Unknown field type out");
            }
            case 0: {
                stringBuilder.append(a.g((Parcel)object2, n2));
                return;
            }
            case 1: {
                stringBuilder.append(a.i((Parcel)object2, n2));
                return;
            }
            case 2: {
                stringBuilder.append(a.h((Parcel)object2, n2));
                return;
            }
            case 3: {
                stringBuilder.append(a.j((Parcel)object2, n2));
                return;
            }
            case 4: {
                stringBuilder.append(a.k((Parcel)object2, n2));
                return;
            }
            case 5: {
                stringBuilder.append(a.l((Parcel)object2, n2));
                return;
            }
            case 6: {
                stringBuilder.append(a.c((Parcel)object2, n2));
                return;
            }
            case 7: {
                object = a.m((Parcel)object2, n2);
                stringBuilder.append("\"").append(eq.O((String)object)).append("\"");
                return;
            }
            case 8: {
                object = a.p((Parcel)object2, n2);
                stringBuilder.append("\"").append(en.b((byte[])object)).append("\"");
                return;
            }
            case 9: {
                object = a.p((Parcel)object2, n2);
                stringBuilder.append("\"").append(en.c((byte[])object));
                stringBuilder.append("\"");
                return;
            }
            case 10: {
                object = a.o((Parcel)object2, n2);
                object2 = object.keySet();
                object2.size();
                stringBuilder.append("{");
                object2 = object2.iterator();
                n2 = 1;
                while (true) {
                    if (!object2.hasNext()) {
                        stringBuilder.append("}");
                        return;
                    }
                    String string2 = (String)object2.next();
                    if (n2 == 0) {
                        stringBuilder.append(",");
                    }
                    stringBuilder.append("\"").append(string2).append("\"");
                    stringBuilder.append(":");
                    stringBuilder.append("\"").append(eq.O(object.getString(string2))).append("\"");
                    n2 = 0;
                }
            }
            case 11: 
        }
        object2 = a.z((Parcel)object2, n2);
        object2.setDataPosition(0);
        this.a(stringBuilder, ((ee.a)object).cc(), (Parcel)object2);
    }

    private void b(StringBuilder stringBuilder, ee.a<?, ?> a2, Object object) {
        if (a2.bU()) {
            this.b(stringBuilder, a2, (ArrayList)object);
            return;
        }
        this.a(stringBuilder, a2.bO(), object);
    }

    private void b(StringBuilder stringBuilder, ee.a<?, ?> a2, ArrayList<?> arrayList) {
        stringBuilder.append("[");
        int n2 = arrayList.size();
        int n3 = 0;
        while (true) {
            if (n3 >= n2) {
                stringBuilder.append("]");
                return;
            }
            if (n3 != 0) {
                stringBuilder.append(",");
            }
            this.a(stringBuilder, a2.bO(), arrayList.get(n3));
            ++n3;
        }
    }

    public static HashMap<String, String> c(Bundle bundle) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        Iterator iterator = bundle.keySet().iterator();
        while (iterator.hasNext()) {
            String string2 = (String)iterator.next();
            hashMap.put(string2, bundle.getString(string2));
        }
        return hashMap;
    }

    private static HashMap<Integer, Map.Entry<String, ee.a<?, ?>>> c(HashMap<String, ee.a<?, ?>> object) {
        HashMap hashMap = new HashMap();
        object = ((HashMap)object).entrySet().iterator();
        while (object.hasNext()) {
            Map.Entry entry = (Map.Entry)object.next();
            hashMap.put(((ee.a)entry.getValue()).bX(), entry);
        }
        return hashMap;
    }

    @Override
    protected Object J(String string2) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override
    protected boolean K(String string2) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override
    public HashMap<String, ee.a<?, ?>> bQ() {
        if (this.nF != null) return this.nF.N(this.mClassName);
        return null;
    }

    public Parcel ci() {
        switch (this.nP) {
            case 0: {
                this.nQ = b.l(this.nN);
                b.D(this.nN, this.nQ);
                this.nP = 2;
                return this.nN;
            }
            case 1: {
                b.D(this.nN, this.nQ);
                this.nP = 2;
                return this.nN;
            }
        }
        return this.nN;
    }

    eh cj() {
        switch (this.nO) {
            default: {
                throw new IllegalStateException("Invalid creation type: " + this.nO);
            }
            case 0: {
                return null;
            }
            case 1: {
                return this.nF;
            }
            case 2: 
        }
        return this.nF;
    }

    public int describeContents() {
        el el2 = CREATOR;
        return 0;
    }

    public int getVersionCode() {
        return this.kZ;
    }

    @Override
    public String toString() {
        du.c(this.nF, "Cannot convert to JSON on client side.");
        Parcel parcel = this.ci();
        parcel.setDataPosition(0);
        StringBuilder stringBuilder = new StringBuilder(100);
        this.a(stringBuilder, this.nF.N(this.mClassName), parcel);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n2) {
        el el2 = CREATOR;
        el.a(this, parcel, n2);
    }
}

