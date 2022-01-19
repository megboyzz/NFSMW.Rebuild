/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Bundle
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.Button
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.d;
import java.util.LinkedList;

public abstract class a<T extends LifecycleDelegate> {
    private T pG;
    private Bundle pH;
    private LinkedList<a> pI;
    private final d<T> pJ = new d<T>(){

        @Override
        public void a(T object) {
            a.a(a.this, object);
            object = a.this.pI.iterator();
            while (true) {
                if (!object.hasNext()) {
                    a.this.pI.clear();
                    a.a(a.this, null);
                    return;
                }
                ((a)object.next()).b(a.this.pG);
            }
        }
    };

    static /* synthetic */ Bundle a(a a2, Bundle bundle) {
        a2.pH = bundle;
        return bundle;
    }

    static /* synthetic */ LifecycleDelegate a(a a2, LifecycleDelegate lifecycleDelegate) {
        a2.pG = lifecycleDelegate;
        return lifecycleDelegate;
    }

    private void a(Bundle bundle, a a2) {
        if (this.pG != null) {
            a2.b((LifecycleDelegate)this.pG);
            return;
        }
        if (this.pI == null) {
            this.pI = new LinkedList();
        }
        this.pI.add(a2);
        if (bundle != null) {
            if (this.pH == null) {
                this.pH = (Bundle)bundle.clone();
            } else {
                this.pH.putAll(bundle);
            }
        }
        this.a(this.pJ);
    }

    private void al(int n2) {
        while (!this.pI.isEmpty()) {
            if (this.pI.getLast().getState() < n2) return;
            this.pI.removeLast();
        }
    }

    public void a(FrameLayout frameLayout) {
        final Context context = frameLayout.getContext();
        final int n2 = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        String string2 = GooglePlayServicesUtil.b(context, n2, -1);
        String string3 = GooglePlayServicesUtil.b(context, n2);
        LinearLayout linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView((View)linearLayout);
        frameLayout = new TextView(frameLayout.getContext());
        frameLayout.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2));
        frameLayout.setText((CharSequence)string2);
        linearLayout.addView((View)frameLayout);
        if (string3 == null) return;
        frameLayout = new Button(context);
        frameLayout.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2));
        frameLayout.setText((CharSequence)string3);
        linearLayout.addView((View)frameLayout);
        frameLayout.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                context.startActivity(GooglePlayServicesUtil.a(context, n2, -1));
            }
        });
    }

    protected abstract void a(d<T> var1);

    public T cG() {
        return this.pG;
    }

    public void onCreate(final Bundle bundle) {
        this.a(bundle, new a(){

            @Override
            public void b(LifecycleDelegate lifecycleDelegate) {
                a.this.pG.onCreate(bundle);
            }

            @Override
            public int getState() {
                return 1;
            }
        });
    }

    public View onCreateView(final LayoutInflater layoutInflater, final ViewGroup viewGroup, final Bundle bundle) {
        final FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        this.a(bundle, new a(){

            @Override
            public void b(LifecycleDelegate lifecycleDelegate) {
                frameLayout.removeAllViews();
                frameLayout.addView(a.this.pG.onCreateView(layoutInflater, viewGroup, bundle));
            }

            @Override
            public int getState() {
                return 2;
            }
        });
        if (this.pG != null) return frameLayout;
        this.a(frameLayout);
        return frameLayout;
    }

    public void onDestroy() {
        if (this.pG != null) {
            this.pG.onDestroy();
            return;
        }
        this.al(1);
    }

    public void onDestroyView() {
        if (this.pG != null) {
            this.pG.onDestroyView();
            return;
        }
        this.al(2);
    }

    public void onInflate(final Activity activity, final Bundle bundle, final Bundle bundle2) {
        this.a(bundle2, new a(){

            @Override
            public void b(LifecycleDelegate lifecycleDelegate) {
                a.this.pG.onInflate(activity, bundle, bundle2);
            }

            @Override
            public int getState() {
                return 0;
            }
        });
    }

    public void onLowMemory() {
        if (this.pG == null) return;
        this.pG.onLowMemory();
    }

    public void onPause() {
        if (this.pG != null) {
            this.pG.onPause();
            return;
        }
        this.al(3);
    }

    public void onResume() {
        this.a(null, new a(){

            @Override
            public void b(LifecycleDelegate lifecycleDelegate) {
                a.this.pG.onResume();
            }

            @Override
            public int getState() {
                return 3;
            }
        });
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.pG != null) {
            this.pG.onSaveInstanceState(bundle);
            return;
        }
        if (this.pH == null) return;
        bundle.putAll(this.pH);
    }

    private static interface a {
        public void b(LifecycleDelegate var1);

        public int getState();
    }
}

