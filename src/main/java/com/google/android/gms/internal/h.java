/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.view.MotionEvent
 */
package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import com.google.android.gms.internal.c;
import com.google.android.gms.internal.d;
import com.google.android.gms.internal.i;

public class h {
    private String dK = "googleads.g.doubleclick.net";
    private String dL = "/pagead/ads";
    private String[] dM = new String[]{".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
    private d dN;
    private final c dO = new c();

    public h(d d2) {
        this.dN = d2;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private Uri a(Uri uri, Context object, String string2, boolean bl2) throws i {
        try {
            if (uri.getQueryParameter("ms") != null) {
                throw new i("Query parameter already exists: ms");
            }
            if (bl2) {
                object = this.dN.a((Context)object, string2);
                return this.a(uri, "ms", (String)object);
            }
            object = this.dN.a((Context)object);
            return this.a(uri, "ms", (String)object);
        }
        catch (UnsupportedOperationException unsupportedOperationException) {
            throw new i("Provided Uri is not in a valid state");
        }
    }

    private Uri a(Uri uri, String string2, String string3) throws UnsupportedOperationException {
        int n2;
        String string4 = uri.toString();
        int n3 = n2 = string4.indexOf("&adurl");
        if (n2 == -1) {
            n3 = string4.indexOf("?adurl");
        }
        if (n3 == -1) return uri.buildUpon().appendQueryParameter(string2, string3).build();
        return Uri.parse((String)(string4.substring(0, n3 + 1) + string2 + "=" + string3 + "&" + string4.substring(n3 + 1)));
    }

    public Uri a(Uri uri, Context context) throws i {
        try {
            return this.a(uri, context, uri.getQueryParameter("ai"), true);
        }
        catch (UnsupportedOperationException unsupportedOperationException) {
            throw new i("Provided Uri is not in a valid state");
        }
    }

    public void a(MotionEvent motionEvent) {
        this.dN.a(motionEvent);
    }

    public boolean a(Uri object) {
        boolean bl2 = false;
        if (object == null) {
            throw new NullPointerException();
        }
        try {
            object = object.getHost();
            String[] stringArray = this.dM;
            int n2 = stringArray.length;
            int n3 = 0;
            while (true) {
                boolean bl3 = bl2;
                if (n3 >= n2) return bl3;
                bl3 = ((String)object).endsWith(stringArray[n3]);
                if (bl3) {
                    return true;
                }
                ++n3;
            }
        }
        catch (NullPointerException nullPointerException) {
            return false;
        }
    }

    public d g() {
        return this.dN;
    }
}

