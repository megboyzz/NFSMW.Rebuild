/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  android.util.Log
 */
package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.c;
import com.google.android.gms.drive.metadata.internal.d;
import com.google.android.gms.internal.ds;
import com.google.android.gms.internal.du;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class MetadataBundle
implements SafeParcelable {
    public static final Parcelable.Creator<MetadataBundle> CREATOR = new d();
    final int kZ;
    final Bundle oT;

    MetadataBundle(int n2, Bundle object) {
        this.kZ = n2;
        this.oT = du.f(object);
        this.oT.setClassLoader(this.getClass().getClassLoader());
        object = this.oT.keySet().iterator();
        while (object.hasNext()) {
            String string2 = (String)object.next();
            if (c.P(string2) != null) continue;
            this.oT.remove(string2);
            Log.w((String)"MetadataBundle", (String)("Ignored unknown metadata field in bundle: " + string2));
        }
    }

    private MetadataBundle(Bundle bundle) {
        this(1, bundle);
    }

    public static <T> MetadataBundle a(MetadataField<T> metadataField, T t2) {
        MetadataBundle metadataBundle = MetadataBundle.cE();
        metadataBundle.b(metadataField, t2);
        return metadataBundle;
    }

    public static MetadataBundle a(MetadataBundle metadataBundle) {
        return new MetadataBundle(new Bundle(metadataBundle.oT));
    }

    public static MetadataBundle cE() {
        return new MetadataBundle(new Bundle());
    }

    public <T> T a(MetadataField<T> metadataField) {
        return metadataField.d(this.oT);
    }

    public <T> void b(MetadataField<T> metadataField, T t2) {
        if (c.P(metadataField.getName()) == null) {
            throw new IllegalArgumentException("Unregistered field: " + metadataField.getName());
        }
        metadataField.a(t2, this.oT);
    }

    public Set<MetadataField<?>> cF() {
        HashSet hashSet = new HashSet();
        Iterator iterator = this.oT.keySet().iterator();
        while (iterator.hasNext()) {
            hashSet.add(c.P((String)iterator.next()));
        }
        return hashSet;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        String string2;
        if (this == object) {
            return true;
        }
        if (!(object instanceof MetadataBundle)) {
            return false;
        }
        object = (MetadataBundle)object;
        Object object2 = this.oT.keySet();
        if (!object2.equals(((MetadataBundle)object).oT.keySet())) {
            return false;
        }
        object2 = object2.iterator();
        do {
            if (!object2.hasNext()) return true;
        } while (ds.equal(this.oT.get(string2 = (String)object2.next()), ((MetadataBundle)object).oT.get(string2)));
        return false;
    }

    public int hashCode() {
        Iterator iterator = this.oT.keySet().iterator();
        int n2 = 1;
        while (iterator.hasNext()) {
            String string2 = (String)iterator.next();
            n2 = this.oT.get(string2).hashCode() + n2 * 31;
        }
        return n2;
    }

    public String toString() {
        return "MetadataBundle [values=" + this.oT + "]";
    }

    public void writeToParcel(Parcel parcel, int n2) {
        d.a(this, parcel, n2);
    }
}

