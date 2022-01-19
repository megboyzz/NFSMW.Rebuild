/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.a;
import com.google.android.gms.internal.v;
import com.google.android.gms.internal.x;
import java.util.Date;
import java.util.HashSet;

public final class bg {
    public static int a(AdRequest.ErrorCode errorCode) {
        switch (errorCode) {
            default: {
                return 0;
            }
            case INVALID_REQUEST: {
                return 1;
            }
            case NETWORK_ERROR: {
                return 2;
            }
            case NO_FILL: 
        }
        return 3;
    }

    public static int a(AdRequest.Gender gender) {
        switch (gender) {
            default: {
                return 0;
            }
            case FEMALE: {
                return 2;
            }
            case MALE: 
        }
        return 1;
    }

    public static AdSize b(x x2) {
        return new AdSize(a.a(x2.width, x2.height, x2.eF));
    }

    public static MediationAdRequest e(v v2) {
        HashSet<String> hashSet;
        if (v2.ez != null) {
            hashSet = new HashSet<String>(v2.ez);
            return new MediationAdRequest(new Date(v2.ex), bg.g(v2.ey), hashSet, v2.eA);
        }
        hashSet = null;
        return new MediationAdRequest(new Date(v2.ex), bg.g(v2.ey), hashSet, v2.eA);
    }

    public static AdRequest.Gender g(int n2) {
        switch (n2) {
            default: {
                return AdRequest.Gender.UNKNOWN;
            }
            case 2: {
                return AdRequest.Gender.FEMALE;
            }
            case 1: 
        }
        return AdRequest.Gender.MALE;
    }

    public static final AdRequest.ErrorCode h(int n2) {
        switch (n2) {
            default: {
                return AdRequest.ErrorCode.INTERNAL_ERROR;
            }
            case 1: {
                return AdRequest.ErrorCode.INVALID_REQUEST;
            }
            case 2: {
                return AdRequest.ErrorCode.NETWORK_ERROR;
            }
            case 3: 
        }
        return AdRequest.ErrorCode.NO_FILL;
    }
}

