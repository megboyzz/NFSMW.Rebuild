/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.location.Location
 *  android.os.Bundle
 *  android.os.Parcel
 */
package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.af;
import com.google.android.gms.internal.ai;
import com.google.android.gms.internal.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public final class v
implements SafeParcelable {
    public static final w CREATOR = new w();
    public final boolean eA;
    public final boolean eB;
    public final String eC;
    public final ai eD;
    public final Location eE;
    public final long ex;
    public final Bundle extras;
    public final int ey;
    public final List<String> ez;
    public final int tagForChildDirectedTreatment;
    public final int versionCode;

    v(int n2, long l2, Bundle bundle, int n3, List<String> list, boolean bl2, int n4, boolean bl3, String string2, ai ai2, Location location) {
        this.versionCode = n2;
        this.ex = l2;
        this.extras = bundle;
        this.ey = n3;
        this.ez = list;
        this.eA = bl2;
        this.tagForChildDirectedTreatment = n4;
        this.eB = bl3;
        this.eC = string2;
        this.eD = ai2;
        this.eE = location;
    }

    public v(Context object, af object2) {
        Object var6_3 = null;
        this.versionCode = 2;
        Collection<Object> collection = ((af)object2).getBirthday();
        long l2 = collection != null ? ((Date)((Object)collection)).getTime() : -1L;
        this.ex = l2;
        this.ey = ((af)object2).getGender();
        collection = ((af)object2).getKeywords();
        collection = !collection.isEmpty() ? Collections.unmodifiableList(new ArrayList(collection)) : null;
        this.ez = collection;
        this.eA = ((af)object2).isTestDevice((Context)object);
        this.tagForChildDirectedTreatment = ((af)object2).S();
        this.eE = ((af)object2).getLocation();
        object = ((af)object2).getNetworkExtras(AdMobExtras.class);
        object = object != null ? ((AdMobExtras)object).getExtras() : null;
        this.extras = object;
        this.eB = ((af)object2).getManualImpressionsEnabled();
        this.eC = ((af)object2).getPublisherProvidedId();
        object2 = ((af)object2).Q();
        object = var6_3;
        if (object2 != null) {
            object = new ai((SearchAdRequest)object2);
        }
        this.eD = object;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        w.a(this, parcel, n2);
    }
}

