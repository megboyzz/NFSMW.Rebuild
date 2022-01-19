/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 */
package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.aj;

public final class ai
implements SafeParcelable {
    public static final aj CREATOR = new aj();
    public final int backgroundColor;
    public final int eZ;
    public final int fa;
    public final int fb;
    public final int fc;
    public final int fd;
    public final int fe;
    public final int ff;
    public final String fg;
    public final int fh;
    public final String fi;
    public final int fj;
    public final int fk;
    public final String fl;
    public final int versionCode;

    ai(int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, String string2, int n11, String string3, int n12, int n13, String string4) {
        this.versionCode = n2;
        this.eZ = n3;
        this.backgroundColor = n4;
        this.fa = n5;
        this.fb = n6;
        this.fc = n7;
        this.fd = n8;
        this.fe = n9;
        this.ff = n10;
        this.fg = string2;
        this.fh = n11;
        this.fi = string3;
        this.fj = n12;
        this.fk = n13;
        this.fl = string4;
    }

    public ai(SearchAdRequest searchAdRequest) {
        this.versionCode = 1;
        this.eZ = searchAdRequest.getAnchorTextColor();
        this.backgroundColor = searchAdRequest.getBackgroundColor();
        this.fa = searchAdRequest.getBackgroundGradientBottom();
        this.fb = searchAdRequest.getBackgroundGradientTop();
        this.fc = searchAdRequest.getBorderColor();
        this.fd = searchAdRequest.getBorderThickness();
        this.fe = searchAdRequest.getBorderType();
        this.ff = searchAdRequest.getCallButtonColor();
        this.fg = searchAdRequest.getCustomChannels();
        this.fh = searchAdRequest.getDescriptionTextColor();
        this.fi = searchAdRequest.getFontFace();
        this.fj = searchAdRequest.getHeaderTextColor();
        this.fk = searchAdRequest.getHeaderTextSize();
        this.fl = searchAdRequest.getQuery();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        aj.a(this, parcel, n2);
    }
}

