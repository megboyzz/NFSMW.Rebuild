/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.RemoteException
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 */
package com.google.android.gms.maps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.c;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.internal.du;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.internal.q;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class MapView
extends FrameLayout {
    private GoogleMap xQ;
    private final b xU;

    public MapView(Context context) {
        super(context);
        this.xU = new b((ViewGroup)this, context, null);
    }

    public MapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.xU = new b((ViewGroup)this, context, GoogleMapOptions.createFromAttributes(context, attributeSet));
    }

    public MapView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.xU = new b((ViewGroup)this, context, GoogleMapOptions.createFromAttributes(context, attributeSet));
    }

    public MapView(Context context, GoogleMapOptions googleMapOptions) {
        super(context);
        this.xU = new b((ViewGroup)this, context, googleMapOptions);
    }

    public final GoogleMap getMap() {
        if (this.xQ != null) {
            return this.xQ;
        }
        this.xU.eb();
        if (this.xU.cG() == null) {
            return null;
        }
        try {
            this.xQ = new GoogleMap(((a)this.xU.cG()).ec().getMap());
            return this.xQ;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public final void onCreate(Bundle bundle) {
        this.xU.onCreate(bundle);
        if (this.xU.cG() != null) return;
        this.xU.a(this);
    }

    public final void onDestroy() {
        this.xU.onDestroy();
    }

    public final void onLowMemory() {
        this.xU.onLowMemory();
    }

    public final void onPause() {
        this.xU.onPause();
    }

    public final void onResume() {
        this.xU.onResume();
    }

    public final void onSaveInstanceState(Bundle bundle) {
        this.xU.onSaveInstanceState(bundle);
    }

    static class a
    implements LifecycleDelegate {
        private final ViewGroup xV;
        private final IMapViewDelegate xW;
        private View xX;

        public a(ViewGroup viewGroup, IMapViewDelegate iMapViewDelegate) {
            this.xW = du.f(iMapViewDelegate);
            this.xV = du.f(viewGroup);
        }

        public IMapViewDelegate ec() {
            return this.xW;
        }

        @Override
        public void onCreate(Bundle bundle) {
            try {
                this.xW.onCreate(bundle);
                this.xX = (View)c.b(this.xW.getView());
                this.xV.removeAllViews();
                this.xV.addView(this.xX);
                return;
            }
            catch (RemoteException remoteException) {
                throw new RuntimeRemoteException(remoteException);
            }
        }

        @Override
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            throw new UnsupportedOperationException("onCreateView not allowed on MapViewDelegate");
        }

        @Override
        public void onDestroy() {
            try {
                this.xW.onDestroy();
                return;
            }
            catch (RemoteException remoteException) {
                throw new RuntimeRemoteException(remoteException);
            }
        }

        @Override
        public void onDestroyView() {
            throw new UnsupportedOperationException("onDestroyView not allowed on MapViewDelegate");
        }

        @Override
        public void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
            throw new UnsupportedOperationException("onInflate not allowed on MapViewDelegate");
        }

        @Override
        public void onLowMemory() {
            try {
                this.xW.onLowMemory();
                return;
            }
            catch (RemoteException remoteException) {
                throw new RuntimeRemoteException(remoteException);
            }
        }

        @Override
        public void onPause() {
            try {
                this.xW.onPause();
                return;
            }
            catch (RemoteException remoteException) {
                throw new RuntimeRemoteException(remoteException);
            }
        }

        @Override
        public void onResume() {
            try {
                this.xW.onResume();
                return;
            }
            catch (RemoteException remoteException) {
                throw new RuntimeRemoteException(remoteException);
            }
        }

        @Override
        public void onSaveInstanceState(Bundle bundle) {
            try {
                this.xW.onSaveInstanceState(bundle);
                return;
            }
            catch (RemoteException remoteException) {
                throw new RuntimeRemoteException(remoteException);
            }
        }
    }

    static class b
    extends com.google.android.gms.dynamic.a<a> {
        private final Context mContext;
        protected d<a> xT;
        private final ViewGroup xY;
        private final GoogleMapOptions xZ;

        b(ViewGroup viewGroup, Context context, GoogleMapOptions googleMapOptions) {
            this.xY = viewGroup;
            this.mContext = context;
            this.xZ = googleMapOptions;
        }

        @Override
        protected void a(d<a> d2) {
            this.xT = d2;
            this.eb();
        }

        public void eb() {
            if (this.xT == null) return;
            if (this.cG() != null) return;
            try {
                IMapViewDelegate iMapViewDelegate = q.u(this.mContext).a(c.h(this.mContext), this.xZ);
                this.xT.a(new a(this.xY, iMapViewDelegate));
                return;
            }
            catch (RemoteException remoteException) {
                throw new RuntimeRemoteException(remoteException);
            }
            catch (GooglePlayServicesNotAvailableException googlePlayServicesNotAvailableException) {
                return;
            }
        }
    }
}

