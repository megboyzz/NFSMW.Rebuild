/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Filter;
import com.google.android.gms.drive.query.internal.FilterHolder;
import com.google.android.gms.drive.query.internal.Operator;
import com.google.android.gms.drive.query.internal.f;
import java.util.ArrayList;
import java.util.List;

public class LogicalFilter
implements SafeParcelable,
Filter {
    public static final Parcelable.Creator<LogicalFilter> CREATOR = new f();
    final int kZ;
    private List<Filter> pe;
    final Operator pf;
    final List<FilterHolder> pp;

    LogicalFilter(int n2, Operator operator, List<FilterHolder> list) {
        this.kZ = n2;
        this.pf = operator;
        this.pp = list;
    }

    public LogicalFilter(Operator object, Filter filter, Filter ... filterArray) {
        this.kZ = 1;
        this.pf = object;
        this.pp = new ArrayList<FilterHolder>(filterArray.length + 1);
        this.pp.add(new FilterHolder(filter));
        this.pe = new ArrayList<Filter>(filterArray.length + 1);
        this.pe.add(filter);
        int n2 = filterArray.length;
        int n3 = 0;
        while (n3 < n2) {
            object = filterArray[n3];
            this.pp.add(new FilterHolder((Filter)object));
            this.pe.add((Filter)object);
            ++n3;
        }
    }

    public LogicalFilter(Operator object, List<Filter> object2) {
        this.kZ = 1;
        this.pf = object;
        this.pe = object2;
        this.pp = new ArrayList<FilterHolder>(object2.size());
        object = object2.iterator();
        while (object.hasNext()) {
            object2 = (Filter)object.next();
            this.pp.add(new FilterHolder((Filter)object2));
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        f.a(this, parcel, n2);
    }
}

