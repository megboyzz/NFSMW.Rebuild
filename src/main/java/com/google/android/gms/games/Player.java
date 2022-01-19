/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.CharArrayBuffer
 *  android.net.Uri
 *  android.os.Parcelable
 */
package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

public interface Player
extends Parcelable,
Freezable<Player> {
    public String getDisplayName();

    public void getDisplayName(CharArrayBuffer var1);

    public Uri getHiResImageUri();

    public Uri getIconImageUri();

    public String getPlayerId();

    public long getRetrievedTimestamp();

    public boolean hasHiResImage();

    public boolean hasIconImage();
}

