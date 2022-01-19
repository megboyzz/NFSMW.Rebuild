/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.ParcelFileDescriptor
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.a;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Contents
implements SafeParcelable {
    public static final Parcelable.Creator<Contents> CREATOR = new a();
    final int kZ;
    final ParcelFileDescriptor lJ;
    private boolean mClosed = false;
    final int nT;
    final int nU;
    final DriveId nV;
    private boolean nW = false;
    private boolean nX = false;

    Contents(int n2, ParcelFileDescriptor parcelFileDescriptor, int n3, int n4, DriveId driveId) {
        this.kZ = n2;
        this.lJ = parcelFileDescriptor;
        this.nT = n3;
        this.nU = n4;
        this.nV = driveId;
    }

    public void close() {
        this.mClosed = true;
    }

    public int cq() {
        return this.nT;
    }

    public int describeContents() {
        return 0;
    }

    public DriveId getDriveId() {
        return this.nV;
    }

    public InputStream getInputStream() {
        if (this.mClosed) {
            throw new IllegalStateException("Contents have been closed, cannot access the input stream.");
        }
        if (this.nU != 0x10000000) {
            throw new IllegalStateException("getInputStream() can only be used with contents opened with MODE_READ_ONLY.");
        }
        if (this.nW) {
            throw new IllegalStateException("getInputStream() can only be called once per Contents instance.");
        }
        this.nW = true;
        return new FileInputStream(this.lJ.getFileDescriptor());
    }

    public int getMode() {
        return this.nU;
    }

    public OutputStream getOutputStream() {
        if (this.mClosed) {
            throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
        }
        if (this.nU != 0x20000000) {
            throw new IllegalStateException("getOutputStream() can only be used with contents opened with MODE_WRITE_ONLY.");
        }
        if (this.nX) {
            throw new IllegalStateException("getOutputStream() can only be called once per Contents instance.");
        }
        this.nX = true;
        return new FileOutputStream(this.lJ.getFileDescriptor());
    }

    public ParcelFileDescriptor getParcelFileDescriptor() {
        if (!this.mClosed) return this.lJ;
        throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
    }

    public void writeToParcel(Parcel parcel, int n2) {
        a.a(this, parcel, n2);
    }
}

