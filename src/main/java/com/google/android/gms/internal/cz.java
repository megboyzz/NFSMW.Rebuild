/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.webkit.WebChromeClient$CustomViewCallback
 */
package com.google.android.gms.internal;

import android.view.View;
import android.webkit.WebChromeClient;
import com.google.android.gms.internal.cv;
import com.google.android.gms.internal.cx;

public final class cz
extends cx {
    public cz(cv cv2) {
        super(cv2);
    }

    public void onShowCustomView(View view, int n2, WebChromeClient.CustomViewCallback customViewCallback) {
        this.a(view, n2, customViewCallback);
    }
}

