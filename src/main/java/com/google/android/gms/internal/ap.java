/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 *  android.util.DisplayMetrics
 *  android.view.MotionEvent
 */
package com.google.android.gms.internal;

import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.google.android.gms.internal.an;
import com.google.android.gms.internal.bk;
import com.google.android.gms.internal.bo;
import com.google.android.gms.internal.cr;
import com.google.android.gms.internal.cs;
import com.google.android.gms.internal.cv;
import java.util.Map;

public final class ap
implements an {
    private static int a(DisplayMetrics displayMetrics, Map<String, String> object, String string2, int n2) {
        object = object.get(string2);
        int n3 = n2;
        if (object == null) return n3;
        try {
            return cr.a(displayMetrics, Integer.parseInt((String)object));
        }
        catch (NumberFormatException numberFormatException) {
            cs.v("Could not parse " + string2 + " in a video GMSG: " + (String)object);
            return n2;
        }
    }

    @Override
    public void a(cv object, Map<String, String> map) {
        String string2 = map.get("action");
        if (string2 == null) {
            cs.v("Action missing from video GMSG.");
            return;
        }
        Object object2 = object.aA();
        if (object2 == null) {
            cs.v("Could not get ad overlay for a video GMSG.");
            return;
        }
        boolean bl2 = "new".equalsIgnoreCase(string2);
        boolean bl3 = "position".equalsIgnoreCase(string2);
        if (bl2 || bl3) {
            object = object.getContext().getResources().getDisplayMetrics();
            int n2 = ap.a((DisplayMetrics)object, map, "x", 0);
            int n3 = ap.a((DisplayMetrics)object, map, "y", 0);
            int n4 = ap.a((DisplayMetrics)object, map, "w", -1);
            int n5 = ap.a((DisplayMetrics)object, map, "h", -1);
            if (bl2 && ((bk)object2).W() == null) {
                ((bk)object2).c(n2, n3, n4, n5);
                return;
            }
            ((bk)object2).b(n2, n3, n4, n5);
            return;
        }
        if ((object2 = ((bk)object2).W()) == null) {
            bo.a(object, "no_video_view", null);
            return;
        }
        if ("click".equalsIgnoreCase(string2)) {
            object = object.getContext().getResources().getDisplayMetrics();
            int n6 = ap.a((DisplayMetrics)object, map, "x", 0);
            int n7 = ap.a((DisplayMetrics)object, map, "y", 0);
            long l2 = SystemClock.uptimeMillis();
            object = MotionEvent.obtain((long)l2, (long)l2, (int)0, (float)n6, (float)n7, (int)0);
            ((bo)((Object)object2)).b((MotionEvent)object);
            object.recycle();
            return;
        }
        if ("controls".equalsIgnoreCase(string2)) {
            object = map.get("enabled");
            if (object == null) {
                cs.v("Enabled parameter missing from controls video GMSG.");
                return;
            }
            ((bo)((Object)object2)).i(Boolean.parseBoolean((String)object));
            return;
        }
        if ("currentTime".equalsIgnoreCase(string2)) {
            object = map.get("time");
            if (object == null) {
                cs.v("Time parameter missing from currentTime video GMSG.");
                return;
            }
            try {
                ((bo)((Object)object2)).seekTo((int)(Float.parseFloat((String)object) * 1000.0f));
                return;
            }
            catch (NumberFormatException numberFormatException) {
                cs.v("Could not parse time parameter from currentTime video GMSG: " + (String)object);
                return;
            }
        }
        if ("hide".equalsIgnoreCase(string2)) {
            object2.setVisibility(4);
            return;
        }
        if ("load".equalsIgnoreCase(string2)) {
            ((bo)((Object)object2)).af();
            return;
        }
        if ("pause".equalsIgnoreCase(string2)) {
            ((bo)((Object)object2)).pause();
            return;
        }
        if ("play".equalsIgnoreCase(string2)) {
            ((bo)((Object)object2)).play();
            return;
        }
        if ("show".equalsIgnoreCase(string2)) {
            object2.setVisibility(0);
            return;
        }
        if ("src".equalsIgnoreCase(string2)) {
            ((bo)((Object)object2)).n(map.get("src"));
            return;
        }
        cs.v("Unknown video action: " + string2);
    }
}

