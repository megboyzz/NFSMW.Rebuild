/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal;

import com.google.android.gms.internal.al;
import com.google.android.gms.internal.an;
import com.google.android.gms.internal.cs;
import com.google.android.gms.internal.cv;
import java.util.Map;

public final class ak
implements an {
    private final al fm;

    public ak(al al2) {
        this.fm = al2;
    }

    @Override
    public void a(cv object, Map<String, String> map) {
        object = map.get("name");
        if (object == null) {
            cs.v("App event with no name parameter.");
            return;
        }
        this.fm.onAppEvent((String)object, map.get("info"));
    }
}

