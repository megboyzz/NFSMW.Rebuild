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
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.dg;
import com.google.android.gms.internal.ds;
import com.google.android.gms.internal.du;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/* loaded from: stdlib.jar:com/google/android/gms/common/data/DataHolder.class */
public final class DataHolder implements SafeParcelable {
    public static final DataHolderCreator CREATOR = new DataHolderCreator();
    private static final Builder lp = new Builder(new String[0], null) { // from class: com.google.android.gms.common.data.DataHolder.1
        @Override // com.google.android.gms.common.data.DataHolder.Builder
        public Builder withRow(ContentValues contentValues) {
            throw new UnsupportedOperationException("Cannot add data to empty builder");
        }

        @Override // com.google.android.gms.common.data.DataHolder.Builder
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
    private boolean lo;
    boolean mClosed;

    /* loaded from: stdlib.jar:com/google/android/gms/common/data/DataHolder$Builder.class */
    public static class Builder {
        private final String[] lh;
        private final ArrayList<HashMap<String, Object>> lq;
        private final String lr;
        private final HashMap<Object, Integer> ls;
        private boolean lt;
        private String lu;

        private Builder(String[] strArr, String str) {
            this.lh = (String[]) du.f(strArr);
            this.lq = new ArrayList<>();
            this.lr = str;
            this.ls = new HashMap<>();
            this.lt = false;
            this.lu = null;
        }

        private void a(HashMap<String, Object> hashMap) {
            Object obj = hashMap.get(this.lr);
            if (obj != null) {
                Integer remove = this.ls.remove(obj);
                if (remove != null) {
                    this.lq.remove(remove.intValue());
                }
                this.ls.put(obj, Integer.valueOf(this.lq.size()));
            }
        }

        private void bk() {
            if (this.lr != null) {
                this.ls.clear();
                int size = this.lq.size();
                for (int i = 0; i < size; i++) {
                    Object obj = this.lq.get(i).get(this.lr);
                    if (obj != null) {
                        this.ls.put(obj, Integer.valueOf(i));
                    }
                }
            }
        }

        public DataHolder build(int i) {
            return new DataHolder(this, i, (Bundle) null);
        }

        public DataHolder build(int i, Bundle bundle) {
            return new DataHolder(this, i, bundle);
        }

        public int getCount() {
            return this.lq.size();
        }

        public Builder removeRowsWithValue(String str, Object obj) {
            int size = this.lq.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    return this;
                }
                if (ds.equal(this.lq.get(i).get(str), obj)) {
                    this.lq.remove(i);
                }
                size = i;
            }
        }

        public Builder sort(String str) {
            dg.d(str);
            if (this.lt && str.equals(this.lu)) {
                return this;
            }
            Collections.sort(this.lq, new a(str));
            bk();
            this.lt = true;
            this.lu = str;
            return this;
        }

        public Builder withRow(ContentValues contentValues) {
            dg.d(contentValues);
            HashMap<String, Object> hashMap = new HashMap<>(contentValues.size());
            for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            return withRow(hashMap);
        }

        public Builder withRow(HashMap<String, Object> hashMap) {
            dg.d(hashMap);
            if (this.lr != null) {
                a(hashMap);
            }
            this.lq.add(hashMap);
            this.lt = false;
            return this;
        }
    }

    /* loaded from: stdlib.jar:com/google/android/gms/common/data/DataHolder$a.class */
    private static final class a implements Comparator<HashMap<String, Object>> {
        private final String lv;

        a(String str) {
            this.lv = (String) du.f(str);
        }

        /* renamed from: a */
        public int compare(HashMap<String, Object> hashMap, HashMap<String, Object> hashMap2) {
            Object f = du.f(hashMap.get(this.lv));
            Object f2 = du.f(hashMap2.get(this.lv));
            if (f.equals(f2)) {
                return 0;
            }
            if (f instanceof Boolean) {
                return ((Boolean) f).compareTo((Boolean) f2);
            }
            if (f instanceof Long) {
                return ((Long) f).compareTo((Long) f2);
            }
            if (f instanceof Integer) {
                return ((Integer) f).compareTo((Integer) f2);
            }
            if (f instanceof String) {
                return ((String) f).compareTo((String) f2);
            }
            throw new IllegalArgumentException("Unknown type for lValue " + f);
        }
    }

    public DataHolder(int i, String[] strArr, CursorWindow[] cursorWindowArr, int i2, Bundle bundle) {
        this.mClosed = false;
        this.lo = true;
        this.kZ = i;
        this.lh = strArr;
        this.lj = cursorWindowArr;
        this.ka = i2;
        this.lk = bundle;
    }

    public DataHolder(AbstractWindowedCursor abstractWindowedCursor, int i, Bundle bundle) {
        this(abstractWindowedCursor.getColumnNames(), a(abstractWindowedCursor), i, bundle);
    }

    private DataHolder(Builder builder, int i, Bundle bundle) {
        this(builder.lh, a(builder), i, bundle);
    }

    public DataHolder(String[] strArr, CursorWindow[] cursorWindowArr, int i, Bundle bundle) {
        this.mClosed = false;
        this.lo = true;
        this.kZ = 1;
        this.lh = (String[]) du.f(strArr);
        this.lj = (CursorWindow[]) du.f(cursorWindowArr);
        this.ka = i;
        this.lk = bundle;
        validateContents();
    }

    private void a(String str, int i) {
        if (this.li == null || !this.li.containsKey(str)) {
            throw new IllegalArgumentException("No such column: " + str);
        } else if (isClosed()) {
            throw new IllegalArgumentException("Buffer is closed.");
        } else if (i < 0 || i >= this.lm) {
            throw new CursorIndexOutOfBoundsException(i, this.lm);
        }
    }

    /* JADX WARN: Finally extract failed */
    private static CursorWindow[] a(AbstractWindowedCursor abstractWindowedCursor) {
        int i;
        ArrayList arrayList = new ArrayList();
        try {
            int count = abstractWindowedCursor.getCount();
            CursorWindow window = abstractWindowedCursor.getWindow();
            if (window == null || window.getStartPosition() != 0) {
                i = 0;
            } else {
                window.acquireReference();
                abstractWindowedCursor.setWindow(null);
                arrayList.add(window);
                i = window.getNumRows();
            }
            while (i < count) {
                if (!abstractWindowedCursor.moveToPosition(i)) {
                    break;
                }
                CursorWindow window2 = abstractWindowedCursor.getWindow();
                if (window2 != null) {
                    window2.acquireReference();
                    abstractWindowedCursor.setWindow(null);
                } else {
                    window2 = new CursorWindow(false);
                    abstractWindowedCursor.fillWindow(i, window2);
                }
                if (window2.getNumRows() == 0) {
                    break;
                }
                arrayList.add(window2);
                i = window2.getNumRows() + window2.getStartPosition();
            }
            abstractWindowedCursor.close();
            return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
        } catch (Throwable th) {
            abstractWindowedCursor.close();
            throw th;
        }
    }

    private static CursorWindow[] a(Builder builder) {
        int i;
        if (builder.lh.length == 0) {
            return new CursorWindow[0];
        }
        ArrayList arrayList = builder.lq;
        int size = arrayList.size();
        CursorWindow cursorWindow = new CursorWindow(false);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(cursorWindow);
        cursorWindow.setNumColumns(builder.lh.length);
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            try {
                if (!cursorWindow.allocRow()) {
                    Log.d("DataHolder", "Allocating additional cursor window for large data set (row " + i2 + ")");
                    cursorWindow = new CursorWindow(false);
                    cursorWindow.setNumColumns(builder.lh.length);
                    arrayList2.add(cursorWindow);
                    if (!cursorWindow.allocRow()) {
                        Log.e("DataHolder", "Unable to allocate row to hold data.");
                        arrayList2.remove(cursorWindow);
                        return (CursorWindow[]) arrayList2.toArray(new CursorWindow[arrayList2.size()]);
                    }
                    i3 = 0;
                }
                Map map = (Map) arrayList.get(i2);
                boolean z = true;
                for (int i4 = 0; i4 < builder.lh.length && z; i4++) {
                    String str = builder.lh[i4];
                    Object obj = map.get(str);
                    if (obj == null) {
                        z = cursorWindow.putNull(i3, i4);
                    } else if (obj instanceof String) {
                        z = cursorWindow.putString((String) obj, i3, i4);
                    } else if (obj instanceof Long) {
                        z = cursorWindow.putLong(((Long) obj).longValue(), i3, i4);
                    } else if (obj instanceof Integer) {
                        z = cursorWindow.putLong((long) ((Integer) obj).intValue(), i3, i4);
                    } else if (obj instanceof Boolean) {
                        z = cursorWindow.putLong(((Boolean) obj).booleanValue() ? 1 : 0, i3, i4);
                    } else if (obj instanceof byte[]) {
                        z = cursorWindow.putBlob((byte[]) obj, i3, i4);
                    } else {
                        throw new IllegalArgumentException("Unsupported object for column " + str + ": " + obj);
                    }
                }
                if (!z) {
                    Log.d("DataHolder", "Couldn't populate window data for row " + i2 + " - allocating new window.");
                    cursorWindow.freeLastRow();
                    cursorWindow = new CursorWindow(false);
                    cursorWindow.setNumColumns(builder.lh.length);
                    arrayList2.add(cursorWindow);
                    i = i2 - 1;
                    i3 = 0;
                } else {
                    i3++;
                    i = i2;
                }
                i2 = i + 1;
            } catch (RuntimeException e) {
                int size2 = arrayList2.size();
                for (int i5 = 0; i5 < size2; i5++) {
                    ((CursorWindow) arrayList2.get(i5)).close();
                }
                throw e;
            }
        }
        return (CursorWindow[]) arrayList2.toArray(new CursorWindow[arrayList2.size()]);
    }

    public static Builder builder(String[] strArr) {
        return new Builder(strArr, null);
    }

    public static Builder builder(String[] strArr, String str) {
        du.f(str);
        return new Builder(strArr, str);
    }

    public static DataHolder empty(int i) {
        return empty(i, null);
    }

    public static DataHolder empty(int i, Bundle bundle) {
        return new DataHolder(lp, i, bundle);
    }

    public String[] bi() {
        return this.lh;
    }

    public CursorWindow[] bj() {
        return this.lj;
    }

    public void c(Object obj) {
        this.ln = obj;
    }

    public void close() {
        synchronized (this) {
            if (!this.mClosed) {
                this.mClosed = true;
                for (int i = 0; i < this.lj.length; i++) {
                    this.lj[i].close();
                }
            }
        }
    }

    public void copyToBuffer(String str, int i, int i2, CharArrayBuffer charArrayBuffer) {
        a(str, i);
        this.lj[i2].copyStringToBuffer(i - this.ll[i2], this.li.getInt(str), charArrayBuffer);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    protected void finalize() throws Throwable {
        try {
            if (this.lo && this.lj.length > 0 && !isClosed()) {
                Log.e("DataBuffer", "Internal data leak within a DataBuffer object detected!  Be sure to explicitly call close() on all DataBuffer extending objects when you are done with them. (" + (this.ln == null ? "internal object: " + toString() : this.ln.toString()) + ")");
                close();
            }
        } finally {
            super.finalize();
        }
    }

    public boolean getBoolean(String str, int i, int i2) {
        a(str, i);
        return Long.valueOf(this.lj[i2].getLong(i - this.ll[i2], this.li.getInt(str))).longValue() == 1;
    }

    public byte[] getByteArray(String str, int i, int i2) {
        a(str, i);
        return this.lj[i2].getBlob(i - this.ll[i2], this.li.getInt(str));
    }

    public int getCount() {
        return this.lm;
    }

    public int getInteger(String str, int i, int i2) {
        a(str, i);
        return this.lj[i2].getInt(i - this.ll[i2], this.li.getInt(str));
    }

    public long getLong(String str, int i, int i2) {
        a(str, i);
        return this.lj[i2].getLong(i - this.ll[i2], this.li.getInt(str));
    }

    public Bundle getMetadata() {
        return this.lk;
    }

    public int getStatusCode() {
        return this.ka;
    }

    public String getString(String str, int i, int i2) {
        a(str, i);
        return this.lj[i2].getString(i - this.ll[i2], this.li.getInt(str));
    }

    public int getVersionCode() {
        return this.kZ;
    }

    public boolean hasNull(String str, int i, int i2) {
        a(str, i);
        return this.lj[i2].isNull(i - this.ll[i2], this.li.getInt(str));
    }

    public boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.mClosed;
        }
        return z;
    }

    public Uri parseUri(String str, int i, int i2) {
        String string = getString(str, i, i2);
        if (string == null) {
            return null;
        }
        return Uri.parse(string);
    }

    public int t(int i) {
        int i2;
        int i3 = 0;
        du.n(i >= 0 && i < this.lm);
        while (true) {
            i2 = i3;
            if (i3 >= this.ll.length) {
                break;
            } else if (i < this.ll[i3]) {
                i2 = i3 - 1;
                break;
            } else {
                i3++;
            }
        }
        int i4 = i2;
        if (i2 == this.ll.length) {
            i4 = i2 - 1;
        }
        return i4;
    }

    public void validateContents() {
        this.li = new Bundle();
        for (int i = 0; i < this.lh.length; i++) {
            this.li.putInt(this.lh[i], i);
        }
        this.ll = new int[this.lj.length];
        int i2 = 0;
        for (int i3 = 0; i3 < this.lj.length; i3++) {
            this.ll[i3] = i2;
            i2 += this.lj[i3].getNumRows();
        }
        this.lm = i2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        DataHolderCreator.a(this, parcel, i);
    }
}
