/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.common.data;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;

public abstract class d<T>
extends DataBuffer<T> {
    private boolean lw = false;
    private ArrayList<Integer> lx;

    protected d(DataHolder dataHolder) {
        super(dataHolder);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private void bl() {
        synchronized (this) {
            if (this.lw) return;
            int n2 = this.lb.getCount();
            this.lx = new ArrayList();
            if (n2 > 0) {
                this.lx.add(0);
                String string2 = this.getPrimaryDataMarkerColumn();
                int n3 = this.lb.t(0);
                String string3 = this.lb.getString(string2, 0, n3);
                for (n3 = 1; n3 < n2; ++n3) {
                    int n4 = this.lb.t(n3);
                    String string4 = this.lb.getString(string2, n3, n4);
                    if (string4.equals(string3)) continue;
                    this.lx.add(n3);
                    string3 = string4;
                }
            }
            this.lw = true;
            return;
        }
    }

    private int v(int n2) {
        if (n2 < 0) return 0;
        if (n2 == this.lx.size()) {
            return 0;
        }
        if (n2 != this.lx.size() - 1) return this.lx.get(n2 + 1) - this.lx.get(n2);
        return this.lb.getCount() - this.lx.get(n2);
    }

    protected abstract T a(int var1, int var2);

    @Override
    public final T get(int n2) {
        this.bl();
        return this.a(this.u(n2), this.v(n2));
    }

    @Override
    public int getCount() {
        this.bl();
        return this.lx.size();
    }

    protected abstract String getPrimaryDataMarkerColumn();

    int u(int n2) {
        if (n2 < 0) throw new IllegalArgumentException("Position " + n2 + " is out of bounds for this buffer");
        if (n2 < this.lx.size()) return this.lx.get(n2);
        throw new IllegalArgumentException("Position " + n2 + " is out of bounds for this buffer");
    }
}

