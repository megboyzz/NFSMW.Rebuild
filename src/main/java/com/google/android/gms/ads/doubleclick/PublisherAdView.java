/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.ViewGroup
 */
package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.internal.ag;

public final class PublisherAdView
extends ViewGroup {
    private final ag dZ;

    public PublisherAdView(Context context) {
        super(context);
        this.dZ = new ag(this);
    }

    public PublisherAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dZ = new ag(this, attributeSet, true);
    }

    public PublisherAdView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.dZ = new ag(this, attributeSet, true);
    }

    public void destroy() {
        this.dZ.destroy();
    }

    public AdListener getAdListener() {
        return this.dZ.getAdListener();
    }

    public AdSize getAdSize() {
        return this.dZ.getAdSize();
    }

    public AdSize[] getAdSizes() {
        return this.dZ.getAdSizes();
    }

    public String getAdUnitId() {
        return this.dZ.getAdUnitId();
    }

    public AppEventListener getAppEventListener() {
        return this.dZ.getAppEventListener();
    }

    public void loadAd(PublisherAdRequest publisherAdRequest) {
        this.dZ.a(publisherAdRequest.v());
    }

    protected void onLayout(boolean bl2, int n2, int n3, int n4, int n5) {
        View view = this.getChildAt(0);
        if (view == null) return;
        if (view.getVisibility() == 8) return;
        int n6 = view.getMeasuredWidth();
        int n7 = view.getMeasuredHeight();
        n2 = (n4 - n2 - n6) / 2;
        n3 = (n5 - n3 - n7) / 2;
        view.layout(n2, n3, n6 + n2, n7 + n3);
    }

    protected void onMeasure(int n2, int n3) {
        int n4;
        int n5 = 0;
        View view = this.getChildAt(0);
        AdSize adSize = this.getAdSize();
        if (view != null && view.getVisibility() != 8) {
            this.measureChild(view, n2, n3);
            n4 = view.getMeasuredWidth();
            n5 = view.getMeasuredHeight();
        } else if (adSize != null) {
            view = this.getContext();
            n4 = adSize.getWidthInPixels((Context)view);
            n5 = adSize.getHeightInPixels((Context)view);
        } else {
            n4 = 0;
        }
        n4 = Math.max(n4, this.getSuggestedMinimumWidth());
        n5 = Math.max(n5, this.getSuggestedMinimumHeight());
        this.setMeasuredDimension(View.resolveSize((int)n4, (int)n2), View.resolveSize((int)n5, (int)n3));
    }

    public void pause() {
        this.dZ.pause();
    }

    public void recordManualImpression() {
        this.dZ.recordManualImpression();
    }

    public void resume() {
        this.dZ.resume();
    }

    public void setAdListener(AdListener adListener) {
        this.dZ.setAdListener(adListener);
    }

    public void setAdSizes(AdSize ... adSizeArray) {
        if (adSizeArray == null) throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
        if (adSizeArray.length < 1) {
            throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
        }
        this.dZ.a(adSizeArray);
    }

    public void setAdUnitId(String string) {
        this.dZ.setAdUnitId(string);
    }

    public void setAppEventListener(AppEventListener appEventListener) {
        this.dZ.setAppEventListener(appEventListener);
    }
}

