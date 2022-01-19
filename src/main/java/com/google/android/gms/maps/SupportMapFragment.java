/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.os.RemoteException
 *  android.support.v4.app.Fragment
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 */
package com.google.android.gms.maps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.c;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.internal.du;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.internal.p;
import com.google.android.gms.maps.internal.q;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class SupportMapFragment
extends Fragment {
    private GoogleMap xQ;
    private final b yb = new b(this);

    public static SupportMapFragment newInstance() {
        return new SupportMapFragment();
    }

    public static SupportMapFragment newInstance(GoogleMapOptions googleMapOptions) {
        SupportMapFragment supportMapFragment = new SupportMapFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", (Parcelable)googleMapOptions);
        supportMapFragment.setArguments(bundle);
        return supportMapFragment;
    }

    protected IMapFragmentDelegate ea() {
        this.yb.eb();
        if (this.yb.cG() != null) return ((a)this.yb.cG()).ea();
        return null;
    }

    public final GoogleMap getMap() {
        Object object;
        block3: {
            object = this.ea();
            if (object == null) {
                return null;
            }
            try {
                if ((object = object.getMap()) == null) return null;
                if (this.xQ == null) break block3;
            }
            catch (RemoteException remoteException) {
                throw new RuntimeRemoteException(remoteException);
            }
            if (this.xQ.dR().asBinder() == object.asBinder()) return this.xQ;
        }
        this.xQ = new GoogleMap((IGoogleMapDelegate)object);
        return this.xQ;
    }

    public void onActivityCreated(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(SupportMapFragment.class.getClassLoader());
        }
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.yb.setActivity(activity);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.yb.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.yb.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onDestroy() {
        this.yb.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.yb.onDestroyView();
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet object, Bundle bundle) {
        super.onInflate(activity, (AttributeSet)object, bundle);
        this.yb.setActivity(activity);
        object = GoogleMapOptions.createFromAttributes((Context)activity, (AttributeSet)object);
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("MapOptions", (Parcelable)object);
        this.yb.onInflate(activity, bundle2, bundle);
    }

    public void onLowMemory() {
        this.yb.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.yb.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.yb.onResume();
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(SupportMapFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(bundle);
        this.yb.onSaveInstanceState(bundle);
    }

    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
    }

    static class a
    implements LifecycleDelegate {
        private final IMapFragmentDelegate xS;
        private final Fragment yc;

        public a(Fragment fragment, IMapFragmentDelegate iMapFragmentDelegate) {
            this.xS = du.f(iMapFragmentDelegate);
            this.yc = du.f(fragment);
        }

        public IMapFragmentDelegate ea() {
            return this.xS;
        }

        /*
         * Unable to fully structure code
         */
        @Override
        public void onCreate(Bundle var1_1) {
            var2_3 = var1_1;
            if (var1_1 != null) ** GOTO lbl5
            try {
                var2_3 = new Bundle();
lbl5:
                // 2 sources

                if ((var1_1 = this.yc.getArguments()) != null && var1_1.containsKey("MapOptions")) {
                    p.a(var2_3, "MapOptions", var1_1.getParcelable("MapOptions"));
                }
                this.xS.onCreate(var2_3);
                return;
            }
            catch (RemoteException var1_2) {
                throw new RuntimeRemoteException(var1_2);
            }
        }

        @Override
        public View onCreateView(LayoutInflater object, ViewGroup viewGroup, Bundle bundle) {
            try {
                object = this.xS.onCreateView(c.h(object), c.h(viewGroup), bundle);
                return (View)c.b((com.google.android.gms.dynamic.b)object);
            }
            catch (RemoteException remoteException) {
                throw new RuntimeRemoteException(remoteException);
            }
        }

        @Override
        public void onDestroy() {
            try {
                this.xS.onDestroy();
                return;
            }
            catch (RemoteException remoteException) {
                throw new RuntimeRemoteException(remoteException);
            }
        }

        @Override
        public void onDestroyView() {
            try {
                this.xS.onDestroyView();
                return;
            }
            catch (RemoteException remoteException) {
                throw new RuntimeRemoteException(remoteException);
            }
        }

        @Override
        public void onInflate(Activity activity, Bundle object, Bundle bundle) {
            object = (GoogleMapOptions)object.getParcelable("MapOptions");
            try {
                this.xS.onInflate(c.h(activity), (GoogleMapOptions)object, bundle);
                return;
            }
            catch (RemoteException remoteException) {
                throw new RuntimeRemoteException(remoteException);
            }
        }

        @Override
        public void onLowMemory() {
            try {
                this.xS.onLowMemory();
                return;
            }
            catch (RemoteException remoteException) {
                throw new RuntimeRemoteException(remoteException);
            }
        }

        @Override
        public void onPause() {
            try {
                this.xS.onPause();
                return;
            }
            catch (RemoteException remoteException) {
                throw new RuntimeRemoteException(remoteException);
            }
        }

        @Override
        public void onResume() {
            try {
                this.xS.onResume();
                return;
            }
            catch (RemoteException remoteException) {
                throw new RuntimeRemoteException(remoteException);
            }
        }

        @Override
        public void onSaveInstanceState(Bundle bundle) {
            try {
                this.xS.onSaveInstanceState(bundle);
                return;
            }
            catch (RemoteException remoteException) {
                throw new RuntimeRemoteException(remoteException);
            }
        }
    }

    static class b
    extends com.google.android.gms.dynamic.a<a> {
        private Activity gr;
        protected d<a> xT;
        private final Fragment yc;

        b(Fragment fragment) {
            this.yc = fragment;
        }

        private void setActivity(Activity activity) {
            this.gr = activity;
            this.eb();
        }

        @Override
        protected void a(d<a> d2) {
            this.xT = d2;
            this.eb();
        }

        public void eb() {
            if (this.gr == null) return;
            if (this.xT == null) return;
            if (this.cG() != null) return;
            try {
                MapsInitializer.initialize((Context)this.gr);
                IMapFragmentDelegate iMapFragmentDelegate = q.u((Context)this.gr).f(c.h(this.gr));
                this.xT.a(new a(this.yc, iMapFragmentDelegate));
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

