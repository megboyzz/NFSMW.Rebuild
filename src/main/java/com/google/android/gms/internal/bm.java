/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable
 */
package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.c;
import com.google.android.gms.internal.al;
import com.google.android.gms.internal.bj;
import com.google.android.gms.internal.bl;
import com.google.android.gms.internal.bn;
import com.google.android.gms.internal.bq;
import com.google.android.gms.internal.ct;
import com.google.android.gms.internal.cv;
import com.google.android.gms.internal.q;

public final class bm
implements SafeParcelable {
    public static final bl CREATOR = new bl();
    public final ct ej;
    public final bj gF;
    public final q gG;
    public final bn gH;
    public final cv gI;
    public final al gJ;
    public final String gK;
    public final boolean gL;
    public final String gM;
    public final bq gN;
    public final int gO;
    public final String gn;
    public final int orientation;
    public final int versionCode;

    bm(int n2, bj bj2, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4, String string2, boolean bl2, String string3, IBinder iBinder5, int n3, int n4, String string4, ct ct2) {
        this.versionCode = n2;
        this.gF = bj2;
        this.gG = (q)c.b(b.a.C(iBinder));
        this.gH = (bn)c.b(b.a.C(iBinder2));
        this.gI = (cv)((Object)c.b(b.a.C(iBinder3)));
        this.gJ = (al)c.b(b.a.C(iBinder4));
        this.gK = string2;
        this.gL = bl2;
        this.gM = string3;
        this.gN = (bq)c.b(b.a.C(iBinder5));
        this.orientation = n3;
        this.gO = n4;
        this.gn = string4;
        this.ej = ct2;
    }

    public bm(bj bj2, q q2, bn bn2, bq bq2, ct ct2) {
        this.versionCode = 1;
        this.gF = bj2;
        this.gG = q2;
        this.gH = bn2;
        this.gI = null;
        this.gJ = null;
        this.gK = null;
        this.gL = false;
        this.gM = null;
        this.gN = bq2;
        this.orientation = -1;
        this.gO = 4;
        this.gn = null;
        this.ej = ct2;
    }

    public bm(q q2, bn bn2, al al2, bq bq2, cv cv2, boolean bl2, int n2, String string2, ct ct2) {
        this.versionCode = 1;
        this.gF = null;
        this.gG = q2;
        this.gH = bn2;
        this.gI = cv2;
        this.gJ = al2;
        this.gK = null;
        this.gL = bl2;
        this.gM = null;
        this.gN = bq2;
        this.orientation = n2;
        this.gO = 3;
        this.gn = string2;
        this.ej = ct2;
    }

    public bm(q q2, bn bn2, al al2, bq bq2, cv cv2, boolean bl2, int n2, String string2, String string3, ct ct2) {
        this.versionCode = 1;
        this.gF = null;
        this.gG = q2;
        this.gH = bn2;
        this.gI = cv2;
        this.gJ = al2;
        this.gK = string3;
        this.gL = bl2;
        this.gM = string2;
        this.gN = bq2;
        this.orientation = n2;
        this.gO = 3;
        this.gn = null;
        this.ej = ct2;
    }

    public bm(q q2, bn bn2, bq bq2, cv cv2, int n2, ct ct2) {
        this.versionCode = 1;
        this.gF = null;
        this.gG = q2;
        this.gH = bn2;
        this.gI = cv2;
        this.gJ = null;
        this.gK = null;
        this.gL = false;
        this.gM = null;
        this.gN = bq2;
        this.orientation = n2;
        this.gO = 1;
        this.gn = null;
        this.ej = ct2;
    }

    public bm(q q2, bn bn2, bq bq2, cv cv2, boolean bl2, int n2, ct ct2) {
        this.versionCode = 1;
        this.gF = null;
        this.gG = q2;
        this.gH = bn2;
        this.gI = cv2;
        this.gJ = null;
        this.gK = null;
        this.gL = bl2;
        this.gM = null;
        this.gN = bq2;
        this.orientation = n2;
        this.gO = 2;
        this.gn = null;
        this.ej = ct2;
    }

    public static bm a(Intent object) {
        try {
            object = object.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            object.setClassLoader(bm.class.getClassLoader());
            return (bm)object.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        }
        catch (Exception exception) {
            return null;
        }
    }

    public static void a(Intent intent, bm bm2) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", (Parcelable)bm2);
        intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
    }

    IBinder aa() {
        return c.h(this.gG).asBinder();
    }

    IBinder ab() {
        return c.h(this.gH).asBinder();
    }

    IBinder ac() {
        return c.h(this.gI).asBinder();
    }

    IBinder ad() {
        return c.h(this.gJ).asBinder();
    }

    IBinder ae() {
        return c.h(this.gN).asBinder();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        bl.a(this, parcel, n2);
    }
}

