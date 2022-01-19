/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.maps.model;

import com.google.android.gms.maps.model.Tile;
import com.google.android.gms.maps.model.TileProvider;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public abstract class UrlTileProvider
implements TileProvider {
    private final int v;
    private final int w;

    public UrlTileProvider(int n2, int n3) {
        this.w = n2;
        this.v = n3;
    }

    private static long a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] byArray = new byte[4096];
        long l2 = 0L;
        int n2;
        while ((n2 = inputStream.read(byArray)) != -1) {
            outputStream.write(byArray, 0, n2);
            l2 += (long)n2;
        }
        return l2;
    }

    private static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        UrlTileProvider.a(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    @Override
    public final Tile getTile(int n2, int n3, int n4) {
        URL uRL = this.getTileUrl(n2, n3, n4);
        if (uRL == null) {
            return NO_TILE;
        }
        try {
            return new Tile(this.w, this.v, UrlTileProvider.a(uRL.openStream()));
        }
        catch (IOException iOException) {
            return null;
        }
    }

    public abstract URL getTileUrl(int var1, int var2, int var3);
}

