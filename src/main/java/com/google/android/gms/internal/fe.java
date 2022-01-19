/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.LocalSocket
 *  android.os.Parcel
 *  android.os.ParcelFileDescriptor
 */
package com.google.android.gms.internal;

import android.net.LocalSocket;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

final class fe
implements RealTimeSocket {
    private ParcelFileDescriptor lJ;
    private final LocalSocket rK;
    private final String rm;

    fe(LocalSocket localSocket, String string2) {
        this.rK = localSocket;
        this.rm = string2;
    }

    @Override
    public void close() throws IOException {
        this.rK.close();
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return this.rK.getInputStream();
    }

    @Override
    public OutputStream getOutputStream() throws IOException {
        return this.rK.getOutputStream();
    }

    @Override
    public ParcelFileDescriptor getParcelFileDescriptor() throws IOException {
        if (this.lJ != null) return this.lJ;
        if (this.isClosed()) return this.lJ;
        Parcel parcel = Parcel.obtain();
        parcel.writeFileDescriptor(this.rK.getFileDescriptor());
        parcel.setDataPosition(0);
        this.lJ = parcel.readFileDescriptor();
        return this.lJ;
    }

    @Override
    public boolean isClosed() {
        if (this.rK.isConnected()) return false;
        if (this.rK.isBound()) return false;
        return true;
    }
}

