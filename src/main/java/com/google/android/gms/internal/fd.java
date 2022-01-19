/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Binder
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.view.Display
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 */
package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.gms.internal.es;
import com.google.android.gms.internal.ex;
import com.google.android.gms.internal.fa;
import java.lang.ref.WeakReference;

public class fd {
    protected ex qm;
    protected a rG;

    private fd(ex ex2, int n2) {
        this.qm = ex2;
        this.as(n2);
    }

    public static fd a(ex ex2, int n2) {
        if (!es.cl()) return new fd(ex2, n2);
        return new b(ex2, n2);
    }

    protected void as(int n2) {
        this.rG = new a(n2, (IBinder)new Binder());
    }

    public void cZ() {
        this.qm.a(this.rG.rH, this.rG.dc());
    }

    public Bundle da() {
        return this.rG.dc();
    }

    public IBinder db() {
        return this.rG.rH;
    }

    public void e(View view) {
    }

    public void setGravity(int n2) {
        this.rG.gravity = n2;
    }

    public static final class a {
        public int bottom = 0;
        public int gravity;
        public int left = 0;
        public IBinder rH;
        public int rI = -1;
        public int right = 0;
        public int top = 0;

        private a(int n2, IBinder iBinder) {
            this.gravity = n2;
            this.rH = iBinder;
        }

        public Bundle dc() {
            Bundle bundle = new Bundle();
            bundle.putInt("popupLocationInfo.gravity", this.gravity);
            bundle.putInt("popupLocationInfo.displayId", this.rI);
            bundle.putInt("popupLocationInfo.left", this.left);
            bundle.putInt("popupLocationInfo.top", this.top);
            bundle.putInt("popupLocationInfo.right", this.right);
            bundle.putInt("popupLocationInfo.bottom", this.bottom);
            return bundle;
        }
    }

    private static final class b
    extends fd
    implements View.OnAttachStateChangeListener,
    ViewTreeObserver.OnGlobalLayoutListener {
        private boolean qR = false;
        private WeakReference<View> rJ;

        protected b(ex ex2, int n2) {
            super(ex2, n2);
        }

        private void f(View view) {
            Display display;
            int n2;
            int n3 = n2 = -1;
            if (es.cp()) {
                display = view.getDisplay();
                n3 = n2;
                if (display != null) {
                    n3 = display.getDisplayId();
                }
            }
            display = view.getWindowToken();
            int[] nArray = new int[2];
            view.getLocationInWindow(nArray);
            n2 = view.getWidth();
            int n4 = view.getHeight();
            this.rG.rI = n3;
            this.rG.rH = display;
            this.rG.left = nArray[0];
            this.rG.top = nArray[1];
            this.rG.right = nArray[0] + n2;
            this.rG.bottom = nArray[1] + n4;
            if (!this.qR) return;
            this.cZ();
            this.qR = false;
        }

        @Override
        protected void as(int n2) {
            this.rG = new a(n2, null);
        }

        @Override
        public void cZ() {
            if (this.rG.rH != null) {
                super.cZ();
                return;
            }
            boolean bl2 = this.rJ != null;
            this.qR = bl2;
        }

        @Override
        public void e(View view) {
            View view2;
            View view3;
            this.qm.cN();
            if (this.rJ != null) {
                view3 = (View)this.rJ.get();
                Context context = this.qm.getContext();
                view2 = view3;
                if (view3 == null) {
                    view2 = view3;
                    if (context instanceof Activity) {
                        view2 = ((Activity)context).getWindow().getDecorView();
                    }
                }
                if (view2 != null) {
                    view2.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
                    view2 = view2.getViewTreeObserver();
                    if (es.co()) {
                        view2.removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
                    } else {
                        view2.removeGlobalOnLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
                    }
                }
            }
            this.rJ = null;
            view3 = this.qm.getContext();
            view2 = view;
            if (view == null) {
                view2 = view;
                if (view3 instanceof Activity) {
                    view = view2 = ((Activity)view3).findViewById(0x1020002);
                    if (view2 == null) {
                        view = ((Activity)view3).getWindow().getDecorView();
                    }
                    fa.a("PopupManager", "You have not specified a View to use as content view for popups. Falling back to the Activity content view which may not work properly in future versions of the API. Use setViewForPopups() to set your content view.");
                    view2 = view;
                }
            }
            if (view2 != null) {
                this.f(view2);
                this.rJ = new WeakReference<View>(view2);
                view2.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
                view2.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
                return;
            }
            fa.b("PopupManager", "No content view usable to display popups. Popups will not be displayed in response to this client's calls. Use setViewForPopups() to set your content view.");
        }

        public void onGlobalLayout() {
            if (this.rJ == null) {
                return;
            }
            View view = (View)this.rJ.get();
            if (view == null) return;
            this.f(view);
        }

        public void onViewAttachedToWindow(View view) {
            this.f(view);
        }

        public void onViewDetachedFromWindow(View view) {
            this.qm.cN();
            view.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
        }
    }
}

