/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.DetectedActivity;
import java.util.ArrayList;

public class ActivityRecognitionResultCreator
implements Parcelable.Creator<ActivityRecognitionResult> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void a(ActivityRecognitionResult activityRecognitionResult, Parcel parcel, int n2) {
        n2 = b.l(parcel);
        b.b(parcel, 1, activityRecognitionResult.tt, false);
        b.c(parcel, 1000, activityRecognitionResult.getVersionCode());
        b.a(parcel, 2, activityRecognitionResult.tu);
        b.a(parcel, 3, activityRecognitionResult.tv);
        b.D(parcel, n2);
    }

    public ActivityRecognitionResult createFromParcel(Parcel parcel) {
        long l2 = 0L;
        int n2 = a.k(parcel);
        int n3 = 0;
        ArrayList<DetectedActivity> arrayList = null;
        long l3 = 0L;
        block6: while (true) {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new ActivityRecognitionResult(n3, arrayList, l3, l2);
                throw new a.a("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.j(parcel);
            switch (a.A(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block6;
                }
                case 1: {
                    arrayList = a.c(parcel, n4, DetectedActivity.CREATOR);
                    continue block6;
                }
                case 1000: {
                    n3 = a.g(parcel, n4);
                    continue block6;
                }
                case 2: {
                    l3 = a.h(parcel, n4);
                    continue block6;
                }
                case 3: 
            }
            l2 = a.h(parcel, n4);
        }
    }

    public ActivityRecognitionResult[] newArray(int n2) {
        return new ActivityRecognitionResult[n2];
    }
}

