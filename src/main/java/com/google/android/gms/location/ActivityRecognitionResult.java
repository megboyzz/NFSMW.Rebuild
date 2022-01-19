/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.Parcel
 */
package com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.du;
import com.google.android.gms.location.ActivityRecognitionResultCreator;
import com.google.android.gms.location.DetectedActivity;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ActivityRecognitionResult
implements SafeParcelable {
    public static final ActivityRecognitionResultCreator CREATOR = new ActivityRecognitionResultCreator();
    public static final String EXTRA_ACTIVITY_RESULT = "com.google.android.location.internal.EXTRA_ACTIVITY_RESULT";
    private final int kZ;
    List<DetectedActivity> tt;
    long tu;
    long tv;

    public ActivityRecognitionResult(int n2, List<DetectedActivity> list, long l2, long l3) {
        this.kZ = 1;
        this.tt = list;
        this.tu = l2;
        this.tv = l3;
    }

    public ActivityRecognitionResult(DetectedActivity detectedActivity, long l2, long l3) {
        this(Collections.singletonList(detectedActivity), l2, l3);
    }

    public ActivityRecognitionResult(List<DetectedActivity> list, long l2, long l3) {
        boolean bl2 = list != null && list.size() > 0;
        du.b(bl2, "Must have at least 1 detected activity");
        this.kZ = 1;
        this.tt = list;
        this.tu = l2;
        this.tv = l3;
    }

    public static ActivityRecognitionResult extractResult(Intent intent) {
        if (ActivityRecognitionResult.hasResult(intent)) return (ActivityRecognitionResult)intent.getExtras().get(EXTRA_ACTIVITY_RESULT);
        return null;
    }

    public static boolean hasResult(Intent intent) {
        if (intent != null) return intent.hasExtra(EXTRA_ACTIVITY_RESULT);
        return false;
    }

    public int describeContents() {
        return 0;
    }

    public int getActivityConfidence(int n2) {
        DetectedActivity detectedActivity;
        Iterator<DetectedActivity> iterator = this.tt.iterator();
        do {
            if (!iterator.hasNext()) return 0;
        } while ((detectedActivity = iterator.next()).getType() != n2);
        return detectedActivity.getConfidence();
    }

    public long getElapsedRealtimeMillis() {
        return this.tv;
    }

    public DetectedActivity getMostProbableActivity() {
        return this.tt.get(0);
    }

    public List<DetectedActivity> getProbableActivities() {
        return this.tt;
    }

    public long getTime() {
        return this.tu;
    }

    public int getVersionCode() {
        return this.kZ;
    }

    public String toString() {
        return "ActivityRecognitionResult [probableActivities=" + this.tt + ", timeMillis=" + this.tu + ", elapsedRealtimeMillis=" + this.tv + "]";
    }

    public void writeToParcel(Parcel parcel, int n2) {
        ActivityRecognitionResultCreator.a(this, parcel, n2);
    }
}

