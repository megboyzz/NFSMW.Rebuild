/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.PendingIntent
 *  android.content.IntentSender$SendIntentException
 *  android.os.Parcel
 */
package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import android.os.Parcel;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ds;

public final class Status
implements Result,
SafeParcelable {
    public static final StatusCreator CREATOR;
    public static final int DATE_INVALID = 12;
    public static final int DEVELOPER_ERROR = 10;
    public static final int ERROR = 13;
    public static final int GEOFENCE_NOT_AVAILABLE = 1000;
    public static final int GEOFENCE_TOO_MANY_GEOFENCES = 1001;
    public static final int GEOFENCE_TOO_MANY_PENDING_INTENTS = 1002;
    public static final int INTERNAL_ERROR = 8;
    public static final int INTERRUPTED = 14;
    public static final int INVALID_ACCOUNT = 5;
    public static final int LICENSE_CHECK_FAILED = 11;
    public static final int NETWORK_ERROR = 7;
    public static final int RESOLUTION_REQUIRED = 6;
    public static final int SERVICE_DISABLED = 3;
    public static final int SERVICE_INVALID = 9;
    public static final int SERVICE_MISSING = 1;
    public static final int SERVICE_VERSION_UPDATE_REQUIRED = 2;
    public static final int SIGN_IN_REQUIRED = 4;
    public static final int SUCCESS = 0;
    public static final int SUCCESS_CACHE = -1;
    public static final int TIMEOUT = 15;
    public static final Status kW;
    public static final Status kX;
    public static final Status kY;
    private int kZ = 0;
    private int ka = 0;
    private String la = "";
    private PendingIntent mPendingIntent = null;

    static {
        kW = new Status(0, null, null);
        kX = new Status(14, null, null);
        kY = new Status(15, null, null);
        CREATOR = new StatusCreator();
    }

    public Status(int n2) {
        this(1, n2, null, null);
    }

    Status(int n2, int n3, String string2, PendingIntent pendingIntent) {
        this.kZ = n2;
        this.ka = n3;
        this.la = string2;
        this.mPendingIntent = pendingIntent;
    }

    public Status(int n2, String string2, PendingIntent pendingIntent) {
        this(1, n2, string2, pendingIntent);
    }

    public Status() {

    }

    private String aT() {
        if (this.la != null) {
            return this.la;
        }
        switch (this.ka) {
            default: {
                return "unknown status code " + this.ka;
            }
            case -1: {
                return "SUCCESS_CACHE";
            }
            case 0: {
                return "SUCCESS";
            }
            case 1: {
                return "SERVICE_MISSING";
            }
            case 2: {
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            }
            case 3: {
                return "SERVICE_DISABLED";
            }
            case 4: {
                return "SIGN_IN_REQUIRED";
            }
            case 5: {
                return "INVALID_ACCOUNT";
            }
            case 6: {
                return "RESOLUTION_REQUIRED";
            }
            case 7: {
                return "NETWORK_ERROR";
            }
            case 8: {
                return "INTERNAL_ERROR";
            }
            case 9: {
                return "SERVICE_INVALID";
            }
            case 10: {
                return "DEVELOPER_ERROR";
            }
            case 11: 
        }
        return "LICENSE_CHECK_FAILED";
    }

    PendingIntent bf() {
        return this.mPendingIntent;
    }

    String bg() {
        return this.la;
    }

    @Deprecated
    public ConnectionResult bh() {
        return new ConnectionResult(this.ka, this.mPendingIntent);
    }

    public int describeContents() {
        return 0;
    }

    public PendingIntent getResolution() {
        return this.mPendingIntent;
    }

    @Override
    public Status getStatus() {
        return this;
    }

    public int getStatusCode() {
        return this.ka;
    }

    int getVersionCode() {
        return this.kZ;
    }

    public boolean hasResolution() {
        if (this.mPendingIntent == null) return false;
        return true;
    }

    public boolean isInterrupted() {
        if (this.ka != 14) return false;
        return true;
    }

    public boolean isSuccess() {
        if (this.ka > 0) return false;
        return true;
    }

    public void startResolutionForResult(Activity activity, int n2) throws IntentSender.SendIntentException {
        if (!this.hasResolution()) {
            return;
        }
        activity.startIntentSenderForResult(this.mPendingIntent.getIntentSender(), n2, null, 0, 0, 0);
    }

    public String toString() {
        return ds.e(this).a("statusCode", this.aT()).a("resolution", this.mPendingIntent).toString();
    }

    public void writeToParcel(Parcel parcel, int n2) {
        StatusCreator.a(this, parcel, n2);
    }
}

