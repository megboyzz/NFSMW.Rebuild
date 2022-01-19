/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Binder
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 */
package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IUiSettingsDelegate
extends IInterface {
    public boolean isCompassEnabled() throws RemoteException;

    public boolean isMyLocationButtonEnabled() throws RemoteException;

    public boolean isRotateGesturesEnabled() throws RemoteException;

    public boolean isScrollGesturesEnabled() throws RemoteException;

    public boolean isTiltGesturesEnabled() throws RemoteException;

    public boolean isZoomControlsEnabled() throws RemoteException;

    public boolean isZoomGesturesEnabled() throws RemoteException;

    public void setAllGesturesEnabled(boolean var1) throws RemoteException;

    public void setCompassEnabled(boolean var1) throws RemoteException;

    public void setMyLocationButtonEnabled(boolean var1) throws RemoteException;

    public void setRotateGesturesEnabled(boolean var1) throws RemoteException;

    public void setScrollGesturesEnabled(boolean var1) throws RemoteException;

    public void setTiltGesturesEnabled(boolean var1) throws RemoteException;

    public void setZoomControlsEnabled(boolean var1) throws RemoteException;

    public void setZoomGesturesEnabled(boolean var1) throws RemoteException;

    public static abstract class com.google.android.gms.maps.internal.IUiSettingsDelegate$a
    extends Binder
    implements IUiSettingsDelegate {
        public static IUiSettingsDelegate af(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            if (iInterface == null) return new a(iBinder);
            if (!(iInterface instanceof IUiSettingsDelegate)) return new a(iBinder);
            return (IUiSettingsDelegate)iInterface;
        }

        public boolean onTransact(int n2, Parcel parcel, Parcel parcel2, int n3) throws RemoteException {
            boolean bl2 = false;
            boolean bl3 = false;
            boolean bl4 = false;
            boolean bl5 = false;
            boolean bl6 = false;
            boolean bl7 = false;
            boolean bl8 = false;
            int n4 = 0;
            int n5 = 0;
            int n6 = 0;
            int n7 = 0;
            int n8 = 0;
            int n9 = 0;
            int n10 = 0;
            boolean bl9 = false;
            switch (n2) {
                default: {
                    return super.onTransact(n2, parcel, parcel2, n3);
                }
                case 1598968902: {
                    parcel2.writeString("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    return true;
                }
                case 1: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    if (parcel.readInt() != 0) {
                        bl9 = true;
                    }
                    this.setZoomControlsEnabled(bl9);
                    parcel2.writeNoException();
                    return true;
                }
                case 2: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    bl9 = bl2;
                    if (parcel.readInt() != 0) {
                        bl9 = true;
                    }
                    this.setCompassEnabled(bl9);
                    parcel2.writeNoException();
                    return true;
                }
                case 3: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    bl9 = bl3;
                    if (parcel.readInt() != 0) {
                        bl9 = true;
                    }
                    this.setMyLocationButtonEnabled(bl9);
                    parcel2.writeNoException();
                    return true;
                }
                case 4: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    bl9 = bl4;
                    if (parcel.readInt() != 0) {
                        bl9 = true;
                    }
                    this.setScrollGesturesEnabled(bl9);
                    parcel2.writeNoException();
                    return true;
                }
                case 5: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    bl9 = bl5;
                    if (parcel.readInt() != 0) {
                        bl9 = true;
                    }
                    this.setZoomGesturesEnabled(bl9);
                    parcel2.writeNoException();
                    return true;
                }
                case 6: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    bl9 = bl6;
                    if (parcel.readInt() != 0) {
                        bl9 = true;
                    }
                    this.setTiltGesturesEnabled(bl9);
                    parcel2.writeNoException();
                    return true;
                }
                case 7: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    bl9 = bl7;
                    if (parcel.readInt() != 0) {
                        bl9 = true;
                    }
                    this.setRotateGesturesEnabled(bl9);
                    parcel2.writeNoException();
                    return true;
                }
                case 8: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    bl9 = bl8;
                    if (parcel.readInt() != 0) {
                        bl9 = true;
                    }
                    this.setAllGesturesEnabled(bl9);
                    parcel2.writeNoException();
                    return true;
                }
                case 9: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    bl9 = this.isZoomControlsEnabled();
                    parcel2.writeNoException();
                    n2 = n4;
                    if (bl9) {
                        n2 = 1;
                    }
                    parcel2.writeInt(n2);
                    return true;
                }
                case 10: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    bl9 = this.isCompassEnabled();
                    parcel2.writeNoException();
                    n2 = n5;
                    if (bl9) {
                        n2 = 1;
                    }
                    parcel2.writeInt(n2);
                    return true;
                }
                case 11: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    bl9 = this.isMyLocationButtonEnabled();
                    parcel2.writeNoException();
                    n2 = n6;
                    if (bl9) {
                        n2 = 1;
                    }
                    parcel2.writeInt(n2);
                    return true;
                }
                case 12: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    bl9 = this.isScrollGesturesEnabled();
                    parcel2.writeNoException();
                    n2 = n7;
                    if (bl9) {
                        n2 = 1;
                    }
                    parcel2.writeInt(n2);
                    return true;
                }
                case 13: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    bl9 = this.isZoomGesturesEnabled();
                    parcel2.writeNoException();
                    n2 = n8;
                    if (bl9) {
                        n2 = 1;
                    }
                    parcel2.writeInt(n2);
                    return true;
                }
                case 14: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    bl9 = this.isTiltGesturesEnabled();
                    parcel2.writeNoException();
                    n2 = n9;
                    if (bl9) {
                        n2 = 1;
                    }
                    parcel2.writeInt(n2);
                    return true;
                }
                case 15: 
            }
            parcel.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            bl9 = this.isRotateGesturesEnabled();
            parcel2.writeNoException();
            n2 = n10;
            if (bl9) {
                n2 = 1;
            }
            parcel2.writeInt(n2);
            return true;
        }

        private static class a
        implements IUiSettingsDelegate {
            private IBinder dU;

            a(IBinder iBinder) {
                this.dU = iBinder;
            }

            public IBinder asBinder() {
                return this.dU;
            }

            @Override
            public boolean isCompassEnabled() throws RemoteException {
                boolean bl2 = false;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    this.dU.transact(10, parcel, parcel2, 0);
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
            public boolean isMyLocationButtonEnabled() throws RemoteException {
                boolean bl2 = false;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    this.dU.transact(11, parcel, parcel2, 0);
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
            public boolean isRotateGesturesEnabled() throws RemoteException {
                boolean bl2 = false;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    this.dU.transact(15, parcel, parcel2, 0);
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
            public boolean isScrollGesturesEnabled() throws RemoteException {
                boolean bl2 = false;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    this.dU.transact(12, parcel, parcel2, 0);
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
            public boolean isTiltGesturesEnabled() throws RemoteException {
                boolean bl2 = false;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    this.dU.transact(14, parcel, parcel2, 0);
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
            public boolean isZoomControlsEnabled() throws RemoteException {
                boolean bl2 = false;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    this.dU.transact(9, parcel, parcel2, 0);
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
            public boolean isZoomGesturesEnabled() throws RemoteException {
                boolean bl2 = false;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    this.dU.transact(13, parcel, parcel2, 0);
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
            public void setAllGesturesEnabled(boolean bl2) throws RemoteException {
                int n2 = 0;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    if (bl2) {
                        n2 = 1;
                    }
                    parcel.writeInt(n2);
                    this.dU.transact(8, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void setCompassEnabled(boolean bl2) throws RemoteException {
                int n2 = 0;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    if (bl2) {
                        n2 = 1;
                    }
                    parcel.writeInt(n2);
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
            public void setMyLocationButtonEnabled(boolean bl2) throws RemoteException {
                int n2 = 0;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    if (bl2) {
                        n2 = 1;
                    }
                    parcel.writeInt(n2);
                    this.dU.transact(3, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void setRotateGesturesEnabled(boolean bl2) throws RemoteException {
                int n2 = 0;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    if (bl2) {
                        n2 = 1;
                    }
                    parcel.writeInt(n2);
                    this.dU.transact(7, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void setScrollGesturesEnabled(boolean bl2) throws RemoteException {
                int n2 = 0;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    if (bl2) {
                        n2 = 1;
                    }
                    parcel.writeInt(n2);
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
            public void setTiltGesturesEnabled(boolean bl2) throws RemoteException {
                int n2 = 0;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    if (bl2) {
                        n2 = 1;
                    }
                    parcel.writeInt(n2);
                    this.dU.transact(6, parcel, parcel2, 0);
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
            public void setZoomControlsEnabled(boolean bl2) throws RemoteException {
                int n2 = 1;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    if (!bl2) {
                        n2 = 0;
                    }
                    parcel.writeInt(n2);
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
            public void setZoomGesturesEnabled(boolean bl2) throws RemoteException {
                int n2 = 0;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    if (bl2) {
                        n2 = 1;
                    }
                    parcel.writeInt(n2);
                    this.dU.transact(5, parcel, parcel2, 0);
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

