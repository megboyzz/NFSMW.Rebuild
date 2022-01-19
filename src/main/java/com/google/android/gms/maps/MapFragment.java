/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Fragment
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.os.RemoteException
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 */
package com.google.android.gms.maps;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
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

public class MapFragment
extends Fragment {
    private final b xP = new b(this);
    private GoogleMap xQ;

    public static MapFragment newInstance() {
        return new MapFragment();
    }

    public static MapFragment newInstance(GoogleMapOptions googleMapOptions) {
        MapFragment mapFragment = new MapFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", (Parcelable)googleMapOptions);
        mapFragment.setArguments(bundle);
        return mapFragment;
    }

    protected IMapFragmentDelegate ea() {
        this.xP.eb();
        if (this.xP.cG() != null) return ((a)this.xP.cG()).ea();
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
            bundle.setClassLoader(MapFragment.class.getClassLoader());
        }
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.xP.setActivity(activity);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.xP.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.xP.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onDestroy() {
        this.xP.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.xP.onDestroyView();
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet object, Bundle bundle) {
        super.onInflate(activity, (AttributeSet)object, bundle);
        this.xP.setActivity(activity);
        object = GoogleMapOptions.createFromAttributes((Context)activity, (AttributeSet)object);
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("MapOptions", (Parcelable)object);
        this.xP.onInflate(activity, bundle2, bundle);
    }

    public void onLowMemory() {
        this.xP.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.xP.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.xP.onResume();
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MapFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(bundle);
        this.xP.onSaveInstanceState(bundle);
    }

    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
    }

    static class a
    implements LifecycleDelegate {
        private final Fragment xR;
        private final IMapFragmentDelegate xS;

        public a(Fragment fragment, IMapFragmentDelegate iMapFragmentDelegate) {
            this.xS = du.f(iMapFragmentDelegate);
            this.xR = du.f(fragment);
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

                if ((var1_1 = this.xR.getArguments()) != null && var1_1.containsKey("MapOptions")) {
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
        private final Fragment xR;
        protected d<a> xT;

        b(Fragment fragment) {
            this.xR = fragment;
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
                this.xT.a(new a(this.xR, iMapFragmentDelegate));
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

