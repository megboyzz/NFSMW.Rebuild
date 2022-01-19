/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal;

import java.util.LinkedHashMap;
import java.util.Map;

public class dy<K, V> {
    private final LinkedHashMap<K, V> nk;
    private int nl;
    private int nm;
    private int nn;
    private int no;
    private int np;
    private int nq;
    private int size;

    public dy(int n2) {
        if (n2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.nl = n2;
        this.nk = new LinkedHashMap(0, 0.75f, true);
    }

    private int d(K k2, V v2) {
        int n2 = this.sizeOf(k2, v2);
        if (n2 >= 0) return n2;
        throw new IllegalStateException("Negative size: " + k2 + "=" + v2);
    }

    protected V create(K k2) {
        return null;
    }

    protected void entryRemoved(boolean bl2, K k2, V v2, V v3) {
    }

    public final void evictAll() {
        this.trimToSize(-1);
    }

    /*
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    public final V get(K k2) {
        if (k2 == null) {
            throw new NullPointerException("key == null");
        }
        // MONITORENTER : this
        V v2 = this.nk.get(k2);
        if (v2 != null) {
            ++this.np;
            // MONITOREXIT : this
            return v2;
        }
        ++this.nq;
        // MONITOREXIT : this
        v2 = this.create(k2);
        if (v2 == null) {
            return null;
        }
        // MONITORENTER : this
        ++this.nn;
        V v3 = this.nk.put(k2, v2);
        if (v3 != null) {
            this.nk.put(k2, v3);
        } else {
            this.size += this.d(k2, v2);
        }
        // MONITOREXIT : this
        if (v3 != null) {
            this.entryRemoved(false, k2, v2, v3);
            return v3;
        }
        this.trimToSize(this.nl);
        return v2;
    }

    /*
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    public final V put(K k2, V v2) {
        if (k2 == null) throw new NullPointerException("key == null || value == null");
        if (v2 == null) {
            throw new NullPointerException("key == null || value == null");
        }
        // MONITORENTER : this
        ++this.nm;
        this.size += this.d(k2, v2);
        V v3 = this.nk.put(k2, v2);
        if (v3 != null) {
            this.size -= this.d(k2, v3);
        }
        // MONITOREXIT : this
        if (v3 != null) {
            this.entryRemoved(false, k2, v3, v2);
        }
        this.trimToSize(this.nl);
        return v3;
    }

    public final int size() {
        synchronized (this) {
            return this.size;
        }
    }

    protected int sizeOf(K k2, V v2) {
        return 1;
    }

    public final String toString() {
        int n2 = 0;
        synchronized (this) {
            int n3 = this.np + this.nq;
            if (n3 == 0) return String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", this.nl, this.np, this.nq, n2);
            n2 = this.np * 100 / n3;
            return String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", this.nl, this.np, this.nq, n2);
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void trimToSize(int n2) {
        while (true) {
            K k2;
            Map.Entry<K, V> entry;
            synchronized (this) {
                if (this.size < 0) throw new IllegalStateException(this.getClass().getName() + ".sizeOf() is reporting inconsistent results!");
                if (this.nk.isEmpty() && this.size != 0) {
                    throw new IllegalStateException(this.getClass().getName() + ".sizeOf() is reporting inconsistent results!");
                }
                if (this.size <= n2) return;
                if (this.nk.isEmpty()) {
                    return;
                }
                entry = this.nk.entrySet().iterator().next();
                k2 = entry.getKey();
                entry = entry.getValue();
                this.nk.remove(k2);
                this.size -= this.d(k2, entry);
                ++this.no;
            }
            this.entryRemoved(true, k2, entry, null);
        }
    }
}

