/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 */
package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ds;
import com.google.android.gms.internal.ft;
import com.google.android.gms.internal.fw;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class fs
implements SafeParcelable {
    public static final ft CREATOR = new ft();
    final int kZ;
    private final int uc;
    final List<fw> ud;
    private final String ue;
    private final String uf;
    private final boolean ug;
    private final Set<fw> uh;

    fs(int n2, int n3, List<fw> list, String string2, String string3, boolean bl2) {
        this.kZ = n2;
        this.uc = n3;
        list = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.ud = list;
        list = string2;
        if (string2 == null) {
            list = "";
        }
        this.ue = list;
        list = string3;
        if (string3 == null) {
            list = "";
        }
        this.uf = list;
        this.ug = bl2;
        if (this.ud.isEmpty()) {
            this.uh = Collections.emptySet();
            return;
        }
        this.uh = Collections.unmodifiableSet(new HashSet<fw>(this.ud));
    }

    public int describeContents() {
        ft ft2 = CREATOR;
        return 0;
    }

    public int dw() {
        return this.uc;
    }

    public String dx() {
        return this.ue;
    }

    public String dy() {
        return this.uf;
    }

    public boolean dz() {
        return this.ug;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof fs)) {
            return false;
        }
        object = (fs)object;
        if (this.uc != ((fs)object).uc) return false;
        if (!((Object)this.uh).equals(((fs)object).uh)) return false;
        if (this.ue != ((fs)object).ue) return false;
        if (this.uf != ((fs)object).uf) return false;
        if (this.ug == ((fs)object).ug) return true;
        return false;
    }

    public int hashCode() {
        return ds.hashCode(this.uc, this.uh, this.ue, this.uf, this.ug);
    }

    public String toString() {
        return ds.e(this).a("maxResults", this.uc).a("types", this.uh).a("nameQuery", this.ue).a("textQuery", this.uf).a("isOpenNowRequired", this.ug).toString();
    }

    public void writeToParcel(Parcel parcel, int n2) {
        ft ft2 = CREATOR;
        ft.a(this, parcel, n2);
    }
}

