/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.games.multiplayer.realtime;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.du;

public final class RealTimeMessage
implements Parcelable {
    public static final Parcelable.Creator<RealTimeMessage> CREATOR = new Parcelable.Creator<RealTimeMessage>(){

        public RealTimeMessage Y(Parcel parcel) {
            return new RealTimeMessage(parcel);
        }

        public RealTimeMessage[] ay(int n2) {
            return new RealTimeMessage[n2];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return this.Y(parcel);
        }

        public /* synthetic */ Object[] newArray(int n2) {
            return this.ay(n2);
        }
    };
    public static final int RELIABLE = 1;
    public static final int UNRELIABLE = 0;
    private final String sH;
    private final byte[] sI;
    private final int sJ;

    private RealTimeMessage(Parcel parcel) {
        this(parcel.readString(), parcel.createByteArray(), parcel.readInt());
    }

    public RealTimeMessage(String string2, byte[] byArray, int n2) {
        this.sH = du.f(string2);
        this.sI = (byte[])du.f(byArray).clone();
        this.sJ = n2;
    }

    public int describeContents() {
        return 0;
    }

    public byte[] getMessageData() {
        return this.sI;
    }

    public String getSenderParticipantId() {
        return this.sH;
    }

    public boolean isReliable() {
        if (this.sJ != 1) return false;
        return true;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeString(this.sH);
        parcel.writeByteArray(this.sI);
        parcel.writeInt(this.sJ);
    }
}

