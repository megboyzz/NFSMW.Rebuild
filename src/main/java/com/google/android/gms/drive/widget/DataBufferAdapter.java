/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.CursorIndexOutOfBoundsException
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.BaseAdapter
 *  android.widget.TextView
 */
package com.google.android.gms.drive.widget;

import android.content.Context;
import android.database.CursorIndexOutOfBoundsException;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.android.gms.common.data.DataBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DataBufferAdapter<T>
extends BaseAdapter {
    private final Context mContext;
    private final int pA;
    private int pB;
    private final int pC;
    private final List<DataBuffer<T>> pD;
    private final LayoutInflater pE;
    private boolean pF = true;

    public DataBufferAdapter(Context context, int n2) {
        this(context, n2, 0, new ArrayList<DataBuffer<T>>());
    }

    public DataBufferAdapter(Context context, int n2, int n3) {
        this(context, n2, n3, new ArrayList<DataBuffer<T>>());
    }

    public DataBufferAdapter(Context context, int n2, int n3, List<DataBuffer<T>> list) {
        this.mContext = context;
        this.pB = n2;
        this.pA = n2;
        this.pC = n3;
        this.pD = list;
        this.pE = (LayoutInflater)context.getSystemService("layout_inflater");
    }

    public DataBufferAdapter(Context context, int n2, int n3, DataBuffer<T> ... dataBufferArray) {
        this(context, n2, n3, Arrays.asList(dataBufferArray));
    }

    public DataBufferAdapter(Context context, int n2, List<DataBuffer<T>> list) {
        this(context, n2, 0, list);
    }

    public DataBufferAdapter(Context context, int n2, DataBuffer<T> ... dataBufferArray) {
        this(context, n2, 0, Arrays.asList(dataBufferArray));
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private View a(int n2, View view, ViewGroup viewGroup, int n3) {
        T t2;
        if (view == null) {
            view = this.pE.inflate(n3, viewGroup, false);
        }
        try {
            if (this.pC != 0) {
                viewGroup = (TextView)view.findViewById(this.pC);
            }
            viewGroup = (TextView)view;
        }
        catch (ClassCastException classCastException) {
            Log.e((String)"DataBufferAdapter", (String)"You must supply a resource ID for a TextView");
            throw new IllegalStateException("DataBufferAdapter requires the resource ID to be a TextView", classCastException);
        }
        if ((t2 = this.getItem(n2)) instanceof CharSequence) {
            viewGroup.setText((CharSequence)t2);
            return view;
        }
        viewGroup.setText((CharSequence)t2.toString());
        return view;
    }

    public void append(DataBuffer<T> dataBuffer) {
        this.pD.add(dataBuffer);
        if (!this.pF) return;
        this.notifyDataSetChanged();
    }

    public void clear() {
        Iterator<DataBuffer<T>> iterator = this.pD.iterator();
        while (true) {
            if (!iterator.hasNext()) {
                this.pD.clear();
                if (!this.pF) return;
                this.notifyDataSetChanged();
                return;
            }
            iterator.next().close();
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public int getCount() {
        Iterator<DataBuffer<T>> iterator = this.pD.iterator();
        int n2 = 0;
        while (iterator.hasNext()) {
            n2 = iterator.next().getCount() + n2;
        }
        return n2;
    }

    public View getDropDownView(int n2, View view, ViewGroup viewGroup) {
        return this.a(n2, view, viewGroup, this.pB);
    }

    public T getItem(int n2) throws CursorIndexOutOfBoundsException {
        DataBuffer<T> dataBuffer;
        int n3;
        Iterator<DataBuffer<T>> iterator;
        block4: {
            iterator = this.pD.iterator();
            n3 = n2;
            while (iterator.hasNext()) {
                dataBuffer = iterator.next();
                int n4 = dataBuffer.getCount();
                if (n4 <= n3) {
                    n3 -= n4;
                    continue;
                }
                break block4;
            }
            throw new CursorIndexOutOfBoundsException(n2, this.getCount());
        }
        try {
            iterator = dataBuffer.get(n3);
            return (T)iterator;
        }
        catch (CursorIndexOutOfBoundsException cursorIndexOutOfBoundsException) {
            throw new CursorIndexOutOfBoundsException(n2, this.getCount());
        }
    }

    public long getItemId(int n2) {
        return n2;
    }

    public View getView(int n2, View view, ViewGroup viewGroup) {
        return this.a(n2, view, viewGroup, this.pA);
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.pF = true;
    }

    public void setDropDownViewResource(int n2) {
        this.pB = n2;
    }

    public void setNotifyOnChange(boolean bl2) {
        this.pF = bl2;
    }
}

