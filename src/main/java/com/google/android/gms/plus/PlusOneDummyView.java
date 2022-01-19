/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.res.Resources
 *  android.graphics.Point
 *  android.graphics.drawable.Drawable
 *  android.util.DisplayMetrics
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.Button
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 */
package com.google.android.gms.plus;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

public class PlusOneDummyView
extends FrameLayout {
    public static final String TAG = "PlusOneDummyView";

    public PlusOneDummyView(Context context, int n2) {
        super(context);
        context = new Button(context);
        context.setEnabled(false);
        context.setBackgroundDrawable(this.es().getDrawable(n2));
        Point point = this.aP(n2);
        this.addView((View)context, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(point.x, point.y, 17));
    }

    private Point aP(int n2) {
        int n3 = 24;
        int n4 = 20;
        Point point = new Point();
        switch (n2) {
            default: {
                n2 = 38;
                n4 = 24;
                break;
            }
            case 1: {
                n2 = 32;
                break;
            }
            case 0: {
                n4 = 14;
                n2 = n3;
                break;
            }
            case 2: {
                n2 = 50;
            }
        }
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        float f2 = TypedValue.applyDimension((int)1, (float)n2, (DisplayMetrics)displayMetrics);
        float f3 = TypedValue.applyDimension((int)1, (float)n4, (DisplayMetrics)displayMetrics);
        point.x = (int)((double)f2 + 0.5);
        point.y = (int)((double)f3 + 0.5);
        return point;
    }

    private d es() {
        d d2;
        d d3 = d2 = new b(this.getContext());
        if (!d2.isValid()) {
            d3 = new c(this.getContext());
        }
        d2 = d3;
        if (d3.isValid()) return d2;
        return new a(this.getContext());
    }

    private static class a
    implements d {
        private Context mContext;

        private a(Context context) {
            this.mContext = context;
        }

        @Override
        public Drawable getDrawable(int n2) {
            return this.mContext.getResources().getDrawable(17301508);
        }

        @Override
        public boolean isValid() {
            return true;
        }
    }

    private static class b
    implements d {
        private Context mContext;

        private b(Context context) {
            this.mContext = context;
        }

        /*
         * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
         */
        @Override
        public Drawable getDrawable(int n2) {
            String string2;
            Resources resources;
            try {
                resources = this.mContext.createPackageContext("com.google.android.gms", 4).getResources();
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                return null;
            }
            switch (n2) {
                case 2: {
                    string2 = "ic_plusone_tall";
                    return resources.getDrawable(resources.getIdentifier(string2, "drawable", "com.google.android.gms"));
                }
                default: {
                    string2 = "ic_plusone_standard";
                    return resources.getDrawable(resources.getIdentifier(string2, "drawable", "com.google.android.gms"));
                }
                case 0: {
                    string2 = "ic_plusone_small";
                    return resources.getDrawable(resources.getIdentifier(string2, "drawable", "com.google.android.gms"));
                }
                case 1: 
            }
            string2 = "ic_plusone_medium";
            return resources.getDrawable(resources.getIdentifier(string2, "drawable", "com.google.android.gms"));
        }

        @Override
        public boolean isValid() {
            try {
                this.mContext.createPackageContext("com.google.android.gms", 4).getResources();
                return true;
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                return false;
            }
        }
    }

    private static class c
    implements d {
        private Context mContext;

        private c(Context context) {
            this.mContext = context;
        }

        @Override
        public Drawable getDrawable(int n2) {
            String string2;
            switch (n2) {
                default: {
                    string2 = "ic_plusone_standard_off_client";
                    break;
                }
                case 0: {
                    string2 = "ic_plusone_small_off_client";
                    break;
                }
                case 1: {
                    string2 = "ic_plusone_medium_off_client";
                    break;
                }
                case 2: {
                    string2 = "ic_plusone_tall_off_client";
                }
            }
            n2 = this.mContext.getResources().getIdentifier(string2, "drawable", this.mContext.getPackageName());
            return this.mContext.getResources().getDrawable(n2);
        }

        @Override
        public boolean isValid() {
            int n2 = this.mContext.getResources().getIdentifier("ic_plusone_small_off_client", "drawable", this.mContext.getPackageName());
            int n3 = this.mContext.getResources().getIdentifier("ic_plusone_medium_off_client", "drawable", this.mContext.getPackageName());
            int n4 = this.mContext.getResources().getIdentifier("ic_plusone_tall_off_client", "drawable", this.mContext.getPackageName());
            int n5 = this.mContext.getResources().getIdentifier("ic_plusone_standard_off_client", "drawable", this.mContext.getPackageName());
            if (n2 == 0) return false;
            if (n3 == 0) return false;
            if (n4 == 0) return false;
            if (n5 == 0) return false;
            return true;
        }
    }

    private static interface d {
        public Drawable getDrawable(int var1);

        public boolean isValid();
    }
}

