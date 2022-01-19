/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  android.util.Base64
 */
package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.c;
import com.google.android.gms.drive.internal.q;
import com.google.android.gms.internal.du;
import com.google.android.gms.internal.hs;
import com.google.android.gms.internal.ht;

public class DriveId
implements SafeParcelable {
    public static final Parcelable.Creator<DriveId> CREATOR = new c();
    final int kZ;
    final String od;
    final long oe;
    final long of;
    private volatile String og = null;

    DriveId(int n2, String string2, long l2, long l3) {
        this.kZ = n2;
        this.od = string2;
        boolean bl2 = !"".equals(string2);
        du.p(bl2);
        this.oe = l2;
        this.of = l3;
    }

    public DriveId(String string2, long l2, long l3) {
        this(1, string2, l2, l3);
    }

    public static DriveId createFromResourceId(String string2) {
        du.f(string2);
        return new DriveId(string2, -1L, -1L);
    }

    static DriveId d(byte[] object) {
        q q2;
        block2: {
            try {
                q2 = q.e(object);
                if (!"".equals(q2.oH)) break block2;
                object = null;
                return new DriveId(q2.versionCode, (String)object, q2.oI, q2.oJ);
            }
            catch (hs hs2) {
                throw new IllegalArgumentException();
            }
        }
        object = q2.oH;
        return new DriveId(q2.versionCode, (String)object, q2.oI, q2.oJ);
    }

    public static DriveId decodeFromString(String string2) {
        du.b(string2.startsWith("DriveId:"), "Invalid DriveId: " + string2);
        return DriveId.d(Base64.decode((String)string2.substring("DriveId:".length()), (int)10));
    }

    final byte[] cs() {
        q q2 = new q();
        q2.versionCode = this.kZ;
        String string2 = this.od == null ? "" : this.od;
        q2.oH = string2;
        q2.oI = this.oe;
        q2.oJ = this.of;
        return ht.a(q2);
    }

    public int describeContents() {
        return 0;
    }

    public final String encodeToString() {
        if (this.og != null) return this.og;
        String string2 = Base64.encodeToString((byte[])this.cs(), (int)10);
        this.og = "DriveId:" + string2;
        return this.og;
    }

    public boolean equals(Object object) {
        if (!(object instanceof DriveId)) {
            return false;
        }
        object = (DriveId)object;
        return this.encodeToString().equals(((DriveId)object).encodeToString());
    }

    public String getResourceId() {
        return this.od;
    }

    public int hashCode() {
        return this.encodeToString().hashCode();
    }

    public String toString() {
        return this.encodeToString();
    }

    public void writeToParcel(Parcel parcel, int n2) {
        c.a(this, parcel, n2);
    }
}

