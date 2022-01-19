/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.database.AbstractWindowedCursor
 *  android.database.CharArrayBuffer
 *  android.database.CursorIndexOutOfBoundsException
 *  android.database.CursorWindow
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.util.Log
 */
package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.database.AbstractWindowedCursor;
import android.database.CharArrayBuffer;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.data.DataHolderCreator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.dg;
import com.google.android.gms.internal.ds;
import com.google.android.gms.internal.du;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public final class DataHolder
implements SafeParcelable {
    public static final DataHolderCreator CREATOR = new DataHolderCreator();
    private static final Builder lp = new Builder(new String[0], null){

        @Override
        public Builder withRow(ContentValues contentValues) {
            throw new UnsupportedOperationException("Cannot add data to empty builder");
        }

        @Override
        public Builder withRow(HashMap<String, Object> hashMap) {
            throw new UnsupportedOperationException("Cannot add data to empty builder");
        }
    };
    private final int kZ;
    private final int ka;
    private final String[] lh;
    Bundle li;
    private final CursorWindow[] lj;
    private final Bundle lk;
    int[] ll;
    int lm;
    private Object ln;
    private boolean lo = true;
    boolean mClosed = false;

    DataHolder(int n2, String[] stringArray, CursorWindow[] cursorWindowArray, int n3, Bundle bundle) {
        this.kZ = n2;
        this.lh = stringArray;
        this.lj = cursorWindowArray;
        this.ka = n3;
        this.lk = bundle;
    }

    public DataHolder(AbstractWindowedCursor abstractWindowedCursor, int n2, Bundle bundle) {
        this(abstractWindowedCursor.getColumnNames(), DataHolder.a(abstractWindowedCursor), n2, bundle);
    }

    private DataHolder(Builder builder, int n2, Bundle bundle) {
        this(builder.lh, DataHolder.a(builder), n2, bundle);
    }

    public DataHolder(String[] stringArray, CursorWindow[] cursorWindowArray, int n2, Bundle bundle) {
        this.kZ = 1;
        this.lh = du.f(stringArray);
        this.lj = du.f(cursorWindowArray);
        this.ka = n2;
        this.lk = bundle;
        this.validateContents();
    }

    private void a(String string2, int n2) {
        if (this.li == null) throw new IllegalArgumentException("No such column: " + string2);
        if (!this.li.containsKey(string2)) {
            throw new IllegalArgumentException("No such column: " + string2);
        }
        if (this.isClosed()) {
            throw new IllegalArgumentException("Buffer is closed.");
        }
        if (n2 < 0) throw new CursorIndexOutOfBoundsException(n2, this.lm);
        if (n2 < this.lm) return;
        throw new CursorIndexOutOfBoundsException(n2, this.lm);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private static CursorWindow[] a(AbstractWindowedCursor abstractWindowedCursor) {
        ArrayList<CursorWindow> arrayList = new ArrayList<CursorWindow>();
        try {
            int n2;
            int n3 = abstractWindowedCursor.getCount();
            CursorWindow cursorWindow = abstractWindowedCursor.getWindow();
            if (cursorWindow != null && cursorWindow.getStartPosition() == 0) {
                cursorWindow.acquireReference();
                abstractWindowedCursor.setWindow(null);
                arrayList.add(cursorWindow);
                n2 = cursorWindow.getNumRows();
            } else {
                n2 = 0;
            }
            while (n2 < n3) {
                if (!abstractWindowedCursor.moveToPosition(n2)) return arrayList.toArray(new CursorWindow[arrayList.size()]);
                cursorWindow = abstractWindowedCursor.getWindow();
                if (cursorWindow != null) {
                    cursorWindow.acquireReference();
                    abstractWindowedCursor.setWindow(null);
                } else {
                    cursorWindow = new CursorWindow(false);
                    abstractWindowedCursor.fillWindow(n2, cursorWindow);
                }
                if ((n2 = cursorWindow.getNumRows()) == 0) return arrayList.toArray(new CursorWindow[arrayList.size()]);
                arrayList.add(cursorWindow);
                n2 = cursorWindow.getStartPosition();
                int n4 = cursorWindow.getNumRows();
                n2 = n4 + n2;
            }
            return arrayList.toArray(new CursorWindow[arrayList.size()]);
        }
        finally {
            abstractWindowedCursor.close();
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    private static CursorWindow[] a(Builder var0) {
        block19: {
            block17: {
                block20: {
                    var4_2 = 0;
                    if (Builder.b(var0).length == 0) {
                        return new CursorWindow[0];
                    }
                    var11_3 = Builder.c(var0);
                    var5_4 = var11_3.size();
                    var9_5 = new CursorWindow(false);
                    var10_6 = new ArrayList<CursorWindow>();
                    var10_6.add(var9_5);
                    var9_5.setNumColumns(Builder.b(var0).length);
                    var1_7 = 0;
                    var2_8 = 0;
                    block3: while (var1_7 < var5_4) {
                        block18: {
                            try {
                                if (!var9_5.allocRow()) {
                                    Log.d((String)"DataHolder", (String)("Allocating additional cursor window for large data set (row " + var1_7 + ")"));
                                    var9_5 = new CursorWindow(false);
                                    var9_5.setNumColumns(Builder.b(var0).length);
                                    var10_6.add(var9_5);
                                    if (!var9_5.allocRow()) {
                                        Log.e((String)"DataHolder", (String)"Unable to allocate row to hold data.");
                                        var10_6.remove(var9_5);
                                        return var10_6.toArray(new CursorWindow[var10_6.size()]);
                                    }
                                    break block17;
                                }
lbl31:
                                // 3 sources

                                while (true) {
                                    var12_12 = (Map)var11_3.get(var1_7);
                                    var6_10 = true;
                                    var3_9 = 0;
lbl35:
                                    // 2 sources

                                    while (true) {
                                        if (var3_9 >= Builder.b(var0).length || !var6_10) break block18;
                                        var13_13 = Builder.b(var0)[var3_9];
                                        var14_14 = var12_12.get(var13_13);
                                        if (var14_14 == null) {
                                            var6_10 = var9_5.putNull(var2_8, var3_9);
                                            break block19;
                                        }
                                        if (var14_14 instanceof String) {
                                            var6_10 = var9_5.putString((String)var14_14, var2_8, var3_9);
                                            break block19;
                                        }
                                        if (var14_14 instanceof Long) {
                                            var6_10 = var9_5.putLong(((Long)var14_14).longValue(), var2_8, var3_9);
                                            break block19;
                                        }
                                        if (var14_14 instanceof Integer) {
                                            var6_10 = var9_5.putLong((long)((Integer)var14_14).intValue(), var2_8, var3_9);
                                            break block19;
                                        }
                                        if (var14_14 instanceof Boolean) {
                                            var7_11 = (Boolean)var14_14 != false ? 1L : 0L;
                                            var6_10 = var9_5.putLong(var7_11, var2_8, var3_9);
                                            break block19;
                                        } else {
                                            if (var14_14 instanceof byte[] == false) throw new IllegalArgumentException("Unsupported object for column " + var13_13 + ": " + var14_14);
                                            var6_10 = var9_5.putBlob((byte[])var14_14, var2_8, var3_9);
                                        }
                                        break block19;
                                        break;
                                    }
                                    break;
                                }
                            }
                            catch (RuntimeException var0_1) {
                                var2_8 = var10_6.size();
                                var1_7 = var4_2;
                                while (var1_7 < var2_8) {
                                    ((CursorWindow)var10_6.get(var1_7)).close();
                                    ++var1_7;
                                }
                                throw var0_1;
                            }
                        }
                        if (var6_10) break block20;
                        {
                            Log.d((String)"DataHolder", (String)("Couldn't populate window data for row " + var1_7 + " - allocating new window."));
                            var9_5.freeLastRow();
                            var9_5 = new CursorWindow(false);
                            var9_5.setNumColumns(Builder.b(var0).length);
                            var10_6.add(var9_5);
                            var2_8 = var1_7 - 1;
                            var1_7 = 0;
                        }
lbl78:
                        // 2 sources

                        while (true) {
                            var3_9 = var2_8 + 1;
                            var2_8 = var1_7;
                            var1_7 = var3_9;
                            continue block3;
                            break;
                        }
                    }
                    return var10_6.toArray(new CursorWindow[var10_6.size()]);
                }
                var3_9 = var2_8 + 1;
                var2_8 = var1_7;
                var1_7 = var3_9;
                ** while (true)
            }
            var2_8 = 0;
            ** while (true)
        }
        ++var3_9;
        ** while (true)
    }

    public static Builder builder(String[] stringArray) {
        return new Builder(stringArray, null);
    }

    public static Builder builder(String[] stringArray, String string2) {
        du.f(string2);
        return new Builder(stringArray, string2);
    }

    public static DataHolder empty(int n2) {
        return DataHolder.empty(n2, null);
    }

    public static DataHolder empty(int n2, Bundle bundle) {
        return new DataHolder(lp, n2, bundle);
    }

    String[] bi() {
        return this.lh;
    }

    CursorWindow[] bj() {
        return this.lj;
    }

    public void c(Object object) {
        this.ln = object;
    }

    public void close() {
        synchronized (this) {
            if (this.mClosed) return;
            this.mClosed = true;
            int n2 = 0;
            while (n2 < this.lj.length) {
                this.lj[n2].close();
                ++n2;
            }
            return;
        }
    }

    public void copyToBuffer(String string2, int n2, int n3, CharArrayBuffer charArrayBuffer) {
        this.a(string2, n2);
        this.lj[n3].copyStringToBuffer(n2 - this.ll[n3], this.li.getInt(string2), charArrayBuffer);
    }

    public int describeContents() {
        return 0;
    }

    protected void finalize() throws Throwable {
        try {
            if (!this.lo) return;
            if (this.lj.length <= 0) return;
            if (this.isClosed()) return;
            String string2 = this.ln == null ? "internal object: " + this.toString() : this.ln.toString();
            Log.e((String)"DataBuffer", (String)("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call close() on all DataBuffer extending objects when you are done with them. (" + string2 + ")"));
            this.close();
            return;
        }
        finally {
            super.finalize();
        }
    }

    public boolean getBoolean(String string2, int n2, int n3) {
        this.a(string2, n2);
        if (Long.valueOf(this.lj[n3].getLong(n2 - this.ll[n3], this.li.getInt(string2))) != 1L) return false;
        return true;
    }

    public byte[] getByteArray(String string2, int n2, int n3) {
        this.a(string2, n2);
        return this.lj[n3].getBlob(n2 - this.ll[n3], this.li.getInt(string2));
    }

    public int getCount() {
        return this.lm;
    }

    public int getInteger(String string2, int n2, int n3) {
        this.a(string2, n2);
        return this.lj[n3].getInt(n2 - this.ll[n3], this.li.getInt(string2));
    }

    public long getLong(String string2, int n2, int n3) {
        this.a(string2, n2);
        return this.lj[n3].getLong(n2 - this.ll[n3], this.li.getInt(string2));
    }

    public Bundle getMetadata() {
        return this.lk;
    }

    public int getStatusCode() {
        return this.ka;
    }

    public String getString(String string2, int n2, int n3) {
        this.a(string2, n2);
        return this.lj[n3].getString(n2 - this.ll[n3], this.li.getInt(string2));
    }

    int getVersionCode() {
        return this.kZ;
    }

    public boolean hasNull(String string2, int n2, int n3) {
        this.a(string2, n2);
        return this.lj[n3].isNull(n2 - this.ll[n3], this.li.getInt(string2));
    }

    public boolean isClosed() {
        synchronized (this) {
            return this.mClosed;
        }
    }

    public Uri parseUri(String string2, int n2, int n3) {
        if ((string2 = this.getString(string2, n2, n3)) != null) return Uri.parse((String)string2);
        return null;
    }

    public int t(int n2) {
        int n3;
        block1: {
            int n4 = 0;
            boolean bl2 = n2 >= 0 && n2 < this.lm;
            du.n(bl2);
            do {
                n3 = ++n4;
                if (n4 >= this.ll.length) break block1;
            } while (n2 >= this.ll[n4]);
            n3 = n4 - 1;
        }
        n2 = n3;
        if (n3 != this.ll.length) return n2;
        return n3 - 1;
    }

    public void validateContents() {
        int n2;
        int n3 = 0;
        this.li = new Bundle();
        for (n2 = 0; n2 < this.lh.length; ++n2) {
            this.li.putInt(this.lh[n2], n2);
        }
        this.ll = new int[this.lj.length];
        int n4 = 0;
        n2 = n3;
        n3 = n4;
        while (true) {
            if (n2 >= this.lj.length) {
                this.lm = n3;
                return;
            }
            this.ll[n2] = n3;
            n3 += this.lj[n2].getNumRows();
            ++n2;
        }
    }

    public void writeToParcel(Parcel parcel, int n2) {
        DataHolderCreator.a(this, parcel, n2);
    }

    public static class Builder {
        private final String[] lh;
        private final ArrayList<HashMap<String, Object>> lq;
        private final String lr;
        private final HashMap<Object, Integer> ls;
        private boolean lt;
        private String lu;

        private Builder(String[] stringArray, String string2) {
            this.lh = du.f(stringArray);
            this.lq = new ArrayList();
            this.lr = string2;
            this.ls = new HashMap();
            this.lt = false;
            this.lu = null;
        }

        private void a(HashMap<String, Object> object) {
            if ((object = ((HashMap)object).get(this.lr)) == null) {
                return;
            }
            Integer n2 = this.ls.remove(object);
            if (n2 != null) {
                this.lq.remove(n2);
            }
            this.ls.put(object, this.lq.size());
        }

        private void bk() {
            if (this.lr == null) return;
            this.ls.clear();
            int n2 = this.lq.size();
            int n3 = 0;
            while (n3 < n2) {
                Object object = this.lq.get(n3).get(this.lr);
                if (object != null) {
                    this.ls.put(object, n3);
                }
                ++n3;
            }
        }

        static /* synthetic */ ArrayList c(Builder builder) {
            return builder.lq;
        }

        public DataHolder build(int n2) {
            return new DataHolder(this, n2, null);
        }

        public DataHolder build(int n2, Bundle bundle) {
            return new DataHolder(this, n2, bundle);
        }

        public int getCount() {
            return this.lq.size();
        }

        public Builder removeRowsWithValue(String string2, Object object) {
            int n2 = this.lq.size() - 1;
            while (n2 >= 0) {
                if (ds.equal(this.lq.get(n2).get(string2), object)) {
                    this.lq.remove(n2);
                }
                --n2;
            }
            return this;
        }

        public Builder sort(String string2) {
            dg.d(string2);
            if (this.lt && string2.equals(this.lu)) {
                return this;
            }
            Collections.sort(this.lq, new a(string2));
            this.bk();
            this.lt = true;
            this.lu = string2;
            return this;
        }

        public Builder withRow(ContentValues object) {
            dg.d(object);
            HashMap<String, Object> hashMap = new HashMap<String, Object>(object.size());
            object = object.valueSet().iterator();
            while (object.hasNext()) {
                Map.Entry entry = (Map.Entry)object.next();
                hashMap.put((String)entry.getKey(), entry.getValue());
            }
            return this.withRow(hashMap);
        }

        public Builder withRow(HashMap<String, Object> hashMap) {
            dg.d(hashMap);
            if (this.lr != null) {
                this.a(hashMap);
            }
            this.lq.add(hashMap);
            this.lt = false;
            return this;
        }
    }

    private static final class a
    implements Comparator<HashMap<String, Object>> {
        private final String lv;

        a(String string2) {
            this.lv = du.f(string2);
        }

        public int a(HashMap<String, Object> object, HashMap<String, Object> object2) {
            if ((object = du.f(((HashMap)object).get(this.lv))).equals(object2 = du.f(((HashMap)object2).get(this.lv)))) {
                return 0;
            }
            if (object instanceof Boolean) {
                return ((Boolean)object).compareTo((Boolean)object2);
            }
            if (object instanceof Long) {
                return ((Long)object).compareTo((Long)object2);
            }
            if (object instanceof Integer) {
                return ((Integer)object).compareTo((Integer)object2);
            }
            if (!(object instanceof String)) throw new IllegalArgumentException("Unknown type for lValue " + object);
            return ((String)object).compareTo((String)object2);
        }

        @Override
        public /* synthetic */ int compare(Object object, Object object2) {
            return this.a((HashMap)object, (HashMap)object2);
        }
    }
}

