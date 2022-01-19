/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.location.Location
 *  android.os.Binder
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 */
package com.google.android.gms.maps.internal;

import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.maps.internal.ILocationSourceDelegate;
import com.google.android.gms.maps.internal.IProjectionDelegate;
import com.google.android.gms.maps.internal.IUiSettingsDelegate;
import com.google.android.gms.maps.internal.b;
import com.google.android.gms.maps.internal.d;
import com.google.android.gms.maps.internal.e;
import com.google.android.gms.maps.internal.f;
import com.google.android.gms.maps.internal.h;
import com.google.android.gms.maps.internal.i;
import com.google.android.gms.maps.internal.j;
import com.google.android.gms.maps.internal.k;
import com.google.android.gms.maps.internal.l;
import com.google.android.gms.maps.internal.m;
import com.google.android.gms.maps.internal.n;
import com.google.android.gms.maps.internal.o;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.internal.IPolylineDelegate;
import com.google.android.gms.maps.model.internal.b;
import com.google.android.gms.maps.model.internal.c;
import com.google.android.gms.maps.model.internal.d;
import com.google.android.gms.maps.model.internal.e;
import com.google.android.gms.maps.model.internal.f;

public interface IGoogleMapDelegate
extends IInterface {
    public com.google.android.gms.maps.model.internal.b addCircle(CircleOptions var1) throws RemoteException;

    public c addGroundOverlay(GroundOverlayOptions var1) throws RemoteException;

    public com.google.android.gms.maps.model.internal.d addMarker(MarkerOptions var1) throws RemoteException;

    public com.google.android.gms.maps.model.internal.e addPolygon(PolygonOptions var1) throws RemoteException;

    public IPolylineDelegate addPolyline(PolylineOptions var1) throws RemoteException;

    public com.google.android.gms.maps.model.internal.f addTileOverlay(TileOverlayOptions var1) throws RemoteException;

    public void animateCamera(com.google.android.gms.dynamic.b var1) throws RemoteException;

    public void animateCameraWithCallback(com.google.android.gms.dynamic.b var1, b var2) throws RemoteException;

    public void animateCameraWithDurationAndCallback(com.google.android.gms.dynamic.b var1, int var2, b var3) throws RemoteException;

    public void clear() throws RemoteException;

    public CameraPosition getCameraPosition() throws RemoteException;

    public int getMapType() throws RemoteException;

    public float getMaxZoomLevel() throws RemoteException;

    public float getMinZoomLevel() throws RemoteException;

    public Location getMyLocation() throws RemoteException;

    public IProjectionDelegate getProjection() throws RemoteException;

    public com.google.android.gms.dynamic.b getTestingHelper() throws RemoteException;

    public IUiSettingsDelegate getUiSettings() throws RemoteException;

    public boolean isBuildingsEnabled() throws RemoteException;

    public boolean isIndoorEnabled() throws RemoteException;

    public boolean isMyLocationEnabled() throws RemoteException;

    public boolean isTrafficEnabled() throws RemoteException;

    public void moveCamera(com.google.android.gms.dynamic.b var1) throws RemoteException;

    public void setBuildingsEnabled(boolean var1) throws RemoteException;

    public boolean setIndoorEnabled(boolean var1) throws RemoteException;

    public void setInfoWindowAdapter(d var1) throws RemoteException;

    public void setLocationSource(ILocationSourceDelegate var1) throws RemoteException;

    public void setMapType(int var1) throws RemoteException;

    public void setMyLocationEnabled(boolean var1) throws RemoteException;

    public void setOnCameraChangeListener(e var1) throws RemoteException;

    public void setOnInfoWindowClickListener(f var1) throws RemoteException;

    public void setOnMapClickListener(h var1) throws RemoteException;

    public void setOnMapLoadedCallback(i var1) throws RemoteException;

    public void setOnMapLongClickListener(j var1) throws RemoteException;

    public void setOnMarkerClickListener(k var1) throws RemoteException;

    public void setOnMarkerDragListener(l var1) throws RemoteException;

    public void setOnMyLocationButtonClickListener(m var1) throws RemoteException;

    public void setOnMyLocationChangeListener(n var1) throws RemoteException;

    public void setPadding(int var1, int var2, int var3, int var4) throws RemoteException;

    public void setTrafficEnabled(boolean var1) throws RemoteException;

    public void snapshot(o var1, com.google.android.gms.dynamic.b var2) throws RemoteException;

    public void stopAnimation() throws RemoteException;

    public static abstract class com.google.android.gms.maps.internal.IGoogleMapDelegate$a
    extends Binder
    implements IGoogleMapDelegate {
        public static IGoogleMapDelegate O(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            if (iInterface == null) return new a(iBinder);
            if (!(iInterface instanceof IGoogleMapDelegate)) return new a(iBinder);
            return (IGoogleMapDelegate)iInterface;
        }

        public boolean onTransact(int n2, Parcel object, Parcel parcel, int n3) throws RemoteException {
            boolean bl2 = false;
            int n4 = 0;
            int n5 = 0;
            int n6 = 0;
            boolean bl3 = false;
            int n7 = 0;
            boolean bl4 = false;
            int n8 = 0;
            IPolylineDelegate iPolylineDelegate = null;
            Object var16_14 = null;
            Object var17_15 = null;
            Object var18_16 = null;
            Object var20_17 = null;
            Object var21_18 = null;
            Object var22_19 = null;
            Object var19_20 = null;
            Object object2 = null;
            switch (n2) {
                default: {
                    return super.onTransact(n2, (Parcel)object, parcel, n3);
                }
                case 1598968902: {
                    parcel.writeString("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    return true;
                }
                case 1: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    object = this.getCameraPosition();
                    parcel.writeNoException();
                    if (object != null) {
                        parcel.writeInt(1);
                        ((CameraPosition)object).writeToParcel(parcel, 1);
                        return true;
                    }
                    parcel.writeInt(0);
                    return true;
                }
                case 2: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    float f2 = this.getMaxZoomLevel();
                    parcel.writeNoException();
                    parcel.writeFloat(f2);
                    return true;
                }
                case 3: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    float f3 = this.getMinZoomLevel();
                    parcel.writeNoException();
                    parcel.writeFloat(f3);
                    return true;
                }
                case 4: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.moveCamera(b.a.C(object.readStrongBinder()));
                    parcel.writeNoException();
                    return true;
                }
                case 5: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.animateCamera(b.a.C(object.readStrongBinder()));
                    parcel.writeNoException();
                    return true;
                }
                case 6: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.animateCameraWithCallback(b.a.C(object.readStrongBinder()), b.a.M(object.readStrongBinder()));
                    parcel.writeNoException();
                    return true;
                }
                case 7: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.animateCameraWithDurationAndCallback(b.a.C(object.readStrongBinder()), object.readInt(), b.a.M(object.readStrongBinder()));
                    parcel.writeNoException();
                    return true;
                }
                case 8: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.stopAnimation();
                    parcel.writeNoException();
                    return true;
                }
                case 9: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    object = object.readInt() != 0 ? PolylineOptions.CREATOR.createFromParcel((Parcel)object) : null;
                    iPolylineDelegate = this.addPolyline((PolylineOptions)object);
                    parcel.writeNoException();
                    object = object2;
                    if (iPolylineDelegate != null) {
                        object = iPolylineDelegate.asBinder();
                    }
                    parcel.writeStrongBinder((IBinder)object);
                    return true;
                }
                case 10: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    object = object.readInt() != 0 ? PolygonOptions.CREATOR.createFromParcel((Parcel)object) : null;
                    object2 = this.addPolygon((PolygonOptions)object);
                    parcel.writeNoException();
                    object = iPolylineDelegate;
                    if (object2 != null) {
                        object = object2.asBinder();
                    }
                    parcel.writeStrongBinder((IBinder)object);
                    return true;
                }
                case 11: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    object = object.readInt() != 0 ? MarkerOptions.CREATOR.createFromParcel((Parcel)object) : null;
                    object2 = this.addMarker((MarkerOptions)object);
                    parcel.writeNoException();
                    object = var16_14;
                    if (object2 != null) {
                        object = object2.asBinder();
                    }
                    parcel.writeStrongBinder((IBinder)object);
                    return true;
                }
                case 12: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    object = object.readInt() != 0 ? GroundOverlayOptions.CREATOR.createFromParcel((Parcel)object) : null;
                    object2 = this.addGroundOverlay((GroundOverlayOptions)object);
                    parcel.writeNoException();
                    object = var17_15;
                    if (object2 != null) {
                        object = object2.asBinder();
                    }
                    parcel.writeStrongBinder((IBinder)object);
                    return true;
                }
                case 13: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    object = object.readInt() != 0 ? TileOverlayOptions.CREATOR.createFromParcel((Parcel)object) : null;
                    object2 = this.addTileOverlay((TileOverlayOptions)object);
                    parcel.writeNoException();
                    object = var18_16;
                    if (object2 != null) {
                        object = object2.asBinder();
                    }
                    parcel.writeStrongBinder((IBinder)object);
                    return true;
                }
                case 14: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.clear();
                    parcel.writeNoException();
                    return true;
                }
                case 15: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    n2 = this.getMapType();
                    parcel.writeNoException();
                    parcel.writeInt(n2);
                    return true;
                }
                case 16: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.setMapType(object.readInt());
                    parcel.writeNoException();
                    return true;
                }
                case 17: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    bl2 = this.isTrafficEnabled();
                    parcel.writeNoException();
                    n2 = n8;
                    if (bl2) {
                        n2 = 1;
                    }
                    parcel.writeInt(n2);
                    return true;
                }
                case 18: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    if (object.readInt() != 0) {
                        bl2 = true;
                    }
                    this.setTrafficEnabled(bl2);
                    parcel.writeNoException();
                    return true;
                }
                case 19: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    bl2 = this.isIndoorEnabled();
                    parcel.writeNoException();
                    n2 = n4;
                    if (bl2) {
                        n2 = 1;
                    }
                    parcel.writeInt(n2);
                    return true;
                }
                case 20: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    bl2 = object.readInt() != 0;
                    bl2 = this.setIndoorEnabled(bl2);
                    parcel.writeNoException();
                    n2 = n5;
                    if (bl2) {
                        n2 = 1;
                    }
                    parcel.writeInt(n2);
                    return true;
                }
                case 21: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    bl2 = this.isMyLocationEnabled();
                    parcel.writeNoException();
                    n2 = n6;
                    if (bl2) {
                        n2 = 1;
                    }
                    parcel.writeInt(n2);
                    return true;
                }
                case 22: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    bl2 = bl3;
                    if (object.readInt() != 0) {
                        bl2 = true;
                    }
                    this.setMyLocationEnabled(bl2);
                    parcel.writeNoException();
                    return true;
                }
                case 23: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    object = this.getMyLocation();
                    parcel.writeNoException();
                    if (object != null) {
                        parcel.writeInt(1);
                        object.writeToParcel(parcel, 1);
                        return true;
                    }
                    parcel.writeInt(0);
                    return true;
                }
                case 24: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.setLocationSource(ILocationSourceDelegate.a.Q(object.readStrongBinder()));
                    parcel.writeNoException();
                    return true;
                }
                case 25: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    object2 = this.getUiSettings();
                    parcel.writeNoException();
                    object = var20_17;
                    if (object2 != null) {
                        object = object2.asBinder();
                    }
                    parcel.writeStrongBinder((IBinder)object);
                    return true;
                }
                case 26: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    object2 = this.getProjection();
                    parcel.writeNoException();
                    object = var21_18;
                    if (object2 != null) {
                        object = object2.asBinder();
                    }
                    parcel.writeStrongBinder((IBinder)object);
                    return true;
                }
                case 27: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.setOnCameraChangeListener(e.a.T(object.readStrongBinder()));
                    parcel.writeNoException();
                    return true;
                }
                case 28: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.setOnMapClickListener(h.a.W(object.readStrongBinder()));
                    parcel.writeNoException();
                    return true;
                }
                case 29: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.setOnMapLongClickListener(j.a.Y(object.readStrongBinder()));
                    parcel.writeNoException();
                    return true;
                }
                case 30: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.setOnMarkerClickListener(k.a.Z(object.readStrongBinder()));
                    parcel.writeNoException();
                    return true;
                }
                case 31: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.setOnMarkerDragListener(l.a.aa(object.readStrongBinder()));
                    parcel.writeNoException();
                    return true;
                }
                case 32: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.setOnInfoWindowClickListener(f.a.U(object.readStrongBinder()));
                    parcel.writeNoException();
                    return true;
                }
                case 33: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.setInfoWindowAdapter(d.a.P(object.readStrongBinder()));
                    parcel.writeNoException();
                    return true;
                }
                case 34: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    object2 = this.getTestingHelper();
                    parcel.writeNoException();
                    object = var22_19;
                    if (object2 != null) {
                        object = object2.asBinder();
                    }
                    parcel.writeStrongBinder((IBinder)object);
                    return true;
                }
                case 35: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    object = object.readInt() != 0 ? CircleOptions.CREATOR.createFromParcel((Parcel)object) : null;
                    object2 = this.addCircle((CircleOptions)object);
                    parcel.writeNoException();
                    object = var19_20;
                    if (object2 != null) {
                        object = object2.asBinder();
                    }
                    parcel.writeStrongBinder((IBinder)object);
                    return true;
                }
                case 36: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.setOnMyLocationChangeListener(n.a.ac(object.readStrongBinder()));
                    parcel.writeNoException();
                    return true;
                }
                case 37: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.setOnMyLocationButtonClickListener(m.a.ab(object.readStrongBinder()));
                    parcel.writeNoException();
                    return true;
                }
                case 38: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.snapshot(o.a.ae(object.readStrongBinder()), b.a.C(object.readStrongBinder()));
                    parcel.writeNoException();
                    return true;
                }
                case 39: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.setPadding(object.readInt(), object.readInt(), object.readInt(), object.readInt());
                    parcel.writeNoException();
                    return true;
                }
                case 40: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    bl2 = this.isBuildingsEnabled();
                    parcel.writeNoException();
                    n2 = n7;
                    if (bl2) {
                        n2 = 1;
                    }
                    parcel.writeInt(n2);
                    return true;
                }
                case 41: {
                    object.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    bl2 = bl4;
                    if (object.readInt() != 0) {
                        bl2 = true;
                    }
                    this.setBuildingsEnabled(bl2);
                    parcel.writeNoException();
                    return true;
                }
                case 42: 
            }
            object.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setOnMapLoadedCallback(i.a.X(object.readStrongBinder()));
            parcel.writeNoException();
            return true;
        }

        private static class a
        implements IGoogleMapDelegate {
            private IBinder dU;

            a(IBinder iBinder) {
                this.dU = iBinder;
            }

            @Override
            public com.google.android.gms.maps.model.internal.b addCircle(CircleOptions object) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    if (object != null) {
                        parcel.writeInt(1);
                        ((CircleOptions)object).writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(35, parcel, parcel2, 0);
                    parcel2.readException();
                    object = b.a.ah(parcel2.readStrongBinder());
                    return object;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public c addGroundOverlay(GroundOverlayOptions object) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    if (object != null) {
                        parcel.writeInt(1);
                        ((GroundOverlayOptions)object).writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(12, parcel, parcel2, 0);
                    parcel2.readException();
                    object = c.a.ai(parcel2.readStrongBinder());
                    return object;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public com.google.android.gms.maps.model.internal.d addMarker(MarkerOptions object) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    if (object != null) {
                        parcel.writeInt(1);
                        ((MarkerOptions)object).writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(11, parcel, parcel2, 0);
                    parcel2.readException();
                    object = d.a.aj(parcel2.readStrongBinder());
                    return object;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public com.google.android.gms.maps.model.internal.e addPolygon(PolygonOptions object) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    if (object != null) {
                        parcel.writeInt(1);
                        ((PolygonOptions)object).writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(10, parcel, parcel2, 0);
                    parcel2.readException();
                    object = e.a.ak(parcel2.readStrongBinder());
                    return object;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public IPolylineDelegate addPolyline(PolylineOptions object) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    if (object != null) {
                        parcel.writeInt(1);
                        ((PolylineOptions)object).writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(9, parcel, parcel2, 0);
                    parcel2.readException();
                    object = IPolylineDelegate.a.al(parcel2.readStrongBinder());
                    return object;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public com.google.android.gms.maps.model.internal.f addTileOverlay(TileOverlayOptions object) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    if (object != null) {
                        parcel.writeInt(1);
                        ((TileOverlayOptions)object).writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(13, parcel, parcel2, 0);
                    parcel2.readException();
                    object = f.a.am(parcel2.readStrongBinder());
                    return object;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void animateCamera(com.google.android.gms.dynamic.b b2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    b2 = b2 != null ? b2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)b2);
                    this.dU.transact(5, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void animateCameraWithCallback(com.google.android.gms.dynamic.b b2, b b3) throws RemoteException {
                Object var3_4 = null;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    b2 = b2 != null ? b2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)b2);
                    b2 = var3_4;
                    if (b3 != null) {
                        b2 = b3.asBinder();
                    }
                    parcel.writeStrongBinder((IBinder)b2);
                    this.dU.transact(6, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void animateCameraWithDurationAndCallback(com.google.android.gms.dynamic.b b2, int n2, b b3) throws RemoteException {
                Object var4_5 = null;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    b2 = b2 != null ? b2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)b2);
                    parcel.writeInt(n2);
                    b2 = var4_5;
                    if (b3 != null) {
                        b2 = b3.asBinder();
                    }
                    parcel.writeStrongBinder((IBinder)b2);
                    this.dU.transact(7, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            public IBinder asBinder() {
                return this.dU;
            }

            @Override
            public void clear() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.dU.transact(14, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public CameraPosition getCameraPosition() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.dU.transact(1, parcel, parcel2, 0);
                    parcel2.readException();
                    CameraPosition cameraPosition = parcel2.readInt() != 0 ? CameraPosition.CREATOR.createFromParcel(parcel2) : null;
                    return cameraPosition;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public int getMapType() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.dU.transact(15, parcel, parcel2, 0);
                    parcel2.readException();
                    int n2 = parcel2.readInt();
                    return n2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public float getMaxZoomLevel() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.dU.transact(2, parcel, parcel2, 0);
                    parcel2.readException();
                    float f2 = parcel2.readFloat();
                    return f2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public float getMinZoomLevel() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.dU.transact(3, parcel, parcel2, 0);
                    parcel2.readException();
                    float f2 = parcel2.readFloat();
                    return f2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public Location getMyLocation() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.dU.transact(23, parcel, parcel2, 0);
                    parcel2.readException();
                    Location location = parcel2.readInt() != 0 ? (Location)Location.CREATOR.createFromParcel(parcel2) : null;
                    return location;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public IProjectionDelegate getProjection() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.dU.transact(26, parcel, parcel2, 0);
                    parcel2.readException();
                    IProjectionDelegate iProjectionDelegate = IProjectionDelegate.a.ad(parcel2.readStrongBinder());
                    return iProjectionDelegate;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public com.google.android.gms.dynamic.b getTestingHelper() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.dU.transact(34, parcel, parcel2, 0);
                    parcel2.readException();
                    com.google.android.gms.dynamic.b b2 = b.a.C(parcel2.readStrongBinder());
                    return b2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public IUiSettingsDelegate getUiSettings() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.dU.transact(25, parcel, parcel2, 0);
                    parcel2.readException();
                    IUiSettingsDelegate iUiSettingsDelegate = IUiSettingsDelegate.a.af(parcel2.readStrongBinder());
                    return iUiSettingsDelegate;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public boolean isBuildingsEnabled() throws RemoteException {
                boolean bl2 = false;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.dU.transact(40, parcel, parcel2, 0);
                    parcel2.readException();
                    int n2 = parcel2.readInt();
                    if (n2 == 0) return bl2;
                    bl2 = true;
                    return bl2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public boolean isIndoorEnabled() throws RemoteException {
                boolean bl2 = false;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.dU.transact(19, parcel, parcel2, 0);
                    parcel2.readException();
                    int n2 = parcel2.readInt();
                    if (n2 == 0) return bl2;
                    bl2 = true;
                    return bl2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public boolean isMyLocationEnabled() throws RemoteException {
                boolean bl2 = false;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.dU.transact(21, parcel, parcel2, 0);
                    parcel2.readException();
                    int n2 = parcel2.readInt();
                    if (n2 == 0) return bl2;
                    bl2 = true;
                    return bl2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public boolean isTrafficEnabled() throws RemoteException {
                boolean bl2 = false;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.dU.transact(17, parcel, parcel2, 0);
                    parcel2.readException();
                    int n2 = parcel2.readInt();
                    if (n2 == 0) return bl2;
                    bl2 = true;
                    return bl2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void moveCamera(com.google.android.gms.dynamic.b b2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    b2 = b2 != null ? b2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)b2);
                    this.dU.transact(4, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void setBuildingsEnabled(boolean bl2) throws RemoteException {
                int n2 = 0;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    if (bl2) {
                        n2 = 1;
                    }
                    parcel.writeInt(n2);
                    this.dU.transact(41, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public boolean setIndoorEnabled(boolean bl2) throws RemoteException {
                boolean bl3 = true;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    int n2 = bl2 ? 1 : 0;
                    parcel.writeInt(n2);
                    this.dU.transact(20, parcel, parcel2, 0);
                    parcel2.readException();
                    n2 = parcel2.readInt();
                    bl2 = n2 != 0 ? bl3 : false;
                    return bl2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void setInfoWindowAdapter(d d2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    d2 = d2 != null ? d2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)d2);
                    this.dU.transact(33, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void setLocationSource(ILocationSourceDelegate iLocationSourceDelegate) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    iLocationSourceDelegate = iLocationSourceDelegate != null ? iLocationSourceDelegate.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)iLocationSourceDelegate);
                    this.dU.transact(24, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void setMapType(int n2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    parcel.writeInt(n2);
                    this.dU.transact(16, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void setMyLocationEnabled(boolean bl2) throws RemoteException {
                int n2 = 0;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    if (bl2) {
                        n2 = 1;
                    }
                    parcel.writeInt(n2);
                    this.dU.transact(22, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void setOnCameraChangeListener(e e2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    e2 = e2 != null ? e2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)e2);
                    this.dU.transact(27, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void setOnInfoWindowClickListener(f f2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    f2 = f2 != null ? f2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)f2);
                    this.dU.transact(32, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void setOnMapClickListener(h h2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    h2 = h2 != null ? h2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)h2);
                    this.dU.transact(28, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void setOnMapLoadedCallback(i i2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    i2 = i2 != null ? i2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)i2);
                    this.dU.transact(42, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void setOnMapLongClickListener(j j2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    j2 = j2 != null ? j2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)j2);
                    this.dU.transact(29, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void setOnMarkerClickListener(k k2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    k2 = k2 != null ? k2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)k2);
                    this.dU.transact(30, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void setOnMarkerDragListener(l l2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    l2 = l2 != null ? l2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)l2);
                    this.dU.transact(31, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void setOnMyLocationButtonClickListener(m m2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    m2 = m2 != null ? m2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)m2);
                    this.dU.transact(37, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void setOnMyLocationChangeListener(n n2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    n2 = n2 != null ? n2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)n2);
                    this.dU.transact(36, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void setPadding(int n2, int n3, int n4, int n5) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    parcel.writeInt(n2);
                    parcel.writeInt(n3);
                    parcel.writeInt(n4);
                    parcel.writeInt(n5);
                    this.dU.transact(39, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void setTrafficEnabled(boolean bl2) throws RemoteException {
                int n2 = 0;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    if (bl2) {
                        n2 = 1;
                    }
                    parcel.writeInt(n2);
                    this.dU.transact(18, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void snapshot(o o2, com.google.android.gms.dynamic.b b2) throws RemoteException {
                Object var3_4 = null;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    o2 = o2 != null ? o2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)o2);
                    o2 = var3_4;
                    if (b2 != null) {
                        o2 = b2.asBinder();
                    }
                    parcel.writeStrongBinder((IBinder)o2);
                    this.dU.transact(38, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void stopAnimation() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.dU.transact(8, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }
        }
    }
}

