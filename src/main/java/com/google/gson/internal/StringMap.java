/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal;

import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;

public final class StringMap<V>
extends AbstractMap<String, V> {
    private static final Map.Entry[] EMPTY_TABLE = new LinkedEntry[2];
    private static final int MAXIMUM_CAPACITY = 0x40000000;
    private static final int MINIMUM_CAPACITY = 4;
    private static final int seed = new Random().nextInt();
    private Set<Map.Entry<String, V>> entrySet;
    private LinkedEntry<V> header;
    private Set<String> keySet;
    private int size;
    private LinkedEntry<V>[] table = (LinkedEntry[])EMPTY_TABLE;
    private int threshold = -1;
    private Collection<V> values;

    public StringMap() {
        this.header = new LinkedEntry();
    }

    private void addNewEntry(String object, V object2, int n2, int n3) {
        LinkedEntry<V> linkedEntry = this.header;
        LinkedEntry linkedEntry2 = linkedEntry.prv;
        object = new LinkedEntry<V>((String)object, object2, n2, this.table[n3], linkedEntry, linkedEntry2);
        object2 = this.table;
        linkedEntry.prv = object;
        linkedEntry2.nxt = object;
        object2[n3] = object;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private LinkedEntry<V>[] doubleCapacity() {
        var10_1 = this.table;
        var5_2 = var10_1.length;
        if (var5_2 == 0x40000000) {
            return var10_1;
        }
        var11_4 = this.makeTable(var5_2 * 2);
        var6_3 /* !! */  = var11_4;
        if (this.size == 0) return var6_3 /* !! */ ;
        var1_5 = 0;
        block0: while (true) {
            var6_3 /* !! */  = var11_4;
            if (var1_5 >= var5_2) return var6_3 /* !! */ ;
            var7_9 /* !! */  = var10_1[var1_5];
            if (var7_9 /* !! */  != null) {
                var2_6 = var7_9 /* !! */ .hash & var5_2;
                var8_10 = null;
                var11_4[var1_5 | var2_6] = var7_9 /* !! */ ;
                var6_3 /* !! */  = var7_9 /* !! */ .next;
                break;
            }
lbl19:
            // 4 sources

            while (true) {
                ++var1_5;
                continue block0;
                break;
            }
            break;
        }
        while (var6_3 /* !! */  != null) {
            var4_8 = var6_3 /* !! */ .hash & var5_2;
            var9_11 /* !! */  = var8_10;
            var3_7 = var2_6;
            if (var4_8 != var2_6) {
                if (var8_10 == null) {
                    var11_4[var1_5 | var4_8] = var6_3 /* !! */ ;
                } else {
                    var8_10.next = var6_3 /* !! */ ;
                }
                var3_7 = var4_8;
                var9_11 /* !! */  = var7_9 /* !! */ ;
            }
            var7_9 /* !! */  = var6_3 /* !! */ ;
            var6_3 /* !! */  = var6_3 /* !! */ .next;
            var8_10 = var9_11 /* !! */ ;
            var2_6 = var3_7;
        }
        if (var8_10 == null) ** GOTO lbl19
        var8_10.next = null;
        ** while (true)
    }

    private LinkedEntry<V> getEntry(String string2) {
        if (string2 == null) {
            return null;
        }
        int n2 = StringMap.hash(string2);
        Object object = this.table;
        object = object[((LinkedEntry<V>[])object).length - 1 & n2];
        while (object != null) {
            String string3 = object.key;
            Object object2 = object;
            if (string3 == string2) return object2;
            if (object.hash == n2) {
                object2 = object;
                if (string2.equals(string3)) return object2;
            }
            object = object.next;
        }
        return null;
    }

    private static int hash(String string2) {
        int n2 = seed;
        int n3 = 0;
        while (true) {
            if (n3 >= string2.length()) {
                n3 = n2 ^ (n2 >>> 20 ^ n2 >>> 12);
                return n3 >>> 7 ^ n3 ^ n3 >>> 4;
            }
            n2 += string2.charAt(n3);
            n2 = n2 + n2 << 10;
            n2 ^= n2 >>> 6;
            ++n3;
        }
    }

    private LinkedEntry<V>[] makeTable(int n2) {
        LinkedEntry[] linkedEntryArray = new LinkedEntry[n2];
        this.table = linkedEntryArray;
        this.threshold = (n2 >> 1) + (n2 >> 2);
        return linkedEntryArray;
    }

    private boolean removeMapping(Object object, Object object2) {
        if (object == null) return false;
        if (!(object instanceof String)) {
            return false;
        }
        int n2 = StringMap.hash((String)object);
        LinkedEntry<V>[] linkedEntryArray = this.table;
        int n3 = n2 & linkedEntryArray.length - 1;
        LinkedEntry<V> linkedEntry = linkedEntryArray[n3];
        LinkedEntry<V> linkedEntry2 = null;
        while (linkedEntry != null) {
            if (linkedEntry.hash == n2 && object.equals(linkedEntry.key)) {
                if (object2 == null) {
                    if (linkedEntry.value != null) {
                        return false;
                    }
                } else if (!object2.equals(linkedEntry.value)) return false;
                if (linkedEntry2 == null) {
                    linkedEntryArray[n3] = linkedEntry.next;
                } else {
                    linkedEntry2.next = linkedEntry.next;
                }
                --this.size;
                this.unlink(linkedEntry);
                return true;
            }
            linkedEntry2 = linkedEntry;
            linkedEntry = linkedEntry.next;
        }
        return false;
    }

    private void unlink(LinkedEntry<V> linkedEntry) {
        linkedEntry.prv.nxt = linkedEntry.nxt;
        linkedEntry.nxt.prv = linkedEntry.prv;
        linkedEntry.prv = null;
        linkedEntry.nxt = null;
    }

    @Override
    public void clear() {
        if (this.size != 0) {
            Arrays.fill(this.table, null);
            this.size = 0;
        }
        LinkedEntry<V> linkedEntry = this.header;
        LinkedEntry linkedEntry2 = linkedEntry.nxt;
        while (true) {
            if (linkedEntry2 == linkedEntry) {
                linkedEntry.prv = linkedEntry;
                linkedEntry.nxt = linkedEntry;
                return;
            }
            LinkedEntry linkedEntry3 = linkedEntry2.nxt;
            linkedEntry2.prv = null;
            linkedEntry2.nxt = null;
            linkedEntry2 = linkedEntry3;
        }
    }

    @Override
    public boolean containsKey(Object object) {
        if (!(object instanceof String)) return false;
        if (this.getEntry((String)object) == null) return false;
        return true;
    }

    @Override
    public Set<Map.Entry<String, V>> entrySet() {
        EntrySet entrySet = this.entrySet;
        if (entrySet != null) {
            return entrySet;
        }
        this.entrySet = entrySet = new EntrySet();
        return entrySet;
    }

    @Override
    public V get(Object linkedEntry) {
        V v2;
        V v3 = v2 = null;
        if (!(linkedEntry instanceof String)) return v3;
        linkedEntry = this.getEntry((String)((Object)linkedEntry));
        v3 = v2;
        if (linkedEntry == null) return v3;
        v3 = linkedEntry.value;
        return v3;
    }

    @Override
    public Set<String> keySet() {
        KeySet keySet = this.keySet;
        if (keySet != null) {
            return keySet;
        }
        this.keySet = keySet = new KeySet();
        return keySet;
    }

    @Override
    public V put(String string2, V v2) {
        if (string2 == null) {
            throw new NullPointerException("key == null");
        }
        int n2 = StringMap.hash(string2);
        Object object = this.table;
        int n3 = n2 & ((LinkedEntry<V>[])object).length - 1;
        object = object[n3];
        while (object != null) {
            if (object.hash == n2 && string2.equals(object.key)) {
                string2 = object.value;
                object.value = v2;
                return (V)string2;
            }
            object = object.next;
        }
        int n4 = this.size;
        this.size = n4 + 1;
        if (n4 > this.threshold) {
            n3 = n2 & this.doubleCapacity().length - 1;
        }
        this.addNewEntry(string2, v2, n2, n3);
        return null;
    }

    @Override
    public V remove(Object object) {
        LinkedEntry<V> linkedEntry;
        block5: {
            if (object == null) return null;
            if (!(object instanceof String)) {
                return null;
            }
            int n2 = StringMap.hash((String)object);
            LinkedEntry<V>[] linkedEntryArray = this.table;
            int n3 = n2 & linkedEntryArray.length - 1;
            linkedEntry = linkedEntryArray[n3];
            LinkedEntry<V> linkedEntry2 = null;
            while (linkedEntry != null) {
                if (linkedEntry.hash == n2 && object.equals(linkedEntry.key)) {
                    if (linkedEntry2 == null) {
                        linkedEntryArray[n3] = linkedEntry.next;
                    } else {
                        linkedEntry2.next = linkedEntry.next;
                    }
                    break block5;
                }
                linkedEntry2 = linkedEntry;
                linkedEntry = linkedEntry.next;
            }
            return null;
        }
        --this.size;
        this.unlink(linkedEntry);
        return linkedEntry.value;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Collection<V> values() {
        Values values = this.values;
        if (values != null) {
            return values;
        }
        this.values = values = new Values();
        return values;
    }

    private final class EntrySet
    extends AbstractSet<Map.Entry<String, V>> {
        private EntrySet() {
        }

        @Override
        public void clear() {
            StringMap.this.clear();
        }

        @Override
        public boolean contains(Object object) {
            if (!(object instanceof Map.Entry)) {
                return false;
            }
            Object v2 = StringMap.this.get((object = (Map.Entry)object).getKey());
            if (v2 == null) return false;
            if (!v2.equals(object.getValue())) return false;
            return true;
        }

        @Override
        public Iterator<Map.Entry<String, V>> iterator() {
            return new LinkedHashIterator<Map.Entry<String, V>>(){

                @Override
                public final Map.Entry<String, V> next() {
                    return this.nextEntry();
                }
            };
        }

        @Override
        public boolean remove(Object object) {
            if (!(object instanceof Map.Entry)) {
                return false;
            }
            object = (Map.Entry)object;
            return StringMap.this.removeMapping(object.getKey(), object.getValue());
        }

        @Override
        public int size() {
            return StringMap.this.size;
        }
    }

    private final class KeySet
    extends AbstractSet<String> {
        private KeySet() {
        }

        @Override
        public void clear() {
            StringMap.this.clear();
        }

        @Override
        public boolean contains(Object object) {
            return StringMap.this.containsKey(object);
        }

        @Override
        public Iterator<String> iterator() {
            return new LinkedHashIterator<String>(){

                @Override
                public final String next() {
                    return this.nextEntry().key;
                }
            };
        }

        @Override
        public boolean remove(Object object) {
            int n2 = StringMap.this.size;
            StringMap.this.remove(object);
            if (StringMap.this.size == n2) return false;
            return true;
        }

        @Override
        public int size() {
            return StringMap.this.size;
        }
    }

    static class LinkedEntry<V>
    implements Map.Entry<String, V> {
        final int hash;
        final String key;
        LinkedEntry<V> next;
        LinkedEntry<V> nxt;
        LinkedEntry<V> prv;
        V value;

        LinkedEntry() {
            this(null, null, 0, null, null, null);
            this.prv = this;
            this.nxt = this;
        }

        LinkedEntry(String string2, V v2, int n2, LinkedEntry<V> linkedEntry, LinkedEntry<V> linkedEntry2, LinkedEntry<V> linkedEntry3) {
            this.key = string2;
            this.value = v2;
            this.hash = n2;
            this.next = linkedEntry;
            this.nxt = linkedEntry2;
            this.prv = linkedEntry3;
        }

        @Override
        public final boolean equals(Object object) {
            if (!(object instanceof Map.Entry)) {
                return false;
            }
            object = (Map.Entry)object;
            Object v2 = object.getValue();
            if (!this.key.equals(object.getKey())) return false;
            if (this.value == null) {
                if (v2 != null) return false;
                return true;
            }
            if (!this.value.equals(v2)) return false;
            return true;
        }

        @Override
        public final String getKey() {
            return this.key;
        }

        @Override
        public final V getValue() {
            return this.value;
        }

        @Override
        public final int hashCode() {
            int n2 = 0;
            int n3 = this.key == null ? 0 : this.key.hashCode();
            if (this.value == null) {
                return n3 ^ n2;
            }
            n2 = this.value.hashCode();
            return n3 ^ n2;
        }

        @Override
        public final V setValue(V v2) {
            V v3 = this.value;
            this.value = v2;
            return v3;
        }

        public final String toString() {
            return this.key + "=" + this.value;
        }
    }

    private abstract class LinkedHashIterator<T>
    implements Iterator<T> {
        LinkedEntry<V> lastReturned;
        LinkedEntry<V> next;

        private LinkedHashIterator() {
            this.next = ((StringMap)StringMap.this).header.nxt;
            this.lastReturned = null;
        }

        @Override
        public final boolean hasNext() {
            if (this.next == StringMap.this.header) return false;
            return true;
        }

        final LinkedEntry<V> nextEntry() {
            LinkedEntry linkedEntry = this.next;
            if (linkedEntry == StringMap.this.header) {
                throw new NoSuchElementException();
            }
            this.next = linkedEntry.nxt;
            this.lastReturned = linkedEntry;
            return linkedEntry;
        }

        @Override
        public final void remove() {
            if (this.lastReturned == null) {
                throw new IllegalStateException();
            }
            StringMap.this.remove(this.lastReturned.key);
            this.lastReturned = null;
        }
    }

    private final class Values
    extends AbstractCollection<V> {
        private Values() {
        }

        @Override
        public void clear() {
            StringMap.this.clear();
        }

        @Override
        public boolean contains(Object object) {
            return StringMap.this.containsValue(object);
        }

        @Override
        public Iterator<V> iterator() {
            return new LinkedHashIterator<V>(){

                @Override
                public final V next() {
                    return this.nextEntry().value;
                }
            };
        }

        @Override
        public int size() {
            return StringMap.this.size;
        }
    }
}

