/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.CharArrayBuffer
 *  android.net.Uri
 */
package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.ds;
import com.google.android.gms.internal.du;

public abstract class b {
    protected final DataHolder lb;
    protected final int ld;
    private final int le;

    public b(DataHolder dataHolder, int n2) {
        this.lb = du.f(dataHolder);
        boolean bl2 = n2 >= 0 && n2 < dataHolder.getCount();
        du.n(bl2);
        this.ld = n2;
        this.le = dataHolder.t(this.ld);
    }

    protected boolean A(String string) {
        return this.lb.hasNull(string, this.ld, this.le);
    }

    protected void a(String string, CharArrayBuffer charArrayBuffer) {
        this.lb.copyToBuffer(string, this.ld, this.le, charArrayBuffer);
    }

    public boolean equals(Object object) {
        boolean bl2;
        boolean bl3 = bl2 = false;
        if (!(object instanceof b)) return bl3;
        object = (b)object;
        bl3 = bl2;
        if (!ds.equal(((b)object).ld, this.ld)) return bl3;
        bl3 = bl2;
        if (!ds.equal(((b)object).le, this.le)) return bl3;
        bl3 = bl2;
        if (((b)object).lb != this.lb) return bl3;
        return true;
    }

    protected boolean getBoolean(String string) {
        return this.lb.getBoolean(string, this.ld, this.le);
    }

    protected byte[] getByteArray(String string) {
        return this.lb.getByteArray(string, this.ld, this.le);
    }

    protected int getInteger(String string) {
        return this.lb.getInteger(string, this.ld, this.le);
    }

    protected long getLong(String string) {
        return this.lb.getLong(string, this.ld, this.le);
    }

    protected String getString(String string) {
        return this.lb.getString(string, this.ld, this.le);
    }

    public int hashCode() {
        return ds.hashCode(this.ld, this.le, this.lb);
    }

    public boolean isDataValid() {
        if (this.lb.isClosed()) return false;
        return true;
    }

    protected Uri z(String string) {
        return this.lb.parseUri(string, this.ld, this.le);
    }
}

