/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal;

import java.util.concurrent.BlockingQueue;

public class gf {
    private static int xe = 10000;
    private static int xf = 1000;
    private final BlockingQueue<a> xg;

    public void b(String string2, String string3, String string4) {
        this.xg.offer(new a(string2, string3, string4));
    }

    private class a {
        public final String mTag;
        public final String xh;

        public a(String string2, String string3, String string4) {
            this.xh = string2;
            this.mTag = string3 + "." + string4;
        }
    }
}

