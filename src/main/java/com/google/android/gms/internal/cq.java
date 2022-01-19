/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.cl;
import com.google.android.gms.internal.cn;
import com.google.android.gms.internal.cs;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public final class cq
extends cl {
    private final String iC;
    private final String iD;
    private final Context mContext;

    public cq(Context context, String string2, String string3) {
        this.mContext = context;
        this.iC = string2;
        this.iD = string3;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     */
    @Override
    public void ai() {
        HttpURLConnection httpURLConnection;
        try {
            cs.u("Pinging URL: " + this.iD);
            httpURLConnection = (HttpURLConnection)new URL(this.iD).openConnection();
        }
        catch (IOException iOException) {
            cs.v("Error while pinging URL: " + this.iD + ". " + iOException.getMessage());
            return;
        }
        try {
            cn.a(this.mContext, this.iC, true, httpURLConnection);
            int n2 = httpURLConnection.getResponseCode();
            if (n2 >= 200) {
                if (n2 < 300) return;
            }
            cs.v("Received non-success response code " + n2 + " from pinging URL: " + this.iD);
            return;
        }
        finally {
            httpURLConnection.disconnect();
        }
    }

    @Override
    public void onStop() {
    }
}

