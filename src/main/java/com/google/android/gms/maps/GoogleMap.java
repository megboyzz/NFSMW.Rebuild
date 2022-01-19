/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.location.Location
 *  android.os.RemoteException
 *  android.view.View
 */
package com.google.android.gms.maps;

import android.graphics.Bitmap;
import android.location.Location;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.internal.du;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.LocationSource;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.ILocationSourceDelegate;
import com.google.android.gms.maps.internal.b;
import com.google.android.gms.maps.internal.d;
import com.google.android.gms.maps.internal.e;
import com.google.android.gms.maps.internal.f;
import com.google.android.gms.maps.internal.g;
import com.google.android.gms.maps.internal.h;
import com.google.android.gms.maps.internal.i;
import com.google.android.gms.maps.internal.j;
import com.google.android.gms.maps.internal.k;
import com.google.android.gms.maps.internal.l;
import com.google.android.gms.maps.internal.m;
import com.google.android.gms.maps.internal.n;
import com.google.android.gms.maps.internal.o;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.internal.c;
import com.google.android.gms.maps.model.internal.d;
import com.google.android.gms.maps.model.internal.f;

public final class GoogleMap {
    public static final int MAP_TYPE_HYBRID = 4;
    public static final int MAP_TYPE_NONE = 0;
    public static final int MAP_TYPE_NORMAL = 1;
    public static final int MAP_TYPE_SATELLITE = 2;
    public static final int MAP_TYPE_TERRAIN = 3;
    private final IGoogleMapDelegate xn;
    private UiSettings xo;

    protected GoogleMap(IGoogleMapDelegate iGoogleMapDelegate) {
        this.xn = du.f(iGoogleMapDelegate);
    }

    public final Circle addCircle(CircleOptions object) {
        try {
            return new Circle(this.xn.addCircle((CircleOptions)object));
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public final GroundOverlay addGroundOverlay(GroundOverlayOptions object) {
        try {
            object = this.xn.addGroundOverlay((GroundOverlayOptions)object);
            if (object == null) return null;
            return new GroundOverlay((c)object);
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public final Marker addMarker(MarkerOptions object) {
        try {
            object = this.xn.addMarker((MarkerOptions)object);
            if (object == null) return null;
            return new Marker((d)object);
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public final Polygon addPolygon(PolygonOptions object) {
        try {
            return new Polygon(this.xn.addPolygon((PolygonOptions)object));
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public final Polyline addPolyline(PolylineOptions object) {
        try {
            return new Polyline(this.xn.addPolyline((PolylineOptions)object));
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public final TileOverlay addTileOverlay(TileOverlayOptions object) {
        try {
            object = this.xn.addTileOverlay((TileOverlayOptions)object);
            if (object == null) return null;
            return new TileOverlay((f)object);
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public final void animateCamera(CameraUpdate cameraUpdate) {
        try {
            this.xn.animateCamera(cameraUpdate.dP());
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public final void animateCamera(CameraUpdate object, int n2, CancelableCallback cancelableCallback) {
        try {
            IGoogleMapDelegate iGoogleMapDelegate = this.xn;
            com.google.android.gms.dynamic.b b2 = ((CameraUpdate)object).dP();
            object = cancelableCallback == null ? null : new a(cancelableCallback);
            iGoogleMapDelegate.animateCameraWithDurationAndCallback(b2, n2, (b)object);
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public final void animateCamera(CameraUpdate object, CancelableCallback cancelableCallback) {
        try {
            IGoogleMapDelegate iGoogleMapDelegate = this.xn;
            com.google.android.gms.dynamic.b b2 = ((CameraUpdate)object).dP();
            object = cancelableCallback == null ? null : new a(cancelableCallback);
            iGoogleMapDelegate.animateCameraWithCallback(b2, (b)object);
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public final void clear() {
        try {
            this.xn.clear();
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    IGoogleMapDelegate dR() {
        return this.xn;
    }

    public final CameraPosition getCameraPosition() {
        try {
            return this.xn.getCameraPosition();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public final int getMapType() {
        try {
            return this.xn.getMapType();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public final float getMaxZoomLevel() {
        try {
            return this.xn.getMaxZoomLevel();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public final float getMinZoomLevel() {
        try {
            return this.xn.getMinZoomLevel();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    @Deprecated
    public final Location getMyLocation() {
        try {
            return this.xn.getMyLocation();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public final Projection getProjection() {
        try {
            return new Projection(this.xn.getProjection());
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public final UiSettings getUiSettings() {
        try {
            if (this.xo != null) return this.xo;
            this.xo = new UiSettings(this.xn.getUiSettings());
            return this.xo;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public final boolean isBuildingsEnabled() {
        try {
            return this.xn.isBuildingsEnabled();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public final boolean isIndoorEnabled() {
        try {
            return this.xn.isIndoorEnabled();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public final boolean isMyLocationEnabled() {
        try {
            return this.xn.isMyLocationEnabled();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public final boolean isTrafficEnabled() {
        try {
            return this.xn.isTrafficEnabled();
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public final void moveCamera(CameraUpdate cameraUpdate) {
        try {
            this.xn.moveCamera(cameraUpdate.dP());
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public final void setBuildingsEnabled(boolean bl2) {
        try {
            this.xn.setBuildingsEnabled(bl2);
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public final boolean setIndoorEnabled(boolean bl2) {
        try {
            return this.xn.setIndoorEnabled(bl2);
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    /*
     * Unable to fully structure code
     */
    public final void setInfoWindowAdapter(final InfoWindowAdapter var1_1) {
        if (var1_1 != null) ** GOTO lbl5
        try {
            this.xn.setInfoWindowAdapter(null);
            return;
lbl5:
            // 1 sources

            this.xn.setInfoWindowAdapter(new d.a(){

                @Override
                public com.google.android.gms.dynamic.b f(d d2) {
                    return com.google.android.gms.dynamic.c.h(var1_1.getInfoWindow(new Marker(d2)));
                }

                @Override
                public com.google.android.gms.dynamic.b g(d d2) {
                    return com.google.android.gms.dynamic.c.h(var1_1.getInfoContents(new Marker(d2)));
                }
            });
            return;
        }
        catch (RemoteException var1_2) {
            throw new RuntimeRemoteException(var1_2);
        }
    }

    /*
     * Unable to fully structure code
     */
    public final void setLocationSource(final LocationSource var1_1) {
        if (var1_1 != null) ** GOTO lbl5
        try {
            this.xn.setLocationSource(null);
            return;
lbl5:
            // 1 sources

            this.xn.setLocationSource(new ILocationSourceDelegate.a(){

                @Override
                public void activate(final g g2) {
                    var1_1.activate(new LocationSource.OnLocationChangedListener(){

                        @Override
                        public void onLocationChanged(Location location) {
                            try {
                                g2.g(com.google.android.gms.dynamic.c.h(location));
                                return;
                            }
                            catch (RemoteException remoteException) {
                                throw new RuntimeRemoteException(remoteException);
                            }
                        }
                    });
                }

                @Override
                public void deactivate() {
                    var1_1.deactivate();
                }
            });
            return;
        }
        catch (RemoteException var1_2) {
            throw new RuntimeRemoteException(var1_2);
        }
    }

    public final void setMapType(int n2) {
        try {
            this.xn.setMapType(n2);
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public final void setMyLocationEnabled(boolean bl2) {
        try {
            this.xn.setMyLocationEnabled(bl2);
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    /*
     * Unable to fully structure code
     */
    public final void setOnCameraChangeListener(final OnCameraChangeListener var1_1) {
        if (var1_1 != null) ** GOTO lbl5
        try {
            this.xn.setOnCameraChangeListener(null);
            return;
lbl5:
            // 1 sources

            this.xn.setOnCameraChangeListener(new e.a(){

                @Override
                public void onCameraChange(CameraPosition cameraPosition) {
                    var1_1.onCameraChange(cameraPosition);
                }
            });
            return;
        }
        catch (RemoteException var1_2) {
            throw new RuntimeRemoteException(var1_2);
        }
    }

    /*
     * Unable to fully structure code
     */
    public final void setOnInfoWindowClickListener(final OnInfoWindowClickListener var1_1) {
        if (var1_1 != null) ** GOTO lbl5
        try {
            this.xn.setOnInfoWindowClickListener(null);
            return;
lbl5:
            // 1 sources

            this.xn.setOnInfoWindowClickListener(new f.a(){

                @Override
                public void e(d d2) {
                    var1_1.onInfoWindowClick(new Marker(d2));
                }
            });
            return;
        }
        catch (RemoteException var1_2) {
            throw new RuntimeRemoteException(var1_2);
        }
    }

    /*
     * Unable to fully structure code
     */
    public final void setOnMapClickListener(final OnMapClickListener var1_1) {
        if (var1_1 != null) ** GOTO lbl5
        try {
            this.xn.setOnMapClickListener(null);
            return;
lbl5:
            // 1 sources

            this.xn.setOnMapClickListener(new h.a(){

                @Override
                public void onMapClick(LatLng latLng) {
                    var1_1.onMapClick(latLng);
                }
            });
            return;
        }
        catch (RemoteException var1_2) {
            throw new RuntimeRemoteException(var1_2);
        }
    }

    /*
     * Unable to fully structure code
     */
    public void setOnMapLoadedCallback(final OnMapLoadedCallback var1_1) {
        if (var1_1 != null) ** GOTO lbl5
        try {
            this.xn.setOnMapLoadedCallback(null);
            return;
lbl5:
            // 1 sources

            this.xn.setOnMapLoadedCallback(new i.a(){

                @Override
                public void onMapLoaded() throws RemoteException {
                    var1_1.onMapLoaded();
                }
            });
            return;
        }
        catch (RemoteException var1_2) {
            throw new RuntimeRemoteException(var1_2);
        }
    }

    /*
     * Unable to fully structure code
     */
    public final void setOnMapLongClickListener(final OnMapLongClickListener var1_1) {
        if (var1_1 != null) ** GOTO lbl5
        try {
            this.xn.setOnMapLongClickListener(null);
            return;
lbl5:
            // 1 sources

            this.xn.setOnMapLongClickListener(new j.a(){

                @Override
                public void onMapLongClick(LatLng latLng) {
                    var1_1.onMapLongClick(latLng);
                }
            });
            return;
        }
        catch (RemoteException var1_2) {
            throw new RuntimeRemoteException(var1_2);
        }
    }

    /*
     * Unable to fully structure code
     */
    public final void setOnMarkerClickListener(final OnMarkerClickListener var1_1) {
        if (var1_1 != null) ** GOTO lbl5
        try {
            this.xn.setOnMarkerClickListener(null);
            return;
lbl5:
            // 1 sources

            this.xn.setOnMarkerClickListener(new k.a(){

                @Override
                public boolean a(d d2) {
                    return var1_1.onMarkerClick(new Marker(d2));
                }
            });
            return;
        }
        catch (RemoteException var1_2) {
            throw new RuntimeRemoteException(var1_2);
        }
    }

    /*
     * Unable to fully structure code
     */
    public final void setOnMarkerDragListener(final OnMarkerDragListener var1_1) {
        if (var1_1 != null) ** GOTO lbl5
        try {
            this.xn.setOnMarkerDragListener(null);
            return;
lbl5:
            // 1 sources

            this.xn.setOnMarkerDragListener(new l.a(){

                @Override
                public void b(d d2) {
                    var1_1.onMarkerDragStart(new Marker(d2));
                }

                @Override
                public void c(d d2) {
                    var1_1.onMarkerDragEnd(new Marker(d2));
                }

                @Override
                public void d(d d2) {
                    var1_1.onMarkerDrag(new Marker(d2));
                }
            });
            return;
        }
        catch (RemoteException var1_2) {
            throw new RuntimeRemoteException(var1_2);
        }
    }

    /*
     * Unable to fully structure code
     */
    public final void setOnMyLocationButtonClickListener(final OnMyLocationButtonClickListener var1_1) {
        if (var1_1 != null) ** GOTO lbl5
        try {
            this.xn.setOnMyLocationButtonClickListener(null);
            return;
lbl5:
            // 1 sources

            this.xn.setOnMyLocationButtonClickListener(new m.a(){

                @Override
                public boolean onMyLocationButtonClick() throws RemoteException {
                    return var1_1.onMyLocationButtonClick();
                }
            });
            return;
        }
        catch (RemoteException var1_2) {
            throw new RuntimeRemoteException(var1_2);
        }
    }

    /*
     * Unable to fully structure code
     */
    @Deprecated
    public final void setOnMyLocationChangeListener(final OnMyLocationChangeListener var1_1) {
        if (var1_1 != null) ** GOTO lbl5
        try {
            this.xn.setOnMyLocationChangeListener(null);
            return;
lbl5:
            // 1 sources

            this.xn.setOnMyLocationChangeListener(new n.a(){

                @Override
                public void d(com.google.android.gms.dynamic.b b2) {
                    var1_1.onMyLocationChange((Location)com.google.android.gms.dynamic.c.b(b2));
                }
            });
            return;
        }
        catch (RemoteException var1_2) {
            throw new RuntimeRemoteException(var1_2);
        }
    }

    public final void setPadding(int n2, int n3, int n4, int n5) {
        try {
            this.xn.setPadding(n2, n3, n4, n5);
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public final void setTrafficEnabled(boolean bl2) {
        try {
            this.xn.setTrafficEnabled(bl2);
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public final void snapshot(SnapshotReadyCallback snapshotReadyCallback) {
        this.snapshot(snapshotReadyCallback, null);
    }

    public final void snapshot(final SnapshotReadyCallback snapshotReadyCallback, Bitmap object) {
        object = object != null ? com.google.android.gms.dynamic.c.h(object) : null;
        object = (com.google.android.gms.dynamic.c)object;
        try {
            this.xn.snapshot(new o.a(){

                @Override
                public void c(com.google.android.gms.dynamic.b b2) throws RemoteException {
                    snapshotReadyCallback.onSnapshotReady((Bitmap)com.google.android.gms.dynamic.c.b(b2));
                }

                @Override
                public void onSnapshotReady(Bitmap bitmap) throws RemoteException {
                    snapshotReadyCallback.onSnapshotReady(bitmap);
                }
            }, (com.google.android.gms.dynamic.b)object);
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public final void stopAnimation() {
        try {
            this.xn.stopAnimation();
            return;
        }
        catch (RemoteException remoteException) {
            throw new RuntimeRemoteException(remoteException);
        }
    }

    public static interface CancelableCallback {
        public void onCancel();

        public void onFinish();
    }

    public static interface InfoWindowAdapter {
        public View getInfoContents(Marker var1);

        public View getInfoWindow(Marker var1);
    }

    public static interface OnCameraChangeListener {
        public void onCameraChange(CameraPosition var1);
    }

    public static interface OnInfoWindowClickListener {
        public void onInfoWindowClick(Marker var1);
    }

    public static interface OnMapClickListener {
        public void onMapClick(LatLng var1);
    }

    public static interface OnMapLoadedCallback {
        public void onMapLoaded();
    }

    public static interface OnMapLongClickListener {
        public void onMapLongClick(LatLng var1);
    }

    public static interface OnMarkerClickListener {
        public boolean onMarkerClick(Marker var1);
    }

    public static interface OnMarkerDragListener {
        public void onMarkerDrag(Marker var1);

        public void onMarkerDragEnd(Marker var1);

        public void onMarkerDragStart(Marker var1);
    }

    public static interface OnMyLocationButtonClickListener {
        public boolean onMyLocationButtonClick();
    }

    @Deprecated
    public static interface OnMyLocationChangeListener {
        public void onMyLocationChange(Location var1);
    }

    public static interface SnapshotReadyCallback {
        public void onSnapshotReady(Bitmap var1);
    }

    private static final class a
    extends b.a {
        private final CancelableCallback xE;

        a(CancelableCallback cancelableCallback) {
            this.xE = cancelableCallback;
        }

        @Override
        public void onCancel() {
            this.xE.onCancel();
        }

        @Override
        public void onFinish() {
            this.xE.onFinish();
        }
    }
}

