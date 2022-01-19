/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.location.Location
 *  android.os.Binder
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  android.os.RemoteException
 */
package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.fj;
import com.google.android.gms.internal.fn;
import com.google.android.gms.internal.fs;
import com.google.android.gms.internal.fu;
import com.google.android.gms.internal.fy;
import com.google.android.gms.internal.gg;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.a;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.List;

public interface fk
extends IInterface {
    public Location Z(String var1) throws RemoteException;

    public void a(long var1, boolean var3, PendingIntent var4) throws RemoteException;

    public void a(PendingIntent var1) throws RemoteException;

    public void a(PendingIntent var1, fj var2, String var3) throws RemoteException;

    public void a(Location var1, int var2) throws RemoteException;

    public void a(fj var1, String var2) throws RemoteException;

    public void a(fs var1, gg var2, fy var3) throws RemoteException;

    public void a(fu var1, gg var2, PendingIntent var3) throws RemoteException;

    public void a(gg var1, PendingIntent var2) throws RemoteException;

    public void a(LocationRequest var1, PendingIntent var2) throws RemoteException;

    public void a(LocationRequest var1, com.google.android.gms.location.a var2) throws RemoteException;

    public void a(LocationRequest var1, com.google.android.gms.location.a var2, String var3) throws RemoteException;

    public void a(com.google.android.gms.location.a var1) throws RemoteException;

    public void a(LatLng var1, fs var2, gg var3, fy var4) throws RemoteException;

    public void a(LatLngBounds var1, int var2, fs var3, gg var4, fy var5) throws RemoteException;

    public void a(String var1, gg var2, fy var3) throws RemoteException;

    public void a(String var1, String var2, gg var3) throws RemoteException;

    public void a(String var1, String var2, String var3) throws RemoteException;

    public void a(List<fn> var1, PendingIntent var2, fj var3, String var4) throws RemoteException;

    public void a(String[] var1, fj var2, String var3) throws RemoteException;

    public Location dp() throws RemoteException;

    public void removeActivityUpdates(PendingIntent var1) throws RemoteException;

    public void setMockLocation(Location var1) throws RemoteException;

    public void setMockMode(boolean var1) throws RemoteException;

    public static abstract class com.google.android.gms.internal.fk$a
    extends Binder
    implements fk {
        public static fk I(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (iInterface == null) return new a(iBinder);
            if (!(iInterface instanceof fk)) return new a(iBinder);
            return (fk)iInterface;
        }

        public boolean onTransact(int n2, Parcel parcel, Parcel object, int n3) throws RemoteException {
            boolean bl2 = false;
            boolean bl3 = false;
            LocationRequest locationRequest = null;
            Object var18_8 = null;
            LocationRequest locationRequest2 = null;
            LocationRequest locationRequest3 = null;
            Object object2 = null;
            LocationRequest locationRequest4 = null;
            LocationRequest locationRequest5 = null;
            LocationRequest locationRequest6 = null;
            Object object3 = null;
            Object var13_16 = null;
            Object var12_17 = null;
            Object var14_18 = null;
            LocationRequest locationRequest7 = null;
            SafeParcelable safeParcelable = null;
            LocationRequest locationRequest8 = null;
            LocationRequest locationRequest9 = null;
            switch (n2) {
                default: {
                    return super.onTransact(n2, parcel, object, n3);
                }
                case 1598968902: {
                    object.writeString("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    return true;
                }
                case 1: {
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    object2 = parcel.createTypedArrayList((Parcelable.Creator)fn.CREATOR);
                    safeParcelable = locationRequest9;
                    if (parcel.readInt() != 0) {
                        safeParcelable = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
                    }
                    this.a((List)object2, (PendingIntent)safeParcelable, fj.a.H(parcel.readStrongBinder()), parcel.readString());
                    object.writeNoException();
                    return true;
                }
                case 2: {
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    safeParcelable = locationRequest;
                    if (parcel.readInt() != 0) {
                        safeParcelable = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
                    }
                    this.a((PendingIntent)safeParcelable, fj.a.H(parcel.readStrongBinder()), parcel.readString());
                    object.writeNoException();
                    return true;
                }
                case 3: {
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    this.a(parcel.createStringArray(), fj.a.H(parcel.readStrongBinder()), parcel.readString());
                    object.writeNoException();
                    return true;
                }
                case 4: {
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    this.a(fj.a.H(parcel.readStrongBinder()), parcel.readString());
                    object.writeNoException();
                    return true;
                }
                case 5: {
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    long l2 = parcel.readLong();
                    if (parcel.readInt() != 0) {
                        bl3 = true;
                    }
                    safeParcelable = var18_8;
                    if (parcel.readInt() != 0) {
                        safeParcelable = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
                    }
                    this.a(l2, bl3, (PendingIntent)safeParcelable);
                    object.writeNoException();
                    return true;
                }
                case 6: {
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    safeParcelable = locationRequest2;
                    if (parcel.readInt() != 0) {
                        safeParcelable = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
                    }
                    this.removeActivityUpdates((PendingIntent)safeParcelable);
                    object.writeNoException();
                    return true;
                }
                case 7: {
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    parcel = this.dp();
                    object.writeNoException();
                    if (parcel != null) {
                        object.writeInt(1);
                        parcel.writeToParcel(object, 1);
                        return true;
                    }
                    object.writeInt(0);
                    return true;
                }
                case 8: {
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    safeParcelable = locationRequest3;
                    if (parcel.readInt() != 0) {
                        safeParcelable = LocationRequest.CREATOR.createFromParcel(parcel);
                    }
                    this.a((LocationRequest)safeParcelable, a.a.G(parcel.readStrongBinder()));
                    object.writeNoException();
                    return true;
                }
                case 9: {
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    safeParcelable = parcel.readInt() != 0 ? LocationRequest.CREATOR.createFromParcel(parcel) : null;
                    if (parcel.readInt() != 0) {
                        object2 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
                    }
                    this.a((LocationRequest)safeParcelable, (PendingIntent)object2);
                    object.writeNoException();
                    return true;
                }
                case 10: {
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    this.a(a.a.G(parcel.readStrongBinder()));
                    object.writeNoException();
                    return true;
                }
                case 11: {
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    safeParcelable = locationRequest4;
                    if (parcel.readInt() != 0) {
                        safeParcelable = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
                    }
                    this.a((PendingIntent)safeParcelable);
                    object.writeNoException();
                    return true;
                }
                case 12: {
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    bl3 = bl2;
                    if (parcel.readInt() != 0) {
                        bl3 = true;
                    }
                    this.setMockMode(bl3);
                    object.writeNoException();
                    return true;
                }
                case 13: {
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    safeParcelable = locationRequest5;
                    if (parcel.readInt() != 0) {
                        safeParcelable = (Location)Location.CREATOR.createFromParcel(parcel);
                    }
                    this.setMockLocation((Location)safeParcelable);
                    object.writeNoException();
                    return true;
                }
                case 14: {
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    safeParcelable = parcel.readInt() != 0 ? LatLngBounds.CREATOR.createFromParcel(parcel) : null;
                    n2 = parcel.readInt();
                    object2 = parcel.readInt() != 0 ? fs.CREATOR.ab(parcel) : null;
                    object3 = parcel.readInt() != 0 ? gg.CREATOR.ah(parcel) : null;
                    this.a((LatLngBounds)safeParcelable, n2, (fs)object2, (gg)object3, fy.a.K(parcel.readStrongBinder()));
                    object.writeNoException();
                    return true;
                }
                case 15: {
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    object2 = parcel.readString();
                    safeParcelable = locationRequest6;
                    if (parcel.readInt() != 0) {
                        safeParcelable = gg.CREATOR.ah(parcel);
                    }
                    this.a((String)object2, (gg)safeParcelable, fy.a.K(parcel.readStrongBinder()));
                    object.writeNoException();
                    return true;
                }
                case 16: {
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    safeParcelable = parcel.readInt() != 0 ? LatLng.CREATOR.createFromParcel(parcel) : null;
                    object2 = parcel.readInt() != 0 ? fs.CREATOR.ab(parcel) : null;
                    if (parcel.readInt() != 0) {
                        object3 = gg.CREATOR.ah(parcel);
                    }
                    this.a((LatLng)safeParcelable, (fs)object2, (gg)object3, fy.a.K(parcel.readStrongBinder()));
                    object.writeNoException();
                    return true;
                }
                case 17: {
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    safeParcelable = parcel.readInt() != 0 ? fs.CREATOR.ab(parcel) : null;
                    object2 = var13_16;
                    if (parcel.readInt() != 0) {
                        object2 = gg.CREATOR.ah(parcel);
                    }
                    this.a((fs)safeParcelable, (gg)object2, fy.a.K(parcel.readStrongBinder()));
                    object.writeNoException();
                    return true;
                }
                case 18: {
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    safeParcelable = parcel.readInt() != 0 ? fu.CREATOR.ac(parcel) : null;
                    object2 = parcel.readInt() != 0 ? gg.CREATOR.ah(parcel) : null;
                    object3 = var12_17;
                    if (parcel.readInt() != 0) {
                        object3 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
                    }
                    this.a((fu)safeParcelable, (gg)object2, (PendingIntent)object3);
                    object.writeNoException();
                    return true;
                }
                case 19: {
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    safeParcelable = parcel.readInt() != 0 ? gg.CREATOR.ah(parcel) : null;
                    object2 = var14_18;
                    if (parcel.readInt() != 0) {
                        object2 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
                    }
                    this.a((gg)safeParcelable, (PendingIntent)object2);
                    object.writeNoException();
                    return true;
                }
                case 20: {
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    safeParcelable = locationRequest7;
                    if (parcel.readInt() != 0) {
                        safeParcelable = LocationRequest.CREATOR.createFromParcel(parcel);
                    }
                    this.a((LocationRequest)safeParcelable, a.a.G(parcel.readStrongBinder()), parcel.readString());
                    object.writeNoException();
                    return true;
                }
                case 21: {
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    parcel = this.Z(parcel.readString());
                    object.writeNoException();
                    if (parcel != null) {
                        object.writeInt(1);
                        parcel.writeToParcel(object, 1);
                        return true;
                    }
                    object.writeInt(0);
                    return true;
                }
                case 24: {
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    this.a(parcel.readString(), parcel.readString(), parcel.readString());
                    return true;
                }
                case 25: {
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    object2 = parcel.readString();
                    object3 = parcel.readString();
                    object = safeParcelable;
                    if (parcel.readInt() != 0) {
                        object = gg.CREATOR.ah(parcel);
                    }
                    this.a((String)object2, (String)object3, (gg)object);
                    return true;
                }
                case 26: 
            }
            parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            safeParcelable = locationRequest8;
            if (parcel.readInt() != 0) {
                safeParcelable = (Location)Location.CREATOR.createFromParcel(parcel);
            }
            this.a((Location)safeParcelable, parcel.readInt());
            object.writeNoException();
            return true;
        }

        private static class a
        implements fk {
            private IBinder dU;

            a(IBinder iBinder) {
                this.dU = iBinder;
            }

            @Override
            public Location Z(String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    parcel.writeString(string2);
                    this.dU.transact(21, parcel, parcel2, 0);
                    parcel2.readException();
                    string2 = parcel2.readInt() != 0 ? (Location)Location.CREATOR.createFromParcel(parcel2) : null;
                    return string2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            /*
             * Enabled unnecessary exception pruning
             */
            @Override
            public void a(long l2, boolean bl2, PendingIntent pendingIntent) throws RemoteException {
                int n2 = 1;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    parcel.writeLong(l2);
                    if (!bl2) {
                        n2 = 0;
                    }
                    parcel.writeInt(n2);
                    if (pendingIntent != null) {
                        parcel.writeInt(1);
                        pendingIntent.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
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
            public void a(PendingIntent pendingIntent) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        parcel.writeInt(1);
                        pendingIntent.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(11, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            /*
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public void a(PendingIntent object, fj fj2, String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    void var3_7;
                    void var1_3;
                    void var2_6;
                    parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (object != null) {
                        parcel.writeInt(1);
                        object.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    if (var2_6 != null) {
                        IBinder iBinder = var2_6.asBinder();
                    } else {
                        Object var1_5 = null;
                    }
                    parcel.writeStrongBinder((IBinder)var1_3);
                    parcel.writeString((String)var3_7);
                    this.dU.transact(2, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void a(Location location, int n2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (location != null) {
                        parcel.writeInt(1);
                        location.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    parcel.writeInt(n2);
                    this.dU.transact(26, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void a(fj fj2, String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    fj2 = fj2 != null ? fj2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fj2);
                    parcel.writeString(string2);
                    this.dU.transact(4, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            /*
             * Enabled unnecessary exception pruning
             */
            @Override
            public void a(fs fs2, gg gg2, fy fy2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (fs2 != null) {
                        parcel.writeInt(1);
                        fs2.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    if (gg2 != null) {
                        parcel.writeInt(1);
                        gg2.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    fs2 = fy2 != null ? fy2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fs2);
                    this.dU.transact(17, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            /*
             * Enabled unnecessary exception pruning
             */
            @Override
            public void a(fu fu2, gg gg2, PendingIntent pendingIntent) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (fu2 != null) {
                        parcel.writeInt(1);
                        fu2.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    if (gg2 != null) {
                        parcel.writeInt(1);
                        gg2.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        parcel.writeInt(1);
                        pendingIntent.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(18, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            /*
             * Enabled unnecessary exception pruning
             */
            @Override
            public void a(gg gg2, PendingIntent pendingIntent) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (gg2 != null) {
                        parcel.writeInt(1);
                        gg2.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        parcel.writeInt(1);
                        pendingIntent.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(19, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            /*
             * Enabled unnecessary exception pruning
             */
            @Override
            public void a(LocationRequest locationRequest, PendingIntent pendingIntent) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequest != null) {
                        parcel.writeInt(1);
                        locationRequest.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        parcel.writeInt(1);
                        pendingIntent.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(9, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            /*
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public void a(LocationRequest locationRequest, com.google.android.gms.location.a a2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    void var1_3;
                    void var2_6;
                    parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequest != null) {
                        parcel.writeInt(1);
                        locationRequest.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    if (var2_6 != null) {
                        IBinder iBinder = var2_6.asBinder();
                    } else {
                        Object var1_5 = null;
                    }
                    parcel.writeStrongBinder((IBinder)var1_3);
                    this.dU.transact(8, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            /*
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public void a(LocationRequest locationRequest, com.google.android.gms.location.a a2, String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    void var3_7;
                    void var1_3;
                    void var2_6;
                    parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequest != null) {
                        parcel.writeInt(1);
                        locationRequest.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    if (var2_6 != null) {
                        IBinder iBinder = var2_6.asBinder();
                    } else {
                        Object var1_5 = null;
                    }
                    parcel.writeStrongBinder((IBinder)var1_3);
                    parcel.writeString((String)var3_7);
                    this.dU.transact(20, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void a(com.google.android.gms.location.a a2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    a2 = a2 != null ? a2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)a2);
                    this.dU.transact(10, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            /*
             * Enabled unnecessary exception pruning
             */
            @Override
            public void a(LatLng latLng, fs fs2, gg gg2, fy fy2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (latLng != null) {
                        parcel.writeInt(1);
                        latLng.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    if (fs2 != null) {
                        parcel.writeInt(1);
                        fs2.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    if (gg2 != null) {
                        parcel.writeInt(1);
                        gg2.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    latLng = fy2 != null ? fy2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)latLng);
                    this.dU.transact(16, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            /*
             * Enabled unnecessary exception pruning
             */
            @Override
            public void a(LatLngBounds latLngBounds, int n2, fs fs2, gg gg2, fy fy2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (latLngBounds != null) {
                        parcel.writeInt(1);
                        latLngBounds.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    parcel.writeInt(n2);
                    if (fs2 != null) {
                        parcel.writeInt(1);
                        fs2.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    if (gg2 != null) {
                        parcel.writeInt(1);
                        gg2.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    latLngBounds = fy2 != null ? fy2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)latLngBounds);
                    this.dU.transact(14, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            /*
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public void a(String string2, gg gg2, fy fy2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    void var1_3;
                    void var3_7;
                    void var2_6;
                    parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    parcel.writeString(string2);
                    if (var2_6 != null) {
                        parcel.writeInt(1);
                        var2_6.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    if (var3_7 != null) {
                        IBinder iBinder = var3_7.asBinder();
                    } else {
                        Object var1_5 = null;
                    }
                    parcel.writeStrongBinder((IBinder)var1_3);
                    this.dU.transact(15, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void a(String string2, String string3, gg gg2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    parcel.writeString(string2);
                    parcel.writeString(string3);
                    if (gg2 != null) {
                        parcel.writeInt(1);
                        gg2.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(25, parcel, null, 1);
                    return;
                }
                finally {
                    parcel.recycle();
                }
            }

            @Override
            public void a(String string2, String string3, String string4) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    parcel.writeString(string2);
                    parcel.writeString(string3);
                    parcel.writeString(string4);
                    this.dU.transact(24, parcel, null, 1);
                    return;
                }
                finally {
                    parcel.recycle();
                }
            }

            /*
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public void a(List<fn> object, PendingIntent pendingIntent, fj fj2, String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    void var4_8;
                    void var1_3;
                    void var3_7;
                    void var2_6;
                    parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    parcel.writeTypedList((List)object);
                    if (var2_6 != null) {
                        parcel.writeInt(1);
                        var2_6.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    if (var3_7 != null) {
                        IBinder iBinder = var3_7.asBinder();
                    } else {
                        Object var1_5 = null;
                    }
                    parcel.writeStrongBinder((IBinder)var1_3);
                    parcel.writeString((String)var4_8);
                    this.dU.transact(1, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void a(String[] object, fj fj2, String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    parcel.writeStringArray((String[])object);
                    object = fj2 != null ? fj2.asBinder() : null;
                    parcel.writeStrongBinder(object);
                    parcel.writeString(string2);
                    this.dU.transact(3, parcel, parcel2, 0);
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
            public Location dp() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    this.dU.transact(7, parcel, parcel2, 0);
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
            public void removeActivityUpdates(PendingIntent pendingIntent) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        parcel.writeInt(1);
                        pendingIntent.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
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
            public void setMockLocation(Location location) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (location != null) {
                        parcel.writeInt(1);
                        location.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(13, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void setMockMode(boolean bl2) throws RemoteException {
                int n2 = 0;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (bl2) {
                        n2 = 1;
                    }
                    parcel.writeInt(n2);
                    this.dU.transact(12, parcel, parcel2, 0);
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

