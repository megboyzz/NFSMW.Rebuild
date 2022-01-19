/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.drive.query;

import com.google.android.gms.drive.metadata.CollectionMetadataField;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.OrderedMetadataField;
import com.google.android.gms.drive.query.Filter;
import com.google.android.gms.drive.query.SearchableField;
import com.google.android.gms.drive.query.internal.ComparisonFilter;
import com.google.android.gms.drive.query.internal.FieldOnlyFilter;
import com.google.android.gms.drive.query.internal.InFilter;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.NotFilter;
import com.google.android.gms.drive.query.internal.Operator;
import java.util.List;

public class Filters {
    public static Filter and(Filter filter, Filter ... filterArray) {
        return new LogicalFilter(Operator.pw, filter, filterArray);
    }

    public static Filter and(List<Filter> list) {
        return new LogicalFilter(Operator.pw, list);
    }

    public static Filter contains(MetadataField<String> metadataField, String string2) {
        return new ComparisonFilter<String>(Operator.pz, metadataField, string2);
    }

    public static <T> Filter eq(MetadataField<T> metadataField, T t2) {
        return new ComparisonFilter<T>(Operator.pr, metadataField, t2);
    }

    public static <T extends Comparable<T>> Filter greaterThan(OrderedMetadataField<T> orderedMetadataField, T t2) {
        return new ComparisonFilter<T>(Operator.pu, orderedMetadataField, t2);
    }

    public static <T extends Comparable<T>> Filter greaterThanEquals(OrderedMetadataField<T> orderedMetadataField, T t2) {
        return new ComparisonFilter<T>(Operator.pv, orderedMetadataField, t2);
    }

    public static <T> Filter in(CollectionMetadataField<T> collectionMetadataField, T t2) {
        return new InFilter<T>(collectionMetadataField, t2);
    }

    public static <T extends Comparable<T>> Filter lessThan(OrderedMetadataField<T> orderedMetadataField, T t2) {
        return new ComparisonFilter<T>(Operator.ps, orderedMetadataField, t2);
    }

    public static <T extends Comparable<T>> Filter lessThanEquals(OrderedMetadataField<T> orderedMetadataField, T t2) {
        return new ComparisonFilter<T>(Operator.pt, orderedMetadataField, t2);
    }

    public static Filter not(Filter filter) {
        return new NotFilter(filter);
    }

    public static Filter or(Filter filter, Filter ... filterArray) {
        return new LogicalFilter(Operator.px, filter, filterArray);
    }

    public static Filter or(List<Filter> list) {
        return new LogicalFilter(Operator.px, list);
    }

    public static Filter sharedWithMe() {
        return new FieldOnlyFilter(SearchableField.pa);
    }
}

