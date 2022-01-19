/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnCompletionListener
 *  android.media.MediaPlayer$OnErrorListener
 *  android.media.MediaPlayer$OnPreparedListener
 *  android.text.TextUtils
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.MediaController
 *  android.widget.VideoView
 */
package com.google.android.gms.internal;

import android.content.Context;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.VideoView;
import com.google.android.gms.internal.cr;
import com.google.android.gms.internal.cv;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class bo
extends FrameLayout
implements MediaPlayer.OnCompletionListener,
MediaPlayer.OnErrorListener,
MediaPlayer.OnPreparedListener {
    private final MediaController gP;
    private final a gQ;
    private final VideoView gR;
    private long gS;
    private String gT;
    private final cv gu;

    public bo(Context context, cv cv2) {
        super(context);
        this.gu = cv2;
        this.gR = new VideoView(context);
        cv2 = new FrameLayout.LayoutParams(-1, -1, 17);
        this.addView((View)this.gR, (ViewGroup.LayoutParams)cv2);
        this.gP = new MediaController(context);
        this.gQ = new a(this);
        this.gQ.ah();
        this.gR.setOnCompletionListener((MediaPlayer.OnCompletionListener)this);
        this.gR.setOnPreparedListener((MediaPlayer.OnPreparedListener)this);
        this.gR.setOnErrorListener((MediaPlayer.OnErrorListener)this);
    }

    private static void a(cv cv2, String string2) {
        bo.a(cv2, string2, new HashMap<String, String>(1));
    }

    public static void a(cv cv2, String string2, String string3) {
        boolean bl2 = string3 == null;
        int n2 = bl2 ? 2 : 3;
        HashMap<String, String> hashMap = new HashMap<String, String>(n2);
        hashMap.put("what", string2);
        if (!bl2) {
            hashMap.put("extra", string3);
        }
        bo.a(cv2, "error", hashMap);
    }

    private static void a(cv cv2, String string2, String string3, String string4) {
        HashMap<String, String> hashMap = new HashMap<String, String>(2);
        hashMap.put(string3, string4);
        bo.a(cv2, string2, hashMap);
    }

    private static void a(cv cv2, String string2, Map<String, String> map) {
        map.put("event", string2);
        cv2.a("onVideoEvent", map);
    }

    public void af() {
        if (!TextUtils.isEmpty((CharSequence)this.gT)) {
            this.gR.setVideoPath(this.gT);
            return;
        }
        bo.a(this.gu, "no_src", null);
    }

    public void ag() {
        long l2 = this.gR.getCurrentPosition();
        if (this.gS == l2) return;
        float f2 = (float)l2 / 1000.0f;
        bo.a(this.gu, "timeupdate", "time", String.valueOf(f2));
        this.gS = l2;
    }

    public void b(MotionEvent motionEvent) {
        this.gR.dispatchTouchEvent(motionEvent);
    }

    public void destroy() {
        this.gQ.cancel();
        this.gR.stopPlayback();
    }

    public void i(boolean bl2) {
        if (bl2) {
            this.gR.setMediaController(this.gP);
            return;
        }
        this.gP.hide();
        this.gR.setMediaController(null);
    }

    public void n(String string2) {
        this.gT = string2;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        bo.a(this.gu, "ended");
    }

    public boolean onError(MediaPlayer mediaPlayer, int n2, int n3) {
        bo.a(this.gu, String.valueOf(n2), String.valueOf(n3));
        return true;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        float f2 = (float)this.gR.getDuration() / 1000.0f;
        bo.a(this.gu, "canplaythrough", "duration", String.valueOf(f2));
    }

    public void pause() {
        this.gR.pause();
    }

    public void play() {
        this.gR.start();
    }

    public void seekTo(int n2) {
        this.gR.seekTo(n2);
    }

    private static final class a {
        private final Runnable ep;
        private volatile boolean gU = false;

        public a(final bo bo2) {
            this.ep = new Runnable(){
                private final WeakReference<bo> gV;
                {
                    this.gV = new WeakReference<bo>(bo2);
                }

                @Override
                public void run() {
                    bo bo22 = (bo)((Object)this.gV.get());
                    if (a.this.gU) return;
                    if (bo22 == null) return;
                    bo22.ag();
                    a.this.ah();
                }
            };
        }

        public void ah() {
            cr.iE.postDelayed(this.ep, 250L);
        }

        public void cancel() {
            this.gU = true;
            cr.iE.removeCallbacks(this.ep);
        }
    }
}

